package com.ktdsuniversity.edu.service;

import java.util.List;

import com.ktdsuniversity.edu.dao.ListMemberDAOImpl;
import com.ktdsuniversity.edu.dao.MemberDAO;
import com.ktdsuniversity.edu.vo.MemberVO;

public class ListMemberServiceImpl implements MemberService {

	private MemberDAO memberDAO;

	public ListMemberServiceImpl() {
		memberDAO = new ListMemberDAOImpl();
	}

	@Override
	public boolean create(MemberVO memberVO) {
		System.out.println(memberDAO.getClass() + ".create");
		return (memberDAO.create(memberVO) > 0);
	}

	@Override
	public List<MemberVO> readAll() {
		System.out.println(memberDAO.getClass() + ".readAll");
		return memberDAO.readAll();
	}


	@Override
	public MemberVO read(int idx) {
		return memberDAO.read(idx);
	}

	@Override
	public MemberVO read(String key) {
		return memberDAO.read(key);
	}

}
