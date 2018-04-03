<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
	</head>
	<body>
		<div class="panel panel-default">
		  <div class="panel-heading">
			<table class="table">
				<tr>
					<td>
						<label for="docNo" class="col-sm-2 control-label" style="margin-top: 5px">医生编号：</label>
					    <div class="col-sm-5">
					      <input type="text" class="form-control" id="docNo" name="docNo" value="" />
					    </div>
					</td>
					<td>
						<label for="docName" class="col-sm-2 control-label" style="margin-top: 5px">医生姓名：</label>
					    <div class="col-sm-5">
					      <input type="text" class="form-control" id="docName" name="docName" value="" />
					    </div>
					</td>
					<td>
						<label for="deptName" class="col-sm-2 control-label" style="margin-top: 5px">所属科室：</label>
					    <div class="col-sm-5">
					      <input type="text" class="form-control" id="deptName" name="deptName" value="" />
					    </div>
					</td>
				</tr>
			</table>
		  </div>
		  <hr width="100%"/>
		  <div class="panel-body">
		    <form class="form-horizontal" role="form">
			  <div class="form-group">
			    <label for="regNo" class="col-sm-4 control-label">挂号编号：</label>
			    <div class="col-sm-2">
			      <input type="text" class="form-control" id="regNo" name="regNo" />
			    </div>
			  </div>
			  <div class="form-group">
			    <div class="col-sm-offset-4 col-sm-7">
			      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			      <button type="submit" class="btn btn-default" onclick="">确认就诊</button>
			      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			      <button type="reset" class="btn btn-default">取消</button>
			      <br/><br/><br/><br/><br/><br/><br/><br/>
			    </div>
			  </div>
			</form>
		  </div>
		</div>
		
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	</body>
</html>