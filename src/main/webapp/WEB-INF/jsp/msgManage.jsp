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
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/task/css/infomessage.css" />
</head>
<body>
	<div class="indexLogo">
		<div class="indexLogo-content">
			<div class="indexLogo-img">
				<img src="${pageContext.request.contextPath }/task/img/logo.png" />
			</div>
			<div class="sceneText">
				<p class="sceneFirst">模拟演练与培训</p>
				<p class="sceneSecond">消息管理</p>
			</div>
			<div class="add-rightBtn">
				<a href="${pageContext.request.contextPath }/task/index.html"><img
					src="${pageContext.request.contextPath }/task/img/保存.png">保存修改</a>
			</div>
		</div>
	</div>
	<div class="add-center">
		<div class="addContentTab">
			<div class="add-tabcon1">
				<div class="add-leftTitle">粤港澳大湾区药品安全突发事件应急演练/消息管理</div>
				<div class="add-leftInfo">
					<span class="add-peoplenum">已上墙人数：<span class="add-num" id="userNum">1</span></span>
					<span class="add-peoplenum">已上墙消息：<span class="add-num" id="msgNum">1</span></span> 
					<span class="add-peoplenum">人工审核</span>
					<div id="div1" class="open1">
                          <div id="div2" class="open2"></div>
                    </div>
				</div>
				<div class="Addtab curPlan">
					<div class="tabbox">
						<div class="tab">
							<a href="javascript:;" class="on">待审核消息</a> <a
								href="javascript:;">待发送消息</a> <a href="javascript:;">已上墙消息</a>
						</div>
						<div class="content">
							<ul>
								<li class="addContent" style="display: block;">
									<div class="programme">
										<div>请求时间</div>
										<div>部门姓名</div>
										<div>消息内容</div>
										<div>操作管理</div>
									</div>
									<div class="formularfeld" id="unCheckMsgs">
									</div>
								</li>
								
								<li class="addContent" id="">
									<div class="programme">
										<div>请求时间</div>
										<div>部门姓名</div>
										<div>消息内容</div>
										<div>操作管理</div>
									</div>
									<div class="formularfeld">
										<div>
											<div>2017/09/23 12:32</div>
											<div>事件调查组-李XX</div>
											<div>调查事件调查事件调查事件调查事件调查事件</div>
											<div class="operatingButton">
												<div>编辑</div>
												<div>上墙</div>
												<div>删除</div>
											</div>
										</div>

										<div>
											<div>2017/09/23 12:32</div>
											<div>事件调查组-李XX</div>
											<div>调查事件调查事件调查事件调查事件调查事件</div>
											<div class="operatingButton">
												<div>编辑</div>
												<div>上墙</div>
												<div>删除</div>
											</div>
										</div>
										<div>
											<div>2017/09/23 12:32</div>
											<div>事件调查组-李XX</div>
											<div>调查事件调查事件调查事件调查事件调查事件</div>
											<div class="operatingButton">
												<div>编辑</div>
												<div>上墙</div>
												<div>删除</div>
											</div>
										</div>
										<div>
											<div>2017/09/23 12:32</div>
											<div>事件调查组-李XX</div>
											<div>调查事件调查事件调查事件调查事件调查事件</div>
											<div class="operatingButton">
												<div>编辑</div>
												<div>上墙</div>
												<div>删除</div>
											</div>
										</div>
										<div>
											<div>2017/09/23 12:32</div>
											<div>事件调查组-李XX</div>
											<div>调查事件调查事件调查事件调查事件调查事件</div>
											<div class="operatingButton">
												<div>编辑</div>
												<div>上墙</div>
												<div>删除</div>
											</div>
										</div>
										<div>
											<div>2017/09/23 12:32</div>
											<div>事件调查组-李XX</div>
											<div>调查事件调查事件调查事件调查事件调查事件</div>
											<div class="operatingButton">
												<div>编辑</div>
												<div>上墙</div>
												<div>删除</div>
											</div>
										</div>

										<div>
											<div>2017/09/23 12:32</div>
											<div>事件调查组-李XX</div>
											<div>调查事件调查事件调查事件调查事件调查事件</div>
											<div class="operatingButton">
												<div>编辑</div>
												<div>上墙</div>
												<div>删除</div>
											</div>
										</div>
										<div>
											<div>2017/09/23 12:32</div>
											<div>事件调查组-李XX</div>
											<div>调查事件调查事件调查事件调查事件调查事件</div>
											<div class="operatingButton">
												<div>编辑</div>
												<div>上墙</div>
												<div>删除</div>
											</div>
										</div>
										<div>
											<div>2017/09/23 12:32</div>
											<div>事件调查组-李XX</div>
											<div>调查事件调查事件调查事件调查事件调查事件</div>
											<div class="operatingButton">
												<div>编辑</div>
												<div>上墙</div>
												<div>删除</div>
											</div>
										</div>
										<div>
											<div>2017/09/23 12:32</div>
											<div>事件调查组-李XX</div>
											<div>调查事件调查事件调查事件调查事件调查事件</div>
											<div class="operatingButton">
												<div>编辑</div>
												<div>上墙</div>
												<div>删除</div>
											</div>
										</div>
										<div>
											<div>2017/09/23 12:32</div>
											<div>事件调查组-李XX</div>
											<div>调查事件调查事件调查事件调查事件调查事件</div>
											<div class="operatingButton">
												<div>编辑</div>
												<div>上墙</div>
												<div>删除</div>
											</div>
										</div>
										<div>
											<div>2017/09/23 12:32</div>
											<div>事件调查组-李XX</div>
											<div>调查事件调查事件调查事件调查事件调查事件</div>
											<div class="operatingButton">
												<div>编辑</div>
												<div>上墙</div>
												<div>删除</div>
											</div>
										</div>

										<div>
											<div>2017/09/23 12:32</div>
											<div>事件调查组-李XX</div>
											<div>调查事件调查事件调查事件调查事件调查事件</div>
											<div class="operatingButton">
												<div>编辑</div>
												<div>上墙</div>
												<div>删除</div>
											</div>
										</div>
										<div>
											<div>2017/09/23 12:32</div>
											<div>事件调查组-李XX</div>
											<div>调查事件调查事件调查事件调查事件调查事件</div>
											<div class="operatingButton">
												<div>编辑</div>
												<div>上墙</div>
												<div>删除</div>
											</div>
										</div>
										<div>
											<div>2017/09/23 12:32</div>
											<div>事件调查组-李XX</div>
											<div>调查事件调查事件调查事件调查事件调查事件</div>
											<div class="operatingButton">
												<div>编辑</div>
												<div>上墙</div>
												<div>删除</div>
											</div>
										</div>
									</div>

								</li>
								<li class="addContent">
									<div class="programme">
										<div>请求时间</div>
										<div>部门姓名</div>
										<div>消息内容</div>
										<div>操作管理</div>
									</div>
									<div class="formularfeld" id="checkedMsgs">
									</div>

								</li>
							</ul>
						</div>
					</div>
				</div>
			</div>
			<div class="top-addRight">
				<div class="top-addRightTitle">屏幕实时消息</div>
				<%-- <div class="top-addRightSet">
					<a href="javascript:;"><i><img
							src="${pageContext.request.contextPath }/task/img/下.png"></i>下墙</a>
					<a href="javascript:;"><i><img
							src="${pageContext.request.contextPath }/task/img/下.png"></i>复制</a>
				</div> --%>
				<div class="top-addRightList curPlan" >
					<p class="top-addTime">12:23</p>
	        	    		<div class="top-addListbox" id="rightCheckedMsg">
	        	    		
	        	    			<p class="top-addList">事件调查组-李xx</p>
	        	    			<div class="top-addListsend"><p class="topChecked">由市燃气事故应急指挥部负责启动lll级应急响应</p>
	        	    			</div>
	        	    			
	        	    		</div>
					
				</div>
			</div>
			<div class="bto-addRight">
				<p>
					<label class="bto-line">组别及姓名</label><input type="text" name="label"
						class="bto-linefirst">
				</p>
				<p>
					<label class="bto-line">推送内容</label><textarea class="bto-linesecond" name="content"></textarea>
				</p>
				<%-- <img src="${pageContext.request.contextPath }/task/img/图片.png"
					class="bto-sendImg"> --%>
				<div class="bto-button" onclick="sendMsg()">发送上墙</div>
			</div>

		</div>
	</div>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/task/js/jquery.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/task/js/add.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/task/js/util.js"></script>
	<script type="text/javascript">
		$(function() {
			  setInterval(getAllDataForPage,1000);
			  // getAllDataForPage();
		});

		function getAllDataForPage() {
			// 自动审核的状态并进行赋值
			$
			.ajax({
				url : "${pageContext.request.contextPath}/hand/get_check",
				type : "GET",
				success : function(checkMap) {
					var div1=document.getElementById("div1");
					var div2=document.getElementById("div2");
					div1.className=checkMap.check?'open1':'close1';
					div2.className=checkMap.check?'open2':'close2';
				}
			});
			
			// 获取已上墙人数以及已上墙消息数
			$
			.ajax({
				url : "${pageContext.request.contextPath}/hand/num?taskId=${taskId}",
				type : "GET",
				success : function(data) {
					$("#userNum").html(data.userNum);
					$("#msgNum").html(data.msgNum);
				}
			});

			// 获取当前演练待审核的消息
			$
			.ajax({
				url : "${pageContext.request.contextPath}/hand/message?taskId=${taskId}&status=0",
				type : "GET",
				success : function(data) {
					setDataForMassage('unCheckMsgs', data);
				}
			});

			// 获取当前演练已上墙的消息
			$
			.ajax({
				url : "${pageContext.request.contextPath}/hand/message?taskId=${taskId}&status=1",
				type : "GET",
				success : function(data) {
					setDataForMassage('checkedMsgs', data);
					setDataForRight('rightCheckedMsg', data);
				}
			});
		};
		// 为指定的元素设置 数据
		function setDataForMassage(eleId, data) {
			$("#" + eleId).empty();
			str = "";
			for (i = 0; i < data.length; i++) {
				str+="<div>";
				str+="<div>"+ Format(new Date(data[i].createTime),'yyyy-MM-dd HH:mm:ss') + "</div>";
				str+="<div>"+data[i].user.orgName+ "—" + data[i].user.name+"</div>";
				str+="<div>"+data[i].content+"</div>";
				str+="<div class='operatingButton'>";
				if(data[i].status == 0){
					var obj = {};
					obj.id = data[i].id;
					obj.status = 1;
					str+="<div><a href='javascript:void(0);'  onClick='resolveMsg(this)' data="+JSON.stringify(obj)+" class='on-wall'>上墙</a></div>";
				}
				if(data[i].status == 1){
					var obj = {};
					obj.id = data[i].id;
					obj.status = 0;
					str+="<div><a href='javascript:void(0);'  onClick='resolveMsg(this)' data="+JSON.stringify(obj)+" class='on-wall'>下墙</a></div>";
				}
				var obj2 = {};
				obj2.id = data[i].id;
				str+="<div><a href='javascript:void(0);'  onClick='delMsg(this)' data="+JSON.stringify(obj)+" class='on-wall'>删除</a></div>";
				str+="</div>";
				str+="</div>";
			}
			$("#" + eleId).append(str);
		}
		
		// 对右侧的上墙信息进行实时刷新
		function setDataForRight(eleId, data) {
			 $("#" + eleId).empty();
			str = "";
			for (i = 0; i < data.length; i++) {
				str+="<p class='top-addList'>"+data[i].user.orgName+ "—" + data[i].user.name+"</p>";
				str+="<div class='top-addListsend'>";
				str+="<p class='topChecked'>"+data[i].content+"</p>";
				str+="</div>";
				if(data[i].status == 1){
					var obj = {};
					obj.id = data[i].id;
					obj.status = 0;
					str+="<div class='operatingButton'>";
					str+="<div class='operatingButton-right'><a href='javascript:void(0);'  onClick='resolveMsg(this)' data="+JSON.stringify(obj)+" class='on-wall-right'>下墙</a></div>";
					str+="</div>";
				}
			}
			
			$("#" + eleId).append(str); 
		}
		
		// 对消息进行处理
		function resolveMsg(a){
			var data = JSON.parse($(a).attr("data"));
			$
			.ajax({
				url : "${pageContext.request.contextPath}/hand/edit_status?msgId="+data.id+"&status="+data.status,
				type : "GET",
				success : function(data) {
				}
			});
		};
		
		// 删除消息
		function delMsg(b){ 
			var data = JSON.parse($(b).attr("data"));
			$
			.ajax({
				url : "${pageContext.request.contextPath}/hand/delmessage?msgId="+data.id,
				type : "GET",
				success : function(data) {
				}
			});
		};
		
		// 发送消息
		function sendMsg(){
			var label = $("input[name='label']").val();
			var content = $("textarea[name='content']").val();
			$
			.ajax({
				url : "${pageContext.request.contextPath}/hand/send?label="+label+"&content="+content,
				type : "POST",
				success : function(data) {
					$("input[name='label']").val('');
					$("input[name='content']").val('');
				},
				error : function(data) { 
		            alert(data.message);
		        }  
			});
		}
	</script>
</body>
</html>