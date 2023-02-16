package com.ktdsuniversity.edu.ext;

public class ExtendsTest {
	public static void print(Address address) {
		System.out.println(address);
	}
	public static void main(String[] args) {
		Address friend1 = new Friends();
		Friends friend = new Friends();
		friend.setName("aaa");
		friend.setBirthDate("2000-11-11");
		print(friend);
	}
}
