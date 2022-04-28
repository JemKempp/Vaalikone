<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="app.model.Candidates" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Candidate</title>
 <link rel="stylesheet" type="text/css" href="../css/jsp.css">
</head>
<style>
body {
background-image: url('https://static.scientificamerican.com/sciam/cache/file/2A451F1D-3FC5-4438-A1DFB859DF8D3AEB_source.jpg?w=590&h=800&4F353870-AA79-41FA-AFBAAEF4F774E4A0');
        background-repeat: no-repeat;
        background-size: cover;
		text-align: center;
}
</style>
<body>
<h2>Haluatko varmasti poistaa ehdokkaan?</h2>
    <form action='./deletecandidates' method='post'>
        <input type="hidden" name="ehdokas_id" value="${sessionScope.candidate.ehdokas_id }">
        <input type='submit' name='ok' value='Poista'>
    </form>
<a href='./showcandidates' class="loginbutton">Takaisin</a>