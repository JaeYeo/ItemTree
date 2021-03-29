<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="login" method="post">
		아이디 : <input type="text" name="userid" placeholder="아이디"><br>
		비밀번호 : <input type="text" name="passwd" placeholder="비밀번호"><br>
		<input type="submit" value="로그인">
		<input type="reset" value="취소">
	</form>
</body>
</html>