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
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.min.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap-datetimepicker.min.css">
	
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/bootstrap-datetimepicker.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/bootstrap-datetimepicker.zh-CN.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/plugin/layer/layer.js"></script>
</head>
<body>
<form style="width: 80%; margin: 70px auto;">
    <div class="form-group">
        <label for="phoneNumber">手机号码</label>
        <input type="text" class="form-control" id="phoneNumber" placeholder="请输入手机号码">
        <input type="hidden" id="openid" value="${openid}">
    </div>
    <div class="form-group">
        <label for="reservationTime">预约时间</label>
        <input size="16" type="text" id="reservationTime" readonly class="form-control form_datetime">
    </div>
    <div class="form-group">
    	<label for="name">病症</label>
    	<textarea class="form-control" rows="3" id="disease"></textarea>
  	</div>
    <div style="float: right; margin-bottom: 10px;">
        <button type="button" class="btn btn-primary" onclick="insertReservation();">增加</button>
    </div>
</form>
<script type="text/javascript">
	$(function () {
		 $(".form_datetime").datetimepicker({
			 format: 'yyyy-mm-dd hh:ii',
			 language: 'zh-CN', //汉化 
     		 autoclose:true //选择日期后自动关闭 
		});
	});

	function insertReservation(){
		if($('#phoneNumber').val() == ''){ 
 			layer.tips('请输入手机号码', '#phoneNumber', {
				tipsMore: true,
			    tips: [1, '#3E7FE7']
			}); 
			return false; 
 		}
		
		if($('#phoneNumber').val()!=''){
			if(!(/^1\d{10}$/.test($('#phoneNumber').val()))){ 
	 			layer.tips('请输入正确的手机号码', '#phoneNumber', {
					tipsMore: true,
				    tips: [1, '#3E7FE7']
				}); 
				return false; 
	 		}
 		}
		
		if($('#reservationTime').val() == ''){ 
 			layer.tips('请选择预约时间', '#reservationTime', {
				tipsMore: true,
			    tips: [1, '#3E7FE7']
			}); 
			return false; 
 		}
		
		
		$.ajax({
			url: "<%=request.getContextPath()%>/hospital/insertReservation.do",
			datatype: 'json',
			type: "post",
			data: {
				openid:$('#openid').val(),
				phoneNumber:$('#phoneNumber').val(),
				reservationTime:$('#reservationTime').val(),
				disease:$('#disease').val()
			},
			success: function (data) {
				if (data.flag == '1' && data.errorCode == '10000') {
					layer.alert("保存成功", {icon: 6});
				}else{
					layer.alert(data.content, {icon: 6});
				}
			}
		});
	}
</script>
</body>
</html>