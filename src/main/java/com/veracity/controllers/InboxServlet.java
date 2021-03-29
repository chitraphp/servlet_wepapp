package com.veracity.controllers;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class InboxServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		
		Cookie[] ck = req.getCookies();
		String username = null;
		if(ck != null) {
			//will do some thing
			for(Cookie c : ck) {
				if(c.getName().equals("user")) {
					username = c.getValue();
				}
			}
			if(username !=null && username != "") {
				//goto inbox and get the message for this user
				pw.write("<h3>Welcome to your INBOX "+username+"</h3>");
				pw.write("<a href='logout'>LOGOUT</a>  | ");
			}else {
				pw.write("<h3 style='color:red'>Please login first !!!</h3>");
				RequestDispatcher rd = req.getRequestDispatcher("Login.html");
				rd.include(req, res);
			}
		}else {
			pw.write("<h3 style='color:red'>Please login first !!!</h3>");
			RequestDispatcher rd = req.getRequestDispatcher("Login.html");
			rd.include(req, res);
		}
		
		pw.close();
	}

}
