package com.ktdsuniversity.edu.member;

public class Main {
	
	public static void main(String[] args) {
		MemberService ms = new MemberService();
		ms.setUserName("aaa");
		String userName = ms.getUserName();
		System.out.println(userName);
		
		ms.join();
//		ms.login();
		ms.quit();
	}

}
