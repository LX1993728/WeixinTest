<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="utf-8">
		<title></title>
		<link rel="stylesheet" href="${pageContext.request.contextPath }/task/css/css_reset.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath }/task/css/reset.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath }/task/css/newbuild.css" />
	</head>
	<body>
	<form action="" id="templateForm">
	
		<div class="indexLogo">
			<div class="indexLogo-content">
				<div class="indexLogo-img">
					<img src="${pageContext.request.contextPath }/task/img/logo.png" />
				</div>
				<div class="sceneText">
					<p class="sceneFirst">模拟演练与培训</p>
					<p class="sceneSecond">事故情景与实施步骤配置</p>
				</div>
				<div class="add-rightBtn">
					<a href="javascript:void(0);" onclick="resolveTemplateSubmit()"><img src="${pageContext.request.contextPath }/task/img/保存.png">保存修改</a>
				</div>
			</div>	
	    </div>
	<div class="all-box">
	    <div class="basicInfo">
	        <div class="basicInfo-title">模拟演练基本信息</div>
	        <div class="basicInfo-info">
	            <p class="basicInfo-name">
	            	<label class="basicInfoName">演练名称</label>
	            	<input type="text" name="name" class="basicInfoInput">
	            </p>
	            <p class="basicInfo-name basicInfo-name1">
	            	<label class="basicInfoName basicInfoName1">演练地点</label>
	            	<input type="text" name="address" class="basicInfoInput">
	            </p>
	            <div class="basicInfo-name basicInfo-name2">
		           <%--  	<label class="basicInfoName basicInfoName2">事发时间</label>
		            	<input type="text" name="time" class="basicInfoInput basicInfoInput1">
		            	<img src="${pageContext.request.contextPath }/task/img/2.png" class="selectdate"> --%>
	            	 	<div class="demo1">
                        <label class="basicInfoName basicInfoName2">事发时间</label>
	        				<input type="text" name="time" id="J-xl-2">
	        				<label class="basicInfo-calendar" id="J-xl-2-btn" ></label>	
                    </div>
	            </div>
	        </div>
	        <div class="basicInfo-rank">
	        	<p class="basicInfo-rankTitle">事发分类定级</p>
	        	<div class="basicInfo-select">
	        		<select class="rank-first" name="eventBigType">
                    <option value ="请选择事件大类">请选择事件大类</option>
                    <option value ="事故灾难">事故灾难</option>
                    <option value="自然灾害">自然灾难</option>
                    <option value="audi">Audi</option>
                </select>
                <select class="rank-first rank-second" name="eventDetailType">
                    <option value ="请选择细分种类">请选择细分种类</option>
                    <option value ="危险化学品事故">危险化学品事故</option>
                    <option value="安全生成事故">安全生成事故</option>
                </select>
                <select class="rank-first rank-third" name="eventCategory">
                    <option value ="请选择事件级别">请选择事件类别</option>
                    <option value ="一般事故(Ⅳ级)">一般事故(Ⅳ级)</option>
                    <option value="较大事故(Ⅲ级)">较大事故(Ⅲ级)</option>
                    <option value="重大事故(Ⅱ级)">重大事故(Ⅱ级)</option>
                    <option value="特别重大事故(Ⅰ级)">特别重大事故(Ⅰ级)</option>
                </select>
	        	</div>
	        	
	        </div>
	        <div class="basicInfo-team">
	        	<p class="team-name">参演单位(组别)</p>
	        	<div class="team-list">
	        		<div class="team-item"><input type="text" name="orgList[0]" placeholder="请输入单位名称"><label class="team-delete">x</label></div>
	        		<div class="team-item team-itemlast"><a href="javascript:;">添加</a></div>	
	        </div>
	    </div>
	    <div class="basicInfo-sence">
	    	<div class="sence-box">
	    	    <div class="sence-title">演练场景设置阶段</div>
	    	    <div class="sence-nav">
	    	    	<a href="javascript:void(0);" onclick="resolveScene(this)" target="iframehtml" class="yanshi"><span></span></a>
	    	    	<div class="sence-navlist">
	    	    		<span class="sence-navitem navitemfirst firstSceneStyleActive"><a href="javascript:void(0);" useId="-1" onclick="resolveScene(this)" target="iframehtml">场景概述</a></span>
	                        
	    	    		<span class="sence-navitem navitemlast"><a href="javascript:void(0);" onclick="resolveScene(this)" useId="100" target="iframehtml">总结评估</a></span>
	    	            
	    	    	</div>
	    	    	<div class="sence-navbutton">
	    	    		<span class="sencebutton sence-navdelbtn" id="delInputBtn">删除流程</span>
	    	    		<span class="sencebutton sence-navaddbtn">添加流程</span>
	    	    		<span class="sencebutton sence-navaddchildbtn">添加子流程</span>
	    	    	</div>
	    	    </div>
	        </div>
	     </div>
	     <div class="iframeBox">
	    	<iframe src="toScenePage?name=newSceneFirst" id="sceneFrames" class="content" name="iframehtml" height="1000px" frameborder="0" scrolling="no" width="1872px"></iframe>
	     <div> 
	    </div>
	    	
	    <div class="pop-box">
	    <div class="pop-up1">
	            <span class="poptitle">请输入阶段名称</span>
	    	    <input type="text" placeholder="请输入流程名称" id="popo1" />
	    	    <input type="button" value="确认" id="pop-sure1" />
	    	    <input type="button" value="取消" id="pop-del1"/>
	    </div>
	    <div class="pop-up2">
	            <span class="poptitle"></span>
	    	    <input type="text" placeholder="请输入流程名称" id="popo2" />
	    	    <input type="button" value="确认" id="pop-sure2"/>
	    	    <input type="button" value="取消" id="pop-del2"/>
	    </div>
	    </div>
	 </form>
	</body>
	<script type="text/javascript" src="${pageContext.request.contextPath }/task/js/jquery.min.js" ></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/task/js/newbuild.js" ></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/task/js/uploadimg.js" ></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/task/time/laydate.dev.js"></script>
	<script type="text/javascript">
	$(function(){
		//event 参数中有 data 属性，就是父窗口发送过来的数据
		window.addEventListener("message", function( event ) { 
			var info = JSON.parse(event.data);
			// alert("======callback()===="+event.data+"===="+(info=='A'));
			if(info != 'A'){ // 进行场景跳转
				
				// 修改样式
				var nextId = info.uuid; 
				$(".active").removeClass("active");
				$(".firstSceneStyleActive").removeClass("firstSceneStyleActive");
				if(nextId == '-1'){
					$("a[useId='-1']").parent().addClass("firstSceneStyleActive");
				}else if(nextId == '100'){
					$("a[useId='100']").parent().addClass("firstSceneStyleActive");
				}else{
					var middle = $("input[useId="+nextId+"]");
					/* middle.siblings().removeClass('active'); */
					middle.addClass("active");
				}
				
				$("#sceneFrames").attr("src",info.src);
				// alert($("#sceneFrames").attr("src")+"===data.src==="+info.src);
			}else{ // AJAX进行模板表单的提交
				// 提交之前 先进行模板属性的校验
				if(!tempValidate()){
					alert('表单项不能有空值');
					return;
				}
				
				// 首先获取所有的UUID数组
				var uuids = [];
			    uuids.push('-1');
			    $('.sence-navitem.senceAdd').each(function (index,domEle){
					uuids.push($(domEle).attr('useId'));
			    	});
			    uuids.push('100');
           		// alert('stage uuis='+JSON.stringify(uuids));
           		
			    // 进行模板的form表单提交
			   $.ajax({ 
				    url: "${pageContext.request.contextPath }/template/template_submit?uuids="+JSON.stringify(uuids), 
				    type:"POST",
				    data:$('#templateForm').serialize(),
				    success: function(data){
				    		$(location).attr('href', '${pageContext.request.contextPath }/index');
				    },
				     error:function(data){
				        	alert('请为新建的场景阶段赋值');
				 }}); 
			    
			}
		}, false ); 
	})
	function resolveScene(aDOM){
		var  isFirst = $(aDOM).parent().hasClass('navitemfirst');
		var  isLast = $(aDOM).parent().hasClass('navitemlast');
		
		// 如果既不是第一个，又不是最后一个，说明是中间的自定义场景
		var  isLevelOne = $(aDOM).hasClass('senceone');
		var  isLevelTwo = $(aDOM).hasClass('sencetwo');
		var  isLevelThree = $(aDOM).hasClass('sencethree');
		
		var obj = {};
		/* $(".active").removeClass("active");
		$(".firstSceneStyleActive").removeClass("firstSceneStyleActive"); */
		if(isFirst){
			obj.level = 1;
			obj.name = '场景概述';
			obj.uuid =  '-1';
			obj.src = 'toScenePage?name=newSceneFirst';
			document.getElementById("sceneFrames").contentWindow.postMessage( JSON.stringify(obj),"*"); 
			// $(aDOM).parent().addClass("firstSceneStyleActive")
		}
		
		if(isLast){
			obj.level = 1;
			obj.name = '总结评估';
			obj.uuid = '100';
			obj.src = 'toScenePage?name=newSceneLast';
			document.getElementById("sceneFrames").contentWindow.postMessage( JSON.stringify(obj),"*");
			// $(aDOM).parent().addClass("firstSceneStyleActive")
		}
		
		if(!isFirst && !isLast){ // 说明是中间阶段
			if(isLevelOne){
				obj.level = 1;
			}
			if(isLevelTwo){
				obj.level = 2;
			}
			if(isLevelThree){
				obj.level = 3;
			}
			
			//  设置唯一标识
			obj.uuid = $(aDOM).attr("useId");
			// 设置场景名称
			obj.name = $(aDOM).attr("value");
			obj.src = "toScenePage?name=newSceneMiddle";
			
			
			// 如果是中间阶段 需要修改iframe的src属性
		    document.getElementById("sceneFrames").contentWindow.postMessage( JSON.stringify(obj),"*"); 
		   
		}
		
	}
	
	// 处理整个模板表单提交
	function resolveTemplateSubmit(){
		 // 向子frame场景发送消息进行提交
		 document.getElementById("sceneFrames").contentWindow.postMessage( JSON.stringify('A'),"*")
	};
	
	// 处理时间组件
	document.getElementById('J-xl-2-btn').onclick = function(){
     laydate({
         istime: true,
         format:'YYYY-MM-DD hh:mm:ss',
         elem: '#J-xl-2'
     });
	}
	
	// 模板整体表单校验
	// 场景概述 表单校验
	var tempValidate = function(){
		var formData = $('#templateForm').serializeArray();
		for(i=0;i<formData.length;i++){
			// console.log(formData[i].name+" ===== "+formData[i].value);
			if(formData[i].value == null || formData[i].value.trim().length == 0){
				return false;
			}
		}
		return true;
	};
	</script>
</html>
