package com.ktdsuniversity.admin.mbr.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ktdsuniversity.admin.mbr.vo.MbrVO;

@Repository
public class MbrDAOImpl extends SqlSessionDaoSupport implements MbrDAO {

	@Autowired
	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}
	
	@Override
	public int createMember(MbrVO mbrVO) {
		return getSqlSession().insert("Member.createMember",mbrVO);
	}

	@Override
	public MbrVO readOneMemberById(String mbrId) {
		return getSqlSession().selectOne("Member.readOneMemberById",mbrId);
	}

	@Override
	public MbrVO readOneMemberByIdAndPwd(MbrVO mbrVO) {
		return getSqlSession().selectOne("Member.readOneMemberByIdAndPwd",mbrVO);
	}
	
	@Override
	public List<MbrVO> readAllMembers() {
		return getSqlSession().selectList("Member.readAllMembers");
	}

	@Override
	public int updateMember(MbrVO mbrVO) {
		return getSqlSession().update("Member.updateMember",mbrVO);
	}

	@Override
	public int deleteMember(String mbrId) {
		return getSqlSession().delete("Member.deleteMember",mbrId);
	}


}
