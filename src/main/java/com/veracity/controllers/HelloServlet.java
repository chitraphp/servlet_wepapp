package com.veracity.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class HelloServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		 
		
        response.setContentType("text/html");

        // Hello
        Date d = new Date();
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        
        out.println("<h1 style='color:red'>Current date and time is :: "+d+" </h1>");

        out.println("</body></html>");
    }

}
