package com.ktdsuniversity.edu.naver.movie;

import com.ktdsuniversity.edu.naver.movie.cmncd.controller.CmnCdController;
import com.ktdsuniversity.edu.naver.movie.cmncd.service.CmnCdService;
import com.ktdsuniversity.edu.naver.movie.cmncd.service.CmnCdServiceImpl;
import com.ktdsuniversity.edu.naver.movie.cmpny.controller.CmpnyController;
import com.ktdsuniversity.edu.naver.movie.cmpny.service.CmpnyService;
import com.ktdsuniversity.edu.naver.movie.cmpny.service.CmpnyServiceImpl;
import com.ktdsuniversity.edu.naver.movie.cntr.controller.CntrController;
import com.ktdsuniversity.edu.naver.movie.cntr.service.CntrService;
import com.ktdsuniversity.edu.naver.movie.cntr.service.CntrServiceImpl;
import com.ktdsuniversity.edu.naver.movie.fmsln.controller.FmsLnController;
import com.ktdsuniversity.edu.naver.movie.gnr.controller.GnrController;
import com.ktdsuniversity.edu.naver.movie.gnr.service.GnrService;
import com.ktdsuniversity.edu.naver.movie.gnr.service.GnrServiceImpl;
import com.ktdsuniversity.edu.naver.movie.mv.controller.MvController;
import com.ktdsuniversity.edu.naver.movie.mv.service.MvService;
import com.ktdsuniversity.edu.naver.movie.mv.service.MvServiceImpl;
import com.ktdsuniversity.edu.naver.movie.mvppl.controller.MvPplController;
import com.ktdsuniversity.edu.naver.movie.mvppl.service.MvPplService;
import com.ktdsuniversity.edu.naver.movie.mvppl.service.MvPplServiceImpl;
import com.ktdsuniversity.edu.naver.movie.pctr.controller.PctrController;
import com.ktdsuniversity.edu.naver.movie.pctr.service.PctrService;
import com.ktdsuniversity.edu.naver.movie.pctr.service.PctrServiceImpl;
import com.ktdsuniversity.edu.naver.movie.rtng.controller.RtngController;
import com.ktdsuniversity.edu.naver.movie.utils.Utils;
import com.ktdsuniversity.edu.naver.movie.vd.controller.VdController;
import com.ktdsuniversity.edu.naver.movie.vd.service.VdService;
import com.ktdsuniversity.edu.naver.movie.vd.service.VdServiceImpl;

