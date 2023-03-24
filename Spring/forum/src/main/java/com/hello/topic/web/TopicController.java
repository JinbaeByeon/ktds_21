package com.hello.topic.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hello.topic.service.TopicService;
import com.hello.topic.vo.TopicVO;

@Controller
public class TopicController {

	@Autowired
	private TopicService topicService;
	
	@GetMapping("/topics")
	public String viewTopicListPage(Model model){
		List<TopicVO> topicList = topicService.readAllTopics();
		model.addAttribute("topicList",topicList);
		return "topic/list";
	}

	@GetMapping("/topic/{topicId}")
	public String viewTopicDetailPage() {
		topicService.readOneTopicByTopicId(0);
		return "topic/detail";
	}
	

	@GetMapping("/topic/write")
	public String viewTopicWritePage() {
		return "topic/write";
	}
	
	@PostMapping("/topic/write")
	public String doTopicWrite(TopicVO topicVO) {
		if(!topicService.createNewTopic(topicVO)) {
			return "topic/write";
		}
		return "redirect:/topic/detail";
	}

	@PostMapping("/topic/delete/{topicId}")
	public String doTopiceDelete() {
		return "redirect:/topics";
	}

	@PostMapping("/topic/update/{topicId}")
	public String doTopicUpdate() {
		return "redirect:/topic/detail";
	}
}
