package com.ktdsuniversity.edu.coupling;

public class MemberServiceImpl implements MemberService{

	@Override
	public void regist() {
		System.out.println("회원 가입합니다.");
	}
	
	@Override
	public void unregist() {
		System.out.println("회원 탈퇴합니다.");
	}
	
	@Override
	public void updateMyInfo() {
		System.out.println("내 정보를 수정합니다.");
	}
}
