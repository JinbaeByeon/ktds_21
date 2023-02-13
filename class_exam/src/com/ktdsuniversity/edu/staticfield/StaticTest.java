package com.ktdsuniversity.edu.staticfield;

public class StaticTest {
	// 상수
	public static final int NUM = 1000;
	public static final String STR = "1234";

	// static field
	static {
		System.out.println("스태틱 필드 호출");
	}
	
	// 메소드
	public static void printHello() {
		System.out.println("Hello");
	}
	
	public static void printHello(String name) {
		System.out.println("Hello " + name);
	}
}
