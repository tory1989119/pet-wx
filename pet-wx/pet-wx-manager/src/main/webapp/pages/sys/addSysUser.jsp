<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
    <title>微信管理后台</title>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/rightCommon.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/common.css">
	
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/plugin/layer/layer.js"></script>
</head>
<body>
<div class="mainSemt">
	<div class="navigateItem pl20">
		系统管理>管理员管理>新增管理员
	</div>
	<div class="rightMain p10">
		<div class="rightMain p10 w600 autoCenter">
				<div>
					<form id="mainform" name="mainform" method="post">
						<div class="lh35 mb20">
							<span class="fl wp16 tr">昵称：</span>
							<input type="text" class="input-control h35  pl5 pr5 wp80" name="nickName" id="nickName">
						</div>
						<div class="lh35 mb20">
							<span class="fl wp16 tr">性别：</span>
							<span>
　　　　　　						　男　<input name="sex" type="radio" id="men" checked=" checked" value="0"/>　　
				 　　　　　　		　女　<input name="sex" type="radio" id="women" value="1"/>
							</span>
						</div>
						<div class="lh35 mb20">
							<span class="fl wp16 tr">年龄：</span>
							<input type="text" class="input-control h35  pl5 pr5 wp80" name="age" value="1" id="age">
						</div>
						<div class="lh35 mb20">
							<span class="fl wp16 tr">地址：</span>
							<input type="text" class="input-control h35  pl5 pr5 wp80" name="address" id="address">
						</div>
						<div class="lh35 mb20">
							<span class="fl wp16 tr">手机号码：</span>
							<input type="text" class="input-control h35  pl5 pr5 wp80" name="phoneNumber" id="phoneNumber">
						</div>
						<div class="lh35 mb20">
							<span class="fl wp16 tr">用户名：</span>
							<input type="text" class="input-control h35  pl5 pr5 wp80" name="username" id="username">
						</div>
						<div class="lh35 mb20">
							<span class="fl wp16 tr">密码：</span>
							<input type="password" class="input-control h35  pl5 pr5 wp80" name="password" id="password">
						</div>
						<div class="tc lh35 mt20">　　　　
							<span class="btnGriy Blackdetail cursor mr20" onclick="closeIf();">
									取消
							</span>　　　　　　　　　
							<span class="btnBlue Blackdetail whitefc cursor mr20" onclick="add();">
									添加
							</span>
						</div>
					</form>	
				</div>
    	</div>
	</div>
</div>
<script>
	var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
	//关闭窗口并刷新页面
	function closeIf(){
		parent.search(parseInt(parent.$('.active').attr('jp-data')));
        parent.layer.close(index);
	}
	function add(){
		
		var nickName = $('#nickName').val();
		if(nickName==''){ 
 			layer.tips('请输入昵称', '#nickName', {
				tipsMore: true,
			    tips: [2, '#3E7FE7']
			}); 
			return false; 
 		}
		var username = $('#username').val();
		if(username==''){ 
 			layer.tips('请输入用户名', '#username', {
				tipsMore: true,
			    tips: [2, '#3E7FE7']
			}); 
			return false; 
 		}
		if(username.length<6){ 
 			layer.tips('用户名至少6位', '#username', {
				tipsMore: true,
			    tips: [2, '#3E7FE7']
			}); 
			return false; 
 		}
 		
		var password = $('#password').val();
		if(password==''){ 
 			layer.tips('请输入密码', '#password', {
				tipsMore: true,
			    tips: [2, '#3E7FE7']
			}); 
			return false; 
 		}
 		if(password.length<6){ 
 			layer.tips('密码至少6位', '#password', {
				tipsMore: true,
			    tips: [2, '#3E7FE7']
			}); 
			return false; 
 		}
		var age = $('#age').val();
		if(age==''){ 
			$('#age').val('1');
 		}
 		var phoneNumber = $('#phoneNumber').val();
 		if(phoneNumber!=''){
			if(!(/^1\d{10}$/.test(phoneNumber))){ 
	 			layer.tips('请输入正确的手机号码', '#phoneNumber', {
					tipsMore: true,
				    tips: [2, '#3E7FE7']
				}); 
				return false; 
	 		}
 		}
 		var sex = $('input[name="sex"]:checked').val();
 		var address = $('#address').val();
		$.ajax({
			url: "<%=request.getContextPath()%>/sys/insertSysUser.do",
			datatype: 'json',
			type: "post",
			data: {
				nickName:nickName,
				sex:sex,
				age:age,
				address:address,
				phoneNumber:phoneNumber,
				username:username,
				password:password
				
			},
			success: function (data) {
				if (data.flag == '1' && data.errorCode == '10000') {
					closeIf();
				}else{
					layer.alert(data.content, {icon: 6});
				}
			}
		});
	}
	
</script>
</body>
</html>