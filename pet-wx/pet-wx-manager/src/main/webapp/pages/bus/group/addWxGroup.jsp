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
		公众号管理>用户分组管理>新增用户分组
	</div>
	<div class="rightMain p10">
		<div class="rightMain p10 w600 autoCenter">
				<div>
					<div class="lh35 mb20">
						<span class="fl wp16 tr">分组名称：</span>
						<input type="text" class="input-control h35  pl5 pr5 wp80" name="name" id="name" maxlength="10">
					</div>
					<div class="tc lh35 mt20">　　　　
						<span class="btnGriy Blackdetail cursor mr20" onclick="closeIf();">
								取消
						</span>　　　　　　　　　
						<span class="btnBlue Blackdetail whitefc cursor mr20" onclick="add();">
								添加
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
	function add(){
		
		if($('#name').val() == ''){ 
 			layer.tips('请输入分组名称', '#name', {
				tipsMore: true,
			    tips: [2, '#3E7FE7']
			}); 
			return false; 
 		}
		$.ajax({
			url: "<%=request.getContextPath()%>/bus/group/insertWxGroup.do",
			datatype: 'json',
			type: "post",
			data: {
				name:$('#name').val()
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