package com.ktdsuniversity.edu.reference;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		List<Integer> list =new ArrayList<>();

		ListHelper lh = new ListHelper();
		lh.setIntList(list);
		
		lh.addInteger(1);
		lh.addInteger(2);
		lh.addInteger(3);
		lh.addInteger(4);
		lh.addInteger(5);
		lh.addInteger(6);
		
		list.add(7);
		list.add(8);
		list.add(9);
		int size = lh.getSize();
		System.out.println(size);
	}
}
