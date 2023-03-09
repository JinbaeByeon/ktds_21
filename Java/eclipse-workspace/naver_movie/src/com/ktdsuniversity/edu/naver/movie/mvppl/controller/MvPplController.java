package com.ktdsuniversity.edu.naver.movie.mvppl.controller;

import java.util.List;

import com.ktdsuniversity.edu.naver.movie.mvppl.service.MvPplService;
import com.ktdsuniversity.edu.naver.movie.mvppl.vo.MvPplVO;

public interface MvPplController {
	default public void createMvPpl(MvPplService mps
								  , String name
								  , String profilePicture
								  , String realName) {
		MvPplVO mvPplVO = new MvPplVO();
		mvPplVO.setNm(name);
		mvPplVO.setPrflPctr(profilePicture);
		mvPplVO.setRlNm(realName);
		
		System.out.print(name + " - ");
		if (mps.create(mvPplVO)) {
			System.out.println("영화인 등록 성공");
		} else {
			System.out.println("영화인 등록 실패");
		}
	}

	default public void readAllMvPpl(MvPplService mps) {
		List<MvPplVO> list = mps.readAll();
		list.forEach(System.out::println);
	}

	default public void updateMvPpl(MvPplService mps
								  , String mvPplId,String name
								  , String profilePicture
								  , String realName) {
		MvPplVO mvPplVO = new MvPplVO();
		mvPplVO.setMvPplId(mvPplId);
		mvPplVO.setNm(name);
		System.out.print(mvPplId + " - ");
		if (mps.update(mvPplVO)) {
			System.out.println("영화인 수정 성공");
		} else {
			System.out.println("영화인 수정 실패");
		}
	}

	default public void readMvPpl(MvPplService cs, String mvPplId) {
		System.out.println(cs.read(mvPplId));
	}
	
	default public void deleteMvPpl(MvPplService cs, String mvPplId) {
		System.out.print(mvPplId + " - ");
		if(cs.delete(mvPplId)) {
			System.out.println("영화인 삭제 성공");
		} else {
			System.out.println("영화인 삭제 실패");
		}
	}
}
