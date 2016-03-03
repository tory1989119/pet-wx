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
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/font-awesome.min.css">
	<script src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
	
</head>
<body>
	<div id="container">
		<header>
			<div class="tc white head-title f20">
				<i class="fa fa-plus-square"></i>
				联系我们
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
			<div class="groom-list overflow">
				<p><br><br>
					<font size="4px">&nbsp;&nbsp;地址：中国浙江省杭州市西湖区萍水西街235号</font><br>
					<font size="4px"><a href="tel:13888888888">&nbsp;&nbsp;手机：13888888888</a></font><br>
					<font size="4px"><a href="tel:0571-88888888">&nbsp;&nbsp;电话：0571-88888888</a></font><br>
					<font size="4px">&nbsp;&nbsp;QQ：254400398</font><br>
				</p>
				<p align="center">
					<img src="<%=request.getContextPath()%>/images/zjdxdwyy.jpg">
					</p>
			</div>
			<div class="griy-bg h20">
				
			</div>
		</div>
	</div>
</body>
</html>