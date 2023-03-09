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
	public boolean createRtng(RtngVO rtngVO) {
		return rtngDAO.createRtng(rtngVO) > 0;
	}

	@Override
	public RtngVO readRtng(String rtngId) {
		return rtngDAO.readRtng(rtngId);
	}

	@Override
	public List<RtngVO> readAllRtng() {
		return rtngDAO.readAllRtng();
	}

	@Override
	public boolean updateRtng(RtngVO rtngVO) {
		return rtngDAO.updateRtng(rtngVO) > 0;
	}

	@Override
	public boolean deleteRtng(String rtngId) {
		return rtngDAO.deleteRtng(rtngId) > 0;
	}

}
