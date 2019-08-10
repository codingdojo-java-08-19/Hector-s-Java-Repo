<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>button clicker</h1>
	<p>"the count is "<c:out value="${count}"/></p>
	<a type="button" href="/ButtonClicker/Home">button</a>
</body>
</html>