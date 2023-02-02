package com.ktdsuniversity.edu.dao;

import java.util.List;

import com.ktdsuniversity.edu.vo.MemberVO;

public interface MemberDAO {
	public int create(MemberVO memberVO);
	public List<MemberVO> readAll();
	public default MemberVO read(int idx) {
		System.out.println("인덱스 접근이 불가능합니다.");
		return null;
	}
	public default MemberVO read(String key) {
		System.out.println("키 접근이 불가능합니다.");
		return null;
	}
}
