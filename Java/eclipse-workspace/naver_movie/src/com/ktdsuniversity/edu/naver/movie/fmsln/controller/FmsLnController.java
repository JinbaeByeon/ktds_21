package com.ktdsuniversity.edu.naver.movie.fmsln.controller;

import java.util.List;

import com.ktdsuniversity.edu.naver.movie.Inf.MyController;
import com.ktdsuniversity.edu.naver.movie.fmsln.service.FmsLnService;
import com.ktdsuniversity.edu.naver.movie.fmsln.service.FmsLnServiceImpl;
import com.ktdsuniversity.edu.naver.movie.fmsln.vo.FmsLnVO;
import com.ktdsuniversity.edu.naver.movie.utils.Utils;

public class FmsLnController implements MyController {
	FmsLnService fs;
	
	public FmsLnController() {
		fs = new FmsLnServiceImpl();
	}
	@Override
	public void create() {
		createFmsLn(Utils.getNextLine("등록할 명대사 입력")
				  , Utils.getNextLine("설명 입력")
				  , Utils.getNextLine("등록자명 입력")
				  , Utils.getNextLine("제작참여인Id 입력"));
	}
	private void createFmsLn(String fmsLn
			               , String expl
			               , String rgstPplNm
			               , String prdcPrtcptnId) {
		FmsLnVO fmsLnVO = new FmsLnVO();
		fmsLnVO.setFmsLn(fmsLn);
		fmsLnVO.setExpl(expl);
		fmsLnVO.setRgstPplNm(rgstPplNm);
		fmsLnVO.setPrdcPrtcptnId(prdcPrtcptnId);
		
		if(fs.create(fmsLnVO)) {
			System.out.println("명대사 등록 성공");
		} else{
			System.out.println("명대사 등록 실패");
		}
	}
	
	@Override
	public void readAll() {
		readAllFmsLn();
	}
	private void readAllFmsLn() {
		List<FmsLnVO> list = fs.readAll();
		list.forEach(System.out::println);
	}

	@Override
	public void read() {
		readFmsLn(Utils.getNextLine("조회할 명대사Id 입력"));
	}
	private void readFmsLn(String fmsLnId) {
		System.out.println(fs.read(fmsLnId));
	}
	
	@Override
	public void update() {
		updateFmsLn(Utils.getNextLine("수정할 명대사Id 입력 ")
				  , Utils.getNextLine("명대사 입력")
				  , Utils.getNextLine("설명 입력"));
	}
	private void updateFmsLn(String fmsLnId
						   , String fmsLn
				           , String expl) {
		FmsLnVO fmsLnVO = new FmsLnVO();
		fmsLnVO.setFmsLnId(fmsLnId);
		fmsLnVO.setFmsLn(fmsLn);
		fmsLnVO.setExpl(expl);
		
		if(fs.update(fmsLnVO)) {
			System.out.println("명대사 수정 성공");
		} else{
			System.out.println("명대사 수정 실패");
		}
		
	}

	@Override
	public void delete() {
		deleteFmsLn(Utils.getNextLine("삭제할 명대사Id 입력 "));
	}
	private void deleteFmsLn(String fmsLnId) {
		System.out.println(fmsLnId + " - ");
		if(fs.delete(fmsLnId)) {
			System.out.println("명대사 삭제 성공");
		} else{
			System.out.println("명대사 삭제 실패");
		}
		
	}
	
}
