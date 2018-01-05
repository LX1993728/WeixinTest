var map;
$(function(){
	//以深圳为地图中心
	var cityName = '深圳';
	//初始化地图
	map = new AMap.Map('container',{
    resizeEnable: true,
    zoom: 11,
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

    disaster();
   
   
    
})
var endDisasterArray = [];
var disaster  = function disaster(){
    map.clearMap();
    var disasterMarker = new AMap.Marker({
                   position: [113.9828,22.584842],
                   //marker所在的位置广东省深圳市南山区桃源街道丽水路西丽同富裕工业城
                   icon: new AMap.Icon({  //复杂图标
                        // size: new AMap.Size(27, 36),//图标大小
                        image: 'image/marker.png' //大图地址
                        // imageOffset: new AMap.Pixel(-28, 0)//相对于大图的取图位置
                   }),
                   content:"<img src='../img/point.png' />",
                   extData:{'flag':'point','pointId':'1'},
                   // offset: new AMap.Pixel(0, -20), //相对于基点的偏移位置
                   map:map//创建时直接赋予map属性
                })
    //圆
    firstCircleOption = {
        center: disasterMarker.getPosition(),// 圆心位置
        radius: 30000, //半径
        strokeColor: "#f5be22", //线颜色
        strokeOpacity: 1, //线透明度
        strokeWeight: 1, //线粗细度
        fillColor: "#ceb076", //填充颜色
        fillOpacity: 0.56,//填充透明度
        zIndex:105,
        map:map
    };
    var firstCircle = new AMap.Circle(firstCircleOption);
    console.log(disasterData);
    var disasterMap = disasterData.getDisasterData();
    judgeMarker(disasterMap.HGCData,firstCircle);
    judgeMarker(disasterMap.JHCData,firstCircle);
    



}
var judgeMarker = function judgeMarker(array,draw){

    $.each(array,function(i,v){
        if(draw.contains(v.lonlat)){
            endDisasterArray.push(v);
        }

    })
    createDisasterMarker(endDisasterArray);
    


}
var createDisasterMarker = function createDisasterMarker(disaster){

    $.each(disaster,function(i,v){
            
        var marker = new AMap.Marker({
           position: v.lonlat,//marker所在的位置
           title:v.text,
           content:"<img src='"+v.image+"' class='image_style_marker_disaster' />",
           extData:v.id,
           map:map//创建时直接赋予map属性
        })
        
     })

}