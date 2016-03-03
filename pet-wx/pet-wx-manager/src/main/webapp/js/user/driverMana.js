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
	var logisticsName = '';
	var phoneNumber = '';
	var address = '';
	var driverLicenseNumber = '';
	if($("#type").val() == 1){
		logisticsName = $("#typeValue").val();
	}else if($("#type").val() == 2){
		phoneNumber = $("#typeValue").val();
	}else if($("#type").val() == 3){
		driverLicenseNumber = $("#typeValue").val();
	}else if($("#type").val() == 4){
		address = $("#typeValue").val();
	}
	
	layer.load(2);//遮罩层
	$.ajax({
	      url: "queryTruckOwner.htm",
	      datatype: 'json',
	      type: "post",
	      data: {
	    	  begin:(pageNum-1)*pageSize,
	    	  rows:pageSize,
	    	  logisticsName:logisticsName,
	    	  phoneNumber:phoneNumber,
	    	  driverLicenseNumber:driverLicenseNumber,
	    	  address:address,
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
		$("#tbodyId").html('<tr ><td colspan="10">无数据</td></tr>');
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
		str = str + '<td>' + data.content[i].phoneNumber + '</td>';
		str = str + '<td>' + data.content[i].name + '</td>';
		if(data.content[i].idCardNumber != null){
			str = str + '<td>' + data.content[i].idCardNumber + '</td>';
		}else{
			str = str + '<td></td>';
		}
		if(data.content[i].driverLicenseNumber != null){
			str = str + '<td>' + data.content[i].driverLicenseNumber + '</td>';
		}else{
			str = str + '<td></td>';
		}
		str = str + '<td>' + data.content[i].experience + '</td>';
		if(data.content[i].logisticsName != null){
			str = str + '<td>' + data.content[i].logisticsName + '</td>';
		}else{
			str = str + '<td></td>';
		}
		if(data.content[i].address != null){
			str = str + '<td>' + data.content[i].address + '</td>';
		}else{
			str = str + '<td></td>';
		}
		str = str + '<td>' + data.content[i].createTime + '</td>';
		str = str + '<td><a href="javascript:void(0)" onclick="getDriverInfo(\'' + data.content[i].id + '\')">司机详情</a> <a href="javascript:void(0)" onclick="getOrderList(\'' + data.content[i].phoneNumber + '\')">查看订单</a></td>';
		str = str + '</tr>';
    }
	$("#tbodyId").html(str);
}
//查看司机详情
function getDriverInfo(id){
	//iframe层-父子操作
	var index = layer.open({
	    type: 2,
	    area: ['1000px', '700px'],
	    fix: false, //不固定
	    maxmin: true,
	    content: 'driverInfoPage.htm?id=' + id
	});
	layer.full(index);
}
//查看订单列表
function getOrderList(phoneNumber){
	window.location.href='../business/orderPageByType.htm?type=1&typeValue=' + phoneNumber;
}