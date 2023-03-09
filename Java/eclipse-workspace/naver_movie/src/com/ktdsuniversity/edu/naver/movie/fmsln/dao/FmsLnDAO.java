package com.ktdsuniversity.edu.naver.movie.fmsln.dao;

import java.util.List;

import com.ktdsuniversity.edu.naver.movie.fmsln.vo.FmsLnVO;

public interface FmsLnDAO {

	public int createFmsLn(FmsLnVO fmsLnVO);

	public FmsLnVO readFmsLn(String fmsLnId);

	public List<FmsLnVO> readAllFmsLn();

	public int updateFmsLn(FmsLnVO fmsLnVO);

	public int deleteFmsLn(String fmsLnId);
}
