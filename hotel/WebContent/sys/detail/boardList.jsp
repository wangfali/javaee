<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
<meta charset=UTF-8 >
<title>无线点餐平台</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="${pageContext.request.contextPath}/sys/detail/style/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/sys/detail/style/js/page_common.js"></script>
<link href="${pageContext.request.contextPath}/sys/detail/style/css/common_style_blue.css" rel="stylesheet"
	type="text/css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/sys/detail/style/css/index_1.css" />
</head>
<body>
	<!-- 页面标题 -->
	<div id="TitleArea">
		<div id="TitleArea_Head"></div>
		<div id="TitleArea_Title">
			<div id="TitleArea_Title_Content">
				<img border="0" width="13" height="13"
					src="${pageContext.request.contextPath}/sys/detail/style/images/title_arrow.gif" /> 餐桌列表
			</div>
		</div>
		<div id="TitleArea_End"></div>
	</div>


	<!-- 过滤条件 -->
	<div id="QueryArea">
		<form action="${pageContext.request.contextPath}/ToFindByNameDoardServlet" method="get">
			<input type="hidden" name="method" value="search"> <input
				type="text" name="keyword" title="请输入餐桌名称"> <input
				type="submit" value="搜索">
		</form>
	</div>


	<!-- 主内容区域（数据列表或表单显示） -->
	<div id="MainArea">
		<table class="MainArea_Content" cellspacing="0" cellpadding="0">
			<!-- 表头-->
			<thead>
				<tr align="center" valign="middle" id="TableTitle">
					<td>编号</td>
					<td>桌名</td>
					<td>状态</td>
					<td>预定时间</td>
					<td>操作</td>
				</tr>
			</thead>
			<!--显示数据列表 -->
			<tbody id="TableData">
				<c:forEach var="board" items="${requestScope.boardList}" varStatus="vars">
				<tr class="TableDetail1">
					<td align="center">${vars.count}&nbsp;</td>
					<td align="center">${board.boardName}&nbsp;</td>
					<td align="center">${board.state}</td>
					<td align="center">${board.time}</td>
					<td><a
						href="${pageContext.request.contextPath}/ToReflectBoardServlet?id=${board.id}&boardName=${board.boardName}&state=${board.state}"
						class="FunctionButton">退桌</a> <a
						href="${pageContext.request.contextPath}/ToDeleteBoardServlet?id=${board.id}"
						onClick="return delConfirm();" class="FunctionButton">删除</a></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>

		<!-- 其他功能超链接 -->
		<div id="TableTail" align="center">
			<div class="FunctionButton">
				<a href="${pageContext.request.contextPath}/sys/detail/saveBoard.jsp">添加</a>
			</div>
		</div>
	</div>
</body>
</html>