package com.ktdsuniversity.edu.controller;

import java.util.List;

import com.ktdsuniversity.edu.service.MapMemberServiceImpl;
import com.ktdsuniversity.edu.service.MemberService;
import com.ktdsuniversity.edu.vo.MemberVO;

public class MemberController {
	MemberService memberService;

	public MemberController() {
		memberService = new MapMemberServiceImpl();
	}

	public List<MemberVO> readAll() {
		return memberService.readAll();
	}

	public boolean create(MemberVO memberVO) {
		return memberService.create(memberVO);
	}

	public MemberVO read(int idx) {
		return memberService.read(idx);
	}

	public MemberVO read(String key) {
		return memberService.read(key);
	}

	public static void main(String[] args) {
		MemberController memCon = new MemberController();
		memCon.create((MemberVO) new MemberVO().setId("id1").setPassword("pwd1").setReadNumber(1).setPageNumber(0));

		memCon.create((MemberVO) new MemberVO().setId("id2").setPassword("pwd2").setReadNumber(2).setPageNumber(0));

		memCon.create((MemberVO) new MemberVO().setId("id3").setPassword("pwd3").setReadNumber(3).setPageNumber(0));

		List<MemberVO> memberList = memCon.readAll();
		System.out.println(memCon.read(1));
		for (MemberVO eachMember : memberList) {
			System.out.println(eachMember);
		}

	}
}
