<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
	
	$(document).ready(function(){
		/* var phones= $("#phone").val().split("-");
		$("#phone1").val(phones[0]);
		$("#phone2").val(phones[1]);
		$("#phone3").val(phones[2]); */
		
		$(".reset").click(function(){
			var id = $(this).attr("id");
			if(id=='r1'){
				$(".rphone1").val("");
				$(".rphone1").prop('readonly',false);
				var amount = parseInt($("#amount1").text())-1;
				$("#amount1").text(amount);
				$("#amount").val(amount);
				var price = parseInt($("#price").text());
				var total = parseInt(amount*price);
				$("#total1").text(total);
				$("#total").val(total);
				$(".rphone1").css({
					'background-color':'white',
					'border-color':'black',
					'border-width':'thin'
				});
				$("#r1CK").val("nonCK");
			}else if(id=='r2'){
				$(".rphone2").val("");
				$(".rphone2").prop('readonly',false);
				var amount = parseInt($("#amount1").text())-1;
				$("#amount1").text(amount);
				$("#amount").val(amount);
				var price = parseInt($("#price").text());
				var total = parseInt(amount*price);
				$("#total1").text(total);
				$("#total").val(total);
				$(".rphone2").css({
					'background-color':'white',
					'border-color':'black',
					'border-width':'thin'
				});
				$("#r2CK").val("nonCK");
			}else if(id=='r3'){
				$(".rphone3").val("");
				$(".rphone3").prop('readonly',false);
				var amount = parseInt($("#amount1").text())-1;
				$("#amount1").text(amount);
				$("#amount").val(amount);
				var price = parseInt($("#price").text());
				var total = parseInt(amount*price);
				$("#total1").text(total);
				$("#total").val(total);
				$(".rphone3").css({
					'background-color':'white',
					'border-color':'black',
					'border-width':'thin'
				});
				$("#r3CK").val("nonCK");
			}else if(id=='r4'){
				$(".rphone4").val("");
				$(".rphone4").prop('readonly',false);
				var amount = parseInt($("#amount1").text())-1;
				$("#amount1").text(amount);
				$("#amount").val(amount);
				var price = parseInt($("#price").text());
				var total = parseInt(amount*price);
				$("#total1").text(total);
				$("#total").val(total);
				$(".rphone4").css({
					'background-color':'white',
					'border-color':'black',
					'border-width':'thin'
				});
				$("#r4CK").val("nonCK");
			}else if(id=='r5'){
				$(".rphone5").val("");
				$(".rphone5").prop('readonly',false);
				var amount = parseInt($("#amount1").text())-1;
				$("#amount1").text(amount);
				$("#amount").val(amount);
				var price = parseInt($("#price").text());
				var total = parseInt(amount*price);
				$("#total1").text(total);
				$("#total").val(total);
				$(".rphone5").css({
					'background-color':'white',
					'border-color':'black',
					'border-width':'thin'
				});
				$("#r5CK").val("nonCK");
			}
		});
		
		$(".search").click(function(){
			var id = $(this).attr("id");
			if(id=='r1'){
				if($("#rphone1-1").val()==""||$("#rphone1-2").val()==""||$("#rphone1-3").val()==""){
					alert("핸드폰 번호를 입력해주세요");
				}else{
					var rphone1 = $("#rphone1-1").val()+"-"+$("#rphone1-2").val()+"-"+$("#rphone1-3").val();
					 $.ajax({
						url:"phoneCheck.do",
						data:{"phone":rphone1},
						type:"POST",
						dataType:"text",
						error:function(jqXHR){
							alert(jqXHR.status);
						},
						success:function(responseData){	
							if($.trim(responseData)=="checkX"){
								$("#r1CK").val('X');
								alert("회원목록에 없는 번호입니다.");
							}else{
								
								$("#r1CK").val('O');
								$("#rphone1").val(rphone1);
								$(".rphone1").prop('readonly',true);
								var amount = Number($("#amount1").text())+1;
								$("#amount1").text(amount);
								$("#amount").val(amount);
								var price = Number($("#price").text());
								var total = Number((amount)*(price));
								$("#total1").text(total);
								$("#total").val(total);
								$(".rphone1").css({
									'background-color':'silver',
									'border-color':'black',
									'border-width':'thin'
								});
							}
						}
					});	 
				}
			}else if(id=='r2'){
				if($("#rphone2-1").val()==""||$("#rphone2-2").val()==""||$("#rphone2-3").val()==""){
					alert("핸드폰 번호를 입력해주세요");
				}else{
					var rphone1 = $("#rphone2-1").val()+"-"+$("#rphone2-2").val()+"-"+$("#rphone2-3").val();
					 $.ajax({
						url:"phoneCheck.do",
						data:{"phone":rphone1},
						type:"POST",
						dataType:"text",
						error:function(jqXHR){
							alert(jqXHR.status);
						},
						success:function(responseData){	
							if($.trim(responseData)=="checkX"){
								$("#r2CK").val('X');
								alert("회원목록에 없는 번호입니다.");
							}else{
								$("#r2CK").val('O');
								$("#rphone2").val(rphone1);
								$(".rphone2").prop('readonly',true);
								var amount = Number($("#amount1").text())+1;
								$("#amount1").text(amount);
								$("#amount").val(amount);
								var price = Number($("#price").text());
								var total = Number((amount)*(price));
								$("#total1").text(total);
								$("#total").val(total);
								$(".rphone2").css({
									'background-color':'silver',
									'border-color':'black',
									'border-width':'thin'
								});
							}
						}
					});	 
				}
			}else if(id=='r3'){
				if($("#rphone3-1").val()==""||$("#rphone3-2").val()==""||$("#rphone3-3").val()==""){
					alert("핸드폰 번호를 입력해주세요");
				}else{
					var rphone1 = $("#rphone3-1").val()+"-"+$("#rphone3-2").val()+"-"+$("#rphone3-3").val();
					 $.ajax({
						url:"phoneCheck.do",
						data:{"phone":rphone1},
						type:"POST",
						dataType:"text",
						error:function(jqXHR){
							alert(jqXHR.status);
						},
						success:function(responseData){	
							if($.trim(responseData)=="checkX"){
								$("#r3CK").val('X');
								alert("회원목록에 없는 번호입니다.");
							}else{
								$("#r3CK").val('O');
								$("#rphone3").val(rphone1);
								$(".rphone3").prop('readonly',true);
								var amount = Number($("#amount1").text())+1;
								$("#amount1").text(amount);
								$("#amount").val(amount);
								var price = Number($("#price").text());
								var total = Number((amount)*(price));
								$("#total1").text(total);
								$("#total").val(total);
								$(".rphone3").css({
									'background-color':'silver',
									'border-color':'black',
									'border-width':'thin'
								});
							}
						}
					});	 
				}
			}else if(id=='r4'){
				if($("#rphone4-1").val()==""||$("#rphone4-2").val()==""||$("#rphone4-3").val()==""){
					alert("핸드폰 번호를 입력해주세요");
				}else{
					var rphone1 = $("#rphone4-1").val()+"-"+$("#rphone4-2").val()+"-"+$("#rphone4-3").val();
					 $.ajax({
						url:"phoneCheck.do",
						data:{"phone":rphone1},
						type:"POST",
						dataType:"text",
						error:function(jqXHR){
							alert(jqXHR.status);
						},
						success:function(responseData){	
							if($.trim(responseData)=="checkX"){
								$("#r4CK").val('X');
								alert("회원목록에 없는 번호입니다.");
							}else{
								$("#r4CK").val('O');
								$("#rphone4").val(rphone1);
								$(".rphone4").prop('readonly',true);
								var amount = Number($("#amount1").text())+1;
								$("#amount1").text(amount);
								$("#amount").val(amount);
								var price = Number($("#price").text());
								var total = Number((amount)*(price));
								$("#total1").text(total);
								$("#total").val(total);
								$(".rphone4").css({
									'background-color':'silver',
									'border-color':'black',
									'border-width':'thin'
								});
							}
						}
					});	 
				}
			}else if(id=='r5'){
				if($("#rphone5-1").val()==""||$("#rphone5-2").val()==""||$("#rphone5-3").val()==""){
					alert("핸드폰 번호를 입력해주세요");
				}else{
					var rphone1 = $("#rphone5-1").val()+"-"+$("#rphone5-2").val()+"-"+$("#rphone5-3").val();
					 $.ajax({
						url:"phoneCheck.do",
						data:{"phone":rphone1},
						type:"POST",
						dataType:"text",
						error:function(jqXHR){
							alert(jqXHR.status);
						},
						success:function(responseData){	
							if($.trim(responseData)=="checkX"){
								$("#r5CK").val('X');
								alert("회원목록에 없는 번호입니다.");
							}else{
								$("#r5CK").val('O');
								$("#rphone5").val(rphone1);
								$(".rphone5").prop('readonly',true);
								var amount = Number($("#amount1").text())+1;
								$("#amount1").text(amount);
								$("#amount").val(amount);
								var price = Number($("#price").text());
								var total = Number((amount)*(price));
								$("#total1").text(total);
								$("#total").val(total);
								$(".rphone5").css({
									'background-color':'silver',
									'border-color':'black',
									'border-width':'thin'
								});
							}
						}
					});	 
				}
			}
		});
		
		$("#submit").click(function(){
	
			
			if($("#r1CK").val()=='nonCK'&&$("#r2CK").val()=='nonCK'&&$("#r3CK").val()=='nonCK'&&$("#r4CK").val()=='nonCK'&&$("#r5CK").val()=='nonCK'){
				alert("핸드폰번호를 입력해주세요");
				return false;
			} else if($("#r1CK").val()=='X'||$("#r2CK").val()=='X'||$("#r3CK").val()=='X'||$("#r4CK").val()=='X'||$("#r5CK").val()=='X'){
				alert("수신자의 핸드폰번호를 확인해주세요");
				return false;
				
			}else{
				if($("#cardNum").val()==""){
					window.open("payment.do","결제","width=420px, height=250px, menubar=no, location=no, toolbar=no , fullscreen=no, scrollbars=yes")
					return false;
				}
			}
		
		});
		
	});
	
