<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<style>
body {
background-image: url('https://static.scientificamerican.com/sciam/cache/file/2A451F1D-3FC5-4438-A1DFB859DF8D3AEB_source.jpg?w=590&h=800&4F353870-AA79-41FA-AFBAAEF4F774E4A0');
        background-repeat: no-repeat;
        background-size: cover;
		text-align: center;
}
</style>
<body>
<div class="container">
<div class="row">
<div class="col-9">

<form action='/showcandidates' method='post'> 

Ehdokkaan etunimi: <input type='text' name='etunimi' size="35" value=''><br>
Ehdokkaan sukunimi: <input type='text' name='sukunimi' size="35" value=''><br>
Ehdokkaan puolue: <input type='text' name='puolue' size="35" value=''><br>
Kotipaikkakunta: <input type='text' name='kotipaikkakunta' size="35" value=''><br>
Ikä: <input type='text' name='ika' size="35" value=''><br>
Ammatti: <input type='text' name='ammatti' size="35" value=''><br>
Miksi haluan eduskuntaan?: <input type='text' name='miksi_eduskuntaan' size="35" value=''><br>
Mitä asioita haluan edistää?: <input type='text' name='mita_asioita_haluat_edistaa' size="35" value=''><br>
<input type='submit' name='ok' value='Send'> 
</body>
</form>
</div>
</div>
</div>
