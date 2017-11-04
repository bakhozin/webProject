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
				<h3 style="text-align: left; padding-left: 10px;">스낵바</h3>
			</div>
		<hr style="margin-top:15px; width: 1150px; font-weight: 2px; ">
		<div class="agile_top_brands_grids" id="detaildiv">
			<div id="bleft" style="float: left;">
				<img alt="" src="../image/choo.jpg	">
			</div>
			<div id="binfo1" style="float: left;">
				<table>
					<tr><td><h3 style="text-align: left;">${giftycon.giftyconName }</h3></td></tr>						
				</table>
				<hr id="infoline">
				<table>
					<tr><td style="width: 50px;"><p style="padding-left: 23px; float : left; text-align: left; padding-top:5px; ">판매가</p></td><td style="width: 100px;" ><p style="padding-right: 40px;">${giftycon.price }</p></td></tr>	
				</table>
				<hr id="dd" style=" border-style: dashed;">
				<table>
					<tr><td style="width: 50px;"><p style="padding-left: 20px; float: left; text-align: left; ">상품설명</p></td><td style="width: 100px;"><p style="padding-right: 40px;">${content1}<br>${content2 }</p></td></tr>
					<tr><td style="width: 50px;"><p style="padding-left: 20px; float : left; text-align: left;">유효기간</p></td><td style="width: 100px;"><p style="padding-right: 40px;">구매 후 6개월 이내</p></td></tr>	
					<tr><td style="width: 50px;"><p style="padding-left: 20px; float : left; text-align: left;">상품교환</p></td><td style="width: 100px;"><p style="padding-right: 40px;">관람 예정 극장의 매점</p></td></tr>						
				</table>
				<hr id="infoline">
				<a href='../shop/shopMain.do?type=${giftycon.giftyconCode }' class='btn btn-danger add-to-cart'data-target='#mcart' data-toggle='' style='margin-left:10px; float: left;'> <i class='fa fa-shopping-cart'></i>목록으로</a>
				<a href='#' class='btn btn-danger add-to-cart'data-target='#mcart' data-toggle='' style='margin-left:10px; float: right; margin-right: 7px; '> <i class='fa fa-shopping-cart'></i>Now Buy</a>
				<a href='#' class='btn btn-danger add-to-cart'data-target='#mcart' data-toggle='' style='margin-left:10px; float: right; '> <i class='fa fa-shopping-cart'></i>&nbsp&nbsp&nbspGift&nbsp&nbsp&nbsp</a>
			</div>	

		</div>
		<hr>
		<ul>
			<li style="list-style-type: dosc"><span style="float: left;">기프트콘으로는 매점상품 및 영화관람권을 구매/이용하실 수 있습니다.</span></li>
			<li style="list-style-type: dosc">
				<span style="float: left; color:#DB0000;">구매 후 전송 받으신 기프트콘 중,</span><br> 
				<span style="float: left;"><span style="font-weight:bold;">매점상품:</span> 매점상품은 각 영화관의 매점에서 실제 상품으로 교환하실 수 있습니다.</span><br>
				<span style="float: left;">(각 영화관 매점에서 기프트콘 제시 > 해당 매점 제품으로 교환)</span><br>
				<span style="float: left;">콤보 中 팝콘을 고소팝콘 이외의 팝콘으로 바꿀 경우, 추가 비용이 발생합니다.</span><br>
				<span style="float: left;"><span style="font-weight:bold;">영화관람권:</span> 영화관람권은 홈페이지,모바일, 또는 영화관 매표소를 통해 영화를 예매하실 수 있습니다.</span><br>
				<span style="float: left;">(홈페이지 빠른예매 > 결제 수단 > '할인/무료/포인트' 선택 > '기프트콘' 선택 > 기프트콘 번호 입력)</span><br>
			</li>
			<li style="list-style-type: dosc">
				<span style="float: left; color:#DB0000;">기프트콘 상품은 일부극장에서 사용이 불가능합니다.</span><br>
				<span style="float: left;">결제가 완료된 기프트콘 중 사용내역이 전혀 없으신 경우, ‘마이페이지 > My 구매정보 > 매점상품’ 에서 취소하실 수 있습니다. </span><br>
				<span style="float: left;">(단, 기프트콘 상품은 현금으로 환불은 불가능합니다.)</span><br>
			</li>
			<li style="list-style-type: dosc">
				<span style="float: left; color:#DB0000;">기프트콘은 부분 환불이 불가합니다.</span><br>
				<span style="float: left;">(예: 3개의 쿠폰을 한 번에 구매하신 경우, 3개 모두 취소만 가능하며, 사용하신 쿠폰이 있는 경우 미사용 쿠폰의 환불은 불가합니다.) </span><br>
				<span style="float: left;">기프트콘의 사용기한은 기프트콘 발송일로부터 6개월입니다.</span><br>
				<span style="float: left;">매점상품 기프트콘은 극장매점에서 기프트콘 사용 후 수령한 영수증으로 CJONE 적립이 가능합니다.</span><br>
			</li>
		</ul>
		</div>
		</div>
	</div>	
	
</body>
</html>