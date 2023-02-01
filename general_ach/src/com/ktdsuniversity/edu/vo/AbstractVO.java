package com.ktdsuniversity.edu.vo;

public abstract class AbstractVO {
	/**
	 * 글 번호
	 */
	private int readNumber;
	/**
	 * 페이지 번호
	 */
	private int pageNumber;

	public int getReadNumber() {
		return readNumber;
	}

	public AbstractVO setReadNumber(int readNumber) {
		this.readNumber = readNumber;
		return this;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public AbstractVO setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
		return this;
	}
	@Override
	public String toString() {
		return "readNumber: " + readNumber + ", pageNumber: " + pageNumber; 
	}

}
