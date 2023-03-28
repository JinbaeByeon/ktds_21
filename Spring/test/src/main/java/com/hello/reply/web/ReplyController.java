package com.hello.reply.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.hello.member.vo.MemberVO;
import com.hello.reply.service.ReplyService;
import com.hello.reply.vo.ReplyVO;

@Controller
public class ReplyController {

	@Autowired
	ReplyService replyService;

	@PostMapping("board/reply/create")
	public String doCreateReply(ReplyVO replyVO
								,@SessionAttribute("__USER_SESSION_DATA__") MemberVO user) {
		replyVO.setEmail(user.getEmail());
		if(replyService.createNewReply(replyVO)) {
			return "redirect:/board/" +replyVO.getBoardId();
 		}
		return "redirect:/board/" +replyVO.getBoardId() + "?errorCode=fail";
	}

	@PostMapping("board/reply/update/{replyId}")
	public String doUpdateReply(@PathVariable int replyId, ReplyVO replyVO) {
		replyVO.setReplyId(replyId);
		if(replyService.updateOneReply(replyVO)) {
			return "redirect:/board/" + replyVO.getBoardId();
		}
		return "redirect:/board/" +replyVO.getBoardId() + "?errorCode=fail";
	}

	@GetMapping("board/{boardId}/reply/delete/{replyId}")
	public String doDeleteReply(@PathVariable int boardId,@PathVariable int replyId) {
		if(replyService.deleteReplyByReplyId(replyId)) {
			return "redirect:/board/" + boardId;
		}
		return "redirect:/board/detail/" + boardId + "?errorCode=fail";
	}
	
//	@PostMapping("board/")
}
