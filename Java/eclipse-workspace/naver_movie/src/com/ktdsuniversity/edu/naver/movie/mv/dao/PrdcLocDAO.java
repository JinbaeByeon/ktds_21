package com.ktdsuniversity.edu.naver.movie.mv.dao;

import com.ktdsuniversity.edu.naver.movie.mv.vo.MvVO;

public interface PrdcLocDAO {
	/**
	 * 제작지 등록 (제작지의 순수한 정보만 등록)
	 * @param mvVO (제작지 테이블에서 가져오는 정보)
	 * @return 생성된 제작지의 수
	 */
	public int createPrdcLoc(MvVO mvVO);

	/**
	 * 제작지 데이터를 변경한다
	 * @param mvVO (mvVO : 수정할 제작지 데이터가 들어있는 VO)
	 * @return 변경된 제작지의 수
	 */
	public int updatePrdcLoc(MvVO mvVO);

	/**
	 * 제작지 데이터 삭제
	 * @param mvVO (mvVO : 삭제할 제작지 데이터가 들어있는 VO)
	 * @return 삭제된 제작지의 수
	 */
	public int deletePrdcLoc(String mvId);
}
