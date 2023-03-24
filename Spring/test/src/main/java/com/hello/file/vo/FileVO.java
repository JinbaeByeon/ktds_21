package com.hello.file.vo;

import org.springframework.web.multipart.MultipartFile;

import com.hello.common.vo.AbstractVO;

/**
 * FILE
 */
public class FileVO extends AbstractVO {

	private long fileId;
	private int boardId;
	private long fileSize;
	private String fileExt;
	
	MultipartFile file;
	
	public long getFileId() {
		return fileId;
	}

	public void setFileId(long fileId) {
		this.fileId = fileId;
	}

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	public String getFileExt() {
		return fileExt;
	}

	public void setFileExt(String fileExt) {
		this.fileExt = fileExt;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}
	

}