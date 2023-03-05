package com.ktdsuniversity.edu.goodgag.board.vo;

import java.util.List;

import com.ktdsuniversity.edu.goodgag.member.vo.MemberVO;
import com.ktdsuniversity.edu.goodgag.reply.vo.ReplyVO;

public class BoardVO {
	private String boardID;
	private String email;
	private String title;
	private String descript;
	private String registDate;
	private String source;
	private String noticeTf;	
	
	/**
	 * 게시글을 작성한 회원의 정보
	 */
	private MemberVO memberVO;

	/**
	 * 게시글에 등록된 댓글의 목록
	 */
	private List<ReplyVO> replyList;
	
	private List<MemberVO> likeMemberList;
	private List<MemberVO> disLikeMemberList;
	
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescript() {
		return descript;
	}

	public void setDescript(String descript) {
		this.descript = descript;
	}

	public String getRegistDate() {
		return registDate;
	}

	public void setRegistDate(String registDate) {
		this.registDate = registDate;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getNoticeTf() {
		return noticeTf;
	}

	public void setNoticeTf(String noticeTf) {
		this.noticeTf = noticeTf;
	}

	public MemberVO getMemberVO() {
		return memberVO;
	}

	public void setMemberVO(MemberVO memberVO) {
		this.memberVO = memberVO;
	}

	public List<ReplyVO> getReplyList() {
		return replyList;
	}

	public void setReplyList(List<ReplyVO> replyList) {
		this.replyList = replyList;
	}

	public List<MemberVO> getLikeMemberList() {
		return likeMemberList;
	}

	public void setLikeMemberList(List<MemberVO> likeMemberList) {
		this.likeMemberList = likeMemberList;
	}

	public List<MemberVO> getDisLikeMemberList() {
		return disLikeMemberList;
	}

	public void setDisLikeMemberList(List<MemberVO> dislikeMemberList) {
		this.disLikeMemberList = dislikeMemberList;
	}

	@Override
	public String toString() {
		String res = "boardID : " + boardID + '\t'
				 + "email : " + email + '\t'
				 + "title : " + title + '\t'
				 + "descript : " + descript + '\t'
				 + "registDate : " + registDate + '\t'
				 + "source : " + source + '\t'
				 + "noticeTf : " + noticeTf + '\n';
		if(memberVO != null) {
			res += "nickName : " + memberVO.getNickName() + '\n';
		}
				
		if(replyList != null && !replyList.isEmpty()) {
			for(int i =0 ;i < replyList.size();++i) {
				res += "댓글 " + (i + 1) + " : " + replyList.get(i) + '\n';
			}
		} else {
			res += "댓글 업슴";
		}
		return res;
	}
}
