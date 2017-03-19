<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset=UTF-8>
<title>使用Jquery操作xml文件</title>
<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
</head>
<body>
<input type="button" value="解析服务器响应的xml文件"/>

	<script type="text/javascript">
		$(":button").click(function(){
			var url = "${pageContext.request.contextPath}/city.xml?time="+new Date().getTime();
			var sendData = null;
			$.get(url,sendData,function(xml){
				//用jquery中的api解析xml文件，这时的xml是js对象
				var $xml = $(xml).find("city");
				//迭代
				$xml.each(function(){
					var city = $(this).text();
					alert(city);
				});
			});
		});
	</script>
</body>
</html>