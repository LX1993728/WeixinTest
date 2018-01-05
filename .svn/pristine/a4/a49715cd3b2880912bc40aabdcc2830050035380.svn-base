$(function(){
	$(".tabbox .tab a").click(function(){
		$(this).addClass('on').siblings().removeClass('on');
		var index = $(this).index();		
		$('.tabbox .content li').hide();
		$('.tabbox .content li:eq('+index+')').show();
	});
	var div2=document.getElementById("div2");
        var div1=document.getElementById("div1");
        div1.onclick=function(){
          div1.className=(div1.className=="close1")?"open1":"close1";
          div2.className=(div2.className=="close2")?"open2":"close2";
          var flag = (div1.className=="open1")?true:false;
          $
			.ajax({
				url : "/hand/edit_check?check="+flag,
				type : "GET",
				success : function(checkMap) {
					var div1=document.getElementById("div1");
					var div2=document.getElementById("div2");
					div1.className=checkMap.check?'open1':'close1';
					div2.className=checkMap.check?'open2':'close2';
				}
			});
    }
})

        
    