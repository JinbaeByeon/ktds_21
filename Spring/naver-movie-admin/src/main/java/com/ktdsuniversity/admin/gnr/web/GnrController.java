package com.ktdsuniversity.admin.gnr.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ktdsuniversity.admin.gnr.service.GnrService;
import com.ktdsuniversity.admin.gnr.vo.GnrVO;

@Controller
public class GnrController {

	@Autowired
	private GnrService gnrService;
	
	@GetMapping("/gnr/list") // http://localhost:8080/admin/gnr/list?gnrNm=장르명&pageNo=2&viewCnt=10
	public String viewGnrListPage(Model model, GnrVO gnrVO) {
		List<GnrVO> gnrList = gnrService.readAllGnr(gnrVO);
		model.addAttribute("gnrList", gnrList);
		model.addAttribute("gnrVO",gnrVO);
		if(!gnrList.isEmpty()) {
			model.addAttribute("lastPage",gnrList.get(0).getLastPage());
		}
		model.addAttribute("gnrNm", gnrVO.getGnrNm());
		model.addAttribute("pageNo", gnrVO.getPageNo());
		model.addAttribute("viewCnt", gnrVO.getViewCnt());
		model.addAttribute("pageCnt", gnrVO.getPageCnt());
		return "gnr/list";
	}
}
