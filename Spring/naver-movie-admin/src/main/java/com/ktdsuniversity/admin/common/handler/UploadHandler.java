package com.ktdsuniversity.admin.common.handler;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.ktdsuniversity.admin.mvppl.vo.MvPplVO;

@Component
public class UploadHandler {
	
	private static final Logger logger = LoggerFactory.getLogger(UploadHandler.class);
	@Autowired
//	private FileDAO fileDAO;
	
	@Value("${upload.profile.path:C:/naver-movie-admin/files/profiles}")
	private String profilePath;

	@Value("${upload.path:C:/naver-movie-admin/files}")
	private String uploadPath;
	
	public String getUploadPath() {
		return uploadPath;
	}
	
	public void upload(List<MultipartFile> fileList,int boardId) {
		fileList.forEach(file ->uploadFile(file,boardId));
	}
	
	public void uploadFile(MultipartFile file, int boardId) {
		if(file != null && !file.isEmpty()) {
			String fileName = UUID.randomUUID().toString();
			
			File uploadDir = new File(uploadPath);
			if(!uploadDir.exists()) {
				uploadDir.mkdirs();
			}
			
			try {
				file.transferTo(new File(uploadPath,fileName));
			} catch (IllegalStateException | IOException e) {
				logger.error(e.getMessage(),e);
				throw new RuntimeException(e.getMessage(),e);
			}
			
		}
	}
	
	public void uploadProfile(MultipartFile file, MvPplVO mvPplVO) {
		if(file != null && !file.isEmpty()) {
			String fileName = UUID.randomUUID().toString();
			
			File uploadDir = new File(profilePath);
			if(!uploadDir.exists()) {
				uploadDir.mkdirs();
			}
			
			try {
				file.transferTo(new File(profilePath,fileName));
			} catch (IllegalStateException | IOException e) {
				throw new RuntimeException(e.getMessage(),e);
			}
			mvPplVO.setPrflPctr(fileName);
		}
	}
	
}
