<!-- K.A.T. Thiwanka -->
<!-- IT19076362 -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" href="./assests/css/bootstrap.min.css"> <!-- For navigation bar -->
	<link rel="stylesheet" href="./assests/css/main.css">
	<link rel="stylesheet" href="./assests/css/register.css">
	<link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;500;700&display=swap" rel="stylesheet">
	<title>Planning Pros | Register</title>
</head>
<body>
	<!-- Start header -->
	<header>
		<div class="navbar">
			<nav class="navbar navbar-expand-lg navbar-light">
				<a class="navbar-brand" href="./">Planning Pros</a>
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
	   <div class="middle">
      <div class="img-container">
         <img src="./assests/images/register-img.png" alt="register-img">
      </div>
      <div class="form-container">
         <h1 class="title">REGISTER <span style="font-size: 1rem;">  AS SUPPLIER</span></h1>
         <form method="POST" action="AddSupplierServlet" class="reg-form">
            <input class="input name" type="text" name="username" placeholder="Username" maxlength="25" required>
            <br>
            <input class="input password" type="password" name="password" placeholder="Password" maxlength="25" required>
            <br>
            <input class="input email" type="email" name="email" placeholder="Email" maxlength="50" required>
            <br>
            <span>Gender</span>
            <input type="radio" name="gender" id="male" value="M" required>
            <span>Male</span>
            <input type="radio" name="gender" id="female" value="F" required>
            <span>Female</span>
            <br>
            <input class="input mobile" type="text" name="mobile" placeholder="Mobile Number" maxlength="10" required>
            <br>
            <input class="input province" type="text" name="province" placeholder="Province" maxlength="25" required>
            <br>
            <input class="input service" type="text" name="service" placeholder="Suppling Services ?" maxlength="50" required>
            <br>
            <input type="submit" name="register" id="reg-btn" value="REGISTER">
         </form>
      </div>
   </div>
	<!-- End content section -->
</body>
</html>