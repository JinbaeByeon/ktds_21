package com.ktdsuniversity.edu.goodgag.board.dao;

import java.util.ArrayList;
import java.util.List;

import com.ktdsuniversity.edu.goodgag.board.vo.BoardVO;
import com.ktdsuniversity.edu.goodgag.member.vo.MemberVO;
import com.ktdsuniversity.edu.goodgag.reply.vo.ReplyVO;
import com.ktdsuniversity.edu.goodgag.utils.db.AbstractDaoPoolSupport;

public class BoardDAOImpl extends AbstractDaoPoolSupport<BoardVO> implements BoardDAO {

	@Override
	public int create(BoardVO boardVO) {
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT INTO BOARDS   ");
		sql.append(" (BRD_ID             ");
		sql.append(", EML                ");
		sql.append(", TTL                ");
		sql.append(", DSCRPT             ");
		sql.append(", RGST_DT            ");
		sql.append(", SRC                ");
		sql.append(", NTC_TF)            ");
		sql.append("VALUES               ");

		sql.append(" (? /*BRD_ID*/ ");
		sql.append(", ? /*EML*/    ");
		sql.append(", ? /*TTL*/    ");
		sql.append(", ? /*DSCRPT*/ ");
		sql.append(", SYSDATE      ");
		sql.append(", ? /*SRC*/    ");
		sql.append(", ? /*NTC_TF*/) ");

		return insert(sql.toString(), (pstmt) -> {
			pstmt.setString(1, boardVO.getBoardID());
			pstmt.setString(2, boardVO.getEmail());
			pstmt.setString(3, boardVO.getTitle());
			pstmt.setString(4, boardVO.getDescript());
			pstmt.setString(5, boardVO.getSource());
			String notice = "BOOLEAN_F";
			if (boardVO.getNoticeTf() != null) {
				notice = boardVO.getNoticeTf();
			}
			pstmt.setString(6, notice);
		});
	}

	@Override
	public BoardVO read(String boardID) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT BRD_ID                  ");
		sql.append("	 , EML                        ");
		sql.append("	 , TTL                        ");
		sql.append("	 , DSCRPT                     ");
		sql.append("	 , RGST_DT                    ");
		sql.append("	 , SRC                        ");
		sql.append("	 , NTC_TF                     ");
		sql.append("  FROM BOARDS                  ");
		sql.append(" WHERE BRD_ID = ?                ");
		
