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
		
	})
</script>
</head>
<body>
	<div>
	<span>물품번호: ${dto.no }</span>ㅣ <sapn>등록일: ${dto.regdate }</sapn><br>
	<span>[ ${dto.type } ]</span><span>${dto.title }</span><br><br>
	<table border="1">
		<colgroup>
			<col width="20%">
			<col width="80%">
		</colgroup>
		<tr>
			<th>게임명</th>
			<td>${dto.gamename }</td>
		</tr>
		<tr>
			<th>거래가격</th>
			<td>${dto.price }</td>
		</tr>
		<tr>
			<th>거래 수량</th>
			<td>${dto.amount }</td>
		</tr>
		<tr>
			<th>종류</th>
			<td>${dto.category }</td>
		</tr>
		</table>
			<input type="button" name="거래내역서" value="거래내역서 받기">
		<table border="1">
		<colgroup>
			<col width="20%">
			<col width="80%">
		</colgroup>
			<tr>
				<th>상세설명</th>
				<td>${dto.content }</td>
			</tr>
		</table>
	</div>
			
</body>
</html>