<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
	<title>Main</title>
	<meta charset="UTF-8">
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	
</head>
<body>

<jsp:include page="common/top.jsp" flush="true"></jsp:include><br>
<hr>
<jsp:include page="common/selectgame.jsp" flush="true"></jsp:include><br>
<hr>
<jsp:include page="common/menu.jsp" flush="true"></jsp:include>
<hr>
<jsp:include page="post/postOverview.jsp" flush="true"></jsp:include>
<jsp:include page="post/comment.jsp" flush="true"></jsp:include>
</body>
</html>
