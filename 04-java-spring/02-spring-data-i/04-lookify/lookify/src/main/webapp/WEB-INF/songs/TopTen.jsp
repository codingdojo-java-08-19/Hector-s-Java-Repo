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
<a href="/lookify/dashboard">dashboard</a>
<c:forEach var="i" begin="0" end="10">
	<p><b>${topTen[i].rating}</b></p>
	<a href="/lookify/songs/${topTen[i].id}">
		${topTen[i].title}
	</a>
	<p>${topTen[i].artist }</p>	
</c:forEach>
</body>
</html>