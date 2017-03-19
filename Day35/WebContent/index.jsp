<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset=UTF-8>
<title>获取服务端当前时间</title>
<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
</head>
<body>
	当前时间：<span id="time"></span><br/>
	<input type="button" value="获取时间"/>
	<script type="text/javascript">
		//定位按钮 添加事件
		$(":button").click(function(){
			//参数一:设置访问路径
			var url="${pageContext.request.contextPath}/TimeServlet?time="+new Date().getTime().toString();
			//参数二以json的方式送请求
			var sendData={
					"name":"哈哈",
					"salray":23
			}
			//回调函数
			$("#time").load(url,sendData,function(backData,textStatus,xmlHttpRequset){
				//回调函数中参数一:backData表示返回的数据，它是js对象
				//window.alert("backData="+ backData);
				//回调函数中参数二:textStatus表示返回状态的文本描述，例如：success.error;
				//window.alert("sendData=")
				//回调函数中参数三：xmlHttpRequest表示ajax中的核心对象
				window.alert("xmlHttpRequest=" + xmlHttpRequset.readyState);
				window.alert("xmlHttpRequest=" + xmlHttpRequset.status);
				window.alert("xmlHttpRequest=" + xmlHttpRequset.responseText);
			});
		});
	</script>
</body>
</html>