<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form method="post" action="/update">
username : ${user.username}<br>
password : <input id="password" type="password"><br>
name : <input id="name"><br>
email : <input id="email"><br>
    <button>수정</button>
</form>
</body>
</html>