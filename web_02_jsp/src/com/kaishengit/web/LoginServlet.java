package com.kaishengit.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import com.kaishengit.entity.Admin;
import com.kaishengit.exception.ServiceException;
import com.kaishengit.service.AdminService;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String remeber = request.getParameter("remeber");
		//�õ��ͻ�����֤���ֵ
		String code = request.getParameter("code");
		//�ж���֤���Ƿ���ȷ
		HttpSession session = request.getSession();
		String sessionCode = (String) session.getAttribute("patchaca");
		System.out.println(sessionCode);
		if(code != null && code.equals(sessionCode)){
			
		
		
		// ���ü�ס�˺ŵ�cookie;
		if (StringUtils.isNotEmpty(remeber)) {
			Cookie cookie = new Cookie("username", username);
			cookie.setDomain("localhost");
			cookie.setPath("/");
			cookie.setMaxAge(60 * 60 * 24);
			cookie.setHttpOnly(true);
			response.addCookie(cookie);
		}
		AdminService adminService = new AdminService();

		try {
			Admin admin = adminService.findAdmin(username, password);
			// ��admin����ŵ�session�У��Ժ����ж��Ƿ�ͬһ���˺ŵ�¼���Ա�����������
			session = request.getSession();
			session.setAttribute("admin", admin);

			response.sendRedirect("/list");
		} catch (ServiceException e) {
			request.setAttribute("message", e.getMessage());
			request.setAttribute("username", username);

			request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);

			//response.sendRedirect("/login");
		}
		}else{
			request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
		}

	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//��ȡcookie
		String username = "";
		Cookie[] cookies = req.getCookies();
		if(cookies != null){
			for(Cookie cookie : cookies){
				if(cookie.getName().equals("username")){
				
					username = cookie.getValue();
					break;
				}
			}
		}
		req.setAttribute("username", username);
		req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);

	}
}
