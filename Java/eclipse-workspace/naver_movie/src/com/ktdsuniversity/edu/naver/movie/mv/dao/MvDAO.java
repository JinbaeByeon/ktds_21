package com.ktdsuniversity.edu.naver.movie.mv.dao;

import java.util.List;

import com.ktdsuniversity.edu.naver.movie.mv.vo.MvVO;

public interface MvDAO {
	/**
	 * 영화 등록 (영화의 순수한 정보만 등록)
	 * @param mvVO (영화 테이블에서 가져오는 정보)
	 * @return 생성된 영화의 수
	 */
	public int createMv(MvVO mvVO);

	/**
	 * 하나의 영화 조회
	 * @param mvId (조회할 영화의 PK)
	 * @return 조회한 영화의 정보
	 */
	public MvVO readMv(String mvId);

	/**
	 * 모든 영화 조회
	 * @return 모든 영화의 목록
	 */
	public List<MvVO> readAllMv();
	
	/**
	 * 영화 데이터를 변경한다
	 * @param mvVO (mvId: 변경대상 pk, mvNm: 영화의 새로운 이름)
	 * @return 변경된 영화의 수
	 */
	public int updateMv(MvVO mvVO);

	/**
	 * 영화 데이터 삭제
	 * @param mvId (삭제대상 pk)
	 * @return 삭제된 영화의 수
	 */
	public int deleteMv(String mvId);
	
	public String createNewMvId();
}
