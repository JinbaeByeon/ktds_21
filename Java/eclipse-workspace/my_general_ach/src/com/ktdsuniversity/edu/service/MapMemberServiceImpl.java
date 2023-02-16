package com.ktdsuniversity.edu.service;

import java.util.List;

import com.ktdsuniversity.edu.dao.MapMemberDAOImpl;
import com.ktdsuniversity.edu.dao.MemberDAO;
import com.ktdsuniversity.edu.vo.MemberVO;

public class MapMemberServiceImpl implements MemberService {

	private MemberDAO memberDAO;

	public MapMemberServiceImpl() {
		memberDAO = new MapMemberDAOImpl();
	}

	@Override
	public boolean create(MemberVO memberVO) {
		return (memberDAO.create(memberVO) > 0);
	}

	@Override
	public List<MemberVO> readAll() {
		return memberDAO.readAll();
	}

	@Override
	public MemberVO read(int idx) {
		// TODO Auto-generated method stub
		return memberDAO.read(idx);
	}

	@Override
	public MemberVO read(String key) {
		// TODO Auto-generated method stub
		return memberDAO.read(key);
	}

}
