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
	<h1>${question.question}</h1>
	
	answer
	<ul>
		<c:forEach var="answer" items="${answers}">
			<li>${answer.answer}</li>
		</c:forEach>
	</ul>
	
	<h3>add your answer</h3>
	answer:
	<form:form action="/questions/${id}" method="post" modelAttribute="newAnswer">
		<form:input path="answer"/>
		<form:errors path="answer"/>
		
		<button type="submit">answer it</button>
	</form:form>
</body>
</html>