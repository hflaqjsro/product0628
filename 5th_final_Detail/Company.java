package javaexp.z04_recruit;

public class Company {
	String comNum;
	String comName;
	String comId;
	String comPw;
	public Company(String comNum, String comName, String comId, String comPw) {
		super();
		this.comNum = comNum;
		this.comName = comName;
		this.comId = comId;
		this.comPw = comPw;
	}
	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Company(String comId, String comPw) {
		super();
		this.comId = comId;
		this.comPw = comPw;
	}
	public String getComNum() {
		return comNum;
	}
	public void setComNum(String comNum) {
		this.comNum = comNum;
	}
	public String getComName() {
		return comName;
	}
	public void setComName(String comName) {
		this.comName = comName;
	}
	public String getComId() {
		return comId;
	}
	public void setComId(String comId) {
		this.comId = comId;
	}
	public String getComPw() {
		return comPw;
	}
	public void setComPw(String comPw) {
		this.comPw = comPw;
	}
	
}
