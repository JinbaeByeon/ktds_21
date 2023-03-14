package com.ktdsuniversity.edu.naver.movie.mv.dao;

import java.util.List;

import com.ktdsuniversity.edu.naver.movie.mv.vo.MvVO;
import com.ktdsuniversity.edu.naver.movie.utils.db.AbstractAutoDaoPoolSupport;

public class MvDAOImpl extends AbstractAutoDaoPoolSupport<MvVO> implements MvDAO {

	@Override
	public int createMv(MvVO mvVO) {
		StringBuffer sql = new StringBuffer();
		sql.append(" INSERT INTO MV");
		sql.append(" (MV_ID,       ");
		sql.append("  MV_TTL,      ");
		sql.append("  ENG_TTL,     ");
		sql.append("  SCRN_STT,    ");
		sql.append("  SCRN_TM,     ");
		sql.append("  OPNG_DT,     ");
		sql.append("  WTC_GRD,     ");
		sql.append("  PSTR,        ");
		sql.append("  SMR)         ");
		sql.append(" VALUES        ");
		sql.append("(?,");
		sql.append(" ?,               ");
		sql.append(" ?,               ");
		sql.append(" ?,               ");
		sql.append(" ?,               ");
		sql.append(" TO_DATE(?,'YYYY-MM-DD'),");
		sql.append(" ?, ");
		sql.append(" ?, ");
		sql.append(" ?) ");

		return insert(sql.toString(), (pstmt) -> {
			pstmt.setString(1, mvVO.getMvId());
			pstmt.setString(2, mvVO.getMvTtl());
			pstmt.setString(3, mvVO.getEngTtl());
			pstmt.setString(4, mvVO.getScrnStt());
			pstmt.setInt(5, mvVO.getScrnTm());
			pstmt.setString(6, mvVO.getOpngDt());
			pstmt.setString(7, mvVO.getWtcGrd());
			pstmt.setString(8, mvVO.getPstr());
			pstmt.setString(9, mvVO.getSmr());
		});
	}

	@Override
	public MvVO readMv(String mvId) {
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT MV.MV_ID,                           ");
		sql.append(" 	   MV.MV_TTL,                             ");
		sql.append(" 	   MV.ENG_TTL,                            ");
		sql.append(" 	   MV.SCRN_STT,                           ");
		sql.append(" 	   MV.SCRN_TM,                            ");
		sql.append(" 	   MV.OPNG_DT,                            ");
		sql.append(" 	   MV.WTC_GRD,                            ");
		sql.append(" 	   MV.PSTR,                               ");
		sql.append(" 	   MV.SMR,                                ");
		sql.append(" 	   GNR.GNR_ID,                            ");
		sql.append(" 	   GNR.GNR_NM,                            ");
		sql.append(" 	   PL.CNTR_ID,                            ");
		sql.append(" 	   PL.CNTR_NM                             ");
		sql.append("   FROM (SELECT *                           ");
		sql.append("   		  FROM MV                              ");
		sql.append("   		 WHERE MV_ID = ?) MV ");
		sql.append("   JOIN (SELECT MG.MV_ID                    ");
		sql.append("   			 , G.GNR_ID                           ");
		sql.append("   			 , G.GNR_NM                           ");
		sql.append("   		  FROM MV_GNR MG                       ");
		sql.append("   		  JOIN GNR G                           ");
		sql.append("   		  	ON G.GNR_ID = MG.GNR_ID) GNR        ");
		sql.append("   	ON GNR.MV_ID = MV.MV_ID                 ");
		sql.append("   JOIN (SELECT PL.MV_ID                    ");
		sql.append("   			 , C.CNTR_ID                          ");
		sql.append("   			 , C.CNTR_NM                          ");
		sql.append("   		  FROM PRDC_LOC PL                     ");
		sql.append("   		  JOIN CNTR C                          ");
		sql.append("   		  	ON C.CNTR_ID = PL.CNTR_ID) PL       ");
		sql.append("   	ON PL.MV_ID = MV.MV_ID                  ");

		return selectOneByKey(sql.toString(), (pstmt) -> pstmt.setString(1, mvId) , MvVO.class);
	}

