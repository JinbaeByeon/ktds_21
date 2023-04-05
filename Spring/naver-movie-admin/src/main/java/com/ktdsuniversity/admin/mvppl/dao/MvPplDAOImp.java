package com.ktdsuniversity.admin.mvppl.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ktdsuniversity.admin.mvppl.vo.MvPplVO;

@Repository
public class MvPplDAOImp extends SqlSessionDaoSupport implements MvPplDAO {

	@Autowired
	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}
	
	@Override
	public int createOneMvPpl(MvPplVO mvPplVO) {
		return getSqlSession().insert("MvPpl.createOneMvPpl",mvPplVO);
	}

	@Override
	public List<MvPplVO> readAllMvPpl(MvPplVO mvPplVO) {
		return getSqlSession().selectList("MvPpl.readAllMvPpl",mvPplVO);
	}
	@Override
	public MvPplVO readOneMvPplByMvPplId(String mvPplId) {
		return getSqlSession().selectOne("MvPpl.readOneMvPplByMvPplId",mvPplId);
	}
	@Override
	public int updateOneMvPpl(MvPplVO mvPplVO) {
		return getSqlSession().update("MvPpl.updateOneMvPpl",mvPplVO);
	}

	@Override
	public int deleteOneMvPplByMvPplId(String mvPplId) {
		return getSqlSession().update("MvPpl.deleteOneMvPplByMvPplId",mvPplId);
	}

	@Override
	public int deleteMvPplByMvPplIdList(List<String> mvPplIdList) {
		return getSqlSession().update("MvPpl.deleteMvPplByMvPplIdList",mvPplIdList);
	}

}
