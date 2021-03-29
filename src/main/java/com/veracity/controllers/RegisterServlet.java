package com.veracity.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;

import com.veracity.dao.EmpDao;
import com.veracity.model.Employee;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException {
    	int id = Integer.parseInt(request.getParameter("id"));
    	String name = request.getParameter("name");
		int sal = Integer.parseInt(request.getParameter("sal"));
		Employee emp = new Employee(id,sal,name);
		
		boolean isAdded = new EmpDao().register(emp);
		
		response.setContentType("text/html");
		//PrintWriter pw = response.getWriter();
		String msg;
		if(isAdded) {
			//pw.write("<h2>Record Added Successfully</h2>");
			 msg = "employee has been added";
			
		}else {
			//pw.write("<h2>Unable to Add</h2>");
			 msg = "Unable to Add";
		}
		
		request.setAttribute("msg", msg);
		RequestDispatcher rd = request.getRequestDispatcher("Message.jsp");
		rd.forward(request, response);
    }

}
