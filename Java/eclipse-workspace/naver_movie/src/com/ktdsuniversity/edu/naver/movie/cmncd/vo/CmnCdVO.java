package com.ktdsuniversity.edu.naver.movie.cmncd.vo;

public class CmnCdVO {
	String cmnCdId;
	String cdNm;
	String prcdncCdId;

	public String getCmnCdId() {
		return cmnCdId;
	}

	public void setCmnCdId(String cmnCdId) {
		this.cmnCdId = cmnCdId;
	}

	public String getCdNm() {
		return cdNm;
	}

	public void setCdNm(String cdNm) {
		this.cdNm = cdNm;
	}

	public String getPrcdncCdId() {
		return prcdncCdId;
	}

	public void setPrcdncCdId(String prcdncCdId) {
		this.prcdncCdId = prcdncCdId;
	}
	
	@Override
	public String toString() {
		String res = "cmnCdId : " + cmnCdId
				 + ", cdNm : " + cdNm
				 + ", prcdncCdId : " + prcdncCdId;
		return res;
	}
}
