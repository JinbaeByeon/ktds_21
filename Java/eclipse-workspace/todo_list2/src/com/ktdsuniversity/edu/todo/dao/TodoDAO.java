package com.ktdsuniversity.edu.todo.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.ktdsuniversity.edu.todo.vo.TodoVO;
import com.ktdsuniversity.edu.todo.vo.VO;

public class TodoDAO implements DAO{
	private int cnt = 0;

	private Map<Integer, TodoVO> dataSource;

	public TodoDAO() {
		dataSource = new HashMap<>();
	}

	public int create(String name) {
		dataSource.put(cnt++, new TodoVO(name));
		return 1;
	}

	public TodoVO read(int key) {
		return dataSource.get(key);
	}

	public List<VO> readAll() {
		Set<Entry<Integer,TodoVO>> entrySet = dataSource.entrySet();
		Stream<Entry<Integer,TodoVO>> stream = entrySet.stream();
		Stream<TodoVO> map = stream.map(entry -> entry.getValue());
		List<VO> list = map.collect(Collectors.toList());
		
		return list;
	}

	public int update(int key, boolean isComplete) {
		TodoVO todoVO = dataSource.get(key);
		if(todoVO==null) {
			return 0;
		}
		todoVO.setComplete(isComplete);
		return 1;
	}

	public int delete(int key) {
		TodoVO todoVO = dataSource.remove(key);
		if(todoVO==null) {
			return 0;
		}
		return 1;
	}
	
	public int clear() {
		int size =dataSource.size();
		dataSource.clear();
		return size;
	}

}
