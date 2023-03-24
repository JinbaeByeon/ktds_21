package com.hello.member.dao;

import java.util.List;

import com.hello.member.vo.MemberVO;

public interface MemberDAO {
	public int readCountByEmail(String email);
	
	public int registMember(MemberVO memberVO);
	
	public MemberVO readOneMemberByEmail(String email);
	
	public List<MemberVO> readAllMembers();
	
	public int updateMember(MemberVO memberVO);
	
	public int deleteMember(String email);
}
