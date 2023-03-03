package com.ktdsuniversity.edu.goodgag.member.service;

import java.util.List;
import com.ktdsuniversity.edu.goodgag.member.dao.MemberDAO;
import com.ktdsuniversity.edu.goodgag.member.dao.MemberDAOImpl;
import com.ktdsuniversity.edu.goodgag.member.vo.MemberVO;

public class MemberServiceImpl implements MemberService {
	private MemberDAO memberDAO;

	public MemberServiceImpl() {
		memberDAO = new MemberDAOImpl();
	}

	@Override
	public int create(MemberVO memberVO) {
		if(memberDAO.read(memberVO.getEmail()) != null) {
			System.out.println("이메일이 중복되었습니다.");
			return 0;
		}
		if(memberDAO.readByNick(memberVO.getNickName()) != null) {
			System.out.println("닉네임이 중복되었습니다.");
			return 0;
		}
		return memberDAO.create(memberVO);
	}

	@Override
	public MemberVO read(String email, String password) {
		return memberDAO.read(email, password);
	}

	@Override
	public MemberVO read(String email) {
		return memberDAO.read(email);
	}

	@Override
	public List<MemberVO> readAll() {
		return memberDAO.readAll();
	}

	@Override
	public int update(MemberVO memberVO) {
		if(memberDAO.readByNick(memberVO.getNickName()) != null) {
			System.out.println("닉네임이 중복되었습니다.");
			return 0;
		}
		return memberDAO.update(memberVO);
	}

	@Override
	public int delete(MemberVO memberVO) {
		if(memberDAO.read(memberVO.getEmail(), memberVO.getPassword()) == null) {
			System.out.println("비밀번호가 틀렸습니다.");
			return 0;
		}
		return memberDAO.delete(memberVO);
	}

}
