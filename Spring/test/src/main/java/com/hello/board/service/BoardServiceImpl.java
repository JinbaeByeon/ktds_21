package com.hello.board.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hello.board.dao.BoardDAO;
import com.hello.board.vo.BoardVO;

@Service
public class BoardServiceImpl extends SqlSessionDaoSupport implements BoardService {

	@Autowired
	private BoardDAO boardDAO;
	
	@Autowired
	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}
	@Override
	public boolean createBoard(BoardVO boardVO) {
		return boardDAO.createBoard(boardVO) > 0;
	}

	@Override
	public BoardVO readOneBoard(int id) {
		return boardDAO.readOneBoard(id);
	}

	@Override
	public List<BoardVO> readAllBoards() {
		return boardDAO.readAllBoards();
	}

	@Override
	public boolean updateBoard(BoardVO boardVO) {
		return boardDAO.updateBoard(boardVO) > 0;
	}

	@Override
	public boolean deleteBoard(int id) {
		return boardDAO.deleteBoard(id) > 0;
	}

}
