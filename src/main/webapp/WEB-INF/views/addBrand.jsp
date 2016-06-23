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
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<link href="resources/css/style.css" rel="stylesheet">

<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<style>
.error {
	color: red;
}

.tg th {
	font-family: Arial, sans-serif;
	font-size: 14px;
	font-weight: normal;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	background-color: #f0f0f0;
}
</style>
</head>
<body>

	<div class="Container" style="padding-top: 10px;">
		<div class="row">
			<div class="col-md-offset-2 col-md-8" align="center">
				<div class="panel panel-default">
					<div class="panel-body">
						<input type="text" name="search">
						<button class="btn">Search Brand</button>
						<br>
						<br>
						<form:form action="${pageContext.request.contextPath}/savebrand"
							method="post" commandName="save_brand" role="form">

								<form:label path="brand_name">
											<spring:message text="Brand Name " />
										</form:label>
									<form:input path="brand_name" />
									<input type="submit"
										value="<spring:message text="Add"/>" /><br> <form:errors
											path="brand_name" cssClass="error"></form:errors>
											
								
								
							<!-- <table align="center">
								<tr>
									<td><form:label path="brand_name">
											<spring:message text="Brand Name " />
										</form:label></td>
									<td><form:input path="brand_name" /><br> <form:errors
											path="brand_name" cssClass="error"></form:errors></td>
								</tr>
								<tr>
									<td colspan="4"><input type="submit"
										value="<spring:message text="Add"/>" /></td>
								</tr>
							</table>-->

						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<br>
	<table class="table table-bordered" style="width: 66%;" align="center">
		<tr style="background-color: #BDC3C7;">
			<th>Brand Id</th>
			<th>Brand Name</th>
			<th>Operation</th>
			<th>Operation</th>
		</tr>
		<c:forEach items="${brands}" var="brnds1">
			<tr>
				<td>${brnds1.brand_id}</td>
				<td>${brnds1.brand_name}</td>
				<td><a href="/editBrand?id=${brnds1.brand_id}">Edit Brand</a>
				<td><a href="/delBrand?id=${brnds1.brand_id}">Delete Brand</a>
			</tr>

		</c:forEach>
	</table>

</body>
</html>