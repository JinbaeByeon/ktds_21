package com.ktdsuniversity.edu.goodgag.member.dao;

import java.util.List;
import com.ktdsuniversity.edu.goodgag.member.vo.MemberVO;

public interface MemberDAO {
	public int create(MemberVO vo);

	public MemberVO read(String email, String password);
	public MemberVO read(String email);
	
	public List<MemberVO> readAll();

	public int update(String email);

	public int delete(String email);
}
