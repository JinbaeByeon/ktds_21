package com.ktdsuniversity.edu.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.ktdsuniversity.edu.vo.MemberVO;

public class MapMemberDAOImpl implements MemberDAO {
	private Map<String, MemberVO> dataSource;

	public MapMemberDAOImpl() {
		dataSource = new HashMap<>();
	}

	@Override
	public int create(MemberVO memberVO) {
		if (dataSource.put(memberVO.getId(), memberVO) == null) {
			return 0;
		}
		return 1;
	}

	@Override
	public List<MemberVO> readAll() {
		return dataSource.entrySet()			// Map을 Set<Entry<k,v>> 형태로 바꿈
				.stream()						// Set을 Stream<Entry<k,v>> 형태로 바꿈
				.map(e -> e.getValue())			// Stream의 Entry<k,v>에서 value만 뽑아서 Stream<v> 형태로 매핑
				.collect(Collectors.toList());	// 매핑된 값들을 List<v> 형태로 반환
	}

	@Override
	public MemberVO read(int idx) {
		System.out.println("index 접근이 불가능합니다.");
		return null;
	}

	@Override
	public MemberVO read(String key) {
		return 	dataSource.get(key);
	}

}
