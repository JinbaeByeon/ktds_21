package com.ktdsuniversity.edu.service;

import java.util.List;

import com.ktdsuniversity.edu.vo.MemberVO;

public interface MemberService {

	public boolean create(MemberVO memberVO);

	public List<MemberVO> readAll();
	
	public MemberVO read(int idx);
	public MemberVO read(String key);

}
