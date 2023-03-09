package com.ktdsuniversity.edu.naver.movie.pctr.vo;

public class PctrVO {
	private String pctrId;
	private String mvId;
	private String pctrTp;
	private String thmbnlPctr;
	private String orgnlPctr;
	
	public String getPctrId() {
		return pctrId;
	}

	public void setPctrId(String pctrId) {
		this.pctrId = pctrId;
	}

	public String getMvId() {
		return mvId;
	}

	public void setMvId(String mvId) {
		this.mvId = mvId;
	}

	public String getPctrTp() {
		return pctrTp;
	}

	public void setPctrTp(String pctrTp) {
		this.pctrTp = pctrTp;
	}

	public String getThmbnlPctr() {
		return thmbnlPctr;
	}

	public void setThmbnlPctr(String thmbnlPctr) {
		this.thmbnlPctr = thmbnlPctr;
	}

	public String getOrgnlPctr() {
		return orgnlPctr;
	}

	public void setOrgnlPctr(String orgnlPctr) {
		this.orgnlPctr = orgnlPctr;
	}

	@Override
	public String toString() {
		String res = "pctrId : " + pctrId
				 + ", mvId : " + mvId
				 + ", pctrTp : " + pctrTp
				 + ", thmbnlPctr : " + thmbnlPctr
				 + ", orgnlPctr : " + orgnlPctr;
		return res;
	}
}
