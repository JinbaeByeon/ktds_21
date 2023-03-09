package com.ktdsuniversity.edu.naver.movie.cmpny.vo;

public class CmpnyVO {
	private String cmpnyId;
	private String cmpnyNm;
	
	public String getCmpnyId() {
		return cmpnyId;
	}
	public void setCmpnyId(String cmpnyId) {
		this.cmpnyId = cmpnyId;
	}
	public String getCmpnyNm() {
		return cmpnyNm;
	}
	public void setCmpnyNm(String cmpnyNm) {
		this.cmpnyNm = cmpnyNm;
	}
	
	@Override
	public String toString() {
		String res = "cmpnyId : " + cmpnyId
				   + ", cmpnyNm : " + cmpnyNm;
		return res;
	}
}
