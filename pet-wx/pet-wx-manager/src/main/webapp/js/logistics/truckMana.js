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
	var truckStatusValue='';
	if($('#searchTypeId').val() == '1'){
		truckStatusValue = $('#truckStatusValue').val();
	}
	
	layer.load(2);//遮罩层
	$.ajax({
	      url: "queryTruck.htm",
	      datatype: 'json',
	      type: "post",
	      data: {
	    	  begin:(pageNum-1)*pageSize,
	    	  rows:pageSize,
	    	  status:truckStatusValue,
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
		str = str + '<td>' + data.content[i].licensePlate + '</td>';
		str = str + '<td>' + getVehicleTypeName(data.content[i].vehicleType) + '</td>';
		str = str + '<td>' + getVehicleWeightTypeName(data.content[i].vehicleWeightType) + ' ' + getVehicleLengthTypeName(data.content[i].vehicleLengthType) + '</td>';
		if(data.content[i].logisticsName != null){
			str = str + '<td>' + data.content[i].logisticsName + '</td>';
		}else{
			str = str + '<td></td>';
		}
		str = str + '<td>' + data.content[i].ownerName + '</td>';
		str = str + '<td>' + data.content[i].phoneNumber + '</td>';
		if(data.content[i].orderTotal != null){
			str = str + '<td>' + data.content[i].orderTotal + '</td>';
		}else{
			str = str + '<td></td>';
		}
		str = str + '<td>' + getTruckStatusName(data.content[i].status) + '</td>';
		str = str + '<td>' + data.content[i].createTime + '</td>';
		str = str + '<td><a href="javascript:void(0)" onclick="getTruckInfo(\'' + data.content[i].id + '\')">车辆详情</a></td>';
		str = str + '</tr>';
    }
	$("#tbodyId").html(str);
}
//查看车辆详情
function getTruckInfo(id){
	//iframe层-父子操作
	var index = layer.open({
	    type: 2,
	    area: ['1000px', '700px'],
	    fix: false, //不固定
	    maxmin: true,
	    content: 'truckInfoPage.htm?id=' + id
	});
	layer.full(index);
}

//查询条件显示
function searchType(){
	if($('#searchTypeId').val() == 1){
		$('#searchTypeValue').hide();
		$('#truckStatusValue').show();
	}else{
		$('#searchTypeValue').show();
		$('#truckStatusValue').hide();
	}
	$('#searchTypeValue').val('');
	$('#truckStatusValue').val('');
}