<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<style>
.dropdown-submenu {
	position: relative;
}

.dropdown-submenu>.dropdown-menu {
	top: 0;
	left: 100%;
	margin-top: -6px;
	margin-left: -1px;
	-webkit-border-radius: 0 6px 6px 6px;
	-moz-border-radius: 0 6px 6px;
	border-radius: 0 6px 6px 6px;
}

.dropdown-submenu:hover>.dropdown-menu {
	display: block;
}

.dropdown-submenu>a:after {
	display: block;
	content: " ";
	float: right;
	width: 0;
	height: 0;
	border-color: transparent;
	border-style: solid;
	border-width: 5px 0 5px 5px;
	border-left-color: #ccc;
	margin-top: 5px;
	margin-right: -10px;
}

/*.dropdown-submenu:hover>a:after {
    border-left-color: #fff;
}*/

/*.dropdown-submenu.pull-left {
    float: none;
}*/
.dropdown-submenu.pull-left>.dropdown-menu {
	left: -100%;
	margin-left: 10px;
	-webkit-border-radius: 6px 0 6px 6px;
	-moz-border-radius: 6px 0 6px 6px;
	border-radius: 6px 0 6px 6px;
}
</style>
</head>
<body>
	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<!--<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="icon-bar"></span> 
					<span class="icon-bar"></span>
				</button>-->
				<a href="${pageContext.request.contextPath}/" class="navbar-brand"><img
					src="resources/images/logo.jpg" style="width: 200px; height: 30px;"></a>

				<!--<div class="col-md-3 navbar-right">
					<div class="navbar-form" role="search">
						<div class="input-group">
							<input type="text" placeholder="Search" class="" name="srch-term" >
							<div class="input-group-btn">
								<button class="btn btn-default" value="Search" type="submit">
								<i class="glyphicon glyphicon-search"></i></button>
							</div>
						</div>
					</div>
				</div>-->
				<!--<form class="navbar-form pull-right form-search">
					<div class="input-append">
						<input data-provide="typeahead" data-items="4" type="text"
							class="span2 search-query">
						<button class="btn">Search</button>
					</div>
				</form>-->
			</div>


			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a
						href="${pageContext.request.contextPath}/">Home</a></li>
					<li><a href="about">About Us</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Brands <span class="caret"></span></a> <!--<ul class="dropdown-menu">
								<c:forEach items="${brandsLst1}" var="id">
									<li>${id.brand_name}</li>
								</c:forEach>--> <!-- <li><a href="htc.jsp">HTC</a></li>
							</ul>--> 
							
							<!-- For display product sub menu -->

						<ul class="dropdown-menu multi-level" role="menu">
							<c:forEach items="${brandsLst1}" var="id">
								<li class="dropdown-submenu"><a href="#">${id.brand_name}</a>
									<ul class="dropdown-menu">
										<c:forEach items="${prdLst}" var="prd">
											<c:if test="${id.brand_id==prd.brand_id}">
												<li><a href="productDetail?id=${prd.product_id }">${prd.product_name}</a></li>
											</c:if>
										</c:forEach>
									</ul></li>
							</c:forEach>
						</ul></li>
						<li><a href="contact">Contact Us</a></li>
					<c:if test="${pageContext.request.userPrincipal.name != null}">
						
						<c:if test="${pageContext.request.userPrincipal.name  == 'admin'}">
							<li><a href="<c:url value="product" />">Products</a></li>
							<li><a href="<c:url value="supplier" />">Supplier</a></li>
							<li><a href="<c:url value="BrandOpt" />">Show Brands</a></li>
							<li><a href="<c:url value="addBrand" />">Add Brands</a></li>
						</c:if>
						<li><a>Hello, ${pageContext.request.userPrincipal.name} </a></li>
						<li><a href="<c:url value="/logout" />">Sign Out</a></li>
					</c:if>
					<!-- <li><a href="service.jsp">Services</a></li>-->
					
				</ul>

				<ul class="nav navbar-nav navbar-right">
					<c:if test="${pageContext.request.userPrincipal.name  == null}">
						<li><a href="login">User Login</a></li>
						<li><a href="login">Admin Login</a></li>
						<li><a href="register">Register</a></li>
					</c:if>
				</ul>

				<div class="btn-group" >

					<button type="button" data-toggle="dropdown"
						class="btn btn-primary dropdown-toggle">
						View Cart <span class="caret"></span>
					</button>
					<ul class="dropdown-menu">
						<%
											HttpSession us = request.getSession();
												us = request.getSession();
												if(us.getAttribute("total") !=null)
													out.println("<li style='font-weight: bold; font-size: 14px;'><a href='viewCart'>Total :" + us.getAttribute("total") + "</li>");
											%>
					</ul>
				</div>
			</div>
		</div>
	</div>

</body>
</html>