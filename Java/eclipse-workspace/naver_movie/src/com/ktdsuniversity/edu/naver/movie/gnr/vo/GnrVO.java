package com.ktdsuniversity.edu.naver.movie.gnr.vo;

import com.ktdsuniversity.edu.naver.movie.utils.db.Column;
import com.ktdsuniversity.edu.naver.movie.utils.db.UseColumn;

@UseColumn(keyColum = "GNR_ID", keyVarName = "gnrId", keyType = int.class)
public class GnrVO {
	@Column(value = "GNR_ID", isRequire = true)
	private int gnrId;
	@Column("GNR_NM")
	private String gnrNm;
	
	public int getGnrId() {
		return gnrId;
	}
	public void setGnrId(int gnrId) {
		this.gnrId = gnrId;
	}
	public String getGnrNm() {
		return gnrNm;
	}
	public void setGnrNm(String gnrNm) {
		this.gnrNm = gnrNm;
	}
	
	@Override
	public String toString() {
		String res = "gnrId : " + gnrId
				   + ", gnrNm : " + gnrNm;
		return res;
	}
}
