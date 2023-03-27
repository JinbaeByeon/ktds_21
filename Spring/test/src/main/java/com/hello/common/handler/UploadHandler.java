package com.hello.common.handler;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.hello.file.dao.FileDAO;
import com.hello.file.vo.FileVO;

@Component
public class UploadHandler {
	@Autowired
	private FileDAO fileDAO;
	
	@Value("${uploadpath:D:/uploadFiles}")
	private String uploadPath;
	
	public String getUploadPath() {
		return uploadPath;
	}
	
	public void upload(List<MultipartFile> fileList,int boardId) {
		fileList.forEach(file ->upload(file,boardId));
	}
	
	public void upload(MultipartFile file, int boardId) {
		if(file != null && !file.isEmpty()) {
			String fileName = UUID.randomUUID().toString();
			
			File uploadDir = new File(uploadPath);
			if(!uploadDir.exists()) {
				uploadDir.mkdirs();
			}
			
			try {
				file.transferTo(new File(uploadPath,fileName));
			} catch (IllegalStateException | IOException e) {
				throw new RuntimeException(e.getMessage(),e);
			}
			String originFileName = file.getOriginalFilename();
			

			FileVO fileVO = new FileVO();
			fileVO.setBoardId(boardId);
			fileVO.setFileSize(file.getSize());
			fileVO.setOriginalFileName(originFileName);
			fileVO.setUuidFileName(fileName);
			String ext = originFileName.substring(originFileName.lastIndexOf(".") + 1);
			fileVO.setFileExt(ext);
			
			fileDAO.createFile(fileVO);
		}
	}
}
