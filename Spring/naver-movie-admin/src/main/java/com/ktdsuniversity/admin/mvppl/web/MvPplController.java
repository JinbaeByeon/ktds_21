package com.ktdsuniversity.admin.mvppl.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ktdsuniversity.admin.mvppl.service.MvPplService;


@Controller
public class MvPplController {

	@Autowired
	private MvPplService mvPplService;
	
	@GetMapping("/mvppl/list")
	public String viewMvPplListPage(Model model
			, @RequestParam(required=false) String nm
			, @RequestParam(required=false, defaultValue="1") int pageNo
			, @RequestParam(required=false, defaultValue="10") int viewCnt) {
		model.addAttribute("mvPplList",mvPplService.readAllMvPpl(nm));
		
		return "mvppl/list";
	}
	
}
