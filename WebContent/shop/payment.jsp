<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<style type="text/css">
body{
	font-family: "�����ٸ����";
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
			window.open("addCard.do","ī����","width=420px, height=250px, menubar=no, location=no, toolbar=no , fullscreen=no, scrollbars=yes")
		});
		
		$("#submit").click(function(){
			
			
			if($("#cardNum1").val()==""||$("#cardNum2").val()==""||$("#cardNum3").val()==""||$("#cardNum4").val()==""){
				alert("ī���ȣ�� �Է����ּ���");
			}else if($("#pwd").val()==""){
				alert("��й�ȣ�� �Է����ּ���");
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
							alert("ī���ȣ�� ��й�ȣ�� Ȯ�����ּ���.")
						}else if(response=='midX'){
							alert("ī������ڰ� ��ġ���� �ʽ��ϴ�.")
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

		<!-- <p>���� ����Ʈ <input id="point" type="text" value="">&nbsp&nbsp&nbsp&nbsp ����� ����Ʈ<input id="usedPoint" name="usedPoint" type="text" value=""> </p> -->
		<p>���������Է�</p>
		<hr>
		<p>�ſ�ī�� <input type="text" id="cardNum1">-<input type="text" id="cardNum2">-
		 <input type="text" id="cardNum3">-<input type="text" id="cardNum4">
		  <input type="hidden" id="cardNum"></p>
		<button id="addCard" style="float: right;">ī�� ����ϱ�</button>
		<br>
		<hr style="margin-top:10px;">
		<p>���� ��й�ȣ <input type="password" name="pwd" id="pwd" ></p>
		<hr>
		<button id="submit">�����ϱ�</button>
		<!-- <input id="submit"type="submit" value="�����ϱ�"> -->

</body>
</html>