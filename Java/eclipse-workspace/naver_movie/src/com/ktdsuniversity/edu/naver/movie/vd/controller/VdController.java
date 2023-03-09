package com.ktdsuniversity.edu.naver.movie.vd.controller;

import java.util.List;

import com.ktdsuniversity.edu.naver.movie.vd.service.VdService;
import com.ktdsuniversity.edu.naver.movie.vd.vo.VdVO;

public interface VdController {
	default public void createVd(VdService vs
								,String mvId
								,String vdTp
								,String ttl
								,String thmbnl
								,String vdUrl) {
		VdVO vdVO = new VdVO();
		vdVO.setMvId(mvId);
		vdVO.setVdTp(vdTp);
		vdVO.setTtl(ttl);
		vdVO.setThmbnl(thmbnl);
		vdVO.setVdUrl(vdUrl);
		
		System.out.print(ttl + " - ");
		if (vs.createVd(vdVO)) {
			System.out.println("동영상 등록 성공");
		} else {
			System.out.println("동영상 등록 실패");
		}
	}

	default public void readAllVd(VdService mps) {
		List<VdVO> list = mps.readAllVd();
		list.forEach(System.out::println);
	}

	default public void updateVd(VdService vs
								,String vdId
								,String mvId
								,String vdTp
								,String ttl
								,String thmbnl
								,String vdUrl) {
		VdVO vdVO = new VdVO();
		vdVO.setVdId(vdId);
		vdVO.setMvId(mvId);
		vdVO.setVdTp(vdTp);
		vdVO.setTtl(ttl);
		vdVO.setThmbnl(thmbnl);
		vdVO.setVdUrl(vdUrl);
		
		
		System.out.print(vdId + " - ");
		if (vs.updateVd(vdVO)) {
			System.out.println("동영상 수정 성공");
		} else {
			System.out.println("동영상 수정 실패");
		}
	}

	default public void readVd(VdService vs, String vdId) {
		System.out.println(vs.readVd(vdId));
	}
	
	default public void deleteVd(VdService vs, String vdId) {
		System.out.print(vdId + " - ");
		if(vs.deleteVd(vdId)) {
			System.out.println("동영상 삭제 성공");
		} else {
			System.out.println("동영상 삭제 실패");
		}
	}
}
