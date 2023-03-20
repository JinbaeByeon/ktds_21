package com.hello.member.dao;

import java.util.List;

import com.hello.member.vo.MemberVO;

public interface MemberDAO {
	public int createNewMember(MemberVO memberVO);
	public List<MemberVO> readAllMember();
}
