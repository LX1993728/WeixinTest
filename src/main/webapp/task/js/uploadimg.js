 function previewImage(file,indexId,flag){
      var MAXWIDTH  = 72; 
      var MAXHEIGHT = 72;
      var div = document.getElementById('preview_'+indexId);
      if (file.files && file.files[0]){
          div.innerHTML ='<img id="imghead_'+indexId+'" onclick=$("#previewImg_'+indexId+'").click()>';
          var img = document.getElementById('imghead_'+indexId);
          img.onload = function(){
          var rect = clacImgZoomParam(MAXWIDTH, MAXHEIGHT, img.offsetWidth, img.offsetHeight);
//                img.width  =  rect.width;
//                img.height =  rect.height;
//                 img.style.marginLeft = rect.left+'px';
//                 img.style.marginTop = rect.top+'px';
			img.style.position='absolute';
			
        	if(flag == 0){
        		img.width  =  250;
                img.height =  140;
        	}else{
        		img.style.top="46px";
        		img.width  =  72;
                img.height =  72;
        	}    
          }
          var reader = new FileReader();
          reader.onload = function(evt){img.src = evt.target.result;}
          reader.readAsDataURL(file.files[0]);
      }
      else //兼容IE
      {
        var sFilter='filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale,src="';
        file.select();
        var src = document.selection.createRange().text;
        div.innerHTML = '<img id="imghead_'+indexId+'">';
        var img = document.getElementById('imghead_'+indexId);
        img.filters.item('DXImageTransform.Microsoft.AlphaImageLoader').src = src;
        var rect = clacImgZoomParam(MAXWIDTH, MAXHEIGHT, img.offsetWidth, img.offsetHeight);
        status =('rect:'+rect.top+','+rect.left+','+rect.width+','+rect.height);
        div.innerHTML = "<div id=divhead style='width:"+rect.width+"px;height:"+rect.height+"px;margin-top:"+rect.top+"px;"+sFilter+src+"\"'></div>";
      }
      
      // 调用AJAX进行图片上传
      postImage(file,indexId);
}
        function clacImgZoomParam( maxWidth, maxHeight, width, height ){
            var param = {top:0, left:0, width:width, height:height};
            if( width>maxWidth || height>maxHeight ){
                rateWidth = width / maxWidth;
                rateHeight = height / maxHeight;
                
                if( rateWidth > rateHeight ){
                    param.width =  maxWidth;
                    param.height = Math.round(height / rateWidth);
                }else{
                    param.width = Math.round(width / rateHeight);
                    param.height = maxHeight;
                }
            }
            param.left = Math.round((maxWidth - param.width) / 2);
            param.top = Math.round((maxHeight - param.height) / 2);
            return param;
        }
        
        //================== 定义 post图片的 函数
        function postImage(file,indexId){
        	var formData = new FormData();
        	formData.append('f', file.files[0]);
        	$.ajax({
        	    url: '/image/singleUpload',
        	    type: 'POST',
        	    cache: false,
        	    data: formData,
        	    processData: false,
        	    contentType: false
        	}).done(function(res) {
        		//1.获取到上传图片的URL res
        		$("#url_"+indexId).val(res);
        		// alert($("#url_"+indexId).val()+"========"+indexId);
        	}).fail(function(res) {
        		alert('图片上传失败,请重新上传');
        	});
        };