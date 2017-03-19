<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset=UTF-8>
<title>Insert title here</title>
</head>
<body>
<br>
<h3>获取相关域对象中的数据</h3>
${requestScope.request}
${sessionScope.session}
${applicationScope.application}<br>
</body>
</html>