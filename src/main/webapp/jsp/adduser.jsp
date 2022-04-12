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

<h1>Kirjaudu sisään</h1>
<form action="/check" method="post">
<input type="text" name="username" value="">
<input type="password" name="password" value="">

<input type="submit" name="send" value="Check">
</form>
<h1>Lisää käyttäjä</h1>
<form action ="/add" method="post">
<input type="text" name="username" value="">
<input type="password" name="password" value="">

<input type="submit" name="send" value="Add">
</form>
<a href="/logout">Logout</a>
</body>
</html>