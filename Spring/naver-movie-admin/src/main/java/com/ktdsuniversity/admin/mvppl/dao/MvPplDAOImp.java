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
	public List<MvPplVO> readAllMvPpl(String nm) {
		return getSqlSession().selectList("MvPpl.readAllMvPplByNm",nm);
	}

	@Override
	public int updateOneMvPpl(MvPplVO mvPplVO) {
		return getSqlSession().update("MvPpl.updateOneMvPpl",mvPplVO);
	}

	@Override
	public int deleteOneMvPpl(String mvPplId) {
		return getSqlSession().delete("MvPpl.deleteOneMvPpl",mvPplId);
	}

}
