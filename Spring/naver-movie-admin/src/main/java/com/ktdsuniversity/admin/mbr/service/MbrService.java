package com.ktdsuniversity.admin.mbr.service;

import java.util.List;

import com.ktdsuniversity.admin.mbr.vo.MbrVO;

public interface MbrService {
	public boolean createMember(MbrVO mbrVO);
	
	public MbrVO readOneMemberById(String mbrId);

	public MbrVO readOneMemberByIdAndPwd(MbrVO mbrVO);
	
	public List<MbrVO> readAllMembers();
	
	public boolean updateMember(MbrVO mbrVO);
	
	public boolean deleteMember(String mbrId);
	
}
