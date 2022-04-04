<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="java.util.ArrayList" %>
<%@ page import="app.model.Candidates" %>
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

<c:forEach var="ehdokas" items="${sessionScope.allcandidates }">
	<tr>
		<td>${ehdokas.ehdokas_id }</td>
		<td>
			<a href="/editehdokas?id=${ehdokas.ehdokas_id }">Edit</a>
			
<h1>Ehdokkaan profiili</h1>
<h2>${requestScope.ehdokkaat.etunimi} ${requestScope.ehdokkaat.sukunimi}</h2>
<p><b>Puolue:</b> ${requestScope.ehdokkaat.puolue}</p><br>
<p><b>Kotipaikkakunta:</b> ${requestScope.ehdokkaat.kotipaikkakunta}</p><br>
<p><b>Ikä:</b> ${requestScope.ehdokkaat.ika} </p><br>
<p><b>Ammatti:</b> ${requestScope.ehdokkaat.ammatti}</p><br>
<p><b>Miksi haluan eduskuntaan?:</b> ${requestScope.ehdokkaat.miksi_eduskuntaan}</p><br>
<p><b>Mitä asioita haluan edistää?:</b> ${requestScope.ehdokkaat.mita_asioita_haluat_edistaa}</p><br>
		</td>
	</tr>
</c:forEach>

</table>

</body>
</html>