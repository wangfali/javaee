<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>结算</title>
  <%@include file="/common/header.jsp"%>
  <script type="text/javascript">
  	//获取餐桌
  		var count=0;
  		function toPay(){
  			var boardName=$("option:selected").attr("value");
  			if(boardName==""||boardName==0){
  				window.alert("请选择餐桌名");
  				return false;
  			}
  			$(".all").each(function(){
  				count=count+parseInt( $(this).text());
  			});
  			 $.ajax({
  				  url:"${basePath}food/dingdan_addCustomer.action?boardName="+boardName+"&count="+count,
  				  type:"post",
  				  async: true,
  				  success:function(msg){
  				  }
  			  });	
  			window.alert("总计"+count+"元"+"        正在通知服务员！");
  			window.location.href="${basePath}index.jsp";
  		}
  		function doCancel(id){
  			document.forms[0].action="${basePath}food/foodBoard_page.action?pageCount="+count;
  			document.forms[0].submit();
  		}
  		
  </script>
</head>
<body style="background-color: #f7a608">
<div class="container control-label ">
    <div class="tab-pane">
    <form action="">
        <table class="table table-bordered tab-content  table-responsive table-hover">
            <caption class="text-success text-center" style="font-size: 2em;">账单</caption>
            <thead>
            <tr>
                <th>操作</th>
                <th>菜名</th>
                <th>单价</th>
                <th>数量</th>
                <th>小计</th>
            </tr>
            </thead>
            <tbody>
				<s:iterator value="foodList">
					<tr>
						<td><a class="label label-danger" style="cursor: pointer;color: black;text-decoration: none"
						 onclick="doCancel('<s:property value='id'/> ')">退订</a></td>
						<td><s:property value="foodName"/></td>
						<td><s:property value="price"/></td>
						<td>1</td>
						<td class="all"><s:property value="price"/></td>
					</tr>
				</s:iterator>
            </tbody>
            <tfoot>
					<tr>
						<td colspan="4"><a class="btn btn-info" onclick="toPay()">人工结账</a></td>
						<td>请选择桌名： <s:select name="boardName" list="boardNameList"
								cssClass="form-control" headerKey="0" headerValue="--请选择--" id="board">
							</s:select>
						</td>
					</tr>
				</tfoot>
        </table>
       </form>
    </div>
    <div>
        <h4>自助结账专区</h4>
        <div class="col-lg-pull-3 img-thumbnail text-center img-responsive">
            <img src="${basePath}images/yinlian.jpg" style="width: 240px;height: 200px;"><br>
        </div>
        <div class="col-lg-pull-3 img-thumbnail text-center img-responsive">
            <img src="${basePath}images/zhifubao.jpg" style="width: 240px;height: 200px;" ><br>

        </div>
        <div class="col-lg-pull-3 img-thumbnail text-center img-responsive">
            <img src="${basePath}images/weixin.jpg" style="width: 240px;height: 200px;" ><br>

        </div>
    </div>
</div>
</body>
</html>