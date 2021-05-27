<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
	
	<h1>Welcome <font color="red" >${username} </font>  to Add Product Details </h1>
	<a href="/logout">Logout</a>&nbsp; &nbsp; &nbsp;<a href="/">Home</a> <br><br>
	<form:form action="saveProduct" modelAttribute="command">
		Product ID: <form:input path="productId" />
		<br>
		<font color="red"><form:errors path="productId" cssClass="error"/></font><br>
		Product Name : <form:input path="productName" />
		<br>
		<font color="red"><form:errors path="productName" cssClass="error"/></font><br>
		Quantity On Hand : <form:input path="quantityOnHand" />
		<br>
		<font color="red"><form:errors path="quantityOnHand" cssClass="error"/></font><br>
		Price : <form:input path="price" />
		<br>
		<font color="red"><form:errors path="price" cssClass="error"/></font><br><br>
		<input type="submit" value="Add Product" />
		
		


	</form:form>
	<br>
	



	<br>
	<br><font color="red">${alreadyExistProduct}</font>


</body>
</html>