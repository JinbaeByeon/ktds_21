package com.ktdsuniversity.edu.goodgag.board.service;

import java.util.List;

import com.ktdsuniversity.edu.goodgag.board.dao.BoardDAO;
import com.ktdsuniversity.edu.goodgag.board.dao.BoardDAOImpl;
import com.ktdsuniversity.edu.goodgag.board.vo.BoardVO;

public class BoardServiceImpl implements BoardService {
	private BoardDAO boardDAO;
	
	public BoardServiceImpl() {
		boardDAO = new BoardDAOImpl();
	}
	
	@Override
	public boolean create(BoardVO boardVO) {
		boardVO.setBoardID(boardDAO.createNewBoardID());
		return boardDAO.create(boardVO) > 0;
	}

	@Override
	public BoardVO read(String boardID) {
		BoardVO boardVO = boardDAO.read(boardID);
		return boardVO;
	}

	@Override
	public List<BoardVO> readAll() {
		List<BoardVO> boardList = boardDAO.readAll();
		return boardList;
	}

	@Override
	public boolean update(BoardVO boardVO) {
		BoardVO targetVO = boardDAO.read(boardVO.getBoardID());
		return boardDAO.update(boardVO) > 0;
	}

	@Override
	public boolean delete(BoardVO boardVO) {
		return boardDAO.delete(boardVO) > 0;
	}

}
