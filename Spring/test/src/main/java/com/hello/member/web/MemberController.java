package com.hello.member.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.hello.common.handler.StringUtil;
import com.hello.member.service.MemberService;
import com.hello.member.vo.MemberVO;

@Controller
public class MemberController {
	@Autowired
	private MemberService memberService;

	@GetMapping("/member/login")
	public String viewLoginPage() {
		return "member/login";
	}
	
	@GetMapping("/member/logout")
	public String viewLogoutPage(HttpSession session) {
		session.invalidate();
		return "redirect:/boards";
	}
	
	@PostMapping("/member/login")
	public String doLogin(MemberVO memberVO, HttpSession session, Model model) {
		if(StringUtil.isEmpty(memberVO.getEmail())) {
			throw new RuntimeException("이메일은 필수 값입니다.");
		}
		if(StringUtil.isEmpty(memberVO.getPassword())) {
			throw new RuntimeException("비밀번호는 필수 값입니다.");
		}
		
		MemberVO memberData =memberService.readOneMemberByEmailAndPassword(memberVO);
		
		if(memberData == null) {
			model.addAttribute("errorCode","NOT_FOUND_USER");
			return "member/login";
		}
		session.setAttribute("__USER_SESSION_DATA__", memberData);
		
		return "redirect:/boards";
	}
	
	@GetMapping("/member/regist")
	public String viewRegistPage() {
		return "member/regist";
	}

	@PostMapping("/member/regist")
	public String doMemberRegist(MemberVO memberVO) {
		String email = memberVO.getEmail();
		String name = memberVO.getName();
		String password = memberVO.getPassword();
		String passwordConfirm = memberVO.getPasswordConfirm();
		if(StringUtil.isEmpty(email)) {
			throw new RuntimeException("email은 필수 값 입니다.");
		}
		if(StringUtil.isEmpty(name)) {
			throw new RuntimeException("name은 필수 값 입니다.");
		}
		if(StringUtil.isEmpty(password)) {
			throw new RuntimeException("password은 필수 값 입니다.");
		}
		if(StringUtil.isExceedLength(email, 100)) {
			throw new RuntimeException("email은 100글자까지 작성할 수 있습니다.");
		}
		if(StringUtil.isExceedLength(name, 10)) {
			throw new RuntimeException("name은 10글자까지 작성할 수 있습니다.");
		}
		if(StringUtil.isExceedLength(password, 100)) {
			throw new RuntimeException("password은 100글자까지 작성할 수 있습니다.");
		}
		if(StringUtil.isExceedLength(passwordConfirm, 100)) {
			throw new RuntimeException("passwordConfirm은 100글자까지 작성할 수 있습니다.");
		}
		if(!StringUtil.isMatchTo(password, passwordConfirm)) {
			throw new RuntimeException();
		}
		memberService.registMember(memberVO);
		return "redirect:/boards";
	}

	@GetMapping("/member/check/{email}/")
	public String viewCheckPasswordPage(@PathVariable String email) {
		return "member/check";
	}

	@PostMapping("/member/check/{email}/")
	public String doCheckPassword(@PathVariable String email
			  					 , String password
			  					 , @SessionAttribute("__USER_SESSION_DATA__") MemberVO user) {
		if(user.getPassword().equals(password)) {
			return "redirect:/member/" + email + "/";
		}
		
		return "redirect:/boards";
	}
	
	@GetMapping("/member/{email}/")
	public String viewMemberDetailPage(@PathVariable String email
									  , Model model) {
		MemberVO member = memberService.readOneMemberByEmail(email);
		model.addAttribute("member", member);
		model.addAttribute("boardList",memberService.readAllBoardsByEmail(email));
		return "member/detail";
	}
	
	@GetMapping("member/update/{email}/")
	public String viewMemberUpdatePage(@PathVariable String email
									  , Model model) {
		model.addAttribute("member", memberService.readOneMemberByEmail(email));
		
		return "member/regist";
	}
	@PostMapping("member/update/{email}/")
	public String doMemberUpdate(@PathVariable String email
							    , MemberVO memberVO) {
		memberVO.setEmail(email);
		memberService.updateMember(memberVO);
		return "redirect:/member/"+email + "/";
	}
	
}
