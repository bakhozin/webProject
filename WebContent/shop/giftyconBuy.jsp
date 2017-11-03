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
			
			

		</div>
		<hr>
		
		</div>
		</div>
	</div>	
	
</body>
</html>