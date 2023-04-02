package com.ktdsuniversity.admin.cmpny.service;

import java.util.List;

import com.ktdsuniversity.admin.cmpny.vo.CmpnyVO;

public interface CmpnyService {

	public boolean createOneCmpny(CmpnyVO cmpnyVO);
	
	public List<CmpnyVO> readAllCmpny(String cmpnyNm);
	
	public boolean updateOneCmpny(CmpnyVO cmpnyVO);
	
	public boolean deleteOneCmpny(String cmpnyId);

}
