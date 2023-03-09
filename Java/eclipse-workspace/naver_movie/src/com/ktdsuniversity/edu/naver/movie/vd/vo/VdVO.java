package com.ktdsuniversity.edu.naver.movie.vd.vo;

public class VdVO {
	private String vdId;
	private String mvId;
	private String vdTp;
	private String ttl;
	private String thmbnl;
	private int plCnt;
	private String vdUrl;
	private String rgstDt;

	public String getVdId() {
		return vdId;
	}

	public void setVdId(String vdId) {
		this.vdId = vdId;
	}

	public String getMvId() {
		return mvId;
	}

	public void setMvId(String mvId) {
		this.mvId = mvId;
	}

	public String getVdTp() {
		return vdTp;
	}

	public void setVdTp(String vdTp) {
		this.vdTp = vdTp;
	}

	public String getTtl() {
		return ttl;
	}

	public void setTtl(String ttl) {
		this.ttl = ttl;
	}

	public String getThmbnl() {
		return thmbnl;
	}

	public void setThmbnl(String thmbnl) {
		this.thmbnl = thmbnl;
	}

	public int getPlCnt() {
		return plCnt;
	}

	public void setPlCnt(int plCnt) {
		this.plCnt = plCnt;
	}

	public String getVdUrl() {
		return vdUrl;
	}

	public void setVdUrl(String vdUrl) {
		this.vdUrl = vdUrl;
	}

	public String getRgstDt() {
		return rgstDt;
	}

	public void setRgstDt(String rgstDt) {
		this.rgstDt = rgstDt;
	}

	@Override
	public String toString() {
		String res = "vdId : " + vdId
				 + ", mvId : " + mvId
				 + ", vdTp : " + vdTp
				 + ", ttl : " + ttl
				 + ", thmbnl : " + thmbnl
				 + ", plCnt : " + plCnt
				 + ", vdUrl : " + vdUrl
				 + ", rgstDt : " + rgstDt;
		return res;
	}
}
