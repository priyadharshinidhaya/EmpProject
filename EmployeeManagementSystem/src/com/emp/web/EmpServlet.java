package com.emp.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.emp.bean.Employee;
import com.emp.dao.impl.EmployeeDB;
import com.emp.empDAO.EmpInterface;

@WebServlet(name="serv" , urlPatterns="/input")
public class EmpServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
						throws ServletException, IOException {
		
		System.out.println("doGet() called");
		
		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		String dob = req.getParameter("dob");
		String address = req.getParameter("address");
		int salary = Integer.parseInt(req.getParameter("salary"));
		String desg = req.getParameter("desg");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		
		PrintWriter out = resp.getWriter();
		System.out.println(name+" "+age+" "+dob+" "+address+" "+salary+" "+
							desg+" "+email+" "+phone);
		
		
		
		Employee employee = new Employee();
		employee.setName(name);
		employee.setAge(age);
		employee.setDob(dob);
		employee.setAddress(address);
		employee.setSalary(salary);
		employee.setDesg(desg);
		employee.setEmail(email);
		employee.setPhone(phone);
		
		EmployeeDB empDB = new EmployeeDB();
		empDB.insertEmployees(employee);
		
		System.out.print("passed to dao implementation");
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/enterAge.html");
		dispatcher.forward(req, resp); 
		
	}
	
	
}
