<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<a href="/languages">dashboard</a>
	
	<h1>${language.name}</h1>
	<p>${language.creator }</p>
	<p>${language.version }</p>
	
	<a href="/languages/${language.id}/edit">edit</a>
</body>
</html>