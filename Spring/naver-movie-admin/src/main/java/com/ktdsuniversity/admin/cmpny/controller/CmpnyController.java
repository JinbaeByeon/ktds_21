package com.ktdsuniversity.admin.cmpny.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ktdsuniversity.admin.cmpny.service.CmpnyService;

@Controller
public class CmpnyController {

	@Autowired
	private CmpnyService cmpnyService;
	
	@GetMapping("/cmpny/list")
	public String viewCmpnyListPage(Model model,
			@RequestParam(required=false) String cmpnyNm,
			@RequestParam(required=false, defaultValue="1") int pageNo,
			@RequestParam(required=false, defaultValue="10") int viewPage) {
		model.addAttribute("cmpnyList",cmpnyService.readAllCmpny(cmpnyNm));
		return "cmpny/list";
	}
}
