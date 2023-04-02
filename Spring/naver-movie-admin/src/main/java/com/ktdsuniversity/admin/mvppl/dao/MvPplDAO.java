package com.ktdsuniversity.admin.mvppl.dao;

import java.util.List;

import com.ktdsuniversity.admin.mvppl.vo.MvPplVO;

public interface MvPplDAO {
	public int createOneMvPpl(MvPplVO mvPplVO);
	
	public List<MvPplVO> readAllMvPpl(String nm);
	
	public int updateOneMvPpl(MvPplVO mvPplVO);

	public int deleteOneMvPpl(String mvPplId);
}
