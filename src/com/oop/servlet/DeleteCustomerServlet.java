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

import com.oop.service.CustomerServiceImpl;
import com.oop.service.ICustomerService;

/**
 * Servlet implementation class DeleteCustomerServlet
 */
@WebServlet("/DeleteCustomerServlet")
public class DeleteCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCustomerServlet() {
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
		
		//Creating variable assign with the username from the userCustomer.jsp
		String username = request.getParameter("username");
		
		//Creating object using CustomerServiceImpl class 
		ICustomerService cusService = new CustomerServiceImpl();
		
		//Handling SQL Exception which thrown in implemented method
		try {
			
			//Calling method for delete interest details
			//Records with foreign keys should be deleted first
			boolean isDeletedInterest = cusService.deleteCustomerInterest(username);
			
			//Checking if interest details deleted form database or not
			if(isDeletedInterest == true) {	
				
				//Message in console
				System.out.println("Successfully deleted interest details");
			}
			else {
				
				//Message in console
				System.out.println("There was an error when deleting interests");
			}
			
			//Calling method for delete personal details
			boolean isDeleted = cusService.deleteCustomer(username);
			
			//Checking if personal details deleted form database or not
			if(isDeleted == true) {
				
				//Message in console
				System.out.println("Successfully deleted customer");
				System.out.println();
				
				//Alert for user
				PrintWriter writer = response.getWriter(); 
				
				response.setContentType("text/html");  
				writer.println("<script type=\"text/javascript\">");  
				writer.println("alert('Your Customer Account has been Deleted');");  
				writer.println("</script>");	
				
				//Redirecting to the home page
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
				dispatcher.include(request, response);
			}
			else {
				
				//Message in console
				System.out.println("There was an error when deleting personal details");
				System.out.println();
				
				//Alert for user
				PrintWriter writer = response.getWriter();
				
				response.setContentType("text/html");  
				writer.println("<script type=\"text/javascript\">");  
				writer.println("alert('There was an Error When Deleting Your Account');");  
				writer.println("</script>");
				
				//Redirecting to the profile page
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/userCustomer.jsp");
				dispatcher.include(request, response);
			}
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

}
