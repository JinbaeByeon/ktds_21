package com.ktdsuniversity.edu.naver.movie.pctr.controller;

import java.util.List;

import com.ktdsuniversity.edu.naver.movie.Inf.MyController;
import com.ktdsuniversity.edu.naver.movie.pctr.service.PctrService;
import com.ktdsuniversity.edu.naver.movie.pctr.service.PctrServiceImpl;
import com.ktdsuniversity.edu.naver.movie.pctr.vo.PctrVO;
import com.ktdsuniversity.edu.naver.movie.utils.Utils;

public class PctrController implements MyController {
	PctrService ps;

	public PctrController() {
		ps = new PctrServiceImpl();
	}
	@Override
	public void create() {
		createPctr(Utils.getNextLine("생성할 사진의 영화Id를 입력하세요.")
				   , Utils.getNextLine("생성할 사진의 타입을 입력하세요.")
				   , Utils.getNextLine("생성할 사진의 썸네일을 입력하세요.")
				   , Utils.getNextLine("생성할 사진의 원본을 입력하세요."));
	}
	private void createPctr(String mvId
						 , String pctrTp
						 , String thmbnlPctr
						 , String orgnlPctr) {
		PctrVO pctrVO = new PctrVO();
		pctrVO.setMvId(mvId);
		pctrVO.setPctrTp(pctrTp);
		pctrVO.setThmbnlPctr(thmbnlPctr);
		pctrVO.setOrgnlPctr(orgnlPctr);
		
		if (ps.create(pctrVO)) {
			System.out.println("사진 등록 성공");
		} else {
			System.out.println("사진 등록 실패");
		}
	}

	@Override
	public void readAll() {
		readAllPctr();
	}
	private void readAllPctr() {
		List<PctrVO> list = ps.readAll();
		list.forEach(System.out::println);
	}

	@Override
	public void read() {
		readPctr(Utils.getNextLine("조회할 Id를 입력하세요."));
	}
	private void readPctr(String pctrId) {
		System.out.println(ps.read(pctrId));
	}

	@Override
	public void update() {
		updatePctr(Utils.getNextLine("수정할 Id를 입력하세요.")
			     , Utils.getNextLine("수정할 사진의 영화Id를 입력하세요.")
				 , Utils.getNextLine("수정할 사진의 타입을 입력하세요.")
				 , Utils.getNextLine("수정할 사진의 썸네일을 입력하세요.")
				 , Utils.getNextLine("수정할 사진의 원본을 입력하세요."));
	}
	private void updatePctr(String pctrId
						 , String mvId
						 , String pctrTp
						 , String thmbnlPctr
						 , String orgnlPctr) {
		PctrVO pctrVO = new PctrVO();
		pctrVO.setPctrId(pctrId);
		pctrVO.setMvId(mvId);
		pctrVO.setPctrTp(pctrTp);
		pctrVO.setThmbnlPctr(thmbnlPctr);
		pctrVO.setOrgnlPctr(orgnlPctr);
		
		System.out.print(pctrId + " - ");
		if (ps.update(pctrVO)) {
			System.out.println("사진 수정 성공");
		} else {
			System.out.println("사진 수정 실패");
		}
	}

	@Override
	public void delete() {
		deletePctr(Utils.getNextLine("삭제할 Id를 입력하세요."));
	}
	private void deletePctr(String pctrId) {
		System.out.print(pctrId + " - ");
		if(ps.delete(pctrId)) {
			System.out.println("사진 삭제 성공");
		} else {
			System.out.println("사진 삭제 실패");
		}
	}





}
