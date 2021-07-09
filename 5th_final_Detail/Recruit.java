package javaexp.z04_recruit;

public class Recruit {
	String comName;
	int comNum;
	String noticeTitle;
	String rcNum;
	
	public Recruit(String rcNum) {
		super();
		this.rcNum = rcNum;
	}
	public String getComName() {
		return comName;
	}
	public void setComName(String comName) {
		this.comName = comName;
	}
	public int getComNum() {
		return comNum;
	}
	public void setComNum(int comNum) {
		this.comNum = comNum;
	}
	public String getNoticeTitle() {
		return noticeTitle;
	}
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}
	public String getRcNum() {
		return rcNum;
	}
	public void setRcNum(String rcNum) {
		this.rcNum = rcNum;
	}
	public Recruit(String comName, int comNum, String noticeTitle, String rcNum) {
		super();
		this.comName = comName;
		this.comNum = comNum;
		this.noticeTitle = noticeTitle;
		this.rcNum = rcNum;
	}
	public Recruit() {
		super();
		// TODO Auto-generated constructor stub
	}
}
