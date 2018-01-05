var map,driving1,driving2,driving3,dataArray = [],infoWindow;
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

    AMap.plugin(['AMap.MouseTool','AMap.AdvancedInfoWindow','AMap.CircleEditor','AMap.Driving','AMap.Walking'],function(){
	    
	})

  //清除路线
  if(driving1&&driving2){
      driving1.clear();
      driving2.clear();
  }

  treat();
   
    
})
var driving1EndMarker,driving2EndMarker,driving3EndMarker;

var treat = function treat(){
    //移除所有的地图覆盖物
    map.clearMap();;
    

     //构造路线导航类
    driving1 = new AMap.Driving({
        map: map,
        hideMarkers:false
    }); 
    driving2 = new AMap.Driving({
        map: map,
        hideMarkers:false,
        // panel: "panel"
        //autoFitView:true,

    }); 
    driving3 = new AMap.Driving({
        map: map,
        hideMarkers:false,
        // panel: "panel"
        //autoFitView:true,

    }); 
    
   
    driving1.search([
        {keyword: '深圳市南山区马湾大道1043号',city:'深圳'},
        {keyword: '深圳市第六人民医院',city:'深圳'}
    ],function(status,result){
       
        result.distanceFlag = result.routes[0].distance;
        dataArray.push(result);
        
        var startMarker = new AMap.Marker({
                position: [result.start.location.lng,result.start.location.lat],//marker所在的位置
                content:"<img src='../img/point.png' class='point_plan_style'/>",
                extData:{'flag':'point','pointId':'1'},
                offset: new AMap.Pixel(-17, -42), //相对于基点的偏移位置
                map:map//创建时直接赋予map属性
                })
        driving1EndMarker = new AMap.Marker({
                   position: [result.end.location.lng,result.end.location.lat],
                   //marker所在的位置广东省深圳市南山区桃源街道丽水路西丽同富裕工业城
                   content:"<img src='../img/treat_yu.png' class='point_plan_style'/>",
                   extData:{'flag':'point','pointId':'1'},
                   offset: new AMap.Pixel(0, -30), //相对于基点的偏移位置
                   map:map//创建时直接赋予map属性
        })
        driving1EndMarker.on("click",function(e){

           initInfoWindow('深圳市第六人民医院',driving1EndMarker)
         
        })
        searchDriving2();
        
    });

    var searchDriving2 = function searchDriving2(){

        driving2.search([
        {keyword: '深圳市南山区马湾大道1043号',city:'深圳'},
        {keyword: '南山区蛇口人民医院',city:'深圳'}
        ],function(status,result){
            
            result.distanceFlag = result.routes[0].distance;
            dataArray.push(result);
            driving2EndMarker = new AMap.Marker({
                       position: [result.end.location.lng,result.end.location.lat],
                       //marker所在的位置广东省深圳市南山区桃源街道丽水路西丽同富裕工业城
                       content:"<img src='../img/treat_yu.png' class='point_plan_style'/>",
                       extData:{'flag':'point','pointId':'1'},
                       offset: new AMap.Pixel(0, -30), //相对于基点的偏移位置
                       map:map//创建时直接赋予map属性
            })
            driving2EndMarker.on("click",function(e){

                initInfoWindow('南山区蛇口人民医院',driving2EndMarker)
         
            })
            searchDriving3();
        });
        

    }

    var searchDriving3 = function searchDriving3(){
        driving3.search([
        {keyword: '深圳市南山区马湾大道1043号',city:'深圳'},
        {keyword: '深圳市第二人民医院',city:'深圳'}
        ],function(status,result){
            
            result.distanceFlag = result.routes[0].distance;
            dataArray.push(result);
            driving3EndMarker = new AMap.Marker({
                       position: [result.end.location.lng,result.end.location.lat],
                       //marker所在的位置广东省深圳市南山区桃源街道丽水路西丽同富裕工业城
                       content:"<img src='../img/treat_yu.png' class='point_plan_style'/>",
                       extData:{'flag':'point','pointId':'1'},
                       offset: new AMap.Pixel(0, -30),//相对于基点的偏移位置
                       map:map//创建时直接赋予map属性
            })
            //事发点提示信息
            driving3EndMarker.on("click",function(e){
                initInfoWindow('深圳市第二人民医院',driving3EndMarker)
            })
            dataArray.sort(by("flag"));
            console.info(dataArray);
            initLeftTreatPanel(dataArray);
            initRightPanel();
            
        });

    }


    var initInfoWindow = function initInfoWindow(keyword,endMarker){

      $.each(endInfoArray,function(i,v){
                   if(keyword == v.text){
                        var infoWindow = new AMap.InfoWindow({
                        isCustom: true,  //使用自定义窗体
                      /*  content: "<div class='point_style'>事发点<div/>",*/
                        content: '<div class="orientate">'+
                              '<p>'+v.text+'</p>'+
                              '<p>'+v.parentName+'</p>'+
                              '<p>联系人: <span>'+v.name+'</span></p>'+
                              '<p>电话: <span>'+v.tel+'</span></p>'+
                              '<div class="fixedPoint">'+
                              '</div>'+
                            '</div>',
                        offset: new AMap.Pixel(95, -50)
                       });

                    infoWindow.open(map, endMarker.getPosition());
                  }
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

var initLeftTreatPanel  = function initLeftPanel(dataArray){
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
                            '<div class="vehicle" id='+v.end.id+' ></div>'+
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
        /*if(v.flag){
            $("#"+v.end.id).removeClass("vehicle");

            $("#"+v.end.id).addClass("walk_style");
        }else{
            $("#"+v.end.id).removeClass("walk_style");
            $("#"+v.end.id).addClass("vehicle");
        }
   */
        $(".result_plan").html($path_details.children(":last").children(":first").children(".currentLap").children(":last").html());

        var $ul = $("."+v.end.id);
        $ul.empty();
        $.each(v.routes[0].steps,function(i,v){
            $('<li>'+v.instruction+'</li>').appendTo($ul);

        })
        $(".disaster_treat").html(v.start.name)

       




    })

}
var treatData = personTreatData.getHospitalData();
var endInfoArray = [];
$.each(treatData.CSJZData,function(i,v){
  endInfoArray.push(v);
});

$.each(treatData.SSJZData,function(i,v){
   endInfoArray.push(v);
});
var initRightPanel = function initRightPanel(){
  var $divCS = $(".touch_treat_CS");
  $divCS.empty();
 
  //创伤救治
  $.each(treatData.CSJZData,function(i,v){
    var html = $('<div>'+
                  '<div class="construction">'+v.text+'</div>'+
                  '<div class="linkman">'+v.name+'</div>'+
                  '<div class="phone">'+v.tel+'</div>'+
                '</div>').appendTo($divCS);


  })

  //烧伤救治
  var $divSS = $(".touch_treat_SS");
  $divSS.empty();
  $.each(treatData.SSJZData,function(i,v){
    var html = $('<div>'+
                  '<div class="construction">'+v.text+'</div>'+
                  '<div class="linkman">'+v.name+'</div>'+
                  '<div class="phone">'+v.tel+'</div>'+
                '</div>').appendTo($divSS);

  })


}




