package com.ktdsuniversity.edu.exceptions;

import java.util.HashMap;
import java.util.Map;

public class ThrowNewTest {

	private static Map<String,String> memberMap = new HashMap<>();
	
	public static boolean isCreate(String memberID) {
		if(memberMap.containsKey(memberID)) {
			throw new DuplicateMemberIDException(memberID);
		}
		memberMap.put(memberID,"create" + memberID);
		return memberMap.containsKey(memberID);
	}
	
	public static void main(String[] args) {
		boolean isCreate = isCreate("ktds0601");
		System.out.println(isCreate);

		isCreate = isCreate("ktds0601");
		System.out.println(isCreate);
		
		System.out.println("회원가입완료");
	}
}
