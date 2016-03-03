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
	
	var name = '';
	var address = '';
	if($("#type").val() == 1){
		name = $("#typeValue").val();
	}else if($("#type").val() == 2){
		address = $("#typeValue").val();
	}
	
	layer.load(2);//遮罩层
	$.ajax({
	      url: "queryLogistics.htm",
	      datatype: 'json',
	      type: "post",
	      data: {
	    	  begin:(pageNum-1)*pageSize,
	    	  rows:pageSize,
	    	  totalType:$("#totalType").val(),
	    	  startTotal:$("#startTotal").val(),
	    	  endTotal:$("#endTotal").val(),
	    	  name:name,
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
		$("#tbodyId").html('<tr ><td colspan="11">无数据</td></tr>');
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
		str = str + '<td>' + data.content[i].emailAddress + '</td>';
		str = str + '<td>' + data.content[i].name + '</td>';
		if(data.content[i].registerNumber != null){
			str = str + '<td>' + data.content[i].registerNumber + '</td>';
		}else{
			str = str + '<td></td>';
		}
		str = str + '<td>' + data.content[i].address + '</td>';
		if(data.content[i].registerCatipal != null){
			str = str + '<td>' + data.content[i].registerCatipal + '万</td>';
		}else{
			str = str + '<td></td>';
		}
		if(data.content[i].truckOwnerTotal != null){
			str = str + '<td>' + data.content[i].truckOwnerTotal + '</td>';
		}else{
			str = str + '<td></td>';
		}
		if(data.content[i].truckTotal != null){
			str = str + '<td>' + data.content[i].truckTotal + '</td>';
		}else{
			str = str + '<td></td>';
		}
		if(data.content[i].orderTotal != null){
			str = str + '<td>' + data.content[i].orderTotal + '</td>';
		}else{
			str = str + '<td></td>';
		}
		str = str + '<td>' + data.content[i].createTime + '</td>';
		str = str + '<td><a href="javascript:void(0)" onclick="getLogisticsInfo(\'' + data.content[i].id + '\')">企业详情</a> <a href="javascript:void(0)" onclick="getOrderList(\'' + data.content[i].name + '\')">查看订单</a> <a href="javascript:void(0)" onclick="getRank(\'' + data.content[i].id + '\')">查看评分</a></td>';
		str = str + '</tr>';
    }
	$("#tbodyId").html(str);
}
//查看物流详情
function getLogisticsInfo(id){
	//iframe层-父子操作
	var index = layer.open({
	    type: 2,
	    area: ['1100px', '800px'],
	    fix: false, //不固定
	    maxmin: true,
	    content: 'logisticsInfoPage.htm?id=' + id
	});
	layer.full(index);
}
//查看订单列表
function getOrderList(logisticsName){
	window.location.href='../business/orderPageByType.htm?type=2&typeValue=' + encodeURI(encodeURI(logisticsName));
}
//查看评分
function getRank(id){
	window.location.href='../business/rankPageByType.htm?type=1&typeValue=' + id;
}