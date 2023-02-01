package com.ktdsuniversity.edu.vo;

public class MemberVO extends AbstractVO {
	
	private String id;
	private String password;
	
	public String getId() {
		return id;
	}
	public MemberVO setId(String id) {
		this.id = id;
		return this;
	}
	public String getPassword() {
		return password;
	}
	public MemberVO setPassword(String password) {
		this.password = password;
		return this;
	}
	@Override
	public String toString() {
		return "id: " + id + ", pwd: " + password + "\n" + super.toString();
	}
}
