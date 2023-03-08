package com.ktdsuniversity.edu.naver.movie.mv.dao;

import java.util.List;

import com.ktdsuniversity.edu.naver.movie.mv.vo.MvVO;

public interface MvGnrDAO {
	/**
	 * 영화_장르 등록 (영화의 순수한 정보만 등록)
	 * @param mvVO (영화 테이블에서 가져오는 정보)
	 * @return 생성된 영화의 수
	 */
	public int createMvGnr(MvVO mvVO);

	/**
	 * 영화_장르 데이터를 변경한다
	 * @param mvVO (mvId: 변경대상 pk, mvNm: 영화의 새로운 이름)
	 * @return 변경된 영화의 수
	 */
	public int updateMvGnr(MvVO mvVO);

	/**
	 * 영화_장르 데이터 삭제
	 * @param mvId (삭제대상 pk)
	 * @return 삭제된 영화의 수
	 */
	public int deleteMvGnr(String mvId);


}
