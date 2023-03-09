package com.ktdsuniversity.edu.naver.movie.pctr.dao;

import java.util.List;

import com.ktdsuniversity.edu.naver.movie.pctr.vo.PctrVO;

public interface PctrDAO {
	/**
	 * 새로운 사진 생성
	 * 
	 * @param pctrVO (사진의 정보)
	 * @return 생성된 사진의 수
	 */
	public int createPctr(PctrVO pctrVO);

	/**
	 * 하나의 사진 조회
	 * 
	 * @param pctrId (조회할 사진의 PK)
	 * @return 조회한 사진의 정보
	 */
	public PctrVO readPctr(String pctrId);

	/**
	 * 모든 사진 조회
	 * 
	 * @return 모든 사진의 목록
	 */
	public List<PctrVO> readAllPctr();

	/**
	 * 사진 데이터를 변경한다
	 * 
	 * @param pctrVO (pctrId: 변경대상 pk, pctrNm: 사진의 새로운 이름)
	 * @return 변경된 사진의 수
	 */
	public int updatePctr(PctrVO pctrVO);

	/**
	 * 사진 데이터 삭제
	 * 
	 * @param pctrId (삭제대상 pk)
	 * @return 삭제된 사진의 수
	 */
	public int deletePctr(String pctrId);
}
