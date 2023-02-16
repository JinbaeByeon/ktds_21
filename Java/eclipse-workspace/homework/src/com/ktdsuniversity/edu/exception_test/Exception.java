package com.ktdsuniversity.edu.exception_test;

import java.util.Scanner;

public class Exception {
	public int stringToInt(Scanner scan) {
		System.out.println("정수를 입력하세요");
		String str = scan.nextLine();
		try {
			return Integer.parseInt(str);
		} catch(NumberFormatException e) {
			return -1;
		}
	}
	public double stringToDouble(Scanner scan) {
		System.out.println("실수를 입력하세요");
		String str = scan.nextLine();
		try {
			return Double.parseDouble(str);
		} catch (NumberFormatException e) {
			return -1.9999;
		}
	}

	public double stringToDouble2(Scanner scan) {
		System.out.println("실수를 입력하세요");
		String str = scan.nextLine();
		int num = 0;
		try {
			num = (int) (Double.parseDouble(str) * 1000);
		} catch (NumberFormatException e) {
			return -1.9999;
		}
		if (num % 10 >= 5) {
			++num;
		}
		return (double) num / 1000;
	}
}
