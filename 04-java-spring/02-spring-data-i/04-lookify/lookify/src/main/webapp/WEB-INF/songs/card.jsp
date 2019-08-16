<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<nav>
		<a href="/lookify/dashboard">dashboard</a>
	</nav>
	<h1>${song.title}</h1>
	<p>${song.artist}</p>
	<p>${song.rating}</p>
	
	<form action="/lookify/songs/${song.id}" method="post">
		<input type="hidden" name="_method" value="delete">
		<button type="submit">delete</button>
	</form>
</body>
</html>