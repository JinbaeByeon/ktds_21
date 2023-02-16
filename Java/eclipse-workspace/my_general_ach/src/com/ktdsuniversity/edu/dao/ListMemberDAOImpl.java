package com.ktdsuniversity.edu.dao;

import java.util.ArrayList;
import java.util.List;

import com.ktdsuniversity.edu.vo.MemberVO;

public class ListMemberDAOImpl implements MemberDAO {
	private List<MemberVO> dataSource;

	public ListMemberDAOImpl() {
		dataSource = new ArrayList<>();
	}

	@Override
	public int create(MemberVO memberVO) {
		if (dataSource.add(memberVO)) {
			return 1;
		}
		return 0;
	}

	@Override
	public List<MemberVO> readAll() {
		return dataSource;
	}

	@Override
	public MemberVO read(int idx) {
		return dataSource.get(idx);
	}

	@Override
	public MemberVO read(String key) {
		return dataSource					// List<MemberVO>
				.stream()					// Stream<MemberVO> 
				.filter(member -> member.getId().equals(key))	// id가 key와 같은 데이터만 Stream<MemberVO>에 넣음
				.findFirst()				// Stream<MemberVO> 에서 첫번째 MemberVO를 Optional<MemberVO>에 넣음
				.orElse(new MemberVO());	// Optional<MemberVO>에 존재하는 값이 null이면 new MemberVO()를 리턴
	}

}
