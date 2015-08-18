package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import model.domain.MemberBean;
import model.domain.MusicBean;

public class MusicDAO {
	private static MusicDAO instance = new MusicDAO();

	public static MusicDAO getInstance() {
		return instance;
	}
	static DataSource source = null;

	static {
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			source = (DataSource) envContext.lookup("jdbc/oracle");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	public static MusicBean selectMusic(String emotion) {//Memo.java에서 호출할때, 매개변수로 emotion값 보내줬음
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			con = source.getConnection();
			pstmt = con.prepareStatement("SELECT * FROM MUSIC WHERE EMOTION = ? AND ROWNUM = 1");//쿼리문 실행하면 값 여러개 나오는개 1개만 선택하려고 ROWNUM=1 넣어둠. 이건 수정할거
			pstmt.setString(1, emotion);//물음표에 가져온 emotion값 ex)happy 넣어줌
			rset = pstmt.executeQuery();
			if (rset.next()) {//쿼리문 실행하면 row값 하나 나옴. 가져온 row에서 값 가져오고 MusicBean객체로 만들어서 Memo.java로 넘겨줌.
				//MUSIC_NUM, TITLE 이런거는 DB에 저장되어있는 필드명이야.
				return new MusicBean(rset.getInt("MUSIC_NUM"), rset.getString("TITLE"), rset.getString("SINGER"), rset.getString("EMOTION"), rset.getString("URL"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset, pstmt, con);
		}
		return null;
	}
	
	public static void close(Statement pstmt, Connection con) {
		try {
			if (pstmt != null) {
				pstmt.close();
				pstmt = null;
			}
			if (con != null) {
				con.close();
				con = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rset, Statement pstmt, Connection con) {
		try {
			if (rset != null) {
				rset.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
