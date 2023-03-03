package com.ktdsuniversity.edu.goodgag.reply.dao;

import java.util.List;
import com.ktdsuniversity.edu.goodgag.reply.vo.ReplyVO;

public interface ReplyDAO {
	public int create(ReplyVO replyVO);

	public ReplyVO read(String replyID);
	
	public List<ReplyVO> readAll(String boardID);

	public int update(ReplyVO replyVO);

	public int delete(ReplyVO replyVO);
	/**
	 * 댓글의 새로운 PK값을 조회한다.
	 * @return String (PK Sequence) 
	 */
	public String createNewReplyID();
}
