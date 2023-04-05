package com.ktdsuniversity.admin.mvppl.web;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ktdsuniversity.admin.common.handler.DownloadUtil;
import com.ktdsuniversity.admin.mvppl.service.MvPplService;
import com.ktdsuniversity.admin.mvppl.vo.MvPplVO;


@Controller
public class MvPplController {
	
	@Autowired
	private MvPplService mvPplService;

	@Value("${upload.profile.path:C:/naver-movie-admin/files/profiles}")
	private String profilePath;
	
	@GetMapping("/mvppl/list")
	public String viewMvPplListPage(Model model, MvPplVO mvPplVO) {
		List<MvPplVO> mvPplList = mvPplService.readAllMvPpl(mvPplVO);
		model.addAttribute("mvPplList",mvPplList);
		model.addAttribute("mvPplVO",mvPplVO);
		if(!mvPplList.isEmpty()) {
			model.addAttribute("lastPage",mvPplList.get(0).getLastPage());
		}
		model.addAttribute("pageNo",mvPplVO.getPageNo());
		model.addAttribute("viewCnt",mvPplVO.getViewCnt());
		model.addAttribute("pageCnt",mvPplVO.getPageCnt());
		
		return "mvppl/list";
	}
	
	@GetMapping("/mvppl/prfl/{fileNm}/")
	public void downloadPrflPctr(@PathVariable String fileNm
								, HttpServletRequest request
								, HttpServletResponse response) {
		System.out.println(fileNm);
		File imgFile = new File(profilePath, fileNm);
		String path =profilePath + "/";
		if(!imgFile.exists() || !imgFile.isFile()) {
			fileNm = "base_profile.png";
		}
		path += fileNm;
		DownloadUtil dnUtil = new DownloadUtil(response, request, path);
		dnUtil.download(fileNm);
	}
	
}
