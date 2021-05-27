<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js"
	integrity="sha384-SR1sx49pcuLnqZUnnPwx6FCym0wLsk5JZuNx2bPPENzswTNFaQU1RDvt3wT4gWFG"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.min.js"
	integrity="sha384-j0CNLUeiqtyaRmlzUHCPZ+Gy5fQu0dQ6eZ/xAww941Ai1SxSY+0EQqNXNE6DZiVc"
	crossorigin="anonymous"></script>

<title>registration form</title>
</head>
<body>

	<form:form method="post" action="/register" modelAttribute="user">

		<h3>Registration Form</h3>

		<div class="form-group">
			<span>User Name :</span>
			<form:input path="username" />
			<font color="red"><form:errors path="username" /></font><br> <span>New
				Password :</span>
			<form:password path="password" />
			<font color="red"><form:errors path="password" /></font><br> <span>Confirm
				Password :</span>
			<form:password path="confirmPassword" />
			<font color="red"><form:errors path="confirmPassword" /></font><br>


			<span>ADMIN :</span>
			<form:radiobutton path="role" value="ADMIN" />
			<span>USER :</span>
			<form:radiobutton path="role" value="USER" />
			<font color="red"><form:errors path="role" /></font><br> <br>
			<br>
			<button class="btn btn-primary" type="submit">Register</button>

		</div>

	</form:form>
	<font color="red">${errorMsg}</font>
	<font color="red">${failedRegistrationMessage}</font>

	<font color="green">${logoutMsg}</font>


</body>
</html>