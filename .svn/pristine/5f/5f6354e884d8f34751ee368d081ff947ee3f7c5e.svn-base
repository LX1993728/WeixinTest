$(function(){
	
	$(".team-itemlast").click(function(){
		// 获取已经加入的参演集合的长度
		var len = $('.team-item:not(.team-itemlast)').size();
		$(this).before("<div class='team-item'><input type='text' name='orgList["+len+"]' placeholder='请输入单位名称'><label class='team-delete'>x</label></div>");
	})
	//演练目标添加
	$(".sence-aimbtn").click(function(){
		// 获取目标元素集合的数组 长度
		var len = $('.sence-aimname').size();
		// alert("======目标集合长度==="+len);
		$(".sence-aimbox").append("<p class='sence-aimitem sence-aimitemright'><label class='sence-aimname'>目标"+(len+1)+"：</label><input type='text' name='targets["+len+"]' placeholder='请输入此次演练目标'></p>")
	})
	//媒体信息图片上传----------场景概述
	//点击加号添加
	function add(){
		// 获取上传组件的个数
		var flen = $("input[type=hidden]").size();
		
		var str='<div class="sence-upload">'+
			    	'<div class="sence-mediaimg">'+
					    '<div id="preview_'+flen+'">'+
					    	'<img id="imghead_'+flen+'" border="0" src="../task/img/addImage.png" width="250" height="140" onClick="$(\'#previewImg_'+flen+'\').click()"/>'+
						'</div>'+
			    		'<input type="file" onChange="previewImage(this,'+flen+',0)" style="display: none;" id="previewImg_'+flen+'">'+
			   		'</div>'+
			   		'<input type="hidden" id="url_'+flen+'" name="imgts['+flen+'].url"/>'+
				    '<textarea placeholder="文字说明" name="imgts['+flen+'].desc">'+
				    '</textarea>'+
				    '<div class="sence-mediabtn">'+
	    	    		'<span class="sencebtn-del"><img src="../task/img1/sence1.png"></span>'+
	    	    		
	    	        '</div>'+
				    
			    '</div>';
	    //$(".sence-mediaitem").append(str);
      $(".sence-mediaitem").prepend(str);
	    callback();
	}
	$(".sencebtn-add").on("click",function(){
		add();
	})
	//点击减号删除
	function del(){
		$(this).parents(".sence-upload").remove();
		callback();
	}
	function callback(){
		$(".sencebtn-del").on("click",function(){
  			$(this).parents(".sence-upload").remove();
		})
	}
  callback();
    //动态改变+高度
//  var addImg=$(".sence-upload");
//  $(".sencebtn-add").


//自定义添加option
  customAddOtion()
  function customAddOtion(){
    $(".customBox").on("change",function(){
      if($("option:selected",this).val() == '自定义'){
        $(".pop-box3").show()
        customAddPopsure3();
      }
    })
  }
  function customAddPopsure3 (){
    var flag = true;
    $("#pop-sure3").one('click',function(){
      if($("#popo3").val()==0){
        alert('请输入自定义能力名称')
      }else{
        var customOptionName = $("#popo3").val()
        var customBoxOptions = $(".customBox option");
        $.each(customBoxOptions,function(i,v){
          if($(v).val()==customOptionName){
            alert('该能力名称已经存在');
            $("#popo3").val('');
            $(".pop-box3").hide();
            $(".customBox option").attr("selected", false);
            $(".customBox option[value='原因清查']").attr("selected", true);
            $("#pop-sure3").unbind();
            flag = false;
          }
        })
        if(flag){
          var customOption = '<option value ="'+customOptionName+'">'+customOptionName+'</option>'
          $(".custom").before(customOption);
          $(".pop-box3").hide();
          $(".customBox option[value='"+customOptionName+"']").attr("selected", true);
          $("#popo3").val('')
        }
      }
    })
  }

  delPopBtn();
  function delPopBtn () {
   $("#pop-del3").click(function(){
      $(".pop-box3").hide();
      $(".customBox option").attr("selected", false);
      $(".customBox option[value='原因清查']").attr("selected", true);
      $("#pop-sure3").unbind();
    })
  }





//任智俊
    var activeInput = "";//保存被选中的流程等级
    //判断是否有一级流程
    $(".sence-navaddchildbtn").click(function(){
      if($(".sence-navlist").children().length==2){     
        alert("请添加流程");
      }
   })
    if($(".sence-navlist").children().length==2){//如果页面无流程
      //给添加流程按钮绑定一次性点击事件，让用户第一次打开页面时可以添加一个流程
      $('.sence-navaddbtn').one('click',function(){
        $(".pop-up1").show()
      })
    }
    //用户输入流程名字后，点击确认按钮
    //获取输入内容，且创建input按钮流程，value值为输入内容
    $("#pop-sure1").click(function(){
      if($(".sence-navlist").children().length==2){//页面无流程，需要添加第一个
          var useName = $("#popo1").val()
           var useId = Date.parse(new Date());
          var inputs = "<input class='sence-navitem senceAdd senceone' onclick='resolveScene(this)' type ='button'  useId='"+useId+"' value ='"+useName+"'>"
          //$(".navitemfirst").after(inputs);
          $(".navitemfirst").after(inputs);
          $(".pop-up1").hide();
          $("#popo1").val('')
          activeInput = $(".active")
           //给添加的流程按钮绑定选中事件
          $(".sence-navlist").children('input').click(function(){
            $(this).siblings().removeClass('active');
            $(this).addClass('active');
            $('.sence-navaddbtn').one('click',function(){
              $(".pop-up1").show()
              activeInput = $(".active")
            })
          });
      }
      if(($(".sence-navlist").children().length>2) && ($(".sence-navlist").children().hasClass('active'))){
        $(".sence-navlist").children('input').removeClass('active')
          var useName = $("#popo1").val()
          var useId = Date.parse(new Date());
          if(activeInput.hasClass('senceone')){//判断用户选择的流程等级，且添加相同等级的流程
            var inputs = "<input class='sence-navitem senceAdd senceone' type ='button' onclick='resolveScene(this)' useId='"+useId+"' value ='"+useName+"'>"
            //如果流程后面有子流程,则追加到子流程后面
            if(activeInput.next().hasClass('sencetwo')){
              if(activeInput.nextAll('.senceone').length==0){//如果子流程后面没有高于该等级的流程，则说明最后是“总结评估”
                $(".navitemlast").before(inputs); //追加到总结评估前面
              }else{
                $(activeInput.nextAll('.senceone')[0]).before(inputs);
              }
              
            }else{
              activeInput.after(inputs);
            }
            
          }
          if(activeInput.hasClass('sencetwo')){//判断用户选择的流程等级，且添加相同等级的流程
            var inputs = "<input class='sence-navitem senceAdd sencetwo' type ='button' onclick='resolveScene(this)' useId='"+useId+"' value ='"+useName+"'>"
            if(activeInput.next().hasClass('sencethree')){//该二级流程后面有三级流程
              if(activeInput.nextAll('.senceone').length==0){//如果子流程后面没有高于该等级的流程，则说明最后是“总结评估”
                $(".navitemlast").before(inputs); //追加到总结评估前面
              }else{
                $(activeInput.nextAll('.senceone')[0]).before(inputs);
                console.log('追加了')
              }
              
            }else if(activeInput.next().hasClass('sencetwo')){//该流程后面是同等级流程
              activeInput.after(inputs);
              console.log('追加错了')
            }
            
          }
          if(activeInput.hasClass('sencethree')){//判断用户选择的流程等级，且添加相同等级的流程
            var inputs = "<input class='sence-navitem senceAdd sencethree' type ='button' onclick='resolveScene(this)' useId='"+useId+"' value ='"+useName+"'>"
            activeInput.after(inputs);
          }
          $(".pop-up1").hide();
          $("#popo1").val('')    
          //给流程按钮绑定选中事件
          $(".sence-navlist").children('input').click(function(){
            $(this).siblings().removeClass('active');
            $(this).addClass('active');
            clickAddBtn();
          });
        }
      });
    function clickAddBtn(){
      if($(".sence-navlist").children().hasClass('active')){//页面已经有流程了，且被选中
      //给流程添加按钮绑定事件
          $('.sence-navaddbtn').one('click',function(){
            $(".pop-up1").show()
            activeInput = $(".active")
            
          })
      }; 
    }
    //点击取消按钮隐藏输入框
    $("#pop-del1").click(function(){
      $(".pop-up1").hide()
      //重新绑定添加流程事件
      if($(".sence-navlist").children().length==2){//如果页面无流程
      //给添加流程按钮绑定一次性点击事件，让用户第一次打开页面时可以添加一个流程
      $('.sence-navaddbtn').one('click',function(){
        $(".pop-up1").show()
      })
    }
    clickAddBtn();
   })
    //点击取消按钮隐藏输入框
    $("#pop-del2").click(function(){
      $(".pop-up2").hide()
      $("#pop-sure2").unbind()//防止添加事件重复绑定
   })
    //当页面存在至少一个流程时，点击添加子流程按钮，弹出输入框
    $(".sence-navaddchildbtn").click(function(){
      if($(".sence-navlist").children().length>2 &&($(".sence-navlist").children().hasClass('active'))){     
       $(".pop-up2").show()
       activeInput = $(".active")
       $(".active").removeClass("active");
       $("#pop-sure2").one("click",function(){
            var useName = $("#popo2").val()
              var useId = Date.parse(new Date());
            if (activeInput.hasClass('senceone')) {//判断用户选择的流程等级，如果为一级则添加二级
              var inputs = "<input class='sence-navitem senceAdd sencetwo' onclick='resolveScene(this)' type ='button' useId='"+useId+"' value ='"+useName+"'>"
              activeInput.after(inputs);
            };
            if (activeInput.hasClass('sencetwo')) {//判断用户选择的流程等级，如果为二级则添加三级
              var inputs = "<input class='sence-navitem senceAdd sencethree' onclick='resolveScene(this)' type ='button' useId='"+useId+"' value ='"+useName+"'>"
              activeInput.after(inputs);
            };
            if (activeInput.hasClass('sencethree')) {//判断用户选择的流程等级，如果为三级则不让用户继续添加
              alert("对不起，三级流程不支持添加子流程")
            };
            $(".pop-up2").hide();
            $("#popo2").val('')    
            //给流程按钮绑定选中事件
            $(".sence-navlist").children('input').click(function(){
              $(this).siblings().removeClass('active');
              $(this).addClass('active');
            });
          })
       }
    })
////点击确定按钮跳转center页面
//    $("#pop-sure1").one("click",function(){
//    	$(".yanshi span").trigger("click")
//    })
////动态添加的input添加跳转
//$(document).on("click",".senceAdd",function(){
//	$(".yanshi span").trigger("click");
//})
//点击场景概述

$(".navitemlast").click(function(){
  $(this).parents(".sence-box").siblings(".iframeBox").css("border","0px");
})
$(".senceAdd").click(function(){
  $(this).parents(".sence-box").siblings(".iframeBox").css("border","0px");
})
$(".navitemfirst").click(function(){
  $(this).parents(".sence-box").siblings(".iframeBox").css("border","1px solid #146162");
})









//删除流程按钮功能实现
    $(document).on('click','#delInputBtn',function(){
      //首先判断用户是否已经选择要删除的流程，如果没有，弹窗提示
      if($(".sence-navlist").children().hasClass('active')){//页面已经有流程了，且被选中
        console.log('页面已经有流程了，且被选中')
        //判断用户选择的是几级流程，并且判断该流程下是否有子流程
        var $inputs = $(".sence-navlist").children('input');
        $inputs.each(function(i, e) {
          if($(e).hasClass('active')){//被选中的流程
            //判断该流程等级，并且判断是否有子流程
            if($(e).hasClass('senceone')){//被选中的是一级流程
              if ($(e).next('input').hasClass('sencetwo')) {//判断是否有子流程
                //有子流程
                alert('请先删除该流程下的子流程')
              }else{
                $(e).remove();
              }
            }
            if($(e).hasClass('sencetwo')){//被选中的是二级流程
              if ($(e).next('input').hasClass('sencethree')) {//判断是否有子流程
                //有子流程
                alert('请先删除该流程下的子流程')
              }else{
                $(e).remove();
              }
            }
            if($(e).hasClass('sencethree')){//被选中的是三级流程
              $(e).remove();
            }
          }
        });
      }else{
        alert("请先选择您要删除的流程")
      }
    })









//center页
    $(".center-addbtn").click(function(){
    	// 获取 具有center-taskbox 类属性的元素的集合的长度
    	var flen = $('.center-taskbox').size();
    	str1='<div class="center-taskbox">'+
	    	'<p class="center-left"><label class="center-taskname">任务'+(flen+1)+':</label><input type="text" name="tasks['+flen+'].name" placeholder="各级应急响应启动"></p>'+
	        '<p class="center-right"><label class="center-taskname">责任组别:</label><input type="text" name="tasks['+flen+'].groups" ></p>'+
	    	'<div class="center-taskbtn">'+
	    		'<span class="center-delbtn">删除</span>'+	
	    		'</div>'+
	    	'</div>'
    	$(".center-sencetask").append(str1);
    	senceCallBack();
    })
    function senceDel(){
    	$(this).parents(".center-taskbox").remove();
    	senceCallBack();
    }
    function senceCallBack(){
    	$(".center-delbtn").click(function(){
 	        $(this).parents(".center-taskbox").remove();
        })
    }
//图片+说明pppp=---------------图片上传
    function centerAdd(){
    		// 获取组件的个数
    		var flen = $('.censence-upload').size();
		var str='<div class="censence-upload">'+
		'<div class="censence-mediaimg">'+
		'<div id="preview_'+flen+'">'+
		'<img id="imghead_'+flen+'" border="0" src="../task/img/addImage.png" width="250" height="140" onClick="$(\'#previewImg_'+flen+'\').click();">'+
		'</div>'+
		'<input type="file" onChange="previewImage(this,'+flen+',0)" style="display: none;" id="previewImg_'+flen+'">'+
		'</div>'+
		'<input type="hidden" id="url_'+flen+'" name="imgts['+flen+'].url" />'+
		'<textarea placeholder="文字说明" name="imgts['+flen+'].desc"></textarea>'+
		'<div class="censence-mediabtn">'+
		'<span class="censencebtn-del"><img src="../task/img1/sence1.png"></span>'+
		'</div>'+
		'</div>'	;
      $(".center-media").prepend(str);
	    centerCallBack();
	}
	$(".censencebtn-add").on("click",function(){
		centerAdd();
	})
	//点击减号删除
	function centerDel(){
		$(this).parents(".censence-upload").remove();
		centerCallBack()
	}
	function centerCallBack(){
		$(".censencebtn-del").on("click",function(){
  			$(this).parents(".censence-upload").remove();
		})
	}
  centerCallBack()
//总结评估页面
   //点击新创建
   $(".assess-newbuild").click(function(){
	   // 获取所有的组项目 的长度
	    var flen = $('.assess-ablity').size();
    		var newbuild=""+
    			'<div class="assess-ablity">'+
			'<div class="assess-ablityleft">'+
			'<p class="assess-name">能力名称</p>'+
			'<select class="assess-ablitychose customBox" name="abilities['+flen+'].name">'+
			'<option value ="原因清查">原因清查</option>'+
			'<option value ="伤亡情况">伤亡情况</option>'+
			'<option value="应急响应">应急响应</option>'+
			'<option value="预警发布">预警发布</option>'+
			'<option value ="舆情控制">舆情控制</option>'+
			'<option value ="自定义" class="custom">自定义</option>'+
			'</select>'+
			'</div>'+
			'<div class="assess-ablityright">'+
			'<p class="assess-name">图片素材</p>'+
			'<p class="assess-img">'+
			'<div id="preview_'+flen+'">'+
			'<img id="imghead_'+flen+'" border="0" src="../task/img1/sence2.png" class="result" onClick="$(\'#previewImg_'+flen+'\').click()"/>'+
			'</div>'+
			'<input type="file" onChange="previewImage(this,'+flen+')" style="display: none;" id="previewImg_'+flen+'">'+
			'<input type="hidden" id="url_'+flen+'" name="abilities['+flen+'].url" />'+
			'<input type="text" placeholder="文字说明" name="abilities['+flen+'].desc" class="assess-imginfo"/>'+
			'</p>'+
			'</div>'+
			'</div>'+
			'<div class="assess-summery">'+
			'<label class="assess-summerytitle">总结评估</label>'+
			'<textarea placeholder="请输入该阶段的场景说明" id="assess_'+flen+'" name="abilities['+flen+'].assess"></textarea>'+
			'<span class="assess-summerysave">保存为模版</span>'+
			'</div>'+
			' </div>';
    		
	    	$(".assessBox").append(newbuild);
	    	customAddOtion();
	    	
   		})
        $(document).on('click',".assess-summerysave",function(){
        		var value = $(this).parent().prev(".assess-ablity").children(".assess-ablityleft").children("select").val();
        		console.info($(this).parent().siblings().find("select").val())
        		var assessstr='<span>'+value+'<span/>';
        		$(".assess-templatecon").append(assessstr);
      
		})


    
})

$(document).on("click",".team-delete",function(){
	$(this).parent(".team-item").remove();
})