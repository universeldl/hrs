<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>医生列表</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/beyond.css" />
	<link href="${pageContext.request.contextPath}/css/bootstrap-table.min.css" rel="stylesheet" type="text/css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap-editable.css" />
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap-table.min.js"></script>
 	<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap-table-zh-CN.min.js"></script>
 	<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap-editable.min.js"></script>
 	<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootbox.min.js"></script>
 	
 	<script type="text/javascript">
 	$(function() {
		//获取科室列表
	    $('#mytab').bootstrapTable({
	        method: 'post',//post避免中文乱码
	        contentType: "application/x-www-form-urlencoded",//必须要有！！！！
	        url:"${pageContext.request.contextPath}/admin/queryDoctorList",//要请求数据的文件路径
	        //height:tableHeight(),//高度调整
	        toolbar: '#toolbar',//指定工具栏 
	        dataType: "json",
	        pageNumber: 1, //初始化加载第一页，默认第一页
	        pagination:true,//是否分页
	        queryParams:queryParams,//请求服务器时所传的参数
	        sidePagination:'server',//指定服务器端分页
	        pageSize:10,//单页记录数
	        pageList:[5,10,20,30],//分页步进值
	        showRefresh:true,//刷新按钮
	        showColumns:false,
	        clickToSelect: true,//是否启用点击选中行
	        columns:[{
	                title:'全选',
	                //复选框
	                checkbox:true,
	                width:25,
	                align:'center',
	                valign:'middle'
	            },{
	                title:'医生编号',
	                field:'doctorNo',
	                align:'center'
	            },{
	                title:'医生姓名',
	                field:'doctorName',
	                align:'center',
	                formatter: function (value, row, index) {
	                    return "<a href=\"#\" name=\"doctorName\" data-type=\"text\" data-pk=\""+row.Id+"\" data-title=\"医生姓名\" class=\"editable editable-click\">" + value + "</a>";
	                }
	            },{
	                title:'所属部门编号',
	                field:'doctorDepartmentNo',
	                align:'center'
	            },{
	                title:'医生性别',
	                field:'doctorSex',
	                align:'center'
	            },{
	                title:'出生日期',
	                field:'doctorBirth',
	                align:'center'
	            },{
	                title:'电话号码',
	                field:'doctorPhone',
	                align:'center'
	            },{
	                title:'挂号费用',
	                field:'doctorRegistrationFee',
	                align:'center'
	            },{
	                title:'入职日期',
	                field:'doctorHireTime',
	                align:'center'
	            }
	        ]
	    })
	    
	    function queryParams(params){  
	        return {  
	                limit : this.limit, // 页面大小  
	                offset : this.offset, // 页码  
	                pageNumber : this.pageNumber,  
	                pageSize : this.pageSize,
	                departmentName: $('#departmentName').val()
	        } 
	    }  
	    //查询按钮事件
	    $('#search_btn').click(function(){
	        $('#mytab').bootstrapTable('refresh', {url: '${pageContext.request.contextPath}/admin/queryDoctorList'});
	    })
	    //tableHeight函数
	    function tableHeight(){
	        //可以根据自己页面情况进行调整
	        return $(window).height() -280;
	    }
	    
	    //行内编辑配置
	    $('#edit').click(function() {
	        $('#mytab .editable').editable('toggleDisabled');
	    }); 
	    
	    //删除按钮点击事件
	    $('#delete').click(function() {
	    	var rows = $("#mytab").bootstrapTable('getSelections');
	    	if (rows.length == 0) {
	    		bootbox.alert({
	    			  size: "small",
	    			  message: "请选择要离职的医生！",
	    		});
	    	} else {
		        bootbox.confirm({
	    			size: "small",
		        	message: "确认该医生离职？",
		            buttons: {
		                confirm: {
		                    label: '确认',
		                    className: 'btn-success'
		                },
		                cancel: {
		                    label: '取消',
		                    className: 'btn-danger'
		                }
		            },
		        	callback: function(result){
		        	/* result is a boolean; true = OK, false = Cancel*/ 
		        		if (result) {
		    	    		var doctorNos = new Array();
		    	    		$.each(rows, function() {
		    	    			doctorNos.push(this.doctorNo);
		    				});
//		     				alert(departmentIds.toString());
				        	$.ajax({
				        		url: "${pageContext.request.contextPath}/admin/deleteDoctor",
				        		type: "post",
				        		data: "doctorNos=" + doctorNos.join(","),
				        		dataType: "json",
				        		async: true,
				        		success: function(data) {
				        			if (data.numOfSuccess == doctorNos.length)
				        	        	$('#mytab').bootstrapTable('refresh', {url: '${pageContext.request.contextPath}/admin/queryDoctorList'});
				        			else {
				        				alert(data.tips);
				        			}
				        		},
								error : function() {
									bootbox.alert({
						    			size: "small",
							        	message: "离职出错"
									});
								}
				        	});
		        		}
		        	}
		        });
	    	}
	    });
 	});
	</script>
</head>
<body>
	<form class="form-inline" role="form" style="margin-top: 30px; margin-left: 30px">>
	  <div class="form-group">
	    <label>姓名:</label>
	    <input type="text" class="form-control" id="name" name="name">
	  </div>
	  <div class="form-group">
	    <label>科室:</label>
	    <select class="form-control" name="depNo" id="depNo">
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
	    <label>状态:</label>
	    <select class="form-control" name="status" id="status">
	    	<option value="1" selected="selected">在职</option>
	    	<option value="0">离职</option>
	    </select>
	  </div>
	  <div class="form-group">
	    <label>入职时间:</label>
	    <input type="date" class="form-control" id="startTime" name="startTime">
	  </div>
	  <label>-</label>
	  <div class="form-group">
	    <input type="date" class="form-control" id="endTime" name="endTime">
	  </div>
	  <input class="btn btn-default" id="search_btn" value="查询" style="width: 60px;"></input>
	</form>
	<div id="toolbar">
		<button id="edit" class="btn btn-primary">修改</button>
		<button id="delete" class="btn btn-danger">离职</button>
	</div>
	<table id="mytab" class="table table-hover table-striped"></table>

</body>
</html>