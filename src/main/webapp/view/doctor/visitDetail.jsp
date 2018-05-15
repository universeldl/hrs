<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="panel panel-default">
	  <div class="panel-heading">
		<table class="table" border="0px">
			<tr>
				<td>
					<label for="" class="col-sm-4 control-label" style="margin-top: 5px">病人编号：</label>
				    <div class="col-sm-5">
				      <input type="text" class="form-control" id="" name="" value="${}" readonly/>
				    </div>
				</td>
				<td>
					<label for="" class="col-sm-4 control-label" style="margin-top: 5px">病人姓名：</label>
				    <div class="col-sm-5">
				      <input type="text" class="form-control" id="" name="" value="${}" readonly/>
				    </div>
				</td>
				<td>
					<label for="" class="col-sm-4 control-label" style="margin-top: 5px">性别：</label>
				    <div class="col-sm-5">
				      <input type="text" class="form-control" id="" name="" value="${}" readonly/>
				    </div>
				</td>
			</tr>
			<tr>
				<td>
					<label for="" class="col-sm-4 control-label" style="margin-top: 5px">联系电话：</label>
				    <div class="col-sm-5">
				      <input type="text" class="form-control" id="" name="" value="${}" readonly/>
				    </div>
				</td>
				<td>
					<label for="" class="col-sm-4 control-label" style="margin-top: 5px">出生日期：</label>
				    <div class="col-sm-5">
				      <input type="text" class="form-control" id="" name="" value="${}" readonly/>
				    </div>
				</td>
			</tr>
		</table>
	  </div>
	</div>
	
	<div class="panel panel-default">
		<table class="table" border="0px">
			<tr>
				<td>
					<input type="button" value="就诊记录" onclick="queryRecord();" class="btn btn-default"/>
				</td>
				<td>
					<input type="button" value="编写病例" onclick="writeDesc();" class="btn btn-default"/>
				</td>
				<td>
					<input type="button" value="开药" onclick="queryMedicine();" class="btn btn-default"/>
				</td>
			</tr>
		</table>
	</div>
	
	<script type="text/javascript">
		function queryMedicine(){
			location.href="${pageContext.request.contextPath}/doctor/queryMedicine";
		}
		
		function queryRecord(){
			location.href="${pageContext.request.contextPath}/doctor/";
		}
		
		function writeDesc(){
			location.href="${pageContext.request.contextPath}/doctor/";
		}
	</script>
</body>
</html>