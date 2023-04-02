package com.ktdsuniversity.admin.gnr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ktdsuniversity.admin.gnr.service.GnrService;

@Controller
public class GnrController {

	@Autowired
	private GnrService gnrService;
	
	@GetMapping("/gnr/list") // http://localhost:8080/admin/gnr/list?gnrNm=장르명&pageNo=2&viewCnt=10
	public String viewGnrListPage(Model model
			, @RequestParam(required=false) String gnrNm
			, @RequestParam(required=false, defaultValue = "1") int pageNo
			, @RequestParam(required=false, defaultValue = "10") int viewCnt) {
		model.addAttribute("gnrList",gnrService.readAllGnr(gnrNm));
		return "gnr/list";
	}
}