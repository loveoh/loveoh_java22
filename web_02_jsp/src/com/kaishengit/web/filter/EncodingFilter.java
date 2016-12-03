package com.kaishengit.web.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.commons.lang3.StringUtils;

public class EncodingFilter extends AbstractFilter {

	String encoding = "utf-8";
	@Override
	public void init(FilterConfig config) throws ServletException {
		
		
		String encoding = config.getInitParameter("encoding");
		if(StringUtils.isNotEmpty(encoding)){
			this.encoding = encoding;
		}
		
	}
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
	
		servletRequest.setCharacterEncoding(encoding);
		servletResponse.setCharacterEncoding(encoding);
		filterChain.doFilter(servletRequest, servletResponse);
		
	}

}
