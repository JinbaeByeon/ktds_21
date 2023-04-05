package com.ktdsuniversity.admin.mvppl.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ktdsuniversity.admin.mvppl.vo.MvPplVO;

public interface MvPplService {
	public boolean createOneMvPpl(MvPplVO mvPplVO, MultipartFile filePrflPctr);
		
	public List<MvPplVO> readAllMvPpl(MvPplVO mvPplVO);
	
	public boolean updateOneMvPpl(MvPplVO mvPplVO, MultipartFile filePrflPctr);

	public boolean deleteOneMvPplByMvPplId(String mvPplId);

	public boolean deleteMvPplByMvPplIdList(List<String> mvPplIdList);
}
