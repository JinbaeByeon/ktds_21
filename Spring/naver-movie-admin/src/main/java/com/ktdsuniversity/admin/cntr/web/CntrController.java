package com.ktdsuniversity.admin.cntr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ktdsuniversity.admin.cntr.service.CntrService;

@Controller
public class CntrController {

	@Autowired
	private CntrService cntrService;
	
	@GetMapping("/cntr/list")
	public String viewCntrListPage(Model model
			, @RequestParam(required=false) String cntrNm
			, @RequestParam(required=false, defaultValue="1") int pageNo
			, @RequestParam(required=false, defaultValue="10") int viewPage) {
		model.addAttribute("cntrList", cntrService.readAllCntr(cntrNm));
		return "cntr/list";
	}
}
