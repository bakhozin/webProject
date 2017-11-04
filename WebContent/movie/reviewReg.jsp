<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<style type="text/css">

</style>
<script type="text/javascript">
	var i=0;
	$(function(){
	 $('.gpa').click(function(){
	  var value=$(this).attr("value");
	  $('#star').attr("src","../image/star_score_"+value+'.png');
	 });
	});
</script>
</head>
<body>

<div class="container">

<h3>Review<small>register</small></h3>
<hr>
<table class="table table-bordered">
    <thead>
    </thead>
    <tbody>
        <form action="noticeReg.do" method="post" enctype="multipart/form-data">
            <tr>
                <th>제목: </th>
                <td><input type="text" placeholder="제목을 입력하세요. " name="title" class="form-control"/></td>
            </tr>
			<tr>
				<th>평점:</th>
                <td>
                <select name="gpa" class="form-control pull-left" style="width: 200px;"> 
	                <option class="gpa" value="1">1</option> 
	                <option class="gpa" value="2">2</option> 
	                <option class="gpa" value="3">3</option> 
	                <option class="gpa" value="4">4</option> 
	                <option class="gpa" value="5">5</option> 
	                <option class="gpa" value="6">6</option> 
	                <option class="gpa" value="7">7</option> 
	                <option class="gpa" value="8">8</option> 
	                <option class="gpa" value="9">9</option> 
	                <option class="gpa" value="10">10</option> 
                </select>
		             &nbsp;&nbsp;&nbsp;&nbsp;<img id="star">
				</td>
            </tr>
            <tr>
                <th>내용: </th>
                <td><textarea cols="10" placeholder="내용을 입력하세요. " name="content" class="form-control" style="height:200px;"></textarea></td>
            </tr>
            <tr>
                <th>첨부파일: </th>
                <td><input type="file" placeholder="파일을 선택하세요. " name="file" class="form-control"/></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="button" value="취소하기" class="btn btn-default pull-right" onclick="javascript:location.href='MovieDetail.do"/>                                             
                    <input type="submit" value="등록" onclick="sendData()" class="btn btn-default pull-right"/>
                </td>
            </tr>
        </form>
    </tbody>
</table>
</div>
</div>
	
</body>
</html>