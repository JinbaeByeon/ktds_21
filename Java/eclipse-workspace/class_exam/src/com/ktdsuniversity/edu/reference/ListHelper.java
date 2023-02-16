package com.ktdsuniversity.edu.reference;

import java.util.List;

public class ListHelper {
	private List<Integer> intList;

	public List<Integer> getIntList() {
		return intList;
	}
	public void setIntList(List<Integer> list) {
		intList = list;
	}

	public void addInteger(int value) {
		intList.add(value);
	}

	public int getSize() {
		return intList.size();
	}

}
