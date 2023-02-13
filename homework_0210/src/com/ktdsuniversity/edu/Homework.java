package com.ktdsuniversity.edu;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Homework {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		Random rd = new Random();
		System.out.println("숫자 리스트");
		for (int i = 0; i < 50; ++i) {
			list.add(rd.nextInt(100));
			System.out.print(list.get(i) + " ");
		}
		System.out.println();
		
		// 1번
		int max = Integer.MIN_VALUE;
		for (int number : list) {
			if (number > max) {
				max = number;
			}
		}
		System.out.println("최댓값 : " + max);

		// 2번
		int min = Integer.MAX_VALUE;
		for (int number : list) {
			if (number < min) {
				min = number;
			}
		}
		System.out.println("최솟값 : " + min);

		// 3번
		int sum = 0;
		for (int number : list) {
			sum += number;
		}
		int avg = sum / list.size();
		System.out.println("평균 : " + avg);
		
		if(list.contains(avg)) {
			System.out.println(avg);
		} else {
			System.out.println(0);			
		}
	}
}
