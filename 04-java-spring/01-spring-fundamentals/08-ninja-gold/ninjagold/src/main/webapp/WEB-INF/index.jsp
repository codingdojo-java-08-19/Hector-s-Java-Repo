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
	<nav>
		<p>GOLD: ${	gold }</p>
	</nav>
	<form action="/gold" method="POST">
		<h1>FARM</h1>
		<p>find 10 to 40 gold </p>
		<input type="hidden" name="local" value="farm">
		<input type="hidden" name="goldMax" value="40">
		<input type="hidden" name="goldMin" value="10">
		<button type="submit">find gold</button>
	</form>
	<form action="/gold" method="POST">
		<h1>CASINO</h1>
		<p>find or lose up to 50 gold </p>
		<input type="hidden" name="local" value="casino">
		<input type="hidden" name="goldMax" value="50">
		<input type="hidden" name="goldMin" value="-50">
		<button type="submit">find gold</button>
	</form>
	<ul>
		<c:forEach var="activity" items="${ activities }">
		<li>${ activity }</li>
		</c:forEach>
	</ul>
</body>
</html>