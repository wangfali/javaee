<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>鸿立酒店</title>
<meta charset="UTF-8">
<%@include file="/common/header.jsp"%>
<script type="text/javascript">
	function toLogin(){
		window.location.href="${basePath}login.jsp";
	}
	
</script>
</head>
<body>
<div class="navbar-wrapper">
  <div class="container">
    <div class="navbar navbar-inverse navbar-static-top">
      
        <div class="navbar-header">
	    <a class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
	      <span class="icon-bar"></span>
	      <span class="icon-bar"></span>
	      <span class="icon-bar"></span>
	    </a>
        <a class="navbar-brand" href="#">鸿立酒店全国连锁</a>
        </div>
        <div class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="#">首页</a></li>
            <li><a href="#" target="ext">关于我们</a></li>
            <li><a href="#" onclick="toLogin()">登录</a></li>
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown">其他 <b class="caret"></b></a>
              <ul class="dropdown-menu">
                <li><a href="#">投诉</a></li>
                <li><a href="#">商务合作</a></li>
                <li><a href="#">人才招聘</a></li>
              </ul>
            </li>
          </ul>
        </div>

    </div>
  </div>
</div>

<div id="myCarousel" class="carousel slide">

  <ol class="carousel-indicators">
    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
    <li data-target="#myCarousel" data-slide-to="1"></li>
    <li data-target="#myCarousel" data-slide-to="2"></li>
    <li data-target="#myCarousel" data-slide-to="3"></li>
    <li data-target="#myCarousel" data-slide-to="4"></li>
  </ol>
  <div class="carousel-inner" style="height: 500px">
    <div class="item active">
      <img src="${basePath}images/1.jpg" style="width:100%" class="img-responsive">
    </div>
    <div class="item">
      <img src="${basePath}images/2.jpg" style="width:100%" class="img-responsive">
    </div>
    <div class="item">
      <img src="${basePath}images/3.jpg" style="width:100%" class="img-responsive">
    </div>
    <div class="item">
      <img src="${basePath}images/4.jpg" style="width:100%" class="img-responsive">
    </div>
    <div class="item">
      <img src="${basePath}images/5.jpg" style="width:100%" class="img-responsive">
    </div>
  </div>

  <a class="left carousel-control" href="#myCarousel" data-slide="prev">
    <span class="icon-prev"></span>
  </a>
  <a class="right carousel-control" href="#myCarousel" data-slide="next">
    <span class="icon-next"></span>
  </a>
</div>
<script type="text/javascript">

    $("#myCarousel").carousel({
        interval :5000
    });
</script>

<div class="container marketing">
  <div class="row">
    <div class="col-md-4 text-center">
      <img class="img-circle" src="${basePath}images/one.jpg" style="width: 140px;height: 140px;">
      <h2>点餐</h2>
      <p>我们提供中餐, 西餐,顶级厨师为您服务</p>
      <p><a class="btn btn-default" href="${basePath}food/diancai_caidanUI.action?foodType='西餐'">西餐»</a>
        <a class="btn btn-default" href="${basePath}food/diancai_caidanUI.action?foodType='粤菜'">粤菜»</a>
        <a class="btn btn-default" href="${basePath}food/diancai_caidanUI.action?foodType='川菜'">川菜»</a>
        <a class="btn btn-default" href="${basePath}food/diancai_caidanUI.action?foodType='湘菜'">湘菜»</a>
      </p>

    </div>
    <div class="col-md-4 text-center">
      <img class="img-circle" src="${basePath}images/two.jpg" style="width: 140px;height: 140px;">
      <h2>订房</h2>
      <p>豪华套房，海景商务房，超大空间，至尊享受</p>
      <p><a class="btn btn-default" href="#">进入 »</a></p>
    </div>
    <div class="col-md-4 text-center">
      <img class="img-circle" src="${basePath}images/three.jpg" style="width: 140px;height: 140px;">
      <h2>宴会</h2>
      <p>定制属于你的豪华宴会</p>
      <p><a class="btn btn-default" href="#">进入»</a></p>
      
    </div>
  </div>
  <footer>
    <p>由筋斗云团队制作</p>
  </footer>
</div>
</body>
</html>