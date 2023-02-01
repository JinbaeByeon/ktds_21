package com.ktdsuniversity.edu.inf;

public class Main {

	public static void calculate(Calculator calc) {
		if (calc instanceof CalculatorNormalImpl) {
			System.out.println(calc.sum(10, 20));
			System.out.println(calc.subtract(40, 3));
			System.out.println(calc.divide(40, 3));
		}

	}

	public static void main(String[] args) {
		Calculator calc = new CalculatorNormalImpl();
		Calculator calc2 = calc;
		calculate(calc);
		
		calc = null;
		calculate(calc2);
		calc = new CalculatorRandomImpl();
		calculate(calc);
	}
}
