package com.kaishengit.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 安全退出页面
 * @author loveoh
 *
 */
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session =  request.getSession();
		
		session.invalidate();
		
		response.sendRedirect("/login");
		//request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
	}

}
