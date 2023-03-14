package com.ktdsuniversity.edu.naver.movie.cmncd.vo;

import com.ktdsuniversity.edu.naver.movie.utils.db.Column;
import com.ktdsuniversity.edu.naver.movie.utils.db.UseColumn;

@UseColumn
public class CmnCdVO {
	@Column("CMN_CD_ID")
	private String cmnCdId;
	@Column("CD_NM")
	private String cdNm;
	@Column("PRCDNC_CD_ID")
	private String prcdncCdId;

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
