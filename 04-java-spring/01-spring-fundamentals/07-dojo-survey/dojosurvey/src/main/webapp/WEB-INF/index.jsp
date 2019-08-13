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
	<form action="/result" method="POST">
		name: <br>
		<input type="text" name='name'>
		location: <br>
		<select name="location">
			<option>here</option>
			<option>there</option>
			<option>everywhere</option>
		</select>
		favorite language: <br>
		<select name="favLang">
			<option>JAVA</option>
			<option>PYTHON</option>
			<option>JAVASCRIPT</option>
		</select>
		comments: <br>
		<textarea rows="10" cols="30" name="comment"></textarea>
		<button type="submit">submit</button>
	</form>
</body>
</html>