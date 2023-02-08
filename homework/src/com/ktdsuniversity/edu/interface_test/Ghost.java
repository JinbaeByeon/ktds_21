package com.ktdsuniversity.edu.interface_test;

public class Ghost implements BionicUnit {

	@Override
	public void move() {
		System.out.println("고스트 - 이동");
	}

	@Override
	public void stop() {
		System.out.println("고스트 - 정지");
	}

	@Override
	public void hold() {
		System.out.println("고스트 - 홀드");
	}

	@Override
	public void patrol() {
		System.out.println("고스트 - 정찰");
	}

	@Override
	public void shot() {
		System.out.println("고스트 - 공격");
	}
}