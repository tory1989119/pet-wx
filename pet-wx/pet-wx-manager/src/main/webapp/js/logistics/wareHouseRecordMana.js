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
	var wareHouseTypeValue='';
	if($('#searchTypeId').val() == '1'){
		wareHouseTypeValue = $('#wareHouseTypeValue').val();
	}
	layer.load(2);//遮罩层
	$.ajax({
	      url: "queryWareHouseRecord.htm",
	      datatype: 'json',
	      type: "post",
	      data: {
	    	  begin:(pageNum-1)*pageSize,
	    	  rows:pageSize,
	    	  type:wareHouseTypeValue,
	    	  province:$("#province").val(),
	    	  city:$("#city").val(),
	    	  area:$("#area").val()
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
		str = str + '<td>' + data.content[i].id + '</td>';
		str = str + '<td>' + data.content[i].examinePerson + '</td>';
		str = str + '<td>' + data.content[i].warehouseId +'</td>';
		str = str + '<td>' + data.content[i].name + '</td>';
		str = str + '<td>' + data.content[i].address + '</td>';
		if(data.content[i].contact != null){
			str = str + '<td>' + data.content[i].contact + '</td>';
		}else{
			str = str + '<td></td>';
		}
		str = str + '<td>' + data.content[i].phoneNumber + '</td>';
		str = str + '<td>' + data.content[i].createTime + '</td>';
		str = str + '</tr>';
    }
	$("#tbodyId").html(str);
}

//查询条件显示
function searchType(){
	if($('#searchTypeId').val() == 1){
		$('#searchTypeValue').hide();
		$('#wareHouseTypeValue').show();
	}else{
		$('#searchTypeValue').show();
		$('#wareHouseTypeValue').hide();
	}
	$('#searchTypeValue').val('');
	$('#wareHouseTypeValue').val('');
}

//获取市
function getCity(){
	$.ajax({
	      url: "../../sys/admin/getCytyOrArea.htm",
	      datatype: 'json',
	      type: "post",
	      data: {
	    	  type:'1',
	    	  keyWord:$('#province').val()
	      },
	      success: function (data) {
	        if (data.flag == '1' && data.errorCode == '10000') {
	        	$('#city').empty();
              	 $('#city').append("<option value=''>选择市</option>");
              	 for(var i = 0; i < data.content.length; i++) {
              		 $('#city').append("<option value='" + data.content[i].city + "'>" + data.content[i].city +"</option>");
				}
	        }
	      }
	    });
}
//获取区
function getArea(){
	$.ajax({
	      url: "../../sys/admin/getCytyOrArea.htm",
	      datatype: 'json',
	      type: "post",
	      data: {
	    	  type:'2',
	    	  keyWord:$('#city').val()
	      },
	      success: function (data) {
	        if (data.flag == '1' && data.errorCode == '10000') {
	        	$('#area').empty();
            	 $('#area').append("<option value=''>选择区或县</option>");
            	 for(var i = 0; i < data.content.length; i++) {
            		 $('#area').append("<option value='" + data.content[i].area + "'>" + data.content[i].area +"</option>");
				}
	        }
	      }
	    });
}

var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
//关闭窗口并刷新页面
function closeIf(){
    parent.layer.close(index);
}