package com.ktdsuniversity.admin.cntr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktdsuniversity.admin.cntr.dao.CntrDAO;
import com.ktdsuniversity.admin.cntr.vo.CntrVO;

@Service
public class CntrServiceImpl implements CntrService{

	@Autowired
	private CntrDAO cntrDAO;
	
	@Override
	public boolean createOneCntr(CntrVO cntrVO) {
		return cntrDAO.createOneCntr(cntrVO) > 0;
	}

	@Override
	public List<CntrVO> readAllCntr(String cntrNm) {
		return cntrDAO.readAllCntr(cntrNm);
	}

	@Override
	public boolean updateOneCntr(CntrVO cntrVO) {
		return cntrDAO.updateOneCntr(cntrVO) > 0;
	}

	@Override
	public boolean deleteOneCntrById(int cntrId) {
		return cntrDAO.deleteOneCntr(cntrId) > 0;
	}
	
}
