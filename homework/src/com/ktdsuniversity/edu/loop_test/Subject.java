package com.ktdsuniversity.edu.loop_test;

import java.util.Random;

public class Subject {
	private String name;
	private int score;
	private String grade;

	public Subject(String name) {
		this.name = name;
		Random rd = new Random();
		score = Math.min(40 + rd.nextInt(70), 100);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade  = grade;
	}

}
