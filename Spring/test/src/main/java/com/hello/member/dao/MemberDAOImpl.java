package com.hello.member.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hello.member.vo.MemberVO;

@Repository
public class MemberDAOImpl extends SqlSessionDaoSupport implements MemberDAO {

	@Autowired
	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}
	
	@Override
	public int registMember(MemberVO memberVO) {
		return getSqlSession().insert("Member.registMember",memberVO);
	}

	@Override
	public MemberVO readOneMemberByEmail(String email) {
		return getSqlSession().selectOne("Member.readOneMemberByEmail",email);
	}

	@Override
	public MemberVO readOneMemberByEmailAndPassword(MemberVO memberVO) {
		return getSqlSession().selectOne("Member.readOneMemberByEmailAndPassword",memberVO);
	}
	
	@Override
	public List<MemberVO> readAllMembers() {
		return getSqlSession().selectList("Member.readAllMembers");
	}

	@Override
	public int updateMember(MemberVO memberVO) {
		return 0;
	}

	@Override
	public int deleteMember(String email) {
		return 0;
	}

	@Override
	public int readCountByEmail(String email) {
		return getSqlSession().selectOne("Member.readCountByEmail",email);
	}



}
