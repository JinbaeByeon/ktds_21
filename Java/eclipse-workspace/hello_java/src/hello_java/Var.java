package hello_java;

public class Var {
	public static void main(String[] args) {
		long x=8999_999_999_999_999_999L;
		int y=5;
		int z=3;
		int a = (int)x+z;
		int b = y-z;
		
		System.out.println("철수는 사과를"+ x+ "개 가지고 있다. 영희는 사과를"+ y+ "개를 가지고  있다.");
		System.out.println("철수가 영희에게 사과를"+ z+ "개를 빌렸다.");
		
		System.out.println("철수는 사과 " + a +"개를 가지고 있다.");
		System.out.println("영희는 사과 " + b +"개를 가지고 있다.");		
	}
}
