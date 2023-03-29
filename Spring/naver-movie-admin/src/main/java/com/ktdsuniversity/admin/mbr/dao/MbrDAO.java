package com.ktdsuniversity.admin.mbr.dao;

import java.util.List;

import com.ktdsuniversity.admin.mbr.vo.MbrVO;

public interface MbrDAO {
	public int createMember(MbrVO mbrVO);
	
	public MbrVO readOneMemberById(String mbrId);
	
	public MbrVO readOneMemberByIdAndPwd(MbrVO mbrVO);

	public List<MbrVO> readAllMembers();
	
	public int updateMember(MbrVO mbrVO);
	
	public int deleteMember(String mbrId);
}
