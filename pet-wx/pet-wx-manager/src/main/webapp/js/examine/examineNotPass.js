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
	var type = '';
	var phoneNumber = '';
	if($("#type").val() == 1){
		type = $('#userType').val();
	}else if($("#type").val() == 2){
		phoneNumber = $("#typeValue").val();
	}
	
	layer.load(2);//遮罩层
	$.ajax({
	      url: "queryExamineNotPass.htm",
	      datatype: 'json',
	      type: "post",
	      data: {
	    	  begin:(pageNum-1)*pageSize,
	    	  rows:pageSize,
	    	  type:type,
	    	  phoneNumber:phoneNumber,
	    	  startDate:$("#startDate").val(),
	    	  endDate:$("#endDate").val()
	      },
	      success: function (data) {
	    	  layer.closeAll('loading');
	        if (data.flag == '1' && data.errorCode == '10000') {
	          table(data,pageNum);//显示列表
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
		str = str + '<td>' + data.content[i].examineId + '</td>';
		
		if(data.content[i].phoneNumber != null){
			str = str + '<td>' + data.content[i].phoneNumber + '</td>';
		}else{
			str = str + '<td></td>';
		}
		
		if(data.content[i].type==2){
			str = str + '<td>司机</td>';
		}else if(data.content[i].type==1){
			str = str + '<td>企业</td>';
		}else if(data.content[i].type==3){
			str = str + '<td>车辆</td>';
		}else if(data.content[i].type==4){
			str = str + '<td>仓储</td>';
		}else{
			str = str + '<td></td>';
		}
		
		
		if(data.content[i].createTime != null){
			str = str + '<td>' + data.content[i].createTime + '</td>';
		}else{
			str = str + '<td></td>';
		}
		
		if(data.content[i].remark != null){
			str = str + '<td>' + data.content[i].remark + '</td>';
		}else{
			str = str + '<td></td>';
		}
		
		if(data.content[i].examinePerson != null){
			str = str + '<td>' + data.content[i].examinePerson + '</td>';
		}else{
			str = str + '<td></td>';
		}
		
		if(data.content[i].examineTime != null){
			str = str + '<td>' + data.content[i].examineTime + '</td>';
		}else{
			str = str + '<td></td>';
		}
		str = str + '<td><a href="javascript:void(0)" onclick="getInfo(\'' + data.content[i].examineId + '\''+',\'' + data.content[i].type + '\')">查看详情</a> </td>';
		str = str + '</tr>';
    }
	$("#tbodyId").html(str);
}
//查看详情
function getInfo(id,type){
	if(type==1){
		//1是企业
		var index = layer.open({
		    type: 2,
		    area: ['1000px', '700px'],
		    fix: false, //不固定
		    maxmin: true,
		    content: '../user/logisticsInfoPage.htm?id=' + id
		});
		layer.full(index);
	}else if(type==2){  
		//2是司机
		var index = layer.open({
		    type: 2,
		    area: ['1000px', '700px'],
		    fix: false, //不固定
		    maxmin: true,
		    content: '../user/driverInfoPage.htm?id=' + id
		});
		layer.full(index);
	}else if(type==3){
		//3是车辆
		var index = layer.open({
		    type: 2,
		    area: ['1000px', '700px'],
		    fix: false, //不固定
		    maxmin: true,
		    content: '../logistics/truckInfoPage.htm?id=' + id
		});
		layer.full(index);
		
	}else if(type==4){
		//4是仓储
		var index = layer.open({
		    type: 2,
		    area: ['1000px', '700px'],
		    fix: false, //不固定
		    maxmin: true,
		    content: '../logistics/wareHouseInfoPage.htm?id=' + id
		});
		layer.full(index);
		
	}
	
}
function changeInput(){
	if($('#type').val() == 1){
		$('#typeValue').hide();
		$('#userType').show();
	}else{
		$('#typeValue').show();
		$('#userType').hide();
	}
	$('#userType').val('');
}