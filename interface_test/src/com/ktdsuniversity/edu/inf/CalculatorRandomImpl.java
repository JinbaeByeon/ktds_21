package com.ktdsuniversity.edu.inf;

import java.util.Random;

public class CalculatorRandomImpl implements Calculator {

	@Override
	public int sum(int numberOne, int numberTwo) {
		return numberOne + numberTwo + new Random().nextInt(numberTwo);
	}

	@Override
	public int subtract(int numberOne, int numberTwo) {
		return numberOne - numberTwo - new Random().nextInt(numberTwo);
	}

	@Override
	public double divide(int numberOne, int numberTwo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
