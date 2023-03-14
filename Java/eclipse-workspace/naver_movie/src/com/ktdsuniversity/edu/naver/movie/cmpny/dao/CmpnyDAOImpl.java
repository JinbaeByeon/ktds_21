package com.ktdsuniversity.edu.naver.movie.cmpny.dao;

import java.util.List;

import com.ktdsuniversity.edu.naver.movie.cmpny.vo.CmpnyVO;
import com.ktdsuniversity.edu.naver.movie.utils.db.AbstractAutoDaoPoolSupport;

public class CmpnyDAOImpl extends AbstractAutoDaoPoolSupport<CmpnyVO> implements CmpnyDAO {

	@Override
	public int createCmpny(CmpnyVO cmpnyVO) {
		StringBuffer sql = new StringBuffer();
		sql.append(" INSERT INTO CMPNY");
		sql.append(" ( CMPNY_ID       ");
		sql.append(" , CMPNY_NM)      ");
		sql.append(" VALUES         ");
		sql.append(" ( 'CO-' || TO_CHAR(SYSDATE,'YYYYMMDD') || '-' || LPAD(SEQ_CMPNY_PK.NEXTVAL,5,'0') ");
		sql.append(" , ?)           ");
		
		return insert(sql.toString(), (pstmt)->{
			pstmt.setString(1, cmpnyVO.getCmpnyNm());
		});
	}

	@Override
	public CmpnyVO readCmpny(String cmpnyId) {
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT CMPNY_ID    ");
		sql.append(" 	  , CMPNY_NM    ");
		sql.append("   FROM CMPNY       ");
		sql.append("  WHERE CMPNY_ID = ?");
		
		return selectOne(sql.toString(),(pstmt)->{
			pstmt.setString(1, cmpnyId);
		}, CmpnyVO.class);
	}

	@Override
	public List<CmpnyVO> readAllCmpny() {
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT CMPNY_ID ");
		sql.append(" 	  , CMPNY_NM ");
		sql.append("   FROM CMPNY    ");
		
		return select(sql.toString(), null, CmpnyVO.class);
	}

	@Override
	public int updateCmpny(CmpnyVO cmpnyVO) {
		StringBuffer sql = new StringBuffer();
		sql.append(" UPDATE CMPNY       ");
		sql.append("    SET CMPNY_NM = ?");
		sql.append("  WHERE CMPNY_ID = ?");
		
		return update(sql.toString(), (pstmt)->{
			pstmt.setString(1, cmpnyVO.getCmpnyNm());
			pstmt.setString(2, cmpnyVO.getCmpnyId());
		});
	}

	@Override
	public int deleteCmpny(String cmpnyId) {
		StringBuffer sql = new StringBuffer();
		sql.append(" DELETE           ");
		sql.append("   FROM CMPNY       ");
		sql.append("  WHERE CMPNY_ID = ?");
		
		return delete(sql.toString(), (pstmt)->{
			pstmt.setString(1, cmpnyId);
		});
	}
}
