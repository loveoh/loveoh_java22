package com.kaishengit.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.kaishengit.entity.Book;
import com.kaishengit.service.BookService;

/**
 * Servlet implementation class UpdateServlet
 */
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		
		BookService bookService = new BookService();
		//判断id是否是数字
		if(StringUtils.isNumeric(id)){
			
			Book book =	bookService.findById(Integer.valueOf(id));
			if(book != null){
				request.setAttribute("book", book);
				
				request.getRequestDispatcher("/WEB-INF/views/update.jsp").forward(request, response);
			}else{
				response.sendError(404, "总有刁民想害朕");
			}
			
		}else{
			response.sendError(404, "总有刁民");
		}
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String name = request.getParameter("name");
		String author = request.getParameter("author");
		String total = request.getParameter("total");
		String isbn = request.getParameter("isbn");
		String id = request.getParameter("id");
		
		Book book = new Book();
		book.setName(name);
		book.setAuthor(author);
		book.setTotal(Integer.valueOf(total));
		book.setIsbn(isbn);
		book.setId(Integer.valueOf(id));
		
		BookService bookService = new BookService();
		
		bookService.update(book);
		
		response.sendRedirect("/list");
		
	}

}
