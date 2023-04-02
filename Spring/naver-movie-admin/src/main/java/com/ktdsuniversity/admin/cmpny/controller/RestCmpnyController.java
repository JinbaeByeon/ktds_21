package com.ktdsuniversity.admin.cmpny.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.ktdsuniversity.admin.cmpny.service.CmpnyService;
import com.ktdsuniversity.admin.cmpny.vo.CmpnyVO;
import com.ktdsuniversity.admin.common.api.vo.APIResponseVO;
import com.ktdsuniversity.admin.common.api.vo.APIStatus;
import com.ktdsuniversity.admin.mbr.vo.MbrVO;

@RestController
public class RestCmpnyController {

	@Autowired
	private CmpnyService cmpnyService;
	
	@PostMapping("/api/cmpny/create")
	public APIResponseVO doCreateCmpny(CmpnyVO cmpnyVO, @SessionAttribute("__ADMIN__") MbrVO admin) {
		cmpnyVO.setCrtr(admin.getMbrId());
		cmpnyVO.setMdfyr(admin.getMbrId());
		if(cmpnyService.createOneCmpny(cmpnyVO)) {
			return new APIResponseVO(APIStatus.OK);
		}
		return new APIResponseVO(APIStatus.FAIL);
	}
	
	@PostMapping("/api/cmpny/update")
	public APIResponseVO doUpdateCmpny(CmpnyVO cmpnyVO, @SessionAttribute("__ADMIN__") MbrVO admin) {
		cmpnyVO.setMdfyr(admin.getMbrId());
		if(cmpnyService.updateOneCmpny(cmpnyVO)) {
			return new APIResponseVO(APIStatus.OK);
		}
		return new APIResponseVO(APIStatus.FAIL);
	}
	
	@GetMapping("/api/cmpny/delete/{cmpnyId}")
	public APIResponseVO doDeleteCmpny(@PathVariable String cmpnyId) {
		if(cmpnyService.deleteOneCmpny(cmpnyId)) {
			return new APIResponseVO(APIStatus.OK);
		}
		return new APIResponseVO(APIStatus.FAIL);
	}
}
