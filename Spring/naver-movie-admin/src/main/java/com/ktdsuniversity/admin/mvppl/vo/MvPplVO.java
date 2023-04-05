package com.ktdsuniversity.admin.mvppl.vo;

import com.ktdsuniversity.admin.common.util.StringUtil;
import com.ktdsuniversity.admin.common.vo.AbstractVO;
import com.ktdsuniversity.admin.mbr.vo.MbrVO;

/**
 * MV_PPL
 */
public class MvPplVO extends AbstractVO{
	
	private String mvPplId;
	private String prflPctr;
	private String nm;
	private String rlNm;
	private String crtDt;
	private String crtr;
	private String mdfyDt;
	private String mdfyr;
	private String useYn;
	private String delYn;
	
	private MbrVO crtMbr;
	private MbrVO mdfyMbr;
	
	private String isDeletePctr;
	
	public void setMvPplId(String mvPplId) {
		this.mvPplId = mvPplId;
	}

	public String getMvPplId() {
		return this.mvPplId;
	}

	public void setPrflPctr(String prflPctr) {
		this.prflPctr = prflPctr;
	}

	public String getPrflPctr() {
		return this.prflPctr;
	}

	public void setNm(String nm) {
		this.nm = nm;
	}

	public String getNm() {
		return this.nm;
	}

	public void setRlNm(String rlNm) {
		this.rlNm = rlNm;
	}

	public String getRlNm() {
		return this.rlNm;
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
	
	public String getIsDeletePctr() {
		return isDeletePctr;
	}

	public void setIsDeletePctr(String isDeletePctr) {
		this.isDeletePctr = isDeletePctr;
	}

	public boolean checkModify(MvPplVO mvPplVO) {
		boolean isModify =false;
		System.out.println(prflPctr + ", " + isDeletePctr);
		if(StringUtil.isEmpty(prflPctr) && isDeletePctr.equals("N")) {
			prflPctr= mvPplVO.prflPctr;
		} else {
			isModify = true;
		}
		if(!nm.equals(mvPplVO.nm)) {
			isModify = true;
		} else {
			nm = null;
		}
		if(!rlNm.equals(mvPplVO.rlNm)) {
			isModify = true;
		}
		useYn = StringUtil.isEmpty(useYn) ? "N" : useYn;
		if(!useYn.equals(mvPplVO.useYn)) {
			isModify = true;
		} else {
			useYn = null;
		}
		return isModify;
	}
}