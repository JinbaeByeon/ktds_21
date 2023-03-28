package com.hello.member.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hello.board.dao.BoardDAO;
import com.hello.board.vo.BoardVO;
import com.hello.common.exception.AjaxResponseException;
import com.hello.member.dao.MemberDAO;
import com.hello.member.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {

	private static final Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);
	@Autowired
	private MemberDAO memberDAO;
	@Autowired
	private BoardDAO boardDAO;
	
	@Override
	public boolean registMember(MemberVO memberVO) {
		if(memberDAO.readCountByEmail(memberVO.getEmail()) > 0) {
			throw new AjaxResponseException("이미 존재하는 이메일입니다.");
		}
		return memberDAO.registMember(memberVO) > 0;
	}

	@Override
	public MemberVO readOneMemberByEmail(String email) {
		return memberDAO.readOneMemberByEmail(email);
	}

	@Override
	public MemberVO readOneMemberByEmailAndPassword(MemberVO memberVO) {
		return memberDAO.readOneMemberByEmailAndPassword(memberVO);
	}
	
	@Override
	public List<MemberVO> readAllMembers() {
		return memberDAO.readAllMembers();
	}

	@Override
	public boolean updateMember(MemberVO memberVO) {
		return memberDAO.updateMember(memberVO) > 0;
	}

	@Override
	public boolean deleteMember(String email) {
		return memberDAO.deleteMember(email) > 0;
	}

	@Override
	public List<BoardVO> readAllBoardsByEmail(String email) {
		return boardDAO.readAllBoardsByEmail(email);
	}

	@Override
	public int readCountByEmail(String email) {
		return memberDAO.readCountByEmail(email);
	}


}
