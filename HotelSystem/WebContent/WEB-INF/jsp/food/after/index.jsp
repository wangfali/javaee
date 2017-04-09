<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html lang="en">
<head>
<%@include file="/common/header.jsp"%>
<script type="text/javascript"
	src="${basePath}js/fusioncharts.charts.js"></script>
<script type="text/javascript" src="${basePath}js/fusioncharts.js"></script>
<meta charset="UTF-8">
<title>鸿立酒店管理系统后台</title>
<style type="text/css">
html {
	background-color: #9a9a9a;
}
</style>
<script type="text/javascript">
	$(document).ready(analyse());
</script>

<script type="text/javascript">
	$(document).ready(doAnnualStatistic());
	function doAnnualStatistic() {
		$.ajax({
			url : "${basePath }/food/face_analyseIncome.action",
			type : "post",
			dataType : "json",
			success : function(data) {
				if (data != null && data != "" && data != undefined) {
					var revenueChart = new FusionCharts({
						"type" : "column3d",
						"renderAt" : "human",
						"width" : "500",
						"height" : "300",
						"dataFormat" : "json",
						"dataSource" : {
							"chart" : {
								"caption" : "酒店收入图",
								"subCaption" : "",
								"xAxisName" : "月份",
								"yAxisName" : "收入额",
								"theme" : "fint"
							},
							"data" : data.chartData
						}
					});
					revenueChart.render();
				} else {
					alert("统计失败！");
				}
			},
			error : function() {
				alert("统计失败！");
			}
		});

	}
</script>
<script type="text/javascript">
	$(document).ready(doAnnualStatistic());
	function doAnnualStatistic() {
		$.ajax({
			url : "${basePath }/food/face_analyseCustmer.action",
			type : "post",
			dataType : "json",
			success : function(data) {
				if (data != null && data != "" && data != undefined) {
					var revenueChart = new FusionCharts({
						"type" : "line",
						"renderAt" : "eye",
						"width" : "500",
						"height" : "300",
						"dataFormat" : "json",
						"dataSource" : {
							"chart" : {
								"caption" : "年度客流量",
								"subCaption" : "本年",
								"xAxisName" : "月",
								"yAxisName" : "人数",
								"lineThickness" : "2",
								"paletteColors" : "#0075c2",
								"baseFontColor" : "#333333",
								"baseFont" : "",
								"captionFontSize" : "14",
								"subcaptionFontSize" : "14",
								"subcaptionFontBold" : "0",
								"showBorder" : "1",
								"bgColor" : "#ffffff",
								"showShadow" : "2",
								"canvasBgColor" : "#ffffff",
								"canvasBorderAlpha" : "0",
								"divlineAlpha" : "100",
								"divlineColor" : "#999999",
								"divlineThickness" : "1",
								"divLineIsDashed" : "1",
								"divLineDashLen" : "1",
								"divLineGapLen" : "1",
								"showXAxisLine" : "1",
								"xAxisLineThickness" : "1",
								"xAxisLineColor" : "#999999",
								"showAlternateHGridColor" : "0"
							},
							"data" : data.chartData
						}
					});
					revenueChart.render();
				} else {
					alert("统计失败！");
				}
			},
			error : function() {
				alert("统计失败！");
			}
		});

	}
</script>
<script type="text/javascript">
	$(document).ready(doAnnualStatistic());
	function doAnnualStatistic() {
		$.ajax({
			url : "${basePath }/food/face_analyse.action",
			type : "post",
			dataType : "json",
			success : function(data) {
				if (data != null && data != "" && data != undefined) {
					var revenueChart = new FusionCharts({
						"type" : "pie3D",
						"renderAt" : "bar",
						"width" : "600",
						"height" : "400",
						"baseFontSize" : "30",
						"dataFormat" : "json",
						"dataSource" : {
							"chart" : {
								"caption" : "菜品分析（单位：种）",
								"numberPrefix" : "",
								"showPercentInTooltip" : "0",
								"decimals" : "1",
								"useDataPlotColorForLabels" : "1",
								"theme" : "fint"
							},
							"data" : data.chartData
						}
					});
					revenueChart.render();
				} else {
					alert("统计失败！");
				}
			},
			error : function() {
				alert("统计失败！");
			}
		});

	}
