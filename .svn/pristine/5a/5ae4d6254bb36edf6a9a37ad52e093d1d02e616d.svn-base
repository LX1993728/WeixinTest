<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="UTF-8" />
<title>Document</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/task/css/reset.css" />
<style>
/*滚动条*/
.sence-mediaitem::-webkit-scrollbar {
	width: 10px;
	height: 0px;
	background-color: #F5F5F5;
}
/*定义滚动条轨道 内阴影+圆角*/
.sence-mediaitem::-webkit-scrollbar-track {
	-webkit-box-shadow: inset 0 0 6px rgba(0, 0, 0, 0.28);
	background: #6f747c;
}
/*定义滑块 内阴影+圆角*/
.sence-mediaitem::-webkit-scrollbar-thumb {
	border-radius: 3px;
	-webkit-box-shadow: inset 0 0 6px rgba(0, 0, 0, .3);
	background-color: rgba(53, 58, 60, 1);
}

.sence-mediaitem::-webkit-scrollbar-thumb:hover {
	border-radius: 3px;
	-webkit-box-shadow: inset 0 0 6px rgba(0, 0, 0, .3);
	background-color: rgba(53, 58, 60, 1);
}

/*滚动条*/
.sence-aimbox::-webkit-scrollbar {
	width: 10px;
	height: 0px;
	background-color: #F5F5F5;
}
/*定义滚动条轨道 内阴影+圆角*/
.sence-aimbox::-webkit-scrollbar-track {
	-webkit-box-shadow: inset 0 0 6px rgba(0, 0, 0, 0.28);
	background: #6f747c;
}
/*定义滑块 内阴影+圆角*/
.sence-aimbox::-webkit-scrollbar-thumb {
	border-radius: 3px;
	-webkit-box-shadow: inset 0 0 6px rgba(0, 0, 0, .3);
	background-color: rgba(53, 58, 60, 1);
}

.sence-aimbox::-webkit-scrollbar-thumb:hover {
	border-radius: 3px;
	-webkit-box-shadow: inset 0 0 6px rgba(0, 0, 0, .3);
	background-color: rgba(53, 58, 60, 1);
}

.sence-sence {
	padding-top: 24px;
	padding-bottom: 21px;
	width: 1842px;
	height: 227px;
	/*border:1px solid #146162;*/
	border-bottom: 1px solid #154285;
	margin: auto;
}

.sence-setsence {
	width: 830px;
	height: 227px;
	float: left;
}

.sence-setname {
	margin-top: 20px;
	float: left;
	display: inline-block;
	width: 125px;
	font-size: 24px;
	letter-spacing: -1px;
	color: #ebf7ff;
}

.sence-setsence>textarea {
	float: right;
	border: 0;
	outline: none;
	padding: 20px 15px 20px 15px;
	width: 670px;
	height: 187px;
	font-size: 25px;
	letter-spacing: 1px;
	color: #ffffff;
	background: rgba(21, 90, 191, 0.25);
}

.sence-setrule {
	float: right;
	margin-right: 30px;
}

.sence-rule {
	float: right;
	border: 0;
	padding: 20px 15px 20px 15px;
	width: 670px;
	height: 187px;
	font-size: 20px;
	letter-spacing: 1px;
	color: #ffffff;
	background: rgba(21, 90, 191, 0.25);
}

.sence-aim {
	position: relative;
	padding-top: 22px;
	padding-bottom: 20px;
	margin: auto;
	width: 1842px;
	min-height: 139px;
	height: auto;
	border-bottom: 1px solid #154285;
}

.sence-aimline {
	position: relative;
	width: 1842px;
	height: 56px;
}

.sence-aimtitle {
	float: left;
	font-size: 27px;
	letter-spacing: -1px;
	color: #ebf7ff;
}

.sence-aimbtn {
	display: inline-block;
	float: right;
	width: 155px;
	height: 56px;
	border-radius: 5px;
	background: rgba(21, 90, 191, 0.45);
	text-align: center;
	line-height: 56px;
	font-size: 24px;
	letter-spacing: -1px;
	color: #ebf7ff;
	cursor: pointer;
}

