package com.ktdsuniversity.edu.naver.movie.mvppl.vo;

public class MvPplVO {
	String mvPplId;
	String prflPctr;
	String nm;
	String rlNm;

	public String getMvPplId() {
		return mvPplId;
	}

	public void setMvPplId(String mvPplId) {
		this.mvPplId = mvPplId;
	}

	public String getPrflPctr() {
		return prflPctr;
	}

	public void setPrflPctr(String prflPctr) {
		this.prflPctr = prflPctr;
	}

	public String getNm() {
		return nm;
	}

	public void setNm(String nm) {
		this.nm = nm;
	}

	public String getRlNm() {
		return rlNm;
	}

	public void setRlNm(String rlNm) {
		this.rlNm = rlNm;
	}

	@Override
	public String toString() {
		String res = "mvPplId : " + mvPplId
				 + ", prflPctr : " + prflPctr
				 + ", nm : " + nm
				 + ", rlNm : " + rlNm;
		return res;
	}
}
