package com.kaishengit.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kaishengit.exception.ServiceException;
import com.kaishengit.service.AdminService;

/**
 * ×¢²áÒ³Ãæ
 * 
 * @author loveoh
 *
 */
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/views/regist.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		
		AdminService adminService = new AdminService();
		
		try{
			adminService.regist(username,password);
			response.sendRedirect("/login");
			
		}catch(ServiceException e){
			String message = e.getMessage();
			request.setAttribute("username", username);
			request.setAttribute("message",message);
			request.getRequestDispatcher("/WEB-INF/views/regist.jsp").forward(request, response);
		}
	}

}
