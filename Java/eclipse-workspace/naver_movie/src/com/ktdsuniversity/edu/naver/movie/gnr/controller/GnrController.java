package com.ktdsuniversity.edu.naver.movie.gnr.controller;

import java.util.List;

import com.ktdsuniversity.edu.naver.movie.gnr.service.GnrService;
import com.ktdsuniversity.edu.naver.movie.gnr.vo.GnrVO;

public interface GnrController {
	default public void createGnr(GnrService gs, String gnrNm) {
		GnrVO gnrVO = new GnrVO();
		gnrVO.setGnrNm(gnrNm);
		if (gs.create(gnrVO)) {
			System.out.println("장르 등록 성공");
		} else {
			System.out.println("장르 등록 실패");
		}
	}

	default public void readAllGnr(GnrService gs) {
		List<GnrVO> list = gs.readAll();
		list.forEach(System.out::println);
	}

	default public void updateGnr(GnrService gs, int gnrId, String gnrNm) {
		GnrVO gnrVO = new GnrVO();
		gnrVO.setGnrId(gnrId);
		gnrVO.setGnrNm(gnrNm);
		if (gs.update(gnrVO)) {
			System.out.println("장르 수정 성공");
		} else {
			System.out.println("장르 수정 실패");
		}
	}

	default public void readGnr(GnrService gs, int gnrId) {
		System.out.println(gs.read(gnrId));
	}
	
	default public void deleteGnr(GnrService gs,int gnrId) {
		if(gs.delete(gnrId)) {
			System.out.println("장르 삭제 성공");
		} else {
			System.out.println("장르 삭제 실패");
		}
	}
}
