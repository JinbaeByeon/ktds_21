package com.ktdsuniversity.edu.naver.movie;

import java.util.Scanner;

import com.ktdsuniversity.edu.naver.movie.cmncd.controller.CmnCdController;
import com.ktdsuniversity.edu.naver.movie.cmncd.service.CmnCdService;
import com.ktdsuniversity.edu.naver.movie.cmncd.service.CmnCdServieImpl;
import com.ktdsuniversity.edu.naver.movie.cmpny.controller.CmpnyController;
import com.ktdsuniversity.edu.naver.movie.cmpny.service.CmpnyService;
import com.ktdsuniversity.edu.naver.movie.cmpny.service.CmpnyServiceImpl;
import com.ktdsuniversity.edu.naver.movie.cntr.controller.CntrController;
import com.ktdsuniversity.edu.naver.movie.cntr.service.CntrService;
import com.ktdsuniversity.edu.naver.movie.cntr.service.CntrServiceImpl;
import com.ktdsuniversity.edu.naver.movie.gnr.controller.GnrController;
import com.ktdsuniversity.edu.naver.movie.gnr.service.GnrService;
import com.ktdsuniversity.edu.naver.movie.gnr.service.GnrServiceImpl;
import com.ktdsuniversity.edu.naver.movie.mvppl.controller.MvPplController;
import com.ktdsuniversity.edu.naver.movie.mvppl.service.MvPplService;
import com.ktdsuniversity.edu.naver.movie.mvppl.service.MvPplServiceImpl;

