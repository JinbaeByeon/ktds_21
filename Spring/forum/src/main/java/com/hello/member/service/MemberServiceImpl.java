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
		if(memberDAO.readCountMemberByEmail(memberVO.getEmail())==0) {
			System.out.println("이메일 업슴");
			return memberDAO.createNewMember(memberVO) > 0;
		}
		System.out.println("이메일 잇슴");
		return false;
	}

	@Override
	public MemberVO readOneMemberByEmailAndPassword(MemberVO memberVO) {
		return memberDAO.readOneMemberByEmailAndPassword(memberVO);
	}
	
	
}
