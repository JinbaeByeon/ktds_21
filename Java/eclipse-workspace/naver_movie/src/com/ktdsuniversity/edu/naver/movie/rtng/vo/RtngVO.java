package com.ktdsuniversity.edu.naver.movie.rtng.vo;

public class RtngVO {
	private String rtngId;
	private String mvId;
	private int rtng;
	private String dtl;
	private String wrtr;
	private String rgstDt;
	private int lkCnt;
	private int dslkCnt;

	public String getRtngId() {
		return rtngId;
	}

	public void setRtngId(String rtngId) {
		this.rtngId = rtngId;
	}

	public String getMvId() {
		return mvId;
	}

	public void setMvId(String mvId) {
		this.mvId = mvId;
	}

	public int getRtng() {
		return rtng;
	}

	public void setRtng(int rtng) {
		this.rtng = rtng;
	}

	public String getDtl() {
		return dtl;
	}

	public void setDtl(String dtl) {
		this.dtl = dtl;
	}

	public String getWrtr() {
		return wrtr;
	}

	public void setWrtr(String wrtr) {
		this.wrtr = wrtr;
	}

	public String getRgstDt() {
		return rgstDt;
	}

	public void setRgstDt(String rgstDt) {
		this.rgstDt = rgstDt;
	}

	public int getLkCnt() {
		return lkCnt;
	}

	public void setLkCnt(int lkCnt) {
		this.lkCnt = lkCnt;
	}

	public int getDslkCnt() {
		return dslkCnt;
	}

	public void setDslkCnt(int dslkCnt) {
		this.dslkCnt = dslkCnt;
	}
	@Override
	public String toString() {
		String res = "mvId : " + mvId + "\t"
				   + "rtng : " + rtng + "\t"
				   + "dtl : " + dtl + "\t"
				   + "wrtr : " + wrtr + "\t"
				   + "rgstDt : " + rgstDt + "\t";
		return res;
	}
}
