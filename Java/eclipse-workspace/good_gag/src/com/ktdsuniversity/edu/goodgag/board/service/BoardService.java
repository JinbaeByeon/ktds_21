package com.ktdsuniversity.edu.goodgag.board.service;

import java.util.List;

import com.ktdsuniversity.edu.goodgag.board.vo.BoardVO;
import com.ktdsuniversity.edu.goodgag.member.vo.MemberVO;

public interface BoardService {
	public boolean create(BoardVO boardVO);

	public BoardVO read(String boardID);
	public List<BoardVO> readAll();

	public boolean update(BoardVO boardVO);

	public boolean delete(String boardID);

	/**
	 * 게시글에 회원이 추천 혹은 비추천을 한다
	 * @param boardVO 추천을 받는 게시글
	 * @param memberVO 추천을 하는 회원
	 * @param recommend 추천 or 비추천
	 * @return recommend가 반영될 경우 true, 반영되지 않을 경우(추천이나 비추천 중복) false
	 */
	public boolean recommend(BoardVO boardVO, MemberVO memberVO, boolean recommend);

}
