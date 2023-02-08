package com.ktdsuniversity.edu.parking_lot;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ParkingLot {
	private Map<CarType, Integer> price;
	private final int SIZE = 35;
	private Map<Integer, Car> mapCar;

	public void proceed() {
		Scanner scan = new Scanner(System.in);
		System.out.println("주차장 관리 프로그램 시작");
		String menu = "";
		while (true) {
			System.out.println("메뉴를 입력하세요. 1. 차량 추가 2. 차량 제거 3. 차량 조회 4.종료");
			menu = scan.nextLine();
			if (menu.equals("1")) {
				Car car = new Car();
				System.out.println("차량의 종류를 입력하세요");
				menu = scan.nextLine();
				if (menu.equals("경차")) {
					car.setType(CarType.경차);
				} else if (menu.equals("소형차")) {
					car.setType(CarType.소형차);
				} else if (menu.equals("준중형차")) {
					car.setType(CarType.준중형차);
				} else if (menu.equals("중형차")) {
					car.setType(CarType.중형차);
				} else if (menu.equals("대형차")) {
					car.setType(CarType.대형차);
				}

				System.out.println("차량의 번호를 입력하세요");
				int number = scan.nextInt();
				scan.nextLine();
				car.setNumber(number);
				car.setTime(System.currentTimeMillis());
				mapCar.put(number, car);
			} else if (menu.equals("2")) {
				System.out.println("차량의 번호를 입력하세요");
				int price = remove(scan.nextInt());
				scan.nextLine();
				if (price == -1) {
					System.out.println("차량이 존재하지 않습니다.");
				} else {
					System.out.println("주차 요금은 " + price + "원 입니다.");
				}
			} else if (menu.equals("3")) {
				mapCar.forEach((k, v) -> System.out.println("차량 번호 : " + k));
			} else {
				break;
			}
		}

	}

	public ParkingLot() {
		mapCar = new HashMap<>();
		price = new HashMap<>();
		price.put(CarType.경차, 500);
		price.put(CarType.소형차, 800);
		price.put(CarType.준중형차, 850);
		price.put(CarType.중형차, 1000);
		price.put(CarType.대형차, 1500);
	}

	public void addCar(Car car) {
		if (mapCar.size() < SIZE) {
			mapCar.put(car.getNumber(), car);
			System.out.println("차 번호: [" + car.getNumber() + " ]가 주차되었습니다.");
		} else {
			System.out.println("만차되어 주차할 수 없습니다.");
		}
	}

	public int remove(int carNumber) {
		if (mapCar.containsKey(carNumber)) {
			Car car = mapCar.get(carNumber);
			mapCar.remove(carNumber);
			int minute = (int) (System.currentTimeMillis() - car.getTime()) / 1000;
			System.out.println("주차시간은 " + minute + "분 입니다.");
			return price.get(car.getType()) * (minute/10);
		} else {
			return -1;
		}
	}

}
