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
				医院介绍
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
			<h3 class="groom-text">
			<p>
			&nbsp;&nbsp;&nbsp;&nbsp;<font size="3px">浙江大学动物医院（杭州浙大圆正动物医院）创建于1960年，其前身为浙江农业大学兽医院，医院直属浙江大学管理。</font><br> 
			&nbsp;&nbsp;&nbsp;&nbsp;<font size="3px">医院拥有一支集国内外高层次、学缘交叉、技术全面的人员队伍，现有技术人员30余人，其中副教授以上专业技术人员5人，拥有博士学位人员8人，拥有硕士学位人员5人，具有国外学术交流经历人员8人。</font><br>
			&nbsp;&nbsp;&nbsp;&nbsp;<font size="3px">萍水西街医院面积约700平方米，设有门诊部、检验科、住院部等，年门诊量约20000例。医院配备了爱德仕全自动五分类血球仪、全自动生化仪、血气分析仪、尿液分析仪、奥林巴斯显微成像系统、DR成像系统、小动物专用彩超、内窥镜、进口呼吸麻醉机、心电图、进口眼压仪、多普勒血压计等先进的诊疗设备，同时在紫金港校区内设有特殊检测技术的实验室。</font><br>
			&nbsp;&nbsp;&nbsp;&nbsp;<font size="3px">医院及相关人员承担了国家和省（部）级科技项目，以及国际学术交流项目。医院在小动物、大家畜、鸟类、水族动物的疾病诊疗方面在同行中有较高的声誉。</font><br>
			&nbsp;&nbsp;&nbsp;&nbsp;<font size="3px">作为浙江省历史最悠久的综合性动物医院，始终坚持“文化引领”，秉承“服务至上”的核心价值观，诠释“精湛演绎技术、关爱体现服务”的理念，践行“科技创新、服务大众、培育新人、引领未来”的使命，以为浙江省动物疾病的预防、诊断、治疗及公共预防提供技术保障为宗旨，同时为浙江大学的教学与科研提供服务。</font><br>
			</p>
			</h3>
			<!--
			<div class="griy-bg h20">
				
			</div>
			-->
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