package com.hello.file.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.hello.common.handler.DownloadUtil;
import com.hello.common.handler.UploadHandler;
import com.hello.file.service.FileService;
import com.hello.file.vo.FileVO;

@Controller
public class FileController {
	
	private static final Logger logger = LoggerFactory.getLogger(FileController.class);
	@Autowired
	private FileService fileService;
	@Autowired
	private UploadHandler uploadHandler;
	
	@PostMapping("/board/file/create")
	public void doCreateFile(FileVO fileVO) {
		if(!fileService.createFile(fileVO)) {
			logger.info("파일이 올라가지 않음");
		}
	}

	@GetMapping("/board/download/{fileId}")
	public void downloadFile(@PathVariable int fileId
							, HttpServletRequest request
							, HttpServletResponse response) {
		FileVO fileVO = fileService.readOneFileByFileId(fileId);
		String uploadPath = uploadHandler.getUploadPath();
		new DownloadUtil(response,request,uploadPath + "/" + fileVO.getUuidFileName())
				.download(fileVO.getOriginalFileName());
	}
	
}
