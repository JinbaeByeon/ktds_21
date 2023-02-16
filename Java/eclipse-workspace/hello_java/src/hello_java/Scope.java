package hello_java;

import java.util.Scanner;

/**
 * 변수 범위 학습한 파일
 * @author User
 * @since 23/01/15
 * @version 1.9
 *
 */
public class Scope {

	/**
	 * 무언가를 입력받을 수 있는 변수
	 */
	static Scanner scanner = new Scanner(System.in);
	
	/**
	 * 
	 * @param args : 입력받는 문자열
	 */
	public static void main(String[] args) {
		System.out.println("이름을 입력하세요. ");
		System.out.println("나이를 입력하세요. ");
		// nextLine()은 문자열을 입력받을 수 있다.
		String name = scanner.nextLine();
		// nextInt()는 숫자를 입력받을 수 있다.
		int age = scanner.nextInt();
		/*
		 * 문자열과 변수를 이어붙일 때에는 + 연산 사용
		 * 문자열과 숫자를 이어붙이면 문자열이 됨
		 */
		System.out.println("이름은 " + name + "입니다.");
		System.out.println("나이는 " + age + "세 입니다.");
	}
}
