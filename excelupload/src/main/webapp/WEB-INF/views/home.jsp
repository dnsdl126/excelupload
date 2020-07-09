<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
						<label>엑셀업로드 (업로드하고 디비에 INSERT)</label>
						<input id="excel" name="excel" class="file" type="file" multiple data-show-upload="false" data-show-caption="true"></input>
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
		<tr >
			<th>02</th>
			<th>홍길동</th>
			<th>3학년</th>
			<th>930126</th>
			<th>무민초등학교</th>
		</tr>

	</table>

</body>
<script type="text/javascript">

function check()


</script>	
</html>