package com.ktdsuniversity.admin.gnr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktdsuniversity.admin.common.exception.APIArgsException;
import com.ktdsuniversity.admin.common.exception.APIException;
import com.ktdsuniversity.admin.common.util.StringUtil;
import com.ktdsuniversity.admin.gnr.dao.GnrDAO;
import com.ktdsuniversity.admin.gnr.vo.GnrVO;

@Service
public class GnrServiceImpl implements GnrService{

	@Autowired
	private GnrDAO gnrDAO;
	
	@Override
	public List<GnrVO> readAllGnr(GnrVO gnrVO) {
		gnrVO.setPeriod();
		return gnrDAO.readAllGnr(gnrVO);
	}

	@Override
	public boolean createOneGnr(GnrVO gnrVO) {
		if(StringUtil.isEmpty(gnrVO.getGnrNm())) {
			throw new APIArgsException("404", "장르명은 필수 입력값입니다.");
		}
		return gnrDAO.createOneGnr(gnrVO) > 0;
	}

	@Override
	public boolean updateOneGnr(GnrVO gnrVO) {
		if(StringUtil.isEmpty(gnrVO.getGnrNm())) {
			throw new APIArgsException("404", "장르명은 필수 입력값입니다.");
		}
		return gnrDAO.updateOneGnr(gnrVO) > 0;
	}

	@Override
	public boolean deleteOntGnrByGnrId(int gnrId) {
		return gnrDAO.deleteOntGnrByGnrId(gnrId) > 0;
	}

	@Override
	public boolean deleteGnrByGnrIdList(List<Integer> gnrIdList) {
		int delCnt = gnrDAO.deleteGnrByGnrIdList(gnrIdList);
		if(delCnt != gnrIdList.size()) {
			throw new APIException("500", "삭제에 실패했습니다. 요청: "+gnrIdList.size()+" 건, 삭제: "+delCnt+"건");
		}
		return true;
	}

}
