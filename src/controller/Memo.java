package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ExtractWord.writeTest;
import model.dao.MemoDAO;
import model.dao.MusicDAO;
import model.domain.MemoBean;
import model.domain.MusicBean;

 
 public class Memo extends javax.servlet.http.HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request,response);
	}  	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request,response);
	}
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("euc-kr");
		String command=request.getParameter("command");
		
		if(command == null){
			command = "list";
		}		
		
		if(command.equals("list")){
			HttpSession session = request.getSession();
			int memberNum=(int)(session.getAttribute("memberNum"));
			
			MemoBean [] list = MemoDAO.getAllContents(memberNum);			
			request.setAttribute("list", list);
			
			RequestDispatcher rd=request.getRequestDispatcher("list.jsp");
			rd.forward(request, response);
			return;
		
		}else if(command.equals("write")){
			String member = request.getParameter("member");
			String title = request.getParameter("title");			
			String content = request.getParameter("content");
			String hashTag1 = request.getParameter("hashtag1");
			String hashTag2 = request.getParameter("hashtag2");
			String hashTag3 = request.getParameter("hashtag3");
			String back = request.getParameter("back");
			
			if(title == null || title.trim().length() == 0 ){
				response.sendRedirect("write.jsp");
				return;
			}
			
			String[] hash = {hashTag1, hashTag2, hashTag3};
			
			if(writeTest.test(hash)!=null){
				int memberNum = Integer.parseInt(member);
				MemoBean gContent = new MemoBean(memberNum, title, content, hashTag1, hashTag2, hashTag3, back);
				MusicBean music = MusicDAO.selectMusic(writeTest.test(hash));
				if(music == null){
					response.sendRedirect("error.jsp");
					return;						
				}else{
					request.setAttribute("resultContent", gContent);
					request.setAttribute("resultMusic", music);
					RequestDispatcher rd=request.getRequestDispatcher("/recommend.jsp");
					
					rd.forward(request, response);
					return;
				}
			}
		}else if(command.equals("read")){
			String strNum=request.getParameter("num");
			
			if(strNum==null){
				response.sendRedirect("memo.do");
				return;
			}
			int num=Integer.parseInt(strNum);
			
			MemoBean gContent =MemoDAO.getContent(num, true);
			MusicBean music =MusicDAO.selectMusic(gContent.getMusicNum());
			
			if(gContent == null){
				response.sendRedirect("error.jsp");
				return;						
			}else{
				request.setAttribute("resultContent", gContent);
				request.setAttribute("resultMusic", music);
				
				RequestDispatcher rd=request.getRequestDispatcher("/read.jsp");
				rd.forward(request, response);
				return;
			}
		}else if(command.equals("updateForm")){
			
			String strNum=request.getParameter("num");
			if(strNum == null || strNum.trim().length() == 0){
				response.sendRedirect("memo.do");
				return;				
			}
			int num = Integer.parseInt(strNum);
			MemoBean gContent =MemoDAO.getContent(num, false);
			if(gContent == null){
				response.sendRedirect("error.jsp");
				return;						
			}else{
				request.setAttribute("resultContent", gContent);
				
				RequestDispatcher rd=request.getRequestDispatcher("update.jsp");
				rd.forward(request, response);
				return;
			}
		}else if(command.equals("update")){
			String strNum = request.getParameter("num");
			String member = request.getParameter("member");
			String title=request.getParameter("title");			
			String content=request.getParameter("content");
			System.out.println(content);
			
			if(strNum == null || strNum.trim().length() == 0 ||
				title == null || title.trim().length() == 0 ||
				content == null || content.trim().length() == 0 ){
					response.sendRedirect("memo.do");
					return;
			}
			int num=Integer.parseInt(strNum);
			int memberNum=Integer.parseInt(member);
			MemoBean gContent = new MemoBean(num, memberNum, title, content);
			boolean result = MemoDAO.updateContent(gContent);
			if(result){
				response.sendRedirect("memo.do");
				return;
			}else{
				response.sendRedirect("error.jsp");
				return;
			}

		}else if(command.equals("delete")){
			String strNum=request.getParameter("num");
			
			if(strNum == null || strNum.trim().length() == 0){
				response.sendRedirect("memo.do");
				return;				
			}
			int num = Integer.parseInt(strNum);
			boolean result = MemoDAO.deleteContent(num);
			if(result){
				response.sendRedirect("memo.do");
				return;
			}else{
				response.sendRedirect("error.jsp");
				return;				
			}
		}else if(command.equals("save")){	
			String member = request.getParameter("member");
			String title = request.getParameter("title");			
			String content = request.getParameter("content");
			String hashTag1 = request.getParameter("hashtag1");
			String hashTag2 = request.getParameter("hashtag2");
			String hashTag3 = request.getParameter("hashtag3");
			String back = request.getParameter("back");
			String music = request.getParameter("musicNum");
			
			int memberNum = Integer.parseInt(member);
			int musicNum = Integer.parseInt(music);
			
			MemoBean gContent = new MemoBean(memberNum, title, content, hashTag1, hashTag2, hashTag3, back, musicNum);
			boolean result = MemoDAO.writeContent(gContent);			
			if(result){
				response.sendRedirect("memo.do");
				return;
			}else{
				response.sendRedirect("error.jsp");
				return;
			}
		}
	}
}