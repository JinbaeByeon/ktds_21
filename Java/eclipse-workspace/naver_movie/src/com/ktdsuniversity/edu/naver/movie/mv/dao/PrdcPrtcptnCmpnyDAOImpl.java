package com.ktdsuniversity.edu.naver.movie.mv.dao;

import java.util.List;

import com.ktdsuniversity.edu.naver.movie.mv.vo.MvVO;
import com.ktdsuniversity.edu.naver.movie.mv.vo.PrdcPrtcptnCmpnyVO;
import com.ktdsuniversity.edu.naver.movie.utils.db.AbstractDaoPoolSupport;

public class PrdcPrtcptnCmpnyDAOImpl extends AbstractDaoPoolSupport<MvVO>
									 implements PrdcPrtcptnCmpnyDAO {

	@Override
	public int createPrdcPrtcptnCmpny(MvVO mvVO) {
		StringBuffer sql = new StringBuffer();
		sql.append(" INSERT INTO PRDC_PRTCPTN_CMPNY");
		sql.append(" (PRDC_PRTCPTN_ID           ");
		sql.append(", MV_ID                     ");
		sql.append(", CMPNY_ID                  ");
		sql.append(", CRCLTN_CD)                ");
		sql.append("VALUES                      ");
		sql.append(" ('MC-' || SYSDATE || '-' || LPAD(SEQ_PRDC_PRTCPTN_CMPNY_PK.NEXTVAL, 5, '0') ");
		sql.append(", ?                        ");
		sql.append(", ?                        ");
		sql.append(", ?)                       ");
		
		int resCnt = 0;
		List<PrdcPrtcptnCmpnyVO> listCmpny = mvVO.getCmpnyList();
		for(PrdcPrtcptnCmpnyVO cmpny : listCmpny) {
			resCnt += insert(sql.toString(), (pstmt) -> {
				pstmt.setString(1, mvVO.getMvId());
				pstmt.setString(2, cmpny.getCmpnyId());
				pstmt.setString(3, cmpny.getCrcltnCd());
			});
		}
		return resCnt;
	}

	@Override
	public int updatePrdcPrtcptnCmpny(MvVO mvVO) {
		return 0;
	}

	@Override
	public int deletePrdcPrtcptnCmpny(MvVO mvVO) {
		return 0;
	}
	

}
