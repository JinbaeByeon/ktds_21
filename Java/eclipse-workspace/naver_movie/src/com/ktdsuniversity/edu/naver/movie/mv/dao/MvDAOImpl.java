package com.ktdsuniversity.edu.naver.movie.mv.dao;

import java.util.List;

import com.ktdsuniversity.edu.naver.movie.mv.vo.MvVO;
import com.ktdsuniversity.edu.naver.movie.utils.db.AbstractDaoPoolSupport;

public class MvDAOImpl extends AbstractDaoPoolSupport<MvVO> implements MvDAO{

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
		sql.append(" ('MV-' || TO_CHAR(SYSDATE,'YYYYMMDD')||'-' ||LPAD(SEQ_MV_PK.NEXTVAL,5,'0'),");
		sql.append(" ?,               ");
		sql.append(" ?,               ");
		sql.append(" ?,               ");
		sql.append(" ?,               ");
		sql.append(" TO_DATE(?,'YYYY-MM-DD'),");
		sql.append(" ?, ");
		sql.append(" ?, ");
		sql.append(" ?) ");
		return insert(sql.toString(), (pstmt)->{
			pstmt.setString(1, mvVO.getMvTtl());
			pstmt.setString(2, mvVO.getEngTtl());
			pstmt.setString(3, mvVO.getScrnStt());
			pstmt.setInt(4, mvVO.getScrnTm());
			pstmt.setString(5, mvVO.getOpngDt());
			pstmt.setString(6, mvVO.getWtcGrd() );
			pstmt.setString(7, mvVO.getPstr());
			pstmt.setString(8, mvVO.getSmr());
		});
	}

	@Override
	public MvVO readMv(String mvId) {
		return null;
	}

	@Override
	public List<MvVO> readAllMv() {
		return null;
	}

	@Override
	public int updateMv(MvVO mvVO) {
		return 0;
	}

	@Override
	public int deleteMv(String mvId) {
		return 0;
	}

}
