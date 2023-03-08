package com.ktdsuniversity.edu.naver.movie.mvppl.dao;

import java.util.List;

import com.ktdsuniversity.edu.naver.movie.mvppl.vo.MvPplVO;
import com.ktdsuniversity.edu.naver.movie.utils.db.AbstractDaoPoolSupport;

public class MvPplDAOImpl extends AbstractDaoPoolSupport<MvPplVO> implements MvPplDAO {

	@Override
	public int createMvPpl(MvPplVO mvPplVO) {
		StringBuffer sql = new StringBuffer();
		sql.append(" INSERT INTO MV_PPL");
		sql.append(" ( MV_PPL_ID       ");
		sql.append(" , PRFL_PCTR       ");
		sql.append(" , NM              ");
		sql.append(" , RL_NM)          ");
		sql.append(" VALUES            ");
		sql.append(" ( 'PD-' || TO_CHAR(SYSDATE,'YYYYMMDD') || '-' || LPAD(SEQ_MV_PPL_PK.NEXTVAL,5,0) /*MV_PPL_ID*/");
		sql.append(" , ?/*PRFL_PCTR*/   ");
		sql.append(" , ?/*NM*/          ");
		sql.append(" , ?/*RL_NM*/)      ");
		
		return insert(sql.toString(), (pstmt)->{
			pstmt.setString(1, mvPplVO.getPrflPctr());
			pstmt.setString(2, mvPplVO.getNm());
			pstmt.setString(3, mvPplVO.getRlNm());
		});
	}

	@Override
	public MvPplVO readMvPpl(String mvPplId) {
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT MV_PPL_ID ");
		sql.append(" 	 , PRFL_PCTR    ");
		sql.append(" 	 , NM           ");
		sql.append(" 	 , RL_NM        ");
		sql.append("   FROM MV_PPL    ");
		sql.append("  WHERE MV_PPL_ID = ?");
		
		return selectOne(sql.toString(),(pstmt)->{
			pstmt.setString(1, mvPplId);
		},(rs) -> {
			MvPplVO mvPplVO = new MvPplVO();
			mvPplVO.setMvPplId(rs.getString("MV_PPL_ID"));
			mvPplVO.setPrflPctr(rs.getString("PRFL_PCTR"));
			mvPplVO.setNm(rs.getString("NM"));
			mvPplVO.setRlNm(rs.getString("RL_NM"));
			return mvPplVO;
		});
	}

	@Override
	public List<MvPplVO> readAllMvPpl() {
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT MV_PPL_ID ");
		sql.append(" 	 , PRFL_PCTR    ");
		sql.append(" 	 , NM           ");
		sql.append(" 	 , RL_NM        ");
		sql.append("   FROM MV_PPL    ");
		
		return select(sql.toString(), null, (rs) -> {
			MvPplVO mvPplVO = new MvPplVO();
			mvPplVO.setMvPplId(rs.getString("MV_PPL_ID"));
			mvPplVO.setPrflPctr(rs.getString("PRFL_PCTR"));
			mvPplVO.setNm(rs.getString("NM"));
			mvPplVO.setRlNm(rs.getString("RL_NM"));
			return mvPplVO;
		});
	}

	@Override
	public int updateMvPpl(MvPplVO mvPplVO) {
		StringBuffer sql = new StringBuffer();
		sql.append(" UPDATE MV_PPL       ");
		sql.append("    SET PRFL_PCTR = ?");
		sql.append(" 	 , NM = ?          ");
		sql.append(" 	 , RL_NM = ?       ");
		sql.append("  WHERE MV_PPL_ID = ?");
		
		return update(sql.toString(), (pstmt)->{
			pstmt.setString(1, mvPplVO.getPrflPctr());
			pstmt.setString(2, mvPplVO.getNm());
			pstmt.setString(3, mvPplVO.getRlNm());
			pstmt.setString(4, mvPplVO.getMvPplId());
		});
	}

	@Override
	public int deleteMvPpl(String mvPplId) {
		StringBuffer sql = new StringBuffer();
		sql.append(" DELETE           ");
		sql.append("   FROM MV_PPL       ");
		sql.append("  WHERE MV_PPL_ID = ?");
		
		return delete(sql.toString(), (pstmt)->{
			pstmt.setString(1, mvPplId);
		});
	}
}
