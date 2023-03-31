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
	public int createNewAdminMbr(MbrVO mbrVO) {
		return getSqlSession().insert("Member.createNewAdminMbr",mbrVO);
	}

	@Override
	public int readCountMbrById(String mbrId) {
		return getSqlSession().selectOne("Member.readCountMbrById",mbrId);
	}	
	@Override
	public String readSaltById(String mbrId) {
		return getSqlSession().selectOne("Member.readSaltById",mbrId);
	}
	@Override
	public String readLgnBlockYnById(String mbrId) {
		return getSqlSession().selectOne("Member.readLgnBlockYnById",mbrId);
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
	public int updateMbrLgnSucc(MbrVO mbrVO) {
		return getSqlSession().update("Member.updateMbrLgnSucc",mbrVO);
	}
	@Override
	public int updateMbrLgnFail(String mbrId) {
		return getSqlSession().update("Member.updateMbrLgnFail",mbrId);
	}
	@Override
	public int updateMbrLgnBlock(String mbrId) {
		return getSqlSession().update("Member.updateMbrLgnBlock",mbrId);
	}
	@Override
	public int updateOneNewAdminMbr(MbrVO mbrVO) {
		return getSqlSession().update("Member.updateOneNewAdminMbr",mbrVO);
	}

	@Override
	public int deleteOneNewAdminMbr(String mbrId) {
		return getSqlSession().delete("Member.deleteOneNewAdminMbr",mbrId);
	}



}
