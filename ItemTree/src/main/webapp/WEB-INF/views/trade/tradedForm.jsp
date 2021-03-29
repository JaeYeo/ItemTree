<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>상품정보</h3>
<table border="1">
	<colgroup>
			<col width="60%">
			<col width="20%">
			<col width="20%">
	</colgroup>
	<tr>
		<th>물품제목</th>
		<th>거래수량</th>
		<th>거래가격</th>
	</tr>
	<tr>
		<td>${dto.title }</td>
		<td>${dto.amount }</td>
		<td>${dto.price }</td>
	</tr>
</table>
</body>
</html>