<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>
		Welcome <font color="red">${username} </font> to Cart Details
	</h1>

	<a href="/productList">Home</a>&nbsp; &nbsp; &nbsp;
<a href="/logout">Logout</a>

<h1>Cart List</h1>

	<form:form action="/cartList" modelAttribute="command">
		<table border="2" width="70%" cellpadding="2">
			<tr>
				
				<th>Product ID</th>
				<th>Product Name</th>
				<th>Quantity On Hand</th>
				<th>Price</th>
			</tr>
			<c:forEach var="cart" items="${cartList}">
				<tr>

					
					<td>${cart.productId }</td>

					<td>${cart.productName }</td>

					<td>${cart.quantityOnHand }</td>

					<td>${cart.price }</td>

					
					<td><a href="/deleteCart/${cart.productId}" >Delete</a></td>
					
				</tr>

			</c:forEach>

		</table>
		<br>
		<input type="submit" />
	</form:form>

</body>
</html>