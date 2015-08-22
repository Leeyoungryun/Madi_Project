package model.domain;

public class MemberBean {
	private int memberNum;
	private String email;
	private String pw;
	private String name;
	private String phone;
	private String tendency;

	public MemberBean() { }

	public MemberBean(int memberNum, String email, String name, String phone, String tendency) {
		this.memberNum = memberNum;
		this.email = email;
		this.name = name;
		this.phone = phone;
		this.tendency = tendency;
	}

	public MemberBean(int memberNum, String email, String pw, String name,
			String phone, String tendency) {
		this.memberNum = memberNum;
		this.email = email;
		this.pw = pw;
		this.name = name;
		this.phone = phone;
		this.tendency = tendency;
	}

	public int getMemberNum() {
		return memberNum;
	}

	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getTendency() {
		return tendency;
	}

	public void setTendency(String tendency) {
		this.tendency = tendency;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MemberBean [memberNum=");
		builder.append(memberNum);
		builder.append(", email=");
		builder.append(email);
		builder.append(", pw=");
		builder.append(pw);
		builder.append(", name=");
		builder.append(name);
		builder.append(", phone=");
		builder.append(phone);
		builder.append(", tendency=");
		builder.append(tendency);
		builder.append("]");
		return builder.toString();
	}
}
