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
	var orderNo='';
	if($('#searchTypeId').val() == '1'){
		orderNo = $('#searchTypeValue').val();
	}
	
	layer.load(2);//遮罩层
	$.ajax({
	      url: "queryQuote.htm",
	      datatype: 'json',
	      type: "post",
	      data: {
	    	  begin:(pageNum-1)*pageSize,
	    	  rows:pageSize,
	    	  orderNo:orderNo,
	    	  startTotal:$('#startTotal').val(),
	    	  endTotal:$('#endTotal').val()
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
		str = str + '<td>' + data.content[i].orderNo + '</td>';
		if(data.content[i].providerTotal != null){
			str = str + '<td>' + data.content[i].providerTotal + '</td>';
		}else{
			str = str + '<td></td>';
		}
		if(data.content[i].maxAmount != null){
			str = str + '<td>' + data.content[i].minAmount + '-' + data.content[i].maxAmount+ '</td>';
		}else{
			str = str + '<td></td>';
		}
		if(data.content[i].fAmount != null){
			str = str + '<td>' + data.content[i].fAmount + '</td>';
		}else{
			str = str + '<td></td>';
		}
		if(data.content[i].lAmount != null && data.content[i].lAmount != ''){
			str = str + '<td>' + data.content[i].lAmount  + '</td>';
		}else{
			str = str + '<td></td>';
		}
		var time = getTime(data.content[i].difMinute);
		str = str + '<td>' + time + '</td>';
		str = str + '<td><a href="javascript:void(0)" onclick="getQuoteInfo(\'' + data.content[i].orderId + '\',\'' + time +'\')">报价详情</a></td>';
		str = str + '</tr>';
    }
	$("#tbodyId").html(str);
}
//查看详情
function getQuoteInfo(id,difMinute){
	//iframe层-父子操作
	var index = layer.open({
	    type: 2,
	    area: ['1100px', '800px'],
	    fix: false, //不固定
	    maxmin: true,
	    content: 'quoteInfo.htm?id=' + id + '&difMinute=' + encodeURI(encodeURI(difMinute))
	});
	layer.full(index);
}
//获取时间
function getTime(difMinute){
	var time = '';
	
	difMinute = parseInt(difMinute);
	if(difMinute < 60){
		time = difMinute + '分';
	}else{
		var difHour = parseInt(difMinute/60);
		difMinute = difMinute%60;
		if(difHour <24){
			time = difHour + '小时' + difMinute + '分';
		}else{
			var difDay = parseInt(difHour/24);
			difHour = difHour%60;
			time = difDay + '天' + difHour + '小时' + difMinute + '分';
		}
	}
	return time;
}