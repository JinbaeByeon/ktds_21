package com.ktdsuniversity.edu.abs.ext;

public class Main {
	public static void main(String[] args) {
		Calculator calc = new SimpleCalculator();
		System.out.println(calc.calculate("+", 10, 40));
		System.out.println(calc.calculate("-", 10, 40));
	}
}
