package com.ktdsuniversity.admin.mbr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktdsuniversity.admin.mbr.dao.MbrDAO;
import com.ktdsuniversity.admin.mbr.vo.MbrVO;

@Service
public class MbrServiceImpl implements MbrService {

	@Autowired
	private MbrDAO mbrDAO;
	
	@Override
	public boolean createMember(MbrVO mbrVO) {
		return mbrDAO.createMember(mbrVO) > 0;
	}

	@Override
	public MbrVO readOneMemberById(String mbrId) {
		return mbrDAO.readOneMemberById(mbrId);
	}

	@Override
	public List<MbrVO> readAllMembers() {
		return mbrDAO.readAllMembers();
	}

	@Override
	public boolean updateMember(MbrVO mbrVO) {
		return mbrDAO.updateMember(mbrVO) > 0;
	}

	@Override
	public boolean deleteMember(String mbrId) {
		return mbrDAO.deleteMember(mbrId) > 0;
	}

	@Override
	public MbrVO readOneMemberByIdAndPwd(MbrVO mbrVO) {
		return mbrDAO.readOneMemberByIdAndPwd(mbrVO);
	}

}
