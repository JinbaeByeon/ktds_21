package com.ktdsuniversity.edu.naver.movie.mvppl.service;

import java.util.List;

import com.ktdsuniversity.edu.naver.movie.mvppl.dao.MvPplDAO;
import com.ktdsuniversity.edu.naver.movie.mvppl.dao.MvPplDAOImpl;
import com.ktdsuniversity.edu.naver.movie.mvppl.vo.MvPplVO;

public class MvPplServiceImpl implements MvPplService {
	private MvPplDAO mvPplDAO;
	public MvPplServiceImpl() {
		mvPplDAO = new MvPplDAOImpl();
	}
	@Override
	public boolean create(MvPplVO mvPplVO) {
		return mvPplDAO.createMvPpl(mvPplVO) > 0;
	}

	@Override
	public MvPplVO read(String mvPplID) {
		return mvPplDAO.readMvPpl(mvPplID);
	}

	@Override
	public List<MvPplVO> readAll() {
		return mvPplDAO.readAllMvPpl();
	}

	@Override
	public boolean update(MvPplVO mvPplVO) {
		return mvPplDAO.updateMvPpl(mvPplVO) > 0;
	}

	@Override
	public boolean delete(String mvPplID) {
		return mvPplDAO.deleteMvPpl(mvPplID) > 0;
	}

}
