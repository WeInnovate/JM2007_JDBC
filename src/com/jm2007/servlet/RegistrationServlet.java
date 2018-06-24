package com.jm2007.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegistrationServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String addr1 = request.getParameter("address");
		String addr2 = request.getParameter("address2");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String zip = request.getParameter("zip");
		String gender = request.getParameter("gender");
		String[] courses = request.getParameterValues("courses");

		response.setContentType("text/HTML");
		PrintWriter out = response.getWriter();

		out.print("<h1>Registration Successfull !!!</h1>");
		out.print("<label>Email: </label><b>" + email + "</b> <br/>");
		out.print("<label>Address 1: </label><b>" + addr1 + "</b> <br/>");
		out.print("<label>Address 2: </label><b>" + addr2 + "</b> <br/>");
		out.print("<label>City: </label><b>" + city + "</b> <br/>");
		out.print("<label>State: </label><b>" + state + "</b> <br/>");
		out.print("<label>ZIP: </label><b>" + zip + "</b><br/>");
		out.print("<label>Gender: </label><b>" + gender + "</b> <br/>");
		out.print("<label>Courses: </label>");
		out.print("<ul>");
		for (int i = 0; i < courses.length; i++) {
			out.print("<li><b>" + courses[i] + "</b></li>");
		}
		out.print("</ul>");

	}

}
