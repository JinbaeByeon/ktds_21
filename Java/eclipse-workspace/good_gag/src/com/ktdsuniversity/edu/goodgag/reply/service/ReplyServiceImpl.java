package com.ktdsuniversity.edu.goodgag.reply.service;

import java.util.List;

import com.ktdsuniversity.edu.goodgag.reply.dao.ReplyDAO;
import com.ktdsuniversity.edu.goodgag.reply.dao.ReplyDAOImpl;
import com.ktdsuniversity.edu.goodgag.reply.vo.ReplyVO;

public class ReplyServiceImpl implements ReplyService {
	
	private ReplyDAO replyDAO;
	
	public ReplyServiceImpl() {
		replyDAO = new ReplyDAOImpl();
	}
	@Override
	public boolean create(ReplyVO replyVO) {
		replyVO.setReplyID(replyDAO.createNewReplyID());
		return replyDAO.create(replyVO) > 0;
	}

	@Override
	public ReplyVO read(String replyID) {
		return null;
	}

	@Override
	public List<ReplyVO> readAll() {
		return null;
	}

	@Override
	public boolean update(ReplyVO replyVO) {
		return false;
	}

	@Override
	public boolean delete(ReplyVO replyVO) {
		return false;
	}

}
