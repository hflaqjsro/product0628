package javaexp.z04_recruit;

import javaexp.z02_earthstory.a.Model;

public class Recruit_Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Recruit_Controller c = new Recruit_Controller();
		
		c.registerDB();
		//개인 회원가입
		c.join(new PersonalMem("hello123","hello123pw","홍길동",
				"hello123@naver.com","010-1234-4567"), new Model());
		c.join(new PersonalMem("hello456","hello456pw","김길동",
				"hello456@naver.com","010-2345-6789"), new Model());
		c.join(new PersonalMem("hello321","hello321pw","마길동",
				"hello321@naver.com","010-1423-4237"), new Model());
		c.join(new PersonalMem("stronghaji","password123","강하지",
				"stronghaji@naver.com","010-1423-4237"), new Model());
		c.join(new PersonalMem("yuna9310","11111111","김유나",
				"yuna9310@naver.com","010-0000-0001"), new Model());
		c.join(new PersonalMem("minjuni","22222222","서민준",
				"minjuni@daum.net","010-0000-0002"), new Model());
		c.join(new PersonalMem("julee93","33333333","이주원",
				"julee93@gmail.com","010-0000-0003"), new Model());
		//개인 로그인
		c.login(new PersonalMem("stronghaji","password123"), new Model());
		c.login(new PersonalMem("hello000","8989"), new Model());
		c.login(new PersonalMem("hello123","hello123pw"), new Model());
		
		//개인 아이디 찾기
		c.findID(new PersonalMem("stronghaji@naver.com"), new Model());
		c.findID(new PersonalMem("julee@naver.com"), new Model());
		
		//개인 비밀번호 찾기
		c.findPW(new PersonalMem("stronghaji","강하지","stronghaji@naver.com"), new Model());
		c.findPW(new PersonalMem("hello123","홍길동","hello123@naver.com"), new Model());
		
		//개인 : 즉시지원
		c.applyNow(new Resume("rs000001"),new Recruit("RC001-SL"), new Model());
		//c.applyNow(new Resume("rs000003"),new Recruit("RC001-SK"), new Model());
		//c.applyNow(new Resume("rs000004"),new Recruit("RC001-LG"), new Model());
		
		/////////////////////////
		
		//기업 회원가입
		c.join(new Company("cm000001","SK","SK_HR123","sk123pw"), new Model());
		c.join(new Company("cm000002","셀트리온","CET_HR123","cet123pw"), new Model());
		c.join(new Company("cm000003","삼성전자","SS_HR123","ss123pw"), new Model());
		
		//기업 로그인
		c.login(new Company("sk123","sk123pw"), new Model());
		c.login(new Company("CET_HR123","cet123pw"), new Model());
	
		//기업 : 지원자 내역 확인
		c.showApplicants(new Recruit("RC001-SK"), new Model());
		
		//개인 : 학력별 현황 확인
		c.eduStat(new Recruit("RC001-CJ"), new Model());
		
		//개인 : 성별 현황 확인
		c.genStat(new Recruit("RC001-CJ"), new Model());
		
		//개인 : 성별 현황 확인
		c.ageStat(new Recruit("RC001-CJ"), new Model());
	}

}
