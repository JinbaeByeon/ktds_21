package com.ktdsuniversity.edu.goodgag.member.dao;

import java.util.List;

import com.ktdsuniversity.edu.goodgag.member.vo.MemberVO;
import com.ktdsuniversity.edu.goodgag.utils.db.AbstractDaoPoolSupport;

public class MemberDAOImpl extends AbstractDaoPoolSupport<MemberVO> implements MemberDAO {

	@Override
	public int create(MemberVO memberVO) {
		StringBuffer sql = new StringBuffer();
		sql.append(" INSERT INTO MEMBERS     ");
		sql.append("  (EML                   ");
		sql.append(" , NCKNM                 ");
		sql.append(" , VRFD_TF               ");
		sql.append(" , PWD                   ");
		sql.append(" , RGST_DT               ");
		sql.append(" , RNK)                  ");
		sql.append(" VALUES                  ");
		sql.append("  (? /*EML*/ ");
		sql.append(" , ? /*NCKNM*/");
		sql.append(" , ? /*VRFD_TF*/");
		sql.append(" , ? /*PWD*/");
		sql.append(" , SYSDATE ");
		sql.append(" , 'RANK_02')  ");
		
		return insert(sql.toString(), (pstmt) -> {
			pstmt.setString(1,memberVO.getEmail());
			pstmt.setString(2,memberVO.getNickName());
			String verified = "BOOLEAN_F";
			if(memberVO.getVerified() != null) {
				verified = memberVO.getVerified();
			} 
			pstmt.setString(3, verified);
			pstmt.setString(4,memberVO.getPassword());
		});
	}

	@Override
	public MemberVO read(String email, String password) {
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT EML ");
		sql.append("	  , NCKNM ");
		sql.append("	  , VRFD_TF ");
		sql.append("	  , PWD ");
		sql.append("	  , TO_CHAR(RGST_DT,'YYYY-MM-DD') RGST_DT ");
		sql.append("	  , RNK ");
		sql.append("   FROM MEMBERS ");
		sql.append("  WHERE EML = ? ");
		sql.append("    AND PWD = ? ");
		
		return selectOne(sql.toString(), (pstmt) -> {
			pstmt.setString(1, email);
			pstmt.setString(2, password);
		}, (rs) -> {
			MemberVO memVO = new MemberVO();
			memVO.setEmail(rs.getString("EML"));
			memVO.setNickName(rs.getString("NCKNM"));
			memVO.setVerified(rs.getString("VRFD_TF"));
			memVO.setPassword(rs.getString("PWD"));
			memVO.setRegistDate(rs.getString("RGST_DT"));
			memVO.setRank(rs.getString("RNK"));
			return memVO;
		});
	}
	
	@Override
	public MemberVO read(String email) {
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT EML ");
		sql.append("	  , NCKNM ");
		sql.append("	  , VRFD_TF ");
		sql.append("	  , PWD ");
		sql.append("	  , TO_CHAR(RGST_DT,'YYYY-MM-DD') RGST_DT ");
		sql.append("	  , RNK ");
		sql.append("   FROM MEMBERS ");
		sql.append("  WHERE EML = ? ");
		
		return selectOne(sql.toString(), (pstmt) -> {
			pstmt.setString(1, email);
		}, (rs) -> {
			MemberVO memVO = new MemberVO();
			memVO.setEmail(rs.getString("EML"));
			memVO.setNickName(rs.getString("NCKNM"));
			memVO.setVerified(rs.getString("VRFD_TF"));
			memVO.setPassword(rs.getString("PWD"));
			memVO.setRegistDate(rs.getString("RGST_DT"));
			memVO.setRank(rs.getString("RNK"));
			return memVO;
		});
	}

	@Override
	public MemberVO readByNick(String nickName) {
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT EML ");
		sql.append("	  , NCKNM ");
		sql.append("	  , VRFD_TF ");
		sql.append("	  , PWD ");
		sql.append("	  , TO_CHAR(RGST_DT,'YYYY-MM-DD') RGST_DT ");
		sql.append("	  , RNK ");
		sql.append("   FROM MEMBERS ");
		sql.append("  WHERE NCKNM = ? ");
		
		return selectOne(sql.toString(), (pstmt) -> {
			pstmt.setString(1, nickName);
		}, (rs) -> {
			MemberVO memVO = new MemberVO();
			memVO.setEmail(rs.getString("EML"));
			memVO.setNickName(rs.getString("NCKNM"));
			memVO.setVerified(rs.getString("VRFD_TF"));
			memVO.setPassword(rs.getString("PWD"));
			memVO.setRegistDate(rs.getString("RGST_DT"));
			memVO.setRank(rs.getString("RNK"));
			return memVO;
		});
	}
	@Override
	public List<MemberVO> readAll() {
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT EML ");
		sql.append("	  , NCKNM ");
		sql.append("	  , VRFD_TF ");
		sql.append("	  , PWD ");
		sql.append("	  , TO_CHAR(RGST_DT,'YYYY-MM-DD') RGST_DT ");
		sql.append("	  , RNK ");
		sql.append("   FROM MEMBERS ");
		return select(sql.toString(), null, (rs) -> {
			MemberVO memVO = new MemberVO();
			memVO.setEmail(rs.getString("EML"));
			memVO.setNickName(rs.getString("NCKNM"));
			memVO.setVerified(rs.getString("VRFD_TF"));
			memVO.setPassword(rs.getString("PWD"));
			memVO.setRegistDate(rs.getString("RGST_DT"));
			memVO.setRank(rs.getString("RNK"));
			return memVO;
		});
	}
	
	@Override
	public int update(MemberVO memberVO) {
		int res = 0;
		StringBuffer sql = new StringBuffer();
		sql.append(" UPDATE MEMBERS  ");
		sql.append("    SET NCKNM = ?");
		sql.append("  WHERE EML = ?  ");
		
		res = update(sql.toString(), (pstmt) -> {			
			pstmt.setString(1, memberVO.getNickName());
			pstmt.setString(2, memberVO.getEmail());
		});
		return res;
	}
	
	@Override
	public int delete(MemberVO memberVO) {
		int res = 0;
		StringBuffer sql = new StringBuffer();
		sql.append(" DELETE ");
		sql.append("   FROM MEMBERS ");
		sql.append("  WHERE EML = ?  "
				 + "    AND PWD = ? ");

		res = update(sql.toString(), (pstmt) -> {			
			pstmt.setString(1, memberVO.getEmail());
			pstmt.setString(2, memberVO.getPassword());
		});
		return res;
	}



}
