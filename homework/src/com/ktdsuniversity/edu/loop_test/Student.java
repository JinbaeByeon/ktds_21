package com.ktdsuniversity.edu.loop_test;

import java.util.ArrayList;
import java.util.List;

public class Student {
	private String name;
	private List<Subject> list;

	public Student(String name) {
		this.name = name;
		list = new ArrayList<>();
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Subject> getList() {
		return list;
	}

	public void setList(List<Subject> list) {
		this.list = list;
	}

	public void setSubject(int i) {
		for (int j = 0; j < i; ++j) {
			list.add(new Subject("과목" + j));
		}
	}
	@Override
	public String toString() {
		String res = "";
		for (Subject sub : list) {
			res += this.name + " | " + sub.getName() + " | " + sub.getScore() + " | " + sub.getGrade() + "\n";
		}
		return res;
	}
}
