<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<link href="resources/css/style.css" rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	
</head>
<body style=" height: 100%;
    background-repeat: no-repeat;
    background-image: linear-gradient(rgb(104, 145, 162), rgb(12, 97, 33));">
    
	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="icon-bar"></span> 
					<span class="icon-bar"></span>
					 <span class="icon-bar"></span>
				</button>
				<a href="" class="navbar-brand"><img src="resources/images/logo.jpg" style="width: 300px; height: 50px;"></a>
						
				<div class="col-md-2 col-sm-6 col-xs-7 navbar-right">
					<div class="navbar-form" role="search">
						<div class="input-group">
							<input type="text" placeholder="Search" class="" name="srch-term" >
							<div class="input-group-btn">
								<button class="btn btn-default" value="Search" type="submit">
								<i class="glyphicon glyphicon-search"></i></button>
							</div>
						</div>
					</div>
				</div>
			</div>
			<br>
			<br>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="index">Home</a></li>
					<li><a href="about.jsp">About Us</a></li>
					<!-- <li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Product <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="android.jsp">Android</a></li>
							<li><a href="ios.jsp">IOS</a></li>
							<li><a href="windows.jsp">Windows</a></li>
						</ul></li>-->
						<li><a href="about.jsp">Brand</a></li>
					<li><a href="service.jsp">Services</a></li>
					<li><a href="contact.jsp">Contact Us</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="login">Login</a></li>
					<li><a href="register">Register</a></li>
				</ul>
			</div>
		</div>
	</div>
<div class="container">
		<div class="card card-container">
			<h2>Login</h2>
			<form class="form-signin" action="login" method="post">
				User ID <input type="text"  class="form-control"
					placeholder="User Id" required autofocus> Password<input
					type="password"  class="form-control"
					placeholder="Password" required>

				<button class="btn btn-lg btn-primary btn-block btn-signin"
					type="submit">Sign in</button>
			</form>

		</div>
	</div>
	
	
</body>
</html>