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
	<link rel="stylesheet" href="${pageContext.request.contextPath }/task/css/summary.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath }/task/scroll/style.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath }/task/scroll/jquery.mCustomScrollbar.css" />
</head>
<body>
	<div class="summary">
	<div class='test'></div>
		<div class="summary-tab">
			<div class="tabbox">
	            <div class="tab">
    	            <a href="javascript:;" class="on">事件报告</a>
                    <a href="javascript:;">评估统计</a>
                </div>
                <div class="tabcontent">
    	            <ul>
        	            <li style="display: block;" class="tabcontent-first">
        	            	<div class="summary-report">
        	            		<div class="summary-list">
        	            			<a class="summary-listItem summary-img1" href="#top">原因清查</a>
        	            			<a class="summary-listItem summary-img2" href="#top">伤亡情况</a>
        	            			<a class="summary-listItem summary-img3" href="#center">应急响应</a>
        	            			<a class="summary-listItem summary-img4" href="#center">预警发布</a>
        	            			<a class="summary-listItem summary-img5" href="#bottom">舆情控制</a>
        	            		</div>
        	            		<div class="content">
        	            			<c:if test="${scene ne null }">
        	            				<c:forEach items="${scene.abilities }" var="ability" varStatus="status">
        	            				
        	            					<c:if test="${status.count % 2 != 0 }">
			        	            			<div class="summaryContent-left">
			        	            			    <!-- <div id="yinji"></div> -->
			        	            				<a class="summary-listItem summary-img1" href="javascript:;" name="top">${ability.name }</a>
			        	            			    <div class="summaryContent-img"><img src="${pageContext.request.contextPath }/imgs/${ability.url }"></div>
			        	            			    <p class="summaryContent-info">${ability.desc }</p>
			        	            			    <div class="summaryContent-detail">
			        	            			    	${ability.assess }
			        	            			    </div>
			        	            			</div>
        	            					</c:if>
        	            					<c:if test="${status.count % 2 == 0 }">
			        	            			<div class="summaryContent-left summaryContent-right">
			        	            				<a class="summary-listItem summary-img2" href="javascript:;" name="top">${ability.name }</a>
			        	            			    <div class="summaryContent-img"><img src="${pageContext.request.contextPath }/imgs/${ability.url }"></div>
			        	            			    <p class="summaryContent-info">${ability.desc }</p>
			        	            			    <div class="summaryContent-detail">
			        	            			    		 	${ability.assess }
			        	            			    </div>
			        	            			</div>
        	            					</c:if>
     	            				</c:forEach>
    	            			</c:if>
        	            		</div>
        	            	</div>
        	            </li>
                        <li class="tabcontent-second">
                        	  <div class="content">
                        	  	   <div class="sumContent">
                        	  	       <div class="sumContent-all">
                        	  	       	    <div class="sumContent-1">
                        	  	       	    	<div class="sumContent-2">
                        	  	       	    		<span class="sumContent-title">统计分析</span>
                        	  	       	    	<div class="content1List">
                                        			<span class="content1big allScore">0</span>
                                        			<span class="content1small">分</span>
                                        			<p class="content1all">总体得分</p>
                                        			<img src="${pageContext.request.contextPath }/task/img1/问好.png" class="imgquery">
                                        		</div>
                                        		<div class="content1List">
                                        			<span class="content1big allPersonnum">0</span>
                                        			<span class="content1small">人</span>
                                        			<p class="content1all">参演人员</p>
                                        		</div>
                                        		<div class="content1List">
                                        			<span class="content1big allDate">0</span>
                                        			<span class="content1small">时</span>
                                        			<span class="content1big allDateMin">0</span>
                                        			<span class="content1small">分</span>
                                        			<p class="content1all">演练用时</p>
                                        		</div>
                        	  	       	    	</div>
                        	  	       	        <div class="sumContent-3">
                        	  	       	        	<span class="sumContent-title sumContent-title1">能力分析</span>
                        	  	       	            <div class="sumContent-box">
                        	  	       	            	<span class="sunContent-tab">一级指标分析</span>
                        	  	       	                <div class="sumContent-chart" id="firstLevel">
                        	  	       	                </div>
                        	  	       	            </div>
                        	  	       	            <div class="sumContent-box sumContent-box1">
                        	  	       	            	<span class="sunContent-tab">二级指标分析</span>
                        	  	       	                <div class="sumContent-chart" id="secondLevel">
                        	  	       	                </div>
                        	  	       	            </div>
                        	  	       	        </div>
                        	  	       	    </div>
                        	  	            <div class="sumContent-4">
                        	  	            	<div class="content">
                        	  	            		<div class="sumContent-5">
                        	  	            			<span class="sumContent-title sumContent-title2">分项排名</span>
                        	  	            		    <span class="sumRank">三级指标排名</span>
                        	  	            		</div>
                        	  	            	</div>
                        	  	            </div>
                        	  	       </div>
                        	  	       <div class="sumContent-bottom">
                        	  	            <div class="sumBottom">
                        	  	            	<div class="sumBottom-1">
                        	  	            		<span class="sumBottom-title">评估详情</span>
                        	  	            	    <p class="sumBottom-title1">评估指标</p>
                        	  	            	</div>
                        	  	            	<div class="sumBottom-2">
                        	  	            		<p class="sumBottom-title1 sumBottom-title2">得分及占比</p>
                        	  	            	</div>
                        	  	            	 <div class="sumBottom-3">
                                                    <p class="sumBottom-title1 sumBottom-title2">评分及说明</p>
                                                </div>
                        	  	            </div>
                        	  	            <div class="sumBottom-nav">
                                                <iframe src="${pageContext.request.contextPath }/task/pager/summary-box.html" class="content" height="600px" frameborder="0" scrolling="no" width="100%"></iframe>                      
                        	  	            </div>
                        	  	       </div>
                        	  	   </div>
                        	  </div>
                        </li>
                    </ul>
                </div>
            </div>
		</div>
	</div>
	
    <script type="text/javascript" src="${pageContext.request.contextPath }/task/js/jquery.min.js" ></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/task/js/summary.js" ></script>
     <script type="text/javascript" src="${pageContext.request.contextPath }/task/js/echart/echarts.js" ></script>
	</script>
</body>
</html>