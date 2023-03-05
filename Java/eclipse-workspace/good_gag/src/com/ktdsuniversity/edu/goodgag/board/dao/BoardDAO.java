package com.ktdsuniversity.edu.goodgag.board.dao;

import java.util.List;

import com.ktdsuniversity.edu.goodgag.board.vo.BoardVO;

public interface BoardDAO {
	public int create(BoardVO boardVO);

	/**
	 * 게시글 하나를 조회
	 * 
	 * @param boardID 게시글 PK
	 * @return 게시글 정보
	 */
	public BoardVO read(String boardID);

	/**
	 * 모든 게시글의 목록을 조회
	 * 
	 * @return 게시글 목록
	 */
	public List<BoardVO> readAll();

	public int update(BoardVO boardVO);

	public int delete(String boardID);

	/**
	 * 게시글의 새로운 PK값을 조회한다.
	 * 
	 * @param boardVO 새로운 PK값을 넣을 객체
	 * @return 만약 새로운 인스턴스를 생성하여 반환하고 싶을 경우 BoardVO 리턴
	 */
	public String createNewBoardID();
	
	public String readRecommend(String boardID, String email);

	public int addRecommend(String boardID, String email, boolean recommend);
	public int deleteRecommend(String boardID, String email);
	public int updateRecommend(String boardID, String email, boolean recommend);

}
