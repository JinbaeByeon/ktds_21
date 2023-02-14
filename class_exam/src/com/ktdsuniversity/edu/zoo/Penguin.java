package com.ktdsuniversity.edu.zoo;

import com.ktdsuniversity.edu.zoo.inf.Swimable;
import com.ktdsuniversity.edu.zoo.inf.Walkable;

public class Penguin implements Swimable, Walkable {

	@Override
	public void eat() {
		System.out.println("penguin - eat");
	}

	@Override
	public void bark() {
		System.out.println("penguin - bark");
	}

	@Override
	public void walk() {
		System.out.println("penguin - walk");
	}

	@Override
	public void swim() {
		System.out.println("penguin - swim");
	}

}
