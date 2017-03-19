<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset=UTF-8>
<title>省市二级联动 </title>
<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
</head>
<body>
省份:<select id="province">
	<option>请选择省份</option>
	<option>海南</option>
	<option>湖南</option>
	</select>
城市名称:<select id="city">
		<option>请选择城市名称</option>
	</select>
	<script type="text/javascript">
		//定位省份选项框 添加事件
		$("#province").change(function(){
			//清空城市中的值
			$("#city option:gt(0)").remove();
			//获取选中省份的值
			var province=$("#province option:selected").val();
			//判断是否为可用的值
			if("请选择省份"!=province){
				//将省份名通过ajax传入后台
				$.ajax({
					type:"post",
					url:"${pageContext.request.contextPath}/provinceAction.action?time="+new Date().getTime().toString(),
					data:"province="+province,
					success:function(backData,textStatus,ajax){
						//转换为jquery对象
						var array=backData.citys;
						for(var i=0;i<array.length;i++){
							var $option=$("<option>"+array[i]+"</option>");
							//将下拉框加入选择框中
							
							$("#city").append($option);
						}
					}
				});
			}else{
				//此处为无效的值
			}
		});
		
	</script>
</body>
</html>