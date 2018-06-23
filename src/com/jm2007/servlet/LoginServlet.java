package com.jm2007.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({ "/login", "/login-user" })
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doGet of LoginServlet");
		response.sendRedirect("login.html");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doPost of LoginServlet");

		// fetch login data
		String username = request.getParameter("email");
		String password = request.getParameter("password");

		if (username.equalsIgnoreCase(password)) {
			RequestDispatcher rd = request.getRequestDispatcher("profile");
			rd.forward(request, response);
		} else {
			response.sendRedirect("login.html");
		}

	}

}
