package com.ktdsuniversity.edu.goodgag.board.service;

import java.util.List;
import java.util.Map;
import com.ktdsuniversity.edu.goodgag.board.dao.BoardDAO;
import com.ktdsuniversity.edu.goodgag.board.dao.BoardDAOImpl;
import com.ktdsuniversity.edu.goodgag.board.vo.BoardVO;
import com.ktdsuniversity.edu.goodgag.member.vo.MemberVO;

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
	public boolean delete(String boardID) {
		return boardDAO.delete(boardID) > 0;
	}

	@Override
	public boolean recommend(BoardVO boardVO, MemberVO memberVO, boolean recommend) {
		String rcmd = boardDAO.readRecommend(boardVO.getBoardID(), memberVO.getEmail());
		String boardID = boardVO.getBoardID();
		String email = memberVO.getEmail();
		Map<MemberVO, Boolean> recommendMap = boardVO.getRecommendMap();
		
		if (rcmd == null) {
			// 추천인 목록에 없는 경우
			// 맵에 데이터 추가
			// Board_Recommends에 Insert
			System.out.println("recommend - insert");
			
			recommendMap.put(memberVO, recommend);
			return boardDAO.addRecommend(boardID, email, recommend) > 0;
		}
		else if((rcmd == "BOOLEAN_T") == recommend) {
			// 기존의 추천 값과 recommend 값이 같을 경우
			// 맵에서 데이터 제거
			// Borad_Recommends에서 Delete
			System.out.println("recommend - delete");
			
			recommendMap.remove(boardVO);
			if(boardDAO.deleteRecommend(boardID, email) == 0) {
				System.out.println("이 출력문은 나오면 안됨");
			};
			return false;
		}
		else {
			// 기존의 추천 값과 recommend 값이 다를 경우
			// 맵에 데이터 추가
			// Board_Recommends에서 RCMD 값을 recommend로 Update
			System.out.println("recommend - update");

			recommendMap.put(memberVO, recommend);
			return boardDAO.updateRecommend(boardID, email, recommend) > 0;
		}
	}
}
