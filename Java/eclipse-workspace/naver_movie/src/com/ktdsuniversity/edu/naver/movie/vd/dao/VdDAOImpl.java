package com.ktdsuniversity.edu.naver.movie.vd.dao;

import java.util.List;

import com.ktdsuniversity.edu.naver.movie.utils.db.AbstractDaoPoolSupport;
import com.ktdsuniversity.edu.naver.movie.vd.vo.VdVO;

public class VdDAOImpl extends AbstractDaoPoolSupport<VdVO> implements VdDAO {

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
		sql.append("  ?,       ");
		sql.append("  ?,       ");
		sql.append("  SYSDATE) ");
		
		return insert(sql.toString(), (pstmt)->{
			pstmt.setString(1, vdVO.getVdId());
			pstmt.setString(2, vdVO.getMvId());
			pstmt.setString(3, vdVO.getVdTp());
			pstmt.setString(4, vdVO.getTtl());
			pstmt.setString(5, vdVO.getThmbnl());
			pstmt.setInt(6, vdVO.getPlCnt());
			pstmt.setString(7, vdVO.getVdUrl());
			pstmt.setString(8, vdVO.getRgstDt());
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
		}, (rs) -> {
			VdVO vdVO = new VdVO();
			vdVO.setVdId(rs.getString("VD_ID"));
			vdVO.setMvId(rs.getString("MV_ID"));
			vdVO.setVdTp(rs.getString("VD_TP"));
			vdVO.setTtl(rs.getString("TTL"));
			vdVO.setThmbnl(rs.getString("THMBNL"));
			vdVO.setPlCnt(rs.getInt("PL_CNT"));
			vdVO.setVdUrl(rs.getString("VD_URL"));
			vdVO.setRgstDt(rs.getString("RGST_DT"));
			return vdVO;
		});
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
		
		return select(sql.toString(), null, (rs) -> {
			VdVO vdVO = new VdVO();
			vdVO.setVdId(rs.getString("VD_ID"));
			vdVO.setMvId(rs.getString("MV_ID"));
			vdVO.setVdTp(rs.getString("VD_TP"));
			vdVO.setTtl(rs.getString("TTL"));
			vdVO.setThmbnl(rs.getString("THMBNL"));
			vdVO.setPlCnt(rs.getInt("PL_CNT"));
			vdVO.setVdUrl(rs.getString("VD_URL"));
			vdVO.setRgstDt(rs.getString("RGST_DT"));
			return vdVO;
		});
	}

	@Override
	public int updateVd(VdVO vdVO) {
		StringBuffer sql = new StringBuffer();
		sql.append(" UPDATE VD    ");
		sql.append("    SET MV_ID = ?, ");
		sql.append(" 	   VD_TP = ?,    ");
		sql.append(" 	   TTL = ?,      ");
		sql.append(" 	   THMBNL = ?,   ");
		sql.append(" 	   PL_CNT = ?,    ");
		sql.append(" 	   VD_URL = ?,   ");
		sql.append(" 	   RGST_DT = ?   ");
		sql.append("  WHERE VD_ID = ?  ");
		
		return update(sql.toString(), (pstmt)->{
			pstmt.setString(1, vdVO.getMvId());
			pstmt.setString(2, vdVO.getVdTp());
			pstmt.setString(3, vdVO.getTtl());
			pstmt.setString(4, vdVO.getThmbnl());
			pstmt.setInt(5, vdVO.getPlCnt());
			pstmt.setString(6, vdVO.getVdUrl());
			pstmt.setString(7, vdVO.getRgstDt());
			pstmt.setString(8, vdVO.getVdId());
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