public class NaverMv implements GnrController
							  , CntrController
							  , CmpnyController
							  , MvPplController
							  , CmnCdController {
	private static final String MENU = "1. 장르, 2. 국가, 3. 회사, 4. 영화인 5. 공통코드(0: 종료)";
	private static final String SUBMENU = "1. 생성, 2. 목록조회, 3. 한개조회, 4. 수정, 5. 삭제 (0: 종료)";
	private static Scanner scan = new Scanner(System.in);

	private int getNextInt(String printMenu) {
		System.out.println(printMenu);
		int menu =scan.nextInt();
		scan.nextLine();
		return menu;
	}
	private String getNextLine(String printMenu) {
		System.out.println(printMenu);
		String menu = scan.nextLine();
		return menu;
	}
	
	private void executeGnr(GnrService gs) {
		while(true) {
			int menu = getNextInt(SUBMENU);
			if(menu == 0) {
				return;
			} else if(menu == 1) {			// 장르 생성
				createGnr(gs,getNextLine("생성할 장르명을 입력하세요."));
			} else if(menu == 2) {	// 장르 목록 조회
				System.out.println("장르 서비스 호출");
				readAllGnr(gs);			
			} else if(menu == 3) {	// 장르 하나 조회
				readGnr(gs, getNextInt("조회할 Id를 입력하세요."));
			} else if(menu == 4) {	// 장르 수정
				updateGnr(gs, getNextInt("수정할 Id를 입력하세요."), getNextLine("수정할 이름을 입력하세요"));
			} else if(menu == 5) {	// 장르 삭제
				menu = getNextInt("삭제할 Id를 입력하세요.");
				deleteGnr(gs,menu);
			}
		}
	}

	private void executeCntr(CntrService cs) {
		while(true) {
			int menu = getNextInt(SUBMENU);
			if(menu == 0) {
				return;
			} else if(menu == 1) {			// 국가 생성
				createCntr(cs,getNextLine("생성할 국가명을 입력하세요."));
			} else if(menu == 2) {	// 국가 목록 조회
				System.out.println("국가 서비스 호출");
				readAllCntr(cs);			
			} else if(menu == 3) {	// 국가 하나 조회
				readCntr(cs, getNextInt("조회할 Id를 입력하세요."));
			} else if(menu == 4) {	// 국가 수정
				updateCntr(cs, getNextInt("수정할 Id를 입력하세요."), getNextLine("수정할 이름을 입력하세요"));
			} else if(menu == 5) {	// 국가 삭제
				deleteCntr(cs,getNextInt("삭제할 Id를 입력하세요."));
			}
		}
	}

	private void executeCmpny(CmpnyService cs) {
		while(true) {
			int menu = getNextInt(SUBMENU);
			
			if(menu == 0) {
				return;
			} else if(menu == 1) {			// 회사 생성
				createCmpny(cs,getNextLine("생성할 회사명을 입력하세요."));
			} else if(menu == 2) {	// 회사 목록 조회
				System.out.println("회사 서비스 호출");
				readAllCmpny(cs);			
			} else if(menu == 3) {	// 회사 하나 조회
				readCmpny(cs, getNextLine("조회할 Id를 입력하세요."));
			} else if(menu == 4) {	// 회사 수정
				updateCmpny(cs, getNextLine("수정할 Id를 입력하세요."), getNextLine("수정할 이름을 입력하세요"));
			} else if(menu == 5) {	// 회사 삭제
				deleteCmpny(cs,getNextLine("삭제할 Id를 입력하세요."));
			}
		}
	}

	private void executeMvPpl(MvPplService mps) {
		while(true) {
			int menu = getNextInt(SUBMENU);
			
			if(menu == 0) {
				return;
			} else if(menu == 1) {			// 영화인 생성
				createMvPpl(mps, getNextLine("생성할 영화인명을 입력하세요.")
						, getNextLine("생성할 영화인 프로필사진을 입력하세요.")
						, getNextLine("생성할 영화인 본명을 입력하세요."));
			} else if(menu == 2) {	// 영화인 목록 조회
				System.out.println("영화인 서비스 호출");
				readAllMvPpl(mps);			
			} else if(menu == 3) {	// 영화인 한 명 조회
				readMvPpl(mps, getNextLine("조회할 Id를 입력하세요."));
			} else if(menu == 4) {	// 영화인 수정
				updateMvPpl(mps, getNextLine("수정할 Id를 입력하세요.")
						, getNextLine("생성할 영화인명을 입력하세요.")
						, getNextLine("생성할 영화인 프로필사진을 입력하세요.")
						, getNextLine("생성할 영화인 본명을 입력하세요."));
			} else if(menu == 5) {	// 영화인 삭제
				deleteMvPpl(mps,getNextLine("삭제할 Id를 입력하세요."));
			}
		}
	}

	private void executeCmnCd(CmnCdService ccs) {
		while(true) {
			int menu = getNextInt(SUBMENU);
	
			if(menu == 0) {
				return;
			} else if(menu == 1) {			// 공통코드 생성
				createCmnCd(ccs, getNextLine("생성할 공통코드의 Id를 입력하세요.")
							   , getNextLine("생성할 공통코드명을 입력하세요."));
			} else if(menu == 2) {	// 공통코드 목록 조회
				System.out.println("공통코드 서비스 호출");
				readAllCmnCd(ccs);	
			} else if(menu == 3) {	// 공통코드 한 개 조회
				readCmnCd(ccs, getNextLine("조회할 Id를 입력하세요."));
			} else if(menu == 4) {	// 공통코드 수정
				updateCmnCd(ccs, getNextLine("수정할 Id를 입력하세요.")
						       , getNextLine("생성할 공통코드명을 입력하세요."));
			} else if(menu == 5) {	// 공통코드 삭제
				deleteCmnCd(ccs,getNextLine("삭제할 Id를 입력하세요."));
			}
		}		
	}

	public static void main(String[] args) {
		GnrService gs = new GnrServiceImpl();
		CntrService cntrSrvc = new CntrServiceImpl();
		CmpnyService cmpSrvc = new CmpnyServiceImpl();
		MvPplService mps = new MvPplServiceImpl();
		CmnCdService ccs = new CmnCdServieImpl();
		
		int menu;
		NaverMv nm = new NaverMv();
		while (true) {
			menu = nm.getNextInt(MENU);
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
			}
		}
		System.out.println("끗");
	}

}
