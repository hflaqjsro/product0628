package javaexp.z04_recruit;

public class Resume {
	String id;
	String pName;
	String rsNum;
	public Resume() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Resume(String rsNum) {
		super();
		this.rsNum = rsNum;
	}

	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public Resume(String id, String pName, String rsNum) {
		super();
		this.id = id;
		this.pName = pName;
		this.rsNum = rsNum;
	}
	public Resume(String id, String rsNum) {
		super();
		this.id = id;
		this.rsNum = rsNum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRsNum() {
		return rsNum;
	}
	public void setRsNum(String rsNum) {
		this.rsNum = rsNum;
	}
	
}
