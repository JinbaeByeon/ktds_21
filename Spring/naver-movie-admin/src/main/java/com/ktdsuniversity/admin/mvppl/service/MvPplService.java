package com.ktdsuniversity.admin.mvppl.service;

import java.util.List;

import com.ktdsuniversity.admin.mvppl.vo.MvPplVO;

public interface MvPplService {
	public boolean createOneMvPpl(MvPplVO mvPplVO);
		
	public List<MvPplVO> readAllMvPpl(String nm);
	
	public boolean updateOneMvPpl(MvPplVO mvPplVO);

	public boolean deleteOneMvPpl(String mvPplId);

}
