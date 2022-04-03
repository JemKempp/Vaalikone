<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<script language="php">
function lahetaKayttaja(lomake){
var user=new Object();
user.tunnus=lomake.tunnus.value;
user.salasana=lomake.salasana.value;
var jsonUser=JSON.stringify(user);

xmlhttp = new XMLHttpRequest();
xmlhttp.onreadystatechange = function() {
if (this.readyState == 4 && this.status == 200){
document.getElementById("result").innerHTML = this.responseText;
}
};
xmlhttp.open("POST", "../php/rekisteroidy.php", true);
	xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xmlhttp.send("user=" + jsonUser);	
}
</script>

<h2>Rekisteröidy</h2>
<form id='userlomake'>
Kauttajatunnus: <input type='text' name='tunnus' value='' placeholder='Käyttäjätunnus...'><br>
Salasana: <input type='text' name='salasana' value='' placeholder='Salasana...'><br>
<input type='button' name='ok' value='Lähetä' onclick='lahetaKayttaja(this.form);'><br>
</form>
</script>
</body>
</html>