<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>name</th>
				<th>creator</th>
				<th>version</th>
				<th>actions</th>				
			</tr>
		</thead>
		<tbody>
			<c:forEach var="language" items="${languages}">
			<tr>
				<td><a href="/languages/${language.id}">${language.name}</a></td>
				<td>${language.creator}</td>
				<td>${language.version}</td>
				<td>
					<form action="/languages/${language.id}" method="post">
					<input type="hidden" name="_method" value="delete">
					<button type="submit">delete</button>
					<a href="/languages/${language.id}/edit" >edit</a>
					</form>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<form action="/languages" method="POST" modelAttribute="language">
		name:
		<input type="text" name="name">
		creator:
		<input type="text" name="creator">
		version:
		<input type="text" name="version">
		<button type="submit">submit</button>
	</form>
	<!---<form:form action="/languages" method="POST" modelAttribute="language">		
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
	</form:form> --->
</body>
</html>