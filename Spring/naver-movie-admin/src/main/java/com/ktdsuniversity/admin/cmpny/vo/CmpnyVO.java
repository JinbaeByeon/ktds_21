package com.ktdsuniversity.admin.cmpny.vo;

import com.ktdsuniversity.admin.common.vo.AbstractVO;
import com.ktdsuniversity.admin.mbr.vo.MbrVO;

/**
 * CMPNY
 */
public class CmpnyVO extends AbstractVO{

	private String cmpnyId;

	private String cmpnyNm;

	private String crtDt;

	private String crtr;

	private String mdfyDt;

	private String mdfyr;

	private String useYn;

	private String delYn;

	private MbrVO crtMbr;
	private MbrVO mdfyMbr;

	public void setCmpnyId(String cmpnyId) {
		this.cmpnyId = cmpnyId;
	}

	public String getCmpnyId() {
		return this.cmpnyId;
	}

	public void setCmpnyNm(String cmpnyNm) {
		this.cmpnyNm = cmpnyNm;
	}

	public String getCmpnyNm() {
		return this.cmpnyNm;
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

	public void setMdfyDt(String mdfyDt) {
		this.mdfyDt = mdfyDt;
	}

	public String getMdfyDt() {
		return this.mdfyDt;
	}

	public void setMdfyr(String mdfyr) {
		this.mdfyr = mdfyr;
	}

	public String getMdfyr() {
		return this.mdfyr;
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

	public MbrVO getCrtMbr() {
		return crtMbr;
	}

	public void setCrtMbr(MbrVO crtMbr) {
		this.crtMbr = crtMbr;
	}

	public MbrVO getMdfyMbr() {
		return mdfyMbr;
	}

	public void setMdfyMbr(MbrVO mdfyMbr) {
		this.mdfyMbr = mdfyMbr;
	}

}