package com.ktdsuniversity.edu.if_elseif_test;

public class ControlStatement {
	public void test1() {
		int age = 19;
		if (age < 19) {
			System.out.println("미성년자입니다.");
		} else if (age >= 19) {
			System.out.println("성인입니다.");
		}
	}

	public void test2() {
		int age = 15;
		if (7 <= age && age <= 13) {
			System.out.println("초등학생입니다.");
		} else if (14 <= age && age <= 16) {
			System.out.println("중학생입니다.");
		} else if (17 <= age && age <= 19) {
			System.out.println("고등학생입니다.");
		} else {
			System.out.println("학생이 아닙니다.");
		}
	}
	
	public void test3() {
		TrafficCard cardChild = new TrafficCard();
		TrafficCard cardAdult = new TrafficCard();
		takeBus(cardAdult);
		takeBus(cardChild);
	}
	public void takeBus(TrafficCard card) {
		card.pay();
		System.out.println("잔액: " + card.getMoney());
	}
	public void test4() {
		Store store = new Store();
		
		store.sell(1,3);
		store.refund(1);
		System.out.println(store);
	}
}
