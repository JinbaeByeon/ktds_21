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
	private List<PrdcPrtcptnCmpnyVO> cmpnyList;
	private List<PrdcPrtcptnPplVO> prdcMvPplList;
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

	public List<PrdcPrtcptnCmpnyVO> getCmpnyList() {
		return cmpnyList;
	}

	public void setCmpnyList(List<PrdcPrtcptnCmpnyVO> cmpnyList) {
		this.cmpnyList = cmpnyList;
	}

	public List<PrdcPrtcptnPplVO> getPrdcMvPplList() {
		return prdcMvPplList;
	}

	public void setPrdcMvPplList(List<PrdcPrtcptnPplVO> prdcMvPplList) {
		this.prdcMvPplList = prdcMvPplList;
	}

	public List<MvPplVO> getFmsLnMvPplList() {
		return fmsLnMvPplList;
	}

	public void setFmsLnMvPplList(List<MvPplVO> fmsLnMvPplList) {
		this.fmsLnMvPplList = fmsLnMvPplList;
	}
	@Override
	public String toString() {

		String res = "mvId : " + mvId
			+ "\t" + "mvTtl : " + mvTtl
			+ "\t" + "engTtl : " + engTtl
			+ "\t" + "scrnStt : " + scrnStt
			+ "\t" + "scrnTm : " + scrnTm
			+ "\t" + "opngDt : " + opngDt
			+ "\t" + "wtcGrd : " + wtcGrd
			+ "\t" + "pstr : " + pstr
			+ "\t" + "smr : " + smr;
		if(gnrList != null) {
			res += "\n장르\n";
			for(GnrVO gnr : gnrList) {
				res += "\t" + gnr + "\n";
			}
		}
		if(cntrList != null) {
			res += "\n제작지\n";
			for(CntrVO cntr : cntrList) {
				res += "\t" + cntr + "\n";
			}
		}
		if(cmpnyList != null) {
			res += "\n제작참여사\n";
			for(CmpnyVO cmpny : cmpnyList) {
				res += "\t" + cmpny + "\n";
			}
		}
		if(prdcMvPplList != null) {
			res += "\n제작참여인\n";
			for(PrdcPrtcptnPplVO prdcMvPpl : prdcMvPplList) {
				res += "\t" + prdcMvPpl + "\n";
			}
		}
		if(fmsLnMvPplList != null) {
			res += "\n명대사\n";
			for(MvPplVO fmsLnMvPpl : fmsLnMvPplList) {
				res += "\t" + fmsLnMvPpl + "\n";
			}
		}
		return res;
	}
}
