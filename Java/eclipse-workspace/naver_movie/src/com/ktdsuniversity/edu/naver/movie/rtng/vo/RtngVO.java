package com.ktdsuniversity.edu.naver.movie.rtng.vo;

import com.ktdsuniversity.edu.naver.movie.utils.db.Column;
import com.ktdsuniversity.edu.naver.movie.utils.db.UseColumn;

@UseColumn
public class RtngVO {
	@Column("RTNG_ID")
	private String rtngId;
	@Column("MV_ID")
	private String mvId;
	@Column("RTNG")
	private int rtng;
	@Column("DTL")
	private String dtl;
	@Column("WRTR")
	private String wrtr;
	@Column("RGST_DT")
	private String rgstDt;
	@Column("LK_CNT")
	private int lkCnt;
	@Column("DSLK_CNT")
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
		String res = "rtngId : " + rtngId + "\t"
				   + "mvId : " + mvId + "\t"
				   + "rtng : " + rtng + "\t"
				   + "dtl : " + dtl + "\t"
				   + "wrtr : " + wrtr + "\t"
				   + "rgstDt : " + rgstDt + "\t";
		return res;
	}
}
