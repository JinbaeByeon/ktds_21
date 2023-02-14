package com.ktdsuniversity.edu.infext;

public class Main {
	public static void memberManage(MemberService ms) {
		ms.regist();
		ms.updateMyInfo();
		if(ms instanceof VipMemberService) {
			((VipMemberService) ms).addPoint(50);
		}
		ms.unregist();
	}

//	public static void vipMemberManage(VipMemberService vms) {
//		vms.regist();
//		vms.updateMyInfo();
//		vms.addPoint(50);
//		vms.unregist();
//	}

	public static void main(String[] args) {
		memberManage(new MemberServcieImpl());		
		memberManage(new VipMemberServiceImpl());
	}
}
