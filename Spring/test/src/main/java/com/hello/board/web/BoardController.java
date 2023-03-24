package com.hello.board.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.hello.board.service.BoardService;
import com.hello.board.vo.BoardVO;
import com.hello.common.handler.UploadHandler;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	@Autowired
	private UploadHandler uploadHandler;
	
	@GetMapping("/boards")
	public String viewBoardListPage(Model model) {
		List<BoardVO> boardList = boardService.readAllBoards();
		model.addAttribute("boardList", boardList);
		return "board/list";
	}
	
	@GetMapping("/board/{id}")
	public String viewBoardDetailPage(@PathVariable int id, Model model) {
		BoardVO board = boardService.readOneBoard(id);
		model.addAttribute("board", board);
		return "board/detail";
	}
	
	@GetMapping("/board/delete/{id}")
	public String doBoardDelete(@PathVariable int id) {
		boolean res = boardService.deleteBoard(id);
		if(res) {
			return "redirect:/boards";
		}
		return "redirect:/topic/" + id;
	}
	
	
	@GetMapping("/board/write")
	public String viewBoardWritePage(Model model) {
		model.addAttribute("url","/board/write");
		return "board/write";
	}
	
	@PostMapping("/board/write")
	public String doWriteBoard(BoardVO	 boardVO, List<MultipartFile> uploadFile) {
		System.out.println("1");
		boardService.createBoard(boardVO);
		System.out.println("2");
		int boardId = boardVO.getId();
		System.out.println("3");
		uploadHandler.upload(uploadFile, boardId);
		
		return "redirect:/board/" + boardId;
	}
	
	@GetMapping("/board/update/{id}")
	public String viewBoardUpdatePage(@PathVariable int id,Model model) {
		BoardVO board = boardService.readOneBoard(id);
		model.addAttribute("board", board);
		model.addAttribute("url","/board/update/" +id);
		return "board/write";
	}
	
	@PostMapping("/board/update/{id}")
	public String doUpdateBoard(@PathVariable int id,BoardVO boardVO) {
		boardVO.setId(id);
		if(boardService.updateBoard(boardVO)) {
			return "redirect:/board/" + id;
		}
		return "redirect:/boards";
	}
	
	
}
