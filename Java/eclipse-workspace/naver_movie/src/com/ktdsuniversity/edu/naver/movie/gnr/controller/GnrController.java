package com.ktdsuniversity.edu.naver.movie.gnr.controller;

import java.util.List;

import com.ktdsuniversity.edu.naver.movie.Inf.MyController;
import com.ktdsuniversity.edu.naver.movie.gnr.service.GnrService;
import com.ktdsuniversity.edu.naver.movie.gnr.service.GnrServiceImpl;
import com.ktdsuniversity.edu.naver.movie.gnr.vo.GnrVO;
import com.ktdsuniversity.edu.naver.movie.utils.Utils;

public class GnrController implements MyController{
	GnrService gs;
	
	public GnrController() {
		gs = new GnrServiceImpl();
	}
	
	@Override
	public void create() {
		createGnr(Utils.getNextLine("생성할 장르명을 입력하세요."));
	}
	private void createGnr(String gnrNm) {
		GnrVO gnrVO = new GnrVO();
		gnrVO.setGnrNm(gnrNm);
		if (gs.create(gnrVO)) {
			System.out.println("장르 등록 성공");
		} else {
			System.out.println("장르 등록 실패");
		}
	}

	@Override
	public void readAll() {
		readAllGnr();
	}
	private void readAllGnr() {
		List<GnrVO> list = gs.readAll();
		list.forEach(System.out::println);
	}

	@Override
	public void read() {
		readGnr(Utils.getNextInt("조회할 Id를 입력하세요."));
	}
	private void readGnr(int gnrId) {
		System.out.println(gs.read(gnrId));
	}

	@Override
	public void update() {
		updateGnr(Utils.getNextInt("수정할 Id를 입력하세요.")
				, Utils.getNextLine("수정할 이름을 입력하세요"));
	}
	private void updateGnr(int gnrId, String gnrNm) {
		GnrVO gnrVO = new GnrVO();
		gnrVO.setGnrId(gnrId);
		gnrVO.setGnrNm(gnrNm);
		if (gs.update(gnrVO)) {
			System.out.println("장르 수정 성공");
		} else {
			System.out.println("장르 수정 실패");
		}
	}

	@Override
	public void delete() {
		deleteGnr(Utils.getNextInt("삭제할 Id를 입력하세요."));
	}
	private void deleteGnr(int gnrId) {
		if(gs.delete(gnrId)) {
			System.out.println("장르 삭제 성공");
		} else {
			System.out.println("장르 삭제 실패");
		}
	}





}
