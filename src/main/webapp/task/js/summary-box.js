
$(function(){
	// 一级菜单显示隐藏切换
	$("#sunBotNav-menu .sunBotNav-menuList1").click(function(e){
		$(this).siblings('.sunBotNav-menuList2').toggle("slow");
		$(this).parent().siblings().find('.sunBotNav-menuList2').hide("slow");
		e.stopPropagation();
	});

	// 二级菜单显示隐藏切换
	var $sunBotNav_lis = $("#sunBotNav-menu .sunBotNav-menuList2 .sunBotNav-menuList2-nav");
	$sunBotNav_lis.click(function(e){
		$(this).siblings('.sunBotNav-menuList3').toggle();
		$(this).parent("li").siblings('li').children('.sunBotNav-menuList3').hide();
		e.stopPropagation();
	})
	

	//给三级菜单绑定点击事件，点击时显示对应文档信息和评分
	$(".sunBotNav-menuList3 ul li").click(function(){
		//隐藏掉其他不对应文档和评分
		var text = $(this).text().toString();
		$.each(summaryData,function(i,v){
			$.each(v.second,function(i,value){
				$.each(value.three,function(i,obj){
					if(obj.name == text){
						$("#delContent").children().remove()
						var contentList = obj.content;
						$("#delContent").append(contentList)

						$("#delData ul").children().remove()
						var DataList = obj.InfoData;
						$("#delData ul").append(DataList)
					}
				
			    })

			})
		})
       
	});
	
})