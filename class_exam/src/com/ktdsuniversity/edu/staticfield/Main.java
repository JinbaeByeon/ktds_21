package com.ktdsuniversity.edu.staticfield;

public class Main {
	public static void main(String[] args) {
		StaticTest st = new StaticTest();
		int num = StaticTest.NUM;
		String str = StaticTest.STR;
		System.out.println(num);
		System.out.println(str);
		StaticTest.printHello();
		StaticTest.printHello("홍길동");
	}
}
