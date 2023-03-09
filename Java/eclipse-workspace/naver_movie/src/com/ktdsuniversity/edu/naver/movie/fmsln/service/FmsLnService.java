package com.ktdsuniversity.edu.naver.movie.fmsln.service;

import java.util.List;

import com.ktdsuniversity.edu.naver.movie.fmsln.vo.FmsLnVO;

public interface FmsLnService {

	public boolean createFmsLn(FmsLnVO fmsLnVO);

	public FmsLnVO readFmsLn(String fmsLnId);

	public List<FmsLnVO> readAllFmsLn();

	public boolean updateFmsLn(FmsLnVO fmsLnVO);

	public boolean deleteFmsLn(String fmsLnId);

}
