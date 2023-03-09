package com.ktdsuniversity.edu.naver.movie.utils;

import java.util.Scanner;

public class Utils {
	static Scanner scan;
	static {
		scan = new Scanner(System.in);
	}
	public static int getNextInt(String printMenu) {
		System.out.println(printMenu);
		int menu =scan.nextInt();
		scan.nextLine();
		return menu;
	}
	public static String getNextLine(String printMenu) {
		System.out.println(printMenu);
		String menu = scan.nextLine();
		return menu;
	}
	
}
