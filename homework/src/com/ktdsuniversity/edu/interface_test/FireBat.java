package com.ktdsuniversity.edu.interface_test;

public class FireBat implements BionicUnit {

	@Override
	public void move() {
		System.out.println("파이어뱃 - 이동");
	}

	@Override
	public void stop() {
		System.out.println("파이어뱃 - 정지");
	}

	@Override
	public void hold() {
		System.out.println("파이어뱃 - 홀드");
	}

	@Override
	public void patrol() {
		System.out.println("파이어뱃 - 정찰");
	}

	@Override
	public void shot() {
		System.out.println("파이어뱃 - 공격");
	}
}