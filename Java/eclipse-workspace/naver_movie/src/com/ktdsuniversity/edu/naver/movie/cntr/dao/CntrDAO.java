package com.ktdsuniversity.edu.naver.movie.cntr.dao;

import java.util.List;

import com.ktdsuniversity.edu.naver.movie.cntr.vo.CntrVO;

public interface CntrDAO {
	/**
	 * 새로운 국가 생성
	 * @param cntrVO (국가의 정보)
	 * @return 생성된 국가의 수
	 */
	public int createCntr(CntrVO cntrVO);

	/**
	 * 하나의 국가 조회
	 * @param cntrId (조회할 국가의 PK)
	 * @return 조회한 국가의 정보
	 */
	public CntrVO readCntr(int cntrId);

	/**
	 * 모든 국가 조회
	 * @return 모든 국가의 목록
	 */
	public List<CntrVO> readAllCntr();
	
	/**
	 * 국가 데이터를 변경한다
	 * @param cntrVO (cntrId: 변경대상 pk, cntrNm: 국가의 새로운 이름)
	 * @return 변경된 국가의 수
	 */
	public int updateCntr(CntrVO cntrVO);

	/**
	 * 국가 데이터 삭제
	 * @param cntrId (삭제대상 pk)
	 * @return 삭제된 국가의 수
	 */
	public int deleteCntr(int cntrId);
}
