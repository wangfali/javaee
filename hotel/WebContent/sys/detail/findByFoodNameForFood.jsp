<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
	<!-- 包含公共的JSP代码片段 -->
	
<title>无线点餐平台</title>



<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
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
			<img border="0" width="13" height="13" src="style/images/title_arrow.gif"/> 菜品列表
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
				<td>菜编号</td>
				<td>菜名</td>
				<td>所属菜系</td>
				<td>价格</td>
                <td>会员价格</td>
				<td>操作</td>
			</tr>
		</thead>	
		<!--显示数据列表 -->
        <tbody id="TableData">
        <c:if test=" ${ empty requestScope.keyword}">
				<tr>
					<td colspan="6">${requestScope.error}</td>
				</tr>
			</c:if>
		<c:forEach var="food" varStatus="sta" items="${requestScope.keyword}">
			<tr class="TableDetail1">
				<td>${sta.count }&nbsp;</td>
				<td>${food.foodName }&nbsp;</td>
				<td>${food.foodType }&nbsp;</td>
				<td>${food.price }&nbsp;</td>
                <td>${food.vipPrice }&nbsp;</td>
				<td>
					<a href="<c:url value="/ToUpdateFoodServlet">
					<c:param name="foodName" value="${food.foodName }"></c:param>
					<c:param name="footType" value="${food.foodType }"></c:param>
					<c:param name="price" value="${food.price }"></c:param>
					<c:param name="vipPrice" value="${food.vipPrice }"></c:param>
					<c:param name="imagePath" value="${food.imagePath}"></c:param>
					<c:param name="text" value="${food.text }"></c:param>
				</c:url>"  class="FunctionButton">更新</a>				
					<a href="${pageContext.request.contextPath}/ToDeleteFoodServlet?id=${food.id}" onClick="return delConfirm();"class="FunctionButton">删除</a>				
				</td>
				
			</tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>