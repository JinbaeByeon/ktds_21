package com.hello.file.service;

import com.hello.file.vo.FileVO;

public interface FileService {
	
	public boolean createFile(FileVO fileVO);
	
	public FileVO readOneFileByFileId(long fileId);
	
	public boolean deleteOneFileByFileId(long fileId);
}
