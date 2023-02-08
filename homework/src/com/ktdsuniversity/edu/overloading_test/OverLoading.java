package com.ktdsuniversity.edu.overloading_test;

public class OverLoading {

	public int sum(int a, int b) {
		return a + b;
	}

	public int sum(int a, int b, int c) {
		return a + b + c;
	}

	public double convert(int i) {
		return i;
	}

	public double convert(long l) {
		return l;
	}

	public double convert(float f) {
		return f;
	}

	public double convert(String str) {
		try {
			return Double.parseDouble(str);
		} catch (NumberFormatException e) {
			return 0.;
		}
	}
}
