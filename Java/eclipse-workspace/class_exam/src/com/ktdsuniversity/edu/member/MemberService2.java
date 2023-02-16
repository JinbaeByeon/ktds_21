package com.ktdsuniversity.edu.member;

public class MemberService2 extends MemberService{
	public void setUserName(String userName) {
		super.setUserName("\"" +userName+ "\"");
	}
}
