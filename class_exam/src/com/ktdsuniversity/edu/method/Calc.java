package com.ktdsuniversity.edu.method;

public class Calc {
	public int sum(int a, int b) {
		System.out.println("sum - int,int");
		return a + b;
	}

	public long sum(long a, long b) {
		System.out.println("sum - long,long");
		return a + b;
	}

	public long sum(long a, int b) {
		System.out.println("sum - long,int");
		return a + b;
	}

	public long sum(int a, long b) {
		System.out.println("sum - int,long");
		return a + b;
	}

	public int sum(int a, int b, int c) {
		System.out.println("sum - int,int,int");
		return a + b + c;
	}

	public long sum(int a, int b, long c) {
		System.out.println("sum - int,int,long");
		return a + b + c;
	}

	public long sum(int a, long b, int c) {
		System.out.println("sum - int,long,int");
		return a + b + c;
	}
}
