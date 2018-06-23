package com.jm2007.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String message = "I'm running...";
		Date date = new Date(System.currentTimeMillis());
		System.out.println(message + " " + date);

		String e = req.getParameter("email");
		PrintWriter out = resp.getWriter();
		out.print(message + " " + date+" "+e);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String e = req.getParameter("email");
		PrintWriter out = resp.getWriter();
		out.print("Hello " + e);
	}

}
