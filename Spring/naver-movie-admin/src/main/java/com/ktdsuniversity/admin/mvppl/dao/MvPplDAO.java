package com.ktdsuniversity.admin.mvppl.dao;

import java.util.List;

import com.ktdsuniversity.admin.mvppl.vo.MvPplVO;

public interface MvPplDAO {
	public int createOneMvPpl(MvPplVO mvPplVO);
	
	public List<MvPplVO> readAllMvPpl(MvPplVO mvPplVO);
	public MvPplVO readOneMvPplByMvPplId(String mvPplId);
	
	public int updateOneMvPpl(MvPplVO mvPplVO);

	public int deleteOneMvPplByMvPplId(String mvPplId);
	
	public int deleteMvPplByMvPplIdList(List<String> mvPplIdList);
}
