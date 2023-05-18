package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.EmployeeDao;
import dao.LoginDao;
import model.User;


@WebServlet("/login")
public class LoginServelet  extends HttpServlet{
	  private static final long serialVersionUID = 1L;
	  
	  LoginDao loginDao = new LoginDao();
	  EmployeeDao employeeDao = new EmployeeDao();

	  @Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/login.jsp");
			dispatcher.forward(request, response);
		}

	  @Override
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String name = request.getParameter("name");
	        String password = request.getParameter("password");

	        try {	    
	        		        	
	        	if(employeeDao.validateUser(name, password)) {
			        DadosEmpregadosServelet dadosEmpregados = new DadosEmpregadosServelet();
			        dadosEmpregados.doGet(request, response);
	        	}else {
					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/login.jsp");    
					dispatcher.forward(request, response);
	        	}
	        	
	        } catch (Exception e) {
	            e.printStackTrace();
	            
	        }

	       
	    }

	    private boolean isValidLogin(String name, String password) {

	    return true;
	  }
	}

