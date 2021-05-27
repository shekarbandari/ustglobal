

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<a href="/">Home</a>
<body>
	<h1>Welcome to Product Home Page</h1>
	<form:form action="searchProductById" >
		Product ID: <form:input  path="productId" /><br>
		Product Name : <form:input path="productName" /><br>
		Quantity On Hand : <form:input path="quantityOnHand" /><br>
		Price : <form:input path="price" /><br> 
		<input
			type="submit" value="Fetch" />
			<input
			type="submit" formaction="searchProductByIdForm" value="reset" />
			<input type="submit" formaction="deleteProductById"
			value="delete by id" />



	</form:form>
	<font color="red">${message}</font>
	

	<br>
	<br>
	

</body>
</html>