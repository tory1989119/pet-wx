<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
    <title>微信管理后台</title>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/common.css">
	
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/plugin/layer/layer.js"></script>
	<!–[if lt IE 9]> <script src="http://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script> <![endif]–>
</head>
<body>
	<header class="head whitefc">
		<div class="logo pl20 fl">
			<img src="images/logo.png" alt="logo" class="fl mr10 mt15"/>
			<span class="fl f20 mr5">微信后台管理系统</span> 
		</div>
		<div class="headLink fr f14">
			<ul>
				<li><img src="images/portrait.png" class="pt10"/></li>
				<li>你好，${sysUserInfo.nickName}  |</li>
				<li class="cursor" onclick="loginOut()">退出</li>
			</ul>
		</div>
	</header>
	<section>
		<div class="left f14 tc">
			<h2 class="bluefc menu f20 whitebg" onclick="goTo();" style="cursor:pointer;">
				主菜单
			</h2>
			${ menuStr}
		</div>
		<div class="right">
			<iframe id="iframeid" name="iframename" frameborder="no" src="" style="width:100%;height:100%;"></iframe>
        </div>
	</section>
	
	<script type="text/javascript">
	$(function() {
		$('.left dl dt').click(function(){
			$(this).next('dd').slideToggle();
		})
	});
	//iframe显示菜单页面
	function getMenu(obj,url){
		$('#iframeid').attr('src',url);
		$('.leftList li').each(function(index) {
		    $(this).removeClass('bluefc');
		});
		 $(obj).attr("class", "bluefc");
	}
	//登出操作
	function loginOut(){
		layer.confirm('确定退出系统么', {
		    btn: ['确定','取消']
		}, function(){
			layer.closeAll();//关闭所有layer弹出框
			window.location.href="<%=request.getContextPath()%>/loginOut.do";
		}, function(){
		    
		});
	}
	//返回首页
	function goTo(){
		//$('#iframeid').attr('src',url);
		$('.leftList li').each(function(index) {
		    $(this).removeClass('bluefc');
		});
		
		$('.leftListName').each(function(index) {
		    $(this).css('display','none');
		});
		
	}
	</script>
	
</body>
</html>