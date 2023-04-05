package com.ktdsuniversity.admin.cntr.dao;

import java.util.List;

import com.ktdsuniversity.admin.cntr.vo.CntrVO;

public interface CntrDAO {

	public int createOneCntr(CntrVO cntrVO);
	
	public List<CntrVO> readAllCntr(CntrVO cntrVO);
	
	public int updateOneCntr(CntrVO cntrVO);
	
	public int deleteOneCntrByCntrId(int cntrId);

	public int deleteCntrByCntrIdList(List<Integer> cntrId);
}
