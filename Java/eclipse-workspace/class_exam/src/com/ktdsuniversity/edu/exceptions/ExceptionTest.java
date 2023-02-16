package com.ktdsuniversity.edu.exceptions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class ExceptionTest {
	static Scanner scan = new Scanner(System.in);
	public static void readFile(String path) {
		try {
			Files.readAllLines(Paths.get(path));
		} catch(IOException e) {
			System.out.println("경로를 다시 입력하세요.");
			readFile(scan.nextLine());
		}
	}
	
	public static void main(String[] args) {
		readFile("");
		
		System.out.println("숫자로 변환 시작");
		String str = "ABC";
		int num = 0;
		try {
			num = Integer.parseInt(str);
		} catch (NumberFormatException e) {
			System.out.println("숫자 변환 에러 " + e.getMessage()
			);
			e.printStackTrace();
		}

		System.out.println(str + " -> " + num + "숫자로 변환 종료");
	}
}
