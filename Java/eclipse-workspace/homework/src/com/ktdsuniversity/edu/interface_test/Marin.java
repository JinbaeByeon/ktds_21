package com.ktdsuniversity.edu.interface_test;

public class Marin implements BionicUnit {

	@Override
	public void move() {
		System.out.println("마린 - 이동");
	}

	@Override
	public void stop() {
		System.out.println("마린 - 정지");
	}

	@Override
	public void hold() {
		System.out.println("마린 - 홀드");
	}

	@Override
	public void patrol() {
		System.out.println("마린 - 정찰");
	}

	@Override
	public void shot() {
		System.out.println("마린 - 공격");
	}
}