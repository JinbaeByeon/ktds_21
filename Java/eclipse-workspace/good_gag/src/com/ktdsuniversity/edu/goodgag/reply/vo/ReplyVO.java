package com.ktdsuniversity.edu.goodgag.reply.vo;

import com.ktdsuniversity.edu.goodgag.board.vo.BoardVO;
import com.ktdsuniversity.edu.goodgag.member.vo.MemberVO;

public class ReplyVO {
	private String replyID;
	private String boardID;
	private String email;
	private String reply;
	private String registDate;
	private String modifyDate;
	private String parentReplyID;
	
	/**
	 * 댓글이 달린 게시글의 정보
	 */
	private BoardVO boardVO;
	/**
	 * 댓글을 작성한 회원의 정보
	 */
	private MemberVO memberVO;
	/**
	 * 현재 댓글이 대댓글일 경우
	 * 상위 댓글의 정보
	 */
	private ReplyVO parentReplyVO;

	public String getReplyID() {
		return replyID;
	}

	public void setReplyID(String replyID) {
		this.replyID = replyID;
	}

	public String getBoardID() {
		return boardID;
	}

	public void setBoardID(String boardID) {
		this.boardID = boardID;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

	public String getRegistDate() {
		return registDate;
	}

	public void setRegistDate(String registDate) {
		this.registDate = registDate;
	}

	public String getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}

	public String getParentReplyID() {
		return parentReplyID;
	}

	public void setParentReplyID(String parentReplyID) {
		this.parentReplyID = parentReplyID;
	}
	
	public BoardVO getBoardVO() {
		return boardVO;
	}

	public void setBoardVO(BoardVO boardVO) {
		this.boardVO = boardVO;
	}

	public MemberVO getMemberVO() {
		return memberVO;
	}

	public void setMemberVO(MemberVO memberVO) {
		this.memberVO = memberVO;
	}

	public ReplyVO getParentReplyVO() {
		return parentReplyVO;
	}

	public void setParentReplyVO(ReplyVO parentReplyVO) {
		this.parentReplyVO = parentReplyVO;
	}

	@Override
	public String toString() {
		return "replyId : " + replyID + '\t'
			 + "boardId : " + boardID + '\t'
			 + "email : " + email + '\t'
			 + "reply : " + reply + '\t'
			 + "registDate : " + registDate + '\t'
			 + "modifyDate : " + modifyDate + '\t'
			 + "parentReplyID : " + parentReplyID + '\t';
	}
}
