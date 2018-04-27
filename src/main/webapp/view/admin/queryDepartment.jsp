<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>科室列表</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/beyond.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap-table.min.css" />
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
	    $('#departmentTable').bootstrapTable({
	        method: 'post',//post避免中文乱码
	        contentType: "application/x-www-form-urlencoded",//必须要有！！！！
	        url:"${pageContext.request.contextPath}/admin/selectDepartmentList",//要请求数据的文件路径
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
	                title:'科室编号',
	                field:'departmentNo',
	                align:'center'
	            },{
	                title:'科室名',
	                field:'departmentName',
	                align:'center',
	                formatter: function (value, row, index) {
	                    return "<a href=\"#\" name=\"departmentName\" data-type=\"text\" data-pk=\""+row.Id+"\" data-title=\"科室名\" class=\"editable editable-click\">" + value + "</a>";
	                }
	            }
// 	            ,{
// 	            	title:'操作',
// 	                field:'id',
// 	                align:'center',
// 	                formatter: actionFormatter
// 	            }
	        ]
	    })
// 	    function actionFormatter(value, row, index) {
//             var id = value;
//             var result = "<button class='btn btn-danger' name='deleteOne'><span class='glyphicon glyphicon-trash'></span></button>";
//             return result;
//         }
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
	        $('#departmentTable').bootstrapTable('refresh', {url: '${pageContext.request.contextPath}/admin/queryDepartmentList'});
	    })
	    //tableHeight函数
	    function tableHeight(){
	        //可以根据自己页面情况进行调整
	        return $(window).height() -280;
	    }
	    
	    //行内编辑配置
	    $('#edit').click(function() {
	        $('#departmentTable .editable').editable('toggleDisabled');
	    }); 
	    
	    //删除按钮点击事件
	    $('#delete').click(function() {
	    	var rows = $("#departmentTable").bootstrapTable('getSelections');
	    	if (rows.length == 0) {
	    		bootbox.alert({
	    			  size: "small",
	    			  message: "请选择最少一条需要删除的科室。",
	    		});
	    	} else {
		        bootbox.confirm({
	    			size: "small",
		        	message: "确认删除所选科室？",
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
//		     	    		alert(JSON.stringify(rows));
		    	    		var departmentNos = new Array();
		    	    		$.each(rows, function() {
		    	    			departmentNos.push(this.departmentNo);
		    				});
//		     				alert(departmentIds.toString());
				        	$.ajax({
				        		url: "${pageContext.request.contextPath}/admin/deleteDepartment",
				        		type: "post",
				        		data: "departmentNos=" + departmentNos.join(","),
				        		dataType: "json",
				        		async: true,
				        		success: function(data) {
				        			if (data.numOfSuccess == departmentNos.length)
				        	        	$('#departmentTable').bootstrapTable('refresh', {url: '${pageContext.request.contextPath}/admin/queryDepartmentList'});
				        			else {
				        				alert(data.tips);
				        			}
				        		},
								error : function() {
									bootbox.alert({
						    			size: "small",
							        	message: "删除出错"
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
	<form class="form-inline" role="form" style="margin-top: 30px; margin-left: 30px">
		<div class="form-group">
			<label>科室名:</label> <input type="text" class="form-control" id="departmentName" name="departmentName">
		</div>
		<input class="btn btn-default" id="search_btn" value="查询"></input>
	</form>
	<div id="toolbar">
		<button id="edit" class="btn btn-primary">修改</button>
		<button id="delete" class="btn btn-danger">删除</button>
	</div>
	<table id="departmentTable" class="table table-hover table-striped"></table>
</body>
</html>