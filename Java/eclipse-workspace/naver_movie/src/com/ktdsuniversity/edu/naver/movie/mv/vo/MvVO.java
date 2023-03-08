package com.ktdsuniversity.edu.naver.movie.mv.vo;

import java.util.List;

import com.ktdsuniversity.edu.naver.movie.cmpny.vo.CmpnyVO;
import com.ktdsuniversity.edu.naver.movie.cntr.vo.CntrVO;
import com.ktdsuniversity.edu.naver.movie.gnr.vo.GnrVO;
import com.ktdsuniversity.edu.naver.movie.mvppl.vo.MvPplVO;

public class MvVO {
	private String mvId;
	private String mvTtl;
	private String engTtl;
	private String scrnStt;
	private int scrnTm;
	private String opngDt;
	private String wtcGrd;
	private String pstr;
	private String smr;

	private List<GnrVO> gnrList;
	private List<CntrVO> cntrList;
	private List<CmpnyVO> cmpnyList;
	private List<MvPplVO> prdcMvPplList;
	private List<MvPplVO> fmsLnMvPplList;
	
	public String getMvId() {
		return mvId;
	}

	public void setMvId(String mvId) {
		this.mvId = mvId;
	}

	public String getMvTtl() {
		return mvTtl;
	}

	public void setMvTtl(String mvTtl) {
		this.mvTtl = mvTtl;
	}

	public String getEngTtl() {
		return engTtl;
	}

	public void setEngTtl(String engTtl) {
		this.engTtl = engTtl;
	}

	public String getScrnStt() {
		return scrnStt;
	}

	public void setScrnStt(String scrnStt) {
		this.scrnStt = scrnStt;
	}

	public int getScrnTm() {
		return scrnTm;
	}

	public void setScrnTm(int scrnTm) {
		this.scrnTm = scrnTm;
	}

	public String getOpngDt() {
		return opngDt;
	}

	public void setOpngDt(String opngDt) {
		this.opngDt = opngDt;
	}

	public String getWtcGrd() {
		return wtcGrd;
	}

	public void setWtcGrd(String wtcGrd) {
		this.wtcGrd = wtcGrd;
	}

	public String getPstr() {
		return pstr;
	}

	public void setPstr(String pstr) {
		this.pstr = pstr;
	}

	public String getSmr() {
		return smr;
	}

	public void setSmr(String smr) {
		this.smr = smr;
	}

	public List<GnrVO> getGnrList() {
		return gnrList;
	}

	public void setGnrList(List<GnrVO> gnrList) {
		this.gnrList = gnrList;
	}

	public List<CntrVO> getCntrList() {
		return cntrList;
	}

	public void setCntrList(List<CntrVO> cntrList) {
		this.cntrList = cntrList;
	}

	public List<CmpnyVO> getCmpnyList() {
		return cmpnyList;
	}

	public void setCmpnyList(List<CmpnyVO> cmpnyList) {
		this.cmpnyList = cmpnyList;
	}

	public List<MvPplVO> getPrdcMvPplList() {
		return prdcMvPplList;
	}

	public void setPrdcMvPplList(List<MvPplVO> prdcMvPplList) {
		this.prdcMvPplList = prdcMvPplList;
	}

	public List<MvPplVO> getFmsLnMvPplList() {
		return fmsLnMvPplList;
	}

	public void setFmsLnMvPplList(List<MvPplVO> fmsLnMvPplList) {
		this.fmsLnMvPplList = fmsLnMvPplList;
	}
}
