package com.ktdsuniversity.admin.mv.vo;

import java.util.List;

import com.ktdsuniversity.admin.common.vo.AbstractVO;
import com.ktdsuniversity.admin.mbr.vo.MbrVO;
import com.ktdsuniversity.admin.mvgnr.vo.MvGnrVO;
import com.ktdsuniversity.admin.prdcprtcptnppl.vo.PrdcPrtcptnPplVO;

/**
 * MV
 */
public class MvVO extends AbstractVO{

	private String mvId;
	private String mvTtl;
	private String engTtl;
	private String scrnStt;
	private int scrnTm;
	private String opngDt;
	private String wtcGrd;
	private String pstr;
	private String smr;
	private String crtDt;
	private String crtr;
	private String mdfyDt;
	private String mdfyr;
	private String useYn;
	private String delYn;

	private MbrVO ctrMbr;
	private MbrVO mdfyMbr;

	private List<MvGnrVO> gnrList;
	private List<PrdcPrtcptnPplVO> pplList;
	
	public void setMvId(String mvId) {
		this.mvId = mvId;
	}

	public String getMvId() {
		return this.mvId;
	}

	public void setMvTtl(String mvTtl) {
		this.mvTtl = mvTtl;
	}

	public String getMvTtl() {
		return this.mvTtl;
	}

	public void setEngTtl(String engTtl) {
		this.engTtl = engTtl;
	}

	public String getEngTtl() {
		return this.engTtl;
	}

	public void setScrnStt(String scrnStt) {
		this.scrnStt = scrnStt;
	}

	public String getScrnStt() {
		return this.scrnStt;
	}

	public void setScrnTm(int scrnTm) {
		this.scrnTm = scrnTm;
	}

	public int getScrnTm() {
		return this.scrnTm;
	}

	public void setOpngDt(String opngDt) {
		this.opngDt = opngDt;
	}

	public String getOpngDt() {
		return this.opngDt;
	}

	public void setWtcGrd(String wtcGrd) {
		this.wtcGrd = wtcGrd;
	}

	public String getWtcGrd() {
		return this.wtcGrd;
	}

	public void setPstr(String pstr) {
		this.pstr = pstr;
	}

	public String getPstr() {
		return this.pstr;
	}

	public void setSmr(String smr) {
		this.smr = smr;
	}

	public String getSmr() {
		return this.smr;
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

	public MbrVO getCtrMbr() {
		return ctrMbr;
	}

	public void setCtrMbr(MbrVO ctrMbr) {
		this.ctrMbr = ctrMbr;
	}

	public MbrVO getMdfyMbr() {
		return mdfyMbr;
	}

	public void setMdfyMbr(MbrVO mdfyMbr) {
		this.mdfyMbr = mdfyMbr;
	}

	public List<MvGnrVO> getGnrList() {
		return gnrList;
	}

	public void setGnrList(List<MvGnrVO> gnrList) {
		this.gnrList = gnrList;
	}

	public List<PrdcPrtcptnPplVO> getPplList() {
		return pplList;
	}

	public void setPplList(List<PrdcPrtcptnPplVO> pplList) {
		this.pplList = pplList;
	}

}