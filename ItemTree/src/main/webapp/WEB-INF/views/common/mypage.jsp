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
	<a href="myAccount">My Account </a><br><br>
	
	 <a href="myTrading">거래중인 물품</a><br>
	 <a href="tradedList?user=seller">판매완료 물품</a><br>
	 <a href="tradedList?user=buyer">구매완료 물품</a><br><br> 
	 
	 <a href="memberUpdate">회원 정보 수정</a><br>
	 <a href="memberPWUpdate">비빌번호 변경</a><br>
	 <a href="memberDelete">회원탈퇴</a>

</body>
</html>