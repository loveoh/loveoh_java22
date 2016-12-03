package com.kaishengit.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kaishengit.exception.ServiceException;
import com.kaishengit.service.BookService;

public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		

		String name = request.getParameter("name");
		String author = request.getParameter("author");
		String total = request.getParameter("total");
		String isbn = request.getParameter("isbn");

		BookService bookService = new BookService();
		try {

			bookService.add(name, author, Integer.valueOf(total), isbn);
			// 添加成功,重定向到/list
			response.sendRedirect("/list");

		} catch (ServiceException ex) {

			request.setAttribute("name", name);
			request.setAttribute("author", author);
			request.setAttribute("total", total);
			request.setAttribute("isbn", isbn);

			request.setAttribute("message", ex.getMessage());

			request.getRequestDispatcher("/WEB-INF/views/add.jsp").forward(request, response);
		}
	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		

			req.getRequestDispatcher("/WEB-INF/views/add.jsp").forward(req, resp);
		

	}

}
