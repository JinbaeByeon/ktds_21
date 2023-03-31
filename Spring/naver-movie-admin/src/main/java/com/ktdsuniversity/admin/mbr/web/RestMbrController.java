package com.ktdsuniversity.admin.mbr.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ktdsuniversity.admin.common.api.vo.APIResponseVO;
import com.ktdsuniversity.admin.common.api.vo.APIStatus;
import com.ktdsuniversity.admin.common.exception.APIArgsException;
import com.ktdsuniversity.admin.common.exception.APIException;
import com.ktdsuniversity.admin.common.util.StringUtil;
import com.ktdsuniversity.admin.mbr.service.MbrService;
import com.ktdsuniversity.admin.mbr.vo.MbrVO;

@RestController
public class RestMbrController {

	@Autowired
	private MbrService mbrService;
	
	@PostMapping("/api/mbr/lgn")
	public APIResponseVO doLoginAdminMember(MbrVO mbrVO, HttpSession session,HttpServletRequest request) {
		if(StringUtil.isEmpty(mbrVO.getMbrId())) {
			throw new APIException("403", "ID를 입력하세요.");
		}
		if(StringUtil.isEmpty(mbrVO.getPwd())) {
			throw new APIException("403", "비밀번호를 입력하세요.");	
		}
		mbrVO.setLtstLgnIp(request.getRemoteAddr());
		
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
		
		
		if(mbrService.createNewAdminMbr(mbrVO)) {
			session.setAttribute("__ADMIN__", mbrVO);
		} else {
			throw new APIException("403", "아이디 또는 비밀번호가 일치하지 않습니다.");
		}
		return new APIResponseVO(APIStatus.OK,"/index");
	}
	
	@GetMapping("/api/mbr/dup/{mbrId}")
	public APIResponseVO doCheckDupMbrId(@PathVariable String mbrId) {
		int mbrCnt = mbrService.readCountMbrById(mbrId);
		System.out.println(mbrCnt);
		if(mbrCnt==0) {
			return new APIResponseVO(APIStatus.OK);
		}
		return new APIResponseVO(APIStatus.FAIL);
	}
	
	@PostMapping("/api/mbr/create")
	public APIResponseVO doCreateNewAdmin(MbrVO mbrVO) {
		
		String mbrId = mbrVO.getMbrId();
		String mbrNm = mbrVO.getMbrNm();
		
		if(mbrId ==null || mbrId.trim().length() == 0) {
			throw new APIArgsException("400", "ID가 누락되었습니다.");
		}
		
		if(mbrNm ==null || mbrNm.trim().length() == 0) {
			throw new APIArgsException("400", "이름이 누락되었습니다.");
		}
		
		boolean isSuccess= mbrService.createNewAdminMbr(mbrVO);
		if(isSuccess) {
			return new APIResponseVO(APIStatus.OK);
		}
		
		return new APIResponseVO(APIStatus.FAIL,"관리자를 등록할 수 없습니다.","500","");
	}
	@PostMapping("/api/mbr/update")
	public APIResponseVO doUpdateAdmin(MbrVO mbrVO) {

		
		String mbrId = mbrVO.getMbrId();
		String mbrNm = mbrVO.getMbrNm();
		
		if(StringUtil.isEmpty(mbrId)) {
			throw new APIArgsException("400", "ID가 누락되었습니다.");
		}
		
		if(StringUtil.isEmpty(mbrNm)) {
			throw new APIArgsException("400", "이름이 누락되었습니다.");
		}
		
		boolean isSuccess= mbrService.updateOneNewAdminMbr(mbrVO);
		if(isSuccess) {
			return new APIResponseVO(APIStatus.OK);
		}
		
		return new APIResponseVO(APIStatus.FAIL,"관리자를 등록할 수 없습니다.","500","");
	}
	
	@GetMapping("/api/mbr/delete/{mbrId}")
	public APIResponseVO doDeleteAdmin(@PathVariable String mbrId) {
		boolean isSuccess= mbrService.deleteOneNewAdminMbr(mbrId);
		if(isSuccess) {
			return new APIResponseVO(APIStatus.OK,"","","");
		}
		
		return new APIResponseVO(APIStatus.FAIL,"관리자를 삭제할 수 없습니다.","500","");
	}
	
}
