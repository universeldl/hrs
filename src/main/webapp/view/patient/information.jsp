<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人信息</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/beyond.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap-table.min.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/font-awesome.min.css">
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap-table.min.js"></script>
 	<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap-table-zh-CN.min.js"></script>
 	<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootbox.min.js"></script>
 	
 	<script type="text/javascript">
 	$(function() {
	    //行内编辑配置
	    $('#edit').click(function() {
	        $('#mytab .editable').editable('toggleDisabled');
	        var row = $("#mytab").bootstrapTable('getSelections');
	  		if(row.length == 1) {
	  			var doctorNo = '';
	  			$.each(row, function() {
	  				doctorNo = this.doctorNo;
				});
		        $.ajax({
	        		url: "${pageContext.request.contextPath}/admin/selectByDoctorNo",
	        		type: "post",
	        		data: "doctorNo="+doctorNo,    //如何拿到该行的depNo
	        		dataType: "json",
	        		async: true,
	        		success: function(data){
	        			$("input[name=doctorNo]").val(data.doctorNo);
	        			$("input[name=doctorName]").val(data.doctorName);
	        			$("input[name=doctorSex]").val(data.doctorSex);
	        			$("input[name=doctorBirth]").val(data.doctorBirth);
	        			$("input[name=doctorPhone]").val(data.doctorPhone);
	        			$("input[name=doctorDepartmentNo]").val(data.doctorDepartmentNo);
	        			$("input[name=doctorRegistrationFee]").val(data.doctorRegistrationFee);
	        	        //显示模态框
	        	        $("#myModal").modal("show");
	        		}
		        });
	  		}else {
	  			bootbox.alert({
	    			  size: "small",
	    			  message: "只能选择一个医生进行修改操作！",
	    		});
	  		}
	    }); 
 	});
	</script>
</head>
<body>
	<form class="form-horizontal" style="margin-top: 30px;">
		<div class="form-group">
			<label class="col-sm-2 control-label" style="width:150px">编号</label>
			<div class="col-sm-8">
				<p class="form-control-static">email@example.com</p>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label" style="width:150px">姓名</label>
			<div class="col-sm-8">
				<p class="form-control-static">email@example.com</p>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label" style="width:150px">性别</label>
			<div class="col-sm-10">
				<p class="form-control-static">email@example.com</p>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label" style="width:150px">出生年月日</label>
			<div class="col-sm-10">
				<p class="form-control-static">email@example.com</p>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label" style="width:150px">电话号码</label>
			<div class="col-sm-10">
				<p class="form-control-static">email@example.com</p>
			</div>
		</div>
	</form>
	<!-- 模态框 -->
   	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
	        <h4 class="modal-title" id="myModalLabel">医生个人信息</h4>
	      </div>
	      <div class="modal-body">
	        <form class="form-horizontal" role="form" action="${pageContext.request.contextPath}/admin/updateDoctor">
			  <div class="form-group">
			    <label for="doctorNo" class="col-sm-2 control-label">医生编号:</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" id="doctorNo" name="doctorNo" value="" disabled>
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="doctorName" class="col-sm-2 control-label">医生姓名:</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" id="doctorName" name="doctorName" value="">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="doctorSex" class="col-sm-2 control-label">医生性别:</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" id="doctorSex" name="doctorSex" value="">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="doctorBirth" class="col-sm-2 control-label">出生日期:</label>
			    <div class="col-sm-10">
			      <input type="date" class="form-control" id="doctorBirth" name="doctorBirth" value="">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="doctorPhone" class="col-sm-2 control-label">电话号码:</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" id="doctorPhone" name="doctorPhone" value="">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="doctorDepartmentNo" class="col-sm-2 control-label">所属部门:</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" id="doctorDepartmentNo" name="doctorDepartmentNo" value="">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="doctorRegistrationFee" class="col-sm-2 control-label">挂号费用:</label>
			    <div class="col-sm-10">
			      <input type="number" class="form-control" id="doctorRegistrationFee" name="doctorRegistrationFee" value="">
			    </div>
			  </div>
		      <div class="modal-footer">
		        <input type="submit" class="btn btn-primary" value="保存"/>
		        <input type="reset" class="btn btn-default" data-dismiss="modal" value="取消"/> 
		      </div>
			</form>
	      </div>
	    </div>
	  </div>
	</div>
	<!-- ending -->

</body>
</html>