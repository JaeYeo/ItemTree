<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.methods{
		width: 200px; height: 600px;
		float: left;
	}
</style>
<c:if test="${!empty success}">
	<script type="text/javascript">
		alert("${success }");
	</script>
</c:if>
</head>
<body>
	<h2>마일리지 충전</h2>
	<div class="methods">
	<jsp:include page="account/mCharging.jsp"></jsp:include>
	</div>
	
	<c:if test="${!empty paymethod}">	 
		<div class="methods_page" id="methods_page">
		<jsp:include page="${paymethod }" flush="false"></jsp:include>
		</div>
	</c:if>
	

</body>
</html>