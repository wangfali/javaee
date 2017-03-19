<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset=UTF-8>
<title>验证码进行验证</title>
<!--引用AJAX-->
<script type="text/javascript" src="js/ajax.js"></script>
</head>
<body>
	<form>
		<table>
			<tr>
				<td>用户名:</td>
				<td><input type="text" name="userName" id="userNameId"></td>
				<td><img src="01_image.jsp"></td>
				<td id="message"></td>
			</tr>
		</table>
	</form>
	<script type="text/javascript">
		//获取验证码对象
		document.getElementById("userNameId").onkeyup=function(){
			//获取输入的字符串
			var checkCode=this.value;
			//除去空格
			checkCode=trim(checkCode);
			//判断长度是否为4
			if(checkCode.length==4){
				//创建ajax对象
				var ajax=createAjax();
				//准备ajax对象
				var method="post";
				var url="${pageContext.request.contextPath}/checkCode.action?time="+new Date().getTime().toString();
				ajax.open(method,url);
				ajax.setRequestHeader("content-type","application/x-www-form-urlencoded");
				var content="checkCode="+checkCode;
				ajax.send(content);
				ajax.onreadystatechange=function(){
					//判断返回的状态码
					if(ajax.readyState==4){
						//判断服务器返回的响应码
						if(ajax.status==200){
							var tip=ajax.responseText;
							//将数据显示成为图片
							var img=document.getElementById("message");
							//设置图片
							var image=document.createElement("img");
							image.src=tip;
							//设置大小
							image.style.width="24px";
							image.style.height="24px";
							//将图片放入第三行
							img.appendChild(image);
						}
					}
				}
			}else{
				//将图片删除
				document.getElementById("message").innerHTML="";
			}
		}
	</script>
	<script type="text/javascript">
		//创建去除空格的字符
		function trim(str){
			str = str.replace(/^\s*/,"");	
			str = str.replace(/\s*$/,"");
			return str; 
		}
	</script>
</body>
</html>