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
	<nav>
		<a href="/lookify/songs/new">add a new song</a>
		<a href="/lookify/search/topten">Top Songs</a>
		
		<form action="/lookify/search" method=post>
			<input type="text" name="artist" placeholder="${error}">
			<button type="submit">search</button>
		</form>
	</nav>
	
	<table>
		<thead>
			<tr>
				<th>song</th>
				<th>rating</th>
				<th>actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="song" items="${songs}">
			<tr>
				<td>
					<a href="/lookify/songs/${song.id}">
						${song.title }
					</a>
				</td>
				<td>
					${song.rating }
				</td>
				<td>
					<form action="/lookify/songs/${song.id}" method="post">
						<input type="hidden" name= "_method" value="delete">
						<button type="submit">delete</button>
					</form>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>