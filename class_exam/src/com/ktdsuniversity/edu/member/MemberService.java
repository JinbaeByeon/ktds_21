package com.ktdsuniversity.edu.member;

public class MemberService {
	private String userName;
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setUserName(String lastName, String firstName) {
		this.userName = firstName + lastName;
	}
	
	public void join() {
		System.out.println("회원가입");
	}
	
	private void login() {
		System.out.println("로그인");
	}
	
	void quit() {
		System.out.println("탈퇴");
	}
}
