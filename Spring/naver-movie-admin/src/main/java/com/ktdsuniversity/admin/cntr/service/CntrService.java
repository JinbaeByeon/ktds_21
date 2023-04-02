package com.ktdsuniversity.admin.cntr.service;

import java.util.List;

import com.ktdsuniversity.admin.cntr.vo.CntrVO;

public interface CntrService {

	public boolean createOneCntr(CntrVO cntrVO);
	
	public List<CntrVO> readAllCntr(String cntrNm);
	
	public boolean updateOneCntr(CntrVO cntrVO);
	
	public boolean deleteOneCntrById(int cntrId);

}
