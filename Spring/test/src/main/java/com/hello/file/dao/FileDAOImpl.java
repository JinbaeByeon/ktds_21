package com.hello.file.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hello.file.vo.FileVO;

@Repository
public class FileDAOImpl extends SqlSessionDaoSupport implements FileDAO {

	@Autowired
	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}
	@Override
	public int createFile(FileVO fileVO) {
		return getSqlSession().insert("File.createFile",fileVO);
	}

	@Override
	public FileVO readOneFileByFileId(long fileId) {
		return getSqlSession().selectOne("File.readOneFileByFileId",fileId);
	}

	@Override
	public String readFileUuidNameByFileId(long fileId) {
		return getSqlSession().selectOne("File.readFileUuidNameByFileId",fileId);
	}
	
	@Override
	public int deleteOneFileByFileId(long fileId) {
		return getSqlSession().delete("File.deleteOneFileByFileId",fileId);
	}

}
