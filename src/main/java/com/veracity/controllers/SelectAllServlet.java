package com.veracity.controllers;

import java.io.IOException;
import java.util.List;

import com.veracity.dao.EmpDao;
import com.veracity.model.Employee;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SelectAllServlet extends HttpServlet {
	
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		List<Employee> list = new EmpDao().selectAll();
		if (list == null) {
			req.setAttribute("msg", "No Records to Show");
			RequestDispatcher rd = req.getRequestDispatcher("Message.jsp");
			rd.forward(req, res);
		} else {
			req.setAttribute("emplist", list);
			RequestDispatcher rd = req.getRequestDispatcher("DisplayAll.jsp");
			rd.forward(req, res);
		}
	}

}
