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
	<link rel="stylesheet" href="./assests/css/gallery.css">
	<link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;500;700&display=swap" rel="stylesheet">
	<title>Planning Pros | Gallery</title>
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
						<li class="nav-item"><a class="nav-link active" href="./gallery.jsp">GALLERY</a>
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
	  <div class="title-container">
         <h1 class="title">FEW OF OUR EVENTS</h1>
      </div>
      <div class="img-container">
         <img src="./assests/images/gallery-img.png" alt="gallery-img">
      </div>
      <div class="slidershow slidermiddle">
         <div class="slides">
            <input type="radio" name="r" id="r1" checked>
            <input type="radio" name="r" id="r2">
            <input type="radio" name="r" id="r3">
            <input type="radio" name="r" id="r4">
            <input type="radio" name="r" id="r5">
            <div class="slide s1">
               <img src="./assests/images/slide-1.png" alt="slide1">
            </div>
            <div class="slide">
               <img src="./assests/images/slide-2.png" alt="slide2">
            </div>
            <div class="slide">
               <img src="./assests/images/slide-3.png" alt="slide3">
            </div>
            <div class="slide">
               <img src="./assests/images/slide-4.png" alt="slide4">
            </div>
            <div class="slide">
               <img src="./assests/images/slide-5.png" alt="slide5">
            </div>
         </div>
         <div class="navigation">
            <label for="r1" class="bar"></label>
            <label for="r2" class="bar"></label>
            <label for="r3" class="bar"></label>
            <label for="r4" class="bar"></label>
            <label for="r5" class="bar"></label>
         </div>
      </div>
   </div>
	<!-- End content section -->
</body>
</html>