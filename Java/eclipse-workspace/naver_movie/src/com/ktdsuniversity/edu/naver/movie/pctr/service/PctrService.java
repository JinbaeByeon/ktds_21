package com.ktdsuniversity.edu.naver.movie.pctr.service;

import java.util.List;

import com.ktdsuniversity.edu.naver.movie.pctr.vo.PctrVO;

public interface PctrService {
	/**
	 * 새로운 영화인 생성
	 * 
	 * @param pctrVO (영화인의 정보)
	 * @return 생성 여부
	 */
	public boolean createPctr(PctrVO pctrVO);

	/**
	 * 하나의 영화인 조회
	 * 
	 * @param pctrId (조회할 영화인의 PK)
	 * @return 조회한 영화인의 정보
	 */
	public PctrVO readPctr(String pctrId);

	/**
	 * 모든 영화인 조회
	 * 
	 * @return 모든 영화인의 목록
	 */
	public List<PctrVO> readAllPctr();

	/**
	 * 영화인 데이터를 변경한다
	 * 
	 * @param pctrVO (pctrId: 변경대상 pk, pctrNm: 영화인의 새로운 이름)
	 * @return 변경 여부
	 */
	public boolean updatePctr(PctrVO pctrVO);

	/**
	 * 영화인 데이터 삭제
	 * 
	 * @param pctrId (삭제대상 pk)
	 * @return 삭제 여부
	 */
	public boolean deletePctr(String pctrId);


}
