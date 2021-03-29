<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
	<title>Main</title>
	<meta charset="UTF-8">
</head>
<body>

<jsp:include page="common/top.jsp" flush="true"></jsp:include><br>
<hr>
<jsp:include page="common/selectgame.jsp" flush="true"></jsp:include><br>
<hr>
<jsp:include page="common/menu.jsp" flush="true"></jsp:include>
<hr>
<jsp:include page="post/postOverview.jsp" flush="true"></jsp:include>

</body>
</html>
