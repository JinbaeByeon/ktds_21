package com.ktdsuniversity.edu.other;

import com.ktdsuniversity.edu.member.MemberService;

public class Main {
	
	public static void main(String[] args) {
		MemberService ms = new MemberService();
		ms.setUserName("이르음");
		String userName = ms.getUserName();
		System.out.println(userName);
		
		ms.join();
//		ms.login();
//		ms.quit();
	}

}
