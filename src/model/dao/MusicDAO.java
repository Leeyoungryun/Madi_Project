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

	public static MusicBean selectMusic(String emotion) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			con = source.getConnection();
			pstmt = con.prepareStatement("SELECT * FROM (SELECT * FROM MUSIC WHERE EMOTION = ? ORDER BY DBMS_RANDOM.VALUE) WHERE ROWNUM = 1");
			pstmt.setString(1, emotion);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				return new MusicBean(rset.getInt("MUSIC_NUM"), rset.getString("TITLE"), rset.getString("SINGER"), rset.getString("EMOTION"), rset.getString("URL"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset, pstmt, con);
		}
		return null;
	}
	
	public static MusicBean selectMusic(int musicNum) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			con = source.getConnection();
			pstmt = con.prepareStatement("SELECT * FROM MUSIC WHERE MUSIC_NUM = ?");
			pstmt.setInt(1, musicNum);
			rset = pstmt.executeQuery();
			if (rset.next()) {
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
