package com.ktdsuniversity.edu.naver.movie.vd.controller;

import java.util.List;

import com.ktdsuniversity.edu.naver.movie.Inf.MyController;
import com.ktdsuniversity.edu.naver.movie.utils.Utils;
import com.ktdsuniversity.edu.naver.movie.vd.service.VdService;
import com.ktdsuniversity.edu.naver.movie.vd.service.VdServiceImpl;
import com.ktdsuniversity.edu.naver.movie.vd.vo.VdVO;

public class VdController implements MyController {
	VdService vs;
	
	public VdController() {
		vs = new VdServiceImpl();
	}
	
	@Override
	public void create() {
		createVd(Utils.getNextLine("생성할 동영상의 영화Id를 입력하세요.")
			   , Utils.getNextLine("생성할 동영상의 타입을 입력하세요.")
			   , Utils.getNextLine("생성할 동영상의 제목을 입력하세요.")
			   , Utils.getNextLine("생성할 동영상의 썸네일을 입력하세요.")
			   , Utils.getNextLine("생성할 동영상의 주소를 입력하세요."));
	}
	private void createVd(String mvId
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
		if (vs.create(vdVO)) {
			System.out.println("동영상 등록 성공");
		} else {
			System.out.println("동영상 등록 실패");
		}
	}

	@Override
	public void readAll() {
		readAllVd();	
	}
	private void readAllVd() {
		List<VdVO> list = vs.readAll();
		list.forEach(System.out::println);
	}

	@Override
	public void read() {
		readVd(Utils.getNextLine("조회할 Id를 입력하세요."));
	}
	private void readVd(String vdId) {
		System.out.println(vs.read(vdId));
	}

	@Override
	public void update() {
		updateVd(Utils.getNextLine("수정할 Id를 입력하세요.")
			   , Utils.getNextLine("수정할 동영상의 영화Id를 입력하세요.")
		       , Utils.getNextLine("수정할 동영상의 타입을 입력하세요.")
			   , Utils.getNextLine("수정할 동영상의 제목을 입력하세요.")
			   , Utils.getNextLine("수정할 동영상의 썸네일을 입력하세요.")
			   , Utils.getNextLine("수정할 동영상의 주소를 입력하세요."));
	}
	private void updateVd(String vdId
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
		if (vs.update(vdVO)) {
			System.out.println("동영상 수정 성공");
		} else {
			System.out.println("동영상 수정 실패");
		}
	}

	@Override
	public void delete() {
		deleteVd(Utils.getNextLine("삭제할 Id를 입력하세요."));
	}
	private void deleteVd(String vdId) {
		System.out.print(vdId + " - ");
		if(vs.delete(vdId)) {
			System.out.println("동영상 삭제 성공");
		} else {
			System.out.println("동영상 삭제 실패");
		}
	}





}
