package com.ktdsuniversity.admin.mbr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktdsuniversity.admin.common.exception.APIException;
import com.ktdsuniversity.admin.common.util.SHA256Util;
import com.ktdsuniversity.admin.mbr.dao.MbrDAO;
import com.ktdsuniversity.admin.mbr.vo.MbrVO;
import com.ktdsuniversity.admin.mbrlgnhist.dao.MbrLgnHistDAO;
import com.ktdsuniversity.admin.mbrlgnhist.vo.MbrLgnHistVO;

@Service
public class MbrServiceImpl implements MbrService {

	@Autowired
	private MbrDAO mbrDAO;
	@Autowired
	private MbrLgnHistDAO mbrLgnHistDAO;
	
	@Override
	public boolean createNewAdminMbr(MbrVO mbrVO) {
		int mbrCnt = this.readCountMbrById(mbrVO.getMbrId());
		if(mbrCnt > 0) {
			throw new APIException("500", "이미 사용중인 ID입니다.");
		}

		String defaultPwd = "admin1234";
		String salt = SHA256Util.generateSalt();
		mbrVO.setPwdSalt(salt);
		defaultPwd = SHA256Util.getEncrypt(defaultPwd, salt);
		mbrVO.setPwd(defaultPwd);
		
		try {
			return mbrDAO.createNewAdminMbr(mbrVO) > 0;
		} catch(RuntimeException e) {
			throw new APIException("500", "이미 사용중인 ID입니다.");
		}
	}

	@Override
	public int readCountMbrById(String mbrId) {
		return mbrDAO.readCountMbrById(mbrId);
	}
	
	@Override
	public MbrVO readOneMemberById(String mbrId) {
		return mbrDAO.readOneMemberById(mbrId);
	}

	@Override
	public List<MbrVO> readAllMembers() {
		return mbrDAO.readAllMembers();
	}

	@Override
	public boolean updateOneNewAdminMbr(MbrVO mbrVO) {
		return mbrDAO.updateOneNewAdminMbr(mbrVO) > 0;
	}

	@Override
	public boolean deleteOneNewAdminMbr(String mbrId) {
		return mbrDAO.deleteOneNewAdminMbr(mbrId) > 0;
	}

	@Override
	public MbrVO readOneMemberByIdAndPwd(MbrVO mbrVO) {
		String mbrId = mbrVO.getMbrId();
		
		String lgnBlockYn = mbrDAO.readLgnBlockYnById(mbrId);
		if(lgnBlockYn==null) {
			throw new APIException("403", "아이디 또는 비밀번호가 일치하지 않습니다.");
		} else if(lgnBlockYn.equals("Y")) {
			throw new APIException("403", "계정이 잠겼습니다. 관리자에게 문의하세요.");
		}
		
		String salt = mbrDAO.readSaltById(mbrId);
		if(salt==null) {
			throw new APIException("403", "아이디 또는 비밀번호가 일치하지 않습니다.");
		}
		mbrVO.setPwd(SHA256Util.getEncrypt(mbrVO.getPwd(), salt));
		
		MbrVO loginData = mbrDAO.readOneMemberByIdAndPwd(mbrVO);
		if(loginData == null) {
			// 실패
			// 로그인 실패 횟수 증가
			if(mbrDAO.updateMbrLgnFail(mbrId)>0) {
				// 로그인 제한
				mbrDAO.updateMbrLgnBlock(mbrId);
			}
		} else {
			// 성공
			mbrDAO.updateMbrLgnSucc(mbrVO);
			MbrLgnHistVO lgnHistVO = new MbrLgnHistVO();
			lgnHistVO.setMbrId(mbrId);
			lgnHistVO.setAct("login");
			lgnHistVO.setIp(mbrVO.getLtstLgnIp());
			mbrLgnHistDAO.createMbrLgnHist(lgnHistVO);
		}
		return loginData;
	}

	@Override
	public boolean createLogoutHistory(MbrLgnHistVO lgnHistVO){
		return mbrLgnHistDAO.createMbrLgnHist(lgnHistVO) > 0;
	}

}
