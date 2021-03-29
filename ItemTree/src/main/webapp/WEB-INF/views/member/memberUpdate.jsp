<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		//회원가입 시 아이디 비밀번호 입력체크
		$("form").submit(function(){			
			var pass = $("#result2").text();
			if(pass=="비밀번호 불일치"){
				alert("비밀번호가 틀립니다.");
				$("#passwd").focus();
				return false;
			}
		});
		//비밀번호 확인 일치
		$("#passwd").on("keyup", function(){
			var mesg="비밀번호 불일치";
			var pw1=$("#passwd").val();
			var pw2=$("#passwd2").val();
			if(pw1==pw2){
				mesg="비밀번호 일치";
			}
			$("#result2").text(mesg);
		});
		//이메일 선택
		$("#emailSelect").on("change", function() {
			var email=$(this).val();
			$("#email2").val(email);
		});

	})


</script>
<h1>회원 정보 수정</h1>
<form action="memberUpdate2" method="post">
아이디 : <span name="userid">${login.userid }</span><br>
비밀번호 : <input type="password" name="passwd" id="passwd"><span id="result2">비밀번호 불일치</span><br>
<input type="hidden" name="userid" value="${login.userid }">
<input type="hidden" id="passwd2" value="${login.passwd }">
<input type="hidden" name="username" value="${login.username }">
이름 : <span name="username">${login.username }</span><br>
<input type="text" name="post" id="sample4_postcode" value="${login.post }">
<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기"><br>
<input type="text" name="addr1" id="sample4_roadAddress" value="${login.addr1 }">
<input type="text" name="addr2" id="sample4_jibunAddress" value="${login.addr2 }">
<span id="guide" style="color:#999"></span> <br>
연락처 : <select name="phone1">
		<option value="010">010</option>
		<option value="011">011</option>
		</select>
-
<input type="text" name="phone2" value="${login.phone2 }">
-
<input type="text" name="phone3" value="${login.phone3 }"><br>
이메일 : <input type="text" name="email1" value="${login.email1 }">@
		<input type="text" name="email2" value="${login.email2 }">
		<select>
		<option value="daum.net">daum.net</option>
		<option value="naver.com">naver.com</option>
		<option value="google.com">google.net</option>
		</select> <br>
<input type="submit" value="회원정보 수정">
<input type="reset" value="취소">

</form>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
    //본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
    function sample4_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 도로명 조합형 주소 변수

                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }
                // 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
                if(fullRoadAddr !== ''){
                    fullRoadAddr += extraRoadAddr;
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample4_postcode').value = data.zonecode; //5자리 새우편번호 사용
                document.getElementById('sample4_roadAddress').value = fullRoadAddr;
                document.getElementById('sample4_jibunAddress').value = data.jibunAddress;

                // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
                if(data.autoRoadAddress) {
                    //예상되는 도로명 주소에 조합형 주소를 추가한다.
                    var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                    document.getElementById('guide').innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';

                } else if(data.autoJibunAddress) {
                    var expJibunAddr = data.autoJibunAddress;
                    document.getElementById('guide').innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';

                } else {
                    document.getElementById('guide').innerHTML = '';
                }
            }
        }).open();
    }
</script>