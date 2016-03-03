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
	
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/plugin/layer/layer.js"></script>
</head>
<body>
<form style="width: 80%; margin: 70px auto;">
    <div class="form-group">
        <label for="exampleInputEmail1">手机号码</label>
        <input type="text" class="form-control" id="exampleInputEmail1" placeholder="请输入手机号码">
    </div>
    <div class="form-group">
        <label for="exampleInputPassword1">预约时间</label>
        <input type="text" class="form-control" id="exampleInputPassword1" placeholder="请选择预约时间">
    </div>
    <div class="form-group">
        <label for="exampleInputFile">网站</label>
        <select class="form-control">
            <option value="TC">58同城</option>
            <option value="GJ">赶集网</option>
            <option value="XL">新浪网</option>
            <option value="HT">汇天下</option>
        </select>
    </div>
    <div class="form-group">
        <label for="exampleInputFile">类型</label>
        <select class="form-control">
            <option value="TC">包月</option>
            <option value="GJ">非包月</option>
        </select>
    </div>
    <div style="float: right; margin-bottom: 10px;">
        <button type="button" class="btn btn-primary glyphicon" onclick="submit();"> 增加</button>
    </div>
</form>
<script type="text/javascript">
	function submit(){
		alert('${code}');
	}
</script>
</body>
</html>