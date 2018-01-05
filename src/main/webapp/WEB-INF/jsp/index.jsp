<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="utf-8">
		<title>CETC</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath }/task/css/reset.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath }/task/css/index.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath }/task/pager/pager.css" />
	</head>
	<body>
		<div class="indexLogo">
			<div class="indexLogo-content">
				<div class="indexLogo-img">
					<img src="${pageContext.request.contextPath }/task/img/logo.png" />
				</div>
				<div class="indexLogo-title">
					模拟演练与培训
				</div>
			</div>
		</div>
		<div class="indexCenter">
			<div class="indexCenter-content">
				<div class="indexDemo">
					<p class="indexDemo-title">演练模版</p>
					<div class="indexDemo-search">
						<i class="indexSearch"><img src="${pageContext.request.contextPath }/task/img/2.png"></i>
						<input type="text" placeholder="请输入演练名称" class="indexDemoInput"/><span class="indexDemobar">搜索</span>
					</div>
				</div>
				<div class="indexList">
					<ul class="indexListDemo">
						<c:forEach items="${templates }" var="template">
							<li class="indexDemoItem">
					    			<div class="indexDemoItem-detaile">
					    				${template.name }
					    				<p class="indexDemoItem-time"><fmt:formatDate value="${template.time}" type="both" /></p>
					    			</div>
					    			<div class="indexDemoItem-btn">
					    				<button class="button indexDelete">删除</button>
					    				<a class="button indexStart" href="${pageContext.request.contextPath }/scene/begin?id=${template.id }">开始</a>
					    			</div>
					    	</li>
						</c:forEach>
					</ul>
				</div>
				<div class="indexListAdd">
						<div class="indexListAddBox">
							<div class="indexDemoItem-img">
					    		<span class="indexDemoAdd"><img src="${pageContext.request.contextPath }/task/img/1.png" /></span>
					    	</div>
					    <div class="indexDemoItem-btn">
					    	<button class="addButton"><a href="${pageContext.request.contextPath }/template/toCreate">添加</a></button>
					    </div>
					</div>
				</div>
			</div>
		</div>
	    <div class="indexHistory">
	    	<div class="indexHistoryContent">
	    		<div calss="indexDemo">
					<p class="indexDemo-title">演练历史</p>
					<div class="indexDemo-search">
						<i class="indexSearch"><img src="${pageContext.request.contextPath }/task/img/2.png"></i>
						<input type="text" placeholder="请输入演练名称" class="indexDemoInput"/><span class="indexDemobar">搜索</span>
					</div>
				</div>
				<table class="indexExercise">
					<tr class="indexExercise-tr">
						<td class="indexExercise-td1">演练名称</td>
						<td>地点</td>
						<td>演练时间</td>
						<td>操作</td>
					</tr>
					<c:forEach items="${tasks }" var="task">
						<tr class="indexExercise-tr">
							<td class="indexExercise-td2">${task.name }</td>
							<td>${task.location }</td>
							<jsp:useBean id="dateValue" class="java.util.Date"/>
							<jsp:setProperty name="dateValue" property="time" value="${task.time}"/>
							<td><fmt:formatDate value="${dateValue}" pattern="yyyy-MM-dd hh:mm:ss" /> </td>
							<td><a class="buttonFind buttonDo" href="${pageContext.request.contextPath }/scene/query?time=${task.time }">查看</a><button class="buttonDo buttonDelete">删除</button></td>
						</tr>
					</c:forEach>
				</table>
				<!-- <div class="indexPager">
	                <ul class="pagination" id="page1">
                    </ul>
	                <div class="pageJump">
		                <span>跳转到</span>
		                <input type="text"/>
		                <span>页</span>
		                <button type="button" class="button">确定</button>
	                </div>
	            </div> -->
	    	</div>
	    </div>


		<script type="text/javascript" src="${pageContext.request.contextPath }/task/js/jquery.min.js" ></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/task/js/index.js" ></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/task/pager/pager.js" ></script>
	    <script>
	    	Page({
			num:6,					//页码数
			startnum:3,				//指定页码
			elem:$('#page1'),		//指定的元素
			callback:function(n){	//回调函数
				console.log(n);
			}
		});
	    </script>
	</body>
</html>