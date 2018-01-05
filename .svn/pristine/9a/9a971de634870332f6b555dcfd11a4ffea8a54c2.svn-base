var map,mouseTool,infowindow;
$(function(){
	//以深圳为地图中心
	var cityName = '深圳';
	//初始化地图
	map = new AMap.Map('container',{
    resizeEnable: true,
    zoom: 10,
    // center: [116.480983, 40.0958]
    });
    map.setCity(cityName);

    //背景样式
    map.setMapStyle('amap://styles/grey');

    //卫星图层
    var tileLayer = new AMap.TileLayer.Satellite();
    tileLayer.setMap(map);

    //标注（point 去掉）
    var features = ['bg','road','building'];
    map.setFeatures(features);

    AMap.plugin(['AMap.MouseTool','AMap.AdvancedInfoWindow','AMap.CircleEditor','AMap.Driving','AMap.DistrictSearch'],function(){
	    
	})

    initBuildAction();
    /*map.on('dragstart',function(){
    	alert("dsf")
    	mouseTool.close();
    })*/
   
    
})
    	
//空楼行动点击事件
$(document).on('click','.build',function(){
	removeAll();
	initBuildAction();
})



//空楼行动
var initBuildAction = function initBuildAction(){
    mouseTool = new AMap.MouseTool(map);
	//事发点marker
	var marker;
	var createPointMarket = function createPointMarket(){
        //清除所有覆盖物
		map.clearMap();
		marker = new AMap.Marker({
		           position: [113.9828,22.584842],//marker所在的位置
		           content:"<img src='../img/point.png' />",
				   extData:{'flag':'point','pointId':'1'},
				   offset: new AMap.Pixel(-17, -42), //相对于基点的偏移位置
		           map:map//创建时直接赋予map属性
    	        })


	}

	createPointMarket();
	
	// createAllBoatMarker();
    //事发点提示信息
	var infoWindow = new AMap.InfoWindow({
	        isCustom: true,  //使用自定义窗体
	      /*  content: "<div class='point_style'>事发点<div/>",*/
	        content: "<div class='orientate'>事发点"+
				"<div class='fixedPoint'>"+
				"</div>"+
			"</div>",
	        offset: new AMap.Pixel(15, -60)
	    });
	infoWindow.open(map, marker.getPosition());

    //矩形
	var polygonOption = {
				         strokeColor: "#E25237", //线颜色
				         strokeOpacity: 1, //线透明度
				         strokeWeight: 1, //线粗细度
				         fillColor: "#FC330D", //填充颜色
				         fillOpacity: 0.47,//填充透明度);
				         zIndex:110
		    			};

	//监听矩形按钮点击事件
	var domEventListener = AMap.event.addDomListener(document.getElementById('rectangle'), 'click', function() {
		//可以写polygonOption 也可以不写默认样式				
		mouseTool.rectangle(polygonOption);
		endHouseArray = [];
		
	}, false);

	//监听现场指挥部按钮点击事件
	var domEventListener = AMap.event.addDomListener(document.getElementById('command'), 'click', function() {
		
		//画指挥部
		//markerOption 也可以不写默认样式
		var markerOption = {
	           content:"<img src='../img/web/五角星拷贝.png' class='image_style_marker'/>",
	        };				
		mouseTool.marker(markerOption);
	}, false);

   
    //监听矩形draw事件
	var drawMarker,drawRemoveRectangle,drawRectangle,firstCircle,secondCircle,firstCircleOption,secondCircleOption,circleEditor;
	mouseTool.on('draw',function(o){
		var draw = o.obj;
		//指挥部marker画完
		if(draw.CLASS_NAME == 'AMap.Marker'){
			if(drawMarker){
				drawMarker.hide();
			}
			drawMarker = draw;
			
			//事发点
			var markerPosition = marker.getPosition();
		    var lnglat = new AMap.LngLat(markerPosition.lng, markerPosition.lat);
			//计算指挥所与事发点的距离
			console.log(draw.getPosition())
			var zhbPosition = draw.getPosition();
			var distance = lnglat.distance([zhbPosition.lng, zhbPosition.lat]);
			$(".distance").html(countDistance(distance));

		}else{

			if(draw.contains(marker.getPosition())){
    	   	 	// console.log('点在矩形内');
    	   	 	var circleArray = map.getAllOverlays('circle');
    	   	 	var rectangle = map.getAllOverlays('polygon');
    	   	 	if(circleArray){
    	   	 		map.remove(circleArray);
    	   	 	}
    	   	 	if(rectangle.length>1){
    	   	 		if(drawRectangle){
    	   	 			map.remove(drawRectangle);
    	   	 		}
    	   	 		
    	   	 	}
    	   	 	drawRectangle = draw;
                //矩形的面积
                $('.rectangleArea').html(Math.round(draw.getArea()/1000000));
    	   	 	//矩形的位置
				var lng = marker.getPosition().lng;
				var lat = marker.getPosition().lat;
				//矩形的位置坐标
				var northEast = draw.getBounds().getNorthEast();
				var southWest = draw.getBounds().getSouthWest();
				var lnglat = new AMap.LngLat(northEast.lng, northEast.lat);
				//计算圆的半径
				var radius = lnglat.distance([southWest.lng, southWest.lat]);
				var firstRadius = radius*0.8;
				$('.firstRadius').val(countDistance(firstRadius));
				//圆的面积
				$('.firstCirclArea').html(countCicleArea(firstRadius));
                //第一个圆
                firstCircleOption = {
			        center: new AMap.LngLat(lng, lat),// 圆心位置
			        radius: firstRadius, //半径
			        strokeColor: "#f5be22", //线颜色
			        strokeOpacity: 1, //线透明度
			        strokeWeight: 1, //线粗细度
			        fillColor: "#ceb076", //填充颜色
			        fillOpacity: 0.56,//填充透明度
			        zIndex:105,
			        map:map
			    };
            	firstCircle = new AMap.Circle(firstCircleOption);

    			//第二个圆
    			var secondRadius = radius*1.3;
    			$('.secondRadius').val(countDistance(secondRadius));
    			//圆的面积
				$('.secondCirclArea').html(countCicleArea(secondRadius));
    			secondCircleOption = {
			        center: new AMap.LngLat(lng, lat),// 圆心位置
			        radius: secondRadius, //半径
			        strokeStyle:"dashed",
			        strokeColor: "#000000", //线颜色
			        strokeOpacity: 1, //线透明度
			        strokeWeight: 1, //线粗细度
			        fillColor: "#656C71", //填充颜色
			        fillOpacity: 0.72,//填充透明度
			        map:map
			    };
			    secondCircle = new AMap.Circle(secondCircleOption);
			    //计算房屋

			   
			    judgeMarker(getHouseData.place,draw);
			    judgeMarker(getHouseData.company,draw);
			    judgeMarker(getHouseData.boat,draw);
			    initRightHouseInfo();

			   




    	   	}else{
    	   		console.log('点不在矩形内');
    	   		if(drawRemoveRectangle){
					drawRemoveRectangle.hide();
				}
				drawRemoveRectangle = draw;
			    //当前的隐藏掉
				draw.hide();
    	   	}
		}
		mouseTool.close(); 
		
		/*circleEditor = new AMap.CircleEditor(map,firstCircle);
		mouseTool.close(); 
		circleEditor.open(); */
   	});
   /* circleEditor.on('adjust',function(type, target, radius){


    })*/
	
    $('.firstRadius').change(function(){
    	mouseTool.close();
    	var currentRadius = parseInt($(this).val());
    	
    	//清掉第一个圆,重新画
    	firstCircle.setMap(null);
    	firstCircleOption.radius = currentRadius*1000;
    	$('.firstCirclArea').html(countCicleArea(currentRadius*1000));
    	firstCircle = new AMap.Circle(firstCircleOption);
    	/*circleEditor.close();
    	circleEditor = new AMap.CircleEditor(map,firstCircle);
		mouseTool.close(); 
		circleEditor.open(); */
    });
    $('.secondRadius').change(function(){
    	mouseTool.close();
    	var currentRadius = parseInt($(this).val());
    	//清掉第一个圆,重新画
    	secondCircle.setMap(null);
    	secondCircleOption.radius = currentRadius*1000;
    	$('.secondCirclArea').html(countCicleArea(currentRadius*1000));
    	secondCircle = new AMap.Circle(secondCircleOption);
    })
  


}
//疏散规划点击事件
$(document).on('click','#plan',function(){
	removeAll();
	plan();
})
		


