<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<%@include file="/common/header.jsp"%>
<jsp:include page="/common/top.jsp"></jsp:include>
<jsp:include page="/common/left.jsp"></jsp:include>
<script type="text/javascript">
	function doAdd() {
		document.forms[0].action = "${basePath}user/user_addUserUI.action";
		document.forms[0].submit();
	}
</script>
<script type="text/javascript">
	//删除菜系
	function doDelete(id) {
		document.forms[0].action = "${basePath}user/user_delete.action?id="
				+ id;
		document.forms[0].submit();
	}
	//更新菜系
	function doEdit(id) {
		document.forms[0].action = "${basePath}user/user_updateUI.action?id="
				+ id;
		document.forms[0].submit();
	}
</script>
</head>
<body>
	<div id="content">
		<div class="outer">
			<div class="inner bg-light lter">
				<div id="collapse4" class="body box" id="nei">
					<s:hidden name="pageCount" id="pageCount"></s:hidden>
					<s:hidden name="allPageCount" id="allPageCount"></s:hidden>
					<form name="form1" action="" method="post"
						enctype="multipart/form-data">
						<table id="dataTable"
							class="table table-bordered table-condensed table-hover table-striped">
							<caption>
								<div style="float: left">
									&nbsp;&nbsp;&nbsp; <input type="button" value="添加"
										class="btn btn-danger" onclick="doAdd()" style="width: 60px">
								</div>
							</caption>
							<thead>
								<tr>
									<th>编号</th>
									<th>用户名</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
								<s:iterator value="userList" status="st">
									<tr style="text-align: center">
										<td><s:property value="#st.count" /></td>
										<td><s:property value="userName" /></td>
										<td><a
											href="javascript:doEdit('<s:property value='id'/>')">更新</a> <a
											href="javascript:doDelete('<s:property value='id'/>')">删除</a>
										</td>
									</tr>
								</s:iterator>
							</tbody>
						</table>
					</form>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="/common/buttom.jsp"></jsp:include>
</body>
</html>