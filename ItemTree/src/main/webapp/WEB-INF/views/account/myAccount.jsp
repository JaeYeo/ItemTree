<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
	function mCharging() {
		var url = "mCharging";
		var name = "마일리지 충전";
		var options = 'top=10, left=10, width=600, height=700, status=no, toolbar=no, resizable=no';
		window.open(url, name, options);
	};
	$(document).ready(function() {
		var coupon1 = ${myAccount.coupon1};
		var coupon2 = ${myAccount.coupon2};
		if(coupon1==true){
			$("#coupon1").text("보유 중");
		}else{
			$("#coupon1").text("없음");
		};
		if(coupon2==true){
			$("#coupon2").text("보유 중");
		}else{
			$("#coupon2").text("없음");
		}
	});

</script>
</head>
<body>

	보유중인 마일리지 : ${myAccount.mileage } 
	<input type="button" id="mCharging" onclick="mCharging()" value="충전"> <br>
	총 판매금액 : ${myAccount.sum_sell } <br>
	총 구매금액 : ${myAccount.sum_buy } <br>
	쿠폰1 : <span id="coupon1"></span><br> 
	쿠폰2 : <span id="coupon2"></span> <br> 
</body>
</html>