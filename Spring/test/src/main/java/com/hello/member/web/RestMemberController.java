package com.hello.member.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.hello.common.exception.AjaxResponseException;
import com.hello.common.handler.StringUtil;
import com.hello.member.service.MemberService;
import com.hello.member.vo.MemberVO;

@Controller
public class RestMemberController {
	
	@Autowired
	private MemberService memberService;

		
	@PostMapping("/api/member/login")
	@ResponseBody
	public Map<String, Object> doLogin(MemberVO memberVO, HttpSession session) {
		if(StringUtil.isEmpty(memberVO.getEmail())) {
			throw new AjaxResponseException("이메일은 필수 값입니다.");
		}
		if(StringUtil.isEmpty(memberVO.getPassword())) {
			throw new AjaxResponseException("비밀번호는 필수 값입니다.");
		}
		
		MemberVO memberData =memberService.readOneMemberByEmailAndPassword(memberVO);

		Map<String,Object> res = new HashMap<>();
		if(memberData == null) {
			res.put("loginResult", false);
			res.put("errorCode","NOT_FOUND_USER");
		} else {
			res.put("loginResult", true);
			session.setAttribute("__USER_SESSION_DATA__", memberData);
		}
		return res;
	}
	
	@GetMapping("/api/member/check/{email}/")
	@ResponseBody
	public Map<String, Object> doCheckDuplicatedEmail(@PathVariable String email){
		boolean isDuplicate = memberService.readCountByEmail(email) >0;
		Map<String, Object> res = new HashMap<>();
		res.put("isDuplicate", isDuplicate);
		return res;
	}
	
	@PostMapping("/api/member/regist")
	@ResponseBody
	public Map<String, Object> doMemberRegist(MemberVO memberVO) {
		String email = memberVO.getEmail();
		String name = memberVO.getName();
		String password = memberVO.getPassword();
		String passwordConfirm = memberVO.getPasswordConfirm();
		if(StringUtil.isEmpty(email)) {
			throw new AjaxResponseException("email은 필수 값 입니다.");
		}
		if(StringUtil.isEmpty(name)) {
			throw new AjaxResponseException("name은 필수 값 입니다.");
		}
		if(StringUtil.isEmpty(password)) {
			throw new AjaxResponseException("password은 필수 값 입니다.");
		}
		if(StringUtil.isExceedLength(email, 100)) {
			throw new AjaxResponseException("email은 100글자까지 작성할 수 있습니다.");
		}
		if(StringUtil.isExceedLength(name, 10)) {
			throw new AjaxResponseException("name은 10글자까지 작성할 수 있습니다.");
		}
		if(StringUtil.isExceedLength(password, 100)) {
			throw new AjaxResponseException("password은 100글자까지 작성할 수 있습니다.");
		}
		if(StringUtil.isExceedLength(passwordConfirm, 100)) {
			throw new AjaxResponseException("passwordConfirm은 100글자까지 작성할 수 있습니다.");
		}
		if(!StringUtil.isMatchTo(password, passwordConfirm)) {
			throw new AjaxResponseException("비밀번호가 일치하지 않습니다.");
		}

		Map<String,Object> res = new HashMap<>();
		res.put("registResult", memberService.registMember(memberVO));
		return res;
	}

	@PostMapping("/api/member/check/{email}/")
	@ResponseBody
	public String doCheckPassword(@PathVariable String email
			  					 , String password
			  					 , @SessionAttribute("__USER_SESSION_DATA__") MemberVO user) {
		if(user.getPassword().equals(password)) {
			return "redirect:/member/" + email;
		}
		
		return "redirect:/boards";
	}
	
	@PostMapping("/api/member/update/{email}/")
	@ResponseBody
	public String doMemberUpdate(@PathVariable String email
							    , @PathVariable String ext
							    , MemberVO memberVO) {
		memberVO.setEmail(email);
		memberService.updateMember(memberVO);
		return "redirect:/member/"+email;
	}
	


	
}
