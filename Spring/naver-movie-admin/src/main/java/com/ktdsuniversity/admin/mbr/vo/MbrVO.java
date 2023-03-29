package com.ktdsuniversity.admin.mbr.vo;

/**
 * MBR
 */
public class MbrVO {

	private String mbrId;
	private String mbrNm;
	private String pwd;
	private String rgstDt;
	private String useYn;
	private String ltstLgnDt;
	private String ltstLgnIp;
	private int lgnTryCnt;
	private String lgnBlockYn;
	private String ltstLgnFailDt;
	private String pwdSalt;
	private String ltstPwdChngDt;
	private String admYn;


	public void setMbrId(String mbrId) {
		this.mbrId = mbrId;
	}

	public String getMbrId() {
		return this.mbrId;
	}

	public void setMbrNm(String mbrNm) {
		this.mbrNm = mbrNm;
	}

	public String getMbrNm() {
		return this.mbrNm;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getPwd() {
		return this.pwd;
	}

	public void setRgstDt(String rgstDt) {
		this.rgstDt = rgstDt;
	}

	public String getRgstDt() {
		return this.rgstDt;
	}

	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}

	public String getUseYn() {
		return this.useYn;
	}

	public void setLtstLgnDt(String ltstLgnDt) {
		this.ltstLgnDt = ltstLgnDt;
	}

	public String getLtstLgnDt() {
		return this.ltstLgnDt;
	}

	public void setLtstLgnIp(String ltstLgnIp) {
		this.ltstLgnIp = ltstLgnIp;
	}

	public String getLtstLgnIp() {
		return this.ltstLgnIp;
	}

	public void setLgnTryCnt(int lgnTryCnt) {
		this.lgnTryCnt = lgnTryCnt;
	}

	public int getLgnTryCnt() {
		return this.lgnTryCnt;
	}

	public void setLgnBlockYn(String lgnBlockYn) {
		this.lgnBlockYn = lgnBlockYn;
	}

	public String getLgnBlockYn() {
		return this.lgnBlockYn;
	}

	public void setLtstLgnFailDt(String ltstLgnFailDt) {
		this.ltstLgnFailDt = ltstLgnFailDt;
	}

	public String getLtstLgnFailDt() {
		return this.ltstLgnFailDt;
	}

	public void setPwdSalt(String pwdSalt) {
		this.pwdSalt = pwdSalt;
	}

	public String getPwdSalt() {
		return this.pwdSalt;
	}

	public void setLtstPwdChngDt(String ltstPwdChngDt) {
		this.ltstPwdChngDt = ltstPwdChngDt;
	}

	public String getLtstPwdChngDt() {
		return this.ltstPwdChngDt;
	}

	public void setAdmYn(String admYn) {
		this.admYn = admYn;
	}

	public String getAdmYn() {
		return this.admYn;
	}

}