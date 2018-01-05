$(function(){
	/*var m2=0,m1=0;
	$('.one').each(function(i,val){
		if($(this).prev().hasClass('one')){//前面没有子流程
			m2++;
		}else if($(this).prev().hasClass('three')){
		}else if($(this).prev().hasClass('menu-two') && $(this).prev(".two").prev().hasClass('two')){
		}else if($(this).prev().hasClass('two') && $(this).prev(".two").prev().hasClass('three')){
			m1++;
		}else if($(this).prev().hasClass('two') && $(this).prev(".two").prev().hasClass('one')){
			m1++;
		}
	})
	setMargin ();
	$(window).resize(function(event) {
		setMargin ();
		setMarginMean();
	});
	
	function setMargin (){
		$('.one').each(function(i,val){
			if(setMarginMean()>=100){
				if($(this).prev().hasClass('one')){//前面没有子流程
					$(this).css("marginLeft",setMarginMean()+100);
				}else if($(this).prev().hasClass('three')){
					$(this).css("marginLeft",setMarginMean())
				}else if($(this).prev().hasClass('two') && $(this).prev(".two").prev().hasClass('two')){
					$(this).css("marginLeft",setMarginMean())
				}else if($(this).prev().hasClass('two') && $(this).prev(".two").prev().hasClass('three')){
					$(this).css("marginLeft",setMarginMean());
				}else if($(this).prev().hasClass('two') && $(this).prev(".two").prev().hasClass('one')){
					$(this).css("marginLeft",setMarginMean());
				}
			}else{
				console.log('小于100了')
			}
			
		});
		setMarginMean();
	}
	function setMarginMean(){
			var oneLen = $('.one').length*$('.one').outerWidth();
			console.log(oneLen)
			var twoLen = $('.two').length*$('.two').outerWidth();
			var threeLen = $('.three').length*$('.three').outerWidth();
			console.log(m1 + '---------'+m2)
			var marginMean = (1920-oneLen-twoLen-threeLen-100*m2)/(m2+m1);
			console.log(marginMean)
			return marginMean
		}
	*/










	/*setMargin ()
	function setMargin (){
		$('.one').each(function(i,val){
			if(setMarginMean()>=100){
				if($(this).prev().length>0){
					$(this).css("marginLeft",setMarginMean());
				}
			}else{
				console.log('小于100了')
				$(this).css("marginLeft",100);
				$('ul').children('.one:first-child').css("marginLeft",0)
			}
			
		});
		setMarginMean();
	}
	function setMarginMean(){
			var oneLen = $('.one').length*$('.one').outerWidth();
			var twoLen = $('.two').length*$('.two').outerWidth();
			var threeLen = $('.three').length*$('.three').outerWidth();
			var marginMean = (1920-oneLen-twoLen-threeLen)/($('.one').length-1);
			return marginMean
	}
	if($(".one").length>=8){
		$(this).css("marginLeft",100);
		$('ul').children('.one:first-child').css("marginLeft",0)
		console.log('大于8个了')
	}*/
	//动态计算各流程宽度
	function setWidth (){
		var liWidth = 1812/($("#navBox-menu>li").length-1);
		$('#navBox-menu>li').each(function(i,val){
			$(this).css('width',liWidth);
			$('#navBox-menu>li:last-child').css('width',100);
			var liChildOne = $(this).children('a.menu-one');
			var liChildsTwo = $(this).children('a.menu-two');
			var liChildsThree = $(this).children('a.menu-three');
			if($(this).outerWidth()<=200){
				$(this).css('width',200);
				$('#navBox-menu>li:last-child').css('width',100);
				// $(this).children('a').css('marginLeft',0);
			}else if($(this).outerWidth()<=$(this).children('.menu-two').length*50+$(this).children('.menu-three').length*50+100){
				$(this).css('width',$(this).children('a.menu-two').length*50+$(this).children('a.menu-three').length*50+100)
			}else{
				var liChildsMargin = (liWidth - liChildOne.length*100-liChildsTwo.length*50-liChildsThree.length*50)/liChildOne.length
				// console.log(liChildLs.outerWidth())
				// liChildLs.css('marginLeft',10);
			}
		})
		var ulWidth = 0;
		$('#navBox-menu>li').each(function(i,v){
			ulWidth += $(this).outerWidth();
		})
		if(ulWidth>=1814){
			$('#navBox-menu').css('width',ulWidth+2)
		}
	}
	//动态追加后台流程相关数据到页面
	function setDataList(data){
		var strOne = '';
		$.each(data,function(i, v) {
			// console.log(v.childs)
			if(v.stageScene.name=="场景概述" || v.stageScene.name=="总结评估"){
				// console.log('错了')
			}else{
				var strTwo ='';
				var strThree ='';
				$.each(v.childs,function(i, child) {
					// console.log(child)
					if(child.level==2){
						strTwo +=   '<a href="javascript:;" class="menu-two" index="'+child.index+'">'+
										'<span></span>'+
									'</a>'
					}
					if(child.level==3){
						strThree +=   '<a href="javascript:;" class="menu-three" index="'+child.index+'">'+
										'<span></span>'+
									'</a>'
					}
					
				});
				strOne += '<li>'+
								'<a href="javascript:;" class="menu-one">'+
									'<div class="menu-gbimg"></div>'+
									'<div>'+v.stageScene.name+'</div>'+
								'</a>'+strTwo+strThree+
							'</li>'
			}

		});
		return strOne;
	}
	// $("#navBox-menuOne").after(setDataList(data_data))
	setWidth ();
	$(window).resize(function(event) {
		setWidth ();
	});

	//下一步按钮点击事件
	$("#nextBtn").click(function(){
            var $this=$('#navBox-menu>li a.active:last');
            if($this.hasClass('lastChild-active')){
	           	console.log('到最后一个了')
	        	return false;
        }
	            nextPro($this);
				moveleft($this);

        //获取当前选中a的页面链接
        var linkTo=$('#navBox-menu>li a.active:last').attr("href");
        //console.log("href",linkTo);
        $("#sceneContent").attr('src', linkTo);
           
            
	})
	//流程active选中状态判断
	function nextPro($this){
		$('#navBox-menu>li a').removeClass('active');
		if($this.hasClass('menu-one')&&$this.next().length==0){
			//如果1级后面是1级
			$this.parent().next('li').find('a').eq(0).addClass('active');
		}else if($this.hasClass('menu-one')&&$this.next('a').hasClass('menu-two')){
			//如果1级后面是2级
			$this.addClass('active').next('a').addClass('active');
		}else if($this.hasClass('menu-two')&&$this.next().length==0){
			//如果2级后面是1级
			$this.parent().next('li').find('a').eq(0).addClass('active');
		}else if($this.hasClass('menu-two')&&$this.next('a').hasClass('menu-two')){
			//如果2级后面是2级
			$this.next('a').addClass('active');
			$this.prevAll('.menu-one').eq(0).addClass('active');

		}else if($this.hasClass('menu-two')&&$this.next('a').hasClass('menu-three')){
			//如果2级后面是3级
			$this.addClass('active').next('a').addClass('active');
			$this.prevAll('.menu-one').eq(0).addClass('active');
		}else if($this.hasClass('menu-three')&&$this.next().length==0){
			//如果3级后面是1级
			$this.parent().next('li').find('a').eq(0).addClass('active');
		}else if($this.hasClass('menu-three')&&$this.next('a').hasClass('menu-two')){
			//如果3级后面是2级
			$this.next('a').addClass('active');
			$this.prevAll('.menu-one').eq(0).addClass('active');
		}else if($this.hasClass('menu-three')&&$this.next('a').hasClass('menu-three')){
			//如果3级后面是3级
			$this.next('a').addClass('active');
			$this.prevAll('.menu-one').eq(0).addClass('active');
			$this.prevAll('.menu-two').eq(0).addClass('active');
		}
	}
    //点击对应的标志跳对应的页面
    $(".menu-one").click(function(){
    	$(this).addClass("active")
    	       .siblings('a')
    	       .removeClass('active')
    	       .parent()
    	       .siblings()
    	       .children()
    	       .removeClass("active");
    })
    $("#navBox-menu>li a:not('.menu-one')").click(function(){
    	$(this).addClass("active")
               .parents()
               .siblings()
               .children()
               .removeClass("active");
    	$(this).parent()
    	       .children(".menu-one")
    	       .addClass("active")
    	       .parent()
    	       .siblings()
    	       .children(".menu-one")
    	       .removeClass("active");
    })
    $(".menu-two").click(function(){
    	$(this).siblings(".menu-two").removeClass("active");
    	$(this).siblings(".menu-three").removeClass("active");
    })
    $(".menu-three").click(function(){
    	$(this).siblings(".menu-three").removeClass("active");
    	$(this).siblings(".menu-two").removeClass("active");
    	$(this).prev(".menu-two").addClass("active");
    	$(this).parent().children(".menu-one").addClass("active");
    })

    //点击下一步导航条与滚动条联动
    function moveleft($this){
    	 if(!$this||!$this.offset()||!$this.offset().left){
        	return;
        }
        var lastLeft=$("#navBox-menu>li:last").offset().left;

    	if(lastLeft&&$this.offset().left>907 && lastLeft>1800){
    		var movLeft=$this.offset().left-900;
            var scrolLeft=-($("#navBox-menu").offset().left-movLeft);
    	    $(".navBox").scrollLeft(scrolLeft);	
    	}
    }
 //点击单个步骤实现滚动居中
    $("#navBox-menu>li a").click(function(){
    	var clicka_left=$(this).offset().left;
    	if(clicka_left>907){
    		var flow_left=$(this).offset().left-900;
    		var flowscroll_left=-($("#navBox-menu").offset().left-flow_left);
    		$(".navBox").scrollLeft(flowscroll_left);
    	}
    	if(clicka_left<600){
    		var flow_left=900-$(this).offset().left;
    		var flowscroll_left=$("#navBox-menu").offset().left-flow_left;
    		$(".navBox").scrollLeft(flowscroll_left);
    	}
    })
	//下一步联动导航栏滚动居中
//	function ulLeft ($this){
//		if($this.offset().left>=600){
//			var liLeft =-( $this.offset().left-600)
//	}


})

