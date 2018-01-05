
//底部移入效果

//var flag = false;
$(".baseOption>ul>li").mouseover(function() {
	$(this).find('ul').show();
});
$(".baseOption>ul>li").mouseout(function() {
	$(this).find('ul').hide();
});
//搜索筛选范围
$("#choose_l").click(function(){
	$(".choose_l_spread").show();
	$(".choose_r").addClass("filtrate")
	
})
$(".choose").click(function(){
	$(".choose_l_spread").show();
	$(".choose_r").addClass("filtrate");
})
$(".choose_l_spread>div").click(function(){
	window.event? window.event.cancelBubble = true : e.stopPropagation();
	$("#choose_l").text($(this).text());
	$(".choose_l_spread").hide();
	$(".choose_r").removeClass("filtrate");
})

//右边展示区域 点击切换文字 和展示内容

$(".spread").click(function(){
	var spn = $(this).children('span');
	if($(spn).text() == "展开") {
		$(spn).text("收起");
		} else {
		$(spn).text("展开");
	};
	$(this).parent(".topic").siblings(".topic_bare").toggleClass("show");
	$(this).children('span').toggleClass("hue");
})