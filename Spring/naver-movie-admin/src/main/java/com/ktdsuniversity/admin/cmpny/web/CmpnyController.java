package com.ktdsuniversity.admin.cmpny.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ktdsuniversity.admin.cmpny.service.CmpnyService;
import com.ktdsuniversity.admin.cmpny.vo.CmpnyVO;

@Controller
public class CmpnyController {

	@Autowired
	private CmpnyService cmpnyService;
	
	@GetMapping("/cmpny/list")
	public String viewCmpnyListPage(Model model, CmpnyVO cmpnyVO) {
		List<CmpnyVO> cmpnyList = cmpnyService.readAllCmpny(cmpnyVO);
		model.addAttribute("cmpnyList",cmpnyList);
		model.addAttribute("cmpnyVO",cmpnyVO);
		if(!cmpnyList.isEmpty()) {
			model.addAttribute("lastPage",cmpnyList.get(0).getLastPage());
		}
		model.addAttribute("pageNo",cmpnyVO.getPageNo());
		model.addAttribute("viewCnt",cmpnyVO.getViewCnt());
		model.addAttribute("pageCnt",cmpnyVO.getPageCnt());
		return "cmpny/list";
	}
}