//衍生灾害
$(document).on('click','.disaster',function(){
	removeAll();
	disaster();
})
var disaster  = function disaster(){
	//移除所有的地图覆盖物
	map.remove(map.getAllOverlays());

	var disasterMarker = new AMap.Marker({
		           position: [113.9828,22.584842],
		           //marker所在的位置广东省深圳市南山区桃源街道丽水路西丽同富裕工业城
		           icon: new AMap.Icon({  //复杂图标
			            // size: new AMap.Size(27, 36),//图标大小
			            image: 'image/marker.png' //大图地址
			            // imageOffset: new AMap.Pixel(-28, 0)//相对于大图的取图位置
		           }),
					   extData:{'flag':'point','pointId':'1'},
					   // offset: new AMap.Pixel(0, -20), //相对于基点的偏移位置
		           map:map//创建时直接赋予map属性
    	        })

	 

}

var countDistance = function countDistance(distance){
	return Math.round(distance / 1000);

}

var removeAll = function removeAll(){

	mouseTool.close();
	//清除路线
	if(driving1&&driving2){
		driving1.clear();
	    driving2.clear();
	}
	

}

var countCicleArea = function countCicleArea(radius){

	return Math.round(3.14 * radius * radius /1000000);

}
var boatMap = intelligentScene.getBoatData();

