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
.messege{
	width:1000px;
	margin-top: 30px;
	margin-left: 40px;
	margin-bottom: 20px;
	font-family:'나눔바른고딕';
	text-align: center;
}
.messege span{
	font-size: 17px;
	font-weight: bold;
}
#res{
	width:960px;
	margin-top: 30px;
	margin-left: 80px;
	margin-bottom: 20px;
	font-family:'나눔바른고딕';
	border-top: 1px solid #79ABFF;
	border-bottom: 1px solid silver;
	border-collapse : collapse;	
}
#res th{
	height: 50px;
	border: thin;
	background-color: #D9E5FF;
	text-align: left;
	padding-left: 20px;
}
#res td{
	border: 1px solid #D9E5FF;
	border-bottom: 1px solid #79ABFF;
	text-align: right;
	padding-right: 50px;
	padding-top: 10px;
	padding-bottom: 10px;
	font-weight: bord;
}
#res span{
	font-size: 30px;
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
	padding-left:15px;
	text-align:center;
	font-family: "나눔바른고딕";
	font-size: 20px;
}
#num{
	margin-top:50px;
	margin-bottom:20px;
	width:1100px;
	height: 50px;
	background-color: #A81919;
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
				<h3 style="text-align: left; padding-left: 10px;">구매완료</h3>
			</div>
		<hr style="margin-top:15px; width: 1150px; font-weight: 2px; ">
		<div class="buyform">
				<div class="messege">
					<h1>구매가 성공적으로 접수되었습니다.</h1>
					<p><span>${m.name }</span> 고객님 감사합니다.</p>
					<p>구매하신 기프티콘은 마이페이지 > My Giftycon에서 확인 가능합니다.</p>
				</div>		
				<hr id="bline">		
				<div class="memberinfo" style="margin-left: 20px;">
					<div  id="num">
						<p>01 결제정보</p>
					</div>
					<div id="giftyconInfo" >
						<img src="${giftycon.image }">
						<table>
							<tr><th id="th">상품</th><th id="th">수량</th><th id="th">결제금액</th></tr>
						</table>
						<hr style="width: 700px; border-color:#BDBDBD;">
						<table>
							<tr><td id="td">${giftycon.giftyconName }<br></td><td id="td">${amount }</td><td id="td"><fmt:formatNumber value="${total }"  groupingUsed="true"/>원</td></tr>
						</table>
					</div>
				</div>					
				<hr id="bline">	
				<div class="memberinfo" style="margin-left: 20px;">
					<div  id="num">
						<p>02 주문정보</p>
					</div>
					<div id="phoneInfo">
						<p style="font-size:18px; margin-left: 10px; font-weight: bold;">구매하는 분</p>
						<p style="font-size:16px; margin-left:10px;">이름 &nbsp&nbsp&nbsp&nbsp &nbsp ${m.name }    &nbsp&nbsp &nbsp|&nbsp&nbsp&nbsp &nbsp  &nbsp
							<%-- <input type="hidden" id="phone" value=${m.phone } name="buyPhone"> --%>
						</p>
						<hr style="border: 1px solid black;">
						<p style="font-size:18px; margin-left: 10px; font-weight: bold;">사용하는 분</p>
						<c:forEach var="ga" items="${list }" >
							<p style="font-size:16px; margin-left:10px;">1 &nbsp&nbsp&nbsp &nbsp휴대폰 번호  &nbsp${ga.recipient }</p>
							<hr style="border: 1px solid sliver;">
						</c:forEach>
						<hr style="border: 1px solid black;">
					</div>
					<br>
					<a href="../member/main.do">홈으로</a>
					<br><br><br>
				</div>			
			</div>		
		</div>
		</div>
	</div>	
	
</body>
</html>