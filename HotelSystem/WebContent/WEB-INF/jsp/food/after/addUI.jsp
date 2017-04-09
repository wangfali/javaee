<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="en">
<head>
<meta charset="UTF-8">
<%@include file="/common/header.jsp"%>
<jsp:include page="/common/top.jsp"></jsp:include>
<jsp:include page="/common/left.jsp"></jsp:include>
<style type="text/css">
	thml{
		background-color: #9a9a9a;
	}
</style>
<script type="text/javascript">
        function goback() {
            history.go(-1);
        }
    </script>
<script type="text/javascript">
var verResult=false;
//异步验证账号是否唯一性
function verifyAccount(){
	  $("#msg").text("");
	  //获取账号
	  var account=$("#account").val();
	  //创建ajax对象
	  $.ajax({
		  url:"${basePath}food/foodBoard_verifyBoardName.action",
		  data:{"boardName":account},
		  type:"post",
		  async: false,
		  success:function(msg){
			  if("true" == msg){
				  verResult=false;
				  $("#msg").text("该餐桌已经存在！");
			  }else{
				  verResult=true;
			  }
		  }
	  });
}
//提交数据验证
function doSubmit(){
	  //头像不能为空
	  var $headImg1=$("#account");
	  if($headImg1.val()==""){
		  window.alert("餐桌名不能为空！");
		  return false;
	  }
	  //账号验证
	  verifyAccount();
	  if(verResult==true){
		  document.forms[0].submit();
	  }
}
</script>
</head>
<body>
<div id="content">
        <div class="outer">
<div class="inner bg-light lter" id="nei">
    <form action="${basePath}food/foodBoard_add.action" method="post" enctype="multipart/form-data">
        <div style="text-align: center; height: 200px;">
            <br>
            <br>
            <label class="label label-default" style="font-size: 2em">新桌名字:</label>
            <input type="text" class="input-group-lg" style="font-size: 2em;width: 40%"
                   name="boardName" id="account" onchange="verifyAccount()">
            <span id="msg" style="color: red"></span>
            <br>
            <br>
            <br>

            <input type="button" style="font-size: 2em;width: 94px;height: 50px;" value="添加" class="btn btn-info" onclick="doSubmit()">
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="button" style="font-size: 2em;width: 94px;height: 50px;" value="返回" class="btn btn-info" onclick="goback()">

            </div>

    </form>
</div>
</div>
</div>

<jsp:include page="/common/buttom.jsp"></jsp:include>
</body>
</html>