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
	tr td{
	padding-left: 10px;
	}
</style>
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
			}else if(${empty login}){
				alert("로그인 후 이용가능합니다.");
				return false;
			};
			location.href="tradeForm?no="+no+"&buyer="+buyer;
		});
		
		function screenshot() {
			var url = "postScreenshot.jsp";
			var name = "이미지 보기";
			var options = 'top=10, left=10, width=600, height=700, status=no, toolbar=no, resizable=no';
			window.open(url, name, options);
		};
	})
</script>
</head>
<body>
	<div>
	<span>물품번호: ${dto.no }</span>ㅣ <sapn>등록일: ${dto.regdate }</sapn><br>
	<h3 style="margin: 5px">${dto.title }</h3>
	<table border="1" style="width: 500px">
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
			<div style="width:500px; text-align: center;">
			<input type="button" name="찜하기" value="찜하기">
			<input type="button" name="구매하기" id="itembuy" value="구매하기">
			<c:if test="${login.userid==dto.userid }">
			<input type="button" name="수정" id="postUpdate" value="물품수정">
			<input type="button" name="삭제" id="postDelete" value="물품삭제">	
			</c:if>
			</div>
		<table border="1" style="height: 100px; width: 500px">
		<colgroup>
			<col width="20%">
			<col width="80%">
		</colgroup>
			<tr style="height: 120px">
				<th>상세설명</th>
				<td>${dto.content }</td>
			</tr>
			<tr style="height: 120px">
				<th>첨부파일</th>
				<td><a href="postScreenshot?imgname=${imgname }" onclick="window.open(this.href,'팝업창','width=800, height=800'); return false">
					<c:if test="${!empty imgname }">
					<img alt="스크린샷" src="resources/images/${imgname }" width="100" height="100">
					</c:if>
					</a>
				</td>
			</tr>
		</table>
	</div>
		
</body>
</html>