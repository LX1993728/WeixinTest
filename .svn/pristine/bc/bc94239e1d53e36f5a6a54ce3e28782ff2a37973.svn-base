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
	<link rel="stylesheet" href="${pageContext.request.contextPath }/task/css/sceneContent.css" />
	<script type="text/javascript" src="${pageContext.request.contextPath }/task/js/jquery.min.js" ></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/task/js/sceneContent.js" ></script>
</head>
<body>
	<div class="s-box">
		<div class="s-boxLeft">
			<div class="s-boxLeftTitle">
				<div class="tab">
					<a href="javascript:;" class="on">演练场景</a>
					<a href="javascript:;">场景说明</a>
				</div>
				<div class="content">
					<ul class="contentBox">
						<li class="on">
						<p>
							${scene.desc }
						</p>
						</li>
						<li>
							<div class="s-tabInfo">
								<div class="s-slideShow">
									<iframe src="${pageContext.request.contextPath }/scene/toImgts?index=${scene.index}" class="content" name="content" height="539px" frameborder="0" scrolling="no" width="100%"></iframe>
								</div>
								<div class="s-slideShowTell">
									${scene.explain }
								</div>
							</div>
						</li>
					</ul>
				</div>
			</div>
		</div>
	    <div class="s-boxRight">
	    	<div class="s-boxTop">
	    	 	<div class="s-boxTopTitle" >演练目标</div>
	    	 	<div class="s-sboxTop">
	    	 	<c:forEach items="${scene.targets }" var="target" varStatus="status">
		    	 	<div class="s-boxRight1">
		    	 		<span class="s-boxRightnum">${status.index + 1 }</span>
		    	 		<div class="s-boxRighttext">
						${target }
		    	 		</div>
		    	 	</div>
	    	 	</c:forEach>
	    	 </div>
	        <div class="s-boxRightBottom">
	        	<div class="s-boxTopTitle">演练原则</div>
	        	<div class="s-boxRightBotCon">
				${scene.rule }
	        	</div>
	        </div>
	    </div>
	</div>
</body>
</html>