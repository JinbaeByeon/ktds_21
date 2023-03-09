package com.ktdsuniversity.edu.naver.movie.mv.dao;

import java.util.List;

import com.ktdsuniversity.edu.naver.movie.gnr.vo.GnrVO;
import com.ktdsuniversity.edu.naver.movie.mv.vo.MvVO;
import com.ktdsuniversity.edu.naver.movie.utils.db.AbstractDaoPoolSupport;

public class MvGnrDAOImpl extends AbstractDaoPoolSupport<MvVO>
						  implements MvGnrDAO {

	@Override
	public int createMvGnr(MvVO mvVO) {
		String mvId = mvVO.getMvId();
		List<GnrVO> gnrList = mvVO.getGnrList();
		StringBuffer sql = new StringBuffer();
		sql.append(" INSERT INTO MV_GNR");
		sql.append("  (MV_ID         ");
		sql.append(" , GNR_ID)       ");
		sql.append(" VALUES          ");
		sql.append("  (?             ");
		sql.append(" , ?)            ");
		
		int resCnt = 0;
		for(GnrVO gnr : gnrList) {
			resCnt += insert(sql.toString(), (pstmt)->{
				pstmt.setString(1, mvId);
				pstmt.setInt(2, gnr.getGnrId());
			});
		}
		return resCnt;
	}

	@Override
	public int updateMvGnr(MvVO mvVO) {
		return 0;
	}

	@Override
	public int deleteMvGnr(MvVO mvVO) {
		return 0;
	}

}
