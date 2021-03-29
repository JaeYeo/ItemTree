<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#title").on("click", function() {
			var no = $("#post_No").val();
			location.href="tradedOverview?no="+no;
		})
	})
</script>
</head>
<body>
<h2>거래완료 목록</h2>
	<table>
	<colgroup>
		<col style="width:7%">
		<col style="width:15%">
		<col style="width:40%">
		<col style="width:10%">
		<col style="width:15%">
		<col style="width:10%">
	</colgroup>
	<thead>
		<tr>
			<th>물품타입</th>
			<th>게임명/서버명</th>
			<th>물품제목</th>
			<th>판매수량</th>
			<th>가격</th>
			<th>등록일</th>
		</tr>
	</thead>
	<c:forEach var="list" items="${List }" varStatus="status">
	<tbody>
		<tr>
			<td class="type" style="text-align: center;">${type }</td>
			<td>${list.gamename } / ${list.servername }</td>
			<td><a href="tradedOverview?no=${list.no}">${list.title }</a></td>
			<td>${list.amount }</td>
			<td>${list.price }</td>
			<td>${list.regdate }</td>
		</tr>
		
	</tbody>
	</c:forEach>
	
	</table>
</body>
</html>