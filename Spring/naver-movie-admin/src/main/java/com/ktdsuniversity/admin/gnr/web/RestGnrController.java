package com.ktdsuniversity.admin.gnr.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.ktdsuniversity.admin.common.api.vo.APIResponseVO;
import com.ktdsuniversity.admin.common.api.vo.APIStatus;
import com.ktdsuniversity.admin.gnr.service.GnrService;
import com.ktdsuniversity.admin.gnr.vo.GnrVO;
import com.ktdsuniversity.admin.mbr.vo.MbrVO;

@RestController
public class RestGnrController {

	@Autowired
	private GnrService gnrService;
	
	@PostMapping("/api/gnr/create")
	public APIResponseVO doCreateGnr(GnrVO gnrVO, @SessionAttribute("__ADMIN__") MbrVO admin) {
		gnrVO.setCrtr(admin.getMbrId());
		gnrVO.setMdfyr(admin.getMbrId());
		
		if(gnrService.createOneGnr(gnrVO)) {
			return new APIResponseVO(APIStatus.OK);
		}
		return new APIResponseVO(APIStatus.FAIL,"생성 안댐","403","");
	}
	
	@PostMapping("/api/gnr/update")
	public APIResponseVO doUpdateGnr(GnrVO gnrVO, @SessionAttribute("__ADMIN__") MbrVO admin) {
		gnrVO.setMdfyr(admin.getMbrId());

		if(gnrService.updateOneGnr(gnrVO)) {
			return new APIResponseVO(APIStatus.OK);
		}
		return new APIResponseVO(APIStatus.FAIL,"업데이트 안댐","403","");
	}
	
	@GetMapping("/api/gnr/delete/{gnrId}")
	public APIResponseVO doDeleteGnr(@PathVariable int gnrId) {
		if(gnrService.deleteOntGnrByGnrId(gnrId)) {
			return new APIResponseVO(APIStatus.OK);
		}
		return new APIResponseVO(APIStatus.FAIL,"삭제 안댐","403","");
	}
	
	@PostMapping("/api/gnr/delete")
	public APIResponseVO doDeleteGnrs(@RequestParam List<Integer> gnrIdList) {
		if(gnrService.deleteGnrByGnrIdList(gnrIdList)) {
			return new APIResponseVO(APIStatus.OK);
		}
		return new APIResponseVO(APIStatus.FAIL,"삭제 안댐","403","");
	}
}
