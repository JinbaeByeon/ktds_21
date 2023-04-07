package com.ktdsuniversity.admin.mv.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ktdsuniversity.admin.mv.service.MvService;
import com.ktdsuniversity.admin.mv.vo.MvVO;

@Controller
public class MvController {

	@Autowired
	private MvService mvService;
	
	@GetMapping("/mv/list")
	public String viewMvListPage(MvVO mvVO, Model model) {
		List<MvVO> mvList = mvService.readAllMv(mvVO);
		model.addAttribute("mvList", mvList);
		model.addAttribute("viewCnt", mvVO.getViewCnt());
		model.addAttribute("pageCnt", mvVO.getPageCnt());
		model.addAttribute("pageNO", mvVO.getPageNo());
		
		return "mv/list";
	}
	
	@GetMapping("/mv/create")
	public String viewMvCreatePage() {
		return "mv/create";
	}
}
