package com.ktdsuniversity.edu.naver.movie.mvppl.service;

import java.util.List;

import com.ktdsuniversity.edu.naver.movie.mvppl.vo.MvPplVO;

public interface MvPplService {
	/**
	 * 새로운 영화인 생성
	 * 
	 * @param mvPplVO (영화인의 정보)
	 * @return 생성 여부
	 */
	public boolean createMvPpl(MvPplVO mvPplVO);

	/**
	 * 하나의 영화인 조회
	 * 
	 * @param mvPplId (조회할 영화인의 PK)
	 * @return 조회한 영화인의 정보
	 */
	public MvPplVO readMvPpl(String mvPplId);

	/**
	 * 모든 영화인 조회
	 * 
	 * @return 모든 영화인의 목록
	 */
	public List<MvPplVO> readAllMvPpl();

	/**
	 * 영화인 데이터를 변경한다
	 * 
	 * @param mvPplVO (mvPplId: 변경대상 pk, mvPplNm: 영화인의 새로운 이름)
	 * @return 변경 여부
	 */
	public boolean updateMvPpl(MvPplVO mvPplVO);

	/**
	 * 영화인 데이터 삭제
	 * 
	 * @param mvPplId (삭제대상 pk)
	 * @return 삭제 여부
	 */
	public boolean deleteMvPpl(String mvPplId);


}