		return selectOne(sql.toString(), (pstmt) -> {
			pstmt.setString(1, boardID);
		}, (rs) -> {
			BoardVO boardVO = new BoardVO();
			boardVO.setBoardID(rs.getString("BRD_ID"));
			boardVO.setEmail(rs.getString("EML"));
			boardVO.setTitle(rs.getString("TTL"));
			boardVO.setDescript(rs.getString("DSCRPT"));
			boardVO.setRegistDate(rs.getString("RGST_DT"));
			boardVO.setSource(rs.getString("SRC"));
			boardVO.setNoticeTf(rs.getString("NTC_TF"));
			return boardVO;
		});
	}

	@Override
	public List<BoardVO> readAll() {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ROW_NUMBER() OVER (ORDER BY BD.BRD_ID ASC) RNUM");
		sql.append("	 , BD.BRD_ID                                         ");
		sql.append("	 , BD.EML                                            ");
		sql.append("	 , BD.TTL                                            ");
		sql.append("	 , BD.RGST_DT                                        ");
		sql.append("	 , BD.NTC_TF                                         ");
		sql.append("	 , RP.RPL_ID                                         ");
		sql.append("	 , MB.NCKNM                                          ");
		sql.append("  FROM BOARDS BD                                      ");
		sql.append("  LEFT JOIN REPLIES RP                                ");
		sql.append("  	ON RP.BRD_ID = BD.BRD_ID                           ");
		sql.append("  JOIN MEMBERS MB                                     ");
		sql.append("  	ON MB.EML =BD.EML                                  ");
		sql.append(" ORDER BY BD.BRD_ID DESC                              ");

//		return selectByKey(sql.toString(), "BRD_ID, "getBoardID, null, null)
		List<BoardVO> boardList = new ArrayList<>();
		
		select(sql.toString(),null,(rs) -> {
			String boardID = rs.getString("BRD_ID");
			
			BoardVO boardVO = getExistBoard(boardList, boardID);
			
			if (boardVO != null) {
				// 이미 등록된 board일 경우
				// eachboard의 replyList를 가져온다.
				List<ReplyVO> replyList = boardVO.getReplyList();
				String replyId = rs.getString("RPL_ID");
				if (replyId != null) {
					ReplyVO replyVO = new ReplyVO();
					replyVO.setReplyID(replyId);
					replyList.add(replyVO);
				}
				return boardVO;
			}
			else {
				// 아직 등록되지 않은 Article일 경우
				// 새로운 Article을 생성한다.
				boardVO = new BoardVO();
				boardVO.setBoardID(boardID);
				boardVO.setEmail(rs.getString("EML"));
				boardVO.setTitle(rs.getString("TTL"));
				boardVO.setRegistDate(rs.getString("RGST_DT"));
				boardVO.setNoticeTf(rs.getString("NTC_TF"));
				
				List<ReplyVO> replyList = new ArrayList<>();
				boardVO.setReplyList(replyList);
				String replyID = rs.getString("RPL_ID");
				if (replyID != null) {
					ReplyVO replyVO = new ReplyVO();
					replyList.add(replyVO);
					replyVO.setReplyID(replyID);
				}
				
				MemberVO memberVO = new MemberVO();
				memberVO.setEmail(rs.getString("EML"));
				memberVO.setNickName(rs.getString("NCKNM"));
				boardVO.setMemberVO(memberVO);
				
				boardList.add(boardVO);
				return boardVO;
			}
		});
		
		return boardList;
		
//		sql.append("SELECT BRD_ID                  ");
//		sql.append("	 , EML                        ");
//		sql.append("	 , TTL                        ");
//		sql.append("	 , DSCRPT                     ");
//		sql.append("	 , RGST_DT                    ");
//		sql.append("	 , SRC                        ");
//		sql.append("	 , NTC_TF                     ");
//		sql.append("  FROM BOARDS                  ");
//		
//		return select(sql.toString(), null, (rs) ->{
//			BoardVO boardVO = new BoardVO();
//			boardVO.setBoardID(rs.getString("BRD_ID"));
//			boardVO.setEmail(rs.getString("EML"));
//			boardVO.setTitle(rs.getString("TTL"));
//			boardVO.setDescript(rs.getString("DSCRPT"));
//			boardVO.setRegistDate(rs.getString("RGST_DT"));
//			boardVO.setSource(rs.getString("SRC"));
//			boardVO.setNoticeTf(rs.getString("NTC_TF"));
//			boardVO.setReplyList(null);
//			return boardVO;
//		});
	}

	@Override
	public int update(BoardVO boardVO) {
		StringBuffer sql = new StringBuffer();
		sql.append("");
		return 0;
	}

	@Override
	public int delete(String boardID) {
		StringBuffer sql = new StringBuffer();
		sql.append(" DELETE          ");
		sql.append("   FROM BOARDS     ");
		sql.append("  WHERE BRD_ID = ?");
		
		return delete(sql.toString(), (pstmt) -> {
			pstmt.setString(1, boardID);
		});
	}

	@Override
	public String createNewBoardID() {
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT 'BO-' || TO_CHAR(SYSDATE,'YYYYMMDD')"
				 + " || '-' || LPAD(SEQ_BOARDS_PK.NEXTVAL,5,'0') NEW_SEQ");
		sql.append("   FROM DUAL ");
		
		return selectOneString(sql.toString(), null, (rs) -> {
			return rs.getString("NEW_SEQ");
		});
	}
	
	/**
	 * BoardList 에 BoardNo 값을 가진 BoardVO 객체를 반환한다.
	 * 없으면 null을 반환한다.
	 * @param BoardList
	 * @param BoardNo
	 * @return BoardVO
	 */
	private BoardVO getExistBoard(List<BoardVO> BoardList, String BoardNo) {
		for (BoardVO eachBoard: BoardList) {
			if (eachBoard.getBoardID().equals(BoardNo)) {
				return eachBoard;
			}
		}
		
		return null;
	}


	@Override
	public String readRecommend(String boardID, String email) {
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT RCMD             ");
		sql.append("   FROM BOARD_RECOMMENDS ");
		sql.append("  WHERE EML = ?   ");
		sql.append("    AND BRD_ID = ?");
		
		return selectOneString(sql.toString(), (pstmt) -> {
			pstmt.setString(1, email);
			pstmt.setString(2, boardID);
		}, (rs) -> {
			return rs.getString("RCMD");
		});
	}

	@Override
	public int addRecommend(String boardID, String email, boolean recommend) {
		StringBuffer sql = new StringBuffer();
		
		sql.append(" INSERT INTO BOARD_RECOMMENDS");
		sql.append("  (EML                       ");
		sql.append(" , BRD_ID                    ");
		sql.append(" , RCMD)                     ");
		sql.append(" VALUES                      ");
		sql.append(" ( ?               ");
		sql.append(" , ?      		   ");
		sql.append(" , ?)              ");

		return insert(sql.toString(), (pstmt) -> {
			pstmt.setString(1, email);
			pstmt.setString(2, boardID);
			pstmt.setString(3,  recommend ? "BOOLEAN_T" : "BOOLEAN_F");
		});		
	}

	@Override
	public int deleteRecommend(String boardID, String email) {
		StringBuffer sql = new StringBuffer();
		
		sql.append(" DELETE                    ");
		sql.append("   FROM BOARD_RECOMMENDS   ");
		sql.append("  WHERE EML = ?   ");
		sql.append("    AND BRD_ID = ?");
		
		return delete(sql.toString(), (pstmt) -> {
			pstmt.setString(1, email);
			pstmt.setString(2, boardID);
		});		
	}

	@Override
	public int updateRecommend(String boardID, String email, boolean recommend) {
		StringBuffer sql = new StringBuffer();
		
		sql.append("UPDATE BOARD_RECOMMENDS   ");
		sql.append("   SET RCMD = ?   ");
		sql.append(" WHERE EML = ?    ");
		sql.append("   AND BRD_ID = ? ");

		return update(sql.toString(), (pstmt) -> {
			pstmt.setString(1, recommend ? "BOOLEAN_T" : "BOOLEAN_F");
			pstmt.setString(2, email);
			pstmt.setString(3, boardID);
		});
	}

}
