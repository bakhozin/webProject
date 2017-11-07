<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<style type="text/css">
body{
	font-family: "나눔바른고딕";
}
input{
	width:60px;
	height: 30px;
}
#submit{
	width:100px;
	float: right;
}
#pwd{
	width:200px;
}
#addCard{
	float:right;
}
</style>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
	
	$(document).ready(function(){
		$("#addCard").click(function(){
			window.open("addCard.do","카드등록","width=420px, height=250px, menubar=no, location=no, toolbar=no , fullscreen=no, scrollbars=yes")
		});
		
		$("#submit").click(function(){
			
			
			if($("#cardNum1").val()==""||$("#cardNum2").val()==""||$("#cardNum3").val()==""||$("#cardNum4").val()==""){
				alert("카드번호를 입력해주세요");
			}else if($("#pwd").val()==""){
				alert("비밀번호를 입력해주세요");
			}else{
				var cardNum = $("#cardNum1").val()+"-"+ $("#cardNum2").val()+"-"+ $("#cardNum3").val()+"-"+ $("#cardNum4").val();
				var pwd = $("#pwd").val();
				$.ajax({
					url:"payment.do",
					data:{"cardNum":cardNum,
						  "pwd":pwd		
					     },
					type:"POST",
					dataType:"text",
					error:function(jqXHR){
						alert(jqXHR.status);
						//alert(jqXHR.statusText);
						//alert(jqXHR.responseText);
						//alert(jqXHR.readyState);
					},
					success:function(response){	
						alert(response);
						if(response=='cardX'){
							alert("카드번호와 비밀번호를 확인해주세요.")
						}else if(response=='midX'){
							alert("카드소유자가 일치하지 않습니다.")
						}else if(response=='success'){
							$(opener.document).find("#cardNum").val(cardNum);
							//$(opener.document).find("#form").attr("action","giftyconBuy.do").submit();
							window.self.close();
						}
					}
				});	
			}
		});
	});
	
</script>
</head>
<body>

		<!-- <p>보유 포인트 <input id="point" type="text" value="">&nbsp&nbsp&nbsp&nbsp 사용할 포인트<input id="usedPoint" name="usedPoint" type="text" value=""> </p> -->
		<p>결제정보입력</p>
		<hr>
		<p>신용카드 <input type="text" id="cardNum1">-<input type="text" id="cardNum2">-
		 <input type="text" id="cardNum3">-<input type="text" id="cardNum4">
		  <input type="hidden" id="cardNum"></p>
		<button id="addCard" style="float: right;">카드 등록하기</button>
		<br>
		<hr style="margin-top:10px;">
		<p>결제 비밀번호 <input type="password" name="pwd" id="pwd" ></p>
		<hr>
		<button id="submit">결제하기</button>
		<!-- <input id="submit"type="submit" value="결제하기"> -->

</body>
</html>