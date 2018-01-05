
$(function(){
	// 一级菜单显示隐藏切换
	$("#sunBotNav-menu .sunBotNav-menuList1").click(function(e){
		$(this).children('i').toggle();
		$(this).parent().siblings().children().children('.icon_pullDown').hide();
		$(this).parent().siblings().children().children('.icon_pullRight').show();
		$(this).siblings('.sunBotNav-menuList2').toggle("slow");
		$(this).parent().siblings().find('.sunBotNav-menuList2').hide("slow");
		e.stopPropagation();
	});

	// 二级菜单显示隐藏切换
	var $sunBotNav_lis = $("#sunBotNav-menu .sunBotNav-menuList2 .sunBotNav-menuList2-nav");
	$sunBotNav_lis.click(function(e){
		$(this).children('i').toggle();
		$(this).parent().siblings().find('.icon_pullDown').hide();
		$(this).parent().siblings().find('.icon_pullRight').show();
		$(this).siblings('.sunBotNav-menuList3').toggle();
		$(this).parent("li").siblings('li').children('.sunBotNav-menuList3').hide();
		e.stopPropagation();
	})
	


	//给三级菜单绑定点击事件，点击时显示对应文档信息和评分
	$(".sunBotNav-menuList3 ul li span").click(function(){
		$("li").removeClass('on')
		$(this).parent().addClass('on')
		//隐藏掉其他不对应文档和评分
		var text = $(this).text().toString();
		$.each(summaryData,function(i,v){
			$.each(v.second,function(i,value){
				$.each(value.three,function(i,obj){
					if(obj.name == text){
						$("#delContent").children().remove()
						var contentList = obj.content;
						$("#delContent").append(contentList)
					}
				
			    })

			})
		})
       
	});
	setInterval(function(){
		getStatisticDataBox();
	},4000)
	
})
var getStatisticDataBox = function getStatisticDataBox(){
	$.ajax({
		url: '/statistic/getStatisticData',
		type: "post",
		dataType: 'JSON',
	 	success:function(data){
	 	  console.info(data)
	 	  var indicatorArray = [];
	 	  var valueObj = {};
	 	  var valueArray = [];
	 	  $.each(data['一级指标'],function(i,v){
	 		  $.each(v,function(key,value){
	 			  var obj = {};
	 			  obj.name = key;
	 			  obj.max = 2;
	 			  obj.per = Math.round(value/2*100);
	 			  if(key == "演练准备"){
	 				 obj.score = Math.round(value/2*25) +"/25";
	 			  }else if(key == "演练实施"){
	 				 obj.score = Math.round(value/2*65)+"/65";
	 			  }else{
	 				 obj.score = Math.round(value/2*10)+"/10";
	 			  }
	 			  indicatorArray.push(obj)
	 			 
	 		  })
	 	  })
	 	  
	 	  initFirstBottom(indicatorArray);
	 	  
	 	  
	 	  var indicatorArray = [];
	 	  var valueObj = {};
	 	  var valueArray = [];
	 	  $.each(data['二级指标'],function(i,v){
	 		  $.each(v,function(key,value){
	 			  var obj = {};
	 			  obj.name = key;
	 			  obj.max = 2;
	 			 obj.per = Math.round(value/2*100);
	 			  if(key == "演练组织"){
	 				 obj.score = Math.round(value/2*10) +"/10";
	 			  }else if(key == "演练方案"){
	 				 obj.score = Math.round(value/2*10)+"/10";
	 			  }else if(key == "演练保障"){
	 				 obj.score = Math.round(value/2*5)+"/5";
	 			  }else if(key == "信息沟通"){
	 				 obj.score = Math.round(value/2*20)+"/20";
	 			  }else if(key == "应急响应"){
	 				 obj.score = Math.round(value/2*35)+"/35";
	 			  }else if(key == "舆情应对"){
	 				 obj.score = Math.round(value/2*10)+"/10";
	 			  }else if(key == "演练分析"){
	 				 obj.score = Math.round(value/2*8)+"/8";
	 			  }else if(key == "资料整理"){
	 				 obj.score = Math.round(value/2*2)+"/2";
	 			  }
	 			  indicatorArray.push(obj)
	 		  })
	 	  })
	 	 // window.sessionStorage["secondArray"] = JSON.stringify(indicatorArray);
	 	  initSecondBottom(indicatorArray);
	 	  
		  var valueArray = [];
		  var thirdLevelArray = [];
		  $.each(data['三级指标'],function(i,v){
				$.each(v,function(key,value){
					var obj = {};
					obj.name = key;
					obj.value = value;
					obj.per = Math.round(value/516*100);
					if(key == "组织指挥机构"){
		 				obj.score = Math.round(value/516*6) +"/6";
		 			}else if(key == "处置队伍"){
		 				obj.score = Math.round(value/516*4) +"/4";
		 			}else if(key == "演练计划"){
		 				obj.score = Math.round(value/516*6) +"/6";
		 			}else if(key == "情景构建"){
		 				obj.score = Math.round(value/516*4) +"/4";
		 			}else if(key == "场地保障"){
		 				obj.score = Math.round(value/516*3) +"/3";
		 			}else if(key == "经费保障"){
		 				obj.score = Math.round(value/516*2) +"/2";
		 			}else if(key == "演练解说"){
		 				obj.score = Math.round(value/516*5) +"/5";
		 			}else if(key == "信息报告"){
		 				obj.score = Math.round(value/516*10) +"/10";
		 			}else if(key == "信息披露"){
		 				obj.score = Math.round(value/516*5) +"/5";
		 			}else if(key == "分级响应"){
		 				obj.score = Math.round(value/516*5) +"/5";
		 			}else if(key == "处置措施"){
		 				obj.score = Math.round(value/516*20) +"/20";
		 			}else if(key == "指挥控制能力"){
		 				obj.score = Math.round(value/516*10) +"/10";
		 			}else if(key == "舆论引导"){
		 				obj.score = Math.round(value/516*10) +"/10";
		 			}else if(key == "点评分析"){
		 				obj.score = Math.round(value/516*4) +"/4";
		 			}else if(key == "总结提炼"){
		 				obj.score = Math.round(value/516*4) +"/4";
		 			}else if(key == "演练记录"){
		 				obj.score = Math.round(value/516*2) +"/2";
		 			}
					valueArray.push(obj);
				})
			})
		  initThirdBottom(valueArray);
		}
   })
}
//渲染一级指标
var initFirstBottom = function initFirstBottom(array){
	$.each(array,function(i,v){
		$.each($(".first"),function(i,dom){
			if($(dom).html() == v.name){
				$(dom).next().next().html(v.score+" " +v.per +"%")
			}
		})
	})
	
}
//渲染二级指标
var initSecondBottom = function initSecondBottom(array){
	$.each(array,function(i,v){
		$.each($(".second"),function(i,dom){
			if($(dom).html() == v.name){
				$(dom).next().next().html(v.score+" " +v.per +"%")
			}
		})
	})
	
}
//渲染三级指标
var initThirdBottom = function initThirdBottom(array){
	$.each(array,function(i,v){
		$.each($(".third"),function(i,dom){
			if($(dom).html() == v.name){
				$(dom).next().html(v.score+" " +v.per +"%")
			}
		})
	})
	
}