var createBoatMarker = function createBoatMarker(obj){

	$.each(obj,function(i,v){
        	
			var marker = new AMap.Marker({
	           position: v.lonlat,//marker所在的位置
	           content:"<img src='"+v.image+"' />",
			   extData:v.id,
	           map:map//创建时直接赋予map属性
	        })
        	
    	
        })

}
var createAllBoatMarker = function createAllBoatMarker(){
	
	createBoatMarker(boatMap.HCData);
	createBoatMarker(boatMap.KCData);
	createBoatMarker(boatMap.SJCData);
	createBoatMarker(boatMap.TLData);
	createBoatMarker(boatMap.ZFCData);
}
var getHouseData = intelligentScene.getHouseData();
var createAllHouseMarker = function createAllHouseMarker(){
	createHouseMarker(getHouseData.place);
	createHouseMarker(getHouseData.company);
	createHouseMarker(getHouseData.boat);


}
var createHouseMarker = function createHouseMarker(house){

	$.each(house,function(i,v){
        	
		var marker = new AMap.Marker({
           position: v.lonlat,//marker所在的位置
           title:v.text,
           content:"<img src='"+v.image+"' class='image_style_marker' />",
		   extData:v.id,
           map:map//创建时直接赋予map属性
        })
    	
     })



}
var endHouseArray = [];
var judgeMarker = function judgeMarker(array,draw){

	$.each(array,function(i,v){
    	if(draw.contains(v.lonlat)){
    		console.log("shi")
    		endHouseArray.push(v);
    	}

    })
    createHouseMarker(endHouseArray);
    


}

var initRightHouseInfo = function initRightHouseInfo(){
	console.log($(".topic_bare"))
	$(".topic_bare").empty();
	var count = 0;
	$.each(endHouseArray,function(i,v){
		
		$('<li>'+
				'<div>'+v.text+'</div>'+
				'<div>'+v.tel+'</div>'+
				'<div class="dw_marker" data='+JSON.stringify(v)+'></div>'+
				'</li>').appendTo($("#"+v.id))
		count += v.personNum;

	})
	$(".place_num").html($("#place").children().length);
	$(".company_num").html($("#company").children().length);
	$(".boat_num").html($("#boat").children().length);
	$(".person_house_num").html(count);


}
$(document).on('click','.dw_marker',function(){
	var data = $(this).attr('data');
	var house = JSON.parse(data);
	map.setCenter(house.lonlat)
})


