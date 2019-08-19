<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>${cat.name}</h1>
products:
<ul>
	<c:forEach var="product" items="${catProds}">
		<li>${product.name}</li>
	</c:forEach>
</ul>
<form action="/categories/${cat.id}" method="post">
	<select name="name">
		<c:forEach var="product" items="${products}">
			<option>${product.name}</option>
		</c:forEach>
	</select>
	<button type="submit">add</button>
</form>
</body>
</html>