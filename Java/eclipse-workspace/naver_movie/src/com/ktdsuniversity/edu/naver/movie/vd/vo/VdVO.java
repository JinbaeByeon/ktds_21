package com.ktdsuniversity.edu.naver.movie.vd.vo;

import com.ktdsuniversity.edu.naver.movie.utils.db.Column;
import com.ktdsuniversity.edu.naver.movie.utils.db.UseColumn;

@UseColumn
public class VdVO {
	@Column("VD_ID")
	private String vdId;
	@Column("MV_ID")
	private String mvId;
	@Column("VD_TP")
	private String vdTp;
	@Column("TTL")
	private String ttl;
	@Column("THMBNL")
	private String thmbnl;
	@Column("PL_CNT")
	private int plCnt;
	@Column("VD_URL")
	private String vdUrl;
	@Column("RGST_DT")
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
