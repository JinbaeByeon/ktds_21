package com.ktdsuniversity.edu.naver.movie.cntr.vo;

import com.ktdsuniversity.edu.naver.movie.utils.db.Column;
import com.ktdsuniversity.edu.naver.movie.utils.db.UseColumn;

@UseColumn(keyColum = "CNTR_ID", keyVarName = "cntrId", keyType = int.class)
public class CntrVO {
	@Column(value = "CNTR_ID", isRequire = true)
	private int cntrId;
	@Column("CNTR_NM")
	private String cntrNm;

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
