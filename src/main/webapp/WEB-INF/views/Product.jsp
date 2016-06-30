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

</head>
<body>
	<h1>Add Product</h1>
	<br>
	<form:form method="post" action="${pageContext.request.contextPath}/saveproduct" enctype="multipart/form-data" modelAttribute=""
		commandName="save_product">
		<table align="center">
			<tr>
				<td>Product Model</td>
				<td><input type="text" name="prod_model" /></td>
			</tr>
			<tr>
				<td>Product Name</td>
				<td><input type="text" name="prod_name" /></td>
			</tr>
			<tr>
				<td>Product Brand</td>
				<td><select name="item">
						<c:forEach items="${brands}" var="id">
    					<option value="${id.brand_id}">${id.brand_name}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>Product Description1</td>
				<td><textarea name="prod_desc1"></textarea></td>
			</tr>
			<tr>
				<td>Product Description2</td>
				<td><textarea name="prod_desc2"></textarea></td>
			</tr>
			<tr>
				<td>Product Price</td>
				<td><input type="text" name="prod_price" /></td>
			</tr>
			<tr>
				<td>Product Discount</td>
				<td><input type="text" name="prod_discount" /></td>
			</tr>
			<tr>
				<td>Product Supplier</td>
				<td><select name="item">
						<c:forEach items="${supplier}" var="id">
    					<option value="${id.supp_id}">${id.supp_name}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>Product Image</td>
				<td><input type="file" name="prod_file" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Add" /></td>
			</tr>
		</table>

	</form:form>

</body>
</html>