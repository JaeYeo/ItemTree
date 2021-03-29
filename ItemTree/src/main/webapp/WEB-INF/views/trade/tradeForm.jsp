<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#paying").on("click", function() {
			var BCname = $("#BCname").val();
			var no = ${dto.no};
			var mileage = ${myMileage};
			var price = ${dto.price};
			console.log(BCname);
			if(BCname==""){
				alert("구매자 캐릭터명을 입력해주세요.");
				$("buyer_charactername").focus();
				return false;
			}else if(price > mileage){
				alert("보유 마일리지가 적습니다. 마일리지 충전 후 다시 시도해주세요.");
				return false;
			}
			location.href = "trading?no="+no;
		});
	})
</script>
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
<h3>내정보</h3>
<table border="1">
	<colgroup>
			<col width="50%">
			<col width="50%">		
	</colgroup>
	<tr>
		<th>아이디</th>
		<td>${login.userid }</td>
	</tr>
	<tr>
		<th>연락처</th>
		<td>${login.phone1 }-${login.phone2 }-${login.phone3 }</td>
	</tr>
	<tr>
		<th>구매자 캐릭터명</th>
		<td><input type="text" name="buyer_charactername" id="BCname" placeholder="캐릭터명을 입력해주세요."></td>
	</tr>
</table>
<h3>보유 마일리지 : ${myMileage }원&nbsp;&nbsp;&nbsp;&nbsp;결제 후 마일리지 : ${myMileage-dto.price }원</h3>

<h3>결제 금액 : ${dto.price } 원</h3>
<button id="paying">결제하기</button>
</body>
</html>