var map,pathSimplifierIns,mouseTool;
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
    
    //鼠标操作插件
    
    AMap.plugin(['AMap.MouseTool','AMap.AdvancedInfoWindow'],function(){
        mouseTool = new AMap.MouseTool(map);
    })
    
    getPersonOnline();
    
    
    
    //搜索判断
    $(".startSeek").click(function(){
    	var txt = $(".staffSearch>input").val()+"";
    	$.each(getPersonData,function(i,v){
     	  if(v.deptName.indexOf(txt) != -1 && txt.length != 0){
     	  		$(".SearchShow>ul").html("");
     	  		$(".SearchShow>ul").append('<li class="personelList"></li>');
     	  		var $li = $('.personelList');
       			var parentHtml = $('<div class="showList" data='+JSON.stringify(v)+'>'+
                                   	 '<div class="showList_headline">'+v.deptName+'<span class=""></span></div>'+
                                   	 '<div class="w_png"></div>'+
                                   	 '</div><ul class="userList" flag='+v.deptId+'></ul>').appendTo($li);
        
      			var $ul;
        		$.each(v.deptUser,function(index,value){
            	$ul = $('.userList');
            	$.each($ul,function(i,dom){
                var parentId = value.parentId;
                if(parentId == $(dom).attr("flag")){
                    var userHtml;
                    if(value.online){
                        userHtml = $('<li class="staffDetails" data='+JSON.stringify(value)+'>'+
                                                '<div><input type="checkbox" id='+value.userId+' /></div>'+
                                                '<div class="staffIcon_style">'+value.userName+'</div>'+
                                                '<div>音频</div>'+
                                                '<div>视频</div>'+
                                            '</li>').appendTo($(dom));

                    }else{
                        userHtml = $('<li class="staffDetails" data='+JSON.stringify(value)+'>'+
                                                '<div><input type="checkbox" id='+value.userId+' /></div>'+
                                                '<div class="staffIcon_style_out">'+value.userName+'</div>'+
                                                '<div class="staff_grey">音频</div>'+
                                                '<div class="staff_grey">视频</div>'+
                                            '</li>').appendTo($(dom));

                    }
                }
            })
        });
       	
       	
       	
       }
        
    })
    	
    	if(txt == " "){
    		$(".SearchShow>ul").append('<li class="personelList"></li>');
   			var $li = $('.personelList');
    		$.each(getPersonData,function(i,v){
        	var parentHtml = $('<div class="showList" data='+JSON.stringify(v)+'>'+
                                    '<div class="showList_headline">'+v.deptName+'<span class=""></span></div>'+
                                    '<div class="w_png"></div>'+
                                    '</div><ul class="userList" flag='+v.deptId+'></ul>').appendTo($li);
        
        
        	var $ul;
        	$.each(v.deptUser,function(index,value){
            $ul = $('.userList');
            $.each($ul,function(i,dom){
                var parentId = value.parentId;
                if(parentId == $(dom).attr("flag")){
                    var userHtml;
                    if(value.online){
                        userHtml = $('<li class="staffDetails" data='+JSON.stringify(value)+'>'+
                                                '<div><input type="checkbox" id='+value.userId+' /></div>'+
                                                '<div class="staffIcon_style">'+value.userName+'</div>'+
                                                '<div>音频</div>'+
                                                '<div>视频</div>'+
                                            '</li>').appendTo($(dom));

                    }else{
                        userHtml = $('<li class="staffDetails" data='+JSON.stringify(value)+'>'+
                                                '<div><input type="checkbox" id='+value.userId+' /></div>'+
                                                '<div class="staffIcon_style_out">'+value.userName+'</div>'+
                                                '<div class="staff_grey">音频</div>'+
                                                '<div class="staff_grey">视频</div>'+
                                            '</li>').appendTo($(dom));

                    }
                }
            })
        });
    })
    
    	}
    	
    })
     
    
    
	var circleOption = { radius: 1000, //半径
				         strokeColor: "#F33", //线颜色
				         strokeOpacity: 1, //线透明度
				         strokeWeight: 3, //线粗细度
				         fillColor: "#ee2200", //填充颜色
				         fillOpacity: 0.35//填充透明度);
		    			};
	//监听按钮点击事件
    var clickGroupCircleFlag = false;
	var domEventListener = AMap.event.addDomListener(document.getElementById('groupCirle'), 'click', function() {
		//可以写circleOption 也可以不写默认样式	

		mouseTool.circle();
        if(clickGroupCircleFlag){
            $("#groupCirle").removeClass("groupCirle_highlight");
            mouseTool.close(true);
            clickGroupCircleFlag = false;
            $(".staffDetails :checked").prop("checked",false);

        }else{
            $("#groupCirle").addClass("groupCirle_highlight");
            clickGroupCircleFlag = true;
        }
        
       
       
	}, false);
	//删除监听
    // AMap.event.removeListener(domEventListener);

	//鼠标工具绘制覆盖物结束时触发此事件 
	var data ;
    if(mouseTool){
         mouseTool.on('draw',function(o){
        //隐藏上一次的圈组
        if(data){
            data.obj.hide();
        }
        data = o;
        var groupCirleUser = [];
        //获得地图上所有的覆盖物
        var markerArray = map.getAllOverlays('marker');
        console.log(markerArray)
        $.each(markerArray,function(i,v){
           if(v.getExtData().flag){
             console.log('点是否在圆内：' + o.obj.contains(v.getPosition()));
             if(o.obj.contains(v.getPosition())){
                groupCirleUser.push(v)
             }
           }
        })
        console.log(groupCirleUser)

        //让左边人员列表的复选框选中
        $(".staffDetails :checked").prop("checked",false);
        $.each(groupCirleUser,function(i,v){

            var userId = v.getExtData().userId;
            $("#"+userId).prop("checked",true);
            var $ul = $("#"+userId).closest("ul");
            if($ul.hasClass("r_show")){
            }else{
                 $("#"+userId).closest("ul").prev().trigger("click");
            }
        })
    });

    }
    
})

