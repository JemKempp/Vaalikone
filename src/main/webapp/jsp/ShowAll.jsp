<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="java.util.ArrayList" %>
<%@ page import="app.model.CheckServlet" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All datatable rows</title>
</head>
<body>

<table>
<tr>
	<th>kysymys_id</th>
	<th>ehdokas_id</th>
	<th>vastaus</th>
</tr>
<c:forEach var="" items="${sessionScope.allkysymykset }">
	<tr>
		<td>${kysymys.id }</td>
		<td>
			<a href="/editkysymys?id=${kysymys.id }">Edit</a>
		</td>
	</tr>
</c:forEach>
</tr>
<c:forEach var="" items="${sessionScope.allehdokkaat }">
	<tr>
		<td>${ehdokas.id }</td>
		<td>
			<a href="/editehdokas?id=${ehdokas.id }">Edit</a>
		</td>
	</tr>
</c:forEach>
</tr>
<c:forEach var="" items="${sessionScope.allvastaukset }">
	<tr>
		<td>${vastaus }</td>
		<td>
			<a href="/editvastaus=${vastaus}">Edit</a>
		</td>
	</tr>
</c:forEach>
</table>

</body>
</html>