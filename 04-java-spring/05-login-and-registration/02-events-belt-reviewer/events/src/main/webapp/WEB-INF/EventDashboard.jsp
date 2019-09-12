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
	<a href="/logout">logout</a>
	local events:
	<table>
		<tr>
			<th>name</th>
			<th>date</th>
			<th>location</th>
			<th>host</th>
			<th>actions status</th>
		</tr>
		<c:forEach var="event" items="${localEvents}">
		<tr>
			<td>
				<a href="/events/${event.id}">
					${event.name}
				</a>		
			</td>
			<fmt:formatDate value="${ event.date }" pattern="MM-dd-yyyy" var="localFormated"/>
			<td>${localFormated}</td>
			<td>${event.city}, ${ event.state.name }</td>
			<td>${event.host.first_name}</td>
			<td>
				<c:if test="${event.host == user }" var="hosting">
					<form:form action="/events/${ event.id }">
						<input type="hidden" name="_method" value="delete">
						<button type="submit">delete</button>
					</form:form>
					<a href="/events/${ event.id }/edit"><button>edit</button></a>
				</c:if>
				<c:if test= "${ !event.attendees.contains(user) && !hosting}">
					<form action="/events/${ event.id }">
						<input type="hidden" name="_method" value="put">
						<button type="submit">attend</button>
					</form>
				</c:if>
			</td>
		</tr>
		</c:forEach>
	</table>
	out of state:
	<table>
		<tr>
			<th>name</th>
			<th>date</th>
			<th>location</th>
			<th>host</th>
			<th>actions status</th>
		</tr>
		<c:forEach var="event" items="${events}">
		<tr>
			<td>
				<a href="/events/${event.id}">
					${event.name}
				</a>
			</td>
			<fmt:formatDate value="${ event.date }" pattern="MM-dd-yyyy" var="formated"/>
			<td>${formated}</td>
			<td>${event.city}, ${ event.state.name }</td>
			<td>${event.host.first_name}</td>
			<td>
				<c:if test="${event.host == user }" var="hosting">
					<form:form action="/events/${ event.id }">
						<input type="hidden" name="_method" value="delete">
						<button type="submit">delete</button>
					</form:form>
					<a href="/events/${ event.id }/edit"><button>edit</button></a>
				</c:if>
				<c:if test= "${ !event.attendees.contains(user) && !hosting}">
					<form action="/events/${ event.id }" method="post">
						<input type="hidden" name="_method" value="put">
						<button type="submit">attend</button>
					</form>
				</c:if>
			</td>
		</tr>
		</c:forEach>
	</table>

	<form:form action="/events" method="post" modelAttribute="event">
		<form:hidden path="host" value="${userId}"/>
		<h3>new event</h3>
		
		name:
		<form:input path="name"/>
		<form:errors path="name"/>
		
		date:
		<form:input type="date" path="date"/>
		<form:errors path="date"/>
		
		city:
		<form:input path="city"/>
		<form:errors path="city"/>
		
		state:
		<form:select path="state">
			<form:options items="${states}" itemLabel="name" itemValue="id"/>
		</form:select>
		
		<button type="submit">submit</button>
	</form:form>
</body>
</html>