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
	<h1>new license</h1>
	<form:form action="/licenses/new" method="post" modelAttribute="card">
		person:
		<form:errors path="person"/>
		<form:select path="person">
			<c:forEach var="person" items="${persons}">
				<option>${person.firstName}</option>
			</c:forEach>
		</form:select>
		<hr/>
		state:
		<form:errors path="state"/>
		<form:input path="state"/>
		expiration:
		<form:errors path="expirationDate" />
		
		<form:input type="date" path="expirationDate" value="${date}" var="sDate"/>
		<fmt:parseDate value="${sDate}" pattern="yyyy-MM-dd HH:mm:ss" var="date"/>
		<button type="submit">submit</button>
	</form:form>
</body>
</html>