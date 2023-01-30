package access;

public class Public {
	private int number1;
	private int number2;

	public void add() {
		int result = number1 + number2;
		System.out.println(result);
	}

	public void setNumbers(int number1, int number2) {
		this.number1 = number1;
		this.number2 = number2;
	}

	public void setNumber1(int number) {
		if(number <100) {
			number1 = number;		
		}
	}

	public void setNumber2(int number) {
		number2 = number;
	}

	public int getNumber1() {
		return number1;
	}

	public int getNumber2() {
		return number2;
	}

	public int[] getNumbers() {
		int[] res = { number1, number2 };
		return res;
	}

	public void f(int a, int b) {
		number1 = 1;
		number2 = 1;
	}

	public void f(int[] n) {
		number1 = 2;
		number2 = 2;
	}
}
