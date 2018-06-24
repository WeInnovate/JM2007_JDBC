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
public class LoginFilter implements Filter {

	public LoginFilter() {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// pre-processing
		System.out.println("LoginFilter1 pre-processing");
		String email = request.getParameter("email");

		if (email != null && email.equals("atul@atul.com")) {
			System.out.println("You are bloacked!");
		} else {
			// pass the request along the filter chain
			chain.doFilter(request, response);
		}

		// post-processing
		System.out.println("LoginFilter1 post-processing");
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
