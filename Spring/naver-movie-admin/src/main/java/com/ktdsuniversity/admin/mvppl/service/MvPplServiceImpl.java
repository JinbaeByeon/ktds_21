package com.ktdsuniversity.admin.mvppl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktdsuniversity.admin.mvppl.dao.MvPplDAO;
import com.ktdsuniversity.admin.mvppl.vo.MvPplVO;

@Service
public class MvPplServiceImpl implements MvPplService {

	@Autowired
	private MvPplDAO mvPplDAO;
	
	@Override
	public boolean createOneMvPpl(MvPplVO mvPplVO) {
		return mvPplDAO.createOneMvPpl(mvPplVO) > 0;
	}


	@Override
	public List<MvPplVO> readAllMvPpl(String nm) {
		return mvPplDAO.readAllMvPpl(nm);
	}

	@Override
	public boolean updateOneMvPpl(MvPplVO mvPplVO) {
		return mvPplDAO.updateOneMvPpl(mvPplVO) > 0;
	}

	@Override
	public boolean deleteOneMvPpl(String mvPplId) {
		return mvPplDAO.deleteOneMvPpl(mvPplId) > 0;
	}

}
