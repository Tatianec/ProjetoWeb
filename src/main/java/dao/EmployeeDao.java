package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Employee;
import model.User;


public class EmployeeDao {
	
	User user = new User();
	
	 public int registerEmployee(Employee employee) throws ClassNotFoundException {
	        String INSERT_USERS_SQL = "INSERT INTO employee" +
	            "  (first_name, last_name, username, password, address, contact) VALUES " +
	            " (?, ?, ?, ?,?,?);";

	        int result = 0;

	        Class.forName("com.mysql.jdbc.Driver");

	        try (Connection connection = DriverManager
	            .getConnection("jdbc:mysql://localhost:3306/employees?useSSL=false", "root", "T8157124*");

	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
	            preparedStatement.setString(1, employee.getFirstName());
	            preparedStatement.setString(2, employee.getLastName());
	            preparedStatement.setString(3, employee.getUsername());
	            preparedStatement.setString(4, employee.getPassword());
	            preparedStatement.setString(5, employee.getAddress());
	            preparedStatement.setString(6, employee.getContact());

	            System.out.println(preparedStatement);
	            // Step 3: Execute the query or update query
	            result = preparedStatement.executeUpdate();
	            
	            preparedStatement.close();
	            connection.close();

	        } catch (SQLException e) {
	            // process sql exception
	            e.printStackTrace();
	        }
	        return result;
	    }
	 
	 public boolean validateUser(String userName, String password) throws ClassNotFoundException {
		 
	     
		 String GET_USERS_SQL = "select id"
		 		+ " from employee where first_name = ? and password = ? ;";
		 
	     Class.forName("com.mysql.jdbc.Driver");

		 try (Connection connection = DriverManager
		            .getConnection("jdbc:mysql://localhost:3306/employees?useSSL=false", "root", "T8157124*");

	            PreparedStatement preparedStatement = connection.prepareStatement(GET_USERS_SQL)) {
		 		preparedStatement.setString(1, userName);
		 		preparedStatement.setString(2, password);
		 		
		 		ResultSet rs = preparedStatement.executeQuery();	
		 		
		 		if (!rs.next()) {
		 			return false;
		 		}else {
		 			return true;
		 		}
		 		
		}catch (SQLException e) {
            e.printStackTrace();
 			return false;
		 }

	 }
	 
	 public Employee getEmployeeByUsername(String userName) throws ClassNotFoundException {
		 
		 Employee employee = new Employee();
		 
		 String GET_USERS_SQL = "select first_name, last_name, username, address,"
		 		+ " contact from employee where first_name = ? ;";
		 
	     Class.forName("com.mysql.jdbc.Driver");

		 try (Connection connection = DriverManager
		            .getConnection("jdbc:mysql://localhost:3306/employees?useSSL=false", "root", "T8157124*");

	            PreparedStatement preparedStatement = connection.prepareStatement(GET_USERS_SQL)) {
		 		preparedStatement.setString(1, userName);
		 		
		 		ResultSet rs = preparedStatement.executeQuery();	
		 		
				if (rs.next()) {
					employee.setFirstName(rs.getString("first_name"));
					employee.setLastName(rs.getString("last_name"));
					employee.setUsername(rs.getString("username"));
					employee.setAddress(rs.getString("address"));
					employee.setContact(rs.getString("contact"));
				}
		 		
	
		}catch (SQLException e) {
            e.printStackTrace();
		 }

		 return employee;
		 
	 }

}
