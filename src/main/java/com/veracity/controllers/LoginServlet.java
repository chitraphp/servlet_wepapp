package com.veracity.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		
		if(username.equals(password)) {
			
			Cookie ck = new Cookie("user", username);
			ck.setMaxAge(5);
			pw.write("<h3>Login Successfull</h3>");
			pw.write("<a href='inbox'>INBOX</a>  | ");
			pw.write("<a >DRAFT</a>  | ");
			pw.write("<a href='logout'>LOGOUT</a>  | ");
			res.addCookie(ck);
			
		}else {
			//return login page
			pw.write("<h3 style='color:red'>Invalid cred....</h3>");
			RequestDispatcher rd = req.getRequestDispatcher("login.html");
			rd.include(req, res);
		}
	}

}
