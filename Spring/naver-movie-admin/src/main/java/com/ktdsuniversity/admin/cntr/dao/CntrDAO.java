package com.ktdsuniversity.admin.cntr.dao;

import java.util.List;

import com.ktdsuniversity.admin.cntr.vo.CntrVO;

public interface CntrDAO {

	public int createOneCntr(CntrVO cntrVO);
	
	public List<CntrVO> readAllCntr(String cntrNm);
	
	public int updateOneCntr(CntrVO cntrVO);
	
	public int deleteOneCntr(int cntrId);
}
