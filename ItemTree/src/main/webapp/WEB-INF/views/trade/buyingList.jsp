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
			location.href="tradingOverview?no="+no;
		})
	})
</script>
</head>
<body>
<h2>거래중인 목록</h2>
	<table border="1">
	<colgroup>
		<col style="width:10%">
		<col style="width:8%">
		<col style="width:52%">
		<col style="width:15%">
		<col style="width:15%">
	</colgroup>
	<%-- <td class="type" style="text-align: center;">${type }</td> --%>
	<thead>
		<tr>
			<th>물품번호</th>
			<th>종류</th>
			<th>물품제목</th>
			<th>수량</th>
			<th>가격</th>
		</tr>
	</thead>
	<c:forEach var="list" items="${List }" varStatus="status">
	<tbody>
		<tr>	
			<td rowspan="2">${list.no }</td>
			<td>${list.category }</td>
			<td><a href="trading2?no=${list.no}">${list.title }</a></td>
			<td>${list.amount }</td>
			<td>${list.price }</td>
		</tr>
		<tr>
			<td colspan="4">판매자:${list.seller_id } &nbsp; <span>캐릭터명:${list.charactername }</span>&nbsp;
				<span style="bold">코드 : </span><span>판매자 ${list.seller_code }ㅣ구매자${list.buyer_code }</span>
			</td>
		</tr>
	</tbody>
	</c:forEach>
	
	</table>
</body>
</html>