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
background-image: url('https://us.123rf.com/450wm/pavlik18/pavlik181602/pavlik18160200019/52558800-hand-casts-ballot-in-the-ballot-box-in-elections-silhouette.jpg?ver=6');
        background-repeat: no-repeat;
        background-size: cover;
        text-align: center;
}
</style>
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
<h2>Rekisteröidy</h2>
<form id='userlomake'>
Kauttajatunnus: <input type='text' name='tunnus' value='' placeholder='Käyttäjätunnus...'><br>
Salasana: <input type='text' name='salasana' value='' placeholder='Salasana...'><br>
<input type='button' name='ok' value='Lähetä' onclick='lahetaKayttaja(this.form);'><br>
</form>
</script>
<h1>Check Password</h1>
<form action="/add" method="post">
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