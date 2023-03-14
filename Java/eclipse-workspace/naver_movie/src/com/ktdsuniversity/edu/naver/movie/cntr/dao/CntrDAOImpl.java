package com.ktdsuniversity.edu.naver.movie.cntr.dao;

import java.util.List;

import com.ktdsuniversity.edu.naver.movie.cntr.vo.CntrVO;
import com.ktdsuniversity.edu.naver.movie.utils.db.AbstractAutoDaoPoolSupport;

public class CntrDAOImpl extends AbstractAutoDaoPoolSupport<CntrVO> implements CntrDAO {

	@Override
	public int createCntr(CntrVO cntrVO) {
		StringBuffer sql = new StringBuffer();
		sql.append(" INSERT INTO CNTR");
		sql.append(" ( CNTR_ID       ");
		sql.append(" , CNTR_NM)      ");
		sql.append(" VALUES         ");
		sql.append(" ( SEQ_CNTR_PK.NEXTVAL ");
		sql.append(" , ?)           ");
		
		return insert(sql.toString(), (pstmt)->{
			pstmt.setString(1, cntrVO.getCntrNm());
		});
	}

	@Override
	public CntrVO readCntr(int cntrId) {
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT CNTR_ID    ");
		sql.append(" 	  , CNTR_NM    ");
		sql.append("   FROM CNTR       ");
		sql.append("  WHERE CNTR_ID = ?");
		
		return selectOne(sql.toString(),(pstmt)->{
			pstmt.setInt(1, cntrId);
		}, CntrVO.class);
	}

	@Override
	public List<CntrVO> readAllCntr() {
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT CNTR_ID ");
		sql.append(" 	  , CNTR_NM ");
		sql.append("   FROM CNTR    ");
		
		return select(sql.toString(), null, CntrVO.class);
	}

	@Override
	public int updateCntr(CntrVO cntrVO) {
		StringBuffer sql = new StringBuffer();
		sql.append(" UPDATE CNTR       ");
		sql.append("    SET CNTR_NM = ?");
		sql.append("  WHERE CNTR_ID = ?");
		
		return update(sql.toString(), (pstmt)->{
			pstmt.setString(1, cntrVO.getCntrNm());
			pstmt.setInt(2, cntrVO.getCntrId());
		});
	}

	@Override
	public int deleteCntr(int cntrId) {
		StringBuffer sql = new StringBuffer();
		sql.append(" DELETE           ");
		sql.append("   FROM CNTR       ");
		sql.append("  WHERE CNTR_ID = ?");
		
		return delete(sql.toString(), (pstmt)->{
			pstmt.setInt(1, cntrId);
		});
	}
}
