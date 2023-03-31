package com.ktdsuniversity.admin.mbr.dao;

import java.util.List;

import com.ktdsuniversity.admin.mbr.vo.MbrVO;

public interface MbrDAO {
	public int createNewAdminMbr(MbrVO mbrVO);
	
	public int readCountMbrById(String mbrId);	
	public String readSaltById(String mbrId);
	public String readLgnBlockYnById(String mbrId);
	
	public MbrVO readOneMemberById(String mbrId);	
	public MbrVO readOneMemberByIdAndPwd(MbrVO mbrVO);
	public List<MbrVO> readAllMembers();
	
	public int updateMbrLgnSucc(MbrVO mbrVO);
	public int updateMbrLgnFail(String mbrId);
	public int updateMbrLgnBlock(String mbrId);
	public int updateOneNewAdminMbr(MbrVO mbrVO);
	
	public int deleteOneNewAdminMbr(String mbrId);
}
