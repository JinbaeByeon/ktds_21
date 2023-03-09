package com.ktdsuniversity.edu.naver.movie.rtng.service;

import java.util.List;

import com.ktdsuniversity.edu.naver.movie.rtng.dao.RtngDAO;
import com.ktdsuniversity.edu.naver.movie.rtng.dao.RtngDAOImpl;
import com.ktdsuniversity.edu.naver.movie.rtng.vo.RtngVO;

public class RtngServiceImpl implements RtngService {
	private RtngDAO rtngDAO;
	
	public RtngServiceImpl() {
		rtngDAO = new RtngDAOImpl();
	}
	
	@Override
	public boolean create(RtngVO rtngVO) {
		return rtngDAO.createRtng(rtngVO) > 0;
	}

	@Override
	public RtngVO read(String rtngId) {
		return rtngDAO.readRtng(rtngId);
	}

	@Override
	public List<RtngVO> readAll() {
		return rtngDAO.readAllRtng();
	}

	@Override
	public boolean update(RtngVO rtngVO) {
		return rtngDAO.updateRtng(rtngVO) > 0;
	}

	@Override
	public boolean delete(String rtngId) {
		return rtngDAO.deleteRtng(rtngId) > 0;
	}

}
