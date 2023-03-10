package com.ktdsuniversity.edu.naver.movie.gnr.dao;

import java.util.List;

import com.ktdsuniversity.edu.naver.movie.gnr.vo.GnrVO;
import com.ktdsuniversity.edu.naver.movie.utils.db.AbstractAutoDaoPoolSupport;

public class GnrDAOImpl extends AbstractAutoDaoPoolSupport<GnrVO> implements GnrDAO {

	@Override
	public int createGnr(GnrVO gnrVO) {
		StringBuffer sql = new StringBuffer();
		sql.append(" INSERT INTO GNR");
		sql.append(" ( GNR_ID       ");
		sql.append(" , GNR_NM)      ");
		sql.append(" VALUES         ");
		sql.append(" ( SEQ_GNR_PK.NEXTVAL ");
		sql.append(" , ?)           ");

		return insert(sql.toString(), (pstmt) -> {
			pstmt.setString(1, gnrVO.getGnrNm());
		});
	}

	@Override
	public GnrVO readGnr(int gnrId) {
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT GNR_ID    ");
		sql.append(" 	  , GNR_NM    ");
		sql.append("   FROM GNR       ");
		sql.append("  WHERE GNR_ID = ?");

		return selectOne(sql.toString(), (pstmt) -> {
			pstmt.setInt(1, gnrId);
		}, GnrVO.class);
	}

	@Override
	public GnrVO readGnrByName(String gnrName) {
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT GNR_ID    ");
		sql.append(" 	  , GNR_NM    ");
		sql.append("   FROM GNR       ");
		sql.append("  WHERE GNR_NM = ?");

		return selectOne(sql.toString(), (pstmt) -> {
			pstmt.setString(1, gnrName);
		}, GnrVO.class);
	}

	@Override
	public List<GnrVO> readAllGnr() {
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT GNR_ID ");
		sql.append(" 	  , GNR_NM ");
		sql.append("   FROM GNR    ");

		return select(sql.toString(), null, GnrVO.class);
	}

	@Override
	public int updateGnr(GnrVO gnrVO) {
		StringBuffer sql = new StringBuffer();
		sql.append(" UPDATE GNR       ");
		sql.append("    SET GNR_NM = ?");
		sql.append("  WHERE GNR_ID = ?");

		return update(sql.toString(), (pstmt) -> {
			pstmt.setString(1, gnrVO.getGnrNm());
			pstmt.setInt(2, gnrVO.getGnrId());
		});
	}

	@Override
	public int deleteGnr(int gnrId) {
		StringBuffer sql = new StringBuffer();
		sql.append(" DELETE           ");
		sql.append("   FROM GNR       ");
		sql.append("  WHERE GNR_ID = ?");

		return delete(sql.toString(), (pstmt) -> {
			pstmt.setInt(1, gnrId);
		});
	}

}
