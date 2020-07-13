<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../include/include.jsp"%> 
<!DOCTYPE html>
<html>
<head>
	<title>학생 테이블 </title>
</head>
<style type="text/css">
	


	table {
		width : 500px;
		height: 80px;
		margin: auto; 
	}


	table, th, td {
		border : 1px solid black;
		text-align: center;
	}

</style>
<body>
	<div class="page-content-wrapper">
	<!-- BEGIN CONTENT BODY -->
	<div class="page-content">
		<div class="page-head">
		<!-- BEGIN PAGE TITLE -->
			<div class="page-title">
			<h1>
				<span id="title"></span>
				<small id="titleSmall"></small>
			</h1>
			</div>
		<!-- END PAGE TITLE -->
		</div>
		<div class="col-lg-10 well" style="width: 500px; margin: auto;">
			<div class="row">
			<form id="excelUploadForm" name="excelUploadForm" enctype="multipart/form-data" method="post"  >
				
				<input id="excelFile" type="file" name="excelFile" /></input>
					
				<button type="button" id="excelUp" onclick="check()">등록</button>
			</form>
			</div>
		</div>
	<!-- END container -->
	</div>
	<!-- END CONTENT BODY -->
</div>
		
	<table >
		<tr >
			<th>번호</th>
			<th>이름</th>
			<th>학년</th>
			<th>생일</th>
			<th>학교</th>
		</tr>
		<c:forEach items="${list}" var ="list" >	
		<tr >
			<th>${list.snum}</th>
			<th>${list.sname}</th>
			<th>${list.sgrade}</th>
			<th>${list.sbirth} </th>
			<th>${list.school}</th>
		</tr>
		</c:forEach>

	</table>

</body>
<script src="http://malsup.github.com/jquery.form.js"></script>
<script type="text/javascript">




function check() {
	var form = $("#excelUploadForm")[0];
	 
    var data = new FormData(form);
    $.ajax({
       enctype:"multipart/form-data",
       method:"POST",
       url: '${path}/excelupload',
       processData: false,   
       contentType: false,
       cache: false,
       data: data,
       success: function(result){  
           alert("업로드 성공!!");
       }
    });


}







</script>	
</html>