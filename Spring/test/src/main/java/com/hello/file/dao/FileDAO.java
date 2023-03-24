package com.hello.file.dao;

import com.hello.file.vo.FileVO;

public interface FileDAO {
	
	public int createFile(FileVO fileVO);
	
	public FileVO readOneFileByFileId(long fileId);

	public String readFileUuidNameByFileId(long fileId);
	
	public int deleteOneFileByFileId(long fileId);
}
