package com.ktdsuniversity.admin.mvppl.web;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;

import com.ktdsuniversity.admin.common.api.vo.APIResponseVO;
import com.ktdsuniversity.admin.common.api.vo.APIStatus;
import com.ktdsuniversity.admin.common.handler.UploadHandler;
import com.ktdsuniversity.admin.mbr.vo.MbrVO;
import com.ktdsuniversity.admin.mvppl.service.MvPplService;
import com.ktdsuniversity.admin.mvppl.vo.MvPplVO;

@RestController
public class RestMvPplController {
	
	private static final Logger logger =
			LoggerFactory.getLogger(RestMvPplController.class);

	@Autowired
	private MvPplService mvPplService;

	
	@PostMapping("/api/mvppl/create")
	public APIResponseVO doCreateMvPpl(MvPplVO mvPplVO
									 , MultipartFile filePrflPctr
			, @SessionAttribute("__ADMIN__") MbrVO admin) {
		mvPplVO.setCrtr(admin.getMbrId());
		mvPplVO.setMdfyr(admin.getMbrId());
		
		
		if(mvPplService.createOneMvPpl(mvPplVO, filePrflPctr)) {
			return new APIResponseVO(APIStatus.OK);
		}
		return new APIResponseVO(APIStatus.FAIL);
	}
	
	@PostMapping("/api/mvppl/update")
	public APIResponseVO doUpdateMvPpl(MvPplVO mvPplVO
									 , MultipartFile filePrflPctr
									 , @SessionAttribute("__ADMIN__") MbrVO admin) {
		
		mvPplVO.setMdfyr(admin.getMbrId());
		
		if(mvPplService.updateOneMvPpl(mvPplVO, filePrflPctr)) {
			return new APIResponseVO(APIStatus.OK);
		}
		return new APIResponseVO(APIStatus.FAIL);
		
	}
	
	
	@GetMapping("/api/mvppl/delete/{mvPplId}")
	public APIResponseVO doDeleteMvPpl(@PathVariable String mvPplId) {
		if(mvPplService.deleteOneMvPplByMvPplId(mvPplId)) {
			return new APIResponseVO(APIStatus.OK);
		}
		return new APIResponseVO(APIStatus.FAIL);
	}
	
	@PostMapping("api/mvppl/delete")
	public APIResponseVO doDeleteMvPpls(@RequestParam List<String> mvPplIdList) {
		if(mvPplService.deleteMvPplByMvPplIdList(mvPplIdList)) {
			return new APIResponseVO(APIStatus.OK);
		}
		return new APIResponseVO(APIStatus.FAIL);
	}
}
