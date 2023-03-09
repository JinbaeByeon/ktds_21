package com.ktdsuniversity.edu.naver.movie.mv.controller;

import java.util.ArrayList;
import java.util.List;

import com.ktdsuniversity.edu.naver.movie.cntr.service.CntrService;
import com.ktdsuniversity.edu.naver.movie.cntr.vo.CntrVO;
import com.ktdsuniversity.edu.naver.movie.gnr.service.GnrService;
import com.ktdsuniversity.edu.naver.movie.gnr.vo.GnrVO;
import com.ktdsuniversity.edu.naver.movie.mv.service.MvService;
import com.ktdsuniversity.edu.naver.movie.mv.vo.MvVO;
import com.ktdsuniversity.edu.naver.movie.mv.vo.PrdcPrtcptnCmpnyVO;
import com.ktdsuniversity.edu.naver.movie.mv.vo.PrdcPrtcptnPplVO;
import com.ktdsuniversity.edu.naver.movie.utils.Utils;

public interface MvController {
	default public MvVO createMv(MvService ms
							   , GnrService gs
							   , CntrService cs
								  , String mvTtl
								  , String engTtl
								  , String scrnStt
								  , int scrnTm
								  , String opngDt
								  , String wtcGrd
								  , String pstr 
								  , String smr
								  , String gnrStr
								  , String cntrStr) {
		MvVO mvVO = new MvVO();
		mvVO.setMvTtl(mvTtl);
		mvVO.setEngTtl(engTtl);
		mvVO.setScrnStt(scrnStt);
		mvVO.setScrnTm(scrnTm);
		mvVO.setOpngDt(opngDt);
		mvVO.setWtcGrd(wtcGrd);
		mvVO.setPstr(pstr);
		mvVO.setSmr(smr);
		
		List<GnrVO> gnrList = new ArrayList<>();
		mvVO.setGnrList(gnrList);
		List.of(gnrStr.replace(" ", "").split(","))
		.forEach(gnrId -> {
			GnrVO gnr = gs.read(Integer.parseInt(gnrId));
			if(gnr != null) {
				gnrList.add(gnr);
			}
		});
		
		List<CntrVO> cntrList = new ArrayList<>();
		mvVO.setCntrList(cntrList);
		List.of(cntrStr.replace(" ", "").split(","))
			.forEach(cntrId -> {
				CntrVO cntr = cs.read(Integer.parseInt(cntrId));
				if(cntr != null) {
					cntrList.add(cntr);
				}
			});
		
		int menu;
		List<PrdcPrtcptnCmpnyVO> cmpnyList = new ArrayList<>();
		mvVO.setCmpnyList(cmpnyList);		
		System.out.println("제작참여사를 입력하세요");
		while(true) {
			menu = Utils.getNextInt("유통종류를 입력하세요 <1. 수입, 2. 배급, 3. 제작 (0 : 입력종료)>");
			if(menu == 0) {
				break;
			}
			PrdcPrtcptnCmpnyVO cmpny = new PrdcPrtcptnCmpnyVO();
			if(menu == 1) {
				cmpny.setCrcltnCd("006_01");
			} else if(menu == 2) {
				cmpny.setCrcltnCd("006_02");
			} else if(menu == 3) {
				cmpny.setCrcltnCd("006_03");
			}
			cmpny.setCmpnyId(Utils.getNextLine("회사id를 입력하세요"));
			cmpnyList.add(cmpny);
		}
		
		List<PrdcPrtcptnPplVO> mvPplList = new ArrayList<>();
		mvVO.setPrdcMvPplList(mvPplList);		
		System.out.println("제작참여인을 입력하세요");
		while(true) {
			menu = Utils.getNextInt("역할종류를 입력하세요 <1. 감독, 2. 프로듀서, 3. 제작, 4. 주연, 5. 조연 (0 : 입력종료)>");
			if(menu == 0) {
				break;
			}
			PrdcPrtcptnPplVO mvPpl = new PrdcPrtcptnPplVO();
			if(menu == 1) {
				mvPpl.setRolTp("005_01");
			} else if(menu == 2) {
				mvPpl.setRolTp("005_02");
			} else if(menu == 3) {
				mvPpl.setRolTp("005_03");
			} else if(menu == 4) {
				mvPpl.setRolTp("005_04");
			} else if(menu == 5) {
				mvPpl.setRolTp("005_05");
			}
			mvPpl.setMvPplId(Utils.getNextLine("영화인id를 입력하세요"));
			mvPpl.setRspnsbltRolNm(Utils.getNextLine("역할명을 입력하세요"));
			mvPplList.add(mvPpl);
		}
		
		System.out.print(mvTtl + " - ");
		if (ms.create(mvVO)) {
			System.out.println("영화 등록 성공");
			return mvVO;
		} else {
			System.out.println("영화 등록 실패");
			return null;
		}
	}

	default public void readAllMv(MvService ms) {
		List<MvVO> list = ms.readAll();
		list.forEach(System.out::println);
	}

	default public void updateMv(MvService ms
								  , String mvId
								  , String mvTtl
								  , String engTtl
								  , String scrnStt
								  , int scrnTm
								  , String opngDt
								  , String wtcGrd
								  , String pstr 
								  , String smr) {
		MvVO mvVO = new MvVO();
		mvVO.setMvId(mvId);
		mvVO.setMvTtl(mvTtl);
		mvVO.setEngTtl(engTtl);
		mvVO.setScrnStt(scrnStt);
		mvVO.setScrnTm(scrnTm);
		mvVO.setOpngDt(opngDt);
		mvVO.setWtcGrd(wtcGrd);
		mvVO.setPstr(pstr);
		mvVO.setSmr(smr);
		
		System.out.print(mvId + " - ");
		if (ms.update(mvVO)) {
			System.out.println("영화 수정 성공");
		} else {
			System.out.println("영화 수정 실패");
		}
	}

	default public void readMv(MvService ms, String mvId) {
		System.out.println(ms.read(mvId));
	}
	
	default public void deleteMv(MvService ms, String mvId) {
		System.out.print(mvId + " - ");
		if(ms.delete(mvId)) {
			System.out.println("영화 삭제 성공");
		} else {
			System.out.println("영화 삭제 실패");
		}
	}

	
}