	@Override
	public List<MvVO> readAllMv() {
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT MV.MV_ID,                     ");
		sql.append(" 	   MV.MV_TTL,                       ");
		sql.append(" 	   MV.MV_TTL,                       ");
		sql.append(" 	   MV.ENG_TTL,                      ");
		sql.append(" 	   MV.SCRN_STT,                     ");
		sql.append(" 	   MV.SCRN_TM,                      ");
		sql.append(" 	   MV.OPNG_DT,                      ");
		sql.append(" 	   MV.WTC_GRD,                      ");
		sql.append(" 	   MV.PSTR,                         ");
		sql.append(" 	   MV.SMR,                          ");
		sql.append(" 	   GNR.GNR_NM,                      ");
		sql.append(" 	   PL.CNTR_NM                       ");
		sql.append("   FROM MV                            ");
		sql.append("   JOIN (SELECT MG.MV_ID              ");
		sql.append("   			 , G.GNR_NM                     ");
		sql.append("   		  FROM MV_GNR MG                 ");
		sql.append("   		  JOIN GNR G                     ");
		sql.append("   		  	ON G.GNR_ID = MG.GNR_ID) GNR  ");
		sql.append("   	ON GNR.MV_ID = MV.MV_ID           ");
		sql.append("   JOIN (SELECT PL.MV_ID              ");
		sql.append("   			 , C.CNTR_NM                    ");
		sql.append("   		  FROM PRDC_LOC PL               ");
		sql.append("   		  JOIN CNTR C                    ");
		sql.append("   		  	ON C.CNTR_ID = PL.CNTR_ID) PL ");
		sql.append("   	ON PL.MV_ID = MV.MV_ID            ");

		return selectByKey(sql.toString(), null, MvVO.class);
	}

	@Override
	public int updateMv(MvVO mvVO) {
		StringBuffer sql = new StringBuffer();
		sql.append(" UPDATE MV  ");
		sql.append(" 	SET MV_TTL = ?");
		sql.append(" 	  , ENG_TTL = ?");
		sql.append(" 	  , SCRN_STT = ?");
		sql.append(" 	  , SCRN_TM = ?");
		sql.append(" 	  , OPNG_DT = TO_DATE(?,'YYYY-MM-DD')");
		sql.append(" 	  , WTC_GRD = ?");
		sql.append(" 	  , PSTR = ?");
		sql.append(" 	  , SMR = ?");
		sql.append("  WHERE MV_ID = ?  ");

		return update(sql.toString(), (pstmt) -> {
			pstmt.setString(1, mvVO.getMvTtl());
			pstmt.setString(2, mvVO.getEngTtl());
			pstmt.setString(3, mvVO.getScrnStt());
			pstmt.setInt(4, mvVO.getScrnTm());
			pstmt.setString(5, mvVO.getOpngDt());
			pstmt.setString(6, mvVO.getWtcGrd());
			pstmt.setString(7, mvVO.getPstr());
			pstmt.setString(8, mvVO.getSmr());
			pstmt.setString(9, mvVO.getMvId());
		});
	}

	@Override
	public int deleteMv(String mvId) {
		StringBuffer sql = new StringBuffer();
		sql.append(" DELETE ");
		sql.append("   FROM MV ");
		sql.append("  WHERE MV_ID = ? ");
		
		return delete(sql.toString(), (pstmt) -> {
			pstmt.setString(1, mvId);
		});
	}

	@Override
	public String createNewMvId() {
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT 'MV-' || TO_CHAR(SYSDATE,'YYYYMMDD')||'-' ||LPAD(SEQ_MV_PK.NEXTVAL,5,'0') NEW_SEQ");
		sql.append(" FROM DUAL");
		return selectOneString(sql.toString(), null);
	}

}
