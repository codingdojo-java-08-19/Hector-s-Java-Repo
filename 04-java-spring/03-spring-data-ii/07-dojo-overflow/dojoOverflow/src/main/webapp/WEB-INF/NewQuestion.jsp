<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>wat's ur ?</h1>
	<form:form action="/questions" method="post" modelAttribute="theQuestion">
		question:
		<form:input path="question"/>
		<form:errors path="question"/>
		
		tags:
		<form:errors path="answers"/>
		<form:errors path="tags"/>
		<input type="text" name="stags">
		
		<button type="submit">submit</button>
	</form:form>
</body>
</html>