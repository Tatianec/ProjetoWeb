package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDao;
import model.Employee;

@WebServlet("/userdetails")
public class DadosEmpregadosServelet extends HttpServlet{
	  private static final long serialVersionUID = 1L;
	  
	 EmployeeDao employeeDao = new EmployeeDao();

	  @Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  
		  String username = request.getParameter("name");
	        
	        try {
	        	
	        	 Employee employee = employeeDao.getEmployeeByUsername(username);
	        	 request.setAttribute("employee", employee);
		   		 request.getRequestDispatcher("/WEB-INF/views/userdetails.jsp").forward(request, response);
	        	
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

		}

	  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   		 RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/userdetails.jsp");
			 dispatcher.forward(request, response);
	  }

	}

