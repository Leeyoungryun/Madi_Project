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
		
	
	//memo DB에 추가
	public static boolean writeContent(MemoBean vo){//Memo.java에서 호출할 때, 매개변수로 MemoBean객체 보내줬음
		//db랑 연결하는 부분이라고 생각해
		Connection con = null;	
		PreparedStatement pstmt = null;
		boolean result = false;
		
		String sql = "INSERT INTO MEMO VALUES(SEQ_MEMO_NUM.NEXTVAL,?,?,?,?,?,?,SYSDATE,1)";
		//memo DB에 write form에서 입력한 값들 삽입하는 쿼리문

		try {
			con = source.getConnection();
			pstmt = con.prepareStatement(sql);

	        pstmt.setInt(1,vo.getMemberNum());//1번째 물음표에 MemoBean객체에있는 MemberNum가져온다. MemberNum이 10번 저장되어있으면
	        //INSERT INTO MEMO VALUES(SEQ_MEMO_NUM.NEXTVAL,10,?,?,?,?,?,SYSDATE,1); 이렇게 된다고 생각해.
	        pstmt.setString(2,vo.getTitle());
	        pstmt.setString(3, vo.getContent());
	        pstmt.setString(4, vo.getHashTag1());
	        pstmt.setString(5, vo.getHashTag2());
	        pstmt.setString(6, vo.getHashTag3());
	        //다른것도 마찬가지
	        
			int count = pstmt.executeUpdate();//쿼리문 실행되서 memo table에 값 추가	
			if(count != 0){//쿼리문 실행할 때 오류안나면
				result = true;//true값 반환 -> 다시 Memo.java돌아가
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(pstmt, con);
		}
		return result;		
	}
	
	//��ȸ - boolean flag �� = read�� ��� true, update�� ���  false
	public static MemoBean getContent(int  num, boolean flag){		
		Connection con = null;	
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		MemoBean vo  = null;
		//String sql1="UPDATE memo set readnum=readnum+1 WHERE num=?";	
		
		String sql2="SELECT MEMBER_NUM, TITLE, CONTENT, HASHTAG1, HASHTAG2, HASHTAG3, TO_CHAR(WRITEDAY,'yyyy/mm/dd hh24:mi:ss'), MUSIC_NUM FROM MEMO WHERE MEMO_NUM = ?";

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
						rset.getString(2), rset.getString(3), rset.getString(4), rset.getString(5), rset.getString(6), rset.getString(7),rset.getInt(8));
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
	
	// �Խù� ����
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
	
	// ��� �Խù� ��ȸ
	public  static MemoBean[] getAllContents(int memeberNum){
		Connection con = null;	
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		MemoBean[] list  = null;
		ArrayList alist = new ArrayList();
		
		String sql="SELECT MEMO_NUM, MEMBER_NUM, TITLE, CONTENT, HASHTAG1, HASHTAG2, HASHTAG3, WRITEDAY, MUSIC_NUM FROM MEMO WHERE MEMBER_NUM = ? ORDER BY MEMO_NUM DESC";	
		
		try {
			con = source.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, memeberNum);
			rset = pstmt.executeQuery();
			while(rset.next()){
				alist.add(new MemoBean(rset.getInt(1), rset.getInt(2), rset.getString(3), rset.getString(4), 
						rset.getString(5), rset.getString(6), rset.getString(7), rset.getString(8), rset.getInt(9)));
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
