package com.ktdsuniversity.edu.naver.movie.cntr.controller;

import java.util.List;

import com.ktdsuniversity.edu.naver.movie.cntr.service.CntrService;
import com.ktdsuniversity.edu.naver.movie.cntr.vo.CntrVO;

public interface CntrController {
	default public void createCntr(CntrService cs, String cntrNm) {
		CntrVO cntrVO = new CntrVO();
		cntrVO.setCntrNm(cntrNm);
		if (cs.createCntr(cntrVO)) {
			System.out.println("국가 등록 성공");
		} else {
			System.out.println("국가 등록 실패");
		}
	}

	default public void readAllCntr(CntrService cs) {
		List<CntrVO> list = cs.readAllCntr();
		list.forEach(System.out::println);
	}

	default public void updateCntr(CntrService cs, int cntrId, String cntrNm) {
		CntrVO cntrVO = new CntrVO();
		cntrVO.setCntrId(cntrId);
		cntrVO.setCntrNm(cntrNm);
		if (cs.updateCntr(cntrVO)) {
			System.out.println("국가 수정 성공");
		} else {
			System.out.println("국가 수정 실패");
		}
	}

	default public void readCntr(CntrService cs, int cntrId) {
		System.out.println(cs.readCntr(cntrId));
	}

	default public void deleteCntr(CntrService gs,int cntrId) {
		if(gs.deleteCntr(cntrId)) {
			System.out.println("국가 삭제 성공");
		} else {
			System.out.println("국가 삭제 실패");
		}
	}
}
