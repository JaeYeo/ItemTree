<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="common/top.jsp" flush="true"></jsp:include><br>
	<hr>
	<jsp:include page="common/selectgame.jsp" flush="true"></jsp:include><br>
	<hr>
	<jsp:include page="common/menu.jsp" flush="true"></jsp:include>
	<hr>
	<jsp:include page="account/myAccount.jsp" flush="true"></jsp:include>
</body>
</html>