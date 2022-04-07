<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    

<div class="container">
<div class="row">
<div class="col-9">

<form action='lisaaehdokas' method='post'> 

Ehdokkaan etunimi: <input type='text' name='etunimi' size="35" value=''><br>
Ehdokkaan sukunimi: <input type='text' name='sukunimi' size="35" value=''><br>
Ehdokkaan puolue: <input type='text' name='puolue' size="35" value=''><br>
Kotipaikkakunta: <input type='text' name='kotipaikkakunta' size="35" value=''><br>
Ikä: <input type='text' name='ika' size="35" value=''><br>
Ammatti: <input type='text' name='ammatti' size="35" value=''><br>
Miksi haluan eduskuntaan?: <input type='text' name='miksi_eduskuntaan' size="35" value=''><br>
Mitä asioita haluan edistää?: <input type='text' name='mita_asioita_haluat_edistaa' size="35" value=''><br>
<input type='submit' name='ok' value='Send'> 
</form>
</div>
</div>
</div>
