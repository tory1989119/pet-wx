<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>浙大宠物医院</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
	<meta name="applicable-device" content="mobile">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="format-detection" content="telephone=no">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/common.css" />
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/list.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/article.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/font-awesome.min.css">
	<script src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
	
</head>
<body>
	<div id="container">
		<header>
			<div class="tc white head-title f20">
				<i class="fa fa-plus-square"></i>
				设施设备
			</div>
		</header>
		<div class="floor">
			<div id="slier" class="sliderWrapper tc">
				<ul class="newSlide" id="sliderTouch">
					<li class="slideLi">
						<a href="#">
							<img src="<%=request.getContextPath()%>/images/banner.jpg">
						</a>
					</li>
				</ul>
			</div>
		</div>
		<div class="groom">
			<div class="griy-bg h20">
				
			</div>
			<div class="article p10 f16">
				<h2 class="tc">设备设施</h2>
				<div>医院配备了爱德仕自动五类血球仪、全自动生化仪、血气分析 仪、尿液分析仪、奥林巴斯显微成像系统、DR成像系统、小动物专 用彩超、内窥镜、进口呼吸麻醉机、心电图、进口眼压仪、多普勒血压计等先进的诊疗设备，同时在紫金港校区内设有特殊检测技术的实验室。</div>
				<ul class="article_img overflow">
					<li>
						<img src="<%=request.getContextPath()%>/images/facility/1.JPG" alt="" style="width: 100px;height: 100px">
						彩超
					</li>
					<li>
						<img src="<%=request.getContextPath()%>/images/facility/2.jpg" alt="" style="width: 100px;height: 100px">
						呼吸麻醉机
					</li>
					<li>
						<img src="<%=request.getContextPath()%>/images/facility/3.JPG" alt="" style="width: 100px;height: 100px">
						监护仓
					</li>
					<li>
						<img src="<%=request.getContextPath()%>/images/facility/4.jpg" alt="" style="width: 100px;height: 100px">
						内窥镜
					</li>
					<li>
						<img src="<%=request.getContextPath()%>/images/facility/5.jpeg" alt="" style="width: 100px;height: 100px">
						B超室
					</li>
					<li>
						<img src="<%=request.getContextPath()%>/images/facility/6.JPG" alt="" style="width: 100px;height: 100px">
						dr室
					</li>
					<li>
						<img src="<%=request.getContextPath()%>/images/facility/7.jpeg" alt="" style="width: 100px;height: 100px">
						X光机
					</li>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>