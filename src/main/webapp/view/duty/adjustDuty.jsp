<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>排班调节</title>
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
	    $('#dutyTable').bootstrapTable({
	        method: 'post',//post避免中文乱码
	        contentType: "application/x-www-form-urlencoded",//必须要有！！！！
	        url:"${pageContext.request.contextPath}/duty/queryDutyByNo",//要请求数据的文件路径
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
	                align:'center',
	                visible:false
	            },{
	                title:'周一',
	                field:'monday',
	                align:'center',
	                formatter:function(value,row,index){
	                	var isduty = ''; 
	                	if(row.monday==1){
	                		isduty = '<input type="checkbox" name="duty" value="monday" checked="checked"/>';
	                	}else if(row.monday==0){
	                		isduty = '<input type="checkbox" name="duty" value="monday"/>';
	                	}
	                	return isduty
	                }
	            },{
	                title:'周二',
	                field:'tuesday',
	                align:'center',
	                formatter:function(value,row,index){
	                	var isduty = ''; 
	                	if(row.tuesday==1){
	                		isduty = '<input type="checkbox" name="duty" value="tuesday" checked="checked"/>';
	                	}else if(row.tuesday==0){
	                		isduty = '<input type="checkbox" name="duty" value="tuesday"/>';
	                	}
	                	return isduty
	                }
	            },{
	                title:'周三',
	                field:'wednesday',
	                align:'center',
	                formatter:function(value,row,index){
	                	var isduty = ''; 
	                	if(row.wednesday==1){
	                		isduty = '<input type="checkbox" name="duty" value="wednesday" checked="checked"/>';
	                	}else if(row.wednesday==0){
	                		isduty = '<input type="checkbox" name="duty" value="wednesday"/>';
	                	}
	                	return isduty
	                }
	            },{
	                title:'周四',
	                field:'thursday',
	                align:'center',
	                formatter:function(value,row,index){
	                	var isduty = ''; 
	                	if(row.thursday==1){
	                		isduty = '<input type="checkbox" name="duty" value="thursday" checked="checked"/>';
	                	}else if(row.thursday==0){
	                		isduty = '<input type="checkbox" name="duty" value="thursday"/>';
	                	}
	                	return isduty
	                }
	            },{
	                title:'周五',
	                field:'friday',
	                align:'center',
	                formatter:function(value,row,index){
	                	var isduty = ''; 
	                	if(row.friday==1){
	                		isduty = '<input type="checkbox" name="duty" value="friday" checked="checked"/>';
	                	}else if(row.friday==0){
	                		isduty = '<input type="checkbox" name="duty" value="friday"/>';
	                	}
	                	return isduty
	                }
	            },{
	                title:'周六',
	                field:'saturday',
	                align:'center',
	                formatter:function(value,row,index){
	                	var isduty = ''; 
	                	if(row.saturday==1){
	                		isduty = '<input type="checkbox" name="duty" value="saturday" checked="checked"/>';
	                	}else if(row.saturday==0){
	                		isduty = '<input type="checkbox" name="duty" value="saturday"/>';
	                	}
	                	return isduty
	                }
	            },{
	                title:'周日',
	                field:'sunday',
	                align:'center',
	                formatter:function(value,row,index){
	                	var isduty = ''; 
	                	if(row.sunday==1){
	                		isduty = '<input type="checkbox" name="duty" value="sunday" checked="checked"/>';
	                	}else if(row.sunday==0){
	                		isduty = '<input type="checkbox" name="duty" value="sunday"/>';
	                	}
	                	return isduty
	                }
	            }
	        ]
	    })
	    function queryParams(params){  
	        return {  
	                limit : this.limit, // 页面大小  
	                offset : this.offset, // 页码  
	                pageNumber : this.pageNumber,  
	                pageSize : this.pageSize,
	                doctorNo: $('#doctorNo').val()
	        } 
	    }  
	    //查询按钮事件
	    $('#search_btn').click(function(){
	        $('#dutyTable').bootstrapTable('refresh', {url: '${pageContext.request.contextPath}/duty/queryDutyByNo'});
	    })
	    $('#reset_btn').click(function(){
	    	$('#doctorNo').val("");
	        $('#dutyTable').bootstrapTable('refresh', {url: '${pageContext.request.contextPath}/duty/queryDutyByNo'});
	    })
	    //tableHeight函数
	    function tableHeight(){
	        //可以根据自己页面情况进行调整
	        return $(window).height() -280;
	    }
	    
	    $('#save').click(function() {
	    	var duties = document.getElementsByName('rights');
            var dutyList = new Array();
            for(var i = 0; i < duties.length; i++){
            	if(duties[i].checked){
             		dutyList.push(duties[i].value);
            	}
            }
            
            $.ajax({
        		url: "${pageContext.request.contextPath}/duty/updateDutyByNo",
        		type: "post",
        		data: "dutyList=" + dutyList.join(","),
        		dataType: "json",
        		async: true,
        		success: function(data) {
        			if (data.numOfSuccess == dutyList.length)
        	        	$('#medicineTable').bootstrapTable('refresh', {url: '${pageContext.request.contextPath}/duty/queryDutyByNo'});
        			else {
        				alert(data.tips);
        			}
        		},
				error : function() {
					bootbox.alert({
		    			size: "small",
			        	message: "保存出错"
					});
				}
        	});
            
	    });
	    
 	});
	</script>
</head>
<body>
	<form class="form-inline" role="form" style="margin-top: 30px; margin-left: 30px">
		<div class="form-group">
			<label>医生编号:</label> <input type="text" class="form-control" id="doctorNo" name="doctorNo">
		</div>
		<input class="btn btn-default" id="reset_btn" value="重置" style="width: 60px;" type="button"></input>
		<input class="btn btn-default" id="search_btn" value="查询" style="width: 60px;" type="button"></input>
	</form>
	<div id="toolbar">
		<button id="save" class="btn btn-primary">保存</button>
	</div>
	<table id="dutyTable" class="table table-hover table-striped"></table>

</body>
</html>