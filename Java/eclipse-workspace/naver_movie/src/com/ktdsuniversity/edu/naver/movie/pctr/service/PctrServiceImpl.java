package com.ktdsuniversity.edu.naver.movie.pctr.service;

import java.util.List;

import com.ktdsuniversity.edu.naver.movie.pctr.dao.PctrDAO;
import com.ktdsuniversity.edu.naver.movie.pctr.dao.PctrDAOImpl;
import com.ktdsuniversity.edu.naver.movie.pctr.vo.PctrVO;

public class PctrServiceImpl implements PctrService {
	private PctrDAO pctrDAO;
	public PctrServiceImpl() {
		pctrDAO = new PctrDAOImpl();
	}
	@Override
	public boolean create(PctrVO pctrVO) {
		return pctrDAO.createPctr(pctrVO) > 0;
	}

	@Override
	public PctrVO read(String pctrID) {
		return pctrDAO.readPctr(pctrID);
	}

	@Override
	public List<PctrVO> readAll() {
		return pctrDAO.readAllPctr();
	}

	@Override
	public boolean update(PctrVO pctrVO) {
		return pctrDAO.updatePctr(pctrVO) > 0;
	}

	@Override
	public boolean delete(String pctrID) {
		return pctrDAO.deletePctr(pctrID) > 0;
	}

}
