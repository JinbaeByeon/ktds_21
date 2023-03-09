package com.ktdsuniversity.edu.naver.movie.pctr.controller;

import java.util.List;

import com.ktdsuniversity.edu.naver.movie.pctr.service.PctrService;
import com.ktdsuniversity.edu.naver.movie.pctr.vo.PctrVO;

public interface PctrController {
	default public void createPctr(PctrService ps
								 , String mvId
								 , String pctrTp
								 , String thmbnlPctr
								 , String orgnlPctr) {
		PctrVO pctrVO = new PctrVO();
		pctrVO.setMvId(mvId);
		pctrVO.setPctrTp(pctrTp);
		pctrVO.setThmbnlPctr(thmbnlPctr);
		pctrVO.setOrgnlPctr(orgnlPctr);
		
		if (ps.createPctr(pctrVO)) {
			System.out.println("사진 등록 성공");
		} else {
			System.out.println("사진 등록 실패");
		}
	}

	default public void readAllPctr(PctrService ps) {
		List<PctrVO> list = ps.readAllPctr();
		list.forEach(System.out::println);
	}

	default public void updatePctr(PctrService ps
								 , String pctrId
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
		if (ps.updatePctr(pctrVO)) {
			System.out.println("사진 수정 성공");
		} else {
			System.out.println("사진 수정 실패");
		}
	}

	default public void readPctr(PctrService ps, String pctrId) {
		System.out.println(ps.readPctr(pctrId));
	}
	
	default public void deletePctr(PctrService ps, String pctrId) {
		System.out.print(pctrId + " - ");
		if(ps.deletePctr(pctrId)) {
			System.out.println("사진 삭제 성공");
		} else {
			System.out.println("사진 삭제 실패");
		}
	}
}
