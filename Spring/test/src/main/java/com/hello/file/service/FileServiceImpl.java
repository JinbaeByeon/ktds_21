package com.hello.file.service;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hello.common.handler.UploadHandler;
import com.hello.file.dao.FileDAO;
import com.hello.file.vo.FileVO;

@Service
public class FileServiceImpl implements FileService {
	
	@Autowired
	private FileDAO fileDAO;
	@Autowired
	private UploadHandler uploadHandler;
	
	@Override
	public boolean createFile(FileVO fileVO) {
		return fileDAO.createFile(fileVO) > 0;
	}

	@Override
	public FileVO readOneFileByFileId(long fileId) {
		return fileDAO.readOneFileByFileId(fileId);
	}

	@Override
	public boolean deleteOneFileByFileId(long fileId) {
		String uploadPath = uploadHandler.getUploadPath();
		String uuidFileName = fileDAO.readFileUuidNameByFileId(fileId);
		File file = new File(uploadPath,uuidFileName);
		if(file.exists()) {
			file.delete();
		}
		
		return fileDAO.deleteOneFileByFileId(fileId) > 0;
	}

}
