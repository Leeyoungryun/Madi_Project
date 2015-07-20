package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.MemberDAO;
import model.domain.MemberBean;

public class Member extends HttpServlet {
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		process(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		process(request, response);
	}
	
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("euc-kr");
		String command = (String)request.getParameter("command");
		String url = null;
		
		if(command.equals("signup")){
			String email = request.getParameter("email");
			String pw = request.getParameter("password");
			String name = request.getParameter("name");
			String phone = request.getParameter("phone");
			String local = request.getParameter("local");
			try {
				if((request.getParameter("password")).equals(request.getParameter("password2"))){
					MemberBean member = MemberDAO.joinMember(email, pw, name, phone, local);
					HttpSession session = request.getSession();
					response.sendRedirect("login/login.jsp");
				}else{
					response.sendRedirect("error/signinError.jsp");
				}
			} catch (Exception e) {
				response.sendRedirect("error/signinError.jsp");
			}
			
		}else if(command.equals("update")){					
			HttpSession session = request.getSession();
			MemberBean mb = (MemberBean)session.getAttribute("member");		
			mb.setPw(request.getParameter("pw").trim());
			mb.setPhone(request.getParameter("phone").trim());	
			mb.setLocal(request.getParameter("local").trim());
			
			try{		
				if((request.getParameter("pw")).equals(request.getParameter("pw2"))){
				MemberDAO.updateMember(mb);			
				response.sendRedirect("myPage/successMemUpdate.jsp");
				}else{
					response.sendRedirect("error/updatePwError.jsp");
				}
			}catch(SQLException e){
				response.sendRedirect("error/updatePwError.jsp");	
			}
			
		}
	}
}
