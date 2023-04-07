package com.ktdsuniversity.admin.mvgnr.vo;

import java.util.List;

import com.ktdsuniversity.admin.gnr.vo.GnrVO;
import com.ktdsuniversity.admin.mbr.vo.MbrVO;

/**
 * MV_GNR
 */
public class MvGnrVO {

	private String mvId;
	private int gnrId;
	private String crtDt;
	private String crtr;
	private String useYn;
	private String delYn;

	private List<String> deleted;
	
	private GnrVO gnr;
	private MbrVO ctrMbr;

	public void setMvId(String mvId) {
		this.mvId = mvId;
	}

	public String getMvId() {
		return this.mvId;
	}

	public void setGnrId(int gnrId) {
		this.gnrId = gnrId;
	}

	public int getGnrId() {
		return this.gnrId;
	}

	public void setCrtDt(String crtDt) {
		this.crtDt = crtDt;
	}

	public String getCrtDt() {
		return this.crtDt;
	}

	public void setCrtr(String crtr) {
		this.crtr = crtr;
	}

	public String getCrtr() {
		return this.crtr;
	}

	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}

	public String getUseYn() {
		return this.useYn;
	}

	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}

	public String getDelYn() {
		return this.delYn;
	}

	public List<String> getDeleted() {
		return deleted;
	}

	public void setDeleted(List<String> deleted) {
		this.deleted = deleted;
	}

	public GnrVO getGnr() {
		return gnr;
	}

	public void setGnr(GnrVO gnr) {
		this.gnr = gnr;
	}

	public MbrVO getCtrMbr() {
		return ctrMbr;
	}

	public void setCtrMbr(MbrVO ctrMbr) {
		this.ctrMbr = ctrMbr;
	}
	
}