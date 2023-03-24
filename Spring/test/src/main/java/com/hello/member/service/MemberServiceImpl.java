package com.hello.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hello.board.dao.BoardDAO;
import com.hello.board.vo.BoardVO;
import com.hello.member.dao.MemberDAO;
import com.hello.member.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDAO memberDAO;
	@Autowired
	private BoardDAO boardDAO;
	
	@Override
	public boolean registMember(MemberVO memberVO) {
		if(memberDAO.readCountByEmail(memberVO.getEmail()) > 0) {
			System.out.println("해당 이메일이 이미 존재합니다");
			return false;
		}
		return memberDAO.registMember(memberVO) > 0;
	}

	@Override
	public MemberVO readOneMemberByEmail(String email) {
		return memberDAO.readOneMemberByEmail(email);
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

}
