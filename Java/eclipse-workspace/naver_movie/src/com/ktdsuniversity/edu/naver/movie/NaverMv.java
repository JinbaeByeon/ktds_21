package com.ktdsuniversity.edu.naver.movie;

import com.ktdsuniversity.edu.naver.movie.Inf.MyController;
import com.ktdsuniversity.edu.naver.movie.cmncd.controller.CmnCdController;
import com.ktdsuniversity.edu.naver.movie.cmpny.controller.CmpnyController;
import com.ktdsuniversity.edu.naver.movie.cntr.controller.CntrController;
import com.ktdsuniversity.edu.naver.movie.fmsln.controller.FmsLnController;
import com.ktdsuniversity.edu.naver.movie.gnr.controller.GnrController;
import com.ktdsuniversity.edu.naver.movie.mv.controller.MvController;
import com.ktdsuniversity.edu.naver.movie.mvppl.controller.MvPplController;
import com.ktdsuniversity.edu.naver.movie.pctr.controller.PctrController;
import com.ktdsuniversity.edu.naver.movie.rtng.controller.RtngController;
import com.ktdsuniversity.edu.naver.movie.utils.Utils;
import com.ktdsuniversity.edu.naver.movie.vd.controller.VdController;

public class NaverMv {
	private static final String MENU = "1. 장르, 2. 국가, 3. 회사, 4. 영화인, 5. 공통코드"
								   + ", 6. 사진, 7. 동영상, 8. 영화, 9. 평점, 10. 명대사 (0: 종료)";
	private static final String SUBMENU = "1. 생성, 2. 목록조회, 3. 한개조회, 4. 수정, 5. 삭제 (0: 종료)";

	private void executeCon(MyController con) {
		while(true) {
			int menu = Utils.getNextInt(SUBMENU);
			if(menu == 0) {
				return;
			} else if(menu == 1) {
				con.create();
			} else if(menu == 2) {
				con.readAll();
			} else if(menu == 3) {
				con.read();
			} else if(menu == 4) {
				con.update();
			} else if(menu == 5) {
				con.delete();
			}
		}
	}

	public static void main(String[] args) {
		MyController gnrCon = new GnrController();
		MyController cntrCon = new CntrController();
		MyController cmpnyCon = new CmpnyController();
		MyController mvPplCon = new MvPplController();
		MyController cmnCdCon = new CmnCdController();
		MyController pctrCon = new PctrController();
		MyController vdCon = new VdController();
		MyController mvCon = new MvController();
		MyController rtngCon = new RtngController();
		MyController fmsLnCon = new FmsLnController();

		int menu;
		NaverMv nm = new NaverMv();
		while (true) {
			menu = Utils.getNextInt(MENU);
			if (menu == 0) {
				break;
			} else if (menu == 1) {
				System.out.println("장르 컨트롤러 호출");
				nm.executeCon(gnrCon);
			} else if (menu == 2) {
				System.out.println("국가 컨트롤러 호출");
				nm.executeCon(cntrCon);
			} else if (menu == 3) {
				System.out.println("회사 컨트롤러 호출");
				nm.executeCon(cmpnyCon);
			} else if (menu == 4) {
				System.out.println("영화인 컨트롤러 호출");
				nm.executeCon(mvPplCon);
			} else if (menu == 5) {
				System.out.println("공통코드 컨트롤러 호출");
				nm.executeCon(cmnCdCon);
			} else if (menu == 6) {
				System.out.println("사진 컨트롤러 호출");
				nm.executeCon(pctrCon);
			} else if (menu == 7) {
				System.out.println("동영상 컨트롤러 호출");
				nm.executeCon(vdCon);
			} else if (menu == 8) {
				System.out.println("영화 컨트롤러 호출");
				nm.executeCon(mvCon);
			} else if (menu == 9) {
				System.out.println("평점 컨트롤러 호출");
				nm.executeCon(rtngCon);
			} else if (menu == 10) {
				System.out.println("명대사 컨트롤러 호출");
				nm.executeCon(fmsLnCon);
			} 
		}
		System.out.println("끗");
	}

}
