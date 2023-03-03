package com.ktdsuniversity.edu.goodgag;

import java.util.List;

import com.ktdsuniversity.edu.goodgag.board.service.BoardService;
import com.ktdsuniversity.edu.goodgag.board.service.BoardServiceImpl;
import com.ktdsuniversity.edu.goodgag.board.vo.BoardVO;
import com.ktdsuniversity.edu.goodgag.member.service.MemberService;
import com.ktdsuniversity.edu.goodgag.member.service.MemberServiceImpl;
import com.ktdsuniversity.edu.goodgag.member.vo.MemberVO;
import com.ktdsuniversity.edu.goodgag.reply.service.ReplyService;
import com.ktdsuniversity.edu.goodgag.reply.service.ReplyServiceImpl;
import com.ktdsuniversity.edu.goodgag.reply.vo.ReplyVO;

public class GoodGagMain {
	MemberService ms;
	BoardService bs;
	ReplyService rs;
	MemberVO myAccount;
	
	private GoodGagMain() {
		ms = new MemberServiceImpl();
		bs = new BoardServiceImpl();
		rs = new ReplyServiceImpl();
	}

	public void createUser() {
		System.out.println("회원가입");
		MemberVO memberVO = new MemberVO();
		memberVO.setEmail("bjbb@gmail.com");
		memberVO.setNickName("진배1");
		memberVO.setPassword("1q2w3e4r");
		myAccount = memberVO;
		if(ms.create(memberVO)==1) {
			System.out.println("회원가입 완료");
		}
	}

	public String writeBoard() {
		System.out.println("게시글 작성");
		BoardVO boardVO = new BoardVO();
		boardVO.setEmail(myAccount.getEmail());
		boardVO.setTitle("제목");
		boardVO.setDescript("내용");
		boardVO.setSource("출처");
		bs.create(boardVO);
		System.out.println("게시글 작성 완료");
		
		return boardVO.getBoardID();
	}

	private String readBoards() {
		System.out.println("게시글 목록 조회");
		List<BoardVO> boardList = bs.readAll();
		boardList.forEach(System.out::println);
		System.out.println("게시글 목록 조회 끝");
		return boardList.get(0).getBoardID();
	}

	private void readBoard(String boardID) {
		System.out.println("게시글 상세 조회");
		BoardVO boardVO = bs.read(boardID);
		System.out.println(boardVO);
		System.out.println("게시글 상세 조회 끝");
	}
	private void updateBoard(String boardID) {
		System.out.println("게시글 수정");
		BoardVO boardVO = new BoardVO();
		boardVO.setBoardID(boardID);
		System.out.println("게시글 수정 끝");
	}
	
	private void writeReply(String boardID) {
		System.out.println("댓글 작성");
		ReplyVO replyVO = new ReplyVO();
		replyVO.setBoardID(boardID);
		replyVO.setReply("댓글2.");
		replyVO.setEmail(myAccount.getEmail());
		replyVO.setMemberVO(myAccount);
		rs.create(replyVO);
		System.out.println("댓글 작성 끝");
	}
	
	private void updateReply(String boardID) {
		System.out.println("댓글 수정");
		System.out.println("댓글 수정 끝");		
	}
	
	public static void main(String[] args) {
		GoodGagMain ggm = new GoodGagMain();
		// 회원 가입
		ggm.createUser();

		// 게시글 작성;
//		String bID = ggm.writeBoard();
		String bID = "BO-20230228-00003";
		// 게시글 목록 조회 (댓글 개수 포함)
		ggm.readBoards();
		
		// 게시글 상세 조회 (댓글 포함)
		ggm.readBoard(bID);
		
		// 게시글 수정
//		ggm.updateBoard(bID);
		
		// 댓글 작성
		ggm.writeReply(bID);
		
		// 댓글 수정
		ggm.updateReply(bID);
		// 게시글 삭제
		// 댓글 삭제
		// 게시글 좋아요
		// 게시글 싫어요
		// 게시글 신고
		// 댓글 좋아요
		// 댓글 싫어요
	}


}
