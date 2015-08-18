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
		
		//참고해
		}else if(command.equals("write")){//write 페이지에서 submit하면 hidden값으로 command vlaue를 write 넘겨줘서, 여기로 온거야
			String member = request.getParameter("member");
			String title = request.getParameter("title");			
			String content = request.getParameter("content");
			String hashTag1 = request.getParameter("hashtag1");
			String hashTag2 = request.getParameter("hashtag2");
			String hashTag3 = request.getParameter("hashtag3"); //form안에 있던 값들 (name에 맞는 value값 가져옴)
			
			if(title == null || title.trim().length() == 0 ){
				response.sendRedirect("write.jsp");
				return;//보지마
			}
			
			if(writeTest.test(content)!=null){//감정 추출하는 부분 아직 하는 중이여서 test로 넣어둔거
				int memberNum = Integer.parseInt(member); //DB에 MEMBER_NUM int값으로 저장되어 있어서 String -> int
				MemoBean gContent = new MemoBean(memberNum, title, content, hashTag1, hashTag2, hashTag3);//jsp에서 가져온 값 MemoBean객체로 만들어 준거
				boolean result = MemoDAO.writeContent(gContent);//DB부분 -> 넘어가서 봐
				
				// MemoDAO.writeContent(gContent);가 실행 잘되면 true값 반환해서 if문 실행
				if(result){
					//메모 쓰는건 완료되면 여기로 넘어오고, 다음에 노래 추천해주는 부분
					MusicBean music = MusicDAO.selectMusic(writeTest.test(content));//감정추출되었다고 가정하고 writeTest.test(content) = happy로 값 넣어놨어. 넘어가서 봐.
					
					//MusicDAO.selectMusic(writeTest.test(content)); 성공적으로 실행해서 MusicBean 객체 반환
					if(music == null){// MusicBean 객체가 없으면 오류
						response.sendRedirect("error.jsp");
						return;						
					}else{// MusicBean 객체가 있으면
						request.setAttribute("resultMusic", music);//request객체에 resultMusic이름으로 MusicBean객체 저장한다고 생각하면되는데, jsp request객체 검색하면나오고 그냥...써
						RequestDispatcher rd=request.getRequestDispatcher("/recommend.jsp");//recommend.jsp로 가서봐
						
						rd.forward(request, response);
						return;
					}
				}else{
					response.sendRedirect("error.jsp");
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
			if(gContent == null){
				response.sendRedirect("error.jsp");
				return;						
			}else{
				request.setAttribute("resultContent", gContent);
				
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
		}	
	}
}