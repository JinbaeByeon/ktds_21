package com.ktdsuniversity.edu.loop_test;

import java.util.ArrayList;
import java.util.List;

public class GradeManager {

	List<Student> list;

	GradeManager() {
		list = new ArrayList<>();
	}

	public void setStudents(int i) {
		for (int j = 0; j < i; ++j) {
			Student student = new Student("학생" + j);
			student.setSubject(3);
			list.add(student);
		}
	}

	public void setGrade() {
		list.forEach(student -> student.getList().forEach(subject -> {
			int score = subject.getScore();
			if (score == 100)
				subject.setGrade("A+");
			else if (score > 90)
				subject.setGrade("A");
			else if (score > 80)
				subject.setGrade("B");
			else if (score > 70)
				subject.setGrade("C");
			else if (score > 60)
				subject.setGrade("D");
			else
				subject.setGrade("F");
		}));
	}

	public void printAll() {
		list.forEach(System.out::println);
	}

}
