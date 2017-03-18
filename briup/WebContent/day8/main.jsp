<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>

<h3>欢迎<%=request.getAttribute("name1") %>登录</h3>
</center>
<table cellspacing="0" border="1" width="600">
<tr>
<td>名称</td>
<td>价格</td>
<td>操作</td>
</tr>
<tr>
<td>java编程思想</td>
<td>99</td>
<td><a href="showBook?id=1001">查看图书</a></td>
</tr>
<tr>
<td>java编程思想</td>
<td>99</td>
<td><a href="showBook?id=1002">查看图书</a></td>
</tr>
</table>
</body>
</html>