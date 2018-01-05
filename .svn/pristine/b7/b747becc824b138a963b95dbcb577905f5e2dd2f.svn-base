    //创建marker
    var createMarker = function createMarker(obj){
        $.each(obj.data,function(i,v){
            var marker = new AMap.Marker({
               position: v.lonlat,//marker所在的位置
               icon: new AMap.Icon({  //复杂图标
                    size: new AMap.Size(100, 100),//图标大小
                    image: v.image, //大图地址
                    // imageOffset: new AMap.Pixel(-28, 0)//相对于大图的取图位置
               }),
               content:"<img src='"+v.image+"' class='image_style_marker'/>",
               extData:{'id':v.id},
               map:map//创建时直接赋予map属性
            })
        })
        
    }

   var getAllData = personnelDispatch.getAllData();
   $('.baseOption :checkbox').change(function(){
       var key = $(this).attr('value');
       if($(this).is(":checked")){
          var obj = getAllData[key];
          createMarker(obj);
       }else{
         var markerArray = map.getAllOverlays('marker');
         $.each(markerArray,function(i,v){
            var markerId = v.getExtData().id;
            if(key == markerId){
               map.remove(v);
            }
         })
       }

   })

  
    