.sence-aimbox {
	width: 1842px;
	min-height: 126px;
	overflow: auto;
}

.sence-aimitem {
	margin-top: 15px;
	width: 830px;
	height: 64px;
	float: left;
}

.sence-aimitemright {
	margin-right: 80px;
}

.sence-aimname {
	float: left;
	display: inline-block;
	width: 125px;
	height: 64px;
	line-height: 64px;
	font-size: 24px;
	letter-spacing: -1px;
	color: #ebf7ff;
}

.sence-aimitem>input {
	float: right;
	font-size: 25px;
	text-indent: 20px;
	color: #fff;
	width: 705px;
	height: 62px;
	border: 0;
	outline: none;
	background: rgba(21, 90, 191, 0.45);
}

.sence-intro {
	width: 1842px;
	height: 64px;
	padding-top: 33px;
	padding-bottom: 33px;
	border-bottom: 1px solid #154285;
	margin: auto;
}

.sence-introbox {
	width: 1842px;
	height: 64px;
}

.sence-introtitle {
	display: inline-block;
	width: 125px;
	height: 64px;
	line-height: 64px;
	font-size: 24px;
	letter-spacing: -1px;
	color: #ebf7ff;
}

.sence-introbox>input {
	float: right;
	display: inline-block;
	width: 1715px;
	height: 64px;
	border-radius: 3px;
	border: 0;
	outline: none;
	background: rgba(21, 90, 191, 0.25);
	text-indent: 15px;
	font-size: 25px;
	color: #fff;
}

.sence-media {
	margin: auto;
	width: 1842px;
	height: 430px;
}

.sence-mediatitle {
	font-size: 27px;
	letter-spacing: -1px;
	color: #ebf7ff;
	margin-top: 28px;
}

.sence-mediaitem {
	position: relative;
	width: 1720px;
	height: 410px;
	/*background: #f00;*/
	margin-left: 132px;
	overflow: auto;
}

.sence-upload {
	margin-top: 20px;
	width: 1215px;
	height: 180px;
	/*background:#0ff;*/
}

.sence-mediaimg {
	width: 250px;
	height: 140px;
}

.sence-upload>textarea {
	position: absolute;
	margin-top: -140px;
	margin-left: 316px;
	display: inline-block;
	width: 690px;
	height: 122px;
	border: 0;
	outline: none;
	background: rgba(21, 90, 191, 0.25);
	font-size: 20px;
	color: #fff;
	padding-top: 18px;
	padding-left: 17px;
}

.sence-mediabtn {
	position: absolute;
	width: 162px;
	height: 72px;
	/*margin-top:-70px;
	left:1055px;*/
}

.sencebtn-del {
	display: block;
	width: 76px;
	height: 72px;
	float: left;
	margin-top: -70px;
	margin-left: 1055px;
}

.sencebtn-add {
	display: block;
	width: 76px;
	height: 72px;
	float: left;
	margin-top: -72px;
	margin-left: 1140px;
	/*margin-right:10px;*/
}

.pop-up1 {
	display: none;
	width: 574px;
	height: 331px;
	border-radius: 5px;
	background: #50555d;
	position: fixed;
	left: 50%;
	margin-left: -287px;
	top: 200px;
	left: 900px;
	z-index: 999;
}

.poptitle {
	display: inline-block;
	width: 574px;
	height: 61px;
	background: #415676;
}

#popo1 {
	width: 536px;
	height: 64px;
	border: 0;
	outline: none;
	border-radius: 5px;
	background: #3c66a5;
	font-size: 20px;
	text-indent: 10px;
	color: #fff;
	margin-left: 18px;
	margin-top: 30px;
}

#pop-sure1, #pop-del1 {
	float: left;
	border: 0;
	outline: none;
	width: 155px;
	height: 56px;
	line-height: 56px;
	text-align: center;
	background: #1f90e6;
	font-size: 24px;
	color: #ebf7ff;
	border-radius: 5px;
	margin-top: 56px;
}

