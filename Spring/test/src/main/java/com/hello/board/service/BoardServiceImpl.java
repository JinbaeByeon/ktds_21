package com.hello.board.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.hello.board.dao.BoardDAO;
import com.hello.board.vo.BoardVO;
import com.hello.common.handler.UploadHandler;

@Service
public class BoardServiceImpl extends SqlSessionDaoSupport implements BoardService {

	@Autowired
	private BoardDAO boardDAO;

	@Autowired
	private UploadHandler uploadHandler;
	
	@Autowired
	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}
	
	@Override
	public boolean createBoard(BoardVO boardVO, List<MultipartFile> uploadFile) {
		boolean res = boardDAO.createBoard(boardVO) > 0;
		if(res) {
			uploadHandler.upload(uploadFile, boardVO.getId());
		}
		return  res;
	}

	@Override
	public BoardVO readOneBoard(int id) {
		BoardVO boardVO = boardDAO.readOneBoard(id);
		if(boardVO== null) {
			throw new RuntimeException("잘모옷된 접근입니다");
		}
		return boardVO;
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
