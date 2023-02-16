package com.ktdsuniversity.edu.infext;

public class VipMemberServiceImpl extends MemberServcieImpl implements VipMemberService {
	int point = 0;

	@Override
	public void regist() {
//		super.regist();
		System.out.println("VIP regist complete");
		addPoint(1000);
	}
	
	@Override
	public void updateMyInfo() {
//		super.updateMyInfo();
		System.out.println("VIP update complete");
		addPoint(50);
	}

	@Override
	public void addPoint(int point) {
		this.point += point;
		System.out.println("VIP add " + point + " point, total = " + this.point);
	}

}
