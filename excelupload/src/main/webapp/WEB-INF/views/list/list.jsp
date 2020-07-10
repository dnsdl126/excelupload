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
			<form id="excelUpForm" method="post" action="" role="form" enctype="multipart/form-data">
				<div class="col-sm-12">
					<div class="row" id="regGoodsImgArea">
						<div class="col-sm-4">
							<input id="excel" class="file" type="file" multiple data-show-upload="false" data-show-caption="true"  ></input>
						</div>
					</div>
				</div>
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
<script type="text/javascript">



  function check(e) {

	  var fileInput = document.getElementById("excel"); //  input ajaxFile 이미지를 담음
	  var files = fileInput.files; // 배열로 여러가지 이미지를 담음
	  var file=files[0];  // 그중 첫번째만 가지고온다
	   	 	
	  var filefullname = fileInput.value; // 추가한 이미지의 이름 
	  var fileform = filefullname.slice(filefullname.indexOf(".") + 1).toLowerCase() // input에 이미지 파일만 업로드 하도록 확장자 파일을 가지고옴   
	   
	  
	  console.log(filefullname);
	  
	  
	    if (file == "" || file == null) {
	        alert("파일을 선택해주세요.");
	        return false;
	    } else if (filename != "xlsx" && filename != "xml") {
	        alert("엑셀 파일만 업로드 가능합니다.");
	        return false;
	    }

	    if (confirm("업로드 하시겠습니까?")) {
	        var options = {
	            success : function(data) {
	                alert("모든 데이터가 업로드 되었습니다.");

	            },
	            type : "POST"
	        };
	        $("#excelUploadForm").ajaxSubmit(options);

	    }
	  
	  
   
  }



</script>	
</html>