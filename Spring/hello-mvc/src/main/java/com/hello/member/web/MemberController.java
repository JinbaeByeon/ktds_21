package com.hello.member.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.hello.member.service.MemberService;
import com.hello.member.vo.MemberVO;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
//	@RequestMapping(value = "/member/regist", method = RequestMethod.GET)
	@GetMapping("/member/regist")
	public String viewMemberRegistPage() {
		return "member/regist";
	}
	
//	@RequestMapping(value = "/member/regist", method = RequestMethod.POST)
	@PostMapping("/member/regist")
	public String doMemberRegist(@ModelAttribute MemberVO memberVO) {
		System.out.println(memberVO);
		System.out.println("회원 등록 : " + memberService.createNewMember(memberVO));
		
		return "";
	}
	
}
