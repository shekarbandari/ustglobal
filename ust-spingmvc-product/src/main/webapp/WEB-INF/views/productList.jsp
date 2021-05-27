<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product List</title>
</head>
<body>

	<br>
	<h1>
		Welcome <font color="red">${username} </font> to Product Details
	</h1>
	<a href="/logout">Logout</a>&nbsp; &nbsp; &nbsp;<a href="/product">ADD</a>&nbsp; &nbsp; &nbsp;
	<a href="/cartList">Cart</a>

	<h1>Product List</h1>
	<form:form action="/cartList" modelAttribute="command">
		<table border="2" width="70%" cellpadding="2">
			<tr>
				<th></th>
				<th>Product ID</th>
				<th>Product Name</th>
				<th>Quantity On Hand</th>
				<th>Price</th>
			</tr>
			<c:forEach var="prod" items="${products}">
				<tr>

					<td><form:checkbox path="productId" value="${prod.productId }" /></td>
					<td>${prod.productId }</td>
					
					<td>${prod.productName }</td>
					
					<td>${prod.quantityOnHand }</td>
					<!-- <td>${prod.quantityOnHand }</td>-->
					<td>${prod.price }</td>
					<!-- <td>${prod.price }</td>-->
					<td><a href="/editProduct/${prod.productId}">Update</a></td>
					<td><a href="/deleteProduct/${prod.productId}">Delete</a></td>
				</tr>

			</c:forEach>
			
		</table><br>
<input type="submit" />
	</form:form>
	
</body>
</html>