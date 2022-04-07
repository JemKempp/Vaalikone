<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <%@ page import="java.util.ArrayList" %>   
 <%@ page import="app.model.Candidates" %>   
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    

<div class="container">
<div class="row">
<div class="col-9">
<ol>
<c:forEach var="Candidates" items="${requestScope.candidatelist}" >
<li>${Candidates.getEtunimi()} ${Candidates.getSukunimi()} - ${Candidates.getPuolue()} - ${Candidates.getKotipaikkakunta()}<a href='/deletecandidates?ehdokas_id=${Candidates.getEhdokas_id()}'> poista ehdokas </a> <a href='/addcandidate?ehdokas_id=${Candidates.getEhdokas_id()}'> Lisää ehdokas </a>
</c:forEach>
</ol>


</div>
<a href='/addcandidate'>Lisää ehdokas</a>
</div>
</div>
