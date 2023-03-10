package com.ktdsuniversity.edu.naver.movie.mv.service;

import java.util.List;

import com.ktdsuniversity.edu.naver.movie.mv.dao.MvDAO;
import com.ktdsuniversity.edu.naver.movie.mv.dao.MvDAOImpl;
import com.ktdsuniversity.edu.naver.movie.mv.dao.MvGnrDAO;
import com.ktdsuniversity.edu.naver.movie.mv.dao.MvGnrDAOImpl;
import com.ktdsuniversity.edu.naver.movie.mv.dao.PrdcLocDAO;
import com.ktdsuniversity.edu.naver.movie.mv.dao.PrdcLocDAOImpl;
import com.ktdsuniversity.edu.naver.movie.mv.dao.PrdcPrtcptnCmpnyDAO;
import com.ktdsuniversity.edu.naver.movie.mv.dao.PrdcPrtcptnCmpnyDAOImpl;
import com.ktdsuniversity.edu.naver.movie.mv.dao.PrdcPrtcptnPplDAO;
import com.ktdsuniversity.edu.naver.movie.mv.dao.PrdcPrtcptnPplDAOImpl;
import com.ktdsuniversity.edu.naver.movie.mv.vo.MvVO;

public class MvServiceImpl implements MvService {
	private MvDAO mvDAO;
	private MvGnrDAO mvGnrDAO;
	private PrdcLocDAO prdcLocDAO;
	private PrdcPrtcptnCmpnyDAO prdcPrtcptnCmpnyDAO;
	private PrdcPrtcptnPplDAO prdcPrtcptnPplDAO;
	
	public MvServiceImpl() {
		mvDAO = new MvDAOImpl();
		mvGnrDAO = new MvGnrDAOImpl();
		prdcLocDAO = new PrdcLocDAOImpl();
		prdcPrtcptnCmpnyDAO = new PrdcPrtcptnCmpnyDAOImpl();
		prdcPrtcptnPplDAO = new PrdcPrtcptnPplDAOImpl();
	}

	@Override
	public boolean create(MvVO mvVO) {
		mvVO.setMvId(mvDAO.createNewMvId());
		if(mvDAO.createMv(mvVO) == 0 ) {
			return false;
		}
		if(mvGnrDAO.createMvGnr(mvVO) == 0 ) {
			return false;
		}
		if(prdcLocDAO.createPrdcLoc(mvVO) == 0 ) {
			return false;
		}
		if(prdcPrtcptnCmpnyDAO.createPrdcPrtcptnCmpny(mvVO) == 0) {
			return false;
		}
		if(prdcPrtcptnPplDAO.createPrdcPrtcptnPpl(mvVO) == 0) {
			return false;
		}
		return true;
	}

	@Override
	public MvVO read(String mvId) {
		return mvDAO.readMv(mvId);
	}

	@Override
	public List<MvVO> readAll() {
		return mvDAO.readAllMv();
	}

	@Override
	public boolean update(MvVO mvVO) {
		if(mvDAO.updateMv(mvVO) == 0) {
			return false;
		}
		if(mvGnrDAO.deleteMvGnr(mvVO.getMvId()) == 0) {
			return false;
		}
		if(mvGnrDAO.createMvGnr(mvVO) == 0) {
			return false;
		}
		if(prdcLocDAO.deletePrdcLoc(mvVO.getMvId()) == 0) {
			return false;
		}
		if(prdcLocDAO.createPrdcLoc(mvVO) == 0) {
			return false;
		}
		if(prdcPrtcptnCmpnyDAO.deletePrdcPrtcptnCmpny(mvVO.getMvId()) == 0) {
			return false;
		}
		if(prdcPrtcptnCmpnyDAO.createPrdcPrtcptnCmpny(mvVO) == 0) {
			return false;
		}
		if(prdcPrtcptnPplDAO.deletePrdcPrtcptnPpl(mvVO.getMvId()) == 0) {
			return false;
		}
		if(prdcPrtcptnPplDAO.createPrdcPrtcptnPpl(mvVO) == 0) {
			return false;
		}
		return true;
	}

	@Override
	public boolean delete(String mvId) {
		int resCnt = mvDAO.deleteMv(mvId);
		resCnt += mvGnrDAO.deleteMvGnr(mvId);
		resCnt += prdcLocDAO.deletePrdcLoc(mvId);
		resCnt += prdcPrtcptnCmpnyDAO.deletePrdcPrtcptnCmpny(mvId);
		resCnt += prdcPrtcptnPplDAO.deletePrdcPrtcptnPpl(mvId);
		
		return resCnt > 0;
	}

}
