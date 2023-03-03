package com.ktdsuniversity.edu.goodgag;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ktdsuniversity.edu.goodgag.member.dao.MemberDAO;
import com.ktdsuniversity.edu.goodgag.member.dao.MemberDAOImpl;
import com.ktdsuniversity.edu.goodgag.member.vo.MemberVO;

public class GoodGagDAO {
	// 1521 = Oracle Server, XE = Express Edition
	final static String url = "jdbc:oracle:thin:@localhost:1521:XE";
	final static String userID = "BBS";
	final static String userPWD = "BBS1234";
	
	static Connection conn = null;
	static PreparedStatement pstmt = null; // DB에게 쿼리를 실행 요청하는 객체
	static ResultSet rs = null;
	
	// 1. Oracle Driver Loading
	public static void loadDriver() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static void closeAll() {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {}
		}
		if(pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {}
		}
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {}
		}
	}
	
	public static void excute() {
		loadDriver();
		
//		printAllMembers();
//		printAllBoards();
//		System.out.println();
//		printAllReplies();
		
		printBoard("bb@gmail.com");
		System.out.println();
		printBoard("admin@gmail.com");
	}
	
	public static void selectTable(String sql) {
		
	}
	
	public static void printAllReplies() {
		try {
			// 2. Oracle DB에 연결
			conn = DriverManager.getConnection(url, userID, userPWD);
			
			// 3. Query 작성
			StringBuffer sql = new StringBuffer();
			sql.append(" SELECT RPL_ID                                     ");
			sql.append(" 	 , BRD_ID                                        ");
			sql.append(" 	 , EML                                           ");
			sql.append(" 	 , RPL                                           ");
			sql.append(" 	 , TO_CHAR(RGST_DT,'YYYY-MM-DD HH24:MI') RGST_DT ");
			sql.append(" 	 , TO_CHAR(MDF_DT ,'YYYY-MM-DD HH24:MI') MDF_DT  ");
			sql.append(" 	 , PRNT_RPL_ID                                   ");
			sql.append("   FROM REPLIES                                    ");
			pstmt = conn.prepareStatement(sql.toString());
			
			// 4. Query 실행
			rs = pstmt.executeQuery();
			
			// 5. Query 결과 받아서 출력
			while(rs.next()) {
				String replyId = rs.getString("RPL_ID");
				String boardId = rs.getString("BRD_ID");
				String email = rs.getString("EML");
				String reply = rs.getString("RPL");
				String registDate = rs.getString("RGST_DT");
				String modifyDate = rs.getString("MDF_DT");
				String parentReplyID = rs.getString("PRNT_RPL_ID");
				
				System.out.println("RPL_ID : " + replyId + '\t'
								 + "BRD_ID : " + boardId + '\t'
								 + "EML : " + email + '\t'
								 + "RPL : " + reply + '\t'
								 + "RGST_DT : " + registDate + '\t'
								 + "MDF_DT : " + modifyDate + '\t'
								 + "PRNT_RPL_ID : " + parentReplyID + '\t');
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
	}
	
	public static void printBoard(String email) {
		try {
			conn = DriverManager.getConnection(url,userID,userPWD);

			StringBuffer sql = new StringBuffer();
			sql.append("SELECT TTL                                           ");
			sql.append("	 , NCKNM                                            ");
			sql.append("	 , TO_CHAR(RGST_DT,'YYYY-MM-DD HH24:MI') RGST_DT_BRD");
			sql.append("  FROM BOARDS BD                                     ");
			sql.append("  JOIN (SELECT EML                                   ");
			sql.append("  			 , NCKNM                                        ");
			sql.append("  	 	  FROM MEMBERS                                  ");
			sql.append("  	 	 WHERE EML = ?) MB              ");
			sql.append("  	ON MB.EML = BD.EML                                ");

			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, email);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String title = rs.getString("TTL");
				String nickName = rs.getString("NCKNM");
				String registDate = rs.getString("RGST_DT_BRD");
				System.out.println("title : " + title + '\t'
								 + "nickName : " +  nickName + '\t'
								 + "registDate : " + registDate);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
		
	}
	
	public static void printAllBoards() {
		try {
			// 2. Oracle DB에 연결
			conn = DriverManager.getConnection(url, userID, userPWD);
			
			// 3. Query 작성
			StringBuffer sql = new StringBuffer();
			sql.append(" SELECT BRD_ID ");
			sql.append("	  , EML       ");
			sql.append("	  , TTL       ");
			sql.append("	  , DSCRPT    ");
			sql.append("	  , TO_CHAR(RGST_DT, 'YYYY-MM-DD') RGST_DT ");
			sql.append("	  , SRC       ");
			sql.append("	  , NTC_TF    ");
			sql.append("   FROM BOARDS ");
			pstmt = conn.prepareStatement(sql.toString());
			
			// 4. Query 실행
			rs = pstmt.executeQuery();
			
			// 5. Query 결과 받아서 출력
			while(rs.next()) {
				String boardId = rs.getString("BRD_ID");
				String email = rs.getString("EML");
				String title = rs.getString("TTL");
				String descript = rs.getString("DSCRPT");
				String registDate = rs.getString("RGST_DT");
				String source = rs.getString("SRC");
				String noticeTf = rs.getString("NTC_TF");
				
				System.out.println("BRD_ID : " + boardId + '\t'
								 + "EML : " + email + '\t'
								 + "TTL : " + title + '\t'
								 + "DSCRPT : " + descript + '\t'
								 + "RGST_DT : " + registDate + '\t'
								 + "SRC : " + source + '\t'
								 + "NTC_TF : " + noticeTf + '\t');
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
	}
	
	public static void printAllMembers() {
		try {
			// 2. Oracle DB에 연결
			conn = DriverManager.getConnection(url, "BBS", "BBS1234");
			// 3. Query 작성
			// 여러 줄의 String을 작성할 때, 사용할 수 있는 객체
			StringBuffer sql = new StringBuffer();
			sql.append(" SELECT EML ");
			sql.append("	  , NCKNM ");
			sql.append("	  , VRFD_TF ");
			sql.append("	  , PWD ");
			sql.append("	  , TO_CHAR(RGST_DT,'YYYY-MM-DD') RGST_DT ");
			sql.append("	  , RNK ");
			sql.append("   FROM MEMBERS ");

			// 3-1. Query를 DB로 보냄
			pstmt = conn.prepareStatement(sql.toString());

			// 4. DB에서 Query 결과 받아오기
			// ResultSet
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String email = rs.getString("EML");
				String nickname = rs.getString("NCKNM");
				String verified = rs.getString("VRFD_TF");
				String password = rs.getString("PWD");
				String registDate = rs.getString("RGST_DT");
				String rank = rs.getString("RNK");

				System.out.println("email : "  + email + '\t'
								 + "nickname : "  + nickname + '\t'
								 + "verified : "  + verified + '\t'
								 + "password : "  + password + '\t'
								 + "regist_date : "  + registDate + '\t'
								 + "rank : "  + rank + '\t');
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 5. DB 연결 해제
			closeAll();
		}
	}
	
	public static void main(String[] args) {
//		excute();
		MemberDAO memDAO = new MemberDAOImpl();
//		List<MemberVO> listMember = memDAO.readAll();
//		listMember.forEach(System.out::println);
		MemberVO memVO = new MemberVO();
		memVO.setEmail("bb@gmail.com");
		memDAO.update(memVO);
		MemberVO member = memDAO.read("bb@gmail.com", "adasdasdasdwqqweqe");
		System.out.println(member);
		
		
		
	}
}
