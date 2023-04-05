package com.ktdsuniversity.admin.cntr.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.ktdsuniversity.admin.cntr.service.CntrService;
import com.ktdsuniversity.admin.cntr.vo.CntrVO;
import com.ktdsuniversity.admin.common.api.vo.APIResponseVO;
import com.ktdsuniversity.admin.common.api.vo.APIStatus;
import com.ktdsuniversity.admin.mbr.vo.MbrVO;

@RestController
public class RestCntrController {

	@Autowired
	private CntrService cntrService;
	
	@PostMapping("/api/cntr/create")
	public APIResponseVO doCreateCntr(CntrVO cntrVO, @SessionAttribute("__ADMIN__") MbrVO admin) {
		cntrVO.setCrtr(admin.getMbrId());
		cntrVO.setMdfyr(admin.getMbrId());
		
		if(cntrService.createOneCntr(cntrVO)){
			return new APIResponseVO(APIStatus.OK);			
		}
		return new APIResponseVO(APIStatus.FAIL);
	}
	
	@PostMapping("/api/cntr/update")
	public APIResponseVO doUpdateCntr(CntrVO cntrVO, @SessionAttribute("__ADMIN__") MbrVO admin) {
		cntrVO.setMdfyr(admin.getMbrId());
		
		if(cntrService.updateOneCntr(cntrVO)) {
			return new APIResponseVO(APIStatus.OK);			
		}
		return new APIResponseVO(APIStatus.FAIL);
		
	}
	
	@GetMapping("/api/cntr/delete/{cntrId}")
	public APIResponseVO doDeleteCntr(@PathVariable int cntrId) {
		if(cntrService.deleteOneCntrByCntrId(cntrId)) {
			return new APIResponseVO(APIStatus.OK);
		}
		return new APIResponseVO(APIStatus.FAIL);
	}
	
	@PostMapping("/api/cntr/delete")
	public APIResponseVO doDeleteCntrs(@RequestParam List<Integer> cntrIdList) {
		if(cntrService.deleteCntrByCntrIdList(cntrIdList)) {
			return new APIResponseVO(APIStatus.OK);
		}
		return new APIResponseVO(APIStatus.FAIL);
	}
}
