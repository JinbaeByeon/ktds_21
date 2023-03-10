package calculator;

/**
 * 사칙연산 클래스
 * 
 * @author User
 *
 */
public class Calculator {

	// 더하기
	public int add(int numberOne, int numberTwo) {
		
		return numberOne + numberTwo;
	}

	// 빼기
	public int subtract(int n1, int n2) {
		int res = n1 - n2;
		if (n2 > n1) {
			res = -res;
		}
		return res;
//		return n1 > n2 ? n1 - n2 : n2 - n1;
	}

	// 곱하기
	public int multiply(int numberOne, int numberTwo) {
		return numberOne * numberTwo;
	}

	// 나누기
	public double divide(int numberOne, int numberTwo) {
		return (double) numberOne / numberTwo;
	}

	// 나머지 구하기
	public int remain(int numberOne, int numberTwo) {
		return numberOne % numberTwo;
	}
}
