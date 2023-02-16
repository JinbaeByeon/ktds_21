package com.ktdsuniversity.edu.inf;

public class CalculatorNormalImpl extends Caculator {
	@Override
	public int sum(int numberOne, int numberTwo) {
		return numberOne + numberTwo;
	}

	@Override
	public int subtract(int numberOne, int numberTwo) {
		return numberOne - numberTwo;
	}

	@Override
	public double divide(int numberOne, int numberTwo) {
		return (double) numberOne / numberTwo;
	}

	@Override
	public int sum2(int n1, int n2) {
		System.out.println("sum2입니다.");
		return 0;
	}
}
