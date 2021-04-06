<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	
	<form action="postUpdate2">
	<input type="hidden" name="userid" value="${login.userid }">
		물품유형 : ${dto.type } <br>
		게임명 <input type="text" name="gamename" value="${dto.gamename }"> 
		서버명<input type="text" name="servername" value="${dto.servername }"><br>
		물품종류 
		<select name="category">
			<option value="게임머니">게임머니</option>
			<option value="아이템">아이템</option>
			<option value="계정">계정</option>
			<option value="기타">기타</option>
		</select><br>
		보유수량<input type="text" name="amount" value="${dto.amount }"> <!-- <span>게임머니일 경우 만,억,조 select추가</span> --> <br>
		거래가격<input type="text" name="price" value="${dto.price }">원<br>
		물품제목<input type="text" name="title" size="40" value="${dto.title }"><br>
		상세설명<input type="text" name="content" style="width:300px;height:200px;" value="${dto.content }"><br>
		<!-- 이미지추가<div id="img"></div><br> -->
		캐릭터명<input type="text" name="charactername" value="${dto.charactername }" }><br>
		<input type="hidden" name="userid" value="${dto.userid }">
		<input type="hidden" name="no" value="${dto.no }">
		<input type="hidden" name="type" value="${dto.type }">

		<input type="submit" value="물품 수정하기">
		
	</form>
</body>
</html>