package com.ktdsuniversity.admin.cmpny.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ktdsuniversity.admin.cmpny.vo.CmpnyVO;

@Repository
public class CmpnyDAOImpl extends SqlSessionDaoSupport implements CmpnyDAO {

	@Autowired
	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}

	@Override
	public int createOneCmpny(CmpnyVO cmpnyVO) {
		return getSqlSession().insert("Cmpny.createOneCmpny",cmpnyVO);
	}

	@Override
	public List<CmpnyVO> readAllCmpny(String cmpnyNm) {
		return getSqlSession().selectList("Cmpny.readAllCmpny",cmpnyNm);
	}

	@Override
	public int updateOneCmpny(CmpnyVO cmpnyVO) {
		return getSqlSession().update("Cmpny.updateOneCmpny",cmpnyVO);
	}

	@Override
	public int deleteOneCmpny(String cmpnyId) {
		return getSqlSession().delete("Cmpny.deleteOneCmpny",cmpnyId);
	}

}
