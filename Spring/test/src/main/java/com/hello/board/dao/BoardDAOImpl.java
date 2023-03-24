package com.hello.board.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hello.board.vo.BoardVO;

@Repository
public class BoardDAOImpl extends SqlSessionDaoSupport implements BoardDAO {

	@Autowired
	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}
	
	@Override
	public int createBoard(BoardVO boardVO) {
		return getSqlSession().insert("Board.createBoard",boardVO);
	}

	@Override
	public BoardVO readOneBoard(int id) {
		return getSqlSession().selectOne("Board.readOneBoard",id);
	}

	@Override
	public List<BoardVO> readAllBoards() {
		return getSqlSession().selectList("Board.readAllBoards");
	}

	@Override
	public int updateBoard(BoardVO boardVO) {
		return getSqlSession().update("Board.updateBoard",boardVO);
	}

	@Override
	public int deleteBoard(int id) {
		return getSqlSession().delete("Board.deleteBoard",id);
	}

	@Override
	public List<BoardVO> readAllBoardsByEmail(String email) {
		return getSqlSession().selectList("Board.readAllBoardsByEmail",email);
	}

}
