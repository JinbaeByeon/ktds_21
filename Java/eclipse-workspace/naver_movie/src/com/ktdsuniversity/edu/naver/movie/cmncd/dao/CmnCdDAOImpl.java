package com.ktdsuniversity.edu.naver.movie.cmncd.dao;

import java.util.List;

import com.ktdsuniversity.edu.naver.movie.cmncd.vo.CmnCdVO;
import com.ktdsuniversity.edu.naver.movie.utils.db.AbstractAutoDaoPoolSupport;

public class CmnCdDAOImpl extends AbstractAutoDaoPoolSupport<CmnCdVO> implements CmnCdDAO {

	@Override
	public int createCmnCd(CmnCdVO cmnCdVO) {
		StringBuffer sql = new StringBuffer();
		sql.append(" INSERT INTO CMN_CD ");
		sql.append("  (CMN_CD_ID        ");
		sql.append(" , CD_NM            ");
		sql.append(" , PRCDNC_CD_ID)    ");
		sql.append(" VALUES             ");
		sql.append("  (?                ");
		sql.append(" , ?                ");
		sql.append(" , ?)               ");
		
		return insert(sql.toString(), (pstmt)->{
			pstmt.setString(1, cmnCdVO.getCmnCdId());
			pstmt.setString(2, cmnCdVO.getCdNm());
			pstmt.setString(3, cmnCdVO.getPrcdncCdId());
		});
	}

	@Override
	public CmnCdVO readCmnCd(String cmnCdId) {
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT CMN_CD_ID ");
		sql.append(" 	  , CD_NM        ");
		sql.append(" 	  , PRCDNC_CD_ID ");
		sql.append("   FROM CMN_CD    ");
		sql.append("  WHERE CMN_CD_ID = ?");

		return selectOne(sql.toString(),(pstmt) ->{
			pstmt.setString(1, cmnCdId);
		}, CmnCdVO.class);
	}

	@Override
	public List<CmnCdVO> readAllCmnCd() {
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT CMN_CD_ID ");
		sql.append(" 	  , CD_NM        ");
		sql.append(" 	  , PRCDNC_CD_ID ");
		sql.append("   FROM CMN_CD    ");

		return select(sql.toString(), null, CmnCdVO.class);
	}

	@Override
	public int updateCmnCd(CmnCdVO cmnCdVO) {
		StringBuffer sql = new StringBuffer();
		sql.append(" UPDATE CMN_CD           ");
		sql.append("    SET CD_NM = ?        ");
		sql.append("      , PRCDNC_CD_ID = ? ");
		sql.append("  WHERE CMN_CD_ID = ?    ");
		
		return update(sql.toString(), (pstmt)->{
			pstmt.setString(1, cmnCdVO.getCdNm());
			pstmt.setString(2, cmnCdVO.getPrcdncCdId());
			pstmt.setString(3, cmnCdVO.getCmnCdId());
		});
	}

	@Override
	public int deleteCmnCd(String cmnCdId) {
		StringBuffer sql = new StringBuffer();
		sql.append(" DELETE           ");
		sql.append("   FROM CMN_CD    ");
		sql.append("  WHERE CMN_CD_ID = ?");
		
		return delete(sql.toString(), (pstmt)->{
			pstmt.setString(1, cmnCdId);
		});
	}

}
