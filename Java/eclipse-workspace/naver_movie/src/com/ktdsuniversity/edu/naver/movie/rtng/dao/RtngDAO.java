package com.ktdsuniversity.edu.naver.movie.rtng.dao;

import java.util.List;

import com.ktdsuniversity.edu.naver.movie.rtng.vo.RtngVO;

public interface RtngDAO {

	public int createRtng(RtngVO rtngVO);

	public RtngVO readRtng(String rtngId);

	public List<RtngVO> readAllRtng();

	public int updateRtng(RtngVO rtngVO);

	public int deleteRtng(String rtngId);
}
