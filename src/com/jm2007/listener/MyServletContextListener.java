package com.jm2007.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyServletContextListener implements ServletContextListener {

	public MyServletContextListener() {
	}

	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("ServletContext is destroyed.");
	}

	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("ServletContext is created and initialized.");
		ServletContext ctx = sce.getServletContext();
		String tableCreationRequired = ctx.getInitParameter("tableCreationRequired");
		if(tableCreationRequired.equals("Yes")) {
			System.out.println("Table Creation Required");
			System.out.println("Get connection \n Create Statement \n Execute Queries");
		}
		else {
			System.out.println("Table Creation Not Required");
		}
	}

}
