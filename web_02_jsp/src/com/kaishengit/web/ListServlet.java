package com.kaishengit.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.kaishengit.entity.Book;
import com.kaishengit.service.BookService;
import com.kaishengit.utils.Page;

public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 判断账号是否登录
		/*
		 * HttpSession session = request.getSession(); Admin admin = (Admin)
		 * session.getAttribute("admin");
		 */

		//先得到url中P的值,确定数据库查询哪一页的数据
		String p = request.getParameter("p");
		//显示的当前页面
		int pagNo = 1;
		//判断p的值是否为数字
		if(StringUtils.isNumeric(p)){
			pagNo = Integer.parseInt(p);
		}
		
		
		
		BookService bookService = new BookService();
		//只查找pagNo的内容
		//List<Book> bookList = bookService.findbyPageNo(pagNo);
		
		Page<Book> page = bookService.findByPage(pagNo);
		
		//List<Book> bookList = bookService.findAll();
		//request.setAttribute("bookList", bookList);
		request.setAttribute("page", page);
		request.getRequestDispatcher("/WEB-INF/views/list.jsp").forward(request, response);
	}

}
