<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="en">
<head>
<meta charset="UTF-8">
<%@include file="/common/header.jsp"%>
<jsp:include page="/common/top.jsp"></jsp:include>
<jsp:include page="/common/left.jsp"></jsp:include>
<script type="text/javascript">
        function goback() {
            history.go(-1);
        }
    </script>
    <script type="text/javascript">
var verResult=false;
function verifyAccount(){
	  $("#msg").text("");
	  var username=$("#username").val();
	  $.ajax({
		  url:"${basePath}user/user_verifyUserName.action",
		  data:{"userName":username},
		  type:"post",
		  async: false,
		  success:function(msg){
			  if("true" == msg){
				  verResult=false;
				  $("#msg").text("该用户名已经存在！");
			  }else{
				  verResult=true;
			  }
		  }
	  });
}
//提交数据验证
function doSubmit(){
	//菜名不能为空验证
	  var $username=$("#username");
	  if($username.val()==""){
		  window.alert("用户名不能为空！");
		  return false;
	  }
	  //价格不能为空验证
	  if($("#password").val()==""){
		  window.alert("密码不能为空！");
		  return false;
	  }
	  //图片不能为空
	  if($("tupian").val()==""){
		  window.alert("请上传图片");
		  return false;
	  }
	  //菜名验证
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
         <div class="inner bg-light lter">
<div id="collapse2" class="body">
    <form name="form" action="${basePath}user/user_addUser.action" class="form-horizontal"  method="post" enctype="multipart/form-data">
        <div class="form-group">
            <label class="control-label col-lg-4">用户名</label>
            <div class="col-lg-4">
                <input type="text" class="form-control" name="userName" id="username" onchange=" verifyAccount()">
				<span id="msg" style="color: red"></span>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-lg-4">密码</label>
            <div class="col-lg-4">
                <input type="text" class=" form-control" name="password" id="password">
            </div>
        </div>
        <div class="form-group" >
            <label  class="control-label col-lg-4">头像</label>
            <div class="col-lg-8">
            <input type="file" name="image" id="tupian">
            </div>
        </div>
        <br>
        <div class="form-actions no-margin-bottom col-lg-8">
            <div class="col-lg-8"></div>
           <input type="button" value="添加" class="btn btn-primary" onclick="doSubmit()">
            &nbsp;&nbsp;&nbsp;&nbsp;
            <input type="button" value="返回" class="btn btn-primary"  onclick="goback()">
        </div>
    </form>
</div>
</div>
</div>
</div>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<jsp:include page="/common/buttom.jsp"></jsp:include>
</body>
</html>