public class NaverMv implements GnrController
							  , CntrController
							  , CmpnyController
							  , MvPplController
							  , CmnCdController
							  , PctrController
							  , VdController
							  , MvController
							  , RtngController
							  , FmsLnController{
	private static final String MENU = "1. 장르, 2. 국가, 3. 회사, 4. 영화인, 5. 공통코드"
								   + ", 6. 사진, 7. 동영상, 8. 영화, 9. 평점, 10. 명대사 (0: 종료)";
	private static final String SUBMENU = "1. 생성, 2. 목록조회, 3. 한개조회, 4. 수정, 5. 삭제 (0: 종료)";

	private void executeGnr(GnrService gs) {
		System.out.println("장르 서비스 호출");
		while(true) {
			int menu = Utils.getNextInt(SUBMENU);
			if(menu == 0) {
				return;
			} else if(menu == 1) {			// 장르 생성
				createGnr(gs,Utils.getNextLine("생성할 장르명을 입력하세요."));
			} else if(menu == 2) {	// 장르 목록 조회
				readAllGnr(gs);			
			} else if(menu == 3) {	// 장르 하나 조회
				readGnr(gs, Utils.getNextInt("조회할 Id를 입력하세요."));
			} else if(menu == 4) {	// 장르 수정
				updateGnr(gs, Utils.getNextInt("수정할 Id를 입력하세요."), Utils.getNextLine("수정할 이름을 입력하세요"));
			} else if(menu == 5) {	// 장르 삭제
				menu = Utils.getNextInt("삭제할 Id를 입력하세요.");
				deleteGnr(gs,menu);
			}
		}
	}

	private void executeCntr(CntrService cs) {
		System.out.println("국가 서비스 호출");
		while(true) {
			int menu = Utils.getNextInt(SUBMENU);
			if(menu == 0) {
				return;
			} else if(menu == 1) {			// 국가 생성
				createCntr(cs,Utils.getNextLine("생성할 국가명을 입력하세요."));
			} else if(menu == 2) {	// 국가 목록 조회
				readAllCntr(cs);			
			} else if(menu == 3) {	// 국가 하나 조회
				readCntr(cs, Utils.getNextInt("조회할 Id를 입력하세요."));
			} else if(menu == 4) {	// 국가 수정
				updateCntr(cs, Utils.getNextInt("수정할 Id를 입력하세요."), Utils.getNextLine("수정할 이름을 입력하세요"));
			} else if(menu == 5) {	// 국가 삭제
				deleteCntr(cs,Utils.getNextInt("삭제할 Id를 입력하세요."));
			}
		}
	}

	private void executeCmpny(CmpnyService cs) {
		System.out.println("회사 서비스 호출");
		while(true) {
			int menu = Utils.getNextInt(SUBMENU);
			
			if(menu == 0) {
				return;
			} else if(menu == 1) {			// 회사 생성
				createCmpny(cs,Utils.getNextLine("생성할 회사명을 입력하세요."));
			} else if(menu == 2) {	// 회사 목록 조회
				readAllCmpny(cs);			
			} else if(menu == 3) {	// 회사 하나 조회
				readCmpny(cs, Utils.getNextLine("조회할 Id를 입력하세요."));
			} else if(menu == 4) {	// 회사 수정
				updateCmpny(cs, Utils.getNextLine("수정할 Id를 입력하세요."), Utils.getNextLine("수정할 이름을 입력하세요"));
			} else if(menu == 5) {	// 회사 삭제
				deleteCmpny(cs,Utils.getNextLine("삭제할 Id를 입력하세요."));
			}
		}
	}

	private void executeMvPpl(MvPplService mps) {
		System.out.println("영화인 서비스 호출");
		while(true) {
			int menu = Utils.getNextInt(SUBMENU);
			
			if(menu == 0) {
				return;
			} else if(menu == 1) {			// 영화인 생성
				createMvPpl(mps, Utils.getNextLine("생성할 영화인명을 입력하세요.")
						, Utils.getNextLine("생성할 영화인 프로필사진을 입력하세요.")
						, Utils.getNextLine("생성할 영화인 본명을 입력하세요."));
			} else if(menu == 2) {	// 영화인 목록 조회
				readAllMvPpl(mps);			
			} else if(menu == 3) {	// 영화인 한 명 조회
				readMvPpl(mps, Utils.getNextLine("조회할 Id를 입력하세요."));
			} else if(menu == 4) {	// 영화인 수정
				updateMvPpl(mps, Utils.getNextLine("수정할 Id를 입력하세요.")
						, Utils.getNextLine("수정할 영화인명을 입력하세요.")
						, Utils.getNextLine("수정할 영화인 프로필사진을 입력하세요.")
						, Utils.getNextLine("수정할 영화인 본명을 입력하세요."));
			} else if(menu == 5) {	// 영화인 삭제
				deleteMvPpl(mps,Utils.getNextLine("삭제할 Id를 입력하세요."));
			}
		}
	}

	private void executeCmnCd(CmnCdService ccs) {
		System.out.println("공통코드 서비스 호출");
		while(true) {
			int menu = Utils.getNextInt(SUBMENU);
	
			if(menu == 0) {
				return;
			} else if(menu == 1) {			// 공통코드 생성
				createCmnCd(ccs, Utils.getNextLine("생성할 공통코드의 Id를 입력하세요.")
							   , Utils.getNextLine("생성할 공통코드명을 입력하세요."));
			} else if(menu == 2) {	// 공통코드 목록 조회
				readAllCmnCd(ccs);	
			} else if(menu == 3) {	// 공통코드 한 개 조회
				readCmnCd(ccs, Utils.getNextLine("조회할 Id를 입력하세요."));
			} else if(menu == 4) {	// 공통코드 수정
				updateCmnCd(ccs, Utils.getNextLine("수정할 Id를 입력하세요.")
						       , Utils.getNextLine("생성할 공통코드명을 입력하세요."));
			} else if(menu == 5) {	// 공통코드 삭제
				deleteCmnCd(ccs,Utils.getNextLine("삭제할 Id를 입력하세요."));
			}
		}		
	}

	private void executePctr(PctrService ps) {
		System.out.println("사진 서비스 호출");
		while(true) {
			int menu = Utils.getNextInt(SUBMENU);
	
			if(menu == 0) {
				return;
			} else if(menu == 1) {			// 사진 생성
				createPctr(ps, Utils.getNextLine("생성할 사진의 영화Id를 입력하세요.")
							   , Utils.getNextLine("생성할 사진의 타입을 입력하세요.")
							   , Utils.getNextLine("생성할 사진의 썸네일을 입력하세요.")
							   , Utils.getNextLine("생성할 사진의 원본을 입력하세요."));
			} else if(menu == 2) {	// 사진 목록 조회
				readAllPctr(ps);	
			} else if(menu == 3) {	// 사진 한 개 조회
				readPctr(ps, Utils.getNextLine("조회할 Id를 입력하세요."));
			} else if(menu == 4) {	// 사진 수정
				updatePctr(ps, Utils.getNextLine("수정할 Id를 입력하세요.")
						     , Utils.getNextLine("수정할 사진의 영화Id를 입력하세요.")
							 , Utils.getNextLine("수정할 사진의 타입을 입력하세요.")
							 , Utils.getNextLine("수정할 사진의 썸네일을 입력하세요.")
							 , Utils.getNextLine("수정할 사진의 원본을 입력하세요."));
			} else if(menu == 5) {	// 사진 삭제
				deletePctr(ps,Utils.getNextLine("삭제할 Id를 입력하세요."));
			}
		}		
	}
	
	private void executeVd(VdService vs) {
		System.out.println("동영상 서비스 호출");
		while(true) {
			int menu = Utils.getNextInt(SUBMENU);
	
			if(menu == 0) {
				return;
			} else if(menu == 1) {			// 동영상 생성
				createVd(vs, Utils.getNextLine("생성할 동영상의 영화Id를 입력하세요.")
					       , Utils.getNextLine("생성할 동영상의 타입을 입력하세요.")
						   , Utils.getNextLine("생성할 동영상의 제목을 입력하세요.")
						   , Utils.getNextLine("생성할 동영상의 썸네일을 입력하세요.")
						   , Utils.getNextLine("생성할 동영상의 주소를 입력하세요."));
			} else if(menu == 2) {	// 동영상 목록 조회
				readAllVd(vs);	
			} else if(menu == 3) {	// 동영상 한 개 조회
				readVd(vs, Utils.getNextLine("조회할 Id를 입력하세요."));
			} else if(menu == 4) {	// 동영상 수정
				updateVd(vs, Utils.getNextLine("수정할 Id를 입력하세요.")
						   , Utils.getNextLine("수정할 동영상의 영화Id를 입력하세요.")
					       , Utils.getNextLine("수정할 동영상의 타입을 입력하세요.")
						   , Utils.getNextLine("수정할 동영상의 제목을 입력하세요.")
						   , Utils.getNextLine("수정할 동영상의 썸네일을 입력하세요.")
						   , Utils.getNextLine("수정할 동영상의 주소를 입력하세요."));
			} else if(menu == 5) {	// 동영상 삭제
				deleteVd(vs,Utils.getNextLine("삭제할 Id를 입력하세요."));
			}
		}		
	}

	private void executeMv(MvService ms, GnrService gs, CntrService cntrSrvc) {
		System.out.println("영화 서비스 호출");
		while(true) {
			int menu = Utils.getNextInt(SUBMENU);
	
			if(menu == 0) {
				return;
			} else if(menu == 1) {			// 영화 생성
				createMv(ms, gs, cntrSrvc
					   , Utils.getNextLine("생성할 영화의 제목을 입력하세요.")
				       , Utils.getNextLine("생성할 영화의 영어제목을 입력하세요.")
					   , Utils.getNextLine("생성할 영화의 상영상태를 입력하세요.")
					   , Utils.getNextInt("생성할 영화의 상영시간을 입력하세요.")
					   , Utils.getNextLine("생성할 영화의 개봉일을 입력하세요.")
					   , Utils.getNextLine("생성할 영화의 관람등급을 입력하세요.")
					   , Utils.getNextLine("생성할 영화의 포스터를 입력하세요.")
					   , Utils.getNextLine("생성할 영화의 줄거리를 입력하세요.")
					   , Utils.getNextLine("생성할 영화의 장르를 입력하세요.")
					   , Utils.getNextLine("생성할 영화의 제작지를 입력하세요."));
			} else if(menu == 2) {	// 영화 목록 조회
				readAllMv(ms);	
			} else if(menu == 3) {	// 영화 한 개 조회
				readMv(ms, Utils.getNextLine("조회할 Id를 입력하세요."));
			} else if(menu == 4) {	// 영화 수정
				updateMv(ms, Utils.getNextLine("수정할 Id를 입력하세요.")
						   , Utils.getNextLine("수정할 영화의 제목을 입력하세요.")
					       , Utils.getNextLine("수정할 영화의 영어제목을 입력하세요.")
						   , Utils.getNextLine("수정할 영화의 상영상태를 입력하세요.")
						   , Utils.getNextInt("수정할 영화의 상영시간을 입력하세요.")
						   , Utils.getNextLine("수정할 영화의 개봉일을 입력하세요.")
						   , Utils.getNextLine("수정할 영화의 관람등급을 입력하세요.")
						   , Utils.getNextLine("수정할 영화의 포스터를 입력하세요.")
						   , Utils.getNextLine("수정할 영화의 줄거리를 입력하세요."));
			} else if(menu == 5) {	// 영화 삭제
				deleteMv(ms,Utils.getNextLine("삭제할 Id를 입력하세요."));
			}
		}		
	}

	public static void main(String[] args) {
		GnrService gs = new GnrServiceImpl();
		CntrService cntrSrvc = new CntrServiceImpl();
		CmpnyService cmpSrvc = new CmpnyServiceImpl();
		MvPplService mps = new MvPplServiceImpl();
		CmnCdService ccs = new CmnCdServiceImpl();
		PctrService ps = new PctrServiceImpl();
		VdService vs = new VdServiceImpl();
		MvService ms = new MvServiceImpl();
		
		int menu;
		NaverMv nm = new NaverMv();
		while (true) {
			menu = Utils.getNextInt(MENU);
			if (menu == 0) {
				break;
			} else if (menu == 1) {
				nm.executeGnr(gs);
			} else if (menu == 2) {
				nm.executeCntr(cntrSrvc);
			} else if (menu == 3) {
				nm.executeCmpny(cmpSrvc);
			} else if (menu == 4) {
				nm.executeMvPpl(mps);
			} else if (menu == 5) {
				nm.executeCmnCd(ccs);
			} else if (menu == 6) {
				nm.executePctr(ps);
			} else if (menu == 7) {
				nm.executeVd(vs);
			} else if (menu == 8) {
				nm.executeMv(ms,gs,cntrSrvc);
			} 
		}
		System.out.println("끗");
	}

}
