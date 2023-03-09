package com.ktdsuniversity.edu.naver.movie.pctr.dao;

import java.util.List;

import com.ktdsuniversity.edu.naver.movie.pctr.vo.PctrVO;
import com.ktdsuniversity.edu.naver.movie.utils.db.AbstractDaoPoolSupport;

public class PctrDAOImpl extends AbstractDaoPoolSupport<PctrVO> implements PctrDAO {
	@Override
	public int createPctr(PctrVO pctrVO) {
		StringBuffer sql = new StringBuffer();
		sql.append(" INSERT INTO PCTR ");
		sql.append(" (PCTR_ID,        ");
		sql.append("  MV_ID,          ");
		sql.append("  PCTR_TP,        ");
		sql.append("  THMBNL_PCTR,    ");
		sql.append("  ORGNL_PCTR)     ");
		sql.append(" VALUES           ");
		sql.append(" ('PT-' || TO_CHAR(SYSDATE,'YYYYMMDD') || '-' || LPAD(SEQ_PCTR_PK.NEXTVAL,5,0) ");
		sql.append("  ,? ");
		sql.append("  ,? ");
		sql.append("  ,? ");
		sql.append("  ,?) ");
		
		return insert(sql.toString(), (pstmt)->{
			pstmt.setString(1, pctrVO.getMvId());
			pstmt.setString(2, pctrVO.getPctrTp());
			pstmt.setString(3, pctrVO.getThmbnlPctr());
			pstmt.setString(4, pctrVO.getOrgnlPctr());
		});
	}

	@Override
	public PctrVO readPctr(String pctrId) {
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT PCTR_ID,  ");
		sql.append(" 	   MV_ID,       ");
		sql.append(" 	   PCTR_TP,     ");
		sql.append(" 	   THMBNL_PCTR, ");
		sql.append(" 	   ORGNL_PCTR   ");
		sql.append(" FROM PCTR        ");
		sql.append("  WHERE PCTR_ID = ?  ");
		
		return selectOne(sql.toString(), (pstmt) -> {
			pstmt.setString(1, pctrId);
		}, (rs) -> {
			PctrVO pctrVO = new PctrVO();
			pctrVO.setPctrId(rs.getString("PCTR_ID"));
			pctrVO.setMvId(rs.getString("MV_ID"));
			pctrVO.setPctrTp(rs.getString("PCTR_TP"));
			pctrVO.setThmbnlPctr(rs.getString("THMBNL_PCTR"));
			pctrVO.setOrgnlPctr(rs.getString("ORGNL_PCTR"));
			return pctrVO;
		});
	}

	@Override
	public List<PctrVO> readAllPctr() {
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT PCTR_ID,  ");
		sql.append(" 	   MV_ID,       ");
		sql.append(" 	   PCTR_TP,     ");
		sql.append(" 	   THMBNL_PCTR, ");
		sql.append(" 	   ORGNL_PCTR   ");
		sql.append(" FROM PCTR        ");
		
		return select(sql.toString(), null, (rs) -> {
			PctrVO pctrVO = new PctrVO();
			pctrVO.setPctrId(rs.getString("PCTR_ID"));
			pctrVO.setMvId(rs.getString("MV_ID"));
			pctrVO.setPctrTp(rs.getString("PCTR_TP"));
			pctrVO.setThmbnlPctr(rs.getString("THMBNL_PCTR"));
			pctrVO.setOrgnlPctr(rs.getString("ORGNL_PCTR"));
			return pctrVO;
		});
	}

	@Override
	public int updatePctr(PctrVO pctrVO) {
		StringBuffer sql = new StringBuffer();
		sql.append(" UPDATE PCTR        ");
		sql.append(" SET MV_ID = ?,    ");
		sql.append(" 	PCTR_TP = ?,     ");
		sql.append(" 	THMBNL_PCTR = ?, ");
		sql.append(" 	ORGNL_PCTR = ?   ");
		sql.append(" WHERE PCTR_ID = ? ");
		
		return update(sql.toString(), (pstmt)->{
			pstmt.setString(1, pctrVO.getMvId());
			pstmt.setString(2, pctrVO.getPctrTp());
			pstmt.setString(3, pctrVO.getThmbnlPctr());
			pstmt.setString(4, pctrVO.getOrgnlPctr());
			pstmt.setString(5, pctrVO.getPctrId());
		});
	}

	@Override
	public int deletePctr(String pctrId) {
		StringBuffer sql = new StringBuffer();
		sql.append(" DELETE           ");
		sql.append("   FROM PCTR        ");
		sql.append("  WHERE PCTR_ID = ? ");
		
		return delete(sql.toString(), (pstmt)->{
			pstmt.setString(1, pctrId);
		});
	}
}
