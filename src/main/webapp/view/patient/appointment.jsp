<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>预约挂号</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap-select.min.css" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap-select.min.js"></script>
	<script type="text/javascript">
	$(function() {
		//异步获取可是列表并动态填充select
		$.ajax({
            url: "/department/loadDepartment",
            dataType: "json",
            success: function (data) {
            	$('#selectDepartment').append("<option disabled>请选择</option>");
                for (var i = 0; i < data.length; i++) {
                    $('#selectDepartment').append("<option value=" + data[i].departmentNo + ">" + data[i].departmentName + "</option>");
                    $('#selectDepartment').selectpicker('refresh');//必须要有
                }
            }
        });
		$('#selectDepartment').change(function() {
			$.ajax({
	            url: "/doctor/loadDoctor",
	            dataType: "json",
	            data: {departmentNo: $('#selectDepartment').val()},
	            success: function (data) {
	                for (var i = 0; i < data.length; i++) {
	                    $('#selectDepartment').append("<option value=" + data[i].doctorNo + ">" + data[i].doctorName + "</option>");
	                    $('#selectDepartment').selectpicker('refresh');//必须要有
	                }
	            }
	        });
		});
	});
</script>
</head>
<body>
	<select id="selectDepartment" class="selectpicker" title="请选择"></select>
	<select id="selectDoctor" class="selectpicker" title="请选择"></select>
</body>
</html>