<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>医生录入</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
	<link href="${pageContext.request.contextPath}/css/bootstrapValidator.min.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/bootstrap-datetimepicker.min.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/font-awesome.min.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/templatemo_style.css" rel="stylesheet" type="text/css">
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrapValidator.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/moment-with-locales.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap-datetimepicker.min.js"></script>
	
	<script type="text/javascript">
		$(function() {
			$("#addDoctor").bootstrapValidator({
				message: 'This value is not valid',
				feedbackIcons: {
		            valid: 'glyphicon glyphicon-ok',
		            invalid: 'glyphicon glyphicon-remove',
		            validating: 'glyphicon glyphicon-refresh'
				},
				fields: {
					doctorName: {
						validators: {
							notEmpty: {
								message: '科室名不能为空'
							}
						}
					},
					doctorPassword: {
						validators: {
							notEmpty: {
								message: '密码不能为空'
							},
							stringLength: {
								min: 6,
								max: 16,
								message: '密码需要 6 至 16 个字符'
							}
						}
					},
					doctorPassword1: {
						validators: {
							notEmpty: {
								message: '密码不能为空'
							},
							identical: {
								field: 'doctorPassword',
								message: '确认密码与输入的密码不相同'
							}
						}
					},
					doctorBirth: {
						validators: {
							notEmpty: {
								message: '出生年月日不能为空'
							},
							date: {
								format: 'YYYY-MM-DD',
								message: '请输入\'YYYY-MM-DD\'格式的日期，或者使用日期选择器'
							}
						}
					},
					doctorHireTime: {
						validators: {
							notEmpty: {
								message: '入职日期不能为空'
							},
							date: {
								format: 'YYYY-MM-DD',
								message: '请输入\'YYYY-MM-DD\'格式的日期，或者使用日期选择器'
							}
						}
					}, 
					doctorPhone: {
						validators: {
							notEmpty: {
								message: '手机号码不能为空'
							},
							digit: {},
		                    phone: {
		                        country: 'CN',
		                        message: '请输入正确的手机号'
		                    }
						}
					},
					doctorRegistrationFee: {
						validators: {
							notEmpty: {
								message: '挂号收费价格不能为空'
							}
						}
					}
				}
			});
		});
	</script>
</head>
<body>
	<form id="addDoctor" class="form-horizontal" role="form" action="${pageContext.request.contextPath}/admin/addDoctor" style="margin-top: 30px; margin-left: 30px" method="post">
		<div class="form-group">
			<label>医生姓名:</label> <input type="text" class="form-control"id="doctorName" name="doctorName" style="width: 225px;">
		</div>
		<div class="form-group">
			<label>所属部门:</label>
			<select id="doctorDepartmentNo" name="doctorDepartmentNo"
				class="form-control" style="width: 225px;">
				<option value="D843" selected="selected">内科</option>
				<option value="D215">外科</option>
				<option value="D964">康复科</option>
				<option value="D700">眼科</option>
				<option value="D507">影像科</option>
				<option value="D858">骨科</option>
				<option value="D873">皮肤科</option>
				<option value="D886">急诊科</option>
				<option value="D053">肿瘤科</option>
				<option value="D572">营养科</option>
				<option value="D199">妇产科</option>
				<option value="D440">疼痛科</option>
				<option value="D576">耳鼻咽喉科</option>
				<option value="D035">药学门诊</option>
				<option value="D027">针灸科</option>
				<option value="D803">中医科</option>
				<option value="D602">感染科</option>
				<option value="D154">超声医学科</option>
				<option value="D145">口腔科</option>
				<option value="D778">儿科</option>
				<option value="D052">麻醉科</option>
				<option value="D982">心理科</option>
			</select>
		</div>
		<div class="form-group">
			<label>医生性别:</label> <select id="doctorSex" name="doctorSex"
				class="form-control" style="width: 225px">
				<option value="1" selected>男</option>
				<option value="0">女</option>
			</select>
		</div>
		<div class="form-group">
			<label>登录密码:</label> <input type="password" class="form-control"
				id="doctorPassword" name="doctorPassword" style="width: 225px;">
		</div>
		<div class="form-group">
			<label>确认密码:</label> <input type="password" class="form-control"
				id="doctorPassword1" name="doctorPassword1" style="width: 225px;">
		</div>
		<div class="form-group">
			<label>出生日期:</label>
			<div class='input-group date' id='birthDatetimepicker'
				style="width: 264px">
				<input type="text" class="form-control" id="doctorBirth"
					name="doctorBirth" value="" style="width: 225px;"> <span
					class="input-group-addon"> <span class="fa fa-calendar"></span>
				</span>
			</div>
		</div>
		<div class="form-group">
			<label>电话号码:</label> <input type="text" class="form-control"
				id="doctorPhone" name="doctorPhone" style="width: 225px;">
		</div>
		<div class="form-group">
			<label>挂号收费:</label> <input type="number" class="form-control"
				id="doctorRegistrationFee" name="doctorRegistrationFee"
				style="width: 225px;">
		</div>
		<div class="form-group">
			<label>入职日期:</label>
			<div class='input-group date' id='hireDatetimepicker'
				style="width: 264px">
				<input type="text" class="form-control" id="doctorHireTime"
					name="doctorHireTime" style="width: 225px;"> <span
					class="input-group-addon"> <span class="fa fa-calendar"></span>
				</span>
			</div>
		</div>
		<div class="form-group">
			<button type="submit" class="btn btn-default" id="add"
				style="margin-top: 10px">添加</button>
		</div>
	</form>
	<table id="mytab" class="table table-hover"></table>

	<script type="text/javascript">
	    $(function () {
	        $('#birthDatetimepicker').datetimepicker({
	            format: 'YYYY-MM-DD',//日期格式化，只显示日期
	            locale: 'zh-CN'      //中文化
	        });
	    });
    </script>
</body>
</html>