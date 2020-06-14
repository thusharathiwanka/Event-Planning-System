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
 * Servlet implementation class EditSupplierServlet
 */
@WebServlet("/EditSupplierServlet")
public class EditSupplierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditSupplierServlet() {
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
		
		//Creating variables and assign variables using values from the editing form
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		String mobile = request.getParameter("mobile");
		String province = request.getParameter("province");
		String service = request.getParameter("service");
		
		//Creating supplier object
		Supplier supplier = new Supplier();
		
		//Setting attributes of supplier object using setters
		supplier.setUserName(username);
		supplier.setPassword(password);
		supplier.setEmail(email);
		supplier.setGender(gender);
		supplier.setMobileNo(mobile);
		supplier.setProvince(province);
		supplier.setService(service);
		
		//Creating object using SupplierServiceImpl class 
		ISupplierService supService = new SupplierServiceImpl();
		
		//Handling SQL Exception which thrown in implemented method
		try {
			
			//Calling method for update details
			boolean isUpdated = supService.updateSupplier(supplier);
			
			//Checking if details updated in database or not
			if(isUpdated == true) {
				
				//Message in console
				System.out.println("Supplier account has been updated");
				System.out.println();
				
				//Alert for user
				PrintWriter writer = response.getWriter();  
				
				response.setContentType("text/html");  
				writer.println("<script type=\"text/javascript\">");  
				writer.println("alert('Your Supplier Account has been Updated');");  
				writer.println("</script>");	
				
				//Redirecting to the account page
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/userSupplier.jsp");
				request.setAttribute("username", username);
				dispatcher.include(request, response);
				
			}
			else {
				
				//Message in console
				System.out.println("There was an error when updating account");
				System.out.println();
				
				//Alert for user
				PrintWriter writer = response.getWriter();  
				
				response.setContentType("text/html");  
				writer.println("<script type=\"text/javascript\">");  
				writer.println("alert('There was an Error When Updating Your Account');");  
				writer.println("</script>");	
				
				//Redirecting to the edit details page
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/editSupplier.jsp");
				dispatcher.include(request, response);
			}
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

}
