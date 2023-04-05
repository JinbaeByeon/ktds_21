package com.ktdsuniversity.admin.cntr.vo;

import com.ktdsuniversity.admin.common.vo.AbstractVO;
import com.ktdsuniversity.admin.mbr.vo.MbrVO;

/**
 * CNTR
 */
public class CntrVO extends AbstractVO{
	
	private int cntrId;
	private String cntrNm;
	private String crtDt;
	private String crtr;
	private String mdfyDt;
	private String mdfyr;
	private String useYn;
	private String delYn;
	
	private MbrVO crtMbr;
	private MbrVO mdfyMbr;
	
	public void setCntrId(int cntrId) {
		this.cntrId = cntrId;
	}

	public int getCntrId() {
		return this.cntrId;
	}

	public void setCntrNm(String cntrNm) {
		this.cntrNm = cntrNm;
	}

	public String getCntrNm() {
		return this.cntrNm;
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