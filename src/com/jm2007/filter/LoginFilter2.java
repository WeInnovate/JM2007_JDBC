package com.jm2007.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/login")
public class LoginFilter2 implements Filter {

	public LoginFilter2() {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// pre-processing
		System.out.println("LoginFilter2 pre-processing");
		
		chain.doFilter(request, response);

		// post-processing
		System.out.println("LoginFilter2 post-processing");
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