var getPersonData = personnelDispatch.getPersonData();

var initPersonDispatcher = function initPersonDispatcher(){
    map.clearMap();
    if(pathSimplifierIns){
        pathSimplifierIns.hide();
    }
    $.each(getPersonData,function(i,v){
        createPersonMarker(v.deptUser)
    })
}

var createPersonMarker = function createPersonMarker(user){

        $.each(user,function(i,v){
            if(v.online){
                var marker = new AMap.Marker({
                   position: v.lonlat,//marker所在的位置
                   icon: new AMap.Icon({  //复杂图标
                        // size: new AMap.Size(27, 36),//图标大小
                        image: v.image, //大图地址
                        // imageOffset: new AMap.Pixel(-28, 0)//相对于大图的取图位置
                   }),
                   content:'<img src = "'+v.image+'" />',
                   title:v.userId+''+v.userName,
                   extData:{'flag':'person','userId':v.userId},
                   offset: new AMap.Pixel(-17, -42), //相对于基点的偏移位置

                   map:map//创建时直接赋予map属性
                })
            }
        
        })

    }
var createHighlightMarker = function createHighlightMarker(user){

    var markerArray = map.getAllOverlays('marker');
        $.each(markerArray,function(i,v){
            console.log(v.getExtData());
           if(v.getExtData().userId == user.userId){
             console.log('此人员要先隐藏然后换高亮的图片');
            // v.hide();
             map.remove(v);
           }
        })
        var marker = new AMap.Marker({
               position: user.lonlat,//marker所在的位置
               content:'<img src = "'+user.image+'" />',
               title:user.userId+''+user.userName,
               extData:{'flag':'person','userId':user.userId},
               offset: new AMap.Pixel(-17, -42), //相对于基点的偏移位置
               map:map//创建时直接赋予map属性
        })



}
//清除元素
$(document).on('click','.eliminate',function(){
    map.clearMap();
    //所有的复选框去掉选中
    $(".baseOption :checkbox").prop('checked',false);


})
var getTaskData = personnelDispatch.getTaskData();
var initDynamicTask = function initDynamicTask(){
    map.clearMap();
    if(pathSimplifierIns){
        pathSimplifierIns.hide();
    }
   
    createTaskMarker(getTaskData);
    var $task = $(".d_mission .rollBox");
    $task.empty();

    $.each(getTaskData,function(i,v){
        var obj = {
             'taskId':v.taskId,
             'image':v.image,
             'lonlat':v.lonlat,
        }
        var date = new Date(),
        month = date.getMonth() + 1,
        day = date.getDate(),
        hour = date.getHours(),
        mins = date.getMinutes();
        if(month < 10) {
            month = "0" + month;
        }
        if(day < 10) {
            day = "0" + day;
        }
        if(mins < 10) {
            mins = "0" + mins;
        }
        if(hour < 10) {
            hour = "0" + hour;
        }
        var present = month + "-" + day + " " + hour + ":" + mins;
        
        var html = $('<div class="trends" data='+JSON.stringify(obj)+'>'+
                                '<ul>'+
                                    '<li>'+
                                        '<div class="posture">'+
                                            '<div>'+v.taskTitle+'<span>'+v.taskName+'</span></div>'+
                                            '<div></div>'+
                                            '<div>'+present+'</div>'+
                                       ' </div>'+
                                        '<div class="substance">'+
                                            '<div>'+v.text+'</div>'+
                                            '<div >'+
                                                '<img src='+v.taskImg+' style="width: 100%;height: 100%;"/>'+
                                            '</div>'+
                                        '</div>'+
                                    '</li>'+
                                '</ul>'+
                          '</div>').appendTo($task);


        
      })


}
var createTaskMarker = function createTaskMarker(data){

    $.each(data,function(i,v){
            
        var marker = new AMap.Marker({
           position: v.lonlat,//marker所在的位置
           content:'<img src = "'+v.image+'"/>',
           title:v.taskId+''+v.taskName,
           extData:{'flag':'task','taskId':v.taskId},
           offset: new AMap.Pixel(-17, -42), //相对于基点的偏移位置
           map:map//创建时直接赋予map属性
        })
           
        
    })
}

