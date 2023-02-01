package com.ktdsuniversity.edu.abs.ext;

/**
 * 추상클래스 Calculator를 상속받아 구현한 클래스
 * 
 * @author User
 *
 */
public class SimpleCalculator extends Calculator {

	@Override
	public int sum(int a, int b) {
		// TODO Auto-generated method stub
		return a + b;
	}

	@Override
	public int subtract(int a, int b) {
		// TODO Auto-generated method stub
		return a - b;
	}

}
