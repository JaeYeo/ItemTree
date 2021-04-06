<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#message_container{
		background-color: lime;
		width: 500px; height: 500px;
	}	
	#message_request{
		padding: -20 0 0 5;	
		display: inline-block;
	}
	#send_mesg{		
		display: inline-block;
	}
	#message_response{
		width: 490px; height: 390px;
		padding-right: 10px;
		
		display: inline-block;		
		overflow: auto;
	}
	 #seller{
		text-align: right;
		width: 300px;
		height: auto;
		margin-left: 170px;
	}
	#buyer{
		text-align: left;
		width: 300px;
		height: auto;
		margin-left: 10px;
	} 
	#comment_S{
		background-color: white;
		display: inline-block;
		border-radius: 10px;
		padding: 0 5px;
	}
	#comment_B{
		background-color: white;
		display: inline-block;
		border-radius: 10px;
		padding: 0 5px;
	}
</style>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
 	function comment_del2(a, b) {
		if(${!empty login.userid}){
			var id = "${login.userid}";
		}
		if(id !== a){
			alert("본인의 댓글만 지울 수 있습니다.");
			return false;
		}
		$.ajax({				
			type : "POST",
			url : "comment_del",
			data : "no="+b,
			dataType : "text",
			success : function(data, status, xhr) { //처리성공시
				console.log(data);
				alert(data);
				$("#send_mesg").trigger("click");
			},
			error : function(xhr, status, error) { //처리실패시
				
			}
		});//end ajax
	} 

	$(document).ready(function() {	
		$("#send_mesg").bind("click", function() {
			var no = ${dto.no};
			var content = $("#ItemTree_mesg").val();			
			if(${empty login}){
				$("#message_response").append("로그인 후 확인하실 수 있습니다.");
				return false;
			}
			$.ajax({				
				type : "POST",
				url : "comment",
				data : "no="+no+"&content="+content,
				dataType : "JSON",
				success : function(data, status, xhr) { //처리성공시
					console.log(data["no"]);
					$("#ItemTree_mesg").val("");
					$("#ItemTree_mesg").focus();
					$("#message_response").empty();				
					var userid = [];
					var content = [];
					var regdate = [];
					var commentno = [];
					$.each(data, function(index, item) {					
						for(var i=0; i<=data["item"].length; i++){
						//	if(data["item"][i]){
								userid.push(data["item"][i]["userid"]);
								content.push(data["item"][i]["content"]);
								regdate.push(data["item"][i]["regdate"]);
								commentno.push(data["item"][i]["no"]);
						//	}		
							var seller = "${dto.userid}";
							console.log(seller===userid[i]);
							if(seller===userid[i]){
								$("#message_response").append("<div id='seller'><div>판매자  ("+userid[i]+")  "+regdate[i]+"</div>"
										+"<button onclick='comment_del2(\""+userid[i]+"\","+commentno[i]+")'>삭제</button><div id='comment_S'><strong>"+content[i]+"</strong></div></div><br>")
							} else if(seller!==userid[i]){
								$("#message_response").append("<div id='buyer'><div>구매자  ("+userid[i]+")  "+regdate[i]+"</div>"
										+"<div id='comment_B'><strong>"+content[i]+"</strong></div><button onclick='comment_del2(\""+userid[i]+"\","+commentno[i]+")'>삭제</button></div><br>")
							}
							
						}
					})
				},
				error : function(xhr, status, error) { //처리실패시
					
				}
			});//end ajax
		});//end click
		$("#send_mesg").trigger("click");//페이지 로딩시 댓글목록 가져오기
		
	})
</script>
</head>
<body>
	<div id="message_container"><h3>ItemTree 메세지</h3>
		<div id="message_response"></div>
	
	
		<div id="message_request">			
			<input size="58px" id="ItemTree_mesg" type="text">
			<div id="send_mesg"><img width="50" height="50" src="https://i0.wp.com/forhappywomen.com/wp-content/uploads/2018/11/%EC%82%B0%EB%B6%80%EC%9D%B8%EA%B3%BC-%ED%8F%AC%ED%95%B4%ED%94%BC%EC%9A%B0%EB%A8%BC-%EB%AC%B8%EC%9D%98-%EC%B9%B4%EC%B9%B4%EC%98%A4%ED%94%8C%EB%9F%AC%EC%8A%A4%EC%B9%9C%EA%B5%AC-%EB%B2%84%ED%8A%BC.png?w=586&ssl=1"></div>
		</div>
	</div>
</body>
</html>