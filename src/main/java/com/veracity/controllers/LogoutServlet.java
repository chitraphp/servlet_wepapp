package com.veracity.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LogoutServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		Cookie ck = new Cookie("user", "");
		res.addCookie(ck);
		
		pw.write("<h3 style='color:red'>Logout successful....</h3>");
		RequestDispatcher rd = req.getRequestDispatcher("Login.html");
		rd.include(req, res);
	}

}
