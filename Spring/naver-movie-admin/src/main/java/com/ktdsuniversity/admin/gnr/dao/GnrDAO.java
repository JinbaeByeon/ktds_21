package com.ktdsuniversity.admin.gnr.dao;

import java.util.List;

import com.ktdsuniversity.admin.gnr.vo.GnrVO;

public interface GnrDAO {
	public List<GnrVO> readAllGnr(GnrVO gnrVO);
	public int createOneGnr(GnrVO gnrVO);
	public int updateOneGnr(GnrVO gnrVO);
	public int deleteOntGnrByGnrId(int gnrId);
	public int deleteGnrByGnrIdList(List<Integer> gnrIdList);
}
