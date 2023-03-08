package com.ktdsuniversity.edu.naver.movie.mv.controller;

import java.util.List;

import com.ktdsuniversity.edu.naver.movie.mv.service.MvService;
import com.ktdsuniversity.edu.naver.movie.mv.vo.MvVO;

public interface MvController {
	default public void createMv(MvService cs
								  , String mvId
								  , String cdNm) {
		MvVO mvVO = new MvVO();

		
		System.out.print(cdNm + " - ");
		if (cs.createMv(mvVO)) {
			System.out.println("영화 등록 성공");
		} else {
			System.out.println("영화 등록 실패");
		}
	}

	default public void readAllMv(MvService cs) {
		List<MvVO> list = cs.readAllMv();
		list.forEach(System.out::println);
	}

	default public void updateMv(MvService cs
								  , String mvId
								  , String cdNm) {
		MvVO mvVO = new MvVO();
		
		System.out.print(mvId + " - ");
		if (cs.updateMv(mvVO)) {
			System.out.println("영화 수정 성공");
		} else {
			System.out.println("영화 수정 실패");
		}
	}

	default public void readMv(MvService cs, String mvId) {
		System.out.println(cs.readMv(mvId));
	}
	
	default public void deleteMv(MvService cs, String mvId) {
		System.out.print(mvId + " - ");
		if(cs.deleteMv(mvId)) {
			System.out.println("영화 삭제 성공");
		} else {
			System.out.println("영화 삭제 실패");
		}
	}

	
}
