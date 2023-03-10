package com.ktdsuniversity.edu.naver.movie.cmncd.dao;

import java.util.List;

import com.ktdsuniversity.edu.naver.movie.cmncd.vo.CmnCdVO;

public interface CmnCdDAO {
	/**
	 * 새로운 공통코드 생성
	 * @param cmnCdVO (공통코드의 정보)
	 * @return 생성된 공통코드의 수
	 */
	public int createCmnCd(CmnCdVO cmnCdVO);

	/**
	 * 하나의 공통코드 조회
	 * @param cmnCdId (조회할 공통코드의 PK)
	 * @return 조회한 공통코드의 정보
	 */
	public CmnCdVO readCmnCd(String cmnCdId);

	/**
	 * 모든 공통코드 조회
	 * @return 모든 공통코드의 목록
	 */
	public List<CmnCdVO> readAllCmnCd();
	
	/**
	 * 공통코드 데이터를 변경한다
	 * @param cmnCdVO (cmnCdId: 변경대상 pk, cdNm: 공통코드의 새로운 이름)
	 * @return 변경된 공통코드의 수
	 */
	public int updateCmnCd(CmnCdVO cmnCdVO);

	/**
	 * 공통코드 데이터 삭제
	 * @param cmnCdId (삭제대상 pk)
	 * @return 삭제된 공통코드의 수
	 */
	public int deleteCmnCd(String cmnCdId);
}
