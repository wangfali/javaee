<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset=UTF-8>
<title>欢迎使用文件上传页面</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/fileUploadAction" method="post" enctype="multipart/form-data">
		用户名：<input type="text" name="userName"><br>
		文件:<input type="file" name="file1"><br> 
		<input type="submit" value="上传">
	</form>
</body>
</html>