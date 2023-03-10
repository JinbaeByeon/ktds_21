package com.ktdsuniversity.edu.naver.movie.cntr.controller;

import java.util.List;

import com.ktdsuniversity.edu.naver.movie.Inf.MyController;
import com.ktdsuniversity.edu.naver.movie.cntr.service.CntrService;
import com.ktdsuniversity.edu.naver.movie.cntr.service.CntrServiceImpl;
import com.ktdsuniversity.edu.naver.movie.cntr.vo.CntrVO;
import com.ktdsuniversity.edu.naver.movie.utils.Utils;

public class CntrController implements MyController {
	CntrService cs;
	public CntrController() {
		cs = new CntrServiceImpl();
	}
	
	@Override
	public void create() {
		createCntr(Utils.getNextLine("생성할 국가명을 입력하세요."));
	}
	private void createCntr(String cntrNm) {
		CntrVO cntrVO = new CntrVO();
		cntrVO.setCntrNm(cntrNm);
		if (cs.create(cntrVO)) {
			System.out.println("국가 등록 성공");
		} else {
			System.out.println("국가 등록 실패");
		}
	}

	@Override
	public void readAll() {
		readAllCntr();
	}
	private void readAllCntr() {
		List<CntrVO> list = cs.readAll();
		list.forEach(System.out::println);
	}

	@Override
	public void read() {
		readCntr(Utils.getNextInt("조회할 Id를 입력하세요."));
		
	}
	private void readCntr(int cntrId) {
		System.out.println(cs.read(cntrId));
	}

	@Override
	public void update() {
		updateCntr(Utils.getNextInt("수정할 Id를 입력하세요.")
				 , Utils.getNextLine("수정할 이름을 입력하세요"));
	}
	private void updateCntr( int cntrId, String cntrNm) {
		CntrVO cntrVO = new CntrVO();
		cntrVO.setCntrId(cntrId);
		cntrVO.setCntrNm(cntrNm);
		if (cs.update(cntrVO)) {
			System.out.println("국가 수정 성공");
		} else {
			System.out.println("국가 수정 실패");
		}
	}

	@Override
	public void delete() {
		deleteCntr(Utils.getNextInt("삭제할 Id를 입력하세요."));
	}
	private void deleteCntr(int cntrId) {
		if(cs.delete(cntrId)) {
			System.out.println("국가 삭제 성공");
		} else {
			System.out.println("국가 삭제 실패");
		}
	}




}
