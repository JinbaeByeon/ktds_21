package com.ktdsuniversity.edu.naver.movie.cmpny.service;

import java.util.List;

import com.ktdsuniversity.edu.naver.movie.cmpny.dao.CmpnyDAO;
import com.ktdsuniversity.edu.naver.movie.cmpny.dao.CmpnyDAOImpl;
import com.ktdsuniversity.edu.naver.movie.cmpny.vo.CmpnyVO;

public class CmpnyServiceImpl implements CmpnyService {
	private CmpnyDAO cmpnyDAO;
	public CmpnyServiceImpl() {
		cmpnyDAO = new CmpnyDAOImpl();
	}
	@Override
	public boolean create(CmpnyVO cmpnyVO) {
		return cmpnyDAO.createCmpny(cmpnyVO) > 0;
	}

	@Override
	public CmpnyVO read(String cmpnyID) {
		return cmpnyDAO.readCmpny(cmpnyID);
	}

	@Override
	public List<CmpnyVO> readAll() {
		return cmpnyDAO.readAllCmpny();
	}

	@Override
	public boolean update(CmpnyVO cmpnyVO) {
		return cmpnyDAO.updateCmpny(cmpnyVO) > 0;
	}

	@Override
	public boolean delete(String cmpnyID) {
		return cmpnyDAO.deleteCmpny(cmpnyID) > 0;
	}

}
