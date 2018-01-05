var map,driving1,driving2,dataArray = [],mouseTool;
var address;
$(function(){
	//以深圳为地图中心
	var cityName = '深圳';
	//初始化地图
	map = new AMap.Map('container',{
    resizeEnable: true,
    /*zoom: 12,*/
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

    AMap.plugin(['AMap.MouseTool','AMap.AdvancedInfoWindow','AMap.CircleEditor','AMap.Driving','AMap.Walking','AMap.Geocoder'],function(){
	    
	})
    //清除路线
    if(driving1&&driving2){
        driving1.clear();
        driving2.clear();
    }

    plan();
    mouseTool = new AMap.MouseTool(map);
    var markerOption = {
                content:"<img src='../img/start_marker_plan.png'/>",
                extData:{'flag':'point','pointId':'1'},
                offset: new AMap.Pixel(-17, -42), //相对于基点的偏移位置
                map:map//创建时直接赋予map属性
                }
    mouseTool.marker(markerOption);
    var oldDisasterMarker;
    mouseTool.on('draw',function(o){
       var draw = o.obj;
       console.info(draw)
       if(oldDisasterMarker){
           map.remove(oldDisasterMarker);
       }
       oldDisasterMarker = draw;
       var position = draw.getPosition();
       console.log(position)
       var geocoder = new AMap.Geocoder({
            radius: 1000,
            extensions: "all"
        });        
        geocoder.getAddress(position, function(status, result) {
            if (status === 'complete' && result.info === 'OK') {
                address = result.regeocode.formattedAddress;
                console.log(address) //返回地址描述
                $(".disaster_area").html(address);
            }
        });        



    })
    
})
$(document).on("click",".ensure",function(){
    dataArray = [];
    plan();
})





var plan = function plan(){
    //移除所有的地图覆盖物
    map.clearMap();;

     //构造路线导航类
    driving1 = new AMap.Driving({
        map: map,
        //panel: "panel",
        //autoFitView:true,
        hideMarkers:false
    }); 
    driving2 = new AMap.Driving({
        map: map,
        hideMarkers:false,
        // panel: "panel"
        //autoFitView:true,

    }); 
    
    var data = [];
    if(!address){
        address = "深圳市南山区马湾大道1043号";

    }
    driving1.search([
        {keyword: address,city:'深圳'},
        {keyword: '小南山公园',city:'深圳'}
    ],function(status,result){
       
        result.distanceFlag = result.routes[0].distance;
        dataArray.push(result);
        
        var startMarker = new AMap.Marker({
                position: [result.start.location.lng,result.start.location.lat],//marker所在的位置
                content:"<img src='../img/start_marker_plan.png' />",
                extData:{'flag':'point','pointId':'1'},
                offset: new AMap.Pixel(-15, -80), //相对于基点的偏移位置
                map:map//创建时直接赋予map属性
                })
        var endMarker = new AMap.Marker({
                   position: [result.end.location.lng,result.end.location.lat],
                   //marker所在的位置广东省深圳市南山区桃源街道丽水路西丽同富裕工业城
                   content:"<img src='../img/end_marker_plan.png'/>",
                   extData:{'flag':'point','pointId':'1'},
                   offset: new AMap.Pixel(0, -43), //相对于基点的偏移位置
                   map:map//创建时直接赋予map属性
        })
        searchDriving2();

        map.setZoom(13);

        
    });

    var searchDriving2 = function searchDriving2(){
        driving2.search([
        {keyword: address,city:'深圳'},
        {keyword: '水湾',city:'深圳'}
        ],function(status,result){
            
            result.distanceFlag = result.routes[0].distance;
            dataArray.push(result);
            var endMarker = new AMap.Marker({
                       position: [result.end.location.lng,result.end.location.lat],
                       //marker所在的位置广东省深圳市南山区桃源街道丽水路西丽同富裕工业城
                       content:"<img src='../img/end_marker_plan.png'/>",
                       extData:{'flag':'point','pointId':'1'},
                       offset: new AMap.Pixel(0, -43), //相对于基点的偏移位置
                       map:map//创建时直接赋予map属性
            })
            searchWalking();
        });

    }

    var searchWalking = function searchWalking(){

        //步行导航
        var walking = new AMap.Walking({
            map: map,
            //panel: "panel"
        }); 
        walking.search([
            {keyword: address,city:'深圳'},
            {keyword: '月亮湾公园 ',city:'深圳'}
        ],function(status,result){
          
            result.flag = "walking";
            result.distanceFlag = result.routes[0].distance;
            dataArray.push(result);
            var endMarker = new AMap.Marker({
                       position: [result.end.location.lng,result.end.location.lat],
                       //marker所在的位置广东省深圳市南山区桃源街道丽水路西丽同富裕工业城
                       content:"<img src='../img/end_marker_plan.png'/>",
                       extData:{'flag':'point','pointId':'1'},
                       offset: new AMap.Pixel(0, -43), //相对于基点的偏移位置
                       map:map//创建时直接赋予map属性
            })
            
            dataArray.sort(by("flag"));
            console.info(dataArray);
            initLeftPanel(dataArray);

        });

    }


    
      
    
    

    
   
    

}
var by = function(name){
 return function(o, p){
   var a, b;
   if (typeof o === "object" && typeof p === "object" && o && p) {
     a = o[name];
     b = p[name];
     if (a === b) {
       return 0;
     }
     if (typeof a === typeof b) {
       return a < b ? -1 : 1;
     }
     return typeof a < typeof b ? -1 : 1;
   }
   else {
     throw ("error");
   }
 }
}

var initLeftPanel  = function initLeftPanel(dataArray){
    var $path_details = $(".path_details");
    $path_details.empty();
    $.each(dataArray,function(i,v){
        var html = $('<li>'+
                        '<div class="circuit">'+
                            '<div><span>1</span>.</div>'+
                            '<div class="onset">'+
                                '<p>从 <span class="start">'+v.start.name+'</span></p>'+
                                '<p>到 <span class="finish">'+v.end.name+'</span></p>'+
                            '</div>'+ 
                            '<div class="strike"></div>'+
                            '<div class="currentLap">'+
                                '<p class="howLong">'+Math.round(v.routes
[0].time/60)+'分钟</p>'+
                                '<p class="totalLenght">'+Math.round(v.routes
[0].distance/1000)+'公里</p>'+
                            '</div>'+
                            '<div class="walk" id='+v.end.id+' ></div>'+
                        '</div>'+
                        '<div class="StartNavigation">'+
                            '<div class="journey">'+
                                '<span>'+v.start.name+'</span>'+
                            '</div>'+
                            '<ul class='+v.end.id+'>'+
                                '<li>直行780米</li>'+
                                '<li>50米后 向左前方直行 进入临海大道</li>'+
                                '<li>25米后 左转 进入妈湾大道</li>'+
                            '</ul>'+
                        '</div>'+
                    '</li>').appendTo($path_details);
        if(v.flag){
            $("#"+v.end.id).removeClass("vehicle");

            $("#"+v.end.id).addClass("walk_style");
        }else{
            $("#"+v.end.id).removeClass("walk_style");
            $("#"+v.end.id).addClass("vehicle");
        }
   
        $(".result_plan").html($path_details.children(":last").children(":first").children(".currentLap").children(":last").html());

        var $ul = $("."+v.end.id);
        $ul.empty();
        $.each(v.routes[0].steps,function(i,v){
            $('<li>'+v.instruction+'</li>').appendTo($ul);

        })
        
        $(".disaster_area").html(v.start.name)



    })
    



}


