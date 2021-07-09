package javaexp.z04_recruit;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DB.DBConnection;

public class Recruit_DAO {
	Connection conn = null;
	PreparedStatement pstm = null;
	ResultSet rs = null;
	static ArrayList<Resume> resumeList = new ArrayList<Resume>();
	static ArrayList<PersonalMem> memList = new ArrayList<PersonalMem>();
	static ArrayList<Company> comList = new ArrayList<Company>();
	static ArrayList<Recruit> recList = new ArrayList<Recruit>();
	static ArrayList<Received> receivedList = new ArrayList<Received>();
	
	public void registerDB() {
		resumeList.add(new Resume("hello123","홍길동","RS000001"));
		resumeList.add(new Resume("hello123","홍길동","RS000002"));
		resumeList.add(new Resume("hello456","김길동","RS000003"));
		resumeList.add(new Resume("hello321","마길동","RS000004"));
		resumeList.add(new Resume("hello654","이길동","RS000005"));
		resumeList.add(new Resume("hello543","신길동","RS000006"));
		recList.add(new Recruit("SK",1234567,"SK텔레콤 상반기 채용 공고","RC001-SK"));
		recList.add(new Recruit("SK",7654321,"KT 상반기 채용 공고","RC001-KT"));
		recList.add(new Recruit("SK",2345678,"LG생건 상반기 채용 공고","RC001-LG"));
	}
	/*
	//즉시지원
	public String applyNow(Resume rs, Recruit rc) {
		Received recv = new Received();
		for(Recruit x: recList) {
			if(x.getRcNum().equals(rc.getRcNum())) {
				recv.setComNum(x.getComNum());
				recv.setComName(x.getComName());
				recv.setNoticeTitle(x.getNoticeTitle());
			}
		}
		for(Resume x : resumeList) {
			if(x.getRsNum().equals(rs.getRsNum())) {
				recv.setpId(x.getId());
				recv.setpName(x.getpName());
			}
		}
		recv.setRsNum(rs.getRsNum());
		recv.setRcNum(rc.getRcNum());
		receivedList.add(recv);	
		
		System.out.println("========================");
		System.out.println("[ 회사명 : "+recv.getComName()+" ]");
		System.out.println("[ 공고 : "+recv.getNoticeTitle()+" ]");
		System.out.println("[ 지원자 : "+recv.getpName()+" ]");
		System.out.println("[ 지원이 완료됐습니다 ]");
		return "지원완료";
		
	}*/
	
	//지원자 확인
	public ArrayList<Received> showApplicants(Recruit r){
		ArrayList<Received> rlist = new ArrayList<Received>();
		for(Received rcv : receivedList) {
			if(rcv.getRcNum().indexOf(r.getRcNum())>=0) {
				rlist.add(rcv);
			}
		}
		System.out.println("[지원자]\t[이력서]");
		for(Received rc : rlist) {
			System.out.println("==========================");
			System.out.print(rc.getpName()+"\t");
			System.out.println(rc.getRsNum());
		}
		return rlist;
	}
	
	
	
	//개인 : 회원가입
	public String join(PersonalMem pm) {
		memList.add(pm);
		System.out.println("=========#회원가입 결과#========");
		System.out.println("[ "+pm.getName()+"님 가입을 축하합니다 ]");
		return "개인회원 가입 완료"; 
	}
	
	//개인 : 로그인
	public boolean login(PersonalMem pm) {
		boolean isMem = false;
		for(PersonalMem x : memList) {
			if(x.getId().equals(pm.getId())&&x.getPw().equals(pm.getPw())) {
				isMem = true;
				break;
			}
		}
		return isMem;
	}
	//기업 : 회원가입
	public String join(Company cm) {
		comList.add(cm);
		System.out.println("=========#회원가입 결과#========");
		System.out.println("[ "+cm.getComName()+" 기업의 가입을 축하합니다 ]");
		return "기업회원 가입 완료";
	}
	//기업 : 로그인
		public boolean login(Company cm) {
			boolean isMem = false;
			for(Company x : comList) {
				if(x.getComId().equals(cm.getComId())&&x.getComPw().equals(cm.getComPw())) {
					isMem = true;
					break;
				}
			}
			return isMem;
		}
	
		
	//개인 : 아이디 찾기
		public String findID(PersonalMem pm) {
			String myID = null;
			for(PersonalMem x : memList) {
				if(x.getMail().equals(pm.getMail())) {
					myID = x.getId();
					break;
				}
			}
			return myID;
		}
		
	//개인 : 비밀번호 찾기
		public String findPW(PersonalMem pm) {
			String tmpPW = "";
			String inputID = pm.getId();
			String inputName = pm.getName();
			String inputMail = pm.getMail();
			for(PersonalMem x : memList) {
				if(x.getId().equals(inputID)&&x.getName().equals(inputName)
						&&x.getMail().equals(inputMail)) {
					//임시 비밀번호 부여받음
					char[] tmp = new char[10];
					for(int i=0;i<tmp.length;i++) {
						int num = (int)(Math.random()*62+48);
						if(num>=58&&num<84) {
							num += 7;
						}else if(num>=85&&num<110) {
							num += 13;
						}
						tmpPW += (char)num;
					}	
					break;
				}
			}
			return tmpPW;
		}
		
