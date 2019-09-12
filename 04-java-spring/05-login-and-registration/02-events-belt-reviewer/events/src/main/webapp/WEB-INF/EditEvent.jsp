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
	<a href="/events">dashboard</a>
	<h1>${ event.name }</h1>
	<form
	 action="/events/${ event.id }/edit"
	 method="post" 
	 >
		name:
		<input name="name" value="${ event.name }"/>
		date:
		<fmt:formatDate 
		value="${ event.date }"
		pattern="yyyy-MM-dd" 
		var="formated"/>
		<input type="date" name="date" value="${ formated }"/>
		
		city:
		<input name="city" value="${ event.city }"/>
	
		<select name="state">
			<option value="${event.state.name}">${event.state.name }</option>
			<c:forEach var="state" items="${states}">
				<option value="${state.name}">${state.name }</option>
			</c:forEach>
		</select>
		
		<button type="submit">update</button>
	</form>
</body>
</html>