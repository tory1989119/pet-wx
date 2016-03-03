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
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.min.css" />
	
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/plugin/layer/layer.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/plugin/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/plugin/jqPaginator/jqPaginator.js"></script>
</head>
<body>
<div class="mainSemt">
	<div class="navigateItem pl20">
		系统管理>管理员管理
	</div>
	<div class="search">
		<ul class="mb20 overflow">
			<li>
				<select class="form-control select145 h30" id="type">
					<option value="0">搜索类型</option>
					<option value="1">昵称</option>
			        <option value="2">手机号码</option>
				</select>
			</li>
			<li>
				<input type="text" class="form-control text250 h30" id="typeValue"/>
			</li>
			<li>
				<span class="fl">开始时间：</span>
				<input type="text" class="form-control selec110 h30 fl" readonly  id="startDate" onClick="WdatePicker()"/>
			</li>
			<li>
				<span class="fl">结束时间：</span>
				<input type="text" class="form-control selec110 h30 fl" readonly  id="endDate" onClick="WdatePicker()"/>
			</li>
			<li>
				<span class="btnSearch whitefc f14 mt5 clearfix cursor" onclick="search(1);">
					搜索
				</span>
			</li>
			<li>
				<span class="btnSearch whitefc f14 mt5 clearfix cursor" onclick="add();">
					新增
				</span>
			</li>
		</ul>
	</div>
	<div class="rightMain tc p10">
		<table width="100%">
			<tr>
				<td>管理员ID</td>
				<td>昵称</td>
				<td>性别</td>
				<td>年龄</td>
				<td>手机号码</td>
				<td>创建时间</td>
				<td>操作</td>
			</tr>
			<tbody id="tbodyId">
				<tr >
					<td colspan="6">无数据</td>
				</tr>
            </tbody>
		</table>
		<div class="page tc f14 mt20 customBootstrap" id="pageId" style="display:none">
			<div class="fl">共<span class="bluefc" id="showPageCount"></span>页记录</div><ul class="pagination" id="paginationId"></ul>
		</div>
	</div>
</div>
<script type="text/javascript">
$(function(){
	//定义查询选择框
	$.jqPaginator('#paginationId', {
        totalPages: 1,
        currentPage: 1,
        first:'首页',
        first: '<li class="first"><a href="javascript:void(0);">首页<\/a><\/li>',
        prev: '<li class="prev"><a href="javascript:void(0);">上一页<\/a><\/li>',
        next: '<li class="next"><a href="javascript:void(0);">下一页<\/a><\/li>',
        last: '<li class="last"><a href="javascript:void(0);">末页<\/a><\/li>',
        page: '<li class="page"><a href="javascript:void(0);">{{page}}<\/a><\/li>',
        onPageChange: function (num, type) {
        	search(num);
        }
    });
})

var pageSize = 10;

//查询 刷新当前页数pageNum
function search(pageNum){
	var phoneNumber = '';
	var nickName = '';
	if($("#type").val() == 1){
		nickName = $("#typeValue").val();
	}else if($("#type").val() == 2){
		phoneNumber = $("#typeValue").val();
	}
	
	layer.load(2);//遮罩层
	$.ajax({
	      url: "<%=request.getContextPath()%>/sys/querySysUser.do",
	      datatype: 'json',
	      type: "post",
	      data: {
	    	  begin:(pageNum-1)*pageSize,
	    	  rows:pageSize,
	    	  nickName:nickName,
	    	  phoneNumber:phoneNumber,
	    	  startDate:$("#startDate").val(),
	    	  endDate:$("#endDate").val()
	      },
	      success: function (data) {
	    	  layer.closeAll('loading');
	        if (data.flag == '1' && data.errorCode == '10000') {
	        	table(data,pageNum);//显示列表
	        }else{
	        	layer.alert(data.content, {icon: 6});
	        }
	      }
	    });
}

//列表显示内容
function table(data,pageNum){
	if(data.content == null || data.content.length <= 0){
		$("#tbodyId").html('<tr ><td colspan="7">无数据</td></tr>');
		$('#pageId').css('display','none');
		return;
	}else{
		$('#pageId').css('display','block');
	}
	
	//计算页数
    if(data.pageCount%10 > 0){
  	  var pageCount = (data.pageCount - data.pageCount%10)/10 + 1; 
    }else{
  	  var pageCount = data.pageCount/10; 
    }
    
    $('#paginationId').jqPaginator('option', {
    	currentPage: pageNum, //当前页数
        totalPages: pageCount //总页数
    });

    $("#showPageCount").html(pageCount);//按时一共查询出几页
	
	var str = '';
	for (var i = 0; i < data.content.length; i++) { 
		str = str + '<tr>';
		str = str + '<td>' + data.content[i].id + '</td>';
		str = str + '<td>' + data.content[i].nickName + '</td>';
		
		if(data.content[i].sex != null){
			if(data.content[i].sex == '0'){
				str = str + '<td>' + '男' + '</td>';
			}else{
				str = str + '<td>' + '女' + '</td>';
			}
		}else{
			str = str + '<td></td>';
		}
		
		if(data.content[i].age != null){
			str = str + '<td>' + data.content[i].age + '</td>';
		}else{
			str = str + '<td></td>';
		}
		
		if(data.content[i].phoneNumber != null){
			str = str + '<td>' + data.content[i].phoneNumber + '</td>';
		}else{
			str = str + '<td></td>';
		}
		str = str + '<td>' + data.content[i].createTime + '</td>';
		str = str + '<td><a href="javascript:void(0)" onclick="getAdminInfo(\'' + data.content[i].id + '\')">管理员详情</a>　<a href="javascript:void(0)" onclick="modify(\'' + data.content[i].id + '\')">修改</a>　<a href="javascript:void(0)" onclick="dele(\'' + data.content[i].id + '\')">删除</a></td>';
		str = str + '</tr>';
    }
	$("#tbodyId").html(str);
}
//查看管理员详情
function getAdminInfo(id){
	//iframe层-父子操作
	var index = layer.open({
	    type: 2,
	    area: ['900px', '500px'],
	    fix: false, //不固定
	    maxmin: true,
	    content: '<%=request.getContextPath()%>/sys/sysUserInfoPage.do?id=' + id
	});
	layer.full(index);
}
//新增
function add(){
	//iframe层-父子操作
	var index = layer.open({
	    type: 2,
	    area: ['900px', '500px'],
	    fix: false, //不固定
	    maxmin: true,
	    content: '<%=request.getContextPath()%>/sys/addSysUserPage.do'
	});
	layer.full(index);
}
//修改
function modify(id){
	//iframe层-父子操作
	var index = layer.open({
	    type: 2,
	    area: ['900px', '500px'],
	    fix: false, //不固定
	    maxmin: true,
	    content: '<%=request.getContextPath()%>/sys/modifySysUserPage.do?id='+id
	});
	layer.full(index);
}
//删除
function dele(id){
	layer.confirm('确定删除该管理员？',{
		btn: ['确定','取消']
	},function(){
		$.ajax({
			url: "<%=request.getContextPath()%>/sys/updateSysUser.do",
			datatype: 'json',
			type: "post",
			data: {
				id:id,
				isDeleted:'1'
			},
			success: function (data) {
				if (data.flag == '1' && data.errorCode == '10000') {
					layer.alert('删除成功！', {
						icon: 6
					},function(index){
						search(parseInt($('.active').attr('jp-data')));
						layer.close(index);
					});
				}else{
					layer.alert(data.content, {icon: 6});
				}
			}
		});
	});
}
</script>
</body>
</html>