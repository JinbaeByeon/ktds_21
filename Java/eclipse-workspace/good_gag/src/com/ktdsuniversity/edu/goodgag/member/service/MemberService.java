package com.ktdsuniversity.edu.goodgag.member.service;

import java.util.List;

import com.ktdsuniversity.edu.goodgag.member.vo.MemberVO;

public interface MemberService {
	public int create(MemberVO memberVO);

	public MemberVO read(String email, String password);

	public MemberVO read(String email);

	public List<MemberVO> readAll();

	public int update(MemberVO memberVO);

	public int delete(MemberVO memberVO);
}
