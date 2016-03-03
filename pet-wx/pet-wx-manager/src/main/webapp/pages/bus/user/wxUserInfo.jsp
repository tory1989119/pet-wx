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
		用户管理>用户管理>用户详情
	</div>
	<div class="rightMain p10">
		<table width="100%" class="detailBus">
			<tr>
				<td>手机号码：$userInfo.phoneNumber</td>
				<td>昵称：$userInfo.nickName</td>
				#if($userInfo.phoneModel != $null)
					<td>手机型号：$userInfo.phoneModel</td>
				#else
					<td>手机型号：无</td>
				#end
				<td>注册时间：$userInfo.createTime</td>
			</tr>
			<tr>
				#if($userInfo.companyName != $null)
					<td colspan="2">公司名称：$userInfo.companyName</td>
				#else
					<td colspan="2">公司名称：无</td>
				#end
				#if($userInfo.companyAddress != $null)
					<td colspan="2">公司地址：$userInfo.companyAddress</td>
				#else
					<td colspan="2">公司地址：无</td>
				#end
			</tr>
			<tr>
				#if($userInfo.startAddress != $null)
    				<td colspan="2">常用地址：$userInfo.startAddress</td>
    				<td colspan="2">常收地址：$userInfo.endAddress</td>
				#else
					<td colspan="2">常用地址：无</td>
    				<td colspan="2">常收地址：无</td>
				#end
			</tr>
			<tr>
				<td colspan="2">常用仓储：无</td>
				#if($userInfo.goodsTypeName != $null && $userInfo.goodsTypeName != '')
    				<td colspan="2">货物类型：$userInfo.goodsTypeName</td>
				#else
					<td colspan="2">货物类型：无</td>
				#end
			</tr>
			<tr>
				
    			<td colspan="2">订单数量：$userInfo.orderTotal</td>
				
				#if($userInfo.spName != $null)
    				<td colspan="2">常用物流：$userInfo.spName</td>
				#else
					<td colspan="2">常用物流：无</td>
				#end
			</tr>
			
		</table>
		<div class="tc lh30 mt20">
    		<span class="btnBlue Blackdetail whitefc cursor" onclick="closeIf();">关闭</span>
    	</div>
	</div>
</div>
<script>
	var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
	//关闭窗口并刷新页面
	function closeIf(){
        parent.layer.close(index);
	}
	
	
</script>
</body>
</html>