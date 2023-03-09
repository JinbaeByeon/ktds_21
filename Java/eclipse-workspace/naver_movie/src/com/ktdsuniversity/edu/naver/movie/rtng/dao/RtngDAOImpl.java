package com.ktdsuniversity.edu.naver.movie.rtng.dao;

import java.util.List;

import com.ktdsuniversity.edu.naver.movie.rtng.vo.RtngVO;
import com.ktdsuniversity.edu.naver.movie.utils.db.AbstractDaoPoolSupport;

public class RtngDAOImpl extends AbstractDaoPoolSupport<RtngVO> implements RtngDAO {

	@Override
	public int createRtng(RtngVO rtngVO) {
		StringBuffer sql = new StringBuffer();
		sql.append(" INSERT INTO RTNG ");
		sql.append(" (RTNG_ID      ");
		sql.append(", MV_ID        ");
		sql.append(", RTNG         ");
		sql.append(", DTL          ");
		sql.append(", WRTR         ");
		sql.append(", RGST_DT      ");
		sql.append(", LK_CNT       ");
		sql.append(", DSLK_CNT)    ");
		sql.append("VALUES         ");
		sql.append(" ('MR-' || TO_CHAR(SYSDATE,'YYYYMMDD') || '-' || LPAD(SEQ_RTNG_PK.NEXTVAL,5,0) ");
		sql.append(", ?           ");
		sql.append(", ?           ");
		sql.append(", ?           ");
		sql.append(", ?           ");
		sql.append(", SYSDATE ");
		sql.append(", 0           ");
		sql.append(", 0)           ");
		

		return insert(sql.toString(), (pstmt)->{
			pstmt.setString(1, rtngVO.getMvId());
			pstmt.setInt(2, rtngVO.getRtng());
			pstmt.setString(3, rtngVO.getDtl());
			pstmt.setString(4, rtngVO.getWrtr());
		});
	
	}

	@Override
	public RtngVO readRtng(String rtngId) {
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT RTNG_ID      ");
		sql.append("      , MV_ID        ");
		sql.append("      , RTNG         ");
		sql.append("      , DTL          ");
		sql.append("      , WRTR         ");
		sql.append("      , RGST_DT      ");
		sql.append("      , LK_CNT       ");
		sql.append("      , DSLK_CNT    ");
		sql.append(" FROM RTNG        ");
		sql.append("  WHERE RTNG_ID = ?  ");
		
		return selectOne(sql.toString(), (pstmt) -> {
			pstmt.setString(1, rtngId);
		}, (rs) -> {
			RtngVO rtngVO = new RtngVO();
			rtngVO.setMvId(rs.getString("MV_ID"));
			rtngVO.setRtng(rs.getInt("RTNG"));
			rtngVO.setDtl(rs.getString("DTL"));
			rtngVO.setWrtr(rs.getString("WRTR"));
			rtngVO.setRgstDt(rs.getString("RGST_DT"));
			rtngVO.setLkCnt(rs.getInt("LK_CNT"));
			rtngVO.setDslkCnt(rs.getInt("DSLK_CNT"));
			return rtngVO;
		});
	}

	@Override
	public List<RtngVO> readAllRtng() {
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT RTNG_ID      ");
		sql.append("      , MV_ID        ");
		sql.append("      , RTNG         ");
		sql.append("      , DTL          ");
		sql.append("      , WRTR         ");
		sql.append("      , RGST_DT      ");
		sql.append("      , LK_CNT       ");
		sql.append("      , DSLK_CNT    ");
		sql.append(" FROM RTNG        ");
		
		return select(sql.toString(), null, (rs) -> {
			RtngVO rtngVO = new RtngVO();
			rtngVO.setMvId(rs.getString("MV_ID"));
			rtngVO.setRtng(rs.getInt("RTNG"));
			rtngVO.setDtl(rs.getString("DTL"));
			rtngVO.setWrtr(rs.getString("WRTR"));
			rtngVO.setRgstDt(rs.getString("RGST_DT"));
			rtngVO.setLkCnt(rs.getInt("LK_CNT"));
			rtngVO.setDslkCnt(rs.getInt("DSLK_CNT"));
			return rtngVO;
		});
	}

	@Override
	public int updateRtng(RtngVO rtngVO) {
		StringBuffer sql = new StringBuffer();
		sql.append(" UPDATE RTNG       ");
		sql.append("    SET RTNG= ?         ");
		sql.append("      , DTL= ?        ");
		sql.append("  WHERE RTNG_ID = ?");

		return update(sql.toString(), (pstmt) -> {
			pstmt.setInt(1, rtngVO.getRtng());
			pstmt.setString(2, rtngVO.getDtl());
		});
	}

	@Override
	public int deleteRtng(String rtngId) {
		StringBuffer sql = new StringBuffer();
		sql.append(" DELETE           ");
		sql.append("   FROM RTNG        ");
		sql.append("  WHERE RTNG_ID = ? ");
		
		return delete(sql.toString(), (pstmt)->{
			pstmt.setString(1, rtngId);
		});
	}

}
