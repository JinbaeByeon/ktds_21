package com.ktdsuniversity.admin.mvppl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.ktdsuniversity.admin.common.api.vo.APIResponseVO;
import com.ktdsuniversity.admin.common.api.vo.APIStatus;
import com.ktdsuniversity.admin.mbr.vo.MbrVO;
import com.ktdsuniversity.admin.mvppl.service.MvPplService;
import com.ktdsuniversity.admin.mvppl.vo.MvPplVO;

@RestController
public class RestMvPplController {

	@Autowired
	private MvPplService mvPplService;
	
	@PostMapping("/mvppl/create")
	public APIResponseVO doCreateMvPpl(MvPplVO mvPplVO, @SessionAttribute("__ADMIN__") MbrVO admin) {
		mvPplVO.setCrtr(admin.getMbrId());
		mvPplVO.setMdfyr(admin.getMbrId());
		
		if(mvPplService.createOneMvPpl(mvPplVO)) {
			return new APIResponseVO(APIStatus.OK);			
		}
		return new APIResponseVO(APIStatus.FAIL);
	}
	
	@PostMapping("/mvppl/update")
	public APIResponseVO doUpdateMvPpl(MvPplVO mvPplVO, @SessionAttribute("__ADMIN__") MbrVO admin) {
		mvPplVO.setMdfyr(admin.getMbrId());
		
		if(mvPplService.updateOneMvPpl(mvPplVO)) {
			return new APIResponseVO(APIStatus.OK);			
		}
		return new APIResponseVO(APIStatus.FAIL);
		
	}
	
	
	@GetMapping("/mvppl/delete/{mvPplId}")
	public APIResponseVO doDeleteMvPpl(@PathVariable String mvPplId) {
		if(mvPplService.deleteOneMvPpl(mvPplId)) {
			return new APIResponseVO(APIStatus.OK);
		}
		return new APIResponseVO(APIStatus.FAIL);
	}
}
