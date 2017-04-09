<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="en">
<head>
<%@include file="/common/header.jsp"%>
<meta charset="UTF-8">
</head>
<body>
 <div id="left">
        <div class="media user-media bg-dark dker">
            <div class="user-media-toggleHover">
                <span class="fa fa-user"></span>
            </div>
            <div class="user-wrapper bg-dark">
                <a class="user-link" href="">
                    <img class="media-object img-thumbnail user-img" alt="User Picture" style="width: 64px;height: 64px;" src="${basePath}upload/<s:property value='#application.imagePath'/>">
                    <span class="label label-danger user-label">管理员</span>
                </a>
            </div>
        </div>
        <ul id="menu" class="bg-blue dker">
            <li>
                <a href="${basePath}/food/face_preface.action" >
                    <i class="fa fa-table"></i>
                    <span class="link-title">首页</span>
                </a>
            </li>
            <li>
                <a href="${basePath}/food/foodBoard_listUI.action">
                    <i class="fa fa-table"></i>
                    <span class="link-title">餐桌管理</span>
                </a>
            </li>
            <li>
                <a href="${basePath}/food/foodType_caixiUI.action">
                    <i class="fa fa-table"></i>
                    <span class="link-title">菜系管理</span>
                </a>
            </li>
            <li>
                <a href="${basePath}/food/food_foodUI.action">
                    <i class="fa fa-table"></i>
                    <span class="link-title">菜品管理</span>
                </a>
            </li>
            <li>
                <a href="${basePath}/food/dingdan_dingdan.action">
                    <i class="fa fa-table"></i>
                    <span class="link-title">餐厅订单</span>
                </a>
            </li>
             <li>
                <a href="${basePath}/user/user_userUI.action">
                    <i class="fa fa-table"></i>
                    <span class="link-title">用户管理</span>
                </a>
            </li>
        </ul>
    </div>
</body>
</html>