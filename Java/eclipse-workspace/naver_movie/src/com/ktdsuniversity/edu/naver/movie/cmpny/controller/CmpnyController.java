package com.ktdsuniversity.edu.naver.movie.cmpny.controller;

import java.util.List;

import com.ktdsuniversity.edu.naver.movie.cmpny.service.CmpnyService;
import com.ktdsuniversity.edu.naver.movie.cmpny.vo.CmpnyVO;

public interface CmpnyController {
	default public void createCmpny(CmpnyService cs, String cmpnyNm) {
		CmpnyVO cmpnyVO = new CmpnyVO();
		cmpnyVO.setCmpnyNm(cmpnyNm);
		System.out.print(cmpnyNm + " - ");
		if (cs.createCmpny(cmpnyVO)) {
			System.out.println("회사 등록 성공");
		} else {
			System.out.println("회사 등록 실패");
		}
	}

	default public void readAllCmpny(CmpnyService cs) {
		List<CmpnyVO> list = cs.readAllCmpny();
		list.forEach(System.out::println);
	}

	default public void updateCmpny(CmpnyService cs, String cmpnyId,String cmpnyNm) {
		CmpnyVO cmpnyVO = new CmpnyVO();
		cmpnyVO.setCmpnyId(cmpnyId);
		cmpnyVO.setCmpnyNm(cmpnyNm);
		System.out.print(cmpnyId + " - ");
		if (cs.updateCmpny(cmpnyVO)) {
			System.out.println("회사 수정 성공");
		} else {
			System.out.println("회사 수정 실패");
		}
	}

	default public void readCmpny(CmpnyService cs, String cmpnyId) {
		System.out.println(cs.readCmpny(cmpnyId));
	}
	
	default public void deleteCmpny(CmpnyService cs, String cmpnyId) {
		System.out.print(cmpnyId + " - ");
		if(cs.deleteCmpny(cmpnyId)) {
			System.out.println("회사 삭제 성공");
		} else {
			System.out.println("회사 삭제 실패");
		}
	}
}
