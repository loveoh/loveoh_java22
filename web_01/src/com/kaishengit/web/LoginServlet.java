package com.kaishengit.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kaishengit.dao.AccountDao;
import com.kaishengit.entity.Account;

public class LoginServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse respone) throws ServletException, IOException {

		String userName = request.getParameter("userName");
		String passWord = request.getParameter("passWord");
		
		
		AccountDao accountDao = new AccountDao();
		//accountDao.add(userName, passWord);
		Account account = accountDao.findByName(userName);
		
		System.out.println("userName:" + userName +"----" + "passWord:" + passWord);
		
		if((account != null)&&passWord.equals(account.getPassword())){
			List<String> addressList = new ArrayList<String>();
			
			addressList.add("֣����");
			addressList.add("������");
			
			request.setAttribute("addressList", addressList);
			request.setAttribute("name", userName);
			
			request.getRequestDispatcher("home.jsp").forward(request, respone);
		}else{
			respone.sendRedirect("index.jsp?error=1001");
		}
		
		
		
		
		
		
		
		
		
		
	/*	if(("tom".equals(userName)&&"aaa".equals(passWord))){
			System.out.println("��¼�ɹ�");
			
			request.setAttribute("userName", userName);
			RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
			rd.forward(request, respone);
			
			
			
			//��¼�ɹ���תҳ��
			//respone.sendRedirect("home.jsp");
			
		}else{
			System.out.println("��¼ʧ��");
			respone.sendRedirect("index.jsp?error=100");
		}
	*/
	}

}
