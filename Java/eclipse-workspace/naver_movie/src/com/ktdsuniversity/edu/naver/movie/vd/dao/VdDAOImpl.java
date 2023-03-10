package com.ktdsuniversity.edu.naver.movie.vd.dao;

import java.util.List;

import com.ktdsuniversity.edu.naver.movie.utils.db.AbstractAutoDaoPoolSupport;
import com.ktdsuniversity.edu.naver.movie.vd.vo.VdVO;

public class VdDAOImpl extends AbstractAutoDaoPoolSupport<VdVO> implements VdDAO {

	@Override
	public int createVd(VdVO vdVO) {
		StringBuffer sql = new StringBuffer();
		sql.append(" INSERT INTO VD ");
		sql.append(" (VD_ID,        ");
		sql.append("  MV_ID,        ");
		sql.append("  VD_TP,        ");
		sql.append("  TTL,          ");
		sql.append("  THMBNL,       ");
		sql.append("  PL_CNT,       ");
		sql.append("  VD_URL,       ");
		sql.append("  RGST_DT)      ");
		sql.append(" VALUES         ");
		sql.append(" ('VD-' || TO_CHAR(SYSDATE,'YYYYMMDD') || '-' || LPAD(SEQ_VD_PK.NEXTVAL,5,0), ");
		sql.append("  ?,       ");
		sql.append("  ?,       ");
		sql.append("  ?,       ");
		sql.append("  ?,       ");
		sql.append("  0,       ");
		sql.append("  ?,       ");
		sql.append("  SYSDATE) ");
		
		return insert(sql.toString(), (pstmt)->{
			pstmt.setString(1, vdVO.getMvId());
			pstmt.setString(2, vdVO.getVdTp());
			pstmt.setString(3, vdVO.getTtl());
			pstmt.setString(4, vdVO.getThmbnl());
			pstmt.setString(5, vdVO.getVdUrl());
		});
	}

	@Override
	public VdVO readVd(String vdId) {
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT VD_ID,  ");
		sql.append(" 	    MV_ID,  ");
		sql.append(" 	    VD_TP,  ");
		sql.append(" 	    TTL,    ");
		sql.append(" 	    THMBNL, ");
		sql.append(" 	    PL_CNT, ");
		sql.append(" 	    VD_URL, ");
		sql.append(" 	    RGST_DT ");
		sql.append("   FROM VD      ");
		sql.append("  WHERE VD_ID = ?");
		
		return selectOne(sql.toString(), (pstmt) -> {
			pstmt.setString(1, vdId);			
		}, VdVO.class);
	}

	@Override
	public List<VdVO> readAllVd() {
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT VD_ID,  ");
		sql.append(" 	    MV_ID,  ");
		sql.append(" 	    VD_TP,  ");
		sql.append(" 	    TTL,    ");
		sql.append(" 	    THMBNL, ");
		sql.append(" 	    PL_CNT, ");
		sql.append(" 	    VD_URL, ");
		sql.append(" 	    RGST_DT ");
		sql.append("   FROM VD      ");
		
		return select(sql.toString(), null, VdVO.class);
	}

	@Override
	public int updateVd(VdVO vdVO) {
		StringBuffer sql = new StringBuffer();
		sql.append(" UPDATE VD    ");
		sql.append("    SET MV_ID = ?, ");
		sql.append(" 	    VD_TP = ?,    ");
		sql.append(" 	    TTL = ?,      ");
		sql.append(" 	    THMBNL = ?,   ");
		sql.append(" 	    VD_URL = ?  ");
		sql.append("  WHERE VD_ID = ?  ");
		
		return update(sql.toString(), (pstmt)->{
			pstmt.setString(1, vdVO.getMvId());
			pstmt.setString(2, vdVO.getVdTp());
			pstmt.setString(3, vdVO.getTtl());
			pstmt.setString(4, vdVO.getThmbnl());
			pstmt.setString(5, vdVO.getVdUrl());
			pstmt.setString(6, vdVO.getVdId());
		});
	}

	@Override
	public int deleteVd(String vdId) {
		StringBuffer sql = new StringBuffer();
		sql.append(" DELETE           ");
		sql.append("   FROM VD        ");
		sql.append("  WHERE VD_ID = ? ");
		
		return delete(sql.toString(), (pstmt)->{
			pstmt.setString(1, vdId);
		});
	}
}
