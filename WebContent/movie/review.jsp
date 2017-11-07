<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<style type="text/css">

</style>
<link rel="stylesheet" href="../css/main.css">
<script type="text/javascript">
var i=0;
 $(function(){
  $('#title').click(function(){
   var value=$(this).attr("value");
   if(i==0){
    $('#m'+value).show();
    i=1;
   }else{
    $('#m'+value).hide();
    i=0;
   }
  });
 });
</script>
</head>
<body>  

	<jsp:include page="MovieDetail.jsp" flush="false"/>	
		
	<div class="container">
	
		<hr>
		<h3>회원리뷰<small>&nbsp;&nbsp;&nbsp;review</small><span><a href="reviewReg.do" class="btn btn-default pull-right">리뷰쓰기</a></span></h3>
		<br>
		<div class="panel panel-primary" style="border-color: white;">
			<c:forEach var="r" items="rList">			
			<div class="panel-body">
				<div class="media">
					<div class="media-head">
						<h4 class="media-heading" id="title" value="description" style="cursor: pointer">영화 한 편 씹어먹어 볼까~&nbsp;<span class="badge">New</span></h4></p>
						<p>평점 : <img src="../image/star_score_03.png">&nbsp; | &nbsp;id&nbsp; | &nbsp;2017-11-04&nbsp; | &nbsp;추천&nbsp; | &nbsp;댓글</p>
						
					</div>				
					<div class="media-left">
						<!-- <img class="media-object" src="../image/choo.jpg" style="width: 150px; height: 150px"> -->
					</div>
					<div class="media-body" id="mdescription" style="display:none">
						
						<p>하루에 많은 시간을 투자하기 어려운 직장인들에게도하루 30분씩이라도 집중해서 영화를 가지고 공부하라고 조언하고 있답니다.</p>
						
					</div>
				</div>
			</div>
			</c:forEach>
		</div>
	</div>
	
</body>
</html>