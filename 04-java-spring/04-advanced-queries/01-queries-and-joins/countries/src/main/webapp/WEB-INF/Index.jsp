<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>adva Q</title>
</head>
<body>
	<h3>how many cities a country has</h3>
	<ul>
		<c:forEach var="row" items="${countries}">
			<li>country:${ row[0] } , # o' cities${ row[1] }</li>
		</c:forEach>
	</ul>
	
	<h3> big mexican cities</h3>
	<ul>
		<c:forEach var="row" items="${mexiCitz}">
			<li>city name: ${ row[0] } , population: ${ row[1] }</li>
		</c:forEach>
	</ul>
	<h3> who speaks slovene</h3>
	<ul>
		<c:forEach var="row" items="${sloviCities}">
			<li>country: ${ row[0] } , percentage: ${ row[1] }</li>
		</c:forEach>
	</ul>
	<h3> top langs</h3>
	<ul>
		<c:forEach var="row" items="${topLangs}">
			<li>country: ${ row[0] }, language: ${row[1]}, percentage: ${ row[2] }</li>
		</c:forEach>
	</ul>
	<h3> big little countries</h3>
	<ul>
		<c:forEach var="row" items="${bigLil}">
			<li>country: ${ row[0] }, population: ${ row[1] }, surface area: ${row[2]}</li>
		</c:forEach>
	</ul>
	<h3> big Monarchies</h3>
	<ul>
		<c:forEach var="row" items="${bigMons}">
			<li>country: ${ row[0] }, population: ${ row[1] }, surface area: ${row[2]}</li>
		</c:forEach>
	</ul>
	<h3> what's up Buenos Aires!?</h3>
	<ul>
		<c:forEach var="row" items="${buenosAires}">
			<li>country: ${ row[0] }, city: ${ row[1] }, district: ${row[2]}, population: ${row[3]}</li>
		</c:forEach>
	</ul>
	<h3> how many countries per region? this many </h3>
	<ul>
		<c:forEach var="row" items="${countryZ}">
			<li>region: ${ row[0] }, countries: ${ row[1] }</li>
		</c:forEach>
	</ul>
</body>
</html>