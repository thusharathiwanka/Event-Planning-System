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
 * Servlet implementation class AddSupplierServlet
 */
@WebServlet("/AddSupplierServlet")
public class AddSupplierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSupplierServlet() {
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
		
		//Creating variables and assign variables using values from the registration form
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		String mobileNo = request.getParameter("mobile");
		String province = request.getParameter("province");
		String service = request.getParameter("service");
		
		//Creating supplier object
		Supplier supplier = new Supplier();
		
		//Setting attributes of supplier object using setters
		supplier.setUserName(username);
		supplier.setPassword(password);
		supplier.setEmail(email);
		supplier.setGender(gender);
		supplier.setMobileNo(mobileNo);
		supplier.setProvince(province);
		supplier.setService(service);
		
		//Creating object using SupplierServiceImpl class 
		ISupplierService supService = new SupplierServiceImpl();
		
		//Handling SQL Exception which thrown in implemented method
		try {
			
			//Calling method for add personal details
			boolean isAddedDetails = supService.addSupplierDetails(supplier);
			
			//Checking if details added to the database or not
			if(isAddedDetails == true) {
				
				//Message in console
				System.out.println("Successfully added personal details");
			}
			else {
				
				//Message in console
				System.out.println("There was an error when adding personal details");
			}
			
			//Calling method for add services
			boolean isAddedService = supService.addSupplierService(supplier);
			
			//Checking if details added to the database or not
			if(isAddedService == true) {
				
				//Message in console
				System.out.println("Successfully added supplier");
				System.out.println();
				
				//Alert for user
				PrintWriter writer = response.getWriter();
	
				response.setContentType("text/html");  
				writer.println("<script type=\"text/javascript\">");  
				writer.println("alert('Your Supplier Account has been Created');");  
				writer.println("</script>");
				
				//Redirecting to the profile page
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/userSupplier.jsp");
				request.setAttribute("username", username);
				dispatcher.include(request, response);
				
			}
			else {
				
				//Message in console
				System.out.println("There was an error when adding services");
				System.out.println();
				
				//Alert for user
				PrintWriter writer = response.getWriter();
				
				response.setContentType("text/html");  
				writer.println("<script type=\"text/javascript\">");  
				writer.println("alert('There was an Error When Creating Your Account');");  
				writer.println("</script>");
				
				//Redirecting to the register page
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/registerSupplier.jsp");
				dispatcher.include(request, response);
			}
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
	}
	
}

