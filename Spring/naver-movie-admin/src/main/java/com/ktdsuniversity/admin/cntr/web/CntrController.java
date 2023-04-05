package com.ktdsuniversity.admin.cntr.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ktdsuniversity.admin.cntr.service.CntrService;
import com.ktdsuniversity.admin.cntr.vo.CntrVO;

@Controller
public class CntrController {

	@Autowired
	private CntrService cntrService;
	
	@GetMapping("/cntr/list")
	public String viewCntrListPage(Model model, CntrVO cntrVO) {
		List<CntrVO> cntrList = cntrService.readAllCntr(cntrVO);
		model.addAttribute("cntrList", cntrList);
		model.addAttribute("cntrVO", cntrVO);
		if(!cntrList.isEmpty()) {
			model.addAttribute("lastPage", cntrList.get(0).getLastPage());
		}
		model.addAttribute("pageNo", cntrVO.getPageNo());
		model.addAttribute("viewCnt", cntrVO.getViewCnt());
		model.addAttribute("pageCnt", cntrVO.getPageCnt());
		return "cntr/list";
	}
}
