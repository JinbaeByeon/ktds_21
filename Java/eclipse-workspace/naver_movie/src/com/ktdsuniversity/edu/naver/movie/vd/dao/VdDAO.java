package com.ktdsuniversity.edu.naver.movie.vd.dao;

import java.util.List;

import com.ktdsuniversity.edu.naver.movie.vd.vo.VdVO;

public interface VdDAO {
	/**
	 * 새로운 동영상 생성
	 * 
	 * @param vdVO (동영상의 정보)
	 * @return 생성된 동영상의 수
	 */
	public int createVd(VdVO vdVO);

	/**
	 * 하나의 동영상 조회
	 * 
	 * @param vdId (조회할 동영상의 PK)
	 * @return 조회한 동영상의 정보
	 */
	public VdVO readVd(String vdId);

	/**
	 * 모든 동영상 조회
	 * 
	 * @return 모든 동영상의 목록
	 */
	public List<VdVO> readAllVd();

	/**
	 * 동영상 데이터를 변경한다
	 * 
	 * @param vdVO (vdId: 변경대상 pk, vdNm: 동영상의 새로운 이름)
	 * @return 변경된 동영상의 수
	 */
	public int updateVd(VdVO vdVO);

	/**
	 * 동영상 데이터 삭제
	 * 
	 * @param vdId (삭제대상 pk)
	 * @return 삭제된 동영상의 수
	 */
	public int deleteVd(String vdId);
}
