package com.kaishengit.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.kaishengit.service.BookService;

/**
 * ɾ��������servlet
 * 
 * @author loveoh
 *
 */
public class DelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		BookService bookService = new BookService();
		//�ж�id�Ƿ�������
			

			bookService.delete(Integer.valueOf(id));
			response.sendRedirect("/list");
			
			
		

	}

}
