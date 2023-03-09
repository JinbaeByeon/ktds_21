package com.ktdsuniversity.edu.naver.movie.gnr.vo;

public class GnrVO {
	private int gnrId;
	private String gnrNm;
	
	public int getGnrId() {
		return gnrId;
	}
	public void setGnrId(int gnrId) {
		this.gnrId = gnrId;
	}
	public String getGnrNm() {
		return gnrNm;
	}
	public void setGnrNm(String gnrNm) {
		this.gnrNm = gnrNm;
	}
	
	@Override
	public String toString() {
		String res = "gnrId : " + gnrId
				   + ", gnrNm : " + gnrNm;
		return res;
	}
}
