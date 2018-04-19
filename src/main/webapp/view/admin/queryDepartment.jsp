<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>科室列表</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/beyond.css" />
	<link href="${pageContext.request.contextPath}/css/bootstrap-table.min.css" rel="stylesheet" type="text/css">
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap-table.min.js"></script>
 	<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap-table-zh-CN.min.js"></script>
 	
 	<script type="text/javascript">
 	$(function() {
	//根据窗口调整表格高度
	    $(window).resize(function() {
	        $('#departmentTable').bootstrapTable('resetView', {
	            height: tableHeight()
	        })
	    })
	//生成用户数据
	    $('#departmentTable').bootstrapTable({
	        method: 'get',
	        contentType: "application/x-www-form-urlencoded",//必须要有！！！！
	        url:"${pageContext.request.contextPath}/admin/selectDepartmentList",//要请求数据的文件路径
	        height:tableHeight(),//高度调整
	        /* toolbar: '#toolbar',//指定工具栏 */
	        dataType: "json",
	        //bootstrap table 可以前端分页也可以后端分页，这里
	        //我们使用的是后端分页，后端分页时需返回含有total：总记录数,这个键值好像是固定的  
	        //rows： 记录集合 键值可以修改  dataField 自己定义成自己想要的就好
	        pageNumber: 1, //初始化加载第一页，默认第一页
	        pagination:true,//是否分页
	        queryParamsType:'limit',//查询参数组织方式
	        //queryParams:queryParams,//请求服务器时所传的参数
	        sidePagination:'server',//指定服务器端分页
	        pageSize:10,//单页记录数
	        pageList:[5,10,20,30],//分页步进值
	        showRefresh:true,//刷新按钮
	        showColumns:false,
	        clickToSelect: true,//是否启用点击选中行
	        toolbarAlign:'right',//工具栏对齐方式
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
	                align:'center'
	            },{
	            	title:'操作',
	                align:'center'
	            }
	        ],
	        locale:'zh-CN',//中文支持,
	        responseHandler:function(res){
	            //在ajax获取到数据，渲染表格之前，修改数据源
	            return res;
	        }
	    })
	    //三个参数，value代表该列的值
	    function operateFormatter(value,row,index){
	        if(value==0){
	            return '<i class="fa fa-lock" style="color:red"></i>';
	        }else if(value==1){
	            return '<i class="fa fa-unlock" style="color:green"></i>';
	        }else{
	            return '数据错误';
	        }
	    }
	
	    //请求服务数据时所传参数
	    /* function queryParams(params){
	        return{
	            //每页多少条数据
	            pageSize: params.limit,
	            //请求第几页
	            pageNumber:params.pageNumber,
	        }
	    } */
	     /* //查询按钮事件
	    $('#search_btn').click(function(){
	        $('#departmentTable').bootstrapTable('refresh', {url: '${pageContext.request.contextPath}/admin/queryDoctorList'});
	    }) */
	    //tableHeight函数
	    function tableHeight(){
	        //可以根据自己页面情况进行调整
	        return $(window).height() -280;
	    }
 	});
	</script>
</head>
<body>
	<table id="departmentTable" class="table table-hover table-striped"></table>
</body>
</html>