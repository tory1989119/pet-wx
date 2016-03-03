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
		公众号管理>客服管理>修改客服
	</div>
	<div class="rightMain p10">
		<div class="rightMain p10 w600 autoCenter">
				<div>
					<div class="lh35 mb20">
						<span class="fl wp16 tr">客服昵称：</span>
						<input type="hidden"  name="id" id="id" value="${wxKfInfo.id}">
						<input type="hidden" name="kfAccount" id="kfAccount" value="${wxKfInfo.kfAccount}">
						<input type="text" class="input-control h35  pl5 pr5 wp80" name="nickname" id="nickname" value="${wxKfInfo.nickname}" maxlength="6">
					</div>
					<div class="lh35 mb20">
						<span class="fl wp16 tr">客服密码：</span>
						<input type="password" class="input-control h35  pl5 pr5 wp80" name="password" id="password" value="${wxKfInfo.password}">
					</div>
					<div class="tc lh35 mt20">　　　　
						<span class="btnGriy Blackdetail cursor mr20" onclick="closeIf();">
								取消
						</span>　　　　　　　　　
						<span class="btnBlue Blackdetail whitefc cursor mr20" onclick="modify();">
								修改
						</span>
					</div>
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
	function modify(){
		if($('#nickname').val() == ''){
 			layer.tips('请输入客服昵称', '#nickname', {
				tipsMore: true,
			    tips: [2, '#3E7FE7']
			}); 
			return false; 
 		}
		if($('#password').val() == ''){
 			layer.tips('请输入密码', '#password', {
				tipsMore: true,
			    tips: [2, '#3E7FE7']
			}); 
			return false; 
 		}
		$.ajax({
			url: "<%=request.getContextPath()%>/bus/kf/updateWxKf.do",
			datatype: 'json',
			type: "post",
			data: {
				id:$('#id').val(),
				kfAccount:$('#kfAccount').val(),
				nickname:$('#nickname').val(),
				password:$('#password').val()
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