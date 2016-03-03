<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
    <title>微信管理后台</title>
		<link rel="stylesheet" href="<%=request.getContextPath()%>/css/login.css">
		<link rel="stylesheet" href="<%=request.getContextPath()%>/css/common.css">
			
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/plugin/layer/layer.js"></script>
		<!–[if lt IE 9]> 	
    		<style>
    			html,body{
    				filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(src=images/loginBg.jpg,sizingMethod=scale)
    			}
    		</style>
    	<![endif]–>

	</head>
	<body>
	<div class="loginMain">
		<h1 class="f26 whitefc">
			微信后台管理系统
		</h1>
		<div class="loginBgbody pr">
			<div class="loginLogo pa">
				<img src="<%=request.getContextPath()%>/images/logoAdmin.png" class="img-responsive">
			</div>
			<div class="pa loginUsr">
				<div class="namefc f24 mb10">
					用户名/username
				</div>
				<div>
					<input type="text" class="w300 p10" id="username" name="username" value="888888"/>
				</div>
				<div class="namefc f24 mt20 mb10">
					密码/password
				</div>
				<div>
					<input type="password" class="w300 p10" id="password" name="password" value="888888"/>
				</div>
				<div class="mt30">
					<span class="loginApp whitefc f18 cursor" id="dologin">
						立即登录
					</span>
				</div>
			</div>
		</div>
	</div>
	<form action="<%=request.getContextPath()%>/main.do" method="get" id="main" >
                
    </form>
	<script type="text/javascript">
		if (window != top) 
		top.location.href = location.href; 
		
		$(function() {
			//登录方法
			$("#dologin").click(function(){
				var isTop = false;
				if($("#username").val() == '' || $("#username").val() == null){
					layer.tips('用户名不能为空', '#username', {
						tipsMore: true,
					    tips: [2, '#2AC0CE']
					});
					isTop = true;
				}
				
				if($("#password").val() == '' || $("#password").val() == null){
					layer.tips('密码不能为空', '#password', {
						tipsMore: true,
					    tips: [2, '#2AC0CE']
					});
					isTop = true;
				}
				
				if(isTop){
					return;
				}
				
				$.ajax({
		    		type:"post",
		    		url:"<%=request.getContextPath()%>/doLogin.do",
		    		data:{
		    			username:$("#username").val(),
						password:$("#password").val()
		    		},
		    		dataType:"json",
		    		success:function(data){
		    			if(data.flag == "1" && data.errorCode == "10000"){
							$("#main").submit();
		    			}else{
		    				layer.msg(data.content, {icon: 5});
		    			}
		    		}
				});
			});
		});
    </script>
</body>
	
</html>