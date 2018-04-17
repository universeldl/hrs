<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	<meta name="viewport" content="width=device-width, initial-scale=1"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/beyond.css" />
	<title>导航</title>
</head>
<body>
	<!-- 导航 -->
	<div class="page-sidebar">
	    <ul class="nav panel-group sidebar-menu" id="nav_parent">
	    	<li>
			    <a href="#" target="frame">
			    	<span class="menu-text">预约</span>
			    </a>
		    </li>
		    <li>
			    <a href="#" target="frame">
			    	<span class="menu-text">就诊记录</span>
			    </a>
		    </li>
	 	</ul>
	</div>
	<div style="left: 250px;position: absolute;" name="div_auto" id="div_auto">
		<iframe name="frame" id="frame" scrolling="no" frameborder="0" style="padding: 0px; width: 1600px; height: 920px;">
			
		</iframe>
	</div>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	<script type="text/javascript">
		
		
	</script>
</body>
</html>