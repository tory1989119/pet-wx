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
		公众号管理>菜单管理>修改菜单
	</div>
	<div class="rightMain p10">
		<div class="rightMain p10 w600 autoCenter">
				<div>
					<div class="lh35 mb20">
						<span class="fl wp16 tr">菜单名：</span>
						<input type="hidden"  name="id" id="id" value="${wxMenuInfo.id}">
						<input type="hidden" name="fid" id="fid" value="${wxMenuInfo.fid}">
						<input type="text" class="input-control h35  pl5 pr5 wp80" name="name" id="name" value="${wxMenuInfo.name}">
						<c:if test="${wxMenuInfo.fid == null || wxMenuInfo.fid == ''}">
							<input type="text" class="input-control h35  pl5 pr5 wp80" name="name" id="name" maxlength="4" value="${wxMenuInfo.name}">
						</c:if>
						<c:if test="${wxMenuInfo.fid != null && wxMenuInfo.fid != ''}">
							<input type="text" class="input-control h35  pl5 pr5 wp80" name="name" id="name" maxlength="7" value="${wxMenuInfo.name}">
						</c:if>
					</div>
					<div class="lh35 mb20">
						<span class="fl wp16 tr">菜单类型：</span>
						<select class="input-control h35  pl5 pr5 wp80" id="type" name="type" value="${wxMenuInfo.type}">
							<c:if test="${wxMenuInfo.fid == null || wxMenuInfo.fid == '' }">
								<option value="">主菜单</option>
							</c:if>
							<option value="click">点击推事件</option>
							<option value="view">跳转URL</option>
							<option value="scancode_push">扫码推事件</option>
							<option value="scancode_waitmsg">扫码推事件且弹出“消息接收中”提示框</option>
							<option value="pic_sysphoto">弹出系统拍照发图</option>
							<option value="pic_photo_or_album">弹出拍照或者相册发图</option>
							<option value="pic_weixin">弹出微信相册发图器</option>
							<option value="location_select">弹出地理位置选择器</option>
							<option value="media_id">下发消息（除文本消息）</option>
							<option value="view_limited">跳转图文消息URL</option>
						</select>
					</div>
					<div class="lh35 mb20">
						<span class="fl wp16 tr">菜单key：</span>
						<input type="text" class="input-control h35  pl5 pr5 wp80" name="menuKey" id="menuKey" value="${wxMenuInfo.menuKey}" maxlength="128">
					</div>
					<div class="lh35 mb20">
						<span class="fl wp16 tr">url地址：</span>
						<input type="text" class="input-control h35  pl5 pr5 wp80" name="url" id="url" value="${wxMenuInfo.url}" maxlength="255">
					</div>
					<div class="lh35 mb20">
						<span class="fl wp16 tr">素材id：</span>
						<input type="text" class="input-control h35  pl5 pr5 wp80" name="mediaId" id="mediaId" value="${wxMenuInfo.mediaId}" maxlength="128">
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
		if($('#name').val() == ''){ 
 			layer.tips('请输入菜单名称', '#name', {
				tipsMore: true,
			    tips: [2, '#3E7FE7']
			}); 
			return false; 
 		}
		$.ajax({
			url: "<%=request.getContextPath()%>/bus/menu/updateWxMenu.do",
			datatype: 'json',
			type: "post",
			data: {
				id:$('#id').val(),
				name:$('#name').val(),
				type:$('#type').val(),
				menuKey:$('#menuKey').val(),
				url:$('#url').val(),
				mediaId:$('#mediaId').val()
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