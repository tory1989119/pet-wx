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
	var consultingStatusValue='';
	if($('#searchTypeId').val() == '1'){
		consultingStatusValue = $('#consultingStatusValue').val();
	}
	
	layer.load(2);//遮罩层
	$.ajax({
	      url: "queryConsulting.htm",
	      datatype: 'json',
	      type: "post",
	      data: {
	    	  begin:(pageNum-1)*pageSize,
	    	  rows:pageSize,
	    	  isProcessed:consultingStatusValue,
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
		$("#tbodyId").html('<tr ><td colspan="8">无数据</td></tr>');
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
		str = str + '<td>' + data.content[i].phoneNumber + '</td>';
		str = str + '<td>' + data.content[i].licensePlate + '</td>';
		if(data.content[i].province != null){
			str = str + '<td>' + data.content[i].province + data.content[i].city + data.content[i].area + '</td>';
		}else{
			str = str + '<td></td>';
		}
		if(data.content[i].logisticsName != null){
			str = str + '<td>' + data.content[i].logisticsName + '</td>';
		}else{
			str = str + '<td></td>';
		}
		if(data.content[i].landlineNumber != null && data.content[i].landlineNumber != ''){
			str = str + '<td>' + data.content[i].areaCode + '-' + data.content[i].landlineNumber + '</td>';
		}else{
			str = str + '<td></td>';
		}
		str = str + '<td>' + data.content[i].createTime + '</td>';
		str = str + '<td>' + getConsultingStatusName(data.content[i].isProcessed) + '</td>';
		str = str + '<td><a href="javascript:void(0)" onclick="getConsultingInfo(\'' + data.content[i].truckId + '\')">求助详情</a></td>';
		str = str + '</tr>';
    }
	$("#tbodyId").html(str);
}
//查看详情
function getConsultingInfo(truckId){
	//iframe层-父子操作
	var index = layer.open({
	    type: 2,
	    area: ['1200px', '900px'],
	    fix: false, //不固定
	    maxmin: true,
	    content: 'queryConsultingDetail.htm?truckId=' + truckId
	});
	layer.full(index);
}

//查询条件显示
function searchType(){
	if($('#searchTypeId').val() == 1){
		$('#searchTypeValue').hide();
		$('#consultingStatusValue').show();
	}else{
		$('#searchTypeValue').show();
		$('#consultingStatusValue').hide();
	}
	$('#searchTypeValue').val('');
	$('#consultingStatusValue').val('');
}