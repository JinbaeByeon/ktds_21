package com.ktdsuniversity.edu.constructor;

public class Main {
	
	public static void main(String[] args) {
		//"(ΘωΘ)y\n((σεσΨ)ρ"
//		Calculator calc = new Calculator();
//		System.out.println(calc);
//		System.out.println(calc.sum());
//		Calculator calc2 = calc;
//		calc = new Calculator(5,6);
//		System.out.println(calc);
//		System.out.println(calc2);
//		System.out.println(calc.sum());
		
		Doctor doctor1 = new Doctor("최신컴","펜");
		System.out.println(doctor1.examination());
		// 출력 >> 의사가 최신컴과 펜으로 진찰합니다.
		
	}
}
