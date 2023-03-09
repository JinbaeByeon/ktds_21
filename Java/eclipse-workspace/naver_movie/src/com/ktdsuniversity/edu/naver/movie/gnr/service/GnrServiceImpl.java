package com.ktdsuniversity.edu.naver.movie.gnr.service;

import java.util.List;

import com.ktdsuniversity.edu.naver.movie.gnr.dao.GnrDAO;
import com.ktdsuniversity.edu.naver.movie.gnr.dao.GnrDAOImpl;
import com.ktdsuniversity.edu.naver.movie.gnr.vo.GnrVO;

public class GnrServiceImpl implements GnrService {
	private GnrDAO gnrDAO;
	public GnrServiceImpl() {
		gnrDAO = new GnrDAOImpl();
	}
	@Override
	public boolean create(GnrVO gnrVO) {
		return gnrDAO.createGnr(gnrVO) > 0;
	}

	@Override
	public GnrVO read(Integer gnrID) {
		return gnrDAO.readGnr(gnrID);
	}

//	@Override
//	public GnrVO readByName(String gnrName) {
//		return gnrDAO.readGnrByName(gnrName);
//	}
	
	@Override
	public List<GnrVO> readAll() {
		return gnrDAO.readAllGnr();
	}

	@Override
	public boolean update(GnrVO gnrVO) {
		return gnrDAO.updateGnr(gnrVO) > 0;
	}

	@Override
	public boolean delete(Integer gnrID) {
		return gnrDAO.deleteGnr(gnrID) > 0;
	}

}
