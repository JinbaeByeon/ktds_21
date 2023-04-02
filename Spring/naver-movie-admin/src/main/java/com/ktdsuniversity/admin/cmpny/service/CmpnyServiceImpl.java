package com.ktdsuniversity.admin.cmpny.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktdsuniversity.admin.cmpny.dao.CmpnyDAO;
import com.ktdsuniversity.admin.cmpny.vo.CmpnyVO;

@Service
public class CmpnyServiceImpl implements CmpnyService {

	@Autowired
	private CmpnyDAO cmpnyDAO;
	
	@Override
	public boolean createOneCmpny(CmpnyVO cmpnyVO) {
		return cmpnyDAO.createOneCmpny(cmpnyVO) > 0;
	}

	@Override
	public List<CmpnyVO> readAllCmpny(String cmpnyNm) {
		return cmpnyDAO.readAllCmpny(cmpnyNm);
	}

	@Override
	public boolean updateOneCmpny(CmpnyVO cmpnyVO) {
		return cmpnyDAO.updateOneCmpny(cmpnyVO) > 0;
	}

	@Override
	public boolean deleteOneCmpny(String cmpnyId) {
		return cmpnyDAO.deleteOneCmpny(cmpnyId) > 0;
	}

}
