package com.hello.topic.service;

import java.util.List;

import com.hello.topic.vo.TopicVO;

public interface TopicService {

	public List<TopicVO> readAllTopics();
	
	public TopicVO readOneTopicByTopicId(int id);
	
	public boolean createNewTopic(TopicVO topicVO);
	
	public boolean updateOneTopic(TopicVO topicVO);
	
	public boolean deleteOneTopicById(int id);	
}
