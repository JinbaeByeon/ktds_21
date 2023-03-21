package com.hello.member.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.hello.member.service.MemberService;
import com.hello.member.vo.MemberVO;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/member/regist")
	public String viewMemberRegistPage() {
		return "member/regist";
	}
	
	
	//파라미터 받아오는 방법 1 : HttpServletRequest
//	@PostMapping("/member/regist")	
//	public String f(HttpServletRequest request){  //HttpServletRequest : HTTP 프로토콜 요청 정보
//		MemberVO memberVO = new MemberVO();
//		memberVO.setEmail(request.getParameter("email"));
//		memberVO.setName(request.getParameter("name"));
//		memberVO.setPassword(request.getParameter("password"));
//		
//		System.out.println(memberService.createNewMember(memberVO));		
//		
//		return "redirect:/member/regist";
//	}
	
	//파라미터 받아오는 방법 2 : @RequestParam
//	@PostMapping("/member/regist")
//	public String doMemberRegist(@RequestParam(name="email") String eml,
//								 @RequestParam String name,
//								 @RequestParam("password") String pwd) {
//		MemberVO memberVO = new MemberVO();
//		memberVO.setEmail(eml);
//		memberVO.setName(name);
//		memberVO.setPassword(pwd);
//		boolean isSuccess = memberService.createNewMember(memberVO);
//		System.out.println("가입 성공? " + isSuccess);
//		if(!isSuccess) {
//			return "redirect:https://www.naver.com";
//		}
//		return "redirect:/member/regist";
//	}

	//파라미터 받아오는 방법 3 : VO
	@PostMapping("/member/regist")
	public String doMemberRegist(MemberVO memberVO) {
		boolean isSuccess = memberService.createNewMember(memberVO);
		
		System.out.println("가입 성공? " + isSuccess);
		
		return "redirect:/member/regist";
	}
}
