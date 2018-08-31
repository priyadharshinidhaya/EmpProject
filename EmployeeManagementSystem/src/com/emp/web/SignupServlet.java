package com.emp.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.emp.dao.impl.EmployeeDB;

@WebServlet(name="signup", urlPatterns="/signup")
public class SignupServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println(" Login doGet() called");
		
		String setUserId = req.getParameter("setUserId");
		int setPassword = Integer.parseInt(req.getParameter("setPassword"));
		
		System.out.println("SetUserId and SetPassword was passed to DAO ");
		
		PrintWriter out = resp.getWriter();
		System.out.println(setUserId+" "+setPassword);
		
		EmployeeDB empDB = new EmployeeDB();
		empDB.insertLogin(setUserId, setPassword);
		
		System.out.println("values inserted in login table");
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/login.html");
		dispatcher.forward(req, resp);
		
	}
}
