package com.ktdsuniversity.edu.naver.movie.vd.service;

import java.util.List;

import com.ktdsuniversity.edu.naver.movie.vd.vo.VdVO;

public interface VdService {
	/**
	 * 새로운 영화인 생성
	 * 
	 * @param vdVO (영화인의 정보)
	 * @return 생성 여부
	 */
	public boolean createVd(VdVO vdVO);

	/**
	 * 하나의 영화인 조회
	 * 
	 * @param vdId (조회할 영화인의 PK)
	 * @return 조회한 영화인의 정보
	 */
	public VdVO readVd(String vdId);

	/**
	 * 모든 영화인 조회
	 * 
	 * @return 모든 영화인의 목록
	 */
	public List<VdVO> readAllVd();

	/**
	 * 영화인 데이터를 변경한다
	 * 
	 * @param vdVO (vdId: 변경대상 pk, vdNm: 영화인의 새로운 이름)
	 * @return 변경 여부
	 */
	public boolean updateVd(VdVO vdVO);

	/**
	 * 영화인 데이터 삭제
	 * 
	 * @param vdId (삭제대상 pk)
	 * @return 삭제 여부
	 */
	public boolean deleteVd(String vdId);


}
