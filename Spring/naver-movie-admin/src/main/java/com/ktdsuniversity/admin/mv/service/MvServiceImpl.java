package com.ktdsuniversity.admin.mv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktdsuniversity.admin.common.exception.APIArgsException;
import com.ktdsuniversity.admin.common.exception.APIException;
import com.ktdsuniversity.admin.mv.dao.MvDAO;
import com.ktdsuniversity.admin.mv.vo.MvVO;
import com.ktdsuniversity.admin.mvgnr.dao.MvGnrDAO;
import com.ktdsuniversity.admin.mvgnr.vo.MvGnrVO;
import com.ktdsuniversity.admin.prdcprtcptnppl.dao.PrdcPrtcptnPplDAO;
import com.ktdsuniversity.admin.prdcprtcptnppl.vo.PrdcPrtcptnPplVO;

@Service
public class MvServiceImpl implements MvService {

	@Autowired
	private MvDAO mvDAO;
	@Autowired
	private MvGnrDAO mvGnrDAO;
	@Autowired
	private PrdcPrtcptnPplDAO prdcPrtcptnPplDAO;
	
	@Override
	public boolean createNewMv(MvVO mvVO) {
		if(mvDAO.createNewMv(mvVO) == 0) {
			return false;
		}
		// 장르 등록
		List<MvGnrVO> gnrList = mvVO.getGnrList();
		if(gnrList == null || gnrList.isEmpty()) {
			throw new APIArgsException("404", "장르를 선택하세요.");
		}
		for(MvGnrVO gnr: gnrList) {
			mvGnrDAO.createNewMvGnr(gnr);
		}
		// 영화 참여인 등록
		List<PrdcPrtcptnPplVO> pplList = mvVO.getPplList();
		if(pplList == null || pplList.isEmpty()) {
			throw new APIArgsException("404", "제작참여인을 선택하세요.");
		}
		for(PrdcPrtcptnPplVO ppl : pplList) {
			prdcPrtcptnPplDAO.createNewPrdcPrtcptnPpl(ppl);
		}
		// 다른 것들도
		
		return true;
	}

	@Override
	public MvVO readOneMvByMvId(String mvId) {
		return mvDAO.readOneMvByMvId(mvId);
	}

	@Override
	public List<MvVO> readAllMv(MvVO mvVO) {
		return mvDAO.readAllMv(mvVO);
	}

	@Override
	public boolean updateOneMv(MvVO mvVO) {
		return mvDAO.updateOneMv(mvVO) > 0;
	}

	@Override
	public boolean deleteOneMv(String mvId) {
		return mvDAO.deleteOneMv(mvId) > 0;
	}

	@Override
	public boolean deleteMvByMvIdList(List<String> mvIdList) {
		int delCnt = mvDAO.deleteMvByMvIdList(mvIdList);
		if(delCnt != mvIdList.size()) {
			throw new APIException("400", "삭제요청 수와 삭제건수가 다릅니다.");
		}
		return true;
	}

}
