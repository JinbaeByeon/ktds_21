package com.ktdsuniversity.edu.todo.dao;

import java.util.List;

import com.ktdsuniversity.edu.todo.vo.VO;

public interface DAO {
	public int create(String name);

	public VO read(int key);

	public List<VO> readAll();

	public int update(int key, boolean isComplete);

	public int delete(int key);
	
	public int clear();
}
