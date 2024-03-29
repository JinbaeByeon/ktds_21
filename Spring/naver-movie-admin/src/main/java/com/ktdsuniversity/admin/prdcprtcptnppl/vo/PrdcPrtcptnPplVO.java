package com.ktdsuniversity.admin.prdcprtcptnppl.vo;

import java.util.List;

import com.ktdsuniversity.admin.mbr.vo.MbrVO;
import com.ktdsuniversity.admin.mvppl.vo.MvPplVO;

/**
 * PRDC_PRTCPTN_PPL
 */
public class PrdcPrtcptnPplVO {

	private String prdcPrtcptnId;
	private String mvId;
	private String mvPplId;
	private String rolTp;
	private String rspnsbltRolNm;
	private String crtDt;
	private String crtr;
	private String useYn;
	private String delYn;

	private List<String> deleted;
	
	private MvPplVO mvPpl;
	private MbrVO crtMbr;
	
	public void setPrdcPrtcptnId(String prdcPrtcptnId) {
		this.prdcPrtcptnId = prdcPrtcptnId;
	}

	public String getPrdcPrtcptnId() {
		return this.prdcPrtcptnId;
	}

	public void setMvId(String mvId) {
		this.mvId = mvId;
	}

	public String getMvId() {
		return this.mvId;
	}

	public void setMvPplId(String mvPplId) {
		this.mvPplId = mvPplId;
	}

	public String getMvPplId() {
		return this.mvPplId;
	}

	public void setRolTp(String rolTp) {
		this.rolTp = rolTp;
	}

	public String getRolTp() {
		return this.rolTp;
	}

	public void setRspnsbltRolNm(String rspnsbltRolNm) {
		this.rspnsbltRolNm = rspnsbltRolNm;
	}

	public String getRspnsbltRolNm() {
		return this.rspnsbltRolNm;
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

	public MvPplVO getMvPpl() {
		return mvPpl;
	}

	public void setMvPpl(MvPplVO mvPpl) {
		this.mvPpl = mvPpl;
	}

	public MbrVO getCrtMbr() {
		return crtMbr;
	}

	public void setCrtMbr(MbrVO crtMbr) {
		this.crtMbr = crtMbr;
	}

}