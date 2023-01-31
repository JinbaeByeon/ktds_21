package com.ktdsuniversity.edu.todo.service;

import java.util.List;

import com.ktdsuniversity.edu.todo.dao.TodoDAO;
import com.ktdsuniversity.edu.todo.vo.TodoVO;
import com.ktdsuniversity.edu.todo.vo.VO;

public class TodoService {
	TodoDAO todoDAO;

	public TodoService() {
		todoDAO = new TodoDAO();
	}

	public boolean create(String name) {
		return todoDAO.create(name) == 1;
	}

	public boolean update(int key, boolean isComplete) {
		return todoDAO.update(key, isComplete) == 1;
	}

	public boolean delete(int key) {
		return todoDAO.delete(key) == 1;
	}

	public boolean clear() {
		return todoDAO.clear() > 0;
	}

	public TodoVO read(int key) {
		return todoDAO.read(key);
	}

	public List<VO> readAll() {
		return todoDAO.readAll();
	}

}
