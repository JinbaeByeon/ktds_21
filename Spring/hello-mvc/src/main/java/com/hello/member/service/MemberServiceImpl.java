package com.hello.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hello.member.dao.MemberDAO;
import com.hello.member.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDAO memberDAO;
	
	@Override
	public boolean createNewMember(MemberVO memberVO) {
		return memberDAO.createNewMember(memberVO) > 0;
	}

}
