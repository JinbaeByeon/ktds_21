package com.ktdsuniversity.edu.goodgag.member.dao;

import java.util.List;
import java.util.Scanner;

import com.ktdsuniversity.edu.goodgag.member.vo.MemberVO;
import com.ktdsuniversity.edu.goodgag.utils.db.AbstractDaoSupport;

public class MemberDAOImpl extends AbstractDaoSupport<MemberVO> implements MemberDAO {

	@Override
	public int create(MemberVO vo) {
		StringBuffer sql = new StringBuffer();
		return insert(sql.toString(), (pstmt) -> {});
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
	
	private MemberVO readByNick(String nickName) {
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
	public int update(String email) {
		int res = 0;
		StringBuffer sql = new StringBuffer();
		sql.append(" UPDATE MEMBERS  ");
		sql.append("    SET NCKNM = ?");
		sql.append("  WHERE EML = ?  ");
		
		final MemberVO member = new MemberVO();
		while (member.getNickName() == null) {
			Scanner scan = new Scanner(System.in);
			System.out.println("변경할 닉네임을 입력하세요.");
			member.setNickName(scan.nextLine());
			if(readByNick(member.getNickName()) != null) {
				System.out.println("이미 존재하는 닉네임입니다.");
				member.setNickName(null);
			}
		}
		res = update(sql.toString(), (pstmt) -> {			
			pstmt.setString(1, member.getNickName());
			pstmt.setString(2, email);
		});
		return res;
	}
	
	@Override
	public int delete(String email) {
		return 1;
	}


}
