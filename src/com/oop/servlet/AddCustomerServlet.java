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

import com.oop.model.Customer;
import com.oop.service.CustomerServiceImpl;
import com.oop.service.ICustomerService;

/**
 * Servlet implementation class AddCustomerServlet
 */
@WebServlet("/AddCustomerServlet")
public class AddCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCustomerServlet() {
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
		String interest = request.getParameter("interest");
		
		//Creating customer object
		Customer customer = new Customer();
		
		//Setting attributes of customer object using setters
		customer.setUserName(username);
		customer.setPassword(password);
		customer.setEmail(email);
		customer.setGender(gender);
		customer.setMobileNo(mobileNo);
		customer.setProvince(province);
		customer.setInterest(interest);
		
		//Creating object using CustomerServiceImpl class 
		ICustomerService custService = new CustomerServiceImpl();
		
		//Handling SQL Exception which thrown in implemented method
		try {
			
			//Calling method for add personal details
			boolean isAddedDetails = custService.addCustomerDetails(customer);
			
			//Checking if details added to the database or not
			if(isAddedDetails == true) {
				
				System.out.println("Successfully added personal details");
			}
			else {
				
				System.out.println("There was an error when adding personal details");
			}
			
			//Calling method for add interests
			boolean isAddedInterest = custService.addCustomerInterest(customer);
			
			//Checking if details added to the database or not
			if(isAddedInterest == true) {
				
				//Message in console
				System.out.println("Successfully added customer");
				System.out.println();
				
				//Alert for user
				PrintWriter writer = response.getWriter();  
				
				response.setContentType("text/html");  
				writer.println("<script type=\"text/javascript\">");  
				writer.println("alert('Your Customer Account has been Created');");  
				writer.println("</script>");	
				
				//Redirecting to the profile page
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/userCustomer.jsp");
				request.setAttribute("username", username);
				dispatcher.include(request, response);
			}
			else {
				
				//Message in console
				System.out.println("There was an error when adding interests");
				System.out.println();
				
				//Alert for user
				PrintWriter writer = response.getWriter();
				
				response.setContentType("text/html");  
				writer.println("<script type=\"text/javascript\">");  
				writer.println("alert('There was an Error When Creating Your Account');");  
				writer.println("</script>");
				
				//Redirecting to the register page
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/registerCustomer.jsp");
				dispatcher.include(request, response);
			}
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
	}

}
