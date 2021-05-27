<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Product Details</title>
</head>
<a href="/">Home</a>
<body>
	<h1>Update Product Details</h1>
	<form:form action="/updateProduct" method="post">
		Product ID : <input type="text" name="productId" value="${product.productId}" readonly="readonly"/>
		<br>
		Product Name : <input type="text" name="productName" value="${product.productName}" />
		<br>
		Quantity On Hand : <input type="text" name=quantityOnHand value="${product.quantityOnHand}" />
		<br>
		Price  : <input type="text" name="price" value="${product.price}"/>
		<br>
		<input type="submit" value="Update" />



	</form:form>

	<br>
	<br>


</body>
</html>