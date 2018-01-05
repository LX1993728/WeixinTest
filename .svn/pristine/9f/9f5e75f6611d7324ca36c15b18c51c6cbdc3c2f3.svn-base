$(function(){
	
	$(".tabbox .tab a").click(function(){
		$(this).addClass('on').siblings().removeClass('on');
		var index = $(this).index();		
		$('.tabbox .tabcontent li').hide();
		$('.tabbox .tabcontent li:eq('+index+')').show();
	});
	/*getStatisticData();
	getPersonNum();
	getDate();*/
	
	setInterval(function(){
		getStatisticData();
		getPersonNum();
		getDate();
		
	},5000)
	
	

  
})
var getStatisticData = function getStatisticData(){
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
	 			  valueArray.push(value);
	 		  })
	 	  })
	 	  valueObj.value = valueArray;
	 	  initFirstLevel(indicatorArray,valueObj);
	 	  
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
	 			  valueArray.push(value);
	 		  })
	 	  })
	 	  valueObj.value = valueArray;
	 	  initSecondLevel(indicatorArray,valueObj);
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
	 	    createThirdLevel(valueArray);
		  
		    $.each(data['sumScore'],function(i,v){
		    	$(".allScore").html(v)
		    })
		   
		}
   })
}
var initFirstLevel = function initFirstLevel(indicatorArray,valueObj){
	 var myChart = echarts.init(document.getElementById('firstLevel'));
	 //myChart.dispose();
	 var option = {
			    
			    tooltip: {},
			    legend: {
			      
			    },
			    radar: {
			        // shape: 'circle',
			        name: {
			        	formatter: function (value, indicator) {
			        	    return value +" "+indicator.per+ "%" + "(" +indicator.score+ ")";
			        	},
			            textStyle: {
			                color: '#fff',
			                /*backgroundColor: '#2ec7c9',
			                borderRadius: 3,
			                padding: [3, 5]*/
			                fontSize:18,
			                padding:7,
			                width:100
			           }
			        },
			        indicator: indicatorArray,
			        center:[200, 200],
			        splitNumber: 3,
			        radius: '70%',
			        splitArea: {
			            areaStyle: {
			                color: 'rgba(146,189,255,0.54)',
			                /*shadowColor: 'rgba(0, 0, 0, 0.5)',
			                shadowBlur: 10*/
			            }
			        },
			    },
			    series: [{
			        name: '一级指标分析',
			        type: 'radar',
			        areaStyle: {normal: {
			        	 color: 'rgba(146,189,255,1)',
			        }},
			        lineStyle:{
			        	normal:{
			        		color:'#92bdff'
			        	}
			        },
			        symbolSize:0,
			        data : [valueObj]
			    }]
			};
	  myChart.setOption(option);
}
var initSecondLevel = function initSecondLevel(indicatorArray,valueObj){
	 var myChart = echarts.init(document.getElementById('secondLevel'));
	 var option = {
			    
			    tooltip: {},
			    legend: {
			      
			    },
			    radar: {
			        // shape: 'circle',
			        name: {
			        	formatter: function (value, indicator) {
			        	    return value +" "+indicator.per+ "%"+"(" +indicator.score+ ")";
			        	},
			            textStyle: {
			                color: '#fff',
			                /*backgroundColor: '#2ec7c9',
			                borderRadius: 3,
			                padding: [3, 5]*/
			                fontSize:18,
			           }
			        },
			        indicator: indicatorArray,
			        center:[230, 160],
			        splitNumber: 3,
			        radius: '60%',
			        splitArea: {
			            areaStyle: {
			                color: 'rgba(146,189,255,0.54)',
			                /*shadowColor: 'rgba(0, 0, 0, 0.5)',
			                shadowBlur: 10*/
			            }
			        },
			    },
			    series: [{
			        name: '二级指标分析',
			        type: 'radar',
			        areaStyle: {normal: {
			        	 color: 'rgba(146,189,255,1)',
			        }},
			        lineStyle:{
			        	normal:{
			        		color:'#92bdff'
			        	}
			        },
			        symbolSize:0,
			        data : [valueObj]
			    }]
			};
	  myChart.setOption(option);
}

var createThirdLevel = function createThirdLevel(array){
	var $sumRank = $(".sumRank");
	$sumRank.empty();
	$.each(array,function(i,v){
		var $html = $('<p><span class="sumRank-title">'+v.name+'</span><span class="sumRank-num"><span class="sumRank-demo" data='+v.name+'></span></span><p>')
		$sumRank.after($html);
		$(".sumRank-demo").each(function(i,dom){
			if($(dom).attr("data") == v.name){
				$(dom).css("width",v.value+"px");
			}
		})
	})
}

var getPersonNum = function getPersonNum(){
	$.ajax({
		url: '/statistic/getPersonNum',
		type: "post",
		dataType: 'JSON',
	 	success:function(data){
	 		console.log("人数")
	 	    console.log(data);
	 		$(".allPersonnum").html(data.count);
	 	}
	})
}

var getDate = function getDate(){
	$.ajax({
		url: '/statistic/getTaskTime',
		type: "post",
		dataType: 'JSON',
	 	success:function(data){
	 		console.log("时间")
	 		console.log(data);
	 		$(".allDate").html(data.hour);
	 		$(".allDateMin").html(data.min);
	 	}
	})
}



