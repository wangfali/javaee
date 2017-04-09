<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html lang="en">
<head>
<meta charset="UTF-8">
<%@include file="/common/header.jsp"%>
<jsp:include page="/common/top.jsp"></jsp:include>
<jsp:include page="/common/left.jsp"></jsp:include>
<script type="text/javascript">
	//结账
	function doDelete(id,price){
		document.forms[0].action="${basePath}food/dingdan_delete.action?id="+id+"&money="+price;
		document.forms[0].submit();
	}
    </script>
</head>
<body>
	<div id="content">
		<form action="" method="post">
			<div class="outer">
				<div class="inner bg-light lter">
					<div id="collapse4" class="body box" id="nei">
						<table id="dataTable"
							class="table table-bordered table-condensed table-hover table-striped">
							<thead>
								<tr>
									<th>订单编号</th>
									<th>餐桌名</th>
									<th>下单日期</th>
									<th>总金额</th>
									<th>状态</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
								<s:iterator value="customerList">
									<tr>
										<td><s:property value="id" /></td>
										<td><s:property value="boardName" /></td>
										<td><s:date name="time" format="yyyy-MM-dd HH:mm" /></td>
										<td ><s:property value="price" /></td>
										<td><s:property value="state?'已经结账':'未结账'" /></td>
										<td><a
											href="javascript:doDelete('<s:property value='id'/>','<s:property value='price'/>')">结账</a>
										</td>
									</tr>
								</s:iterator>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</form>
	</div>
	<jsp:include page="/common/buttom.jsp"></jsp:include>
</body>
</html>