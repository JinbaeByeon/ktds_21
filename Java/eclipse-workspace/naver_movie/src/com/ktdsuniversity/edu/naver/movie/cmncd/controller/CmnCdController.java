package com.ktdsuniversity.edu.naver.movie.cmncd.controller;

import java.util.List;

import com.ktdsuniversity.edu.naver.movie.Inf.MyController;
import com.ktdsuniversity.edu.naver.movie.cmncd.service.CmnCdService;
import com.ktdsuniversity.edu.naver.movie.cmncd.service.CmnCdServiceImpl;
import com.ktdsuniversity.edu.naver.movie.cmncd.vo.CmnCdVO;
import com.ktdsuniversity.edu.naver.movie.utils.Utils;

public class CmnCdController implements MyController {
	CmnCdService cs;
	
	public CmnCdController() {
		cs = new CmnCdServiceImpl();
	}

	private String getPrcdncId(String cmnCdId) {
		if(cmnCdId.contains("_")) {
			int endIdx = cmnCdId.lastIndexOf("_");
			return cmnCdId.substring(0,endIdx);
		}
		return null;		
	}

	@Override
	public void create() {
		createCmnCd(Utils.getNextLine("생성할 공통코드의 Id를 입력하세요.")
				  , Utils.getNextLine("생성할 공통코드명을 입력하세요."));
		
	}
	private void createCmnCd(String cmnCdId
								  , String cdNm) {
		CmnCdVO cmnCdVO = new CmnCdVO();
		cmnCdVO.setCmnCdId(cmnCdId);
		cmnCdVO.setCdNm(cdNm);
		cmnCdVO.setPrcdncCdId(getPrcdncId(cmnCdId));
		System.out.print(cdNm + " - ");
		if (cs.create(cmnCdVO)) {
			System.out.println("공통코드 등록 성공");
		} else {
			System.out.println("공통코드 등록 실패");
		}
	}

	@Override
	public void readAll() {
		readAllCmnCd();
	}
	private void readAllCmnCd() {
		List<CmnCdVO> list = cs.readAll();
		list.forEach(System.out::println);
	}

	@Override
	public void read() {
		readCmnCd(Utils.getNextLine("조회할 Id를 입력하세요."));		
	}
	private void readCmnCd(String cmnCdId) {
		System.out.println(cs.read(cmnCdId));
	}
	
	@Override
	public void update() {
		updateCmnCd(Utils.getNextLine("수정할 Id를 입력하세요.")
			      , Utils.getNextLine("생성할 공통코드명을 입력하세요."));		
	}
	private void updateCmnCd(String cmnCdId
								  , String cdNm) {
		CmnCdVO cmnCdVO = new CmnCdVO();
		cmnCdVO.setCmnCdId(cmnCdId);
		cmnCdVO.setCdNm(cdNm);
		cmnCdVO.setPrcdncCdId(getPrcdncId(cmnCdId));
		
		System.out.print(cmnCdId + " - ");
		if (cs.update(cmnCdVO)) {
			System.out.println("공통코드 수정 성공");
		} else {
			System.out.println("공통코드 수정 실패");
		}
	}

	@Override
	public void delete() {
		deleteCmnCd(Utils.getNextLine("삭제할 Id를 입력하세요."));
		
	}
	private void deleteCmnCd(String cmnCdId) {
		System.out.print(cmnCdId + " - ");
		if(cs.delete(cmnCdId)) {
			System.out.println("공통코드 삭제 성공");
		} else {
			System.out.println("공통코드 삭제 실패");
		}
	}
}
