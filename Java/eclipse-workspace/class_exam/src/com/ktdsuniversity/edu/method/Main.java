package com.ktdsuniversity.edu.method;

public class Main {
	public static void main(String[] args) {
		Calc calc = new Calc();
		calc.sum(0, 0);
		calc.sum(0, 0L);
		calc.sum(0L, 0L);
		calc.sum(0, 0, 0);
		calc.sum(0, 0, 0L);
		calc.sum(0, 0, 0);
		
		Welcome wc = new Welcome();
		System.out.println(wc.greeting());
		System.out.println(wc.greeting("이름"));
		System.out.println(wc.greeting("이름","안녕"));
		System.out.println(wc.greeting("안녕하세여","a","b","c","d","e"));
		
		System.out.println(wc.greetings("hi",new String[] {"a","b","c"}));
	}
}
