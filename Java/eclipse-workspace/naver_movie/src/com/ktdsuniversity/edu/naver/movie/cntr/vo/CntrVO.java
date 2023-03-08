package com.ktdsuniversity.edu.naver.movie.cntr.vo;

public class CntrVO {
	int cntrId;
	String cntrNm;

	public int getCntrId() {
		return cntrId;
	}

	public void setCntrId(int cntrId) {
		this.cntrId = cntrId;
	}

	public String getCntrNm() {
		return cntrNm;
	}

	public void setCntrNm(String cntrNm) {
		this.cntrNm = cntrNm;
	}

	@Override
	public String toString() {
		String res = "cntrId : " + cntrId
				 + ", cntrNm : " + cntrNm;
		return res;
	}
}
