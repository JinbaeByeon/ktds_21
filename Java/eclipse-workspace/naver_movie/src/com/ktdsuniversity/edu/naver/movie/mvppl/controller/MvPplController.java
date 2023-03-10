package com.ktdsuniversity.edu.naver.movie.mvppl.controller;

import java.util.List;

import com.ktdsuniversity.edu.naver.movie.Inf.MyController;
import com.ktdsuniversity.edu.naver.movie.mvppl.service.MvPplService;
import com.ktdsuniversity.edu.naver.movie.mvppl.service.MvPplServiceImpl;
import com.ktdsuniversity.edu.naver.movie.mvppl.vo.MvPplVO;
import com.ktdsuniversity.edu.naver.movie.utils.Utils;

public class MvPplController implements MyController {
	MvPplService mps;
	
	public MvPplController() {
		mps = new MvPplServiceImpl();
	}
	
	@Override
	public void create() {
		createMvPpl(Utils.getNextLine("생성할 영화인명을 입력하세요.")
				  , Utils.getNextLine("생성할 영화인 프로필사진을 입력하세요.")
				  , Utils.getNextLine("생성할 영화인 본명을 입력하세요."));
	}
	private void createMvPpl(String name
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

	@Override
	public void readAll() {
		readAllMvPpl();
	}
	private void readAllMvPpl() {
		List<MvPplVO> list = mps.readAll();
		list.forEach(System.out::println);
	}

	@Override
	public void read() {
		readMvPpl(Utils.getNextLine("조회할 Id를 입력하세요."));
	}
	private void readMvPpl(String mvPplId) {
		System.out.println(mps.read(mvPplId));
	}
	
	@Override
	public void update() {
		updateMvPpl(Utils.getNextLine("수정할 Id를 입력하세요.")
				  , Utils.getNextLine("수정할 영화인명을 입력하세요.")
				  , Utils.getNextLine("수정할 영화인 프로필사진을 입력하세요.")
				  , Utils.getNextLine("수정할 영화인 본명을 입력하세요."));
	}
	private void updateMvPpl(String mvPplId
						  , String name
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


	@Override
	public void delete() {
		deleteMvPpl(Utils.getNextLine("삭제할 Id를 입력하세요."));
	}
	private void deleteMvPpl(String mvPplId) {
		System.out.print(mvPplId + " - ");
		if(mps.delete(mvPplId)) {
			System.out.println("영화인 삭제 성공");
		} else {
			System.out.println("영화인 삭제 실패");
		}
	}





}
