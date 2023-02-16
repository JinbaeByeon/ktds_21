package com.ktdsuniversity.edu.constructor;

public class Calculator {
	private int a;
	private int b;

	public Calculator() {
		a = 10;
		b = 20;
	}

	public Calculator(int a, int b) {
		this.a = a;
		this.b = b;
	}

	public int sum() {
		return a + b;
	}
	
}
