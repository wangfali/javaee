<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset=UTF-8>
<title>使用json实现三级联动</title>
<script type="text/javascript" src="js/ajax.js"></script>
</head>
<body>
	<form>
	<!--省份下拉框-->
		<select id="provinceId">
			<option>请选择省份</option>
			<option>海南</option>
			<option>广东</option>
		</select>
		<!-- 城市下拉框 -->
		<select id="cityId">
			<option>请选择城市</option>
		</select>
		<!-- 区块下拉框-->
		<select id="sectionId">
			<option>请选择区块</option>
		</select>
	</form>
	<!-- 创建方法 -->
	<script type="text/javascript">
		//获取省份下拉框对象
		document.getElementById("provinceId").onchange=function(){
			var province=this[this.selectedIndex].value;
			//清空城市下拉框中的内容
			document.getElementById("cityId").options.length=1;
			//清空区域下拉框中的内容
			document.getElementById("sectionId").options.length=1;
			//判断省份下拉框中的字符串
			if("请输入省份"!= province){
				//创建AJAX对象
				var ajax=createAjax();
				//准备ajax对象
				var method="post";
				var url="${pageContext.request.contextPath}/show.action?time="+new Date().getTime().toString();
				ajax.open(method, url);
				//设置请求头
				ajax.setRequestHeader("content-type","application/x-www-form-urlencoded")
				//设置content
				var content="bean.province="+province;
				//发送ajax
				ajax.send(content);
				//准备接受服务器传来的数据
				ajax.onreadystatechange=function(){
					//判断接收到的状态码
					if(ajax.readyState==4){
						//判断服务器接收到的响应码
						if(ajax.status==200){
							//接收html数据
							var city=ajax.responseText;
							//将数据转换为json
							city=eval("("+city+")");
							//获取城市集合
							var array=city.citys;
							//循环输出
							for(var i=0;i<array.length;i++){
								var option=document.createElement("option");
								option.innerHTML=array[i];
								//将选项添加进入下拉框
								document.getElementById("cityId").appendChild(option);
							}
						}
					}
				}
			}
		}
	</script>
	<!-- 实现城市和区域的联动-->
	<script type="text/javascript">
		//当城市下框中选项有改动时触发的事件
		document.getElementById("cityId").onchange=function(){
			//获取选中的值
			var city=this[this.selectedIndex].value;
			//清空区域选项框中的数据
			document.getElementById("sectionId").options.length=1;
			//判断选择的值
			if("请选择城市"!=city){
				//创建ajax对象
				var ajax=createAjax();
				//准备发送ajax
				var method="post";
				var url="${pageContext.request.contextPath}/show2?time="+new Date().getTime().toString();
				ajax.open(method, url);
				//设置请求头
				ajax.setRequestHeader("content-type","application/x-www-form-urlencoded");
				//设置content
				var content="bean.city="+city;
				//发送ajax
				ajax.send(content);
				//接收服务器返回状态码
				ajax.onreadystatechange=function(){
					//判断返回码
					if(ajax.readyState==4){
						//判断响应码
						if(ajax.status==200){
							//接收html数据
							var section=ajax.responseText;
							//将java变为ajax
							section=eval("("+section+")");
							//获取集合对象
							var array=section.sections;
							//将数组遍历输出
							for (var i = 0; i < array.length; i++) {
								var option=document.createElement("option");
								option.innerHTML=array[i];
								//将option加入下拉框中
								document.getElementById("sectionId").appendChild(option);
							}
						}
					}
				}
			}
		}
	</script>
</body>
</html>