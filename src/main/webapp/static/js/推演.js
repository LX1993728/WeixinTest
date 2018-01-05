
//底部移入效果

//var flag = false;
$(".baseOption>ul>li").mouseover(function() {
	$(this).find('ul').show();
});
$(".baseOption>ul>li").mouseout(function() {
	$(this).find('ul').hide();
});

//右边搜索筛选范围
$("#choose_l").click(function(){
	$(".choose_l_spread").show()
})

$(".choose_l_spread>div").click(function(){
	$("#choose_l").text($(this).text());
	$(".choose_l_spread").hide()
})