var createHighlightTaskMarker = function createHighlightTaskMarker(task){

    var markerArray = map.getAllOverlays('marker');
    $.each(markerArray,function(i,v){
        console.log(v.getExtData());
        if(v.getExtData().taskId == task.taskId){
          console.log('此任务要先隐藏然后换高亮的图片');
          // v.hide();
          map.remove(v);
        }
    })
    var marker = new AMap.Marker({
       position: task.lonlat,//marker所在的位置
       content:'<img src = "'+task.image+'"/>',
       // title:v.taskId+''+v.taskName,
       extData:{'flag':'task','taskId':task.taskId},
       offset: new AMap.Pixel(-17, -42), //相对于基点的偏移位置
       map:map//创建时直接赋予map属性
    })
           



}

var initAllocateSupplies = function initAllocateSupplies(){
    map.clearMap();
    //航线
      AMapUI.load(['ui/misc/PathSimplifier', 'lib/$', 'lib/utils'], function(PathSimplifier, $, utils) {

        if (!PathSimplifier.supportCanvas) {
            alert('当前环境不支持 Canvas！');
            return;
        }

        var defaultRenderOptions = {
            pathNavigatorStyle: {
                initRotateDegree: 0,
                width: 16,
                height: 16,
                autoRotate: true,
                lineJoin: 'round',
                content: 'defaultPathNavigator',
                fillStyle: '#087EC4',
                strokeStyle: '#116394', //'#eeeeee',
                lineWidth: 1,
                pathLinePassedStyle: {
                    lineWidth: 2,
                    strokeStyle: 'rgba(8, 126, 196, 1)',
                    borderWidth: 1,
                    borderStyle: '#eeeeee',
                    dirArrowStyle: false
                }
            }
        };
        pathSimplifierIns = new PathSimplifier({

            zIndex: 100,

            map: map,

            getPath: function(pathData, pathIndex) {

                return pathData.path;
            },
            getHoverTitle: function(pathData, pathIndex, pointIndex) {

                if (pointIndex >= 0) {
                    //point 
                    return pathData.name + '，点:' + pointIndex + '/' + pathData.path.length;
                }

                return pathData.name + '，点数量' + pathData.path.length;
            },
            renderOptions: defaultRenderOptions
        });

        window.pathSimplifierIns = pathSimplifierIns;


        pathSimplifierIns.setData([{
            name: 'Test',
            path: PathSimplifier.getGeodesicPath([114.350091,22.644424], [113.950091,22.744424], 50)
        }]);

        pathSimplifierIns.setSelectedPathIndex(0);


        navg = pathSimplifierIns.createPathNavigator(0, {

            loop: true,
            speed: 10000,
            pathNavigatorStyle: {
                //content: 'none'
            }
        });
        map.setZoom(10)

        navg.start();
    });
              
}

