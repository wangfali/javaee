<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<%@include file="/common/header.jsp"%>
<style type="text/css">
body {
	margin: 0;
	padding: 0;
}
</style>
<script type="text/javascript">
	//创建一个整型的数组
	var count=0;
	function toCommit(id,text){
		//获取弹出窗口中的文本域,将菜品的描述放入其中
		$("#say").text(text);
		//获取主键并将主键放入隐藏域当中
		$("#id").val(id);
		//将对话框弹出
		$("#myModal").show();
	}
	function toSave(){
		//获取当前产品的id
		var id=$("#id").val();
		//获取产品数的变量加一
		count=count+1;
		//向后台发送请求
		 $.ajax({
			  url:"${basePath}CarServlet?id="+id+"&count="+count,
			  type:"post",
			  async: true,
			  success:function(msg){
				  //获取响应后的信息并判断
				  if("success"==msg){
					  //响应成功，将购物车的数量加一
					  $("#count").text(count);
				  }else{
					  //提示用户加入购物车失败
					  window.alert("加入购物车失败！");
				  }
			  }
		  });	
	}
	function toBuy(){
		//判断购物车的数量是否为0
		if(0!=count){
		//页面进行跳转，并将数据传入后台
		window.location.href="${basePath}food/diancai_jiezhangUI.action?count="+count;
		}else{
			//输出提示信息
			window.alert("购物车内没有物品！不能下单");
		}
	}
</script>
</head>
<body>
	<!--左边的菜单-->
	<s:iterator value="foodList">
		<div class="col-lg-pull-2 img-thumbnail text-center"
			data-toggle="modal" data-target="#myModal"
			onclick="toCommit('<s:property value='id'/>','<s:property value='text'/>')" style="width: 80;height: 80">
			<img src="${basePath}upload/<s:property value='imagePath'/>"
				onclick="toCommit('<s:property value='id'/>','<s:property value='text'/>')" style="width: 80;height: 80" />
			<br>
			<s:property value="foodName" />
			&nbsp;&nbsp;&nbsp;&nbsp; <label class="label label-info"><s:property
					value="price" /></label>

		</div>
	</s:iterator>
	<!--菜单明细弹出框-->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">

					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">菜品详细</h4>
				</div>
				<div class="modal-body">
					<p id="say">大海蟹采用了比较好的烹饪工艺，加上美味的配料，由本店首席厨师制作</p>
					<input type="hidden" id="id">
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" onclick="toSave()"
						data-dismiss="modal">加入购物车</button>
				</div>
			</div>
		</div>
	</div>
	<!--右边导航悬浮框-->
	<div id="car"
		style="width: 88px; height: 120px; position: fixed; top: 50%; right: 15px; margin-top: -135px; background-color: #9a9a9a; text-align: center; border-radius: 8px;">
		<br> <br> <a class="label-info label" href="#"
			style="text-decoration: none; color: #000; font-size: 2em; cursor: pointer;"
			onclick="toBuy()">下单</a> <label>总数:</label>
		<p id="count"></p>
	</div>
	<!--菜单明细弹出框 end-->
</body>
</html>