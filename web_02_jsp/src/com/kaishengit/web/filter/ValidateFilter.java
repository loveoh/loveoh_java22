package com.kaishengit.web.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kaishengit.entity.Admin;

public class ValidateFilter extends AbstractFilter {

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		
		String uri = request.getRequestURI();
		

		if ("/".equals(uri) || "/login".equals(uri) || uri.startsWith("/static/") || "/index.jsp".equals(uri)) {

			filterChain.doFilter(request, response);
			
		} else {

			HttpSession session = request.getSession();
			Admin admin = (Admin) session.getAttribute("admin");

			if (admin != null) {

				filterChain.doFilter(request, response);
			} else {
				response.sendRedirect("/login?uri=" + uri);
			}
		}

	}

}
