package com.ktdsuniversity.admin.mbr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ktdsuniversity.admin.mbr.service.MbrService;
import com.ktdsuniversity.admin.mbr.vo.MbrVO;

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
		return "mbr/index";
	}
}
