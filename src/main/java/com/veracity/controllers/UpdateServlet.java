package com.veracity.controllers;

import java.io.IOException;
import java.io.PrintWriter;

//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.veracity.dao.EmpDao;

public class UpdateServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		int sal = Integer.parseInt(req.getParameter("sal"));
		
		
        boolean isupdated = new EmpDao().update(id,sal);
		
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		if(isupdated) {
			pw.write("<h1> records Updated successully</h1>");
			
		}else {
			pw.write("<h2 style='color:red'>Unable to update Salary</h2>");
			
		}
		
		
	}

}
