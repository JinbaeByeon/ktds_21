package calculator;

public class Main {
	public static void main(String[] args) {		
		Calculator calc = new Calculator();
		int resAdd = calc.add(10, 10);
		int resSub1 = calc.subtract(10, 3);
		int resSub2 = calc.subtract(5, 10);
		int resSub3 = calc.subtract(5, 5);
		int resMul = calc.multiply(5,2);
		double resDiv = calc.divide(50, 3);
		int resRem = calc.remain(50, 3);
		
		System.out.println("resAdd = " + resAdd);
		System.out.println("resSub = " + resSub1);
		System.out.println("resSub = " + resSub2);
		System.out.println("resSub = " + resSub3);
		System.out.println("resMul = " + resMul);
		System.out.println("resDiv = " + resDiv);
		System.out.println("resRem = " + resRem);
		
	}
}
