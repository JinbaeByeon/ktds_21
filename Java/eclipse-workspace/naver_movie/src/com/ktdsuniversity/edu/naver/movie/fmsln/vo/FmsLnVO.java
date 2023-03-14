package com.ktdsuniversity.edu.naver.movie.fmsln.vo;

import com.ktdsuniversity.edu.naver.movie.mv.vo.PrdcPrtcptnPplVO;
import com.ktdsuniversity.edu.naver.movie.utils.db.Column;
import com.ktdsuniversity.edu.naver.movie.utils.db.UseColumn;

@UseColumn
public class FmsLnVO {
	@Column("FMS_LN_ID")
	private String fmsLnId;
	@Column("FMS_LN")
	private String fmsLn;
	@Column("EXPL")
	private String expl;
	@Column("RGST_DT")
	private String rgstDt;
	@Column("RGST_PPL_NM")
	private String rgstPplNm;
	@Column("RCMD_CNT")
	private int rcmdCnt;
	@Column("PRDC_PRTCPTN_ID")
	private String prdcPrtcptnId;
	
	private PrdcPrtcptnPplVO mvPplVO;
	
	public String getFmsLnId() {
		return fmsLnId;
	}

	public void setFmsLnId(String fmsLnId) {
		this.fmsLnId = fmsLnId;
	}

	public String getFmsLn() {
		return fmsLn;
	}

	public void setFmsLn(String fmsLn) {
		this.fmsLn = fmsLn;
	}

	public String getExpl() {
		return expl;
	}

	public void setExpl(String expl) {
		this.expl = expl;
	}

	public String getRgstDt() {
		return rgstDt;
	}

	public void setRgstDt(String rgstDt) {
		this.rgstDt = rgstDt;
	}

	public String getRgstPplNm() {
		return rgstPplNm;
	}

	public void setRgstPplNm(String rgstPplNm) {
		this.rgstPplNm = rgstPplNm;
	}

	public int getRcmdCnt() {
		return rcmdCnt;
	}

	public void setRcmdCnt(int rcmdCnt) {
		this.rcmdCnt = rcmdCnt;
	}
	
	public String getPrdcPrtcptnId() {
		return prdcPrtcptnId;
	}

	public void setPrdcPrtcptnId(String prdcPrtcptnId) {
		this.prdcPrtcptnId = prdcPrtcptnId;
	}

	public PrdcPrtcptnPplVO getMvPplVO() {
		return mvPplVO;
	}

	public void setMvPplVO(PrdcPrtcptnPplVO mvPplVO) {
		this.mvPplVO = mvPplVO;
	}

	@Override
	public String toString() {
		String res = "fmsLnId : " + fmsLnId + "\t"
				   + "fmsLn : " + fmsLn + "\t"
				   + "expl : " + expl + "\t"
				   + "rgstDt : " + rgstDt + "\t"
				   + "rgstPplNm : " + rgstPplNm + "\t"
				   + "rcmdCnt : " + rcmdCnt;
		return res;
	}
}
