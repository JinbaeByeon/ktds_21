package com.ktdsuniversity.edu.interface_test;

public class Medic implements BionicUnit {

	@Override
	public void move() {
		System.out.println("메딕 - 이동");
	}

	@Override
	public void stop() {
		System.out.println("메딕 - 정지");
	}

	@Override
	public void hold() {
		System.out.println("메딕 - 홀드");
	}

	@Override
	public void patrol() {
		System.out.println("메딕 - 정찰");
	}

	@Override
	public void shot() {
		System.out.println("메딕 - 치료");
	}
}