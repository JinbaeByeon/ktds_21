package com.ktdsuniversity.admin.gnr.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ktdsuniversity.admin.gnr.vo.GnrVO;

@Repository
public class GnrDAOImpl extends SqlSessionDaoSupport implements GnrDAO {

	@Autowired
	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}

	@Override
	public List<GnrVO> readAllGnr(GnrVO gnrVO) {
		return getSqlSession().selectList("Gnr.readAllGnr",gnrVO);
	}
	@Override
	public List<GnrVO> readAllGnrNoPagination(String gnrNm) {
		return getSqlSession().selectList("Gnr.readAllGnrNoPagination",gnrNm);
	}
	@Override
	public int createOneGnr(GnrVO gnrVO) {
		return getSqlSession().insert("Gnr.createOneGnr",gnrVO);
	}

	@Override
	public int updateOneGnr(GnrVO gnrVO) {
		return getSqlSession().update("Gnr.updateOneGnr",gnrVO);
	}

	@Override
	public int deleteOntGnrByGnrId(int gnrId) {
		return getSqlSession().update("Gnr.deleteOntGnrByGnrId",gnrId);
	}

	@Override
	public int deleteGnrByGnrIdList(List<Integer> gnrIdList) {
		return getSqlSession().update("Gnr.deleteGnrByGnrIdList",gnrIdList);
	}

	
}
