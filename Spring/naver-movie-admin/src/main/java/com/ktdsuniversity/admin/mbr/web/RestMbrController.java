package com.ktdsuniversity.admin.mbr.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ktdsuniversity.admin.common.api.vo.APIResponseVO;
import com.ktdsuniversity.admin.common.api.vo.APIStatus;
import com.ktdsuniversity.admin.common.exception.APIException;
import com.ktdsuniversity.admin.mbr.service.MbrService;
import com.ktdsuniversity.admin.mbr.vo.MbrVO;

@RestController
public class RestMbrController {

	@Autowired
	private MbrService mbrService;
	
	@PostMapping("/api/mbr/lgn")
	public APIResponseVO doLoginAdminMember(MbrVO mbrVO, HttpSession session) {
		MbrVO mbr = mbrService.readOneMemberByIdAndPwd(mbrVO);
		if(mbr== null) {
			throw new APIException("403", "아이디 또는 비밀번호가 일치하지 않습니다.");
		} else {
			session.setAttribute("__ADMIN__", mbr);
		}
		return new APIResponseVO(APIStatus.OK,"/index");
	}

	@PostMapping("/api/mbr/rgst")
	public APIResponseVO doRegistAdminMember(MbrVO mbrVO, HttpSession session) {
		
		mbrVO.setAdmYn("Y");
		mbrVO.setLgnBlockYn("N");
		mbrVO.setLgnTryCnt(0);
		mbrVO.setPwdSalt("asdasd");
		mbrVO.setUseYn("Y");
		
		if(mbrService.createMember(mbrVO)) {
			session.setAttribute("__ADMIN__", mbrVO);
		} else {
			throw new APIException("403", "아이디 또는 비밀번호가 일치하지 않습니다.");
		}
		return new APIResponseVO(APIStatus.OK,"/index");
	}
}
