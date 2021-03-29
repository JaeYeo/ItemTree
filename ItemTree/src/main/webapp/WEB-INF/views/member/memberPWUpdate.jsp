<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		//기존비밀번호 새로운비밀번호 확인절차
		$("form").submit(function(){			
			var pass = $("#result2").text();
			var pass2 = $("#result3").text();
			if(pass=="비밀번호 불일치"){
				alert("비밀번호가 틀립니다.");
				$("#passwd").focus();
				return false;
			}else if(pass2=="새로운 비밀번호 불일치"){
				alert("새로운 비빌번호가 같지 않습니다.");
				$("#passwd3").focus();
				return false;
			}
		});
		//기존 비밀번호 확인 일치
		$("#passwd").on("keyup", function(){
			var mesg="비밀번호 불일치";
			var pw1=$("#passwd").val();
			var pw2=$("#passwd2").val();
			if(pw1==pw2){
				mesg="비밀번호 일치";
			}
			$("#result2").text(mesg);
		});
		//새로운 비밀번호 확인 일치
		$("#passwd4").on("keyup", function(){
			var mesg="새로운 비밀번호 불일치";
			var pw3=$("#passwd3").val();
			var pw4=$("#passwd4").val();
			if(pw3==pw4){
				mesg="새로운 비밀번호 일치";
			}
			$("#result3").text(mesg);
		});


	})


</script>
<h1>비밀번호 변경</h1>
<form action="memberPWUpdate2" method="post">

아이디 : <span name="userid">${login.userid }</span><br>
비밀번호 : <input type="password" name="passwd" id="passwd"><span id="result2">비밀번호 불일치</span><br>
새로운 비밀번호 : <input type="password" name="passwd3" id="passwd3"><span id="result3">새로운 비밀번호 불일치</span><br>
새로운 비밀번호 확인 : <input type="password" name="passwd4" id="passwd4"><br>
<input type="hidden" name="userid" value="${login.userid }">
<input type="hidden" id="passwd2" value="${login.passwd }">

<input type="submit" value="비밀번호 변경">
<input type="reset" value="취소">

</form>
