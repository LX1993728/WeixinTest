<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>Document</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/task/css/reset.css" />
	<style>

/*滚动条*/
.assessBox::-webkit-scrollbar {
	width: 10px;  
	height: 0px;  
	background-color: #F5F5F5;  
	}  
/*定义滚动条轨道 内阴影+圆角*/  
.assessBox::-webkit-scrollbar-track {
	-webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.28);  
	background: #6f747c ;  
}  
/*定义滑块 内阴影+圆角*/  
.assessBox::-webkit-scrollbar-thumb {
	border-radius: 3px;  
	-webkit-box-shadow: inset 0 0 6px rgba(0,0,0,.3);  
	background-color:rgba(53, 58, 60, 1);  
	}  
.assessBox::-webkit-scrollbar-thumb:hover {
	border-radius: 3px;  
	-webkit-box-shadow: inset 0 0 6px rgba(0,0,0,.3);  
	backgro
}
.assess{
	position: relative;
	margin:auto;
	/* margin-top:20px; */
	width:1870px;
	height:678px;
	background: rgba(6,13,24,0.7);
}
.assess-left{
	float: left;
	width:1379px;
	height:678px;
	border:1px solid #146062;
	border-radius: 5px;
}
.assess-lefttitle{
	width:1359px;
	padding-left:20px;
	height:61px;
	line-height: 61px;
	font-size: 27px;
	letter-spacing: -1px;
	color: #ebf7ff;
	background: rgba(21,90,191,0.25);
}
.assessBox{
	width:1378px;
	height:419px;
	overflow: auto;
}

.assess-ablity{
	position: relative;
	padding:5px 0px 0 20px;
	width:1339px;
	height:152px;
	border-bottom:0px solid #154285;
}
.assess-ablityleft{
	float:left;
	width:540px;
	height:152px;
}
.assess-name{
	line-height: 30px;
	font-size: 24px;
	color: #ebf7ff;
}
.assess-ablitychose{
	width: 540px;
	height: 64px;
	border:0;
	outline: none;
	background: rgba(21,90,191,0.25);
	border-radius: 3px;
	margin-top:10px;
	font-size:25px;
	color:#fff;
	text-indent:15px;
}
.assess-ablityright{
	float:right;
	width:730px;
	height:152px;
}
.assess-img{
	margin-top:10px;
	width:730px;
	height:72px;
}
#file_input{
	/*position:absolute;
	margin-top:-50px;
	opacity:0;*/
	display:none;
	width:72px;
	height:72px;
	overflow:hidden;
}
.result{
	position:absolute;
	margin-top:-72px;
	width:72px;
	height:72px;
	background: url(${pageContext.request.contextPath }/task/img1/sence2.png)no-repeat;
}
#result>img{
	width:72px;
	height:72px;
}
.assess-imgclose{
	position: absolute;
	margin-top: -85px;
	margin-left:52px;
}
.assess-imginfo{
	margin-top:-72px;
	font-size: 25px;
	color:#fff;
	text-indent:15px;
	float: right;
	border:0;
	outline: none;
	width:646px;
	height:72px;
	background: rgba(21,90,191,0.25);
}
.assess-imgdel{
    position:absolute;
    right:20px;
    margin-top:10px;
	text-decoration: underline;
	font-size: 20px;
	line-height: 24px;
	letter-spacing: 0px;
	color: #d2d2d2;
	cursor: pointer;
}
.assess-summery{
	position: relative;
	padding:26px 0px 20px 20px;
	width:1339px;
	height:214px;
	border-bottom:1px solid #154285;
}
.assess-summerytitle{
	position:relative;
	display:inline-block;
	width:150px;
	height:64px;
    font-size: 24px;
	letter-spacing: -1px;
	color: #ebf7ff;
}
.assess-summery>textarea{
	border:0;
	outline: none;
	width:1160px;
	height:130px;
	background: rgba(21,90,191,0.25);
	float: right;
	font-size: 24px;
	color: #fff;
	text-indent:15px;
}
.assess-summerysave{
	position:absolute;
    right:20px;
    top:183px;
	display: block;
	width:155px;
	height:56px;
	text-align: center;
	line-height:56px;
	font-size:24px;
	color: #ebf7ff;
	border-radius: 5px;
	background: #1f90e6;
	cursor:pointer;
}
.assess-newbuild{
	padding-top:40px;
	padding-left:32px;
	text-decoration: underline;
	font-size: 26px;
	line-height: 24px;
	letter-spacing: 0px;
	color: #89b1ef;
	cursor:pointer;
}
.assess-right{
	float: right;
	width:485px;
	height:678px;
	border:1px solid #146062;
	border-radius:5px;
}
.assess-template{
	width:470px;
	height:61px;
	line-height: 61px;
	padding-left:20px;
	font-size: 27px;
	color: #ebf7ff;
	background: rgba(21,90,191,0.25);
}
.assess-templatecon{
	width:462px;
	height:597px;
	padding:20px 10px 0 14px;
}
.assess-templatecon>span{
	margin-right:9px;
	margin-bottom:12px;
	font-size: 24px;
	color:#fff;
	text-align: center;
	line-height: 50px;
	display: block;
	float:left;
	width: 220px;
	height: 50px;
	background-color: #237bfd;
	border-radius: 3px;
	border: solid 1px #777c83;
	background: rgba(21,90,191,0.45);	
}
.pop-up3{
	width:574px;
	height:331px;
	border-radius: 5px;
	background-color:rgba(23,48,68,0.9);
	position:fixed;
	left:50%;
	margin-left:-287px;
	top:200px;
	left:900px;
	z-index: 999;
}
.poptitle{
	display:inline-block;
	width:574px;
	height:61px;
	background-color:rgba(21,90,191,0.6);
}
#popo3{
	width:536px;
	height:64px;
	border:0;
	outline: none;
	border-radius: 5px;
	background-color:rgba(21,90,191,0.41);
	font-size:20px;
	text-indent:10px;
	color:#fff;
	margin-left:18px;
	margin-top:30px;
}
input[type="text"]::-webkit-input-placeholder { /* WebKit browsers */ 
	color: #c9c3c3;
} 
#pop-sure3,#pop-del3{
	float: left;
    border:0;
    outline: none;
    width:155px;
    height:56px;
    line-height: 56px;
    text-align: center;	
    background:#1f90e6;
    font-size:24px;
    color: #ebf7ff;
    border-radius:5px;
    margin-top:56px;
}
#pop-sure3{
	margin-left:18px;
}
#pop-del3{
	margin-left:225px;
}
	</style>
