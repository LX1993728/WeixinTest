<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
<style>
*{ padding:0; margin:0; list-style:none;}
/************************样式区。原本都打算写到JS里面的。不过这玩意改的比较多。新手改CSS没啥问题我就写在这了*****************************************/
/*  修改输出屏大小  */
.banner{/*  修改输出屏大小  */  overflow: hidden; position: relative; margin-left: auto; margin-right: auto; }
.banner .img{width: 99999px; position:absolute; left:0px; top:0;}
.banner .img li{ float:left;}
/*/ 修改图片大小 /*/
/**/
/*/ 小圆圈 /*/
#ban1 .banner{width:960px;height:539px;margin:auto; }
#ban1 .banner .img img{width:960px;height:539px;}
.banner .num{ position:absolute; width:100%; bottom:10px; left:0; text-align:center; font-size:0px;}
.banner .num li{ width:10px;height:10px; background:#888; border-radius:50%; display:inline-block; margin:0 3px; cursor:pointer;}
.banner .num li.on{ background:#F60;}
/*/ 按钮 /*/
.banner .btn{ width:30px; height:50px; background:rgba(0,0,0,0.5); position:absolute; top:50%; margin-top:-25px; cursor:pointer; text-align:center; line-height:50px; color:#fff; font-size:40px; font-family:"宋体";}
.banner .btn_l{ left:0;}
.banner .btn_r{ right:0;}
.banner_lop{
	display: inline-block;
	width:890px;
    height:76px;
    padding:12px 35px 12px 35px;
	position: absolute;
	z-index: 100;
	bottom:0;
	font-size: 24px;
	color:#fff;
	background-color: rgba(0, 0, 0, 0.41);
}


</style>
	</head>
	<body>
		<script src="${pageContext.request.contextPath }/task/js/jquery.min.js"></script>
		<script src="${pageContext.request.contextPath }/task/slideshow/js/gdlb.js"></script>
<div id="ban1">
<div class="banner">
		<c:if test="${imgts ne null }">
		<ul class="img">
			<c:forEach items="${imgts }" var="imgt">
				<li><a href="#"><img src="${pageContext.request.contextPath }/imgs/${imgt.url}"></a>
	            <span class='banner_lop'>${imgt.desc}</span>
				</li>
			</c:forEach>
	    </ul>
		</c:if>
    
  <!--   <ul class="num">    	
    </ul> -->
    
    <div class="btn btn_l">&lt;</div>
    <div class="btn btn_r">&gt;</div>

</div>

</div>



</body>
</html>
