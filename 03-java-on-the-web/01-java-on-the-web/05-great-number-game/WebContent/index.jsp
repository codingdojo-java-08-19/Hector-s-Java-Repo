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
	<c:if test="${tooHigh}">
		<h1>TOO HIGH</h1>
	</c:if>
	<c:if test="${tooLow}">
		<h1>TOO LOW</h1>
	</c:if>
	<c:if test="${correct}">
		<h1>CORRECT</h1>
	</c:if>		
	<c:if test="${!tooHigh && !tooLow}">
		<h3>I AM THINKING OF A NUMBER BETWEEN 1 AND 100</h3>
	</c:if>
	<form action="/GreatNumberGame/Game" method="post">
	guess: <input type="number" name="guess">
	<button type="submit">SUBMIT</button>
	</form>
</body>
</html>