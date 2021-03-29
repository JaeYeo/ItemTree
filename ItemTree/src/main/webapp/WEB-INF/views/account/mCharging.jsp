<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.paymethods{
		width: 150px; height: 35px;
		font-size : 15pt;
		padding : 10px 0px;
		text-align: center;
		margin: 10px 0 0 -30px;
	}
	#kakaopay{ background-color: yellow;}
	#naverpay{ background-color: green;}
	ul, li{
	list-style: none;}
</style>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#kakaopay").on("click", function() {
			location.href = "paymethods?method=kakaopay"
		});
		$("#naverpay").on("click", function() {
			location.href = "paymethods?method=naverpay"
		});
	})
</script>
</head>

<body>
<div>
	<ul>
		<li><div class="paymethods" id="kakaopay">카카오페이</div></li>
		<li><div class="paymethods" id="naverpay">네이버페이</div></li>
	</ul>
</div>


</body>
</html>