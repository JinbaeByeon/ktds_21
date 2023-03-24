package com.hello.member.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.hello.member.service.MemberService;
import com.hello.member.vo.MemberVO;

@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;

	@GetMapping("/member/regist")
	public String viewRegistPage() {
		return "member/regist";
	}

	@PostMapping("/member/regist")
	public String doMemberRegist(MemberVO memberVO) {
		memberService.registMember(memberVO);
		return "redirect:/boards";
	}

	@GetMapping("/member/{email}{ext:\\.[a-z]+}")
	public String viewMemberDetailPage(@PathVariable String email
									  , @PathVariable String ext
									  , Model model) {
		email += ext;
		MemberVO member = memberService.readOneMemberByEmail(email);
		model.addAttribute("member", member);
		model.addAttribute("boardList",memberService.readAllBoardsByEmail(email));
		return "member/detail";
	}
	
	@GetMapping("member/update/{email}{ext:\\.[a-z]+}")
	public String viewMemberUpdatePage(@PathVariable String email
									  , @PathVariable String ext
									  , Model model) {
		email += ext;		
		model.addAttribute("member", memberService.readOneMemberByEmail(email));
		
		return "member/regist";
	}
	@PostMapping("member/update/{email}{ext:\\.[a-z]+}")
	public String doMemberUpdate(@PathVariable String email
							    , @PathVariable String ext
							    , MemberVO memberVO) {
		email += ext;
		memberVO.setEmail(email);
		memberService.updateMember(memberVO);
		return "redirect:/member/"+email;
	}
	
}
