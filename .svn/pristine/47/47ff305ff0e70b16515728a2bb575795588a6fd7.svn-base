$(function(){
	//删除添加项
	$(".indexDelete").click(function(){
        $(this).parents("li.indexDemoItem").remove();
	})
	//删除表格内容
	$(".buttonDelete").click(function(){
		$(this).parents("tr.indexExercise-tr").remove();
	})
	//隔行变色
	$(".indexExercise .indexExercise-tr:nth-child(even)").addClass("indexExercise-odd");
	//点击ul>li>a
	$(".sceneNavItem>a.sceneNavtext").click(function(){
		$(this).addClass("sceneSeleted").parent().siblings().children("a.sceneNavtext").removeClass("sceneSeleted");
	    $(this).parent().siblings().find(".secneChilds").removeClass("secneChildSelected");
	    $(this).siblings(".secneChild").children(".secneChilds").removeClass("secneChildSelected");
	})
	$(".secneChildOne").click(function(){
		$(this).addClass("secneChildSelected");
		$(this).next(".secneChildTwo").removeClass("secneChildSelected");
        $(this).parents(".sceneNavItem").siblings().find("a.secneChilds").removeClass("secneChildSelected");
	    $(this).parent().siblings(".sceneNavtext").addClass("sceneSeleted").parent().siblings().children(".sceneNavtext").removeClass("sceneSeleted");
	})
	$(".secneChildTwo").click(function(){
		$(this).addClass("secneChildSelected");
		$(this).prev(".secneChildOne").addClass("secneChildSelected");
        $(this).parents(".sceneNavItem").siblings().find("a.secneChilds").removeClass("secneChildSelected");
		$(this).parent().siblings(".sceneNavtext").addClass("sceneSeleted").parent().siblings().children(".sceneNavtext").removeClass("sceneSeleted");
	})
//点击图片时让对应的文本变色，其余兄弟去掉颜色
    $(".sceneNavbtn>img").click(function(){
    	$(this).parents(".sencefirsta").next(".sceneNavtext").addClass('sceneSeleted');
    	$(this).parents(".sceneNavItem").siblings().children('.sceneNavtext').removeClass('sceneSeleted');
        $(this).parents(".sencefirsta")
        	   .siblings('.secneChild')
               .children('.secneChilds')
               .removeClass('secneChildSelected');
        $(this).parents(".sceneNavItem")
               .siblings()
               .find(".secneChilds")
               .removeClass('secneChildSelected');
    })
    //点击下一步实现页面刷新
    
   console.log(123)
    //计时器
    var miao = 0;
    function timeDate(){
    	miao++;
    	var s = parseInt(miao%60);
    	var m = parseInt(miao/60);
    	var h = parseInt(miao/3600)
    	if(s >= 60){
    		s = 0;
    		m++
    	}
    	if(m >= 60){
    		m = 0;
    		h++;
    	}
    	if(s < 10){
    		s = '0' + s ;
    	}
    	if(m < 10){
    		m = "0" + m;
    	}
    	if(h < 10){
    		h = "0" + h;
    	}
    	
    	var record = '演练计时 : ' + h + '小时' + m + '分' + s + '秒 ';
    	$(".sceneSecondText").html(record);
    }
    var timer = window.setInterval(timeDate, 1000);




})
