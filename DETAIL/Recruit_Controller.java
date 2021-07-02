package javaexp.z04_recruit;

import javaexp.z02_earthstory.a.Model;

public class Recruit_Controller {
	Recruit_Service service = new Recruit_Service();
	//db등록
	public void registerDB() {
		service.registerDB();
	}
	//개인 : 회원가입
	public String join(PersonalMem pm, Model d) {
		d.addAttribute("회원가입", service.join(pm));
		return "회원가입 완료";
	}
	//개인 : 로그인
	public String login(PersonalMem pm, Model d) {
		d.addAttribute("로그인", service.login(pm));
		return "로그인 결과";
	}
	//기업 : 회원가입
		public String join(Company cm, Model d) {
			d.addAttribute("회원가입", service.join(cm));
			return "회원가입 완료";
		}
	//기업 : 로그인
		public String login(Company cm, Model d) {
			d.addAttribute("로그인", service.login(cm));
			return "로그인 결과";
		}		
	//개인 : 즉시지원
	public String applyNow(Resume rs, Recruit rc, Model d) {
		d.addAttribute("즉시지원", service.applyNow(rs, rc));
		return "지원 완료";		
	}
	//기업 : 지원내역 확인
	public String showApplicants(Recruit r, Model d) {
		d.addAttribute("지원자 확인", service.showApplicants(r));
		return "지원자 명단 목록";
	}
}
