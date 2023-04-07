package com.ktdsuniversity.admin.prdcprtcptnppl.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ktdsuniversity.admin.prdcprtcptnppl.vo.PrdcPrtcptnPplVO;

@Repository
public class PrdcPrtcptnPplDAOImpl extends SqlSessionDaoSupport implements PrdcPrtcptnPplDAO {

	@Autowired
	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}

	@Override
	public int createNewPrdcPrtcptnPpl(PrdcPrtcptnPplVO prdcPplVO) {
		return getSqlSession().insert("PrdcPrtcptnPpl.createNewPrdcPrtcptnPpl",prdcPplVO);
	}

	@Override
	public int deleteOnePrdcPrtcptnPplByPrdcPplId(String prdcPplId) {
		return getSqlSession().update("PrdcPrtcptnPpl.deleteOnePrdcPrtcptnPplByPrdcPplId",prdcPplId);
	}
}
