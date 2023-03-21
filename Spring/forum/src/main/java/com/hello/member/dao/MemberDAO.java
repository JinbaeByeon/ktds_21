package com.hello.member.dao;

import com.hello.member.vo.MemberVO;

/**
 * Mybatis 환경에서 DAO 메소드의 parameter 규칙
 * 항상 하나의 파라미터만 전달해야한다.
 */
public interface MemberDAO {

	public int createNewMember(MemberVO memberVO);
	
	public int readCountMemberByEmail(String email);
	
	public MemberVO readOneMemberByEmailAndPassword(MemberVO memberVO);
}
