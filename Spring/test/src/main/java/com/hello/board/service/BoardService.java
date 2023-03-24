package com.hello.board.service;

import java.util.List;

import com.hello.board.vo.BoardVO;

public interface BoardService {

	public boolean createBoard(BoardVO boardVO);
	
	public BoardVO readOneBoard(int id);
	
	public List<BoardVO> readAllBoards();
	
	public boolean updateBoard(BoardVO boardVO);
	
	public boolean deleteBoard(int id);

}
