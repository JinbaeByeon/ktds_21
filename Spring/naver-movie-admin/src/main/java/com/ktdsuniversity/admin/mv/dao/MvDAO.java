package com.ktdsuniversity.admin.mv.dao;

import java.util.List;

import com.ktdsuniversity.admin.mv.vo.MvVO;

public interface MvDAO {

	public int createNewMv(MvVO mvVO);

	public MvVO readOneMvByMvId(String mvId);
	public List<MvVO> readAllMv(MvVO mvVO);

	public int updateOneMv(MvVO mvVO);
	
	public int deleteOneMv(String mvId);
	
	public int deleteMvByMvIdList(List<String> mvIdList);
}
