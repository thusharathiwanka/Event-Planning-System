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

import com.oop.service.ISupplierService;
import com.oop.service.SupplierServiceImpl;

/**
 * Servlet implementation class DeleteSupplierServlet
 */
@WebServlet("/DeleteSupplierServlet")
public class DeleteSupplierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteSupplierServlet() {
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
		
		//Creating variable assign with the username from the userSupplier.jsp
		String username = request.getParameter("username");
		
		//Creating object using SupplierServiceImpl class 
		ISupplierService supService = new SupplierServiceImpl();
		
		//Handling SQL Exception which thrown in implemented method
		try {
			
			//Calling method for delete service details
			//Records with foreign keys should be deleted first
			boolean isDeletedService = supService.deleteSupplierService(username);
			
			//Checking if service details deleted form database or not
			if(isDeletedService == true) {
				
				//Message in console
				System.out.println("Successfully deleted service details");
			}
			else {
				
				//Message in console
				System.out.println("There was an error when deleting services");
			}
			
			//Calling method for delete personal details
			boolean isDeleted = supService.deleteSupplier(username);
			
			//Checking if personal details deleted form database or not
			if(isDeleted == true) {
				
				//Message in console
				System.out.println("Successfully deleted supplier");
				System.out.println();
				
				//Alert for user
				PrintWriter writer = response.getWriter();  
				
				response.setContentType("text/html");  
				writer.println("<script type=\"text/javascript\">");  
				writer.println("alert('Your Supplier Account has been Deleted');");  
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
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/userSupplier.jsp");
				dispatcher.include(request, response);
			}
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

}