#pop-sure1 {
	margin-left: 18px;
}

#pop-del1 {
	margin-left: 225px;
}

.pop-up2 {
	display: none;
	width: 574px;
	height: 331px;
	border-radius: 5px;
	background: #50555d;
	position: fixed;
	left: 50%;
	margin-left: -287px;
	top: 200px;
	left: 900px;
	z-index: 999;
}

#popo2 {
	width: 536px;
	height: 64px;
	border: 0;
	outline: none;
	border-radius: 5px;
	background: #3c66a5;
	font-size: 20px;
	text-indent: 10px;
	color: #fff;
	margin-left: 18px;
	margin-top: 30px;
}

#pop-sure2, #pop-del2 {
	float: left;
	border: 0;
	outline: none;
	width: 155px;
	height: 56px;
	line-height: 56px;
	text-align: center;
	background: #1f90e6;
	font-size: 24px;
	color: #ebf7ff;
	border-radius: 5px;
	margin-top: 56px;
}

#pop-sure2 {
	margin-left: 18px;
}

#pop-del2 {
	margin-left: 225px;
}
</style>
</head>
<body>
	<form id="sceneFirstFormId"
		action="${pageContext.request.contextPath }/template/stage_submit"
		method="post">
		<div class="sence-senceBox">
			<div class="sence-sence">
				<div class="sence-setsence">
					<span class="sence-setname">演练情景</span>
					<textarea name="desc" 
						placeholder="请输入演练情景概述">${scene ne null?scene.desc:'' }</textarea>
				</div>
				<div class="sence-setsence sence-setrule">
					<!-- <span class="sence-setname">演练原则</span>
	            	    <div class="sence-rule">
	            	 	   （1）结合实际、合理定位。紧密结合应急管理工作实际，明确演练目的，根据资源条件确定演练方式和规模。
                        （2）着眼实战、讲求实效。以提高应急指挥人员的指挥协调能力、应急队伍的实战能力为着眼点。重视对演练效果及组织工作的评估、考核，总结推广好经验，及时整改存在问题。
                        （3）精心组织、确保安全。围绕演练目的，精心策划演练内容，科学设计演练方案，周密组织演练活动，制订并严格遵守有关安全措施，确保演练参与人员及演练装备设施的安全。
 					 </div>     -->
					<div class="sence-setsence">
						<span class="sence-setname">演练原则</span>
						<textarea name="rule" 
							placeholder="请输入演练原则">${scene ne null?scene.rule:'' }</textarea>
					</div>
				</div>
			</div>
			<div class="sence-aim">
				<div class="sence-aimline">
					<span class="sence-aimtitle">演练目标</span> <span class="sence-aimbtn">添加</span>
				</div>
				<div class="sence-aimbox">
				<c:choose>
					<c:when test="${scene ne null}">
						<c:forEach items="${scene.targets }" var="t" varStatus="status">
							<p class="sence-aimitem sence-aimitemright">
								<label class="sence-aimname">目标${status.index +1}：</label><input
									type="text" name="targets[${status.index}]" value="${t }"
									placeholder="请输入此次演练目标">
							</p>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<p class="sence-aimitem sence-aimitemright">
							<label class="sence-aimname">目标1：</label><input type="text"
								name="targets[0]" placeholder="请输入此次演练目标">
						</p>
						<p class="sence-aimitem">
							<label class="sence-aimname">目标2：</label><input type="text"
								name="targets[1]" placeholder="请输入此次演练目标">
						</p>
					</c:otherwise>
					</c:choose>
				</div>
			</div>
			<div class="sence-intro">
				<p class="sence-introbox">
					<label class="sence-introtitle">场景说明</label><input type="text"
						name="explain" value="${scene.explain }" placeholder="请输入此次场景说明">
				</p>
			</div>
			<div class="sence-media">
				<p class="sence-mediatitle">媒体信息</p>
				<div class="sence-mediaitem">
					<c:if test="${scene ne null }">
						<c:forEach items="${scene.imgts }" var="imgt" varStatus="status">
							<div class="sence-upload">
								<div class="sence-mediaimg">
									<div id="preview_${status.index }">
										<img id="imghead_${status.index}" border="0"
											src="${pageContext.request.contextPath }/imgs/${imgt.url}"
											width="250" height="140"
											onClick="$('#previewImg__${status.index }').click();">
									</div>
									<input type="file"
										onChange="previewImage(this,${status.index },0)"
										style="display: none;" id="previewImg_${status.index}">
								</div>
								<input type="hidden" id="url_${status.index}"
									name="imgts[${status.index }].url" value="${imgt.url }" />
								<textarea placeholder="文字说明" name="imgts[${status.index }].desc">${imgt.desc }</textarea>
								<div class="sence-mediabtn">
									<span class="sencebtn-del"><img
										src="${pageContext.request.contextPath }/task/img1/sence1.png"></span>
									<span class="sencebtn-add"><img
										src="${pageContext.request.contextPath }/task/img1/sence2.png"></span>
								</div>
							</div>
						</c:forEach>
					</c:if>
					<c:if test="${scene eq null }">
						<div class="sence-upload">
							<div class="sence-mediaimg">
								<div id="preview_0">
									<img id="imghead_0" border="0"
										src="${pageContext.request.contextPath }/task/img/addImage.png"
										width="250" height="140" onClick="$('#previewImg_0').click();">
								</div>
								<input type="file" onChange="previewImage(this,0,0)"
									style="display: none;" id="previewImg_0">
							</div>
							<input type="hidden" id="url_0" name="imgts[0].url" />
							<textarea placeholder="文字说明" name="imgts[0].desc"></textarea>
							<div class="sence-mediabtn">
								<span class="sencebtn-del"><img
									src="${pageContext.request.contextPath }/task/img1/sence1.png"></span>
								<span class="sencebtn-add"><img
									src="${pageContext.request.contextPath }/task/img1/sence2.png"></span>
							</div>
						</div>
					</c:if>
				</div>
			</div>
		</div>
		</div>
	</form>
	
