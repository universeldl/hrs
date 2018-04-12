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
	<link href="${pageContext.request.contextPath}/css/bootstrapValidator.min.css" rel="stylesheet" type="text/css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrapValidator.min.js"></script>
	<title>用户登录</title>
	
	<style type="text/css">
		.form-control-xxx {
		    width:200px;
		    display:inline;
		}
	</style>
	
	<script type="text/javascript">
		$(function() {
			$("#loginForm").bootstrapValidator({
				message: 'This value is not valid',
				feedbackIcons: {
		            valid: 'glyphicon glyphicon-ok',
		            invalid: 'glyphicon glyphicon-remove',
		            validating: 'glyphicon glyphicon-refresh'
				},
				fields: {
					id: {
						validators: {
							notEmpty: {
								message: '编号不能为空'
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
					verificationCode: {
						validators: {
							notEmpty: {
								message: '密码不能为空'
							},
							stringLength: {
								min: 4,
								max: 4,
								message: ' '
							}
						}
					}
				}
			});
		});
	</script>
</head>
<body class="templatemo-bg-gray" style="background-image: url('images/login_background.jpg');background-size: 100%; background-repeat:no-repeat; background-attachment: fixed;">
	<div class="container">
		<div class="col-md-12">
			<h1 class="margin-bottom-15">用户登录</h1>
			<form id="loginForm" class="form-horizontal templatemo-container templatemo-login-form-1 margin-bottom-30" role="form" action="${pageContext.request.contextPath}/login" method="post">				
		        <div class="form-group">
		          <div class="col-xs-12">		            
		            <div class="control-wrapper">
		            	<label for="id" class="control-label fa-label"><i class="fa fa-user fa-medium"></i></label>
		            	<input type="text" class="form-control" id="id" name="id" placeholder="编号……">
		            </div>		            	            
		          </div>              
		        </div>
		        <div class="form-group">
		          <div class="col-md-12">
		          	<div class="control-wrapper">
		            	<label for="password" class="control-label fa-label"><i class="fa fa-lock fa-medium"></i></label>
		            	<input type="password" class="form-control" id="password" name="password" placeholder="密码……">
		            </div>
		          </div>
		        </div>
		        <div class="form-group">
		          <div class="">
		          	<div class="control-wrapper">
		            	<label for="type" class="control-label fa-label" style="margin-left: 20px">账户类型：</label>
		            	<select id="type" name="type" class="form-control" style="width: 100px;margin-left: 70px">
		            		<option value="0" selected>医生</option>
		            		<option value="1">管理员</option>
		            		<option value="2">病人</option>
		            	</select>
		            </div>
		          </div>
		        </div>
		        <div class="form-group">
		          <div class="col-md-12">
		          	<div class="control-wrapper">
		            	<label for="verificationCode" class="control-label fa-label" style="margin-left: 10px">验证码：</label>
		            	<input type="text" class="form-control form-control-xxx" id="verificationCode" name="verificationCode" style="width: 100px;margin-left: 55px"/>
		            	<img id="verifyCode" src="${pageContext.request.contextPath}/verify/generateVerify" style="margin-left: 10px;margin-bottom: 2px" width="80" height="30"/>
		            </div>
		          </div>
		        </div>
		        <div class="form-group">
		          <div class="col-md-12">
	             	<div class="checkbox control-wrapper">
	                	<label for="remFlag">
	                  		<input id="remFlag" name="remFlag" type="checkbox" onclick="remember();"> 记住我
                		</label>
	              	</div>
		          </div>
		        </div>
		        <div class="form-group">
		          <div class="col-md-12">
		          	<div class="control-wrapper">
		          		<input type="submit" value="登录" class="btn btn-info">
		          		<input type="reset" value="重置" class="btn btn-info">
		          		<a href="${pageContext.request.contextPath}/patient/toRegistration" class="text-right pull-right">用户注册</a>
		          		<a class="text-right pull-right" href="#">&nbsp|&nbsp</a>
		          		<a href="forgot-password.html" class="text-right pull-right">忘记密码?</a>
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
		$(document).ready(function(){
	        //记住密码功能
	        var str = getCookie("hrs_cookie");
	        str = str.substring(1,str.length-1);
	        var id = str.split(",")[0];
	        var password = str.split(",")[1];
	        var type = str.split(",")[2];
	        //自动填充用户名和密码
	        $("#id").val(id);
	        $("#password").val(password);
	        var i = parseInt(type);
	        $("#type").val(type);
	        if(id != null && id != ""){
	        	$("#remFlag").attr("checked","checked");
	        }
	        
	        $("#verifyCode").mouseover(
					function() {//为验证码绑定onMouseOver事件
						//鼠标指针变成手掌
						//this是document对象,需要转换成jquery对象
						$(this).css("cursor", "pointer").prop(
								"title", "换一张");
					}).click(
					function() {//绑定点击事件,更改验证码
						$(this).attr(
								"src",
								"${pageContext.request.contextPath}/verify/generateVerify?random="
										+ Math.random())
					});
		});
		
		//获取cookie
		function getCookie(cname) {
		    var name = cname + "=";
		    var ca = document.cookie.split(';');
		    for(var i=0; i<ca.length; i++) {
		        var c = ca[i];
		        while (c.charAt(0)==' ') c = c.substring(1);
		        if (c.indexOf(name) != -1) return c.substring(name.length, c.length);
		    }
		    return "";
		}
		
		//记住密码功能
		function remember(){
		    var remFlag = $("input[type='checkbox']").is(':checked');
		    if(remFlag==true){ //如果选中设置remFlag为1
		        //cookie存用户名和密码,回显的是真实的用户名和密码,存在安全问题.
		        var conFlag = confirm("为了您的账号安全，确认要在公共场合记住密码吗？");
		        if(conFlag){ //确认标志
		            $("#remFlag").val("1");
		        }else{
		            $("input[type='checkbox']").removeAttr('checked');
		            $("#remFlag").val("0");
		        }
		    }else{ //如果没选中设置remFlag为""
		        $("#remFlag").val("0");
		    }
		}
	</script>
</body>
</html>