</script>

<script type="text/javascript">
	$(document).ready(doAnnualStatistic());
	function doAnnualStatistic() {
		$.ajax({
			url : "${basePath }/food/face_analyseBoard.action",
			type : "post",
			dataType : "json",
			success : function(data) {
				if (data != null && data != "" && data != undefined) {
					var revenueChart = new FusionCharts({
						"type" : "bar3D",
						"renderAt" : "bernoilli",
						"width" : "500",
						"height" : "300",
						"dataFormat" : "json",
						"dataSource" : {
							"chart" : {
								"caption" : "年度定桌量",
								"xAxisName" : "月份",
								"yAxisName" : "桌",
								"theme" : "fint"
							},
							"data" : data.chartData
						}
					});
					revenueChart.render();
				} else {
					alert("统计失败！");
				}
			},
			error : function() {
				alert("统计失败！");
			}
		});

	}
</script>
</head>
<body>
	<div class="bg-dark dk" id="wrap">
		<div id="top">
			<!-- .navbar -->
			<nav class="navbar navbar-inverse navbar-static-top">
				<div class="container-fluid">
					<div class="collapse navbar-collapse navbar-ex1-collapse"></div>
				</div>
				<!-- /.container-fluid -->
			</nav>
			<!-- /.navbar -->
			<header class="head">
				<div class="main-bar">
					<h3>
						<i class=""></i>&nbsp; 鸿立酒店管理系统后台
					</h3>
				</div>
			</header>
		</div>
		<!-- /#top -->
		<div id="left">
			<div class="media user-media bg-dark dker">
				<div class="user-media-toggleHover">
					<span class="fa fa-user"></span>
				</div>
				<div class="user-wrapper bg-dark">
					<a class="user-link" href=""> <img
						class="media-object img-thumbnail user-img" alt="管理员头像"
						src="${basePath}upload/<s:property value='#application.imagePath'/>"
						style="width: 64px; height: 64px;"> <span
						class="label label-danger user-label">管理员</span>

					</a>
				</div>
			</div>
			<ul id="menu" class="bg-blue dker">
				<li><a href="${basePath}/food/face_preface.action"> <i
						class="fa fa-table"></i> <span class="link-title">首页</span>
				</a></li>
				<li><a href="${basePath}/food/foodBoard_listUI.action"> <i
						class="fa fa-table"></i> <span class="link-title">餐桌管理</span>
				</a></li>
				<li><a href="${basePath}/food/foodType_caixiUI.action"> <i
						class="fa fa-table"></i> <span class="link-title">菜系管理</span>
				</a></li>
				<li><a href="${basePath}/food/food_foodUI.action"> <i
						class="fa fa-table"></i> <span class="link-title">菜品管理</span>
				</a></li>
				<li><a href="${basePath}/food/dingdan_dingdan.action"> <i
						class="fa fa-table"></i> <span class="link-title">餐厅订单</span>
				</a></li>
				<li><a href="${basePath}/user/user_userUI.action"> <i
						class="fa fa-table"></i> <span class="link-title">用户管理</span>
				</a></li>
			</ul>
		</div>
		<div id="content">
			<div class="outer">
				<div class="inner bg-light lter">
					<div class="row" id="nei">
						<div class="col-lg-6">
							<div class="box">
								<div class="body " id="human"></div>
							</div>
						</div>
						<div class="col-lg-6">
							<div class="box">
								<div class="body" id="eye"></div>
							</div>
						</div>
						<div class="row">
							<div class="col-lg-6">
								<div class="box">
									<div class="body" id="bar"></div>
								</div>
							</div>
							<div class="col-lg-6">
								<div class="box">
									<div class="body" id="bernoilli"></div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<footer class="Footer bg-dark dker">
		<p>2017 &copy;筋斗云团队制作</p>
	</footer>
</body>
</html>