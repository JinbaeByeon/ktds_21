package com.ktdsuniversity.edu.goodgag.board.service;

import java.util.List;

import com.ktdsuniversity.edu.goodgag.board.vo.BoardVO;

public interface BoardService {
	public boolean create(BoardVO boardVO);

	public BoardVO read(String boardID);
	public List<BoardVO> readAll();

	public boolean update(BoardVO boardVO);

	public boolean delete(BoardVO boardVO);
}
