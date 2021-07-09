package javaexp.z04_recruit;

import javaexp.z02_earthstory.a.Model;

public class Recruit_Controller {
	Recruit_Service service = new Recruit_Service();
	//db등록
	public void registerDB() {
		service.registerDB();
	}
	
	
	//개인 : 로그인
		public String login(PersonalMem pm, Model d) {
			d.addAttribute("로그인", service.login(pm));
			return "로그인 결과";
		}
	//개인 : 회원가입
	public String join(PersonalMem pm, Model d) {
		d.addAttribute("회원가입", service.join(pm));
		return "회원가입 완료";
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
	//개인 : 아이디 찾기
		public String findID(PersonalMem pm, Model d) {
			d.addAttribute("아이디 찾기", service.findID(pm));
			return "아이디 찾기 결과";
		}
	//개인 : 비밀번호 찾기
		public String findPW(PersonalMem pm, Model d) {
			d.addAttribute("비밀번호 찾기", service.findPW(pm));
			return "비밀번호 찾기 결과";
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
	
	//개인 : 학력별 통계
	public String eduStat(Recruit rc, Model d) {
		d.addAttribute("학력별 지원현황통계", service.eduStat(rc));
		return "학력별 지원현황";
	}
	
	//개인 : 성별 통계
	public String genStat(Recruit rc, Model d) {
		d.addAttribute("성별 지원현황통계", service.genStat(rc));
		return "성별 지원현황";
	}
	
	//개인 : 연령 평균 통계
	public String ageStat(Recruit rc, Model d) {
		d.addAttribute("연령 평균", service.ageStat(rc));
		return "지원 연령 현황";
	}
}
