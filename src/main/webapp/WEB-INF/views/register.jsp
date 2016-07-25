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
					src="resources/images/logo.jpg" style="width: 200px; height: 30px;"></a>

				
			</div>
			
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="${pageContext.request.contextPath}/">Home</a></li>
					<li><a href="about">About Us</a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Brands <span class="caret"></span></a> <!--<ul class="dropdown-menu">
								<c:forEach items="${brandsLst1}" var="id">
									<li>${id.brand_name}</li>
								</c:forEach>--> <!-- <li><a href="htc.jsp">HTC</a></li>
							</ul>--> <!-- For display product sub menu -->

						<ul class="dropdown-menu multi-level" role="menu">
							<c:forEach items="${brandsLst1}" var="id">
								<li class="dropdown-submenu"><a href="#">${id.brand_name}</a>
									<ul class="dropdown-menu">
										<c:forEach items="${prdLst}" var="prd">
											<c:if test="${id.brand_id==prd.brand_id}">
												<li><a href="productDetail/${prd.product_id }">${prd.product_name}</a></li>
											</c:if>
										</c:forEach>
									</ul></li>
							</c:forEach>
						</ul></li>
					
					<li><a href="contact">Contact Us</a></li>
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
	<footer class="container-fluid bg-4 text-center">
  <p>@2016 Copyright</p> 
</footer>
</body>
</html>