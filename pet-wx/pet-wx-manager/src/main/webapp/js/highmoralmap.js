/**
 * 
 * 封装高的地图方法 wuxiaojian 2015-12-26
 * showHighmoralmap(html,coordinate) html：坐标自定义展示框 coordinate：坐标
 * createInfoWindow(title, content) 构建自定义信息窗体
 * closeInfoWindow 关闭信息窗体
 */

var map;
function showHighmoralmap(html,coordinate){
	var lng = coordinate.split(",")[0];
	var lat = coordinate.split(",")[1];
	var lnglat = [lng, lat];
	
	//地图加载
	map = new AMap.Map('container',{
    	zoom: 10,
    	center: lnglat
	});
	
	// 添加地图类型切换插件
	map.plugin(["AMap.MapType"], function() {
		// 地图类型切换
		var mapType = new AMap.MapType({
			// 1显示卫星图 0显示正常图
			defaultType: 0,
			//叠加路网图层
			showRoad: true
		});
		map.addControl(mapType);
	});
	
	// 加载比例尺插件
	map.plugin(["AMap.Scale"], function() {
		scale = new AMap.Scale();
		map.addControl(scale);
	});
	
	//自定义鼠标样式图标
	map.setDefaultCursor("url(http://developer.amap.com/wp-content/uploads/2014/06/closedhand.cur),pointer");

	//在地图中添加ToolBar插件
	map.plugin(["AMap.ToolBar"], function() {
		toolBar = new AMap.ToolBar();
		map.addControl(toolBar);
	});
	
	//圆点显示
	var marker = new AMap.Marker({
        position: lnglat,
        map:map
  	});
  
  	//鼠标点击marker弹出自定义的信息窗体
    AMap.event.addListener(marker, 'click', function() {
        inforWindow.open(map, lnglat);
    });
	
    //展示自定义框
	var inforWindow = new AMap.InfoWindow({
		isCustom: true,  //使用自定义窗体
		autoMove: true,
		content: createInfoWindow('当前订单', html),
        offset: new AMap.Pixel(16, -45)
	});
	inforWindow.open(map, lnglat);
}

//构建自定义信息窗体
function createInfoWindow(title, content) {
    var info = document.createElement("div");
    info.className = "info";

    //可以通过下面的方式修改自定义窗体的宽高
    //info.style.width = "400px";

    // 定义顶部标题
    var top = document.createElement("div");
    var titleD = document.createElement("div");
    var closeX = document.createElement("img");
    top.className = "info-top";
    titleD.innerHTML = title;
    closeX.src = "http://webapi.amap.com/images/close2.gif";
    closeX.onclick = closeInfoWindow;

    top.appendChild(titleD);
    top.appendChild(closeX);
    info.appendChild(top);


    // 定义中部内容
    var middle = document.createElement("div");
    middle.className = "info-middle";
    middle.style.backgroundColor = 'white';
    middle.innerHTML = content;
    info.appendChild(middle);

    // 定义底部内容
    var bottom = document.createElement("div");
    bottom.className = "info-bottom";
    bottom.style.position = 'relative';
    bottom.style.top = '0px';
    bottom.style.margin = '0 auto';
    var sharp = document.createElement("img");
    sharp.src = "http://webapi.amap.com/images/sharp.png";
    bottom.appendChild(sharp);
    info.appendChild(bottom);
    return info;
}

//关闭信息窗体
function closeInfoWindow() {
    map.clearInfoWindow();
}