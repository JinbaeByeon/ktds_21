package com.ktdsuniversity.edu.naver.movie.fmsln.service;

import java.util.List;

import com.ktdsuniversity.edu.naver.movie.fmsln.dao.FmsLnDAO;
import com.ktdsuniversity.edu.naver.movie.fmsln.dao.FmsLnDAOImpl;
import com.ktdsuniversity.edu.naver.movie.fmsln.vo.FmsLnVO;

public class FmsLnServiceImpl implements FmsLnService {
	private FmsLnDAO fmsLnDAO;
	
	public FmsLnServiceImpl() {
		fmsLnDAO = new FmsLnDAOImpl();
	}
	@Override
	public boolean create(FmsLnVO fmsLnVO) {
		return fmsLnDAO.createFmsLn(fmsLnVO) > 0;
	}

	@Override
	public FmsLnVO read(String fmsLnId) {
		return fmsLnDAO.readFmsLn(fmsLnId);
	}

	@Override
	public List<FmsLnVO> readAll() {
		return fmsLnDAO.readAllFmsLn();
	}

	@Override
	public boolean update(FmsLnVO fmsLnVO) {
		return fmsLnDAO.updateFmsLn(fmsLnVO) > 0;
	}

	@Override
	public boolean delete(String fmsLnId) {
		return fmsLnDAO.deleteFmsLn(fmsLnId) > 0;
	}

}
