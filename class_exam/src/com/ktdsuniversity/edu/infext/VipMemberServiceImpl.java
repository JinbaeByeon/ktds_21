package com.ktdsuniversity.edu.infext;

public class VipMemberServiceImpl implements VipMemberService {
	int point = 0;

	@Override
	public void regist() {
		System.out.println("VIP regist complete");
		addPoint(1000);
	}

	@Override
	public void unregist() {
		System.out.println("VIP unregist complete");
	}

	@Override
	public void updateMyInfo() {
		System.out.println("VIP update complete");
	}

	@Override
	public void addPoint(int point) {
		this.point += point;
		System.out.println("VIP add " + point + " point, total = " + this.point);
	}

}
