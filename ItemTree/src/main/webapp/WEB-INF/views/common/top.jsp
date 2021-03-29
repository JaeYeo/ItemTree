<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:if test="${!empty mesg}">
	<script type="text/javascript">
		alert("${mesg }")
	</script>
</c:if>
<script type="text/javascript">
	function gomain() {
		location.href = "main";
	}
</script>
<style type="text/css">
	.gomain{
		width: 150px; height: 50px; color: green;
	}
</style>
</head>
<body>
	<div class="gomain" onclick="gomain()"><h1>ItemTree</h1></div>
	
	<c:if test="${empty login}">
	 <a href="loginForm">마이페이지</a>
	 <a href="">고객감동센터</a>
	 <a href="memberForm">회원가입</a>
	 <a href="loginForm">로그인</a>
	</c:if>
	<c:if test="${!empty login}">	 
	 <a href="">등록한 물품 보기</a>
	 <a href="mypage">마이페이지</a>
	 <a href="">고객감동센터</a>
	 <a href="logout">로그아웃</a><br>
	 어서오세요. ${login.userid }님
	</c:if>
</body>
</html>