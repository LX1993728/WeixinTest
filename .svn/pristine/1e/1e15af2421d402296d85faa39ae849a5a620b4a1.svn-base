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
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/task/css/css_reset.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/task/css/scene.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath }/task/css/leftnav.css" />
</head>
<body>
    <div class="indexLogo">
			<div class="indexLogo-content">
				<div class="indexLogo-img">
					<img src="${pageContext.request.contextPath }/task/img/logo.png" />
				</div>
				<div class="sceneText">
					<p class="sceneFirst">${sessionScope.task.name }</p>
					<p class="sceneSecond">${sessionScope.task.location }</p>
				</div>
				<div class="sceneRight">
					<jsp:useBean id="dateValue" class="java.util.Date"/>
					<jsp:setProperty name="dateValue" property="time" value="${task.time}"/>
					<span class="sceneSecondText"></span>
					<span class="sceneSecondNext"><img src="${pageContext.request.contextPath }/task/img/下一步.png" id="nextBtn" class="sceneSecondNext-btn"></span>
					<span class="sceneSecondBnt"><a href="${pageContext.request.contextPath }/scene/endScene"><img src="${pageContext.request.contextPath }/task/img/结束(1).png"></a></span>
				</div>
			</div>
	</div>
	<div class="navBox">
		<ul class="" id="navBox-menu">
				<c:forEach items="${sessionScope.stages}" var="stage">
					<c:if test="${stage.stageScene.name eq '场景概述' }">
						<li>
							<a class="menu-one active" href="${pageContext.request.contextPath }/scene/toScene?index=${stage.stageScene.index}" target="content">
								 <div class="menu-gbimg"></div>
								 <div>情景概述</div>
							</a>
						</li>
					</c:if>
					<c:if test="${stage.stageScene.name eq '总结评估' }">
						<li>
						    <a class="menu-one lastChild-active" href="${pageContext.request.contextPath }/scene/toScene?index=${stage.stageScene.index}" target="content">
								 <div class="menu-gbimg"></div>
								 <div>总结评估</div>
							</a>
						</li>
					</c:if>
					<c:if test="${(stage.stageScene.name ne '场景概述') and (stage.stageScene.name ne '总结评估') }">
						<li>
						    <a class="menu-one" href="${pageContext.request.contextPath }/scene/toScene?index=${stage.stageScene.index}" target="content">
							 	 <div class="menu-gbimg"></div>
								 <div>${stage.stageScene.name }</div>
							</a>
							<c:forEach items="${stage.childs }" var="child">
								<c:if test="${child.level eq 2}">
									<a class="menu-two" href="${pageContext.request.contextPath }/scene/toScene?index=${child.index}" target="content"><span></span></a>
								</c:if>
								<c:if test="${child.level eq 3}">
									<a class="menu-three" href="${pageContext.request.contextPath }/scene/toScene?index=${child.index}" target="content"><span></span></a>
								</c:if>
							</c:forEach>
						</li> 
					</c:if>
				</c:forEach>
			</ul>
	</div>
	<div class="secneContent">
		<div class="secneContentBox">
		    <iframe src="${pageContext.request.contextPath }/scene/toScene" id="sceneContent" class="content" name="content" height="100%" frameborder="0" scrolling="no" width="100%"></iframe>
	   </div>
	</div>
	
    <div class="smartPlan page clearfix">
	<!-- 参与成员 -->
            <div class="member clearfix">
                <!-- 解决滑出抖动bug -->
                <div class="member-bug fl"></div>
                <div class="member-show fl">
                    <div class="member-flag">
                        <div class="member-title">
                        参与成员
                        </div>
                        <div class="member-nav">
                            <ul class="member-nav-Box">
                                
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="member-hidden fl">
                    <i class="rightArrow"></i>
                </div>
            </div>
        </div>
	<script type="text/javascript" src="${pageContext.request.contextPath }/task/js/jquery.min.js" ></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/task/js/nav-index.js" ></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/task/js/index.js" ></script>
	<script type="text/javascript">
		$(function(){
            // 当前位置的菜单之间相互切换
            $(".navTitle").click(function(){
                // 切换子菜单的显示隐藏
                $(this).next().toggle("slow");
                // 切换箭头图标
                $(this).children('i').toggle();
            })
		    // 参与成员的显示隐藏
            $(".member").hover(function() {
                $(".member").stop(true,false).animate({left: "16px"},500,function(){
                    $('.curPlan').css('visibility','hidden');
                });
                $(".member-hidden").stop(true,false).hide(600);
                //$('.curPlan').animate({opacity: "0"},1000);
            }, function() {
                $(".member").stop(true,false).animate({left: "-460px"},500);
                $('.curPlan').css({visibility:'visible',opacity: "1"});
                $(".member-hidden").stop(true,false).show(600);
            });
            
			if(${sessionScope.isHistory}){ // 如果是历史信息，则只获取一次
				getUserAndGroups();
			}else{ // 如果正在推演 则定时刷新
			//	getUserAndGroups();
				setInterval(getUserAndGroups,5000);
			}
		});
		
		// 刷新页面数据
		function setDataToGroupsAndUsers(groups){
			$(".member-nav-Box").empty();
			str ="";
			for(i=0; i< groups.length;i++){
				var group = groups[i];
				var users = group.users;
				str+="<li class='nav'>";
				str+="<div class='navTitle clearfix'>"+
                                        "<span>"+group.orgName+"</span>"+
                                        "<i class='pulldown' style='display:none'></i>"+
                                        "<i class='pullright'></i>"+
                                    "</div>";
				str+="<div class='subnav' style='display:none'>"+
                                        "<ul>";
				for(j=0;j<users.length;j++){
					str+="<li>"+users[j].name+"</li>";
				}
				str+="</ul>"; 
				str+="</div></li>"; 
			}
			$(".member-nav-Box").append(str);
			$(".navTitle").click(function(){
                // 切换子菜单的显示隐藏
                $(this).next().toggle("slow");
                // 切换箭头图标
                $(this).children('i').toggle();
            })
		};
		// 获取组织单位以及 成员信息
		function getUserAndGroups(){
			$.ajax({
			   	  url: "${pageContext.request.contextPath}/hand/org_users?time=${sessionScope.task.time}",
		          type : "GET",
		          success: function(data) { 
		        	 	 setDataToGroupsAndUsers(data);		        	  
			     }
			});
		};
		
	</script>
</body>
</html>