package com.ktdsuniversity.admin.mvppl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ktdsuniversity.admin.common.exception.APIException;
import com.ktdsuniversity.admin.common.handler.UploadHandler;
import com.ktdsuniversity.admin.mvppl.dao.MvPplDAO;
import com.ktdsuniversity.admin.mvppl.vo.MvPplVO;

@Service
public class MvPplServiceImpl implements MvPplService {

	@Autowired
	private MvPplDAO mvPplDAO;

	@Autowired
	UploadHandler uploadHandler;
	
	@Override
	public boolean createOneMvPpl(MvPplVO mvPplVO, MultipartFile filePrflPctr) {
		uploadHandler.uploadProfile(filePrflPctr, mvPplVO);
		return mvPplDAO.createOneMvPpl(mvPplVO) > 0;
	}


	@Override
	public List<MvPplVO> readAllMvPpl(MvPplVO mvPplVO) {
		mvPplVO.setPeriod();
		return mvPplDAO.readAllMvPpl(mvPplVO);
	}

	@Override
	public boolean updateOneMvPpl(MvPplVO mvPplVO, MultipartFile filePrflPctr) {
		uploadHandler.uploadProfile(filePrflPctr, mvPplVO);
		MvPplVO orgnMvPplData = mvPplDAO.readOneMvPplByMvPplId(mvPplVO.getMvPplId());
		
		if(!mvPplVO.checkModify(orgnMvPplData)) {
			throw new APIException("400", "변경된 정보가 없습니다.");
		}
		
		return mvPplDAO.updateOneMvPpl(mvPplVO) > 0;
	}

	@Override
	public boolean deleteOneMvPplByMvPplId(String mvPplId) {
		return mvPplDAO.deleteOneMvPplByMvPplId(mvPplId) > 0;
	}

	@Override
	public boolean deleteMvPplByMvPplIdList(List<String> mvPplIdList) {
		int delCnt = mvPplDAO.deleteMvPplByMvPplIdList(mvPplIdList);
		if(delCnt != mvPplIdList.size()) {
			throw new APIException("400", "삭제 실패 (요청수: "+ mvPplIdList.size() +", 삭제수: " +delCnt+")");
		}
		return true;
	}
}
