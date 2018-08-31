package com.emp.empDAO;

import java.util.List;
import com.emp.bean.Employee;

public interface EmpInterface {

	public void insertEmployees(Employee emp);
	
	public boolean isPresent(String userId , int password);
	
	public List<Employee> getEmployee(int age);
	
	public void insertLogin(String setUserId , int setPassword);
}
