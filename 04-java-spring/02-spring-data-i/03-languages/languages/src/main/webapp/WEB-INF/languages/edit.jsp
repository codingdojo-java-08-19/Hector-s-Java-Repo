<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form:form action="/languages/${language.id}/edit" modelAttribute="language">
		<input type="hidden" name="_method" value="put">		
		name:
		<form:errors path="name"/>
		<form:input path="name"/>
		creator:
		<form:errors path="creator"/>
		<form:input path="creator"/>
		version:
		<form:errors path="version"/>
		<form:input path="version"/>
		
		<button type="submit">submit</button>
	</form:form>
</body>
</html>