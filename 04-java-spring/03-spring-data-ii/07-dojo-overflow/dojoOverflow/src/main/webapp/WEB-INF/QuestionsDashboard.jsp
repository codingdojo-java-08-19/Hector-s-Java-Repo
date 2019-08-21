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
	<h1>question dashboard</h1>
	<table>
		<thead>
			<tr>
				<th>
				question
				</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="question" items="${questions}">
				<tr>
					<td>
						<a href="questions/${question.id}">
							${question.question}
						</a>
					</td>
					<td>
						<c:forEach var="tag" items="${question.tags}">
							${tag.subject},
						</c:forEach>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="/questions/new">new question</a>
</body>
</html>