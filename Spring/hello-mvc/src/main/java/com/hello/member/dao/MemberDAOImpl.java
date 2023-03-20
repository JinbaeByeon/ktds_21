package com.hello.member.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hello.member.vo.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Resource
	private List<String> memberSQL;

	@Override
	public int createNewMember(MemberVO memberVO) {
		String sql = memberSQL.get(0);
		return jdbcTemplate.update(sql
								  , memberVO.getEmail()
								  , memberVO.getName()
								  , memberVO.getPassword());
	}

	@Override
	public List<MemberVO> readAllMember() {
		return null;
	}
	
}
