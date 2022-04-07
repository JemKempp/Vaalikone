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

<c:forEach var="candidates" items="${sessionScope.allcandidates }">

    <li>
    
    <ol>Ehdokkaan numero: ${candidates.ehdokas_id }</ol>
    <ol>Sukunimi: ${candidates.sukunimi } </ol>
    <ol>Etunimi: ${candidates.etunimi }</ol>
    <ol>Puolue: ${candidates.puolue }</ol>
    <ol>Kotipaikkakunta: ${candidates.kotipaikkakunta }</ol>
    <ol>Ikä: ${candidates.ika }</ol>
    <ol>Miksi eduskuntaan: ${candidates.miksi_eduskuntaan }</ol>
    <ol>Mitä asioita haluat edistää: ${candidates.mita_asioita_haluat_edistaa }</ol>
    <ol>Ammatti: ${candidates.ammatti }</ol>
    
    <td>
			<a href="/editcandidate?id=${ehdokas.id }">Edit</a>
		</td>
    </li>
    
		

</c:forEach>
</table>



</body>
</html>