	//공고통계(학력)-count
		public ArrayList<Statistics> eduStat(Recruit rc) {
			ArrayList<Statistics> stList = new ArrayList<Statistics>();
			Connection conn = null;
			PreparedStatement pstm = null;
			ResultSet rs = null;
			String rcNum = rc.getRcNum();
			try {
				String query = "SELECT ESTR, count(a.rsnum)\r\n"
						+ "FROM received a, (SELECT rsnum, education FROM resume) b, education c\r\n"
						+ "WHERE a.rcNum="+"'"+rcNum+"'"+" AND a.rsnum=b.rsnum AND b.education=c.enum\r\n"
						+ "GROUP BY estr";
				conn = DBConnection.getConnection();
				pstm = conn.prepareStatement(query);
				rs = pstm.executeQuery();

				while(rs.next()) {
					stList.add(new Statistics(rs.getString("estr"), rs.getInt("count(a.rsnum)")));
				}
			} catch (SQLException se) {
				System.out.println("SELECT문에서 예외 발생");
				se.printStackTrace();
			} finally {
				try {
					if (rs!=null) rs.close();
					if (pstm!=null) pstm.close();
					if(conn!=null) conn.close();
				} catch (Exception e) {
					throw new RuntimeException(e.getMessage());
				}
			}
			return stList;
		}
		
	
		//공고통계(성별)-count
				public ArrayList<Statistics> genStat(Recruit rc) {
					ArrayList<Statistics> stList = new ArrayList<Statistics>();
					Connection conn = null;
					PreparedStatement pstm = null;
					ResultSet rs = null;
					String rcNum = rc.getRcNum();
					try {
						String query = "SELECT decode(c.gender, 1, '남자','여자'),"
								+ " count(a.rsnum) AS \"인원\"\r\n"
								+ "FROM received a, (SELECT rsnum, pnum FROM resume) b,"
								+ " (SELECT pnum, gender FROM personal) c\r\n"
								+ "WHERE a.rcnum="+"'"+rcNum+"'"+" AND a.rsnum=b.rsnum "
										+ "AND b.pnum=c.pnum\r\n"
								+ "GROUP BY decode(c.gender, 1, '남자','여자')";
						
						conn = DBConnection.getConnection();
						pstm = conn.prepareStatement(query);
						rs = pstm.executeQuery();

						while(rs.next()) {
							stList.add(new Statistics(rs.getString(1), rs.getInt(2)));
						}
					} catch (SQLException se) {
						System.out.println("SELECT문에서 예외 발생");
						se.printStackTrace();
					} finally {
						try {
							if (rs!=null) rs.close();
							if (pstm!=null) pstm.close();
							if(conn!=null) conn.close();
						} catch (Exception e) {
							throw new RuntimeException(e.getMessage());
						}
					}
					return stList;
				}	
	//공고통계(연령별) - avg
				public int ageStat(Recruit rc) {
					int avgAge =0;
					Connection conn = null;
					PreparedStatement pstm = null;
					ResultSet rs = null;
					String rcNum = rc.getRcNum();
					try {
						String query = "SELECT  avg(to_char(sysdate, 'YYYY')- TO_CHAR(c.birth,'YYYY'))\r\n"
								+ "FROM received a, (SELECT rsnum, pnum FROM resume) b, "
								+ "(SELECT pnum, birth FROM personal) c\r\n"
								+ "WHERE rcnum="+"'"+rcNum+"'"+" AND a.rsnum=b.rsnum AND b.pnum = c.pnum";
						
						conn = DBConnection.getConnection();
						pstm = conn.prepareStatement(query);
						rs = pstm.executeQuery();

						if(rs.next()) {
							avgAge = rs.getInt(1);
						}
					} catch (SQLException se) {
						System.out.println("SELECT문에서 예외 발생");
						se.printStackTrace();
					} finally {
						try {
							if (rs!=null) rs.close();
							if (pstm!=null) pstm.close();
							if(conn!=null) conn.close();
						} catch (Exception e) {
							throw new RuntimeException(e.getMessage());
						}
					}
					return avgAge;
				}
		
	//이력서 즉시지원 : 다운로드
		public boolean applyNow(Recruit rc, Resume rs) {
			String rcNum = rc.getRcNum().replace("-", "_");
			String myRs = rs.getRsNum()+".txt";
			boolean isApplied = false;
			
			File resume = new File(myRs);
			File sent = new File(rcNum+"/"+myRs);
			String rsPath = "C:\\javaexp\\workspace2\\javaexp\\"
					+ "src\\main\\java\\javaexp\\z04_recruit\\"+myRs;
			String sentPath = "C:\\javaexp\\workspace2\\javaexp\\"+rcNum+"\\"+myRs;
			Path org = Paths.get(rsPath);
			Path cpy = Paths.get(sentPath);
			try {
				Files.copy(org, cpy);
				isApplied = true;
			} catch (FileAlreadyExistsException e) {
				isApplied=false;
			}catch (IOException e) {
				e.printStackTrace();
			}			
			return isApplied;
		}
}
