package com.ktdsuniversity.edu.zoo;

import com.ktdsuniversity.edu.zoo.inf.Animal;
import com.ktdsuniversity.edu.zoo.inf.Crawlable;
import com.ktdsuniversity.edu.zoo.inf.Flyable;
import com.ktdsuniversity.edu.zoo.inf.Runable;
import com.ktdsuniversity.edu.zoo.inf.Swimable;
import com.ktdsuniversity.edu.zoo.inf.Walkable;

public class Main {
	private static void proceed(Animal animal) {
		animal.bark();
		animal.eat();
		if (animal instanceof Walkable) {
			((Walkable) animal).walk();
		}
		if (animal instanceof Runable) {
			((Runable) animal).run();
		}
		if (animal instanceof Swimable) {
			((Swimable) animal).swim();
		}
		if(animal instanceof Flyable) {
			((Flyable)animal).fly();
		}
		if(animal instanceof Crawlable) {
			((Crawlable) animal).crawl();
		}
	}

	public static void main(String[] args) {
		proceed(new Lion("사아자아"));
		proceed(new Penguin());
		proceed(new Duck());
		proceed(new Snake());
	}
}
