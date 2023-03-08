package com.ktdsuniversity.edu.naver.movie.cmpny.service;

import java.util.List;

import com.ktdsuniversity.edu.naver.movie.cmpny.vo.CmpnyVO;

public interface CmpnyService {
	/**
	 * 새로운 회사 생성
	 * 
	 * @param cmpnyVO (회사의 정보)
	 * @return 생성 여부
	 */
	public boolean createCmpny(CmpnyVO cmpnyVO);

	/**
	 * 하나의 회사 조회
	 * 
	 * @param cmpnyId (조회할 회사의 PK)
	 * @return 조회한 회사의 정보
	 */
	public CmpnyVO readCmpny(String cmpnyId);

	/**
	 * 모든 회사 조회
	 * 
	 * @return 모든 회사의 목록
	 */
	public List<CmpnyVO> readAllCmpny();

	/**
	 * 회사 데이터를 변경한다
	 * 
	 * @param cmpnyVO (cmpnyId: 변경대상 pk, cmpnyNm: 회사의 새로운 이름)
	 * @return 변경 여부
	 */
	public boolean updateCmpny(CmpnyVO cmpnyVO);

	/**
	 * 회사 데이터 삭제
	 * 
	 * @param cmpnyId (삭제대상 pk)
	 * @return 삭제 여부
	 */
	public boolean deleteCmpny(String cmpnyId);
}
