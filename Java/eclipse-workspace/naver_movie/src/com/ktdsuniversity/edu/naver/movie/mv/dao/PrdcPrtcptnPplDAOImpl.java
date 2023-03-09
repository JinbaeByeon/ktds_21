package com.ktdsuniversity.edu.naver.movie.mv.dao;

import java.util.List;

import com.ktdsuniversity.edu.naver.movie.mv.vo.MvVO;
import com.ktdsuniversity.edu.naver.movie.mv.vo.PrdcPrtcptnPplVO;
import com.ktdsuniversity.edu.naver.movie.utils.db.AbstractDaoPoolSupport;

public class PrdcPrtcptnPplDAOImpl extends AbstractDaoPoolSupport<MvVO> implements PrdcPrtcptnPplDAO {

	@Override
	public int createPrdcPrtcptnPpl(MvVO mvVO) {
		StringBuffer sql = new StringBuffer();
		sql.append(" INSERT INTO PRDC_PRTCPTN_PPL");
		sql.append(" (PRDC_PRTCPTN_ID           ");
		sql.append(", MV_ID                     ");
		sql.append(", MV_PPL_ID                  ");
		sql.append(", ROL_TP                ");
		sql.append(", RSPNSBLT_ROL_NM)                ");
		sql.append("VALUES                      ");
		sql.append(" ('MP-' || SYSDATE || '-' || LPAD(SEQ_PRDC_PRTCPTN_PPL_PK.NEXTVAL, 5, '0') ");
		sql.append(", ?                        ");
		sql.append(", ?                        ");
		sql.append(", ?                        ");
		sql.append(", ?)                       ");
		
		int resCnt = 0;
		List<PrdcPrtcptnPplVO> listPpl = mvVO.getPrdcMvPplList();
		for(PrdcPrtcptnPplVO mvPpl : listPpl) {
			resCnt += insert(sql.toString(), (pstmt) -> {
				pstmt.setString(1, mvVO.getMvId());
				pstmt.setString(2, mvPpl.getMvPplId());
				pstmt.setString(3, mvPpl.getRolTp());
				pstmt.setString(4, mvPpl.getRspnsbltRolNm());
			});
		}
		return resCnt;
	}

	@Override
	public int updatePrdcPrtcptnPpl(MvVO mvVO) {
		return 0;
	}

	@Override
	public int deletePrdcPrtcptnPpl(MvVO mvVO) {
		return 0;
	}

}
