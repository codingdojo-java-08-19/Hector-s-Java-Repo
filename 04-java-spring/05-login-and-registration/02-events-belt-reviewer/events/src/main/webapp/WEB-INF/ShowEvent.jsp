
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
	<h3>${ event.host.first_name } ${ event.host.last_name }</h3>
	<h1>${ event.name }</h1>
	<fmt:formatDate value="${ event.date }" pattern="MM-dd-yyyy" var="formated"/>
	<p>date: ${ formated }</p>
	<p>location: ${ event.city }, ${ event.state.name }</p>
	<p>number of attendees: ${ howMany }</p>
		
	<table>
		<thead>
			<tr>
				<th>
					name
				</th>
				<th>
					location
				</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="attendee" items="${ event.attendees }">
			<tr>
				<td>
				${ attendee.first_name }, ${ attendee.last_name }
				</td>
				<td>
					${ attendee.homeState.name }
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	
	<h2>message board</h2>
	
	<section>
		<c:forEach var="message" items="${ event.messages }">
			<p>
			${ message.sender.first_name } ${ message.sender.last_name }: ${ message.message } 
			</p>
		</c:forEach>
	</section>
	
	<form:form action="/messages/${ event.id }" modelAttribute="newMessage">
	<form:hidden path="sender" value="${ userId }"/>
	<form:hidden path="event" value="${ event.id }"/>
	
	<form:textarea path="message"/>
	<form:errors path="message"/>
	
	<button type="submit">send</button>
	</form:form>
	</body>
</html>