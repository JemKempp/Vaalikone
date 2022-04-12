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
<style>
body {
background-image: url('https://static.scientificamerican.com/sciam/cache/file/2A451F1D-3FC5-4438-A1DFB859DF8D3AEB_source.jpg?w=590&h=800&4F353870-AA79-41FA-AFBAAEF4F774E4A0');
        background-repeat: no-repeat;
        background-size: cover;
		text-align: center;
		color: white;
}
</style>

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
            <a href="/editcandidate?id=${candidates.ehdokas_id }">Muokkaa</a>
            <a href="/DeleteCandidates?id=${candidates.ehdokas_id }">Poista</a>
    <td>
           
            
        </td>
    </li>



</c:forEach>
</table>


</body>
</html>
