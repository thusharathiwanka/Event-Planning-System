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
	<title>Planning Pros | Login</title>
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
         <img src="./assests/images/sup-login-img.png" alt="register-img" style="margin-left: -8rem;">
      </div>
      <div class="form-container" style="margin-top: 10rem; margin-left: 15rem;">
         <h1 class="title">LOGIN <span style="font-size: 1rem;"> SUPPLIER</span></h1>
         <form method="POST" action="LoginSupplierServlet" class="reg-form">
            <input class="input name" type="text" name="username" placeholder="Username" maxlength="25" required>
            <br>
            <input class="input password" type="password" name="password" placeholder="Password" maxlength="25" required>
            <br>
            <input type="submit" name="register" id="reg-btn" value="LOGIN">
         </form>
      </div>
   </div>
	<!-- End content section -->
</body>
</html>