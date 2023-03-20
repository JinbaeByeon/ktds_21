package com.hello.board.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // Handler Mapping에 의해 URL 분석이 가능하도록 설정함
public class BoardController {
	
	// HandlerAdapter에 의해서 Controller가 실행될 수 있도록 설정함
	// http://localhost:8080/hello-mvc/ 로 접근 시 아래 메소드가 실행됨
	@RequestMapping("/board") 
	public String viewIndexPage() {
		return "board/board";	// View만 반환한다
								// /WEB-INF/view/board/board.jsp를 화면에 출력
	}
	
	// http://localhost:8080/hello-mvc/detail로 접근 시 아래 메소드가 실행됨
	@RequestMapping("/detail")
	public String viewDetailPage(Model model) {
		// model <- detail.jsp에 전달할 데이터의 모음
		model.addAttribute("message", "안녕하세요"); // detail.jsp에게 데이터를 전달한다
		return "board/detail";	// /WEB-INF/view/board/detail.jsp를 화면에 출력
	}
}
