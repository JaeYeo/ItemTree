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
		$("#buyer_appoval").on("click", function() {
			var no = ${pdto.no};
			if(!confirm("구매 확정을 하시겠습니까?")){
				alert("취소(아니오)를 누르셨습니다.");
				return false;
			}else {
				alert("확인(예)을 누르셨습니다.");
				location.href="trade_approval?buyer_approval=true&no="+no;
			}
			
		});
		$("#seller_appoval").on("click", function() {
			var no = ${pdto.no};
			$.ajax({
				type : "get",
				url : "seller_approval", //서버주소
				dataType : "text", //응답데이터 타입
				data : {
					no : no,
					seller_approval : true 
				},
				success : function(data, status, xhr) { //처리성공시
					console.log(data);
					$("#seller_appoval_mesg").text(data);
					alert("물품전달 완료. 구매자의 응답이 완료되면 거래가 종료됩니다.");
				},
				error : function(xhr, status, error) { //처리실패시
					console.log("error");
				}
			});//end ajax
		});
		$("#buyer_cancel").on("click", function() {
			var no = ${pdto.no};
			alert("거래취소요청 완료. 상대방이 수락하면 거래가 취소됩니다.");
			$(".trade_cancel_mesg").text("거래취소 요청됨");
			location.href="trade_cancel?buyer_cancel=true&no="+no;
		});
		$("#seller_cancel").on("click", function() {
			var no = ${pdto.no};
			alert("거래취소요청 완료. 상대방이 수락하면 거래가 취소됩니다.");
			$(".trade_cancel_mesg").text("거래취소 요청됨");
			location.href="trade_cancel?seller_cancel=true&no="+no;
		});
	});

</script>
</head>
<body>
<c:if test="${!empty pdto }"><!-- 물품정보가 있을경우에만 보이기 -->
물품번호 : ${pdto.no } ㅣ 등록일 : ${pdto.regdate } <br>
<h3>[거래 진행중]${pdto.title }</h3>
<table border="1">
	<colgroup>
			<col width="50%">
			<col width="50%">		
	</colgroup>
	<tr>
		<th>거래가격</th>
		<td>${pdto.price }</td>
	</tr>
	<tr>
		<th>거래수량</th>
		<td>${pdto.amount }</td>
	</tr>
	<tr>
		<th>종류</th>
		<td>${pdto.category }</td>
	</tr>
</table>
<h3>필수확인 정보</h3>
<c:if test="${login.userid == buyer_dto.userid }">
<div class="login=buyer">
<table border="1">
	<colgroup>
			<col width="50%">
			<col width="50%">		
	</colgroup>
	<tr>
		<th>판매자 이름</th>
		<td>${seller_dto.username }</td>
	</tr>
	<tr>
		<th>판매자 캐릭터명</th>
		<td>${pdto.charactername }</td>
	</tr>
	<tr>
		<th>나의 캐릭터명 </th>
		<td>${tdto.buyer_charname }</td>
	</tr>
	<tr>
		<th>판매자 연락처</th>
		<td>${seller_dto.phone1 }-${seller_dto.phone2 }-${seller_dto.phone3 }</td>
	</tr>
	<tr>
		<th>판매자 코드</th>
		<td>${tdto.seller_code }</td>
	</tr>
	<tr>
		<th>나의 코드</th>
		<td>${tdto.buyer_code }</td>
	</tr>
</table>
<br>
<div id="buyer_appoval_mesg"></div>
<div class="trade_cancel_mesg"></div>
<button id="buyer_appoval">구매확정</button>
<button id="buyer_cancel">거래취소 요청</button>
<button id="message">ItemTree쪽지함</button>
</div>
</c:if>
<c:if test="${login.userid == seller_dto.userid }">
<div class="login=seller">
<table border="1">
	<colgroup>
			<col width="50%">
			<col width="50%">		
	</colgroup>
	<tr>
		<th>구매자 이름</th>
		<td>${buyer_dto.username }</td>
	</tr>
	<tr>
		<th>구매자 캐릭터명</th>
		<td>${tdto.buyer_charname }</td>
	</tr>
	<tr>
		<th>나의 캐릭터명 </th>
		<td>${pdto.charactername }</td>
	</tr>
	<tr>
		<th>구매자 연락처</th>
		<td>${buyer_dto.phone1 }-${buyer_dto.phone2 }-${buyer_dto.phone3 }</td>
	</tr>
	<tr>
		<th>구매자 코드</th>
		<td>${tdto.buyer_code }</td>
	</tr>
	<tr>
		<th>나의 코드</th>
		<td>${tdto.seller_code }</td>
	</tr>
</table>
<br>
<div id="seller_appoval_mesg"></div>
<div class="trade_cancel_mesg"></div>
<button id="seller_appoval">물품 전달 완료</button>
<button id="seller_cancel">거래취소 요청</button>
<button id="message">ItemTree쪽지함</button>
</div>
</c:if>
</c:if><!-- 물품정보가 있을때만 보이기 end -->
</body>
</html>