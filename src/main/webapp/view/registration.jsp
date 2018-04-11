<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta name="keywords" content="" />
	<meta name="description" content="" />
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	
	<link href="${pageContext.request.contextPath}/css/font-awesome.min.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/templatemo_style.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/css/bootstrap-datetimepicker.min.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/bootstrapValidator.min.css" rel="stylesheet" type="text/css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/moment-with-locales.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap-datetimepicker.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrapValidator.min.js"></script>
	<title>病人注册</title>
	
	<style type="text/css">
		.form-control-xxx {
		    width:200px;
		    display:inline;
		}
	</style>
	
	<script type="text/javascript">
		$(function() {
			$("#registerForm").bootstrapValidator({
				message: 'This value is not valid',
				feedbackIcons: {
		            valid: 'glyphicon glyphicon-ok',
		            invalid: 'glyphicon glyphicon-remove',
		            validating: 'glyphicon glyphicon-refresh'
				},
				fields: {
					name: {
						validators: {
							notEmpty: {
								message: '姓名不能为空'
							},
							stringLength: {
								mix: 2
							}
						}
					},
					password: {
						validators: {
							notEmpty: {
								message: '密码不能为空'
							}
						}
					},
					confirmPassword: {
						validators: {
							notEmpty: {
								message: '密码不能为空'
							},
							identical: {
								field: 'password',
								message: '确认密码与输入的密码不相同'
							}
						}
					},
					birth: {
						validators: {
							notEmpty: {
								message: '出生年月日不能为空'
							}
						}
					},
					phone: {
						validators: {
							notEmpty: {
								message: '手机号码不能为空'
							},
							digit: {},
		                    phone: {
		                        country: 'CN'
		                    }
						}
					}
				}
			});
		});
	</script>
</head>
<body class="templatemo-bg-gray" style="background-image: url('../images/login_background.jpg');background-size: 100%; background-repeat:no-repeat; background-attachment: fixed;">
	<div class="container">
		<div class="col-xs-12">
			<h1 class="margin-bottom-15">病人注册</h1>
			<form id="registerForm" class="form-horizontal templatemo-container templatemo-login-form-1 margin-bottom-30" role="form" action="${pageContext.request.contextPath}/patient/registration" method="post">				
		        <div class="form-group">
		          <div class="col-xs-12">		            
		            <div class="control-wrapper">
		            	<label for="name" class="control-label fa-label"><i class="fa fa-user fa-medium"></i></label>
		            	<input type="text" class="form-control" id="name" name="name" placeholder="姓名">
		            </div>		            	            
		          </div>              
		        </div>
		        <div class="form-group">
		          <div class="col-xs-12">
		          	<div class="control-wrapper">
		            	<label for="password" class="control-label fa-label"><i class="fa fa-lock fa-medium"></i></label>
		            	<input type="password" class="form-control" id="password" name="password" placeholder="密码">
		            </div>
		          </div>
		        </div>
		        <div class="form-group">
		          <div class="col-xs-12">
		          	<div class="control-wrapper">
		            	<label for="confirmPassword" class="control-label fa-label"><i class="fa fa-lock fa-medium"></i></label>
		            	<input type="password" class="form-control" id="confirmPassword" name="confirmPassword" placeholder="确认密码">
		            </div>
		          </div>
		        </div>
		        <div class="form-group">
		          <div class="col-xs-12">
		          	<div class="control-wrapper">
						<div class='input-group date' id='datetimepicker'>
					        <span class="input-group-addon">
					            <span class="fa fa-calendar"></span>
					        </span>
					        <input type='text' class="form-control" id="birth" name="birth" placeholder="出生年月日" />
					    </div>
		            </div>
		          </div>
		        </div>
		        <div class="form-group">
		          <div class="col-xs-12">
		          	<div class="control-wrapper">
		            	<label for="phone" class="control-label fa-label"><i class="fa fa-phone fa-medium"></i></label>
		            	<input type="tel" class="form-control" id="phone" name="phone" placeholder="手机号">
		            </div>
		          </div>
		        </div>
		        <div class="form-group">
		          <div class="">
		          	<div class="control-wrapper">
		            	<label for="gender" class="control-label fa-label" style="margin-left: 20px">性别：</label>
		            	<select id="gender" name="gender" class="form-control" style="width: 100px;margin-left: 70px">
		            		<option value="1" selected>男</option>
		            		<option value="0">女</option>
		            	</select>
		            </div>
		          </div>
		        </div>
		        <div class="form-group">
		          <div class="col-md-12">
		          	<div class="control-wrapper">
		          		<input type="submit" value="注册" class="btn btn-info">
		          		<input type="reset" value="重置" class="btn btn-info">
		          	</div>
		          </div>
		        </div>
		        <hr>
		      </form>
		      <div class="text-center">
		      	<label>&copy XXX</label>	
		      </div>
		</div>
	</div>
	<script type="text/javascript">
		$(function () {
	        $('#datetimepicker').datetimepicker({
	            format: 'YYYY-MM-DD',//日期格式化，只显示日期
	            locale: 'zh-CN'
	        });
	    });
	</script> 
</body>
</html>