
    var result = document.getElementById("result");
    var input = document.getElementById("file_input");
    var button=document.getElementById("button")
    if(typeof FileReader === 'undefined'){
        result.innerHTML = "抱歉，你的浏览器不支持 FileReader";
        input.setAttribute('disabled','disabled');
    }else{
        input.addEventListener('change',readFile,false);
    }
                           
    function readFile(){
        var file = this.files[0];
        if(!/image\/\w+/.test(file.type)){
            alert("请确保文件为图像类型");
            return false;
        }
        var reader = new FileReader();
        reader.readAsDataURL(file);
        
        reader.onload = function(e){
            result.innerHTML = '<img src="'+this.result+'" alt=""/>'
        }
    }
    //帮助div点击去出发input的上传事件
    result.onclick=function(){
    	$("#file_input").trigger("click");
    }
    //帮助input button实现点击图片上传
    button.onclick=function(){
        $("#file_input").trigger("click");
    }
    

