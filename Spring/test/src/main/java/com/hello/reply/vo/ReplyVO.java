package com.hello.reply.vo;

import com.hello.member.vo.MemberVO;

/**
 * REPLY
 */
public class ReplyVO {
	/**
	 * 댓글 계층 조회를 위한 LEVEL 데이터
	 */
	private int depth;
	
	private int replyId;
	private int boardId;
	private String reply;
	private String email;
	private String crtDt;
	private String mdfyDt;
	private int prntReplyId;
	
	private MemberVO memberVO;
	
	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public void setReplyId(int replyId) {
		this.replyId = replyId;
	}

	public int getReplyId() {
		return this.replyId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	public int getBoardId() {
		return this.boardId;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

	public String getReply() {
		return this.reply;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return this.email;
	}

	public void setCrtDt(String crtDt) {
		this.crtDt = crtDt;
	}

	public String getCrtDt() {
		return this.crtDt;
	}

	public void setMdfyDt(String mdfyDt) {
		this.mdfyDt = mdfyDt;
	}

	public String getMdfyDt() {
		return this.mdfyDt;
	}

	public void setPrntReplyId(int prntReplyId) {
		this.prntReplyId = prntReplyId;
	}

	public int getPrntReplyId() {
		return this.prntReplyId;
	}

	public MemberVO getMemberVO() {
		return memberVO;
	}

	public void setMemberVO(MemberVO memberVO) {
		this.memberVO = memberVO;
	}

}