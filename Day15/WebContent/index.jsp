<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset=UTF-8>
<title>Insert title here</title>
</head>
<body>
<hr>
<form action="${pageContext.request.contextPath}/DateAction" method="post">
<h2>请输入用户名以及年龄</h2>
姓名：<input type="text" name="name"><br>
年龄：<input type="text" name="age">
<input type="submit" value="提交数据">
</form>
</body>
</html>