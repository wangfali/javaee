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
	  var foodname=$("#foodname").val();
	  $.ajax({
		  url:"${basePath}food/food_verifyFoodName.action",
		  data:{"foodName":foodname},
		  type:"post",
		  async: false,
		  success:function(msg){
			  if("shi" == msg){
				  verResult=false;
				  $("#msg").text("该菜名已经存在！");
			  }else{
				  verResult=true;
			  }
		  }
	  });
}
//提交数据验证
function doSubmit(){
	//菜名不能为空验证
	  var $foodname=$("#foodname");
	  if($foodname.val()==""){
		  window.alert("菜名不能为空！");
		  return false;
	  }
	  //价格不能为空验证
	  if($("#jiage").val()==""){
		  window.alert("价格不能为空！");
		  return false;
	  }
	  if($("#caixi").val()=="0"){
		  window.alert("请选择菜系！");
		  return false;
	  }
	  //会员价不能为空
	  if($("vip").val()==""){
		  window.alert("会员价不能为空！")
		  return false;
	  }
	  //图片不能为空
	  if($("image").val()==""){
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
    <form name="form" action="${basePath}food/food_update.action" class="form-horizontal"  method="post" enctype="multipart/form-data">
        <div class="form-group">
            <label class="control-label col-lg-4">菜名</label>
            <div class="col-lg-4">
				<s:textfield name="food.foodName" cssClass="form-control" id="foodname" onchange="verifyAccount()"></s:textfield>
				<span id="msg" style="color: red"></span>
				<s:hidden name="id"></s:hidden>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-lg-4">菜系</label>
            <div class="col-lg-4">
            <s:select name="foodType" list="foodTypeList" cssClass="form-control" id="caixi" 
             headerKey="0" headerValue="--请选择--">
                </s:select>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-lg-4">价格</label>
            <div class="col-lg-4">
           		<s:textfield name="food.price" cssClass="form-control" id="jiage"></s:textfield>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-lg-4">会员价</label>
            <div class="col-lg-4">
            	<s:textfield name="food.vipPrice" cssClass="form-control" id="vip"></s:textfield>
            </div>
        </div>
        <div class="form-group">
            <label  class="control-label col-lg-4">简介</label>

            <div class="col-lg-8">
            	<s:textarea name="food.text" style=" width: 335px" cssClass="form-control" ></s:textarea>
            </div>
        </div>
        <div class="form-group" >
            <label  class="control-label col-lg-4">图片</label>
            <div class="col-lg-8">
             <img src="${basePath}upload/<s:property value='food.imagePath'/>" class="img-thumbnail" style="width: 140px;height: 140px">
            <input type="file" name="image" id="image" >
            </div>
        </div>
        <br>
        <div class="form-actions no-margin-bottom col-lg-8">
            <div class="col-lg-8"></div>
           <input type="button" value="更新" class="btn btn-primary" onclick="doSubmit()">
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
<jsp:include page="/common/buttom.jsp"></jsp:include>s
</body>
</html>