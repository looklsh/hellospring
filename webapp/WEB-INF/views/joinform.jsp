<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/hellospring/user/join" method="post">
	<input type="text" name="name" placeholder="이름">
	 <input type="text" name="email" placeholder="email">
	 <input type="password" name="password" placeholder="암호">
	 <input type="submit" value="가입">
	</form>
</body>
</html>