var getPersonOnline = function getPersonOnline(){
	console.log(1234)
	$.ajax({
 		url: '/map/getPersonOnline',
 		type: "post",
 		dataType: 'JSON',
 		success:function(data){
 			 console.log(data)
 			 $.each(getPersonData,function(i,v){ 
 				$.each(v.deptUser,function(index,value){
 					$.each(data,function(key,val){
 						if(key == value.userId){
 							if(val == "Online"){
 								value.online = true;
 							}else{
 								value.online = false;
 							}
 						}
 	 				})
 				})
 			 })
 			initLeftPerson();
 			initPersonDispatcher();
 		}
   })
}

var initLeftPerson = function initLeftPerson(){
	//渲染左边人员调度
	console.log(123)
    $(".SearchShow>ul").append('<li class="personelList"></li>');
    var $li = $('.personelList');
    $.each(getPersonData,function(i,v){
        var parentHtml = $('<div class="showList" data='+JSON.stringify(v)+'>'+
                                    '<div class="showList_headline">'+v.deptName+'<span class=""></span></div>'+
                                    '<div class="w_png"></div>'+
                                    '</div><ul class="userList" flag='+v.deptId+'></ul>').appendTo($li);
        
        
        var $ul;
        $.each(v.deptUser,function(index,value){
            $ul = $('.userList');
            $.each($ul,function(i,dom){
                var parentId = value.parentId;
                if(parentId == $(dom).attr("flag")){
                    var userHtml;
                    if(value.online){
                        userHtml = $('<li class="staffDetails" data='+JSON.stringify(value)+'>'+
                                                '<div><input type="checkbox" id='+value.userId+' /></div>'+
                                                '<div class="staffIcon_style">'+value.userName+'</div>'+
                                                '<div class="videoGroup" flag="single">音频</div>'+
                                                '<div class="videoGroup" flag="single">视频</div>'+
                                            '</li>').appendTo($(dom));

                    }else{
                        userHtml = $('<li class="staffDetails" data='+JSON.stringify(value)+'>'+
                                                '<div><input type="checkbox" id='+value.userId+' /></div>'+
                                                '<div class="staffIcon_style_out">'+value.userName+'</div>'+
                                                '<div class="staff_grey videoGroup" flag="single">音频</div>'+
                                                '<div class="staff_grey videoGroup" flag="single">视频</div>'+
                                            '</li>').appendTo($(dom));

                    }
                }
            })
        });
    })
    
}
$(document).on("click",".videoGroup",function(){
	var dataIdArray = [];
	var single = false;
	if($(this).attr("flag")){
		single = true;
		var dataString = $(this).parent().attr("data");
		var data = JSON.parse(dataString);
		dataIdArray.push(data.userId);
	}else{
		$(".staffDetails :checkbox").each(function(i,dom){
			if($(dom).is(":checked")){
				var dataString = $(dom).closest(".staffDetails").attr("data");
				var data = JSON.parse(dataString);
				dataIdArray.push(data.userId);
			}
		})
	}
	
	console.log(dataIdArray)
	if(dataIdArray.length>0){
		$.ajax({
	 		url: '/map/callPersonOnlineVideo',
	 		type: "post",
	 		dataType: 'JSON',
	 		data:{
	 			userId:JSON.stringify(dataIdArray),
	 			single:single
	 		},
	 		success:function(data){
	 			console.log(data);
	 		}
	   })
	}
	
})

