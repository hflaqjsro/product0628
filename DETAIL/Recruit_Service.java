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
			System.out.println(pm.getId()+"님이 로그인했습니다.");
			return "로그인 성공";
		} else {
			System.out.println("=========#로그인 결과#========");
			System.out.println("아이디/비밀번호가 다릅니다.");
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
				System.out.println(cm.getComId()+"님[기업]이 로그인했습니다.");
				return "로그인 성공";
			} else {
				System.out.println("=========#로그인 결과#========");
				System.out.println("아이디/비밀번호가 다릅니다.");
				return "로그인 실패";
			}	
		}
		
	
	//개인 : 즉시지원
	public String applyNow(Resume rs, Recruit rc) {
		return dao.applyNow(rs, rc);	
	}
	
	//기업 : 지원자 내역 확인
	public ArrayList<Received> showApplicants(Recruit r){
		return dao.showApplicants(r);
	}
}
