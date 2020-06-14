<!-- K.A.T. Thiwanka -->
<!-- IT19076362 -->
<%@page import="com.oop.service.ISupplierService"%>
<%@ page import="com.oop.service.SupplierServiceImpl"%>
<%@ page import="com.oop.model.Supplier"%> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" href="./assests/css/bootstrap.min.css"> <!-- For navigation bar -->
	<link rel="stylesheet" href="./assests/css/main.css">
	<link rel="stylesheet" href="./assests/css/user.css">
	<link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;500;700&display=swap" rel="stylesheet">
	<title>Planning Pros | Profile</title>
</head>
<body>
	<!-- Start header -->
	<header>
		<div class="navbar">
			<nav class="navbar navbar-expand-lg navbar-light">
				<a class="navbar-brand">Planning Pros</a>
				<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
					aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarNav">
					<div class="mr-auto"></div>
					<ul class="navbar-nav">
						<li class="nav-item"><a class="nav-link" href="./index.jsp">HOME
								<span class="sr-only">(current)</span>
						</a></li>
						<li class="nav-item"><a class="nav-link" href="./gallery.jsp">GALLERY</a>
						</li>
						<li class="nav-item"><a class="nav-link" href="./about.jsp">ABOUT US</a>
						</li>
						<li class="nav-item"><a class="nav-link" href="./contact.jsp">CONTACT US</a>
						</li>
					</ul>
				</div>
			</nav>
		</div>
	</header>
	<!-- End header -->
	<!-- Start content section -->
	<div id="logout">
		<a class="logout" href="./">LOG OUT</a>
	</div>
	<div class="middle">
		<div class="img-container">
			<img src="./assests/images/sup-profile-img.png" alt="register-img">
		</div>
		<div class="form-container">
			<h1 class="title">WELCOME <span style="font-size: 1rem;">  SUPPLIER</span></h1>
			<% 
				String username = (String)request.getAttribute("username");
				
				ISupplierService supService = new SupplierServiceImpl();
				Supplier supplier = supService.showSupplierDetails(username);
			%>
			<div class="reg-form">
				<br> 
				<span>User Name</span> <span id="profileRes" style="color: black"><%=username%></span><br><br>
				<span>Email</span> <span id="profileRes" style="margin-left: 3.55rem; color: black"><%=supplier.getEmail()%></span><br><br> 
				<span>Gender</span> <span id="profileRes" style="margin-left: 2.38rem; color: black"><%=supplier.getGender()%></span><br><br> 
				<span>Mobile</span> <span id="profileRes" style="margin-left: 2.9rem; color: black"><%=supplier.getMobileNo()%></span><br><br> 
				<span>Province</span> <span id="profileRes" style="margin-left: 1.7rem; color: black"><%=supplier.getProvince()%></span><br><br> 
				<span>Services</span> <span id="profileRes" style="margin-left: 2rem; color: black"><%=supplier.getService()%></span><br><br>
				
				<form action="DeleteSupplierServlet" method="POST">
					<a id="up-btn" href='./editSupplier.jsp?username=<%=username%>'>UPDATE DETAILS</a>
					<input type="hidden" name="username" value="<%=username%>">
					<input type="submit" id="del-btn" name="del-btn" value="DELETE ACCOUNT"> 
					<a id="event-btn" href="./saller.jsp">ADD A SERVICE</a>
				</form> 
			</div>
		</div>
	</div>
	<!-- End content section -->
</body>
</html>