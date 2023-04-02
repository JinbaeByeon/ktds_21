package com.ktdsuniversity.admin.cmpny.dao;

import java.util.List;

import com.ktdsuniversity.admin.cmpny.vo.CmpnyVO;

public interface CmpnyDAO {

	public int createOneCmpny(CmpnyVO cmpnyVO);
	
	public List<CmpnyVO> readAllCmpny(String cmpnyNm);
	
	public int updateOneCmpny(CmpnyVO cmpnyVO);
	
	public int deleteOneCmpny(String cmpnyId);
}
