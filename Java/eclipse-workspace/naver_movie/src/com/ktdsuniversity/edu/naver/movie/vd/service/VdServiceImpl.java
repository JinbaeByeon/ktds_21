package com.ktdsuniversity.edu.naver.movie.vd.service;

import java.util.List;

import com.ktdsuniversity.edu.naver.movie.vd.dao.VdDAO;
import com.ktdsuniversity.edu.naver.movie.vd.dao.VdDAOImpl;
import com.ktdsuniversity.edu.naver.movie.vd.vo.VdVO;

public class VdServiceImpl implements VdService {
	private VdDAO vdDAO;
	public VdServiceImpl() {
		vdDAO = new VdDAOImpl();
	}
	@Override
	public boolean createVd(VdVO vdVO) {
		return vdDAO.createVd(vdVO) > 0;
	}

	@Override
	public VdVO readVd(String vdID) {
		return vdDAO.readVd(vdID);
	}

	@Override
	public List<VdVO> readAllVd() {
		return vdDAO.readAllVd();
	}

	@Override
	public boolean updateVd(VdVO vdVO) {
		return vdDAO.updateVd(vdVO) > 0;
	}

	@Override
	public boolean deleteVd(String vdID) {
		return vdDAO.deleteVd(vdID) > 0;
	}

}
