package com.ktdsuniversity.edu.naver.movie.gnr.service;

import java.util.List;

import com.ktdsuniversity.edu.naver.movie.gnr.dao.GnrDAO;
import com.ktdsuniversity.edu.naver.movie.gnr.dao.GnrDAOImpl;
import com.ktdsuniversity.edu.naver.movie.gnr.vo.GnrVO;

public class GnrServiceImpl implements GnrService {
	GnrDAO gnrDAO;
	public GnrServiceImpl() {
		gnrDAO = new GnrDAOImpl();
	}
	@Override
	public boolean createGnr(GnrVO gnrVO) {
		return gnrDAO.createGnr(gnrVO) > 0;
	}

	@Override
	public GnrVO readGnr(int gnrID) {
		return gnrDAO.readGnr(gnrID);
	}

	@Override
	public List<GnrVO> readAllGnr() {
		return gnrDAO.readAllGnr();
	}

	@Override
	public boolean updateGnr(GnrVO gnrVO) {
		return gnrDAO.updateGnr(gnrVO) > 0;
	}

	@Override
	public boolean deleteGnr(int gnrID) {
		return gnrDAO.deleteGnr(gnrID) > 0;
	}

}
