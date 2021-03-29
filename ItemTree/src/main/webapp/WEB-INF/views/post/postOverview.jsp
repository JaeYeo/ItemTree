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
		$("#postUpdate").on("click", function() {
			var no = ${dto.no};
			location.href="postUpdate?no="+no;
		});
		
		$("#postDelete").on("click", function() {
			var no = ${dto.no};
			location.href="postDelete?no="+no;
		});
		$("#itembuy").on("click", function() {
			var no = ${dto.no};
			var seller = "${dto.userid}";
			var buyer = "${login.userid}";
			if(seller == buyer){
				alert("본인의 물품은 구매할 수 없습니다.");
				return false;
			};
			location.href="tradeForm?no="+no+"&buyer="+buyer;
		});
	})
</script>
</head>
<body>
	<div>
	<span>물품번호: ${dto.no }</span>ㅣ <sapn>등록일: ${dto.regdate }</sapn><br>
	<span>${dto.title }</span>
	<table border="1">
		<colgroup>
			<col width="20%">
			<col width="80%">
		</colgroup>
		<tr>
			<th>거래가격</th>
			<td>${dto.price }</td>
		</tr>
		<tr>
			<th>아이템 수량</th>
			<td>${dto.amount }</td>
		</tr>
		<tr>
			<th>결제금액</th>
			<td>${dto.price }</td>
		</tr>
		</table>
			<input type="button" name="찜하기" value="찜하기">
			<input type="button" name="구매하기" id="itembuy" value="구매하기">
			<input type="button" name="수정" id="postUpdate" value="물품수정">
			<input type="button" name="삭제" id="postDelete" value="물품삭제">	
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
			
	다이렉트 메시지
	<div>메시지</div>
</body>
</html>