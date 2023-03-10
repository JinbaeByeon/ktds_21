package com.ktdsuniversity.edu.naver.movie.fmsln.dao;

import java.util.List;

import com.ktdsuniversity.edu.naver.movie.fmsln.vo.FmsLnVO;
import com.ktdsuniversity.edu.naver.movie.utils.db.AbstractDaoPoolSupport;

public class FmsLnDAOImpl extends AbstractDaoPoolSupport<FmsLnVO> implements FmsLnDAO {

	@Override
	public int createFmsLn(FmsLnVO fmsLnVO) {
		StringBuffer sql = new StringBuffer();
		sql.append(" INSERT INTO FMS_LN   ");
		sql.append("  (FMS_LN_ID        ");
		sql.append(" , FMS_LN           ");
		sql.append(" , EXPL             ");
		sql.append(" , RGST_DT          ");
		sql.append(" , RGST_PPL_NM      ");
		sql.append(" , RCMD_CNT         ");
		sql.append(" , PRDC_PRTCPTN_ID) ");
		sql.append(" VALUES                                                              ");
		sql.append("  ('FL-' || TO_CHAR(SYSDATE,'YYYYMMDD') || '-' || LPAD(SEQ_FMS_LN_PK.NEXTVAL ,5,'0')");
		sql.append(" , ?        ");
		sql.append(" , ?        ");
		sql.append(" , SYSDATE   ");
		sql.append(" , ?        ");
		sql.append(" , 0         ");
		sql.append(" , ?)       ");

		return insert(sql.toString(), (pstmt) -> {
			pstmt.setString(1, fmsLnVO.getFmsLn());
			pstmt.setString(2, fmsLnVO.getExpl());
			pstmt.setString(3, fmsLnVO.getRgstPplNm());
			pstmt.setString(4, fmsLnVO.getPrdcPrtcptnId());
		});
	}

	@Override
	public FmsLnVO readFmsLn(String fmsLnId) {
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT FMS_LN_ID    ");
		sql.append(" 	  , FMS_LN          ");
		sql.append(" 	  , EXPL            ");
		sql.append(" 	  , RGST_DT         ");
		sql.append(" 	  , RGST_PPL_NM     ");
		sql.append(" 	  , RCMD_CNT        ");
		sql.append(" 	  , PRDC_PRTCPTN_ID ");
		sql.append("   FROM FMS_LN       ");
		sql.append("  WHERE FMS_LN_ID = ?  ");
		

		return selectOne(sql.toString(), (pstmt)->{
			pstmt.setString(1, fmsLnId);
		}, (rs) -> {
			FmsLnVO fmsLnVO = new FmsLnVO();
			fmsLnVO.setFmsLnId(rs.getString("FMS_LN_ID"));
			fmsLnVO.setFmsLn(rs.getString("FMS_LN"));
			fmsLnVO.setExpl(rs.getString("EXPL"));
			fmsLnVO.setRgstDt(rs.getString("RGST_DT"));
			fmsLnVO.setRgstPplNm(rs.getString("RGST_PPL_NM"));
			fmsLnVO.setRcmdCnt(rs.getInt("RCMD_CNT"));
			fmsLnVO.setPrdcPrtcptnId(rs.getString("PRDC_PRTCPTN_ID"));
			return fmsLnVO;
		});
	}

	@Override
	public List<FmsLnVO> readAllFmsLn() {
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT FMS_LN_ID    ");
		sql.append(" 	  , FMS_LN          ");
		sql.append(" 	  , EXPL            ");
		sql.append(" 	  , RGST_DT         ");
		sql.append(" 	  , RGST_PPL_NM     ");
		sql.append(" 	  , RCMD_CNT        ");
		sql.append(" 	  , PRDC_PRTCPTN_ID ");
		sql.append("   FROM FMS_LN       ");
		
		return select(sql.toString(), null, (rs) -> {
			FmsLnVO fmsLnVO = new FmsLnVO();
			fmsLnVO.setFmsLnId(rs.getString("FMS_LN_ID"));
			fmsLnVO.setFmsLn(rs.getString("FMS_LN"));
			fmsLnVO.setExpl(rs.getString("EXPL"));
			fmsLnVO.setRgstDt(rs.getString("RGST_DT"));
			fmsLnVO.setRgstPplNm(rs.getString("RGST_PPL_NM"));
			fmsLnVO.setRcmdCnt(rs.getInt("RCMD_CNT"));
			fmsLnVO.setPrdcPrtcptnId(rs.getString("PRDC_PRTCPTN_ID"));
			return fmsLnVO;
		});
	}

	@Override
	public int updateFmsLn(FmsLnVO fmsLnVO) {
		StringBuffer sql = new StringBuffer();
		sql.append(" UPDATE FMS_LN    ");
		sql.append("    SET FMS_LN = ?  ");
		sql.append("      , EXPL = ?   ");
		sql.append("  WHERE FMS_LN_ID=?");

		return update(sql.toString(), (pstmt) -> {
			pstmt.setString(1, fmsLnVO.getFmsLn());
			pstmt.setString(2, fmsLnVO.getExpl());
			pstmt.setString(3, fmsLnVO.getFmsLnId());
		});
	}

	@Override
	public int deleteFmsLn(String fmsLnId) {
		StringBuffer sql = new StringBuffer();
		sql.append(" DELETE           ");
		sql.append("   FROM FMS_LN        ");
		sql.append("  WHERE FMS_LN_ID = ? ");
		
		return delete(sql.toString(), (pstmt)->{
			pstmt.setString(1, fmsLnId);
		});
	}

}
