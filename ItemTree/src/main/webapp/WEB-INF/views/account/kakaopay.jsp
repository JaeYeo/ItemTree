<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
const kakaopay = document.getElementById('kakaopay_charge');
const form = document.getElementById('kakaopayForm');

kakaopay.addEventListener("click", function() {
	form.action = "kakaoPay_ready";
	form.method = "post";
	form.submit();
});

</script>
</head>
<body>
<h3>카카오페이</h3>
<form id="kakaopayForm" action="kakaoPay_ready" method="post">
<input type="radio" name="pay" value="500000">500,000원
<input type="radio" name="pay" value="300000">300,000원
<input type="radio" name="pay" value="100000">100,000원<br>
<input type="radio" name="pay" value="50000">&nbsp;50,000원 
<input type="radio" name="pay" value="30000">&nbsp;30,000원
<input type="radio" name="pay" value="10000">&nbsp;10,000원<br>
직접 입력 : <input type="text" name="pay">원<br><br>

	<input type="submit" value="충전하기">
</form>
</body>
</html>