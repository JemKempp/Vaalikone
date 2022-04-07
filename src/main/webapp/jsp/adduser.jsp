<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
<%-- 
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
<h2>Rekisteröidy</h2>
<form id='userlomake'>
Kauttajatunnus: <input type='text' name='tunnus' value='' placeholder='Käyttäjätunnus...'><br>
Salasana: <input type='text' name='salasana' value='' placeholder='Salasana...'><br>
<input type='button' name='ok' value='Lähetä' onclick='lahetaKayttaja(this.form);'><br>
</form>
</script>
--%>
<h1>Check Password</h1>
<form action="/check" method="post">
<input type="text" name="username" value="">
<input type="password" name="password" value="">

<input type="submit" name="send" value="Check">
</form>
<form action ="/add" method="post">
<input type="text" name="username" value="">
<input type="password" name="password" value="">

<input type="submit" name="send" value="Add">
</form>
</body>
</html>