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
<body>
<h2>Haluatko varmasti poistaa ehdokkaan?</h2>
    <form action='./DeleteCandidates' method='post'>
        <input type="hidden" name="ehdokas_id" value="${sessionScope.candidate.ehdokas_id }">
        <input type='submit' name='ok' value='Poista'>
    </form>
<a href='./showcandidates' class="loginbutton">Takaisin</a>