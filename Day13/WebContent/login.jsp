<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset=UTF-8>
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/date4" method="post">
		姓名:<input type="text" name="userBean.name">
		年龄:<input type="text" name="userBean.age">
		出生日期:<input type="text" name="userBean.brith">
		<input type="submit" value="提交">
	</form>
</body>
</html>