<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>科室添加</title>
	<link rel="stylesheet" type="text/css"href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	
	<script type="text/javascript">
	</script>
	</head>
	<body>
		<form class="form-inline" role="form" action="${pageContext.request.contextPath}/admin/addDepartment" style="margin-top: 30px; margin-left: 30px" method="post">
			<div class="form-group">
				<label>科室名:</label> <input type="text" class="form-control" id="name"
					name="name">
			</div>
			<button type="submit" class="btn btn-default" id="add">添加</button>
		</form>
		<table id="mytab" class="table table-hover"></table>
	
	</body>
</html>