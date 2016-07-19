<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mobile Store</title>
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<link href="resources/css/style.css" rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body
	style="height: 100%; background-repeat: no-repeat; background-image: linear-gradient(rgb(104, 145, 162), rgb(12, 97, 33));">

	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a href="" class="navbar-brand"><img
					src="resources/images/logo.jpg" style="width: 300px; height: 50px;"></a>

				<div class="col-md-2 col-sm-6 col-xs-7 navbar-right">
					<div class="navbar-form" role="search">
						<div class="input-group">
							<input type="text" placeholder="Search" class="" name="srch-term">
							<div class="input-group-btn">
								<button class="btn btn-default" value="Search" type="submit">
									<i class="glyphicon glyphicon-search"></i>
								</button>


							</div>
						</div>
					</div>
				</div>
			</div>
			<br> <br>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="index.jsp">Home</a></li>
					<li><a href="about.jsp">About Us</a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Brands <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="samsung.jsp">Samsung</a></li>
							<li><a href="apple.jsp">Apple</a></li>
							<li><a href="htc.jsp">HTC</a></li>
							<li><a href="sony.jsp">Sony</a></li>
							
						</ul></li>
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
			<h2>Register</h2>
			<form:form action="${pageContext.request.contextPath}/registerUser" method="POST" 
			commandName="register_user" role="form">
				First Name<input type="text"  class="form-control"
					placeholder="First Name" name="firstname" value="" required autofocus> 
					
					Last Name<input type="text"  class="form-control"
					placeholder="Last Name" name="lastname" value="" required autofocus> 
					
					Contact no<input type="text"  class="form-control"
					placeholder="Contact No" name="contactNo" value="" required autofocus> 
					
					Email Id<input type="text"  class="form-control"
					placeholder="Email Id" value="" name="emailId" required autofocus> 
					
					Username<input type="text"  class="form-control"
					placeholder="User Name" value="" name="username" required autofocus> 
					
					Password<input type="password"  class="form-control"
					placeholder="Password" value="" name="password" required autofocus> 
					
					Address<textarea name="address" class="form-control" rows="5" required></textarea>
					<br>
				   <input class="btn btn-lg btn-primary btn-block" type="submit" value="Register">
			</form:form>

		</div>
	</div>
</body>
</html>