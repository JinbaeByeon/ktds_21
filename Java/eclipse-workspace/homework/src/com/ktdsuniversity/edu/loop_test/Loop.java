package com.ktdsuniversity.edu.loop_test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Loop {
	public void test1() {
		List<Integer> lotto = new ArrayList<>();
		Random rd = new Random();
		while (lotto.size() < 6) {
			int num = 1 + rd.nextInt(45);
			if(!lotto.contains(num)) {
				lotto.add(num);
			}
		}
		lotto.forEach(n -> System.out.println(n + " "));
	}
	
	public void test2(Scanner scan) {
		int num = 87;
		System.out.println("Up & Down 게임, 숫자를 맞춰보세요");
		while(true) {
			int numInput = scan.nextInt();
			scan.nextLine();
			
			if(numInput < num) {
				System.out.println("UP");
			} else if(numInput > num) {
				System.out.println("DOWN");
			}else {
				System.out.println("정답입니다.");
				break;
			}
		}
	}
	
	public void test3() {
		GradeManager gm = new GradeManager();
		gm.setStudents(5);
		gm.setGrade();
		gm.printAll();
	}
}
