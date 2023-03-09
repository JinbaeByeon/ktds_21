package com.ktdsuniversity.edu.naver.movie.cntr.service;

import java.util.List;

import com.ktdsuniversity.edu.naver.movie.cntr.dao.CntrDAO;
import com.ktdsuniversity.edu.naver.movie.cntr.dao.CntrDAOImpl;
import com.ktdsuniversity.edu.naver.movie.cntr.vo.CntrVO;

public class CntrServiceImpl implements CntrService {
	private CntrDAO cntrDAO;
	public CntrServiceImpl() {
		cntrDAO = new CntrDAOImpl();
	}
	@Override
	public boolean create(CntrVO cntrVO) {
		return cntrDAO.createCntr(cntrVO) > 0;
	}

	@Override
	public CntrVO read(Integer cntrID) {
		return cntrDAO.readCntr(cntrID);
	}

	@Override
	public List<CntrVO> readAll() {
		return cntrDAO.readAllCntr();
	}

	@Override
	public boolean update(CntrVO cntrVO) {
		return cntrDAO.updateCntr(cntrVO) > 0;
	}

	@Override
	public boolean delete(Integer cntrID) {
		return cntrDAO.deleteCntr(cntrID) > 0;
	}

}
