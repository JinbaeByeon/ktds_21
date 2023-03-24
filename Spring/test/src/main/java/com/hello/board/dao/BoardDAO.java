package com.hello.board.dao;

import java.util.List;

import com.hello.board.vo.BoardVO;

public interface BoardDAO {

	public int createBoard(BoardVO boardVO);
	
	public BoardVO readOneBoard(int id);
	
	public List<BoardVO> readAllBoards();
	
	public int updateBoard(BoardVO boardVO);
	
	public int deleteBoard(int id);

	public List<BoardVO> readAllBoardsByEmail(String email);
}
