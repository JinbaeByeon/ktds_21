package com.ktdsuniversity.edu.naver.movie.Inf;

import java.util.List;

public interface MyService<T, K> {

	public boolean create(T vo);

	public T read(K key);

	public List<T> readAll();

	public boolean update(T vo);

	public boolean delete(K key);
	
}
