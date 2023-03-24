package com.hello.member.service;

import java.util.List;

import com.hello.board.vo.BoardVO;
import com.hello.member.vo.MemberVO;

public interface MemberService {
	public boolean registMember(MemberVO memberVO);
	
	public MemberVO readOneMemberByEmail(String email);
	
	public List<MemberVO> readAllMembers();
	
	public boolean updateMember(MemberVO memberVO);
	
	public boolean deleteMember(String email);

	public List<BoardVO> readAllBoardsByEmail(String email);
}
