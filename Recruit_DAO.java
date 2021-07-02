package javaexp.z04_recruit;

import java.util.ArrayList;

public class Recruit_DAO {
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
		System.out.println("회사명 : "+recv.getComName());
		System.out.println("공고 : "+recv.getNoticeTitle());
		System.out.println("지원자 : "+recv.getpName());
		System.out.println("지원이 완료됐습니다.");
		return "지원완료";
		
	}
	
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
		System.out.println(pm.getName()+"님 가입을 축하합니다!");
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
		System.out.println(cm.getComName()+" 기업의 가입을 축하합니다!");
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
	
}
