package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.MemberDAO;
import model.domain.MemberBean;

public class Login extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void process(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		String command = request.getParameter("command");
		String url = null;
		if (command.equals("login")) {
			String email = request.getParameter("email");
			String pw = request.getParameter("pw");
			try {
				MemberBean mb = MemberDAO.checkMember(email, pw);
				if (mb != null) {
					HttpSession session = request.getSession();
					session.setAttribute("member", mb);
					session.setAttribute("memberNum", mb.getMemberNum());

					request.getRequestDispatcher("write.jsp").forward(request,
							response);
				} else {
					response.sendRedirect("error.jsp");
				}
			} catch (Exception e) {
				response.sendRedirect("error.jsp");
			}

		} else if (command.equals("logout")) {
			try {
				HttpSession session = request.getSession();
				session.removeAttribute("member");
				request.getRequestDispatcher("index.html").forward(request,
						response);
			} catch (Exception e) {
				response.sendRedirect("error.jsp");
			}
		}
	}
}
