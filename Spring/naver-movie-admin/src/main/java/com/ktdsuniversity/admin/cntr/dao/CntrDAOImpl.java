package com.ktdsuniversity.admin.cntr.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ktdsuniversity.admin.cntr.vo.CntrVO;

@Repository
public class CntrDAOImpl extends SqlSessionDaoSupport implements CntrDAO {

	@Autowired
	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}
	
	@Override
	public int createOneCntr(CntrVO cntrVO) {
		return getSqlSession().insert("Cntr.createOneCntr",cntrVO);
	}

	@Override
	public List<CntrVO> readAllCntr(CntrVO cntrVO) {
		return getSqlSession().selectList("Cntr.readAllCntr",cntrVO);
	}

	@Override
	public int updateOneCntr(CntrVO cntrVO) {
		return getSqlSession().update("Cntr.updateOneCntr",cntrVO);
	}

	@Override
	public int deleteOneCntrByCntrId(int cntrId) {
		return getSqlSession().update("Cntr.deleteOneCntrByCntrId",cntrId);
	}

	@Override
	public int deleteCntrByCntrIdList(List<Integer> cntrIdList) {
		return getSqlSession().update("Cntr.deleteCntrByCntrIdList",cntrIdList);
	}

}