</script>
	
</head>
<style>
/* 메인메인메인메인메인메인메인메인   */
.luncher {
	width: 100%;
	height: 30px;
	line-height: 12px;
}
.luncher>ul>li {
	float: right;
	font-size: 15px;
	padding: 9px 0 0 20px;
	line-height: 12px;
	list-style: none;
}
a {
	color: black;
}
.navbar-nav {
	width: 100%;
	text-align: center;
}
.navbar-nav>li {
	float: none;
	display: inline-block;
	border-left:1px solid #999; 
	padding:0 100px;
}
.dropdown {
	font-size: 25px; 
	font-weight: bold;
	
}
.dropdown-toggle {
	color: black;
}
.dropdown-menu {
	padding: 10px 10px;
	border: 2px solid gray;
	text-align: center;
	width:100px;
	margin: 0 auto;
}
.dropdown:hover .dropdown-menu {
	display: block;
	margin-top: 0;
}

/*///////////////////////////////////////////////////////////  */
/* 영화순위순위순위순위순위순위 */
body{padding-top:20px;}
.carousel {
    margin-bottom: 0;
    padding: 0 40px 30px 40px;
}
/* The controlsy */
.carousel-control {
	left: -12px;
    height: 40px;
	width: 40px;
    background: none repeat scroll 0 0 #222222;
    border: 4px solid #FFFFFF;
    border-radius: 23px 23px 23px 23px;
    margin-top: 90px;
}
.carousel-control.right {
	right: -12px;
}
/* The indicators */
.carousel-indicators {
	right: 50%;
	top: auto;
	bottom: -10px;
	margin-right: -19px;
}
/* The colour of the indicators */
.carousel-indicators li {
	background: #cecece;
}
.carousel-indicators .active {
background: #428bca;
}
#cbox{
	font-family: 'Tekton Pro';
}
#detaildiv{
	margin-left: 30px;
	width:1100px;
	height: 450px;
}
#infoline{
	width:500px;
	background-color: silver;
	height:2px;
	border-style: hidden;
	margin-right: 47px;
}
#binfo1{
	width:500px;
	margin-left:50px;
	margin-top:30px;
	float: right;
}
#binfo1 table{
	width: 550px;
	padding-top:20px; 
	
	font-family: "나눔바른고딕";
}
#binfo2 table{
	width: 550px;
	font-family: "나눔바른고딕";
}
#giftyconInfo{
	width:1100px;
	height:300px;
	border: 1px solid black;
}
#giftyconInfo img{
	width: 300px;
	height: 280px;
	float:left;
}
#giftyconInfo table{
	margin-top: 50px;
}
#th{
	width:400px;
	text-align:center;
	font-size: 17px;
	font-family: "나눔바른고딕";
}
#td{
	width:400px;
	text-align:center;
	font-family: "나눔바른고딕";
	font-size: 30px;
}
#num{
	margin-top:50px;
	margin-bottom:20px;
	width:1100px;
	height: 50px;
	background-color: #4C4C4C;
	color: white;
	font-family: "나눔바른고딕";
	text-align: left;
	padding-left:15px;
	padding-top:8px;
	font-size:20px;
	font-weight: bold;
}
#phoneInfo{
	text-align: left;
	font-family: "나눔바른고딕";
}
.reset{
	float: right; 
	margin-right:10px; 
	background-color:white; 
	border: 2px solid #4C4C4C;
	border-radius: 3px;
	font-size: 17px;
	width:60px;
	text-align: center;
}
.reset:HOVER {
	text-decoration: none;
	cursor: pointer;
}
.search{ 
	margin-right:10px; 
	background-color:white; 
	border: 2px solid #CC3D3D;
	border-radius: 3px;
	font-size: 17px;
	padding-left:10px;
	padding-right:10px;
	padding-top:3px;
	padding-bottom:3px;
	text-align: center;
}
.search:HOVER {
	text-decoration: none;
	cursor: pointer;
}
</style>
<body>
	<h1 style="text-align: center;"><a id="cbox" style="font-size: 50px; font-weight:bold; color: firebrick;" href="Index.jsp">Charie's BOX</a></h1>
	<div class="luncher">
		<ul>
			<li></li>
			<li>
				<a class="basket" href="#"><span class="glyphicon glyphicon-shopping-cart"></span>장바구니</a>
			</li>
			<li style="padding-right:10px;">
				<a class="login" href="./joinus/login.jsp"><span class="glyphicon glyphicon-off"></span>로그인</a>
			</li>
		</ul>
	</div>
	<nav class="navbar navbar">
	<div class="container-fluid" style="margin-bottom: 15px;">
		<ul class="nav navbar-nav" style="margin-top: 2px;">
			<li class="dropdown" style="border-left: none;"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#">영화 </a>
				<ul class="dropdown-menu" id="menu">
					<li><a href="#">Page 1-1</a></li>
					<li><a href="#">Page 1-2</a></li>
					<li><a href="#">Page 1-3</a></li>
				</ul></li>
			<li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">예매</a>
				<ul class="dropdown-menu">
					<li><a href="#">Page 1-1</a></li>
					<li><a href="#">Page 1-2</a></li>
					<li><a href="#">Page 1-3</a></li>
				</ul></li>
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#">극장</a>
				<ul class="dropdown-menu">
					<li><a href="#">Page 1-1</a></li>
					<li><a href="#">Page 1-2</a></li>
					<li><a href="#">Page 1-3</a></li>
				</ul></li>
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#">스토어</a>
				<ul class="dropdown-menu">
					<li><a href="#">Page 1-1</a></li>
					<li><a href="#">Page 1-2</a></li>
					<li><a href="#">Page 1-3</a></li>
				</ul></li>
		</ul>
	</div>
	</nav>
	<!-- 영화 순위 -->
	<hr>
	<!-- <h3 style="font-size: 30px; text-align: center; padding-top: 20px;"><img src="http://img.cgv.co.kr/R2014/images/title/h4_menu.png"></h3> -->
	<div style="height: 388px; text-align: center;">
		<div class="top-brands">
		<div class="container">
			<div style="">
				<h3 style="text-align: left; padding-left: 10px;">주문정보입력</h3>
			</div>
		<hr style="margin-top:15px; width: 1150px; font-weight: 2px; ">
		<div class="agile_top_brands_grids" id="detaildiv">
			<div  id="num">
				<p>01 상품정보</p>
			</div>
			<div id="giftyconInfo" >
				<img src="${giftycon.image }">
				<table>
					<tr><th id="th">상품</th><th id="th">판매가</th></tr>
				</table>
				<hr style="width: 700px; border-color:#BDBDBD;">
				<table>
					<tr><td id="td">${giftycon.giftyconName }<br><span style="font-size:14px">${content1 }</span></td><td id="td"><fmt:formatNumber value="${giftycon.price }"  groupingUsed="true"/>원</td></tr>
				</table>
			</div>
			<div  id="num">
				<p>02 연락처를 입력해주세요</p>
			</div>
			<div id="phoneInfo">
				<form action="giftyconBuyProc.do" method="post">
					<p style="font-size:18px; margin-left: 10px; font-weight: bold;">구매하는 분</p>
					<p style="font-size:16px; margin-left:10px;">이름 |&nbsp&nbsp&nbsp ${m.name }    &nbsp&nbsp &nbsp&nbsp&nbsp&nbsp &nbsp휴대폰 번호  |&nbsp &nbsp &nbsp${m.phone }
					</p>
					<hr style="border: 1px solid black;">
					<p style="font-size:18px; margin-left: 10px; font-weight: bold;">사용하는 분</p>
					<p style="font-size:16px; margin-left:10px;">1 &nbsp&nbsp&nbsp &nbsp휴대폰 번호  &nbsp
						<input type="text" class="rphone1" id="rphone1-1" style="width:100px; height: 30px;"> -
						<input type="text" class="rphone1" id="rphone1-2" style="width:100px; height: 30px;"> -
						<input type="text" class="rphone1" id="rphone1-3" style="width:100px; height: 30px;">
						<input type="hidden" class="rphone1"  id="rphone1" name="rphone">
						<a class="search" id="r1">조회</a>
						<input type="hidden" class="rphone" id="r1CK" value="nonCK">
						<a style="" class="reset" id="r1">초기화</a>
					</p>
					<hr style="border: 1px solid sliver;">
					<p style="font-size:18px; margin-left: 10px; font-weight: bold;">사용하는 분</p>
					<p style="font-size:16px; margin-left:10px;">2 &nbsp&nbsp&nbsp &nbsp휴대폰 번호  &nbsp
						<input type="text"  class="rphone2" id="rphone2-1" style="width:100px; height: 30px;"> -
						<input type="text" class="rphone2"  id="rphone2-2" style="width:100px; height: 30px;"> -
						<input type="text" class="rphone2"  id="rphone2-3" style="width:100px; height: 30px;">
						<input type="hidden" class="rphone2"  id="rphone2" name="rphone">
						<a class="search" id="r2">조회</a>
						<input type="hidden" class="rphone"  id="r2CK" value="nonCK">
						<a style="  "class="reset" id="r2">초기화</a>
					</p>
					<hr style="border: 1px solid sliver;">
					<p style="font-size:18px; margin-left: 10px; font-weight: bold;">사용하는 분</p>
					<p style="font-size:16px; margin-left:10px;">3 &nbsp&nbsp&nbsp &nbsp휴대폰 번호  &nbsp
						<input type="text" class="rphone3"  id="rphone3-1" style="width:100px; height: 30px;"> -
						<input type="text" class="rphone3"  id="rphone3-2" style="width:100px; height: 30px;"> -
						<input type="text" class="rphone3"  id="rphone3-3" style="width:100px; height: 30px;">
						<input type="hidden" class="rphone3"  id="rphone3" name="rphone">
						<a class="search" id="r3">조회</a>
						<input type="hidden" class="rphone" id="r3CK" value="nonCK">
						<a style="  "class="reset" id="r3">초기화</a>
					</p>
					<hr style="border: 1px solid sliver;">
					<p style="font-size:18px; margin-left: 10px; font-weight: bold;">사용하는 분</p>
					<p style="font-size:16px; margin-left:10px;">4 &nbsp&nbsp&nbsp &nbsp휴대폰 번호  &nbsp
						<input type="text" class="rphone4"  id="rphone4-1" style="width:100px; height: 30px;"> -
						<input type="text" class="rphone4"  id="rphone4-2" style="width:100px; height: 30px;"> -
						<input type="text" class="rphone4"  id="rphone4-3" style="width:100px; height: 30px;">
						<input type="hidden" class="rphone4"  id="rphone4" name="rphone">
						<a class="search" id="r4">조회</a>
						<input type="hidden" class="rphone" id="r4CK" value="nonCK">
						<a style="  "class="reset" id="r4">초기화</a>
					</p>
					<hr style="border: 1px solid sliver;">
					<p style="font-size:18px; margin-left: 10px; font-weight: bold;">사용하는 분</p>
					<p style="font-size:16px; margin-left:10px;">5 &nbsp&nbsp&nbsp &nbsp휴대폰 번호  &nbsp
						<input type="text" class="rphone5"  id="rphone5-1" style="width:100px; height: 30px;"> -
						<input type="text"  class="rphone5" id="rphone5-2" style="width:100px; height: 30px;"> -
						<input type="text"  class="rphone5" id="rphone5-3" style="width:100px; height: 30px;">
						<input type="hidden" class="rphone5" id="rphone5" name="rphone">
						<a class="search"  class="rphone5" id="r5">조회</a>
						<input type="hidden" class="rphone" id="r5CK" value="nonCK">
						<a style=""class="reset" id="r5">초기화</a>
					</p>
					<hr style="border: 1px solid black;">

				<p style="float: right; font-size:20px;">최종 결제 금액&nbsp&nbsp<span style="font-weight: bold; color:#4C4C4C;"><span id="amount1">0</span> X <span id="price">${giftycon.price }</span> = <span id="total1">0</span>원</span></p>
				<br>
				<br>
				<input type="hidden" name="giftyconCode" value="${giftycon.giftyconCode }">
				<input type="hidden" name="cardNum" id="cardNum">
				<input type="hidden" name="total" id="total">
				<input type="hidden" name="amount" id="amount">
				<input id="submit" style="float: right; font-size:18px; margin-right: 10px; width:100px;" type="submit" class='btn btn-danger add-to-cart' value="결제하기">
				</form>
			
			</div>
		</div>
		<hr>
		</div>
		</div>
	</div>	
	
</body>
</html>