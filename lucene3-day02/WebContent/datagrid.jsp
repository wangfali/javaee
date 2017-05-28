<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- 引入css文件 -->
<link rel="stylesheet" href="themes/icon.css" type="text/css"></link>
<link rel="stylesheet" href="themes/bootstrap/easyui.css" type="text/css"></link>
<!-- 引入js文件 有顺序 -->
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/easyui-lang-zh_CN.js"></script>
</head>
<body>
<!-- 
		pagination表示分页栏
		pageSize表示每个显示多少条记录
		pageList表示可供选择的条数
	-->
	
	<table id="dg"></table>
	<script type="text/javascript">
		$("#dg").datagrid({
			url : "${pageContext.request.contextPath}/ArticleServlet?time="+new Date().getTime(),
			columns :  [[    
					        	{field:'id',title:'编号',width:100},    
					        	{field:'title',title:'姓名',width:100},    
					        	{field:'content',title:'薪水',width:100},
					        	{field:'sex',title:'性别',width:100}       
						]],
			fitColumns : true,
			singleSelect : true,
			pagination : true,
			pageSize : 2,
			pageList : [2]		    
		});
	</script>
</body>
</html>