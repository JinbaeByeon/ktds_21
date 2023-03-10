package com.ktdsuniversity.edu.naver.movie.rtng.controller;

import java.util.List;

import com.ktdsuniversity.edu.naver.movie.Inf.MyController;
import com.ktdsuniversity.edu.naver.movie.rtng.service.RtngService;
import com.ktdsuniversity.edu.naver.movie.rtng.service.RtngServiceImpl;
import com.ktdsuniversity.edu.naver.movie.rtng.vo.RtngVO;
import com.ktdsuniversity.edu.naver.movie.utils.Utils;

public class RtngController implements MyController {
	RtngService rs;
	
	public RtngController() {
		rs = new RtngServiceImpl();
	}
	@Override
	public void create() {
		createRtng(Utils.getNextLine("등록할 평점의 영화Id 입력")
				  , Utils.getNextInt("평점 입력")
				  , Utils.getNextLine("내용 입력")
				  , Utils.getNextLine("등록자명 입력"));
	}
	private void createRtng(String mvId
			               , int rtng
			               , String dtl
			               , String wrtr) {
		RtngVO rtngVO = new RtngVO();
		rtngVO.setRtng(rtng);
		rtngVO.setMvId(mvId);
		rtngVO.setDtl(dtl);
		rtngVO.setWrtr(wrtr);
		
		if(rs.create(rtngVO)) {
			System.out.println(" 등록 성공");
		} else{
			System.out.println("평점 등록 실패");
		}
	}
	
	@Override
	public void readAll() {
		readAllRtng();
	}
	private void readAllRtng() {
		List<RtngVO> list = rs.readAll();
		list.forEach(System.out::println);
	}

	@Override
	public void read() {
		readRtng(Utils.getNextLine("조회할 평점Id 입력"));
	}
	private void readRtng(String rtngId) {
		System.out.println(rs.read(rtngId));
	}
	
	@Override
	public void update() {
		updateRtng(Utils.getNextLine("수정할 평점Id 입력 ")
				  , Utils.getNextInt("평점 입력")
				  , Utils.getNextLine("내용 입력"));
	}
	private void updateRtng(String rtngId
						   , int rtng
				           , String dtl) {
		RtngVO rtngVO = new RtngVO();
		rtngVO.setRtngId(rtngId);
		rtngVO.setRtng(rtng);
		rtngVO.setDtl(dtl);
		
		if(rs.update(rtngVO)) {
			System.out.println("평점 수정 성공");
		} else{
			System.out.println("평점 수정 실패");
		}
	}

	@Override
	public void delete() {
		deleteRtng(Utils.getNextLine("삭제할 평점Id 입력 "));
	}
	private void deleteRtng(String rtngId) {
		System.out.println(rtngId + " - ");
		if(rs.delete(rtngId)) {
			System.out.println("평점 삭제 성공");
		} else{
			System.out.println("평점 삭제 실패");
		}
		
	}
	
}
