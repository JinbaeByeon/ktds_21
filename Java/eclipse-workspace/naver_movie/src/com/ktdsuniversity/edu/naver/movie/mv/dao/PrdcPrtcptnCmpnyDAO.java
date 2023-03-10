package com.ktdsuniversity.edu.naver.movie.mv.dao;

import com.ktdsuniversity.edu.naver.movie.mv.vo.MvVO;

public interface PrdcPrtcptnCmpnyDAO {
	/**
	 * 제작참여사 등록
	 * @param mvVO (제작참여사 테이블에서 가져온 데이터를 담은 VO)
	 * @return 제작참여사 등록 건수
	 */
	public int createPrdcPrtcptnCmpny(MvVO mvVO);

	/**
	 * 제작참여사 데이터를 변경한다
	 * @param mvVO (mvVO : 수정할 제작참여사 데이터가 들어있는 VO)
	 * @return 변경된 제작참여사의 수
	 */
	public int updatePrdcPrtcptnCmpny(MvVO mvVO);

	/**
	 * 제작참여사 데이터 삭제
	 * @param mvVO (mvVO : 삭제할 제작참여사 데이터가 들어있는 VO)
	 * @return 삭제된 제작참여사의 수
	 */
	public int deletePrdcPrtcptnCmpny(String mvId);
}
