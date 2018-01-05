$(function(){
	$(".tab a").click(function(){
		$(this).addClass('on').siblings().removeClass('on');
		var index = $(this).index();
		$('.content li').hide();
		$('.content li:eq('+index+')').show();
	});
	$(".s-LineImg").click(function(){
		$(this).parent(".s-boxLine").addClass('checked');
		//获取当前选中的个数
        var checkedBox=$(".checked").length;
        $(".s-index").html(checkedBox);
        //显示当前进度百分比
        var schedule= checkedBox/boxLineNum;
        var scheduleaa=Math.floor(schedule* 100);
        $(".s-progressNum").html(scheduleaa+"%")
        //图片变化
        $(this).addClass("s-LineImg-success")
		var move=$(this).parent(".s-boxLine").remove();
		$(".s-sboxLine").append(move);
		//进度条长度改变
        var aa=380*schedule+"px";
        $(".ss-schedule").css("width",aa);
	})
	//获取的s-boxLine的长度
    var boxLineNum=$(".sbox").length;
    $(".s-length").html(boxLineNum);
})
	