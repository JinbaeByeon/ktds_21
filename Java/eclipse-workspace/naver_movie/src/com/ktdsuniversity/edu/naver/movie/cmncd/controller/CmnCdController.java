package com.ktdsuniversity.edu.naver.movie.cmncd.controller;

import java.util.List;

import com.ktdsuniversity.edu.naver.movie.cmncd.service.CmnCdService;
import com.ktdsuniversity.edu.naver.movie.cmncd.vo.CmnCdVO;

public interface CmnCdController {
	default public void createCmnCd(CmnCdService cs
								  , String cmnCdId
								  , String cdNm) {
		CmnCdVO cmnCdVO = new CmnCdVO();
		cmnCdVO.setCmnCdId(cmnCdId);
		cmnCdVO.setCdNm(cdNm);
		if(cmnCdId.contains("_")) {
			int endIdx = cmnCdId.lastIndexOf("_");
			cmnCdVO.setPrcdncCdId(cmnCdId.substring(0,endIdx));
		}
		
		System.out.print(cdNm + " - ");
		if (cs.createCmnCd(cmnCdVO)) {
			System.out.println("공통코드 등록 성공");
		} else {
			System.out.println("공통코드 등록 실패");
		}
	}

	default public void readAllCmnCd(CmnCdService cs) {
		List<CmnCdVO> list = cs.readAllCmnCd();
		list.forEach(System.out::println);
	}

	default public void updateCmnCd(CmnCdService cs
								  , String cmnCdId
								  , String cdNm) {
		CmnCdVO cmnCdVO = new CmnCdVO();
		cmnCdVO.setCmnCdId(cmnCdId);
		cmnCdVO.setCdNm(cdNm);
		if(cmnCdId.contains("_")) {
			int endIdx = cmnCdId.lastIndexOf("_");
			cmnCdVO.setPrcdncCdId(cmnCdId.substring(0,endIdx));
		}
		
		System.out.print(cmnCdId + " - ");
		if (cs.updateCmnCd(cmnCdVO)) {
			System.out.println("공통코드 수정 성공");
		} else {
			System.out.println("공통코드 수정 실패");
		}
	}

	default public void readCmnCd(CmnCdService cs, String cmnCdId) {
		System.out.println(cs.readCmnCd(cmnCdId));
	}
	
	default public void deleteCmnCd(CmnCdService cs, String cmnCdId) {
		System.out.print(cmnCdId + " - ");
		if(cs.deleteCmnCd(cmnCdId)) {
			System.out.println("공통코드 삭제 성공");
		} else {
			System.out.println("공통코드 삭제 실패");
		}
	}
}
