package javaexp.z04_recruit;

public class PersonalMem {
	String id;
	String pw;
	String name;
	String mail;
	String HP;
	public PersonalMem() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PersonalMem(String mail) {
		super();
		this.mail = mail;
	}
	public PersonalMem(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	}
	public PersonalMem(String id, String name, String mail) {
		super();
		this.id = id;
		this.name = name;
		this.mail = mail;
	}
	public PersonalMem(String id, String pw, String name, String mail, String hP) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.mail = mail;
		HP = hP;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getHP() {
		return HP;
	}
	public void setHP(String hP) {
		HP = hP;
	}

	
}
