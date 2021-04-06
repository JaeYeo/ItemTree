<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		//비밀번호와 탈퇴절차 확인
		$("form").submit(function(){			
			var pass = $("#result2").text();
			var pass2 = $("#result3").text();
			if(pass=="비밀번호 불일치"){
				alert("비밀번호가 틀립니다.");
				$("#passwd").focus();
				return false;
			}else if(pass2=="탈퇴불가능"){
				alert("회원탈퇴를 입력해주세요.");
				$("memberdelete").focus();
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
		//탈퇴 절차1
		$("#memberdelete").on("keyup", function(){			
			var del=$("#memberdelete").val();
			if(del=="회원탈퇴"){
				mesg="탈퇴가능";
			}
			$("#result3").text(mesg);
		});


	})


</script>
<h1>회원탈퇴</h1>
<form action="memberDelete2" method="post">

아이디 : <span name="userid">${login.userid }</span><br>
비밀번호 : <input type="password" name="passwd" id="passwd"><span id="result2">비밀번호 불일치</span><br>
회원탈퇴 : <input type="text" name="memberdelete" id="memberdelete" placeholder="회원탈퇴"><span id="result3">탈퇴불가능</span><br>
<input type="hidden" name="userid" value="${login.userid }">
<input type="hidden" id="passwd2" value="${login.passwd }">

<input type="submit" value="회원 탈퇴">
<input type="reset" value="취소">

</form>
