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
	<h1>Add Supplier</h1>
	<br>
	<form:form action="${pageContext.request.contextPath}/saveSupplier"
		method="post" commandName="save_supplier" role="form">
		<div class="form-group">
			<table align="center">
				<tr>

					<td>Supplier Name</td>
					<td><input type="hidden" name="supp_id"
						value="${supplierDetail.getSupp_id()}" /> <input type="text"
						name="supp_name" value="${supplierDetail.getSupp_name()}" /></td>
				</tr>
				<tr>
					<td>Supplier Address</td>
					<td><textarea name="supp_address">${supplierDetail.getSupp_address()}</textarea></td>
				</tr>
				<tr>
					<td>Supplier City</td>
					<td><input type="text" name="supp_city"
						value="${supplierDetail.getSupp_city()}" /></td>
				</tr>
				<tr>
					<td>Supplier Contact No.1</td>
					<td><input type="text" name="supp_contact1"
						value="${supplierDetail.getSupp_contact1()}" /></td>
				</tr>
				<tr>
					<td>Supplier Contact No.2</td>
					<td><input type="text" name="supp_contact2"
						value="${supplierDetail.getSupp_contact2()}" /></td>
				</tr>
				<tr>
					<td>Supplier Email</td>
					<td><input type="text" name="supp_email"
						value="${supplierDetail.getSupp_email()}" /></td>
				</tr>
				<tr>
					<td colspan="2"><c:if
							test="${!empty supplierDetail.getSupp_name()}">
							<input type="submit" value="Edit" />
						</c:if> <c:if test="${empty supplierDetail.getSupp_name()}">
							<input type="submit" value="Add" />
						</c:if></td>
				</tr>
			</table>
		</div>
	</form:form>
	<br>
	<c:if test="${empty supplierDetail.getSupp_name()}">
		<table class="table table-bordered" style="width: 66%;" align="center">
			<tr style="background-color: #BDC3C7;">
				<th>Supplier Id</th>
				<th>Supplier Name</th>
				<th>Supplier Address</th>
				<th>Supplier City</th>
				<th>Supplier Contact No.1</th>
				<th>Supplier Contact No.1</th>
				<th>Supplier Email Id</th>
				<th>Operation</th>
				<th>Operation</th>
			</tr>
			<c:forEach items="${suppliersList}" var="supp">
				<tr>
					<td>${supp.supp_id}</td>
					<td>${supp.supp_name}</td>
					<td>${supp.supp_address}</td>
					<td>${supp.supp_city}</td>
					<td>${supp.supp_contact1}</td>
					<td>${supp.supp_contact2}</td>
					<td>${supp.supp_email}</td>
					<td><a href="<c:url value='/editSupplier/${supp.supp_id}' />">Edit</a></td>
					<td><a href="<c:url value='/delSupplier/${supp.supp_id}' />">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>