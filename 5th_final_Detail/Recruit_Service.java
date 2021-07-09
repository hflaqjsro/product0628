package javaexp.z04_recruit;

import java.util.ArrayList;

public class Recruit_Service {
	Recruit_DAO dao = new Recruit_DAO();
	//DB등록
	public void registerDB() {
		dao.registerDB();
	}
	
	//개인 : 회원가입
	public String join(PersonalMem pm) {
		return dao.join(pm);
	}
	
	//개인 : 로그인
	public String login(PersonalMem pm) {
		boolean isMem = dao.login(pm);
		if(isMem==true) {
			System.out.println("=========#로그인 결과#========");
			System.out.println("[ "+pm.getId()+"님이 로그인했습니다 ]");
			return "로그인 성공";
		} else {
			System.out.println("=========#로그인 결과#========");
			System.out.println("[ 아이디/비밀번호가 다릅니다 ]");
			return "로그인 실패";
		}	
	}
	//기업 : 회원가입
		public String join(Company cm) {
			return dao.join(cm);
		}
	//기업 : 로그인	
		public String login(Company cm) {
			boolean isMem = dao.login(cm);
			if(isMem==true) {
				System.out.println("=========#로그인 결과#========");
				System.out.println("[ "+cm.getComId()+"님(기업)이 로그인했습니다 ]");
				return "로그인 성공";
			} else {
				System.out.println("=========#로그인 결과#========");
				System.out.println("[ 아이디/비밀번호가 다릅니다 ]");
				return "로그인 실패";
			}	
		}
		
	//개인 : 아이디 찾기
		public String findID(PersonalMem pm) {
			String myID = dao.findID(pm);
			if(myID==null) {
				System.out.println("=========#아이디 찾기 결과#========");
				System.out.println("[ 해당 메일이 존재하지 않습니다 ]");
				return "정보 없음";
			}else {
				System.out.println("=========#아이디 찾기 결과#========");
				System.out.println("[ 회원님의 아이디는 "+myID+" 입니다 ]");
				return myID;
			}
		}
	//개인 : 비밀번호 찾기
		public String findPW(PersonalMem pm) {
			String tmpPW = dao.findPW(pm);
			if(tmpPW=="") {
				System.out.println("=========#비밀번호 찾기 결과#========");
				System.out.println("[ 입력한 정보를 다시 확인하세요 ]");
				return "정보 없음";
			}else {
				System.out.println("=========#비밀번호 찾기 결과#========");
				System.out.println("[ 임시비밀번호가 생성되었습니다 : "+tmpPW+" ]");
				return tmpPW;
			}
		}
	//개인 : 즉시지원
		public String applyNow(Resume rs, Recruit rc) {
			System.out.println("=========#지원 결과#========");
			if(dao.applyNow(rc, rs)) {
				System.out.println("[ 지원이 완료되었습니다 ]");
				return "지원 완료";
			}else {
				System.out.println("[ 이미 지원했습니다 ]");
				return "지원 불가";
			}
		}
	
	//기업 : 지원자 내역 확인
		public ArrayList<Received> showApplicants(Recruit r){
			return dao.showApplicants(r);
		}
		
		
	//개인 : 학력별 통계 확인
		public ArrayList<Statistics> eduStat(Recruit rc) {
			ArrayList<Statistics> stList = dao.eduStat(rc);
			System.out.println("학력		인원");
			System.out.println("==================");
			for(Statistics x : stList) {
				System.out.print(x.getCategory()+"\t");
				System.out.println(x.getResult());
			}
			return stList;
		}
		
	//개인 : 성별 통계 확인
		public ArrayList<Statistics> genStat(Recruit rc){
			ArrayList<Statistics> stList = dao.genStat(rc);
			System.out.println("성별	인원");
			System.out.println("==========");
			for(Statistics x : stList) {
				System.out.print(x.getCategory()+"\t");
				System.out.println(x.getResult());
			}
			return stList;
		}
	//개인 : 평균연 통계 확인
		public int ageStat(Recruit rc) {
			int avgAge = dao.ageStat(rc);
			System.out.println("==========");
			System.out.println("지원자 평균연령 : "+avgAge);
			return avgAge;
		}
}