</head>
<body>
	<form action="" id="sceneLastFormId">
	<div class="assess">
	    	<div class="assess-left">
	    		<p class="assess-lefttitle">响应能力总结</p>
	    		<div class="assessBox">
	    		<c:if test="${scene eq null }">
		    		<div class="assess-ablity">
		    			<div class="assess-ablityleft">
		    				<p class="assess-name">能力名称</p>
		    				<select class="assess-ablitychose customBox" name="abilities[0].name">
	                            <option value ="原因清查">原因清查</option>
	                            <option value ="伤亡情况">伤亡情况</option>
	                            <option value="应急响应">应急响应</option>
	                            <option value="预警发布">预警发布</option>
	                            <option value ="舆情控制">舆情控制</option>
	                            <option value ="自定义" class="custom">自定义</option>
	                            
	                        </select>
		    			</div>
		    			<div class="assess-ablityright">
		    				<p class="assess-name">图片素材</p>
		    				<p class="assess-img">
		    					<div id="preview_0">
								<img id="imghead_0" border="0"
										src="${pageContext.request.contextPath }/task/img1/sence2.png"
										class="result" onClick="$('#previewImg_0').click();">
							</div>
								<input type="file" onChange="previewImage(this,0)"
									style="display: none;" id="previewImg_0">
								<input type="hidden" id="url_0" name="abilities[0].url" />
			    					<input type="text" placeholder="文字说明" name="abilities[0].desc" class="assess-imginfo"/>
		    				</p>
		    			</div>
		    		</div>
		    	    	<div class="assess-summery">
		    	    		<label class="assess-summerytitle">总结评估</label>
		    	    		<textarea placeholder="请输入该阶段的场景说明" id="assess_0" name="abilities[0].assess"></textarea>
		    	    		<span class="assess-summerysave">保存为模版</span>	
		    	    </div>
	    		</c:if>
	    		
	    		<c:if test="${scene ne null }">
	    			<c:forEach items="${scene.abilities }" var="ability" varStatus="status">
			    		<div class="assess-ablity">
			    			<div class="assess-ablityleft">
			    				<p class="assess-name">能力名称</p>
			    				<select class="assess-ablitychose" name="abilities[${status.index }].name" >
		                            <option value ="原因清查" ${ability.name eq '原因清查'?'selected':'' } >原因清查</option>
		                            <option value ="伤亡情况" ${ability.name eq '伤亡情况'?'selected':'' }>伤亡情况</option>
		                            <option value="应急响应" ${ability.name eq '应急响应'?'selected':'' }>应急响应</option>
		                            <option value="预警发布" ${ability.name eq '预警发布'?'selected':'' }>预警发布</option>
		                            <option value ="舆情控制" ${ability.name eq '舆情控制'?'selected':'' }>舆情控制</option>
		                    </select>
			    			</div>
			    			<div class="assess-ablityright">
			    				<p class="assess-name">图片素材</p>
			    				<p class="assess-img">
			    					<div id="preview_${status.index }">
									<img id="imghead_${status.index }" border="0"
											src="${pageContext.request.contextPath }/imgs/${ability.url}"
											class="result" onClick="$('#previewImg_${status.index}').click();">
								</div>
									<input type="file" onChange="previewImage(this,${status.index })"
										style="display: none;" id="previewImg_${status.index }">
									<input type="hidden" id="url_${status.index }" name="abilities[${status.index }].url" value="${ability.url }"/>
				    					<input type="text" placeholder="文字说明" name="abilities[${status.index }].desc" value="${ ability.desc}" class="assess-imginfo"/>
			    				</p>
			    			</div>
			    		</div>
			    	    	<div class="assess-summery">
			    	    		<label class="assess-summerytitle">总结评估</label>
			    	    		<textarea placeholder="请输入该阶段的场景说明" id="assess_${status.index }" name="abilities[${status.index }].assess">${ability.assess }</textarea>
			    	    		<span class="assess-summerysave">保存为模版</span>	
			    	    </div>
	    			</c:forEach>
	    		</c:if>
	    	    
	    	    </div>
	    	    <div class="assess-summerynew">
	    	    	<p class="assess-newbuild">新创建</p>
	    	    </div>
	    	</div>
	    	<div class="assess-right">
	    		<p class="assess-template">常用模版</p>
	    		<div class="assess-templatecon">
	    			<span>原因清查</span>
	    			<span>接警与信息报送</span>
	    			<span>原因清查</span>
	    			<span>原因清查</span>
	    			<span>接警与信息报送</span>
	    			<span>原因清查</span>
	    			<span>原因清查</span>
	    		</div>
	    	</div>
	    	<div class="pop-box3" style="display:none">
			    <div class="pop-up3">
			            <span class="poptitle"></span>
			    	    <input type="text" placeholder="请输入能力名称" id="popo3" />
			    	    <input type="button" value="确认" id="pop-sure3" />
			    	    <input type="button" value="取消" id="pop-del3"/>
			    </div>
		    </div>
	    </div>
	</form>
	<script type="text/javascript" src="${pageContext.request.contextPath }/task/js/jquery.min.js" ></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/task/js/newbuild.js" ></script>
	<script type="text/javascript"
	src="${pageContext.request.contextPath }/task/js/uploadimg.js"></script>
	<script type="text/javascript">
			$(function(){
				//event 参数中有 data 属性，就是父窗口发送过来的数据
				window.addEventListener("message", function( event ) { 
					var info = JSON.parse(event.data);
					// alert('====First 子frame====='+event.data);
					if(!lastValidate()){
						alert('表单项不能有空值');
						return;
					}
					if( info != 'A'){ // 说明是场景提交阶段
						// ajax 提交表单,并将返回的uuid 进行拼接
						 $.ajax({ 
						    url: "${pageContext.request.contextPath }/template/stageLast_submit?name="+info.name+"&level="+info.level+"&uuid="+info.uuid, 
						    type:"POST",
						    data:$('#sceneLastFormId').serialize(),
						    success: function(uuid){
						    	if(uuid != null){
						    		info.src =info.src+"&uuid="+uuid;
						    	}
								window.parent.postMessage(JSON.stringify(info),'*');
						     },
						        error:function(data){
						 }}); 
					}else{
						 $.ajax({ 
						    url: "${pageContext.request.contextPath }/template/stageLast_submit", 
						    type:"POST",
						    data:$('#sceneLastFormId').serialize(),
						    success: function(uuid){
						    		window.parent.postMessage(JSON.stringify('A'),'*');	
						    },
						        error:function(data){
						 }}); 
						
					}
					
				}, false ); 
			})
			
			
		var lastValidate = function(){
			var formData = $('#sceneLastFormId').serializeArray();
			for(i=0;i<formData.length;i++){
				// console.log(formData[i].name+" ===== "+formData[i].value);
				if(formData[i].value == null || formData[i].value.trim().length == 0){
					return false;
				}
			}
			return true;
		};
		</script>
</body>
</html>
