package com.ktdsuniversity.edu.naver.movie.mv.dao;

import java.util.List;

import com.ktdsuniversity.edu.naver.movie.mv.vo.MvVO;
import com.ktdsuniversity.edu.naver.movie.utils.db.AbstractDaoPoolSupport;

public class MvDAOImpl extends AbstractDaoPoolSupport<MvVO> implements MvDAO {

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
		sql.append(" SELECT MV_ID  ");
		sql.append(" 	  , MV_TTL  ");
		sql.append(" 	  , ENG_TTL ");
		sql.append(" 	  , SCRN_STT");
		sql.append(" 	  , SCRN_TM ");
		sql.append(" 	  , OPNG_DT ");
		sql.append(" 	  , WTC_GRD ");
		sql.append(" 	  , PSTR    ");
		sql.append(" 	  , SMR     ");
		sql.append("   FROM MV   ");
		sql.append("  WHERE MV_ID = ?");

		return selectOne(sql.toString(), (pstmt) -> {
			pstmt.setString(1, mvId);
		}, (rs) -> {
			MvVO mvVO = new MvVO();
			mvVO.setMvId(rs.getString("MV_ID"));
			mvVO.setMvTtl(rs.getString("MV_TTL"));
			mvVO.setEngTtl(rs.getString("ENG_TTL"));
			mvVO.setScrnStt(rs.getString("SCRN_STT"));
			mvVO.setScrnTm(rs.getInt("SCRN_TM"));
			mvVO.setOpngDt(rs.getString("OPNG_DT"));
			mvVO.setWtcGrd(rs.getString("WTC_GRD"));
			mvVO.setPstr(rs.getString("PSTR"));
			mvVO.setSmr(rs.getString("SMR"));

			return mvVO;
		});
	}

	@Override
	public List<MvVO> readAllMv() {
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT MV_ID  ");
		sql.append(" 	  , MV_TTL  ");
		sql.append(" 	  , ENG_TTL ");
		sql.append(" 	  , SCRN_STT");
		sql.append(" 	  , SCRN_TM ");
		sql.append(" 	  , OPNG_DT ");
		sql.append(" 	  , WTC_GRD ");
		sql.append(" 	  , PSTR    ");
		sql.append(" 	  , SMR     ");
		sql.append("   FROM MV   ");

		return select(sql.toString(), null, (rs) -> {
			MvVO mvVO = new MvVO();
			mvVO.setMvId(rs.getString("MV_ID"));
			mvVO.setMvTtl(rs.getString("MV_TTL"));
			mvVO.setEngTtl(rs.getString("ENG_TTL"));
			mvVO.setScrnStt(rs.getString("SCRN_STT"));
			mvVO.setScrnTm(rs.getInt("SCRN_TM"));
			mvVO.setOpngDt(rs.getString("OPNG_DT"));
			mvVO.setWtcGrd(rs.getString("WTC_GRD"));
			mvVO.setPstr(rs.getString("PSTR"));
			mvVO.setSmr(rs.getString("SMR"));
			
			return mvVO;
		});
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
		return selectOneString(sql.toString(), null, (rs) -> {
			return rs.getString("NEW_SEQ");
		});
	}

}
