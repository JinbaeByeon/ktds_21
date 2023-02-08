package com.ktdsuniversity.edu;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.ktdsuniversity.edu.class_test.BoardVO;
import com.ktdsuniversity.edu.class_test.VendingMachine;
import com.ktdsuniversity.edu.if_elseif_test.ControlStatement;
import com.ktdsuniversity.edu.method_test.Method;

public class Main {
	public void minToHour() {
		Scanner scan = new Scanner(System.in);
		int min = scan.nextInt();
		scan.close();
		System.out.println(min / 60 + "시간 " + min % 60 + "분");
	}

	public double stringToDouble() {
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		scan.close();
		try {
			return Double.parseDouble(str);
		} catch (NumberFormatException e) {
			return -1.9999;
		}
	}

	public double stringToDouble2() {
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		scan.close();
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

	public void LottoNumber() {
		Random rd = new Random();
		List<Integer> lotto = new ArrayList<>();
		for (int i = 0; i < 6; ++i) {
			int num = 1 + rd.nextInt(44);
			if (!lotto.contains(num)) {
				lotto.add(num);
			}
		}
	}

	public void example(int i) {
		Method method = new Method();
		BoardVO board;
		ControlStatement control = new ControlStatement();
		switch (i) {
		case 1:
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			break;
		case 6:
			break;
		case 7:
			break;
		case 8:
			break;
		case 9:
			System.out.println(method.test1(10)); // 100			
			break;
		case 10:
			System.out.println(method.test2(10)); // 10
			break;
		case 11:
			System.out.println(method.test3(10,20.5)); // 205
			break;
		case 12:
			method.test4(10,20,30); // 6000
			break;
		case 13:
			System.out.println("게시글의 정보를 표현하는 클래스 -> class_test\\BoardVO");
			break;
		case 14: case 15:
			System.out.println("클래스를 인스턴스화 하고 Setting 후 출력");
			board = new BoardVO();
			board.setNumber(0);
			board.setTime("00:00");
			board.setTitle("제목");
			board.setViews(0);
			board.setWriter("작성자");
			System.out.println(board);
			break;
		case 16:
			System.out.println("자판기 상품 표현하는 클래스 -> class_test\\VendingMachine");
			VendingMachine vm = new VendingMachine();
			break;
		case 17:
			control.test1();
			break;
		case 18:
			control.test2();
			break;
		case 19:
			control.test3();
			break;
		case 20:
			control.test4();
			break;
		case 21:
			break;
		case 22:
			break;
		case 23:
			break;
		case 24:
			break;
		case 25:
			break;
		case 26:
			break;
		case 27:
			break;
		case 28:
			break;
		case 29:
			break;
		case 30:
			break;
		case 31:
			break;
		case 32:
			break;
		case 33:
			break;
		case 34:
			System.out.println(stringToDouble2());
			break;
		case 35:
			break;
		case 36:
			minToHour();
			break;
		}
	}

	public static void main(String[] args) {
		Main ex = new Main();
		Scanner scan = new Scanner(System.in);

		while(true) {
			System.out.println("실행할 문제 번호를 입력하세요 (0: 종료)\n > ");
			int testNumber = scan.nextInt();
			scan.nextLine();
			ex.example(testNumber);
			if(testNumber==0) break;
		}
		scan.close();
	}
}
