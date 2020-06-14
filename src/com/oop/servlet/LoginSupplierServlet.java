/* K.A.T. Thiwanka
IT19076362 */
package com.oop.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.model.Supplier;
import com.oop.service.ISupplierService;
import com.oop.service.SupplierServiceImpl;

/**
 * Servlet implementation class LoginSupplierServlet
 */
@WebServlet("/LoginSupplierServlet")
public class LoginSupplierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginSupplierServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Creating variables and assign variables using values from the login form
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		//Creating object using SupplierServiceImpl class 
		ISupplierService supService = new SupplierServiceImpl();
		
		//Creating supplier object
		Supplier supplier = new Supplier();
		
		//Setting attributes of supplier object using setters
		supplier.setUserName(username);
		supplier.setPassword(password);
		
		//Handling SQL Exception which thrown in implemented method
		try {
			
			//Calling method for validate username and password
		    supplier = supService.validateDetails(supplier);
		    
		    //Checking if password and username is valid or not
		    if(supplier.getUserName() != null || supplier.getPassword() != null) {
				
		    	//Message in console
		    	System.out.println("Successfully logged in");
				System.out.println();
				
				//Alert for user
				PrintWriter writer = response.getWriter();  
				
				response.setContentType("text/html");  
				writer.println("<script type=\"text/javascript\">");  
				writer.println("alert('Succussfully Logged In');");  
				writer.println("</script>");	
				
				//Redirecting to the account page
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/userSupplier.jsp");
				request.setAttribute("username", username);
				dispatcher.include(request, response);
		    }
		    else {
				
		    	//Message in console
				System.out.println("There was an error when logging in");
				System.out.println();
				
				//Alert for user
				PrintWriter writer = response.getWriter();  
				
				response.setContentType("text/html");  
				writer.println("<script type=\"text/javascript\">");  
				writer.println("alert('Your Username or Password is Incorrect');");  
				writer.println("</script>");	
				
				//Redirecting to the login page
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/supplierLogin.jsp");
				dispatcher.include(request, response);
		    }
			    
		}
		catch (SQLException e) {
			
			e.printStackTrace();
		}
	
	}

}
