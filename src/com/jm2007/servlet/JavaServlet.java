package com.jm2007.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/java" }, initParams = { @WebInitParam(name = "trainerName", value = "Atul"),
		@WebInitParam(name = "trainerMobile", value = "123") })
public class JavaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public JavaServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/HTML");

		String name = request.getParameter("name");
		PrintWriter out = response.getWriter();
		out.print("Hello, " + name);
		out.print("<br />");

		ServletConfig cfg = getServletConfig();
		String trnName = cfg.getInitParameter("trainerName");
		String trnMobile = cfg.getInitParameter("trainerMobile");
		out.print("Your trainer is " + trnName + " and his mobile number is " + trnMobile);
		out.print("<br />");
		
		ServletContext ctx = cfg.getServletContext();
		String institute = ctx.getInitParameter("institute");
		out.print(institute);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
