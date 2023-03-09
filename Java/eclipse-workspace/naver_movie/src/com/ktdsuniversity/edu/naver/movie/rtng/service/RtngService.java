package com.ktdsuniversity.edu.naver.movie.rtng.service;

import java.util.List;
import com.ktdsuniversity.edu.naver.movie.rtng.vo.RtngVO;

public interface RtngService {

	public boolean createRtng(RtngVO rtngVO);

	public RtngVO readRtng(String rtngId);

	public List<RtngVO> readAllRtng();

	public boolean updateRtng(RtngVO rtngVO);

	public boolean deleteRtng(String rtngId);
}
