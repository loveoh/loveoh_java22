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

		// �ж��˺��Ƿ��¼
		/*
		 * HttpSession session = request.getSession(); Admin admin = (Admin)
		 * session.getAttribute("admin");
		 */

		//�ȵõ�url��P��ֵ,ȷ�����ݿ��ѯ��һҳ������
		String p = request.getParameter("p");
		//��ʾ�ĵ�ǰҳ��
		int pagNo = 1;
		//�ж�p��ֵ�Ƿ�Ϊ����
		if(StringUtils.isNumeric(p)){
			pagNo = Integer.parseInt(p);
		}
		
		
		
		BookService bookService = new BookService();
		//ֻ����pagNo������
		//List<Book> bookList = bookService.findbyPageNo(pagNo);
		
		Page<Book> page = bookService.findByPage(pagNo);
		
		//List<Book> bookList = bookService.findAll();
		//request.setAttribute("bookList", bookList);
		request.setAttribute("page", page);
		request.getRequestDispatcher("/WEB-INF/views/list.jsp").forward(request, response);
	}

}
