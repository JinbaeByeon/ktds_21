package com.ktdsuniversity.edu.naver.movie.mv.service;

import java.util.List;

import com.ktdsuniversity.edu.naver.movie.mv.vo.MvVO;

public interface MvService {

	/**
	 * 새로운 영화 생성
	 * 
	 * @param mvVO (영화의 정보)
	 * @return 생성 여부
	 */
	public boolean createMv(MvVO mvVO);

	/**
	 * 하나의 영화 조회
	 * 
	 * @param mvId (조회할 영화의 PK)
	 * @return 조회한 영화의 정보
	 */
	public MvVO readMv(String mvId);

	/**
	 * 모든 영화 조회
	 * 
	 * @return 모든 영화의 목록
	 */
	public List<MvVO> readAllMv();

	/**
	 * 영화 데이터를 변경한다
	 * 
	 * @param mvVO (mvId: 변경대상 pk, mvNm: 영화의 새로운 이름)
	 * @return 변경 여부
	 */
	public boolean updateMv(MvVO mvVO);

	/**
	 * 영화 데이터 삭제
	 * 
	 * @param mvId (삭제대상 pk)
	 * @return 삭제 여부
	 */
	public boolean deleteMv(String mvId);

}
