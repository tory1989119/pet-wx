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
	layer.load(2);//遮罩层
	$.ajax({
	      url: "querySendHelp.htm",
	      datatype: 'json',
	      type: "post",
	      data: {
	    	  begin:(pageNum-1)*pageSize,
	    	  rows:pageSize,
	    	  dateType:$("#dateType").val(),
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
		$("#tbodyId").html('<tr ><td colspan="9">无数据</td></tr>');
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
		if(data.content[i].licensePlate != null){
			str = str + '<td>' + data.content[i].licensePlate + '</td>';
		}else{
			str = str + '<td></td>';
		}
		str = str + '<td>' + data.content[i].rName + '</td>';
		str = str + '<td>' + data.content[i].rPhoneNumber + '</td>';
		str = str + '<td>' + data.content[i].sName + '</td>';
		str = str + '<td>' + data.content[i].sPhoneNumber + '</td>';
		if(data.content[i].status == 6){
			str = str + '<td>帮送完成</td>';
		}else{
			str = str + '<td>帮送中</td>';
		}
		if(data.content[i].shippingDate != null){
			str = str + '<td>' + data.content[i].shippingDate + '</td>';
		}else{
			str = str + '<td></td>';
		}
		if(data.content[i].arriveTime != null){
			str = str + '<td>' + data.content[i].arriveTime + '</td>';
		}else{
			str = str + '<td></td>';
		}
		str = str + '</tr>';
    }
	$("#tbodyId").html(str);
}