package com.ktdsuniversity.edu.goodgag.member.vo;

public class MemberVO {
	private String email;
	private String nickName;
	private String verified;
	private String password;
	private String registDate;
	private String rank;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getVerified() {
		return verified;
	}
	public void setVerified(String verified) {
		this.verified = verified;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRegistDate() {
		return registDate;
	}
	public void setRegistDate(String registDate) {
		this.registDate = registDate;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	
	@Override
	public String toString() {
		return "email : " + email + '\t'
			 + "nickName : " + nickName + '\t'
			 + "verified : " + verified + '\t'
			 + "password : " + password + '\t'
			 + "registDate : " + registDate + '\t'
			 + "rank : " + rank + '\t';
	}
	
	@Override
	public boolean equals(Object member) {
		return email.equals(((MemberVO)member).email);
	}
}
