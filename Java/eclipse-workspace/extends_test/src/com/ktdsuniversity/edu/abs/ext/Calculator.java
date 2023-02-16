package com.ktdsuniversity.edu.abs.ext;

public abstract class Calculator {
	public int calculate(String calcType, int a, int b) {
		if (calcType.equals("+")) {
			return sum(a, b);
		} else if (calcType.equals("-")) {
			return subtract(a, b);
		}
		return 0;
	}

	protected abstract int sum(int a, int b);

	protected abstract int subtract(int a, int b);

}
