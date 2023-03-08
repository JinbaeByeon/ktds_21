package com.ktdsuniversity.edu.naver.movie.cntr.service;

import java.util.List;

import com.ktdsuniversity.edu.naver.movie.cntr.dao.CntrDAO;
import com.ktdsuniversity.edu.naver.movie.cntr.dao.CntrDAOImpl;
import com.ktdsuniversity.edu.naver.movie.cntr.vo.CntrVO;

public class CntrServiceImpl implements CntrService {
	CntrDAO cntrDAO;
	public CntrServiceImpl() {
		cntrDAO = new CntrDAOImpl();
	}
	@Override
	public boolean createCntr(CntrVO cntrVO) {
		return cntrDAO.createCntr(cntrVO) > 0;
	}

	@Override
	public CntrVO readCntr(int cntrID) {
		return cntrDAO.readCntr(cntrID);
	}

	@Override
	public List<CntrVO> readAllCntr() {
		return cntrDAO.readAllCntr();
	}

	@Override
	public boolean updateCntr(CntrVO cntrVO) {
		return cntrDAO.updateCntr(cntrVO) > 0;
	}

	@Override
	public boolean deleteCntr(int cntrID) {
		return cntrDAO.deleteCntr(cntrID) > 0;
	}

}
