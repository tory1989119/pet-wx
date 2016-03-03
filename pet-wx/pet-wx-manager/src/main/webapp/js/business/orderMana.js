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

function searchOrderType(obj,type){
	$('.orderList li').each(function(index) {
	    $(this).removeClass('active');
	});
	 $(obj).attr("class", "active");
	 $("#type").val(type);
	 search(1);
}

var pageSize = 10;

//查询 刷新当前页数pageNum
function search(pageNum){
    var orderNo = '';
    var goodsType = '';
    var vehicleType = '';
    var shippingPhoneNumber = '';
    var driverPhoneNumber = '';
    var logisticsName = '';
	
	if($('#searchTypeId').val() == 4){
		goodsType = $('#goodsTypeValue').val();
	}else if($('#searchTypeId').val() == 5){
		vehicleType = $('#truckTypeValue').val();
	}else if($('#searchTypeId').val() == 1){
		orderNo = $('#searchTypeValue').val();
	}else if($('#searchTypeId').val() == 2){
		shippingPhoneNumber = $('#searchTypeValue').val();
	}else if($('#searchTypeId').val() == 3){
		driverPhoneNumber = $('#searchTypeValue').val();
	}else if($('#searchTypeId').val() == 6){
		logisticsName = $('#searchTypeValue').val();
	}
	
	layer.load(2);//遮罩层
	$.ajax({
	      url: "queryOrder.htm",
	      datatype: 'json',
	      type: "post",
	      data: {
	    	  begin:(pageNum-1)*pageSize,
	    	  rows:pageSize,
	    	  type:$("#type").val(),
	    	  startDate:$("#startDate").val(),
	    	  endDate:$("#endDate").val(),
	    	  orderNo : orderNo,
		      goodsType : goodsType,
		      vehicleType : vehicleType,
		      shippingPhoneNumber : shippingPhoneNumber,
		      driverPhoneNumber : driverPhoneNumber,
		      logisticsName : logisticsName,
			  departureProvince:$("#departureProvince").val(),
			  departureCity:$("#departureCity").val(),
			  departureArea:$("#departureArea").val(),
			  destinationProvince:$("#destinationProvince").val(),
			  destinationCity:$("#destinationCity").val(),
			  destinationAaea:$("#destinationArea").val()
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
		$("#divId").html('<div align="center">无数据</div>');
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
		str = str + '<div class="listRecord"><ul class="listNan overflow fb">';
		str = str + '<li>发货日期：' + data.content[i].shippingDate + '</li>';
		str = str + '<li>订单号：' + data.content[i].orderNo + '</li>';
		str = str + '<li>货主：' + data.content[i].shippingPhoneNumber + '</li>';
		if(data.content[i].driverPhoneNumber == null || data.content[i].driverPhoneNumber == ''){
			str = str + '<li></li>';
		}else{
			str = str + '<li>车主：' + data.content[i].driverPhoneNumber + '</li>';
		}
		str = str + '</ul>';
		str = str + '<div class="p15"><div class="listImg pr fl ml30">';
		if(data.content[i].goodsPictureUrl1 != null && data.content[i].goodsPictureUrl1 != ''){
			str = str + '<div style="width:112px;height: 65px;background:black"><img style="width: 112px;height: 65px;" src="' + data.content[i].goodsPictureUrl1 + '"/></div>';
		}else{
			str = str + '<div style="width:112px;height: 65px;background:black"><img style="width: 112px;height: 65px;" src=""/></div>';
		}
		str = str + '<span class="pa feedback tc">' + getOrderStatusName(data.content[i].status) + '</span>';
		str = str + '</div><div class="fl ml20">';
		if(data.content[i].departureProvince != null && data.content[i].departureProvince != ''){
			str = str + '<div>' + data.content[i].departureProvince + data.content[i].departureCity + data.content[i].departureArea + data.content[i].departureAddress + '--' + data.content[i].destinationProvince + data.content[i].destinationCity + data.content[i].destinationArea + data.content[i].destinationAddress + '</div>';
		}else{
			str = str + '<div>无发货地址--无收货地址</div>';
		}
		str = str + '<div>车辆信息：' ;
		str = str + getVehicleTypeName(data.content[i].vehicleType) ;
		str = str + getVehicleLengthTypeName(data.content[i].vehicleLengthType);
		str = str + getVehicleWeightTypeName(data.content[i].vehicleWeightType);
		str = str + '</div>';
		str = str + '<div>货物信息：';
		str = str + getGoodsTypeName(data.content[i].goodsType);
		if(data.content[i].estimateWeight != null && data.content[i].estimateWeight != ''){
			str = str + ' ' + data.content[i].estimateWeight + '(吨)';
		}
		str = str + '</div></div><div class="fr">';
		str = str + '<span class="btnBlue Blackdetail whitefc mt5 clearfix cursor" onclick="getOrderInfo(\'' + data.content[i].id + '\');">查看详情</span>';
		
		if(data.content[i].status == '3' || data.content[i].status == '4'){
			if(data.content[i].coordinate != null || data.content[i].coordinate != ''){
				str = str + '<span class="btnBlue Blackdetail whitefc mt5 clearfix cursor" onclick="getLocation(\'' + data.content[i].id + '\');">定位</span>';
			}
		}
		if(data.content[i].status == '6'){
			str = str + '<span class="btnBlue Blackdetail whitefc mt5 clearfix cursor" onclick="getEvaluate(\'' + data.content[i].orderNo + '\');">查看评价</span>';
		}
		str = str + '</div><div class="cb"></div></div></div>';
    }
	$("#divId").html(str);
}
//查看详情
function getOrderInfo(id){
	//iframe层-父子操作
	var index = layer.open({
	    type: 2,
	    area: ['1200px', '900px'],
	    fix: false, //不固定
	    maxmin: true,
	    content: 'orderInfoPage.htm?id=' + id
	});
	layer.full(index);
}
//定位
function getLocation(id){
	//iframe层-父子操作
	var index = layer.open({
	    type: 2,
	    area: ['900px', '900px'],
	    fix: false, //不固定
	    maxmin: true,
	    content: 'orderLocation.htm?id=' + id
	});
	layer.full(index);
}
//查看评价
function getEvaluate(orderNo){
	window.location.href='../business/rankPageByType.htm?type=2&typeValue=' + orderNo;
}

//查询条件显示
function searchType(){
	if($('#searchTypeId').val() == 4){
		$('#searchTypeValue').hide();
		$('#goodsTypeValue').show();
		$('#truckTypeValue').hide();
	}else if($('#searchTypeId').val() == 5){
		$('#searchTypeValue').hide();
		$('#goodsTypeValue').hide();
		$('#truckTypeValue').show();
	}else{
		$('#searchTypeValue').show();
		$('#goodsTypeValue').hide();
		$('#truckTypeValue').hide();
	}
	$('#searchTypeValue').val('');
	$('#goodsTypeValue').val('');
	$('#truckTypeValue').val('');
}
//获取市
function getCity(provinceId,cityId){
	$.ajax({
	      url: "../../sys/admin/getCytyOrArea.htm",
	      datatype: 'json',
	      type: "post",
	      data: {
	    	  type:'1',
	    	  keyWord:$('#' + provinceId).val()
	      },
	      success: function (data) {
	        if (data.flag == '1' && data.errorCode == '10000') {
	        	$('#' + cityId).empty();
              	 $('#' + cityId).append("<option value=''>选择市</option>");
              	 for(var i = 0; i < data.content.length; i++) {
              		 $('#' + cityId).append("<option value='" + data.content[i].city + "'>" + data.content[i].city +"</option>");
				}
	        }
	      }
	    });
}
//获取区
function getArea(cityId,areaId){
	$.ajax({
	      url: "../../sys/admin/getCytyOrArea.htm",
	      datatype: 'json',
	      type: "post",
	      data: {
	    	  type:'2',
	    	  keyWord:$('#' + cityId).val()
	      },
	      success: function (data) {
	        if (data.flag == '1' && data.errorCode == '10000') {
	        	$('#' + areaId).empty();
            	 $('#' + areaId).append("<option value=''>选择区或县</option>");
            	 for(var i = 0; i < data.content.length; i++) {
            		 $('#' + areaId).append("<option value='" + data.content[i].area + "'>" + data.content[i].area +"</option>");
				}
	        }
	      }
	    });
}
