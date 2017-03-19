<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset=UTF-8>
<title>Insert title here</title>
<script type="text/javascript" src="${ pageContext.request.contextPath}/sys/detail/style/js/jquery.js"></script>
<script type="text/javascript" src="${ pageContext.request.contextPath}/sys/detail/style/js/page_common.js"></script>
<link href="${ pageContext.request.contextPath}/sys/detail/style/css/common_style_blue.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="${ pageContext.request.contextPath}/sys/detail/style/css/index_1.css" />
</head>
<body>
	<!-- 页面标题 -->
	<div id="TitleArea">
		<div id="TitleArea_Head"></div>
		<div id="TitleArea_Title">
			<div id="TitleArea_Title_Content">
				<img border="0" width="13" height="13"
					src="style/images/title_arrow.gif" /> 菜系列表
			</div>
		</div>
		<div id="TitleArea_End"></div>
	</div>
	<!-- 主内容区域（数据列表或表单显示） -->
	<div id="MainArea">
		<table class="MainArea_Content" align="center" cellspacing="0" cellpadding="0">
			<!-- 表头-->
			<thead>
				<tr align="center" valign="middle" id="TableTitle">
					<td>菜系编号</td>
					<td>菜系名称</td>
					<td>操作</td>
				</tr>
			</thead>
			<!--显示数据列表 -->
			<tbody id="TableData">
			<c:if test="${ empty requestScope.keyword }">
				<tr>
					<td colspan="4">${requestScope.error}</td>
				</tr>
			</c:if>
				<c:forEach items="${requestScope.keyword }" var="foodType">
					<tr>
						<td>${foodType.id}</td>
						<td>${foodType.typeName}</td>
						<td>
							<a href="${pageContext.request.contextPath }/ToUpdateCuisineServlet?id=${foodType.id}&typeName=${foodType.typeName}" class="FunctionButton">更新</a> 
							<a href="${pageContext.request.contextPath}/ToDeleteFoodTypeServlet?id=${foodType.id}" class="FunctionButton">删除</a>
						</td>
					</tr>
				</c:forEach>	
			</tbody>
		</table>
	</div>
</body>
</html>
