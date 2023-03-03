package com.ktdsuniversity.edu.goodgag.reply.service;

import java.util.List;

import com.ktdsuniversity.edu.goodgag.reply.vo.ReplyVO;

public interface ReplyService {
	public boolean create(ReplyVO replyVO);

	public ReplyVO read(String replyID);
	public List<ReplyVO> readAll();

	public boolean update(ReplyVO replyVO);

	public boolean delete(ReplyVO replyVO);
	
}
