package com.ktdsuniversity.edu.naver.movie.pctr.service;

import java.util.List;

import com.ktdsuniversity.edu.naver.movie.pctr.dao.PctrDAO;
import com.ktdsuniversity.edu.naver.movie.pctr.dao.PctrDAOImpl;
import com.ktdsuniversity.edu.naver.movie.pctr.vo.PctrVO;

public class PctrServiceImpl implements PctrService {
	PctrDAO pctrDAO;
	public PctrServiceImpl() {
		pctrDAO = new PctrDAOImpl();
	}
	@Override
	public boolean createPctr(PctrVO pctrVO) {
		return pctrDAO.createPctr(pctrVO) > 0;
	}

	@Override
	public PctrVO readPctr(String pctrID) {
		return pctrDAO.readPctr(pctrID);
	}

	@Override
	public List<PctrVO> readAllPctr() {
		return pctrDAO.readAllPctr();
	}

	@Override
	public boolean updatePctr(PctrVO pctrVO) {
		return pctrDAO.updatePctr(pctrVO) > 0;
	}

	@Override
	public boolean deletePctr(String pctrID) {
		return pctrDAO.deletePctr(pctrID) > 0;
	}

}
