package com.ktdsuniversity.edu.coupling;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Main {
	private static void proceed(MemberService ms) {
		ms.regist();
		ms.unregist();
		ms.updateMyInfo();
	}
	
	public static void main(String[] args) {
		proceed(new EmployeeServiceImpl());
	}
}
