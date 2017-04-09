<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="en">
<head>
<meta charset="UTF-8">
<%@include file="/common/header.jsp"%>
<jsp:include page="/common/top.jsp"></jsp:include>
<jsp:include page="/common/left.jsp"></jsp:include>
<script type="text/javascript">
	//添加菜系
        function doAdd(){
		document.forms[0].action="${basePath}food/foodType_addcaixiUI.action";
		document.forms[0].submit();
	}
    </script>
<script type="text/javascript">
	//删除菜系
	function doDelete(id){
		document.forms[0].action="${basePath}food/foodType_delete.action?id="+id;
		document.forms[0].submit();
	}
	//更新菜系
	function doSelect(id){
		document.forms[0].action="${basePath}food/foodType_upcaixiUI.action?id="+id;
		document.forms[0].submit();
	}
	//搜索
	function dofind(){
		//获取输入的名称
		var $name=$("#one");
		//判断输入的内容是否为空
		if($name.val()==""){
			window.alert("请输入要搜索的菜系！")
		}else{
			document.forms[0].action="${basePath}food/foodType_findByName.action?typeName="+$name.val();
			document.forms[0].submit();
		}
		
	}
	//页面加载时的配置
	$(function(){
		var pagecount=$("#pageCount").val();
		var allPageCount=$("#allPageCount").val();
		$("li").removeClass("active");
		$("li[id="+pagecount+"]").addClass("active");
		if(pagecount!=1){
			$("#previous").removeClass("disabled");
		}
		if(6<=allPageCount){
			$("#next").addClass("disabled");
		}
	});
	function supPage(){
		var count=$("#pageCount").val();
		count=count-1;
		document.forms[0].action="${basePath}food/foodType_page.action?pageCount="+count;
		document.forms[0].submit();
	}
	function subPage(){
		//判断是否超页
		var count=$("#pageCount").val();
		var allPageCount=$("#allPageCount").val();
		count=count+1;
		if(6<=allPageCount){
		document.forms[0].action="${basePath}food/foodType_page.action?pageCount="+count;
		document.forms[0].submit();
		}
	}
</script>
</head>
<body>
<div id="content">
        <div class="outer">
         <div class="inner bg-light lter">
	<div class="box">
		<div id="collapse4" class="body" id="nei">
			<form name="form1" action="" method="post"
				enctype="multipart/form-data">
				<s:hidden name="pageCount" id="pageCount"></s:hidden>
				<s:hidden name="allPageCount" id="allPageCount"></s:hidden>
				<table id="dataTable"
					class="table table-bordered table-condensed table-hover table-striped">
					<caption>
						<div style="width: 15%; float: left;">
							<input type="text" class="input-small form-control" id="one"
								placeholder="请输入要搜索的菜系！" style="width: 180px;">
						</div>
						<div style="float: left">
							&nbsp;&nbsp;&nbsp;<input type="button" value="搜索"
								class="btn btn-info" onclick="dofind()" style="width: 60px">
							&nbsp;&nbsp;&nbsp; <input type="button" value="添加"
								class="btn btn-danger" onclick="doAdd()" style="width: 60px">
						</div>
					</caption>
					<thead>
						<tr>
							<th>菜系编号</th>
							<th>菜系名称</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<s:iterator value="foodTypeList" status="st">
							<tr style="text-align: center">
								<td><s:property value="#st.count" /></td>
								<td><s:property value="typeName" /></td>
								<td><a
									href="javascript:doSelect('<s:property value='id'/>','<s:property value='boardName'/>')">更新</a>
									&nbsp;&nbsp;&nbsp; <a
									href="javascript:doDelete('<s:property value='id'/>')">删除</a></td>
							</tr>
						</s:iterator>
					</tbody>
					<tfoot>
						<tr>
							<td colspan="5" style="text-align: right;">
								<ul class="pagination">
									<li class="paginate_button previous disabled" id="previous"><a
										href="#" data-dt-idx="0" tabindex="0" onclick="supPage()">上一页</a></li>
									<li class="paginate_button active" id="1"><a
										href="${basePath}food/foodType_page.action?pageCount=1"
										tabindex="0" onclick="commit(1)">1</a></li>
									<li class="paginate_button " id="2"><a
										href="${basePath}food/foodType_page.action?pageCount=2"
										onclick="commit(2)">2</a></li>
									<li class="paginate_button " id="3"><a
										href="${basePath}food/foodType_page.action?pageCount=3"
										onclick="commit(3)">3</a></li>
									<li class="paginate_button " id="4"><a
										href="${basePath}food/foodType_page.action?pageCount=4"
										onclick="commit(4)">4</a></li>
									<li class="paginate_button " id="5"><a
										href="${basePath}food/foodType_page.action?pageCount=5"
										onclick="commit(5)">5</a></li>
									<li class="paginate_button " id="6"><a
										href="${basePath}food/foodType_page.action?pageCount=6"
										onclick="commit(6)">6</a></li>
									<li class="paginate_button next" id="next" >
										<a href="#" onclick="subPage()">下一页</a>
									</li>
								</ul>
							</td>
						</tr>
					</tfoot>
				</table>
			</form>
		</div>
	</div>
	</div>
	</div>
	</div>
	<jsp:include page="/common/buttom.jsp"></jsp:include>
</body>
</html>