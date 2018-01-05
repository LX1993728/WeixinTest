<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
	<meta charset="UTF-8" />
	<title>Document</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/task/css/reset.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath }/task/css/dispose.css" />
</head>
<body>
	<div class="s-box">
		<div class="s-boxLeft">
			<div class="s-boxLeftTitle">
				<div class="tab">
					<a href="javascript:;" class="on">场景说明</a>
					<a href="javascript:;">任务动态</a>
				</div>
				<div class="content">
					<ul class="contentBox d-contentBox">
						<li class="on">
							<div class="s-tabInfo">
								<div class="s-slideShow">
									<iframe src="${pageContext.request.contextPath }/scene/toImgts?index=${scene.index}" class="content" name="content" height="539px" frameborder="0" scrolling="no" width="100%"></iframe>
								</div>
								<div class="s-slideShowTell">
									${scene.explain }
								</div>
							</div>
						</li>
						<li>
						    <div class="d-content" id="message">
							
						    </div>
						</li>
					</ul>
				</div>
			</div>
		</div>
		<div class="d-boxRight">
			<div class="s-boxTopTitle">任务看板</div>
			<div class="s-sboxLine">
			<div class="s-boxLine">
				<span class="s-Linetitle">任务数</span>   
				<span class="s-LineNum">
					<span class="s-index">0</span>/
					<span class="s-length">${fn:length(scene.tasks) }</span>
				</span>
				<div class="s-progress">
					<span class="ss-progressbar"></span>
					<span class="ss-schedule"></span>
					<span class="s-progressNum">0%</span>
				</div>
			</div>
			<c:forEach items="${scene.tasks }" var="task" varStatus="status">
				<div class="s-boxLine sbox">
					<span class="s-Linetitle1">任务${ status.index+1}:</span> 
					<span class="s-LineImg"></span>
					<div class="s-LineText">${task.name }</div>
				    <p class="s-LineTextBto">${task.groups }</p>
				</div>
			
			</c:forEach>
		</div>
	</div>
    <script type="text/javascript" src="${pageContext.request.contextPath }/task/js/jquery.min.js" ></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/task/js/sceneContent.js" ></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/task/js/util.js" ></script>
	<script type="text/javascript">
		$(function(){
			if(${sessionScope.isHistory}){ // 如果是历史信息，则只获取一次
				getMessages();
			}else{ // 如果正在推演 则定时刷新
				setInterval(getMessages,1000);
			}
		});
		
		// 刷新页面数据
		function setMessagesTOELement(messages){
			$("#message").empty();
			str ="";
			for(i=0;i<messages.length;i++){
				var time =Format(new Date(messages[i].createTime),"yyyy-MM-dd HH:mm:ss");  
				str+="<div class='d-headImg'>";
				str+="<span class='d-headImgbox'><img src='${pageContext.request.contextPath }/task/img/部门.png'></span>";
				str+="</div>";
				str+="<div class='d-headText'>";
				str+="<div class='d-headTextInfo'>";
				str+="<p>";
				str+="<span class='d-name'>"+messages[i].user.name+"</span>";
				str+="<span class='d-position'>"+messages[i].user.orgName+"</span>";
				str+="<span class='d-time'>"+time+"</span>";
				str+="</p>";
				str+="<p class='d-headTextDetail'>";
				str+=messages[i].content;
				str+="</p>";
				str+="</div>";
				str+="</div>";
				str+="<div class='d-headWatch'>";
				str+="查看";
				str+="</div>";
			}
			$("#message").append(str);
		};
		// 获取组织单位以及 成员信息
		function getMessages(){
			$.ajax({
			   	  url: "${pageContext.request.contextPath}/hand/all_message?taskId=${sessionScope.task.time}&index=${scene.index}",
		          type : "GET",
		          success: function(data) { 
		        	  setMessagesTOELement(data);		        	  
			     }
			});
		};
		
	</script>
</body>
</html>