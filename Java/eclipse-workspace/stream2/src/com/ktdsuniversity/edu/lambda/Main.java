package com.ktdsuniversity.edu.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static void printSumResult(int a, int b, Computable computable) {
		int sumRes = computable.add(a, b);
		System.out.println(sumRes);
	}

	public static void print(String str, Printable printable) {
		printable.print(str);
	}

	public static void main(String[] args) {
		printSumResult(10, 20, new Computable() {

			@Override
			public int add(int numberOne, int numberTwo) {
				return numberOne + numberTwo;
			}

		});
		printSumResult(10, 20, (a, b) -> a + b);
		printSumResult(10, 20, (a, b) -> {
			return a + b;
		});
		print("asd", System.out::println);
		print("asd", str -> {
			System.out.println(str);
		});

		List<Integer> list = List.of(10, 20, 30, 40, 50);
		List<Integer> list2 = Arrays.asList(10,20,30,40);
		list.forEach(System.out::print);
		System.out.println();
		list2.forEach(System.out::print);
	}
}
