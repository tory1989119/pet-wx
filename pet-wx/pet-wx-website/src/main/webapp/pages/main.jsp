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
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/index.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/font-awesome.min.css">
	
	<script src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/index.js"></script>
	<script src="<%=request.getContextPath()%>/js/jquery.event.move.js"></script>
	<script src="<%=request.getContextPath()%>/js/jquery.event.swipe.js"></script>
	<script src="<%=request.getContextPath()%>/js/unslider.js"></script>
</head>
<body>
	<div id="container">
		<header>
			<div class="tc white head-title f20">
				<i class="fa fa-plus-square"></i>
				浙江大学附属动物医院
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
					<li class="slideLi">
						<a href="#">
							<img src="<%=request.getContextPath()%>/images/banner.jpg">
						</a>
					</li>
					<li class="slideLi">
						<a href="#">
							<img src="<%=request.getContextPath()%>/images/banner.jpg">
						</a>
					</li>
				</ul>
			</div>
		</div>
		<div class="nav griy-bg">
			<ul class="nav-box overflow">
				<li>
					<div class="white-bg nav-child tc">
						<img src="<%=request.getContextPath()%>/images/present.png" alt="医院介绍" class="img-responsive" onclick="gotoPage('/hospital/introducePage.do');">
						<div class="nav-txt f20">
							医院介绍
						</div>
					</div>
				</li>
				<li>
					<div class="white-bg nav-child tc">
						<img src="<%=request.getContextPath()%>/images/department.png" alt="特色科室" class="img-responsive" onclick="gotoPage('/hospital/departmentPage.do');">
						<div class="nav-txt">
							特色科室
						</div>
					</div>
				</li>
				<li>
					<div class="white-bg nav-child tc">
						<img src="<%=request.getContextPath()%>/images/device.png" alt="设备设施" class="img-responsive" onclick="gotoPage('/hospital/facilityPage.do');">
						<div class="nav-txt">
							设备设施
						</div>
					</div>
				</li>
				<li>
					<div class="white-bg nav-child tc">
						<img src="<%=request.getContextPath()%>/images/school.png" alt="宠物学堂" class="img-responsive" onclick="gotoPage('/hospital/schoolPage.do');">
						<div class="nav-txt">
							宠物学堂
						</div>
					</div>
				</li>
				<li>
					<div class="white-bg nav-child tc">
						<img src="<%=request.getContextPath()%>/images/team.png" alt="医疗团队" class="img-responsive" onclick="gotoPage('/hospital/teamPage.do');">
						<div class="nav-txt">
							医疗团队
						</div>
					</div>
				</li>
				<li>
					<div class="white-bg nav-child tc">
						<img src="<%=request.getContextPath()%>/images/contact.png" alt="联系我们" class="img-responsive" onclick="gotoPage('/hospital/contactPage.do');">
						<div class="nav-txt">
							联系我们
						</div>
					</div>
				</li>
			</ul>
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
	<script type="text/javascript">
		function gotoPage(url){
			window.location.href = '<%=request.getContextPath()%>' + url;
		}
	</script>
</body>
</html>