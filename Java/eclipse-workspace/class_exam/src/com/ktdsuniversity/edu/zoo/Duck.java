package com.ktdsuniversity.edu.zoo;

import com.ktdsuniversity.edu.zoo.inf.Runable;
import com.ktdsuniversity.edu.zoo.inf.Swimable;
import com.ktdsuniversity.edu.zoo.inf.Walkable;

public class Duck implements Swimable, Walkable, Runable {

	@Override
	public void eat() {
		System.out.println("Duck - eat");
	}

	@Override
	public void bark() {
		System.out.println("Duck - bark");
	}

	@Override
	public void run() {
		System.out.println("Duck - run");
	}

	@Override
	public void walk() {
		System.out.println("Duck - walk");
	}

	@Override
	public void swim() {
		System.out.println("Duck - swim");
	}

}
