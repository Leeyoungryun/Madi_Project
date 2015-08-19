package model.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import model.domain.MemoBean;

public class MemoDAO {

	static DataSource source = null;
	
	static{		 
		try {
			Context initContext = new InitialContext();		
			Context envContext			
			= (Context)initContext.lookup("java:/comp/env");
			
			source = (DataSource)envContext.lookup("jdbc/oracle");
		} catch (NamingException e) {			
			e.printStackTrace();
		}	
	}
		
	public static boolean writeContent(MemoBean vo){
		Connection con = null;	
		PreparedStatement pstmt = null;
		boolean result = false;

		String sql = "INSERT INTO MEMO VALUES(SEQ_MEMO_NUM.NEXTVAL,?,?,?,?,?,?,?,SYSDATE,?)";

		try {
			con = source.getConnection();
			pstmt = con.prepareStatement(sql);

	        pstmt.setInt(1,vo.getMemberNum());
	        pstmt.setString(2,vo.getTitle());
	        pstmt.setString(3, vo.getContent());
	        pstmt.setString(4, vo.getHashTag1());
	        pstmt.setString(5, vo.getHashTag2());
	        pstmt.setString(6, vo.getHashTag3());
	        pstmt.setString(7, vo.getBack());
	        pstmt.setInt(8, vo.getMusicNum());
	        
			int count = pstmt.executeUpdate();
			if(count != 0){
				result = true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(pstmt, con);
		}
		return result;		
	}
	
	public static MemoBean getContent(int  num, boolean flag){		
		Connection con = null;	
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		MemoBean vo  = null;
		//String sql1="UPDATE memo set readnum=readnum+1 WHERE num=?";	
		
		String sql2="SELECT MEMBER_NUM, TITLE, CONTENT, HASHTAG1, HASHTAG2, HASHTAG3, BACK, TO_CHAR(WRITEDAY,'yyyy/mm/dd hh24:mi:ss'), MUSIC_NUM FROM MEMO WHERE MEMO_NUM = ?";

		try {
			con = source.getConnection();
			/*
			if(flag){
				pstmt = con.prepareStatement(sql1);
				pstmt.setInt(1, num);
				int count = pstmt.executeUpdate();
				if(count == 0){
					return vo;
				}
			}
			*/
			pstmt = con.prepareStatement(sql2);
			pstmt.setInt(1, num);	
			rset = pstmt.executeQuery();
		
			if(rset.next()){
				vo = 	new MemoBean(num, rset.getInt(1),
						rset.getString(2), rset.getString(3), rset.getString(4), rset.getString(5), rset.getString(6), rset.getString(7), rset.getString(8), rset.getInt(9));
			}

			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(pstmt, con);
		}
		return vo;
	}
	
	//�Խù� ����
	public  static boolean deleteContent(int num){
		Connection con = null;	
		PreparedStatement pstmt = null;
		boolean result = false;
		
		String sql="DELETE FROM MEMO WHERE MEMO_NUM = ?";
		
		try {
			con = source.getConnection();
			pstmt = con.prepareStatement(sql);

	        pstmt.setInt(1,num);

			int count = pstmt.executeUpdate();
			
			if(count != 0){
				result = true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(pstmt, con);
		}
		return result;
	}
	
	public  static boolean updateContent(MemoBean vo){
		Connection con = null;	
		PreparedStatement pstmt = null;
		boolean result = false;
		
		String sql="UPDATE MEMO SET TITLE = ?, CONTENT = ? WHERE MEMO_NUM = ?";
		
		try {
			con = source.getConnection();
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1,vo.getTitle());
		    pstmt.setString(2, vo.getContent());
		    pstmt.setInt(3, vo.getMemoNum());
			pstmt.executeUpdate();

			int count = pstmt.executeUpdate();
			
			if(count != 0){
				result = true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(pstmt, con);
		}
		return result;
		
	}
	
	public  static boolean updateMusic(int musicNum){
		Connection con = null;	
		PreparedStatement pstmt = null;
		boolean result = false;
		
		String sql="UPDATE MEMO SET MUSIC_NUM = ? WHERE LAST_VALUE(MEMO_NUM)";
		
		try {
			con = source.getConnection();
			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, musicNum);
			pstmt.executeUpdate();

			int count = pstmt.executeUpdate();
			
			if(count != 0){
				result = true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(pstmt, con);
		}
		return result;
		
	}
	
	// ��� �Խù� ��ȸ
	public  static MemoBean[] getAllContents(int memeberNum){
		Connection con = null;	
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		MemoBean[] list  = null;
		ArrayList alist = new ArrayList();
		
		String sql="SELECT MEMO_NUM, MEMBER_NUM, TITLE, CONTENT, HASHTAG1, HASHTAG2, HASHTAG3, BACK, WRITEDAY, MUSIC_NUM FROM MEMO WHERE MEMBER_NUM = ? ORDER BY MEMO_NUM DESC";	
		
		try {
			con = source.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, memeberNum);
			rset = pstmt.executeQuery();
			while(rset.next()){
				alist.add(new MemoBean(rset.getInt(1), rset.getInt(2), rset.getString(3), rset.getString(4), 
						rset.getString(5), rset.getString(6), rset.getString(7), rset.getString(8), rset.getString(9), rset.getInt(10)));
			}
			
			list = new MemoBean[alist.size()];
			alist.toArray(list);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(rset, pstmt, con);
		}
		return list;
	}
	public  static void close(Statement stmt, Connection con){
		try{
			if(stmt != null){
				stmt.close();
				stmt = null;
			}
			if(con != null){
				con.close();
				con = null;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public  static void close(ResultSet rset, Statement stmt, Connection con){
		try{
			if(rset != null){
				rset.close();			
			}
			if(stmt != null){
				stmt.close();				
			}
			if(con != null){
				con.close();				
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}
