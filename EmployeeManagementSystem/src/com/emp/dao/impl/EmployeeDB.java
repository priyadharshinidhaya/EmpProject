package com.emp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.emp.bean.*;
import com.emp.DBUtil.DBUtil;
import com.emp.bean.Employee;
import com.emp.empDAO.EmpInterface;




public class EmployeeDB implements EmpInterface{

	@Override
	public void insertEmployees(Employee employee) {
		
		System.out.println(" Details recieved in implmentation");
		System.out.println(employee.getEmail());
		
		String sql = "insert into empdetails(name,age,dob,address,salary,desg,email,phone) values(?,?,?,?,?,?,?,?)";     
		
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		
		try{
		connection  = DBUtil.getConnection();
		connection.setAutoCommit(false);
		
		
			
			System.out.println(employee.getName());
			prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setString(1, employee.getName());
			
			prepareStatement.setInt(2, employee.getAge());
			prepareStatement.setString(3, employee.getDob());
			prepareStatement.setString(4, employee.getAddress());
			prepareStatement.setInt(5, employee.getSalary());
			prepareStatement.setString(6, employee.getDesg());
			prepareStatement.setString(7, employee.getEmail());
			prepareStatement.setString(8, employee.getPhone());
			
			prepareStatement.executeUpdate();
			
			System.out.println("values inserted in empdetails table");
		
		
		connection.commit();
		}
		catch(Exception e){
			
			try{
				connection.rollback();
			}
		
			catch (Exception e1) {
				e1.printStackTrace();
			}
				e.printStackTrace();
		}
		
		finally {
			DBUtil.close(connection, prepareStatement, null);
		}
		
}

	@Override
	public boolean isPresent(String userId, int password) {
		
		String sql = "select * from login";
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;
		
		System.out.println("UserId and password recieved in implmentation ");
		
		List<String> userIdList    = new ArrayList<>();
		List<Integer> passwordList  = new ArrayList<>();
		
		try {
			connection = DBUtil.getConnection();
			prepareStatement = connection.prepareStatement(sql);
			resultSet = prepareStatement.executeQuery();
			while(resultSet.next()){
			
				userIdList.add(resultSet.getString("userId"));
				passwordList.add(resultSet.getInt("password"));
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(connection, prepareStatement, resultSet);
		}
		
	/*	System.out.println(userIdList.get(0)+" "+userIdList.get(1)+" "+userIdList.get(2));
		System.out.println(passwordList.get(0)+" "+passwordList.get(1)+" "+passwordList.get(1));
		*/
		
		
		boolean isPresented = false ;
		
		for(int i=0; i<userIdList.size(); i++) {
			
			if(userId.equals(userIdList.get(i)) ){
						if(password == passwordList.get(i)) {
							isPresented = true ;
			}
			
		}
				
	}
		return isPresented;
	}
	

	@Override
	public List<Employee> getEmployee(int age) {
		
		System.out.println("getEmployee() called ..");
		String sql = "select * from empdetails";
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;
		
		List<Employee> empList    = new ArrayList<>();
		
		
		try {
			connection = DBUtil.getConnection();
			prepareStatement = connection.prepareStatement(sql);
			resultSet = prepareStatement.executeQuery();
			
			while(resultSet.next()){
				Employee emp = new Employee();
				emp.setName(resultSet.getString("Name"));
				emp.setAddress(resultSet.getString("Address"));
				
				empList.add(emp);
				
				System.out.println(emp.getName()+" "+emp.getAddress());
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(connection, prepareStatement, resultSet);
		}
		
		
		return empList;
		
	}

	@Override
	public void insertLogin(String setUserId, int setPassword) {
		
			
			System.out.println("Details recieved in implmentation");
			
			String sql = "insert into login(userID , password) values(?,?)";     
			
			Connection connection = null;
			PreparedStatement prepareStatement = null;
			
			try{
			connection  = DBUtil.getConnection();
			connection.setAutoCommit(false);
	
				System.out.println(setUserId+""+setPassword);
				
				prepareStatement = connection.prepareStatement(sql);
				
				prepareStatement.setString(1,setUserId );
				prepareStatement.setInt(2, setPassword);
				
				
				prepareStatement.executeUpdate();
				System.out.println("values inserted in login table");
			
			
			connection.commit();
			}
			catch(Exception e){
				
				try{
					connection.rollback();
				}
			
				catch (Exception e1) {
					e1.printStackTrace();
				}
					e.printStackTrace();
			}
			
			finally {
				DBUtil.close(connection, prepareStatement, null);
			}
			
	}

}
