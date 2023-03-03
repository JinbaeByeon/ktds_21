package com.ktdsuniversity.edu.goodgag.reply.dao;

import java.util.List;

import com.ktdsuniversity.edu.goodgag.reply.vo.ReplyVO;
import com.ktdsuniversity.edu.goodgag.utils.db.AbstractDaoPoolSupport;

public class ReplyDAOImpl extends AbstractDaoPoolSupport<ReplyVO> implements ReplyDAO {

	@Override
	public int create(ReplyVO replyVO) {
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT INTO REPLIES   ");
		sql.append(" (RPL_ID                 ");
		sql.append(", BRD_ID                 ");
		sql.append(", EML                    ");
		sql.append(", RPL                    ");
		sql.append(", RGST_DT                ");
		sql.append(", MDF_DT                 ");
		sql.append(", PRNT_RPL_ID)            ");
		sql.append("VALUES               ");

		sql.append(" ( ? ");
		sql.append(" , ? /*BRD_ID*/    ");
		sql.append(" , ? /*EML*/    ");
		sql.append(" , ? /*RPL*/ ");
		sql.append(" , SYSDATE      ");
		sql.append(" , SYSDATE      ");
		sql.append(" , ? )/*PRNT_RPL_ID*/    ");

		return insert(sql.toString(), (pstmt) -> {
			pstmt.setString(1, replyVO.getReplyID());
			pstmt.setString(2, replyVO.getBoardID());
			pstmt.setString(3, replyVO.getEmail());
			pstmt.setString(4, replyVO.getReply());
			pstmt.setString(5, replyVO.getParentReplyID());
		});
	
	}

	@Override
	public ReplyVO read(String replyID) {
		return null;
	}

	@Override
	public List<ReplyVO> readAll(String replyID) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT RPL_ID                         ");
		sql.append("	 , BRD_ID                            ");
		sql.append("	 , EML                               ");
		sql.append("	 , RPL                               ");
		sql.append("	 , RGST_DT                           ");
		sql.append("	 , MDF_DT                            ");
		sql.append("	 , PRNT_RPL_ID                       ");
		sql.append("  FROM REPLIES RP                     ");
		sql.append(" WHERE RP.BRD_ID = ?");
		
		return select(sql.toString(), (pm) -> {
			pm.setString(1, replyID);
		}, (rs) -> {
			ReplyVO replyVO = new ReplyVO();
			replyVO.setReplyID(rs.getString("RPL_ID")     );
			replyVO.setBoardID(rs.getString("BRD_ID")     );
			replyVO.setEmail(rs.getString("EML")        );
			replyVO.setReply(rs.getString("RPL")         );
			replyVO.setRegistDate(rs.getString("RGST_DT")    );
			replyVO.setModifyDate(rs.getString("MDF_DT")     );
			replyVO.setParentReplyID(rs.getString("PRNT_RPL_ID"));
			return replyVO;
		});
	}

	@Override
	public int update(ReplyVO replyVO) {
		return 0;
	}

	@Override
	public int delete(ReplyVO replyVO) {
		return 0;
	}

	@Override
	public String createNewReplyID() {
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT 'RE-' || TO_CHAR(SYSDATE,'YYYYMMDD')"
				 + " || '-' || LPAD(SEQ_BOARDS_PK.NEXTVAL,5,'0') NEW_SEQ");
		sql.append("   FROM DUAL ");
		
		return selectOneString(sql.toString(), null, (rs) -> {
			return rs.getString("NEW_SEQ");
		});
	}

}
