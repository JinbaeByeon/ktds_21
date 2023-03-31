package com.ktdsuniversity.admin.mbr.service;

import java.util.List;

import com.ktdsuniversity.admin.mbr.vo.MbrVO;
import com.ktdsuniversity.admin.mbrlgnhist.vo.MbrLgnHistVO;

public interface MbrService {
	public boolean createNewAdminMbr(MbrVO mbrVO);

	public int readCountMbrById(String mbrId);
	
	public MbrVO readOneMemberById(String mbrId);

	public MbrVO readOneMemberByIdAndPwd(MbrVO mbrVO);
	
	public List<MbrVO> readAllMembers();
	
	public boolean updateOneNewAdminMbr(MbrVO mbrVO);
	
	public boolean deleteOneNewAdminMbr(String mbrId);
	
	public boolean createLogoutHistory(MbrLgnHistVO lgnHistVO);
}
