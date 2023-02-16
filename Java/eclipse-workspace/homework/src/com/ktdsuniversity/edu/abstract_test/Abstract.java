package com.ktdsuniversity.edu.abstract_test;

public class Abstract {
	public void test(InfoPhone info) {
		String res = "이름: " + info.getName() + ", 전화번호: " + info.getPhoneNumber();
		if(info instanceof InfoSchool) {
			res += ", 학교명: " + ((InfoSchool)info).getSchoolName();
		}
		System.out.println(res);
	}
}
