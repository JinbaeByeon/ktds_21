package com.ktdsuniversity.edu.coupling;

public class EmployeeServiceImpl implements MemberService {

	@Override
	public void regist() {
		System.out.println("사원을 등록합니다.");
	}

	@Override
	public void unregist() {
		System.out.println("사원을 삭제합니다.");
	}

	@Override
	public void updateMyInfo() {
		System.out.println("사원 정보를 수정합니다.");
	}

}
