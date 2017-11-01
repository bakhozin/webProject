<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/latest/css/bootstrap.min.css">
<script src="//code.jquery.com/jquery.min.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/latest/js/bootstrap.min.js"></script>

<style>
  /* 사이드바 래퍼 스타일 */
  
  #page-wrapper {
    padding-left: 250px;
  }
  
  #sidebar-wrapper {
  	position:absolute;
    width: 250px;
    height: auto;
    margin-left: -250px;
    background: white;
    overflow-x: hidden;
    overflow-y: auto;
  }
  
  #page-content-wrapper {
    width: 100%;
    padding: 20px;
  }
  /* 사이드바 스타일 */
  
  .sidebar-nav {
    width: 250px;
    margin: 0;
    padding: 0;
    list-style: none;
  }
  
  .sidebar-nav li {
    text-indent: 1.5em;
    line-height: 2.8em;
  }
  
  .sidebar-nav li a {
/*     display:  ; */
    text-decoration: none;
    color: #999;
  }
  
  .sidebar-nav li a:hover {
    color: #fff;
    background: powderblue;
  }
  
  .sidebar-nav > .sidebar-brand {
    font-size: 1.3em;
    line-height: 3em;
  }

</style>
<div class="container">
	<div class="jumbotron">
		<div class="panel panel-primary">
			
			<div class="panel-body">
				<div class="media">
					<div class="media-left">
						<a href="https://www.musinsa.com/?m=news"><img class="media-object" src="../images/choo.jpg" alt="추신수" style="width:150px; height:200px;"></a>
					</div>
					<div class="media-body">
						<h2>&nbsp;추신수님&nbsp;&nbsp;&nbsp;<small>mid입력공간</small></h2>
						<hr>
						<h4>&nbsp;고객님은 일반입니다.</h4>
						<a href="#" class="btn btn-default">&nbsp;지난등급이력보기</a>
						<div style="float: right"><br><br><br><br></div>
					</div>
					<div class="media-right" style="border-left: 1px solid black;">
						<p>special Membership</p>		
					</div>
				</div>
				<hr>
				<div class="col-sm-4" style="border-right: 1px solid black;">
					<h2>myCoupon</h2>
				
				</div>
				<div class="col-sm-4" style="border-right: 1px solid black;">
					<h2>CJ ONE POINT</h2><span class="glyphicon glyphicon-plus">아</span>
				</div>
				<div class="col-sm-4">
				
				</div>
			</div>
		</div>			
	</div>	
</div>
<div class="container">
	<div class="col-sm-6">
<div id="page-wrapper">
  <!-- 사이드바 -->
  <div id="sidebar-wrapper">
    <ul class="sidebar-nav">
      <hr>
      <li class="sidebar-brand">
        <a href="#" style="color:black"><b>My CGV Home</b></a></li>
      <li><a href="#">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;나의 예매 내역</a></li>
      <hr>
        <li class="sidebar-brand"><a href="#" style="color:black"><b>관람권/할인쿠폰 관리</b></a></li>
      <li><a href="#">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;CGV 영화관람권</a></li>
      <li><a href="#">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;CGV 할인쿠폰</a></li>
      <li><a href="#">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;CGV 영화관람권</a></li>
      <hr>
        <li class="sidebar-brand"><a href="#" style="color:black"><b>티켓/팝콘 스토어</b></a></li>
      <li><a href="#">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;매점상품 기프티콘</a></li>
      <li><a href="#">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;영화관람권 기프티콘</a></li>
      <hr>
        <li class="sidebar-brand"><a href="#" style="color:black"><b>회원정보</b></a></li>
      <li><a href="#">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;개인정보 변경</a></li>
      <li><a href="#">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;회원탈퇴</a></li>
      <hr>
        <li class="sidebar-brand"><a href="#" style="color:black"><b>프로필 관리</b></a></li>
      
      <hr>
       <li class="sidebar-brand"><a href="#" style="color:black"><b>회원정보</b></a></li>
      <li><a href="#">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;개인정보 변경</a></li>
      <li><a href="#">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;회원탈퇴</a></li>
      <hr>
        <li class="sidebar-brand"><a href="#" style="color:black"><b>프로필 관리</b></a></li>
      
      <hr> <li class="sidebar-brand"><a href="#" style="color:black"><b>회원정보</b></a></li>
      <li><a href="#">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;개인정보 변경</a></li>
      <li><a href="#">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;회원탈퇴</a></li>
      <hr>
        <li class="sidebar-brand"><a href="#" style="color:black"><b>프로필 관리</b></a></li>
      
      <hr>
    </ul>
  </div>
  </div>
  <!-- /사이드바 -->

  <!-- 본문 -->
  <div class="col-sm-6" style="float: right;">
    <div class="container">
      <h1>작업변경해볼게.desktop</h1>
      <p>git test용 작업변경중이야.desktop</p>
    </div>
  </div>
  <!-- /본문 -->
</div>
</div>
</body>
</html>