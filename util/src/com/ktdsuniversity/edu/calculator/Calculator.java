package com.ktdsuniversity.edu.calculator;

import java.util.Scanner;

import com.ktdsuniversity.edu.exceptions.NotSupportAgeException;
import com.ktdsuniversity.edu.util.Utils;

public class Calculator {
	
	public static void checkAge(int age) {
		if(age>150) {
			throw new NotSupportAgeException("151세 이상은 입력할 수 없습니다.");
		}
	}
	public static void main(String[] args) {
		checkAge(20);
		
		try {
			checkAge(200);
		} catch (NotSupportAgeException e) {
			System.out.println(e.getMessage());
		}
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		System.out.println(Utils.toByte(str, (byte) 99));
		System.out.println(Utils.isEquals(null, str));
		Utils.toLong(str,0);
		Utils.toShort(str,(short)1);
		scan.close();
	}
}
