package com.ktdsuniversity.edu.naver.movie.cmpny.controller;

import java.util.List;

import com.ktdsuniversity.edu.naver.movie.Inf.MyController;
import com.ktdsuniversity.edu.naver.movie.cmpny.service.CmpnyService;
import com.ktdsuniversity.edu.naver.movie.cmpny.service.CmpnyServiceImpl;
import com.ktdsuniversity.edu.naver.movie.cmpny.vo.CmpnyVO;
import com.ktdsuniversity.edu.naver.movie.utils.Utils;

public class CmpnyController implements MyController{
	CmpnyService cs;
	
	public CmpnyController() {
		cs = new CmpnyServiceImpl();
	}
	
	@Override
	public void create() {
		createCmpny(Utils.getNextLine("생성할 회사명을 입력하세요."));
	}
	private void createCmpny(String cmpnyNm) {
		CmpnyVO cmpnyVO = new CmpnyVO();
		cmpnyVO.setCmpnyNm(cmpnyNm);
		System.out.print(cmpnyNm + " - ");
		if (cs.create(cmpnyVO)) {
			System.out.println("회사 등록 성공");
		} else {
			System.out.println("회사 등록 실패");
		}
	}

	@Override
	public void readAll() {
		readAllCmpny();
	}
	private void readAllCmpny() {
		List<CmpnyVO> list = cs.readAll();
		list.forEach(System.out::println);
	}

	@Override
	public void read() {
		readCmpny(Utils.getNextLine("조회할 Id를 입력하세요."));
	}
	private void readCmpny(String cmpnyId) {
		System.out.println(cs.read(cmpnyId));
	}
	
	@Override
	public void update() {
		updateCmpny(Utils.getNextLine("수정할 Id를 입력하세요.")
			 , Utils.getNextLine("수정할 이름을 입력하세요"));
	}
	private void updateCmpny(String cmpnyId,String cmpnyNm) {
		CmpnyVO cmpnyVO = new CmpnyVO();
		cmpnyVO.setCmpnyId(cmpnyId);
		cmpnyVO.setCmpnyNm(cmpnyNm);
		System.out.print(cmpnyId + " - ");
		if (cs.update(cmpnyVO)) {
			System.out.println("회사 수정 성공");
		} else {
			System.out.println("회사 수정 실패");
		}
	}


	@Override
	public void delete() {
		deleteCmpny(Utils.getNextLine("삭제할 Id를 입력하세요."));
	}
	private void deleteCmpny(String cmpnyId) {
		System.out.print(cmpnyId + " - ");
		if(cs.delete(cmpnyId)) {
			System.out.println("회사 삭제 성공");
		} else {
			System.out.println("회사 삭제 실패");
		}
	}





}
