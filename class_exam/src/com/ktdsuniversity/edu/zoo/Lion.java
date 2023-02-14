package com.ktdsuniversity.edu.zoo;

import com.ktdsuniversity.edu.zoo.inf.Runable;
import com.ktdsuniversity.edu.zoo.inf.Swimable;
import com.ktdsuniversity.edu.zoo.inf.Walkable;

public class Lion implements Runable, Walkable, Swimable {

	private String name;

	public Lion(String name) {
		this.name = name;
	}

	@Override
	public void eat() {
		System.out.println(name + " - eat");
	}

	@Override
	public void bark() {
		System.out.println(name + " - bark");
	}

	@Override
	public void swim() {
		System.out.println(name + " - swim");
	}

	@Override
	public void walk() {
		System.out.println(name + " - walk");
	}

	@Override
	public void run() {
		System.out.println(name + " - run");
	}
}
