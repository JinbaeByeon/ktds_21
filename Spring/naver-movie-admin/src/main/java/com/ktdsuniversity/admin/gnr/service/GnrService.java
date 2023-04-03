package com.ktdsuniversity.admin.gnr.service;

import java.util.List;

import com.ktdsuniversity.admin.gnr.vo.GnrVO;

public interface GnrService {
	public List<GnrVO> readAllGnr(GnrVO gnrVO);
	public boolean createOneGnr(GnrVO gnrVO);
	public boolean updateOneGnr(GnrVO gnrVO);
	public boolean deleteOntGnrByGnrId(int gnrId);
	public boolean deleteGnrByGnrIdList(List<Integer> gnrIdList);
}
