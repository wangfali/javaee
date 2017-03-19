<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset=UTF-8>
<title>用户注册</title>
<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
</head>
<body>
	<!-- 
		在异步提交的方式下，form标签的action和method属性没有意义
	-->
	<form action="01_time.jsp" method="GET">
		<table border="2" >
			<tr>
				<th>用户名</th>
				<td><input type="text" name="username"/></td>
			</tr>
			<tr>
				<th>密码</th>
				<td><input type="password" name="password"/></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="button" value="检查" style="width:111px"/>
				</td>
			</tr>
		</table>
	</form>
	<script type="text/javascript">
		//定位提交按钮
		$(":button").click(function(){
		//定位用户名和密码文本框获取相应的值
		var userName=$(":text").val();
		var password=$(":password").val();
		//去除两边的空格
		userName=$.trim(userName);
		password=$.trim(password);
		//判断是否为空
		if(userName.length==0||password==0){
			//输出提示
			window.alert("用户名或密码不能为空");
			//两个文本框清空
			$(":text").val("");
			$(":password").val("");
		}else{
			//设置参数
			var url="${pageContext.request.contextPath}/registerServlet?time="+new Date().getTime().toString();
			//使用json创建对象
			var sendData={
					"userName":userName,
					"password":password
			}
			//使用ajax异步提交技术验证方法
			$(":button").load(url,sendData,function(backData){
				//输出验证的提示
				window.alert(backData);
				//两个文本框清空
				$(":text").val("");
				$(":password").val("");
			});
		}
		});
	</script>
</body>
</html>