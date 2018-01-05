<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="utf-8">
		<title></title>
		<link rel="stylesheet" href="${pageContext.request.contextPath }/task/css/reset.css" />
		<style>
		.sence-mediaitem::-webkit-scrollbar {
		width: 10px;  
		height: 4px;  
		background: rgba(21,90,191,0.25); 
} 
.team-list::-webkit-scrollbar {
	width: 10px;  
		height: 4px;  
		background: rgba(21,90,191,0.25); 
}
.center-sencetask::-webkit-scrollbar {
	width: 10px;  
		height: 4px;  
		background: rgba(21,90,191,0.25); 
}
.center-media::-webkit-scrollbar {
	width: 10px;  
		height: 4px;  
		background: rgba(21,90,191,0.25); 
}
.center{
	width:1878px;
	height:1060px;
	border:1px solid #156164;
	border-radius: 5px;
	background: rgba(6,13,24,0.7);
}
.center-sencetask{
	width:1878px;
	height:508px;
	overflow: auto;
	border-bottom:1px solid #154285;
}
.center-sencetitle{
	padding:34px 0 30px 20px;
	font-size: 24px;
	color: #ebf7ff;
}
.center-taskbox{
	width:1838px;
	height:64px;
	margin:auto;
	margin-bottom:20px;
}
.center-left{
	margin-right:100px;
	float: left;
	width:660px;
	height:64px;
}
.center-taskname{
	display: inline-block;
	width:125px;
	height:64px;
	font-size: 24px;
	line-height:64px;
	color: #ebf7ff;
}
.center-left>input{
	float: right;
	border:0;
	outline: none;
	width:535px;
	height: 62px;
	font-size: 25px;
	color:#fff;
	text-indent:15px;
	background: rgba(21,90,191,0.25);
}
.center-right{
	float:left;
	width:610px;
}
.center-right>input{
	float: right;
	border:0;
	outline: none;
	width:485px;
	height: 62px;
	font-size: 25px;
	color:#fff;
	text-indent:15px;
	background: rgba(21,90,191,0.25);
}
.center-taskbtn{
	float: right;
	width:330px;
	height:64px;
}
.center-taskbtn>span{
	display:block;
	float: left;
	width:155px;
	height:56px;
	margin-top:4px;
	text-align: center;
	line-height:56px;
	font-size: 24px;
    color: #ebf7ff;
	border-radius: 3px;
}
.center-addbtn{
	margin-right:20px;
	background-color: #1f90e6;
}
.center-delbtn{
	background-color: #51555c;
}
.center-senceinfo{
	width:1878px;
	height:551px;
}
.center-senceinfotitle{
	width:1858px;
	padding-left:20px;
	height:80px;
	line-height: 80px;
	font-size: 24px;
	letter-spacing: -1px;
	color: #ebf7ff;
}
.center-senceitem{
	position:relative;
	margin:auto;
	width:1838px;
	height:64px;
}
.center-sencename{
	display:inline-block;
	width:125px;
	height:64px;
	line-height:64px;
	font-size: 25px;
	letter-spacing: 1px;
	color: #ffffff;
}
.center-senceitem>input{
	text-indent:15px;
	font-size: 25px;
	color:#fff;
	border:0;
	outline:none;
	width:1712px;
	height:64px;
	background: rgba(21,90,191,0.25);
}
.center-media{
	position: relative;
	width:1740px;
	padding-left:130px;
    height:360px;
    overflow: auto;
}
.center-mediatitle{
	padding-left:0;
}
.censence-upload{
	margin-top:20px;
	width:1215px;
	height:180px;
	/*background:#0ff;*/
}
.censence-mediaimg{
	width:250px;
	height:140px;
}
.censence-upload>textarea{
	position: absolute;
	margin-top:-140px;
	margin-left:316px;
	display: inline-block;
	width: 690px;
	height: 122px;
	border:0;
	outline: none;
	background: rgba(21,90,191,0.25);
	font-size: 20px;
	color:#fff;
	padding-top:18px;
	padding-left:17px;
}
.censence-mediabtn{
	position:absolute;
	width: 162px;
	height:72px;
}
.censencebtn-del{
	display:block;
	width:76px;
	height:72px;
	float:left;
	margin-top:-70px;
	margin-left:1055px;
}
.censencebtn-add{
	display:block;
	width:76px;
	height:72px;
	float:left;
	margin-top:-72px;
	margin-left:1140px;
	/*margin-right:10px;*/
}
		</style>
	</head>
	<body>
	<form action="" id="sceneMiddleFormId">
	
		<div class="center">
	    	<div class="center-sencetask">
	    		<p class="center-sencetitle">场景任务</p>
	    		<c:choose>
		    		<c:when test="${scene eq null }">
			    		<div class="center-taskbox">
			    			<p class="center-left"><label class="center-taskname">任务1:</label><input type="text" name="tasks[0].name" placeholder="各级应急响应启动"></p>
			    			<p class="center-right"><label class="center-taskname">责任组别:</label><input name="tasks[0].groups" type="text"></p>
			    			<div class="center-taskbtn">
			    				<span class="center-addbtn">添加</span>
			    				<span class="center-delbtn">删除</span>	
			    			</div>
			    		</div>
		    		</c:when>
		    		<c:otherwise>
		    			<c:forEach items="${scene.tasks }" var="task" varStatus="status">
		    				<c:choose>
			    				<c:when test="${status.index == 0 }">
						    		<div class="center-taskbox">
						    			<p class="center-left"><label class="center-taskname">任务1:</label><input type="text" name="tasks[0].name" value="${task.name }" placeholder="各级应急响应启动"></p>
						    			<p class="center-right"><label class="center-taskname">责任组别:</label><input name="tasks[0].groups" value="${task.groups }" type="text"></p>
						    			<div class="center-taskbtn">
						    				<span class="center-addbtn">添加</span>
						    				<span class="center-delbtn">删除</span>	
						    			</div>
						    		</div>
			    				</c:when>
			    				<c:otherwise>
						    		<div class="center-taskbox">
						    			<p class="center-left"><label class="center-taskname">任务${status.index +1 }:</label><input type="text" name="tasks[${status.index }].name" value="${task.name }" placeholder="各级应急响应启动"></p>
						    			<p class="center-right"><label class="center-taskname">责任组别:</label><input name="tasks[${status.index }].groups" value="${task.groups }" type="text"></p>
						    			<div class="center-taskbtn">
						    				<span class="center-delbtn">删除</span>	
						    			</div>
						    		</div>
			    				</c:otherwise>
		    				</c:choose>
		    			</c:forEach>
		    		</c:otherwise>
		    	</c:choose>
	    	</div>
	        <div class="center-senceinfo">
	        	<p class="center-senceinfotitle">场景说明</p>
	        	<p class="center-senceitem"><input type="text" name="explain" value="${scene ne null?scene.explain:'' }" placeholder="请输入该阶段的场景说明"></p>
	            <div class="center-media">
	        	    <p class="center-senceinfotitle center-mediatitle">媒体信息</p>
	        	    <c:if test="${scene eq null }">
		        	    <div class="censence-upload">
		    	    			<div class="censence-mediaimg">
		    	    				<div id="preview_0">
		                                <img id="imghead_0" border="0" src="${pageContext.request.contextPath }/task/img/addImage.png" width="250" height="140" onClick="$('#previewImg_0').click();">
	                                </div>         
	                                <input type="file" onChange="previewImage(this,0,0)" style="display: none;" id="previewImg_0">
		    	    			</div>
		    	    			<input type="hidden" id="url_0" name="imgts[0].url" />
		    	    			<textarea placeholder="文字说明" name="imgts[0].desc"></textarea>
		    	    			<div class="censence-mediabtn">
		    	    				<span class="censencebtn-del"><img src="${pageContext.request.contextPath }/task/img1/sence1.png"></span>
		    	    				<span class="censencebtn-add"><img src="${pageContext.request.contextPath }/task/img1/sence2.png"></span>
		    	    		    </div>
		    	   	 	</div>
	        	    </c:if>
	        	    <c:if test="${scene ne null }">
	        	    		<c:forEach items="${scene.imgts }" var="imgt" varStatus="status">
	        	    		   <c:choose>
	        	    		   
		        	    			<c:when test="${ status.index eq 0}">
					        	    <div class="censence-upload">
					    	    			<div class="censence-mediaimg">
					    	    				<div id="preview_0">
					                                <img id="imghead_0" border="0" src="${pageContext.request.contextPath }/imgs/${imgt.url}" width="250" height="140" onClick="$('#previewImg_0').click();">
				                                </div>         
				                                <input type="file" onChange="previewImage(this,0,0)" style="display: none;" id="previewImg_0">
					    	    			</div>
					    	    			<input type="hidden" id="url_0" name="imgts[0].url"  value="${imgt.url }"/>
					    	    			<textarea placeholder="文字说明" name="imgts[0].desc">${imgt.desc }</textarea>
					    	    			<div class="censence-mediabtn">
					    	    				<span class="censencebtn-del"><img src="${pageContext.request.contextPath }/task/img1/sence1.png"></span>
					    	    				<span class="censencebtn-add"><img src="${pageContext.request.contextPath }/task/img1/sence2.png"></span>
					    	    		    </div>
					    	   	 	</div>
		        	    			</c:when>
		        	    			<c:otherwise>
					        	    <div class="censence-upload">
					    	    			<div class="censence-mediaimg">
					    	    				<div id="preview_${status.index }">
					                                <img id="imghead_${status.index }" border="0" src="${pageContext.request.contextPath }/imgs/${imgt.url}" width="250" height="140" onClick="$('#previewImg_${status.index}').click();">
				                                </div>         
				                                <input type="file" onChange="previewImage(this,${status.index },0)" style="display: none;" id="previewImg_${status.index }">
					    	    			</div>
					    	    			<input type="hidden" id="url_${status.index}" name="imgts[${status.index }].url" value="${imgt.url }" />
					    	    			<textarea placeholder="文字说明" name="imgts[${status.index }].desc">${imgt.desc }</textarea>
					    	    			<div class="censence-mediabtn">
					    	    				<span class="censencebtn-del"><img src="${pageContext.request.contextPath }/task/img1/sence1.png"></span>
					    	    		    </div>
					    	   	 	</div>
		        	    			</c:otherwise>
		        	    		</c:choose>
	        	    		</c:forEach>
	        	    </c:if>
	        	 
	            </div>
	        </div>
	        
	    </div>
  </form>
	    <script type="text/javascript" src="${pageContext.request.contextPath }/task/js/jquery.min.js" ></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/task/js/newbuild.js" ></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/task/js/uploadimg.js" ></script>
	<script type="text/javascript">
		$(function(){
			//event 参数中有 data 属性，就是父窗口发送过来的数据
			window.addEventListener("message", function( event ) { 
				var info = JSON.parse(event.data);
				// alert('====Middle 子frame====='+event.data);
				if(!middleValidate()){
					alert('表单项不能有空值');
					return;
				}
				if( info != 'A'){ // 说明是场景提交阶段
					  // ajax 提交表单,并将返回的uuid 进行拼接
					  $.ajax({ 
					    url: "${pageContext.request.contextPath }/template/stageMiddle_submit?name="+info.name+"&level="+info.level+"&uuid="+info.uuid, 
					    type:"POST",
					    data:$('#sceneMiddleFormId').serialize(),
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
					    url: "${pageContext.request.contextPath }/template/stageMiddle_submit", 
					    type:"POST",
					    data:$('#sceneMiddleFormId').serialize(),
					    success: function(data){
					    		window.parent.postMessage(JSON.stringify('A'),'*');
					    },
					        error:function(data){
					 }});

				}
				
			}, false ); 
		})
		
		var middleValidate = function(){
			var formData = $('#sceneMiddleFormId').serializeArray();
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
