<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action='editcandidate' method='post'>
Ehdokas id: <input type='text' name='ehdokas_id' size="35" value='${sessionScope.candidates.ehdokas_id}' readonly><br> 
Ehdokkaan etunimi: <input type='text' name='etunimi' size="35" value='${sessionScope.candidates.etunimi}'><br>
Ehdokkaan sukunimi: <input type='text' name='sukunimi' size="35" value='${sessionScope.candidates.sukunimi}'><br>
Ehdokkaan puolue: <input type='text' name='puolue' size="35" value='${sessionScope.candidates.puolue}'><br>
Kotipaikkakunta: <input type='text' name='kotipaikkakunta' size="35" value='${sessionScope.candidates.kotipaikkakunta}'><br>
Ikä: <input type='text' name='ika' size="35" value='${sessionScope.candidates.ika}'><br>
Ammatti: <input type='text' name='ammatti' size="35" value='${sessionScope.candidates.ammatti}'><br>
Miksi haluan eduskuntaan?: <input type='text' name='miksi_eduskuntaan' size="35" value='${sessionScope.candidates.miksi_eduskuntaan}'><br>
Mitä asioita haluan edistää?: <input type='text' size="35" name='mita_asioita_haluat_edistaa' value='${sessionScope.candidates.mita_asioita_haluat_edistaa}'><br>
<input type='submit' name='ok' value='Send'> 
</form>
</body>
</html>