</body>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/task/js/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/task/js/newbuild.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/task/js/uploadimg.js"></script>
<script type="text/javascript">
$(function(){
	//event 参数中有 data 属性，就是父窗口发送过来的数据
	window.addEventListener("message", function( event ) { 
		var info = JSON.parse(event.data);
			// alert('====First 子frame====='+event.data+'===length:=='+event.data.length);
			if(!FirstValidate()){
				alert('表单项不能有空值');
				return;
			}
			if( info != 'A'){ // 说明是场景提交阶段
				// ajax 提交表单,并将返回的uuid 进行拼接
				 $.ajax({ 
				    url: "${pageContext.request.contextPath }/template/stageFirst_submit?name="+info.name+"&level="+info.level+"&uuid="+info.uuid, 
				    type:"POST",
				    data:$('#sceneFirstFormId').serialize(),
				    success: function(uuid){
				    	if(uuid != null){
				    		info.src =info.src+"&uuid="+uuid;
				    	}
						window.parent.postMessage(JSON.stringify(info),'*');
				     },
				        error:function(data){
				 }}); 
			}else{ // 说明是模板提交 先进行最后一个场景的模板提交，提交成功后向父frame发送消息
				$.ajax({ 
				    url: "${pageContext.request.contextPath }/template/stageFirst_submit", 
				    type:"POST",
				    data:$('#sceneFirstFormId').serialize(),
				    success: function(data){
				   	 	window.parent.postMessage(JSON.stringify('A'),'*');
				     },
				        error:function(data){
				 }}); 
				
			}
	}, false ); 
	
	
})
	
// 场景概述 表单校验
var FirstValidate = function(){
	var formData = $('#sceneFirstFormId').serializeArray();
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