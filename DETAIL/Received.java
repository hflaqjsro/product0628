package javaexp.z04_recruit;

public class Received {
	
	String pId;
	String pName;
	String rsNum;
	int comNum;
	String comName;
	String rcNum;
	String noticeTitle;
	
	
	public String getNoticeTitle() {
		return noticeTitle;
	}


	public String getpName() {
		return pName;
	}


	public void setpName(String pName) {
		this.pName = pName;
	}


	public Received(String pId, String pName, String rsNum, int comNum, String comName, String rcNum,
			String noticeTitle) {
		super();
		this.pId = pId;
		this.pName = pName;
		this.rsNum = rsNum;
		this.comNum = comNum;
		this.comName = comName;
		this.rcNum = rcNum;
		this.noticeTitle = noticeTitle;
	}


	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}


	public Received(String pId, String rsNum, int comNum, String comName, String rcNum, String noticeTitle) {
		super();
		this.pId = pId;
		this.rsNum = rsNum;
		this.comNum = comNum;
		this.comName = comName;
		this.rcNum = rcNum;
		this.noticeTitle = noticeTitle;
	}


	public Received(String pId, String rsNum, int comNum, String rcNum) {
		super();
		this.pId = pId;
		this.rsNum = rsNum;
		this.comNum = comNum;
		this.rcNum = rcNum;
	}
	
	
	public String getComName() {
		return comName;
	}


	public void setComName(String comName) {
		this.comName = comName;
	}


	public Received(String pId, String rsNum, int comNum, String comName, String rcNum) {
		super();
		this.pId = pId;
		this.rsNum = rsNum;
		this.comNum = comNum;
		this.comName = comName;
		this.rcNum = rcNum;
	}


	public Received() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Received(String rsNum, String rcNum) {
		super();
		this.rsNum = rsNum;
		this.rcNum = rcNum;
	}
	public String getRsNum() {
		return rsNum;
	}
	public void setRsNum(String rsNum) {
		this.rsNum = rsNum;
	}
	public String getRcNum() {
		return rcNum;
	}
	public void setRcNum(String rcNum) {
		this.rcNum = rcNum;
	}
	public String getpId() {
		return pId;
	}
	public void setpId(String pId) {
		this.pId = pId;
	}
	public int getComNum() {
		return comNum;
	}
	public void setComNum(int comNum) {
		this.comNum = comNum;
	}
	
}
