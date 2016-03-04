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
				宠物学堂
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
			<h3 class="groom-title">
				热门推荐
			</h3>
			<div class="groom-list overflow">
				<ul>
					<c:forEach var="item" items="${list}">
						<li>
							<div class="avatar fl">
								<div class="avatar-box">
									<a href="${item.url}"><img alt="${item.title}" src="${item.thumbUrl}" width="100%" height="100%"></a>
								</div>
							</div>
							<div class="grrom-brev fl">
								<div class="brev-box">
									<div>
										<a href="${item.url}"><font size="3px">${item.title}</font></a> 
									</div>
									<br><br><br>
									<div class="grrom-time griy">
										${item.updateTime}
									</div>
								</div>
							</div>
						</li>
					</c:forEach>
				</ul>
			</div>
			<div class="griy-bg h20">
				
			</div>
		</div>
		<!-- 
		<div class="viewport">
			<ul class="nav-top f16 overflow griy">
				<li class="active">
					<a href="">
						<i class="fa fa-home fa-2x"></i>
						<div>首页</div>
					</a>
				</li>
				<li>
					<a href="">
						<i class="fa fa-edit fa-2x"></i>
						<div>预约</div>
					</a>
				</li>
				<li>
					<a href="">
						<i class="fa fa-heart-o fa-2x"></i>
						<div>服务</div>
					</a>
				</li>
				<li>
					<a href="">
						<i class="fa fa-user fa-2x"></i>
						<div>个人</div>
					</a>
				</li>
			</ul>
		</div>
		 -->
	</div>
</body>
</html>