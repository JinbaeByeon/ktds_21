package com.ktdsuniversity.edu.naver.movie.mvppl.vo;

import com.ktdsuniversity.edu.naver.movie.utils.db.Column;
import com.ktdsuniversity.edu.naver.movie.utils.db.UseColumn;

@UseColumn(keyColum = "MV_PPL_ID", keyVarName = "mvPplId", keyType = int.class)
public class MvPplVO {
	@Column(value = "MV_PPL_ID", isRequire = true)
	private String mvPplId;
	@Column("PRFL_PCTR")
	private String prflPctr;
	@Column("NM")
	private String nm;
	@Column("RL_NM")
	private String rlNm;

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
