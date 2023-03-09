package com.ktdsuniversity.edu.naver.movie.mv.dao;

import java.util.List;

import com.ktdsuniversity.edu.naver.movie.cntr.vo.CntrVO;
import com.ktdsuniversity.edu.naver.movie.mv.vo.MvVO;
import com.ktdsuniversity.edu.naver.movie.utils.db.AbstractDaoPoolSupport;

public class PrdcLocDAOImpl extends AbstractDaoPoolSupport<MvVO>
							implements PrdcLocDAO {

	@Override
	public int createPrdcLoc(MvVO mvVO) {
		StringBuffer sql = new StringBuffer();
		sql.append(" INSERT INTO PRDC_LOC");
		sql.append(" (MV_ID           ");
		sql.append(", CNTR_ID)        ");
		sql.append("VALUES            ");
		sql.append(" (?               ");
		sql.append(", ?)              ");
		List<CntrVO> cntrList = mvVO.getCntrList();
		
		int resCnt = 0;
		for(CntrVO cntr : cntrList) {
			resCnt += insert(sql.toString(), (pstmt) -> {
				pstmt.setString(1, mvVO.getMvId());
				pstmt.setInt(2, cntr.getCntrId());
			});
		}
		return resCnt;
	}

	@Override
	public int updatePrdcLoc(MvVO mvVO) {
		return 0;
	}

	@Override
	public int deletePrdcLoc(MvVO mvVO) {
		return 0;
	}

}
