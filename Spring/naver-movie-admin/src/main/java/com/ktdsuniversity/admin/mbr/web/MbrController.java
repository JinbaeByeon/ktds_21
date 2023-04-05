package com.ktdsuniversity.admin.mbr.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ktdsuniversity.admin.mbr.service.MbrService;
import com.ktdsuniversity.admin.mbr.vo.MbrVO;
import com.ktdsuniversity.admin.mbrlgnhist.vo.MbrLgnHistVO;

@Controller
public class MbrController {

	@Autowired
	private MbrService mbrService;
	
	@GetMapping("/")
	public String viewAdminLoginPage() {
		return "mbr/lgn";
	}
	
	@GetMapping("/regist")
	public String viewAdminRegistPage() {
		return "mbr/rgst";
	}
	
	@GetMapping("/index")
	public String viewIndexPage() {
		return "index";
	}
	@GetMapping("/mbr/list")
	public String viewIndexPage(Model model) {
		model.addAttribute("mbrList",mbrService.readAllMembers());
		return "mbr/list";
	}
	@GetMapping("/mbr/lgt")
	public String doLogout(HttpSession session, HttpServletRequest request) {
		MbrLgnHistVO lgnHistVO = new MbrLgnHistVO();
		lgnHistVO.setIp(request.getRemoteAddr());
		lgnHistVO.setAct("logout");	
		lgnHistVO.setMbrId(((MbrVO)session.getAttribute("__ADMIN__")).getMbrId()); 
		session.invalidate();
		System.out.println("로그아웃!");
		mbrService.createLogoutHistory(lgnHistVO);
		return "redirect:/";
	}
}
