package com.ktdsuniversity.edu.naver.movie.cmncd.service;

import java.util.List;

import com.ktdsuniversity.edu.naver.movie.cmncd.dao.CmnCdDAO;
import com.ktdsuniversity.edu.naver.movie.cmncd.dao.CmnCdDAOImpl;
import com.ktdsuniversity.edu.naver.movie.cmncd.vo.CmnCdVO;

public class CmnCdServiceImpl implements CmnCdService {
	private CmnCdDAO cmnCdDAO;
	
	public CmnCdServiceImpl() {
		cmnCdDAO = new CmnCdDAOImpl();
	}
	
	@Override
	public boolean createCmnCd(CmnCdVO cmnCdVO) {
		return cmnCdDAO.createCmnCd(cmnCdVO) > 0;
	}

	@Override
	public CmnCdVO readCmnCd(String cmnCdId) {
		return cmnCdDAO.readCmnCd(cmnCdId);
	}

	@Override
	public List<CmnCdVO> readAllCmnCd() {
		return cmnCdDAO.readAllCmnCd();
	}

	@Override
	public boolean updateCmnCd(CmnCdVO cmnCdVO) {
		return cmnCdDAO.updateCmnCd(cmnCdVO) > 0;
	}

	@Override
	public boolean deleteCmnCd(String cmnCdId) {
		return cmnCdDAO.deleteCmnCd(cmnCdId) > 0;
	}

}
