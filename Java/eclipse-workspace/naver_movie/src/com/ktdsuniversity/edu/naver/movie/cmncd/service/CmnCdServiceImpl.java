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
	public boolean create(CmnCdVO cmnCdVO) {
		return cmnCdDAO.createCmnCd(cmnCdVO) > 0;
	}

	@Override
	public CmnCdVO read(String cmnCdId) {
		return cmnCdDAO.readCmnCd(cmnCdId);
	}

	@Override
	public List<CmnCdVO> readAll() {
		return cmnCdDAO.readAllCmnCd();
	}

	@Override
	public boolean update(CmnCdVO cmnCdVO) {
		return cmnCdDAO.updateCmnCd(cmnCdVO) > 0;
	}

	@Override
	public boolean delete(String cmnCdId) {
		return cmnCdDAO.deleteCmnCd(cmnCdId) > 0;
	}

}
