<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form method="post" action="/login">
    id : <input id="username"><br>
    pw : <input type = password id="password"><br>
    <button>로그인</button><br>
</form>
<form method="get" action="/join">
    <button>회원가입</button>
</form>
</body>
</html>