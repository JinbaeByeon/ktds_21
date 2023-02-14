package com.ktdsuniversity.edu.exceptions;

public class NumberFormatExceptionTest {

	public static boolean isInt(String str) {
		if (str == null) {
			return false;
		}
		return str.matches("^[1-9]+$");
	}

	public static boolean isDouble(String str) {
		if(str == null) {
			return false;
		}
		return str.matches("^[1-9]+$.?");
	}

	public static void main(String[] args) {
		String str = "123";
		if (isInt(str)) {
			System.out.println(Integer.parseInt(str));
		}
		
		try {
			Integer.parseInt("adfa");
		}
		catch(NumberFormatException e) {
			
		}
		System.out.println(isDouble("123.45"));

	}
}
