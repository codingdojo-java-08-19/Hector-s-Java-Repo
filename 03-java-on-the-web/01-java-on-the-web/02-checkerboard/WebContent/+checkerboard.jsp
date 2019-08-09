<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="Style.css">
<title>CHECKERBOARD</title>
</head>
<body>


<% 
String heightString = request.getParameter("height");
String widthString = request.getParameter("width");
Integer height = 0 ;
Integer width = 0 ;
Integer color = 0;
%>
<% if ( heightString != null ) {%>
<% height = Integer.parseInt(heightString); %>
<% } %>

<%if (widthString != null){ %>
<% width = Integer.parseInt(widthString); %>
<% } %>

<% for(int row = 0; row < height; row++ ) { %>
	<%if(width%2 == 0) {%>
	<% color ++; %>
	<% } %>
	<div>
		<%for (int colmn = 0; colmn < width; colmn++){ %>
			<% if (color%2 == 0) {%>
				<div class='pink'></div>
				<% color ++;%>
			<% }else{ %>
				<div class='aqua'></div>
				<% color ++;%>
			<% } %>
		<% } %>
	</div>
<% } %>
</body>
</html>