<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="com.briup.www.Student"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="b" uri="http://briup.com"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<b:if test="${10<5}">
		内容输出
	</b:if>
	<b:Choose>
		<b:When test="${10<5 }">
			内容输出
		</b:When>
		<b:Otherwise>
			内容不能输出
		</b:Otherwise>
	</b:Choose>
	<%
		List<Student> list = new ArrayList<Student>();
		list.add(new Student("wangfali", "123456"));
		list.add(new Student("wangfaping", "123456"));
		list.add(new Student("wangfa", "1243"));
		pageContext.setAttribute("list", list);
		Map<String, Student> map = new HashMap<String, Student>();
		map.put("001", new Student("wangfali", "123456"));
		map.put("002", new Student("wangfaping", "123456"));
		map.put("003", new Student("wangfa", "1243"));
		pageContext.setAttribute("map", map);
	%>
	<c:forEach var="student" items="${list }">
		姓名：${student.nameString} 年龄：${student.passwordString}<br/>
	</c:forEach>
	<c:forEach var="student" items="${map }">
		姓名：${student.value.nameString} 年龄：${student.value.passwordString}<br/>
	</c:forEach>
	<b:ForEach items="${list }" var="student">
		姓名：${student.nameString}- 年龄：${student.passwordString}<br/>
	</b:ForEach>
	<b:ForEach items="${map }" var="student">
		姓名：${student.nameString}- 年龄：${student.passwordString}<br/>
	</b:ForEach>
</body>
</html>