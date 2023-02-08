package com.ktdsuniversity.edu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ktdsuniversity.edu.abstract_test.Abstract;
import com.ktdsuniversity.edu.abstract_test.InfoPhone;
import com.ktdsuniversity.edu.abstract_test.InfoSchool;
import com.ktdsuniversity.edu.class_test.BoardVO;
import com.ktdsuniversity.edu.class_test.VendingMachine;
import com.ktdsuniversity.edu.if_elseif_test.ControlStatement;
import com.ktdsuniversity.edu.interface_test.BionicUnit;
import com.ktdsuniversity.edu.interface_test.FireBat;
import com.ktdsuniversity.edu.interface_test.Ghost;
import com.ktdsuniversity.edu.interface_test.Marin;
import com.ktdsuniversity.edu.interface_test.Medic;
import com.ktdsuniversity.edu.interface_test.Unit;
import com.ktdsuniversity.edu.loop_test.Loop;
import com.ktdsuniversity.edu.method_test.Method;
import com.ktdsuniversity.edu.parking_lot.ParkingLot;
import com.ktdsuniversity.edu.exception_test.Exception;

public class Main {
	public void minToHour() {
		Scanner scan = new Scanner(System.in);
		int min = scan.nextInt();
		scan.close();
		System.out.println(min / 60 + "시간 " + min % 60 + "분");
	}

	public void example(int i, Scanner scan) {
		Method method = new Method();
		BoardVO board;
		ControlStatement control = new ControlStatement();
		Loop loop = new Loop();
		InfoPhone info;
		Exception excpt = new Exception();
		ParkingLot pl = new ParkingLot();
		switch (i) {
		case 1:
			String[] a = { "1", "2", "3", "4" };
			System.out.println(a);
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
			System.out.println(method.test3(10, 20.5)); // 205
			break;
		case 12:
			method.test4(10, 20, 30); // 6000
			break;
		case 13:
			System.out.println("게시글의 정보를 표현하는 클래스 -> class_test\\BoardVO");
			break;
		case 14:
		case 15:
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
			loop.test1();
			break;
		case 22:
			loop.test2(scan);
			break;
		case 23:
			loop.test3();
			break;
		case 24:
			System.out.println("Unit, BionicUnit 인터페이스 구현 (상속)");
			break;
		case 25:
			System.out.println("마린, 메딕, 파이어뱃, 고스트 클래스 구현");
			break;
		case 26:
			List<Unit> listUnit = new ArrayList<>();
			listUnit.add(new Marin());
			listUnit.add(new FireBat());
			listUnit.add(new Medic());
			listUnit.add(new Ghost());
			listUnit.forEach(unit -> {
				unit.move();
				unit.stop();
				unit.hold();
				unit.patrol();
				if (unit instanceof BionicUnit) {
					((BionicUnit) unit).shot();
				}
			});
			break;
		case 27:
			System.out.println("OverLoading\\sum -> 오버로딩 메소드 2개 생성");
			break;
		case 28:
			System.out.println("OverLoading\\convert -> 오버로딩 메소드 4개 생성");
			break;
		case 29:
		case 30:
			info = new InfoSchool("aaa", "010-0000-0000", "ktdsUniversity");
			Abstract abs = new Abstract();
			abs.test(info);
			break;
		case 31:
			System.out.println("정해진 메소드가 필요한 상속 관계의 객체들이 있을 경우 인터페이스");
			break;
		case 32:
			System.out.println(excpt.stringToInt(scan));
			break;
		case 33:
			System.out.println(excpt.stringToDouble(scan));
			break;
		case 34:
			System.out.println(excpt.stringToDouble2(scan));
			break;
		case 35:
			pl.proceed();
			break;
		case 36:
			minToHour();
			break;
		}
	}

	public static void main(String[] args) {
		Main ex = new Main();
		Scanner scan = new Scanner(System.in);

		while (true) {
			System.out.println("실행할 문제 번호를 입력하세요 (0: 종료)\n > ");
			int testNumber = scan.nextInt();
			scan.nextLine();
			ex.example(testNumber, scan);
			if (testNumber == 0)
				break;
		}
		scan.close();
	}
}
