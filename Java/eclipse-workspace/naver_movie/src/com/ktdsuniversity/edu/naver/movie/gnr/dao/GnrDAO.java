package com.ktdsuniversity.edu.naver.movie.gnr.dao;

import java.util.List;

import com.ktdsuniversity.edu.naver.movie.gnr.vo.GnrVO;

/**
 * GNR 테이블과 연동하기 위한 DAO
 * @author User
 */
public interface GnrDAO {
	/**
	 * 새로운 장르 생성
	 * @param gnrVO (장르의 정보)
	 * @return 생성된 장르의 수
	 */
	public int createGnr(GnrVO gnrVO);

	/**
	 * 하나의 장르 조회
	 * @param gnrId (조회할 장르의 PK)
	 * @return 조회한 장르의 정보
	 */
	public GnrVO readGnr(int gnrId);

	/**
	 * 장르 이름을 통한 장르 조회
	 * @param gnrName (장르 이름)
	 * @return
	 */
	public GnrVO readGnrByName(String gnrName);
	/**
	 * 모든 장르 조회
	 * @return 모든 장르의 목록
	 */
	public List<GnrVO> readAllGnr();
	
	/**
	 * 장르 데이터를 변경한다
	 * @param gnrVO (gnrId: 변경대상 pk, gnrNm: 장르의 새로운 이름)
	 * @return 변경된 장르의 수
	 */
	public int updateGnr(GnrVO gnrVO);

	/**
	 * 장르 데이터 삭제
	 * @param gnrId (삭제대상 pk)
	 * @return 삭제된 장르의 수
	 */
	public int deleteGnr(int gnrId);

}