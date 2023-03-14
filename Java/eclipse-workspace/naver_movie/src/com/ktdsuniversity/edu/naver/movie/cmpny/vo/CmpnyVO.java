package com.ktdsuniversity.edu.naver.movie.cmpny.vo;

import com.ktdsuniversity.edu.naver.movie.utils.db.Column;
import com.ktdsuniversity.edu.naver.movie.utils.db.UseColumn;

@UseColumn(keyColum = "CMPNY_ID", keyVarName = "cmpnyId", keyType = String.class)
public class CmpnyVO {
	@Column(value = "CMPNY_ID", isRequire = true)
	private String cmpnyId;
	@Column("CMPNY_NM")
	private String cmpnyNm;
	
	public String getCmpnyId() {
		return cmpnyId;
	}
	public void setCmpnyId(String cmpnyId) {
		this.cmpnyId = cmpnyId;
	}
	public String getCmpnyNm() {
		return cmpnyNm;
	}
	public void setCmpnyNm(String cmpnyNm) {
		this.cmpnyNm = cmpnyNm;
	}
	
	@Override
	public String toString() {
		String res = "cmpnyId : " + cmpnyId
				   + ", cmpnyNm : " + cmpnyNm;
		return res;
	}
}
