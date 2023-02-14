package com.ktdsuniversity.edu.zoo;

import com.ktdsuniversity.edu.zoo.inf.Crawlable;
import com.ktdsuniversity.edu.zoo.inf.Swimable;

public class Snake implements Crawlable, Swimable {

	@Override
	public void eat() {
		System.out.println("snake - eat");
	}

	@Override
	public void bark() {
		System.out.println("snake - bark");
	}

	@Override
	public void swim() {
		System.out.println("snake - swim");
	}

	@Override
	public void crawl() {
		System.out.println("snake - crawl");
	}

}
